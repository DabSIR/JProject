package jproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class MainPageController implements Initializable {

    @FXML
    private BorderPane mainPage;
    @FXML
    private Circle loadIndicator;
    private Timeline timeline;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RotateTransition rotate = new RotateTransition(Duration.seconds(2), loadIndicator);
        rotate.setByAngle(360);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setCycleCount(Timeline.INDEFINITE);
        // Start the animation
        timeline = new Timeline(new KeyFrame(Duration.seconds(4), event -> {
            // Load the new scene after the animation is complete
            try {
                loginAction();
            } catch (IOException ex) {
                Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
        rotate.play();
    }    
    
    private void loginAction() throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        JProject.changeScene(homePage);
    }
    
}
