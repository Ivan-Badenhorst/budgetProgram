package com.personal.budget.gui;

import com.personal.budget.DB.TransactionsDAO;
import com.personal.budget.logic.Transaction;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;


import java.util.List;

public class TransactionsController {

    @FXML
    private TableView<Transaction> transactionTable;
    @FXML
    private TableColumn<Transaction, Integer> idColumn;
    @FXML
    private TableColumn<Transaction, LocalDate> dateColumn;
    @FXML
    private TableColumn<Transaction, Double> amountColumn;
    @FXML
    private TableColumn<Transaction, String> accountNumberColumn;
    @FXML
    private TableColumn<Transaction, String> typeColumn;
    @FXML
    private TableColumn<Transaction, String> descriptionColumn;
    @FXML
    private TableColumn<Transaction, String> statusColumn;
    @FXML
    private TableColumn<Transaction, String> categoryColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().idTransaction()).asObject());

        dateColumn.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().date()));

        amountColumn.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().amount()).asObject());

        accountNumberColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().accountNumber()));

        typeColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().type()));

        descriptionColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().description()));

        statusColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().status()));

        categoryColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().category()));

        // Load transactions
        loadTransactions();
    }

    private void loadTransactions() {
        // Replace 'P.getTransactions()' with the actual method to fetch transactions

        //FOR NOW I MAKE IT HERE, BUT I SHOULD HAVE A BETTER WAY OF MANAGING THE DAO!!
        TransactionsDAO tc = new TransactionsDAO();
        List<Transaction> transactions = tc.getAllTransactions();

        // Add the transactions to the table
        ObservableList<Transaction> observableList = FXCollections.observableArrayList(transactions);
        transactionTable.setItems(observableList);
    }


}
