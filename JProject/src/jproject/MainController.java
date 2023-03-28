/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package jproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author Dylan
 */
public class MainController implements Initializable {

    @FXML
    private AnchorPane mainPage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void toLogin(MouseEvent event) throws IOException {
        Parent loginPage = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        JProject.changeScene(loginPage);
    }

    
}
