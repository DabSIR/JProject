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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class HomePageController implements Initializable {

    @FXML
    private AnchorPane homePage;
    @FXML
    private Label homeBtn;
    @FXML
    private Label roomBtn;
    @FXML
    private Label energyBtn;
    
    @FXML
    private VBox mainFrame;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnchorPane.setTopAnchor(mainFrame, 0.0);
        AnchorPane.setBottomAnchor(mainFrame, 0.0);
        AnchorPane.setLeftAnchor(mainFrame, 0.0);
        AnchorPane.setRightAnchor(mainFrame, 0.0);   
    }    

    @FXML
    private void goToRooms(MouseEvent event) throws IOException {
        Parent roomPage = FXMLLoader.load(getClass().getResource("roomPage.fxml"));
        JProject.changeScene(roomPage);
    }

    @FXML
    private void goToEnergy(MouseEvent event) throws IOException {
        Parent energyPage = FXMLLoader.load(getClass().getResource("energyPage.fxml"));
        JProject.changeScene(energyPage);
    }


}
