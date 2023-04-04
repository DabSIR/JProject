/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package jproject;

import Classes.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
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

    /**
     * Handler to add a room
     * @param event 
     */
    @FXML
    private void addRoom(MouseEvent event) {
        
        //Setup window
        Label label = new Label("Add Room");
        label.setTextFill(Color.web("#E6E6E9"));
        label.setFont(new Font("Arial", 25));
        
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
        roomNameField.setStyle("-fx-background-color: #1C2541;"
            + "-fx-background-radius: 0; -fx-background-insets: 0;" 
            + "-fx-text-fill: #E6E6E9; -fx-font-size: 18px;" 
            + "-fx-border-color: #E6E6E9; -fx-border-width: 0 0 2 0;");
        
        //Set a restriction to the textfield so user can only enter 25 chars
        UnaryOperator<TextFormatter.Change> lengthFilter = change -> {
            if (change.getControlNewText().length() <= 25) {
                return change;
            }
            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(lengthFilter);
        roomNameField.setTextFormatter(textFormatter);
        
        HBox roomNamesField = new HBox();
        roomNamesField.setAlignment(Pos.CENTER);
        roomNamesField.getChildren().addAll(room, roomNameField);
        
        //Add Button
        Button addButton = new Button("Add");
        addButton.setStyle("-fx-background-color: #1C2541; "
                + "-fx-text-fill: #E6E6E9; -fx-border-color: #E6E6E9; "
                + "-fx-border-width: 2px; -fx-font-size: 16px; "
                + "-fx-font-family: Arial;");
        container.getChildren().addAll(roomNamesField, addButton); 
        
        // Create a new popup window and set its content
        Stage addRoomPopUp = new Stage();
        addRoomPopUp.initOwner(JProject.getStage());
        addRoomPopUp.initModality(Modality.APPLICATION_MODAL);
        addRoomPopUp.setTitle("Add Room");
        addRoomPopUp.setX(JProject.getStage().getX() 
                + (JProject.getStage().getWidth() - 300) / 2);
        addRoomPopUp.setY(JProject.getStage().getY() 
                + (JProject.getStage().getHeight() - 500) / 2);
        addRoomPopUp.setScene(new Scene(container));
        
        //Handler to ensure user has entered a name for the room
        addButton.setOnAction(e -> {
            String roomName = roomNameField.getText().trim();
            if (roomName.isEmpty()) {
                errorHandling.showErrorAlert("Please enter a value");
            } else {
                Room newRoom = new Room(roomName);
                JProject.getHome().addRoom(roomName, newRoom);
                addRoomPopUp.close();
            }
        });
        
        // Show the popup window using the showAndWait() method
        addRoomPopUp.showAndWait();  
        
        displayRooms();
    }
    
    /**
     * Iterates over the HashMap for the rooms in the house, and displays
     * a new StackPane for each room
     */
    private void displayRooms() {
        
        //Check if there are any registered rooms
        if (!(JProject.getHome().getRooms().isEmpty())) {   
            roomList.getChildren().clear();
            VBox roomBox;
            
            //Loop through the room list and make a pane for each room
            for (String roomName : JProject.getHome().getRooms().keySet()) {
                roomBox = new VBox();
                roomBox.setStyle("-fx-background-color: #1C2541; "
                    + "-fx-background-radius: 25px; -fx-padding: 16px;");
                roomBox.setAlignment(Pos.TOP_LEFT);
                roomBox.setPrefWidth(325);
                roomBox.setPrefHeight(150);
                roomBox.setEffect(new InnerShadow(10,
                Color.color(0,0,0,0.5)));
                              
                Label roomLabel = null;
                Text roomText = new Text(roomName);
                roomText.setWrappingWidth(275);
                roomText.setFont(Font.font("Arial",30));
                roomText.setFill(Color.web("#E6E6E9"));
                if (JProject.getHome().getRooms().get(roomName)
                    .getAppliances() == null) {
                    roomLabel = new Label("0 Appliances");
                }
                else {
                    roomLabel = new Label( 
                        + JProject.getHome().getRooms()
                            .get(roomName).getAppliances().size()
                        + " Appliances");
                }   
                roomLabel.setFont(new Font("Arial", 18));
                
                //Create the dropdown to edit/delete a room
                Button dropMenu = new Button("\u2630");
                dropMenu.setStyle("-fx-background-color: rgba(0,0,0,0);"
                        + "-fx-text-fill: #E6E6E9; -fx-font-size: 20px;");
                dropMenu.setOnAction(event -> showMenu(dropMenu, roomName));

                //Add the text and label(# appliances) to the room box
                HBox title = new HBox();
                title.getChildren().addAll(roomText, dropMenu);
                roomBox.getChildren().add(title);
                roomBox.getChildren().add(roomLabel);
                
                roomList.getChildren().add(roomBox);
           }
        }
    }
    
    /**
     * Dropdown menu for each room
     * @param dropMenu
     * @param roomName 
     */
    private void showMenu(Button dropMenu, String roomName) {
        
    // Create a dropdown menu
    ContextMenu menu = new ContextMenu();

    //Add appliances menu
    MenuItem addAppliance = new MenuItem("Add Appliance");
    addAppliance.setOnAction(e -> {
        
        //Setup window
        Label label = new Label("Add Appliance");
        label.setTextFill(Color.web("#E6E6E9"));
        label.setFont(new Font("Arial", 25));
        
        VBox container = new VBox(label);
        container.setSpacing(25);
        container.setStyle("-fx-background-color: #0B132B;"
                + "-fx-padding: 25px;");
        container.setAlignment(Pos.TOP_CENTER);
        container.setPrefWidth(300);
        container.setPrefHeight(500);
        
        //Input fields
        HBox applianceInput = new HBox();
        applianceInput.setSpacing(16);
        applianceInput.setAlignment(Pos.CENTER);
        Label applianceLabel = new Label("Name: ");
        applianceLabel.setTextFill(Color.web("#E6E6E9"));
        applianceLabel.setFont(new Font("Arial", 18));
        TextField applianceName = new TextField();
        applianceName.setPrefWidth(175);
        applianceName.setPrefHeight(30);
        
        //Set a restriction to the textfield so user can only enter 25 chars
        UnaryOperator<TextFormatter.Change> lengthFilter = change -> {
        if (change.getControlNewText().length() <= 25) {
            return change;
        }
            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(lengthFilter);
        applianceName.setTextFormatter(textFormatter);
        applianceName.setPromptText("New Appliance");
        
        applianceInput.getChildren().addAll(applianceLabel,
    applianceName);
        
        // Create the ListView
        ListView<String> applianctTypeList = new ListView<>();   
        applianctTypeList.setStyle("-fx-background: #1C2541; "
            + "-fx-text-fill: #E6E6E9; -fx-border-color: #E6E6E9; "
            + "-fx-border-width: 2px; -fx-font-size: 16px; "
            + "-fx-font-family: Arial; -fx-prompt-text-fill: #E6E6E6;");

        //loop through the ApplianceTypes enum to get all values for ChoiceBox
        for (ApplianceTypes type : ApplianceTypes.values()) {
            applianctTypeList.getItems().add(type.toString());
        }

        //Make the add Appliance button
        Button addApplianceBtn = new Button("Add");
        addApplianceBtn.setStyle("-fx-background-color: #1C2541; "
                + "-fx-text-fill: #E6E6E9; -fx-border-color: #E6E6E9; "
                + "-fx-border-width: 2px; -fx-font-size: 18px; "
                + "-fx-font-family: Arial;");
        
        container.getChildren().addAll(
    applianceInput,
    applianctTypeList,
    addApplianceBtn);
       
        // Create a new popup window and set its content
        Stage addAppliancePopUp = new Stage();
        addAppliancePopUp.initOwner(JProject.getStage());
        addAppliancePopUp.initModality(Modality.APPLICATION_MODAL);
        addAppliancePopUp.setTitle("Add Appliance");
        addAppliancePopUp.setX(JProject.getStage().getX() 
                + (JProject.getStage().getWidth() - 300) / 2);
        addAppliancePopUp.setY(JProject.getStage().getY() 
                + (JProject.getStage().getHeight() - 500) / 2);
        addAppliancePopUp.setScene(new Scene(container));
         
         //Handler to ensure user has entered a name and selected a type
        addApplianceBtn.setOnAction(event -> {
            String nameOfAppliance = applianceName.getText().trim();
            if (nameOfAppliance.isEmpty() || nameOfAppliance == null) {
                errorHandling.showErrorAlert("Please enter a value");              
            } 
            else {  //add an appliance to the room based on the selected type 
                String selectedType = applianctTypeList.getSelectionModel().getSelectedItem();
                Appliance appliance;
                switch (selectedType) {
                    case "Light":
                        appliance = new Light(nameOfAppliance);
                        break;
                    case "AC":
                        appliance = new AirConditioner(nameOfAppliance);
                        break;
                    case "Dishwasher":
                        appliance = new DishWasher(nameOfAppliance);
                        break;
                    case "Dryer":
                        appliance = new Dryer(nameOfAppliance);
                        break;
                    case "TV":
                        appliance = new TV(nameOfAppliance);
                        break;
                    case "Fridge":
                        appliance = new Fridge(nameOfAppliance);
                        break;
                    case "Washer":
                        appliance = new Washer(nameOfAppliance);
                        break;
                    default:
                        appliance = new Appliance(nameOfAppliance);
                }
                JProject.getHome().getRoom(roomName).addAppliance(appliance);
                try {
                    JProject.getHome().getRoom(roomName).addApplianceToFile(appliance);
                } catch (IOException ex) {
                    System.out.println("Error: problem adding appliance to file");
                }
                
                System.out.println(JProject.getHome().getRoom(roomName)
                    .getAppliances().size());
                //If user adds an appliance (if appliances list is not empty)
                if (!JProject.getHome().getRoom(roomName).getAppliances().isEmpty()) {
                    displayRooms();
                }
                addAppliancePopUp.close();
                }   
        });

        // Show the popup window using the showAndWait() method
        addAppliancePopUp.showAndWait(); 
    });
    menu.getItems().add(addAppliance);

    //Handler to delete a room
    MenuItem deleteRoom = new MenuItem("Delete Room");
    deleteRoom.setOnAction(event -> {
        SmartHome.removeRoom(roomName);
        displayRooms();
    });
    menu.getItems().add(deleteRoom);

    // Show dropdown menu to the left of the button
    menu.show(dropMenu, Side.LEFT, 0, 0);
    }
    
}
