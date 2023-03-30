package jproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class MainPageController implements Initializable {

    @FXML
    private BorderPane mainPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        mainPage.setPrefWidth(JProject.stage.getWidth());
//        mainPage.setPrefHeight(JProject.stage.getHeight());
    }    

    @FXML
    private void loginAction(MouseEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        JProject.changeScene(homePage);
    }
    
}
