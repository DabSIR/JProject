/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package jproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class LoginPageController implements Initializable {

    @FXML
    private AnchorPane mainPage;
    @FXML
    private Rectangle loginBtn;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginHandle(MouseEvent event) {
        
    }
    
}
