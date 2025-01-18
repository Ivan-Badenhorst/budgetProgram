package com.personal.budget.gui;

import javafx.fxml.FXML;

public class SecondController {

    @FXML
    protected void onGoBackClick() {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("hello");
    }

}
