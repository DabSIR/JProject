/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package jproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class EnergyPageController implements Initializable {

    @FXML
    private AnchorPane homePage;
    @FXML
    private VBox mainFrame;
    @FXML
    private Label homeBtn;
    @FXML
    private Label roomBtn;
    @FXML
    private Label energyBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void goToHome(MouseEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        JProject.changeScene(homePage);
    }

    @FXML
    private void goToRooms(MouseEvent event) throws IOException {
        Parent roomPage = FXMLLoader.load(getClass().getResource("roomPage.fxml"));
        JProject.changeScene(roomPage);
    }
    
}
