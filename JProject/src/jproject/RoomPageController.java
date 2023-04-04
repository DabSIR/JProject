package jproject;

import Classes.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
                ErrorHandling.showErrorAlert("Please enter a value");
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
    
    //Handler to view a room
    MenuItem viewRoom = new MenuItem("View Room");
    viewRoom.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event){
            try {
                Room selectedRoom = JProject.getHome().getRoom(roomName);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("roomView.fxml"));
                Parent roomViewPage = loader.load();
                RoomViewController roomController = loader.getController();
                roomController.setRoom(selectedRoom);
                JProject.changeScene(roomViewPage);
            } catch (IOException ex) {
                ErrorHandling.showErrorAlert("Problem loading room please retry.");
            }
        }
    });
    menu.getItems().add(viewRoom);
    
    //Add appliances menu 
    MenuItem addAppliance = new MenuItem("Add Appliance");
    addAppliance.setOnAction(e -> {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addAppliancePopUp.fxml"));
            Parent addAppliancePopUp = loader.load();
            AddAppliancePopUpController controller = loader.getController();
            controller.setRoom(JProject.getHome().getRoom(roomName));
            Scene scene = new Scene(addAppliancePopUp);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait(); 
            displayRooms();
        } catch (IOException ex) {
            ErrorHandling.showErrorAlert("Error, please retry.");
        }
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
