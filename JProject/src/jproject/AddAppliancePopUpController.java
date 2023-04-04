/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package jproject;

import Classes.Appliance;
import Classes.Camera;
import Classes.DishWasher;
import Classes.Dryer;
import Classes.Fridge;
import Classes.Light;
import Classes.Room;
import Classes.Sensor;
import Classes.TV;
import Classes.Washer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class AddAppliancePopUpController implements Initializable {

    @FXML
    private TextField applianceName;
    @FXML
    private ComboBox<String> applianceTypeList;
    @FXML
    private Button addApplianceBtn;
    private Room room;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //loop through the ApplianceTypes enum to get all values for ChoiceBox
        for (ApplianceTypes type : ApplianceTypes.values()) {
            applianceTypeList.getItems().add(type.toString());
        }         
    }
 
    @FXML
    private void addAppliance(MouseEvent event) {
        String nameOfAppliance = applianceName.getText().trim();
            if (nameOfAppliance.isEmpty() || nameOfAppliance == null
                || applianceTypeList.getSelectionModel().getSelectedItem() == null) {
                ErrorHandling.showErrorAlert("Please enter a name for"
                    + "the appliance");              
            } 
            else {  //add an appliance to the room based on the selected type 
                String selectedType = applianceTypeList.getSelectionModel().getSelectedItem();
                Appliance appliance;
                switch (selectedType) {
                    case "Light":
                        appliance = new Light(nameOfAppliance);
                        break;
                    case "Dishwasher":
                        appliance = new DishWasher(nameOfAppliance);
                        break;
                    case "Dryer":
                        appliance = new Dryer(nameOfAppliance);
                        break;
                    case "Washer":
                        appliance = new Washer(nameOfAppliance);
                        break;
                    case "TV":
                        appliance = new TV(nameOfAppliance);
                        break;
                    case "Fridge":
                        appliance = new Fridge(nameOfAppliance);
                        break;
                    case "Camera":
                        appliance = new Camera(nameOfAppliance);
                        break;
                    case "Sensor":
                        appliance = new Sensor(nameOfAppliance);
                        break;
                    default:
                        appliance = new Appliance(nameOfAppliance);
                }
                room.addAppliance(appliance);
                try {
                    room.addApplianceToFile(appliance);
                } catch (IOException ex) {
                    ErrorHandling.showErrorAlert("Error adding appliance, please retry.");
                }
                //If user adds an appliance (if appliances list is not empty)
                if (!room.getAppliances().isEmpty()) {
                    Stage stage = (Stage) addApplianceBtn.getScene().getWindow();
                    stage.close();
                }
            }
        
        }

    public void setRoom(Room room) {
        this.room = room;
    }
    
    
}

                
