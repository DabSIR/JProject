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
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //Setup the stage
        this.stage = stage;   
        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        stage.setX(0);
        stage.setY(0);
        stage.setMaximized(true);
        
        //Load the main page
        Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        changeScene(mainPage);  
       
    }
    
    /**
     * Changes the scene for the stage
     * 
     * @param root 
     */
    public static void changeScene(Parent root) {  
        stage.setScene(new Scene(root));
        stage.show();
    
    }
    



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
} 
    
