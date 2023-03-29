package jproject;

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
    protected static Stage stage;
    protected static Scene scene;
    
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
} 
    
