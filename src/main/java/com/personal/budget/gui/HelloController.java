package com.personal.budget.gui;

import com.personal.budget.DB.TransactionsDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onGoNextClick() {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("second");
    }

    @FXML
    protected void onViewTransactionsClick() {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("transactions");
    }
}