package jproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Dylan, Nav, Altyn
 */
public class JProject extends Application {
    private static Stage stage;
    
    @Override
    public void start(Stage stageParam) throws Exception {
        this.stage = stageParam;
        Parent main = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        changeScene(main);
        
    }
    
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
    
