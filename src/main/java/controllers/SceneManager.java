package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * SceneManager is responsible for managing different scenes in a JavaFX application.
 * SceneManager is a singleton.
 * It allows for loading and switching between scenes during the application's runtime.
 * This class implements the Singleton pattern to ensure only one instance of the SceneManager exists.
 */
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

    /**
     * Sets the primary stage where scenes will be displayed.
     *
     * @param primaryStage the primary stage of the application.
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Loads a scene from an FXML file and stores it in the scenes map under a given name.
     *
     * @param name the name of the scene to be stored.
     * @param fxmlPath the path to the FXML file for the scene.
     * @throws IOException if the FXML file cannot be loaded.
     */
    public void loadScene(String name, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scenes.put(name, scene);
    }

    /**
     * Displays the scene corresponding to the provided name on the primary stage.
     * If no scene with this name has been loaded, nothing happens
     *
     * @param name the name of the scene to be displayed.
     */
    public void showScene(String name){

        if(primaryStage != null && scenes.containsKey(name)){
            primaryStage.setScene(scenes.get(name));
            primaryStage.show();
        }

    }


}
