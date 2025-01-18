package com.personal.budget.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriesDAO {

    public boolean insertCategory(String value){
        String query = "INSERT INTO tester (value) VALUES (?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, value);
            int rows = preparedStatement.executeUpdate();
            System.out.println("Inserted " + rows + " row(s).");
            return true;

        } catch (SQLException e) {
            System.err.println("Error inserting value: " + e.getMessage());
        }
        return false;
    }

}
