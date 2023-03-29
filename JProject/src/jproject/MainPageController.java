package jproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import static jproject.JProject.stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class MainPageController implements Initializable {

    @FXML
    private AnchorPane mainPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        Screen screen = Screen.getPrimary();
        double screenWidth = JProject.stage.getWidth();
        double screenHeight = JProject.stage.getHeight();
        mainPage.setPrefWidth(screenWidth);
        mainPage.setPrefHeight(screenHeight);
    }    
    
}
