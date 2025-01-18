package com.personal.budget.DB;

import com.personal.budget.logic.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionsDAO {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM transactions";

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Transaction transaction = mapResultSetToTransaction(resultSet);
                transactions.add(transaction);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching transactions: " + e.getMessage());
        }

        return transactions;
    }


    private Transaction mapResultSetToTransaction(ResultSet resultSet) throws SQLException{
        int idTransaction =  resultSet.getInt("id_transaction");
        LocalDate date = resultSet.getDate("date").toLocalDate();
        double amount = resultSet.getDouble("amount");
        String accountNumber = resultSet.getString("account_number");
        String type = resultSet.getString("type");
        String description = resultSet.getString("description");
        String status = resultSet.getString("status");

        //FOR NOW THIS IS WRONG - NEED TO CONVERT TO THE NAME OF CATEGORY
        String category = String.valueOf(resultSet.getInt("category"));

        return new Transaction(idTransaction, date, amount, accountNumber, type, description, status, category);

    }

}
