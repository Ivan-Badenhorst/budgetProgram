package com.personal.budget.logic;

import java.time.LocalDate;


/**
 * Record class to encapsulate a transaction from the database
 */
public record Transaction(int idTransaction, LocalDate date, double amount, String accountNumber, String type,
                          String description, String status, String category) {
}
