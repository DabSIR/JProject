/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package jproject;

import Classes.Room;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class RoomPageController implements Initializable {

    @FXML
    private Label homeBtn;
    @FXML
    private Label roomBtn;
    @FXML
    private Label energyBtn;
    @FXML
    private VBox mainFrame;
    @FXML
    private AnchorPane roomPage;
    @FXML
    private Label addRoomBtn;
    @FXML
    private FlowPane roomList;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnchorPane.setTopAnchor(mainFrame, 0.0);
        AnchorPane.setBottomAnchor(mainFrame, 0.0);
        AnchorPane.setLeftAnchor(mainFrame, 0.0);
        AnchorPane.setRightAnchor(mainFrame, 0.0);  
        displayRooms();
    }    

    @FXML
    private void goToEnergy(MouseEvent event) throws IOException {
        Parent energyPage = FXMLLoader.load(getClass().getResource("energyPage.fxml"));
        JProject.changeScene(energyPage);
    }


    @FXML
    private void goToHome(MouseEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        JProject.changeScene(homePage);
    }

    /**
     * Handler to add a room
     * @param event 
     */
    @FXML
    private void addRoom(MouseEvent event) {
        
        //Setup window
        Label label = new Label("Add Room");
        label.setTextFill(Color.web("#E6E6E9"));
        label.setFont(new Font("Arial", 20));
        
        VBox container = new VBox(label);
        container.setSpacing(25);
        container.setStyle("-fx-background-color: #0B132B;");
        container.setAlignment(Pos.CENTER);
        container.setPrefWidth(300);
        container.setPrefHeight(500);
        
        //Input fields
        Label room = new Label("Room: ");
        room.setTextFill(Color.web("#E6E6E9"));
        room.setFont(new Font("Arial", 16));
        TextField roomNameField = new TextField();
        roomNameField.setPromptText("Bedroom");
        HBox roomNamesField = new HBox();
        roomNamesField.setAlignment(Pos.CENTER);
        roomNamesField.getChildren().addAll(room, roomNameField);
        
        //Add Button
        Button addButton = new Button("Add");
        addButton.setStyle("-fx-background-color: #1C1C1C; "
                + "-fx-text-fill: #E6E6E9; -fx-border-color: #E6E6E9; "
                + "-fx-border-width: 2px; -fx-font-size: 16px; "
                + "-fx-font-family: Arial;");
        container.getChildren().addAll(roomNamesField, addButton); 
        
        // Create a new popup window and set its content
        Stage popUpStage = new Stage();
        popUpStage.initOwner(JProject.getStage());
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.setX(JProject.getStage().getX() 
                + (JProject.getStage().getWidth() - 300) / 2);
        popUpStage.setY(JProject.getStage().getY() 
                + (JProject.getStage().getHeight() - 500) / 2);
        popUpStage.setScene(new Scene(container));
        
        //Handler to ensure user has entered a name for the room
        addButton.setOnAction(e -> {
            String roomName = roomNameField.getText().trim();
            if (roomName.isEmpty()) {
                errorHandling.showErrorAlert("Please enter a value");
            } else {
                Room newRoom = new Room(roomName);
                JProject.getHome().addRoom(roomName, newRoom);   
                System.out.println(JProject.getHome().getRooms().size());
                
                //Add the room to the Room_List.txt file to be stored
                PrintWriter writer = null;
                try {
                    File file = new File(roomName);
                    writer = new PrintWriter("src/Room_List/" + file + ".txt");
                    writer.println();
                    writer.close();
                    
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        // Show the popup window using the showAndWait() method
        popUpStage.showAndWait();  
        
        displayRooms();
    }
    
    /**
     * Iterates over the HashMap for the rooms in the house, and displays
     * a new StackPane for each room
     */
    private void displayRooms() {
        if (!(JProject.getHome().getRooms().isEmpty())) {   
            roomList.getChildren().clear();
            HBox roomBox;
            for (String roomName : JProject.getHome().getRooms().keySet()) {
                roomBox = new HBox();
                roomBox.setStyle("-fx-background-color: #1C2541; "
                    + "-fx-background-radius: 25px; -fx-padding: 16px;");
                roomBox.setAlignment(Pos.CENTER);
                roomBox.setPrefWidth(325);
                roomBox.setPrefHeight(150);
                
                Label roomLabel = null;
                if (JProject.getHome().getRooms().get(roomName).getAppliances() == null) {
                   roomLabel = new Label(roomName + "\n 0 Appliances");
                }
                else {
                    roomLabel = new Label(roomName + "\n" 
                    + JProject.getHome().getRooms().get(roomName).getAppliances().size()
                    + " Appliances");
                }             
                roomBox.getChildren().add(roomLabel);
                roomList.getChildren().add(roomBox);
           }
        }
    }
    
}
