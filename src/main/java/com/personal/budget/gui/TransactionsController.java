package com.personal.budget.gui;

import com.personal.budget.DB.TransactionsDAO;
import com.personal.budget.logic.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.List;

public class TransactionsController {

    @FXML
    private TableView<Transaction> transactionTable;

    @FXML
    public void initialize() {
        // Configure table columns
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("idTransaction"));
//        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
//        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        // Load transactions
        loadTransactions();
    }

    private void loadTransactions() {
        // Replace 'P.getTransactions()' with the actual method to fetch transactions

        //FOR NOW I MAKE IT HERE, BUT I SHOULD HAVE A BETTER WAY OF MANAGING THE DAO!!
        TransactionsDAO tc = new TransactionsDAO();
        List<Transaction> transactions = tc.getAllTransactions();

        // Add the transactions to the table
        transactionTable.getItems().setAll(transactions);
    }


}
