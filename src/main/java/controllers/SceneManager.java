package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private static SceneManager instance;
    private Stage primaryStage;
    private Map<String, Scene> scenes = new HashMap<>();

    private SceneManager() {};

    public SceneManager getInstance(){
        if(instance == null){
            instance = new SceneManager();
        }
        return  instance;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void loadScene(String name, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scenes.put(name, scene);
    }

    public void showScene(String name){

        if(primaryStage != null && scenes.containsKey(name)){
            primaryStage.setScene(scenes.get(name));
            primaryStage.show();
        }

    }


}
