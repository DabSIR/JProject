package Classes;

import java.util.ArrayList;

public class Room {

    private String name;
    private ArrayList<Appliance> appliance;
    private String location;
    private double totalPowerUsage;
    private double currentPowerUsage;
    private double totalWaterUsage;
    private double currentWaterUsage;

    /**
     * Constructor
     * @param name 
     */
    public Room(String name) {
        this.name = name;
    }

    /**
     * 
     * @param appliance
     */
    public void addAppliance(Appliance appliance) {

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