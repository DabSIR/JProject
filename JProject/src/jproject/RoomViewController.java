/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package jproject;

import Classes.AirConditioner;
import Classes.Appliance;
import Classes.DishWasher;
import Classes.Dryer;
import Classes.Fridge;
import Classes.Light;
import Classes.Room;
import Classes.TV;
import Classes.Washer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class RoomViewController implements Initializable {

    @FXML
    private AnchorPane roomPage;
    @FXML
    private VBox mainFrame;
    @FXML
    private Label homeBtn;
    @FXML
    private Label roomBtn;
    @FXML
    private Label energyBtn;
    @FXML
    private Label roomsView;
    @FXML
    private Label addApplianceBtn;
    @FXML
    private FlowPane applianceList;
    
    private Room room;

    
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

    public void setRoom(Room room) {
        this.room = room;
        
        //Check if room has appliances
        if (applianceList != null && this.room != null) {
            VBox appBox;
            applianceList.getChildren().clear();
            for (Appliance appliance : room.getAppliances()) {
                appBox = new VBox();
                appBox.setStyle("-fx-background-color: #1C2541; "
                    + "-fx-background-radius: 25px; -fx-padding: 16px;");
                appBox.setAlignment(Pos.TOP_LEFT); 
                appBox.setPrefWidth(150); 
                appBox.setPrefHeight(150); 
                appBox.setEffect(new InnerShadow(
                    10,Color.color(0,0,0,0.5)));
                
                
                Text appText = new Text(appliance.getName());
                appText.setWrappingWidth(150);
                appText.setFont(Font.font("Arial",30));
                appText.setFill(Color.web("#E6E6E9"));
                Label appLabel = new Label(appliance.getClass()
                    .toString().substring(14));
                appLabel.setFont(Font.font("Arial", 18));
                
                //Create the dropdown to edit/delete a appliance
                Button dropMenu = new Button("\u2630");
                dropMenu.setStyle("-fx-background-color: rgba(0,0,0,0);"
                        + "-fx-text-fill: #E6E6E9; -fx-font-size: 20px;");
                
                //Add the text and label to the appBox
                HBox title = new HBox();
                title.getChildren().addAll(appText, dropMenu);
                appBox.getChildren().add(title);
                appBox.getChildren().add(appLabel);
                
                applianceList.getChildren().add(appBox);
            }
        } 
    }


    /**
     * Handler for Energy Button for user to go to energy view
     * @param event
     * @throws IOException 
     */
    @FXML
    private void goToEnergy(MouseEvent event) throws IOException {
        Parent energyPage = FXMLLoader.load(getClass()
            .getResource("energyPage.fxml"));
        JProject.changeScene(energyPage);
    }

    /**
     * Handler for Home Button for user to go home
     * @param event
     * @throws IOException 
     */
    @FXML
    private void goToHome(MouseEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass()
            .getResource("homePage.fxml"));
        JProject.changeScene(homePage);
    }

    @FXML
    private void goBack(MouseEvent event) throws IOException {
        Parent roomPage = FXMLLoader.load(getClass().getResource("roomPage.fxml"));
        JProject.changeScene(roomPage);
    }

    @FXML
    private void addAppliance(MouseEvent event) {
        try { 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addAppliancePopUp.fxml"));
            Parent addAppliancePopUp = loader.load();
            AddAppliancePopUpController controller = loader.getController();
            controller.setRoom(room);
            Scene scene = new Scene(addAppliancePopUp);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait(); 
            setRoom(room);
        } catch (IOException ex) {
            ErrorHandling.showErrorAlert("Error please retry.");
        }
    }
    
}
