package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jproject.ErrorHandling;

public class Room {

    private String name;
    private ArrayList<Appliance> appliances;
    private String location;
    private double totalPowerUsage;
    private double currentPowerUsage;
    private double totalWaterUsage;
    private double currentWaterUsage;

    public ArrayList<Appliance> getAppliances() {
        return appliances;
    }

    /**
     * Constructor
     * @param name 
     */
    public Room(String name) {
        this.name = name;
        this.appliances = new ArrayList<Appliance>();
    }
    
    public Room(String name, ArrayList<Appliance> appliances) {
        this.name = name;
        this.appliances = appliances;
    }
    
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    /**
     * 
     * @param appliance
     */
    public void addApplianceToFile(Appliance appliance) throws IOException {
        File file = new File("src/Room_List/" + getName() + ".txt");
        
        //Check if file exists
        if (file.exists()) {
            
            //Add an appliance to the rooms appliances list
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(new FileWriter(file, true));
                writer.append(appliance.getName() + "," 
                    + appliance.getClass().getSimpleName() + "\n");
                writer.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        else {
            ErrorHandling.showErrorAlert("Porblem adding the appliance please retry");
        }
        
    }

    /**
     * 
     * @param appliance
     */
    public void removeAppliance(Appliance appliance) {

    }

    public String getName() {
            return this.name;
    }

    public String getLocation() {
            return this.location;
    }

    /**
     * 
     * @param location
     */
    public void setLocation(String location) {
            this.location = location;
    }

    public double getTotalPowerUsage() {
            return this.totalPowerUsage;
    }

    /**
     * 
     * @param totalPowerUsage
     */
    public void setTotalPowerUsage(double totalPowerUsage) {
            this.totalPowerUsage = totalPowerUsage;
    }

    public double getCurrentPowerUsage() {
            return this.currentPowerUsage;
    }

    /**
     * 
     * @param currentPowerUsage
     */
    public void setCurrentPowerUsage(double currentPowerUsage) {
            this.currentPowerUsage = currentPowerUsage;
    }

    public double getTotalWaterUsage() {
            return this.totalWaterUsage;
    }

    /**
     * 
     * @param totalWaterUsage
     */
    public void setTotalWaterUsage(double totalWaterUsage) {
            this.totalWaterUsage = totalWaterUsage;
    }

    public double getCurrentWaterUsage() {
            return this.currentWaterUsage;
    }

    /**
     * 
     * @param currentWaterUsage
     */
    public void setCurrentWaterUsage(double currentWaterUsage) {
            this.currentWaterUsage = currentWaterUsage;
    }

}