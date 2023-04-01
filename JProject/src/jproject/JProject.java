package jproject;

import Classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Dylan, Nav, Altyn
 */
public class JProject extends Application {
    private static SmartHome home = new SmartHome();
    
    private static Stage stage;
    private static Scene scene;

    private static int windowHeight = 812;
    private static int windowWidth = 375;
    
    @Override
    public void start(Stage stage) throws Exception {
     
        //Setup the stage
        this.stage = stage;   
        
        //Load the main page
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        scene = new Scene(mainPage, windowWidth, windowHeight);
        changeScene(mainPage);      
        
        
        
    }
    
    /**
     * Changes the scene for the stage
     * 
     * @param root 
     */
    public static void changeScene(Parent root) { 
        scene.setRoot(root);
        stage.setScene(scene); 
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
     public static SmartHome getHome() {
        return home;
    }

    public static void setHome(SmartHome home) {
        JProject.home = home;
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        JProject.stage = stage;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        JProject.scene = scene;
    }
} 
    
