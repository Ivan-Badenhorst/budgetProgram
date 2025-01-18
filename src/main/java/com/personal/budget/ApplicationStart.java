package com.personal.budget;

import com.personal.budget.gui.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationStart extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.setPrimaryStage(primaryStage);

        //set up the stage:
        primaryStage.setTitle("Budget Application");

        //set up the scene:
        try {
            sceneManager.loadScene("hello", "/com/personal/budget/hello-view.fxml");
            sceneManager.loadScene("second", "/com/personal/budget/second-view.fxml");
            sceneManager.loadScene("transactions", "/com/personal/budget/transactions-view.fxml");
            sceneManager.showScene("hello");
        }
        catch(Exception e){
            System.out.println("Loading scenes failed: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch();
    }
}