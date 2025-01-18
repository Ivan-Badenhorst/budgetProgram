package com.personal.budget;

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
}