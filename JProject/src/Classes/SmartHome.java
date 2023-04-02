package Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import jproject.JProject;

public class SmartHome {

	private static HashMap<String, Room> rooms = new HashMap<>();
	private ArrayList<Scene> scenes;
	private ArrayList<EnergyReport> energyReports;
	private SecuritySystem securitySystem;
	private Profile profile;
        private static final String PATH_TO_ROOMS_LIST = "src/Room_List";
        
        public SmartHome() {
           // Create a File object for the folder directory
            File folder = new File(PATH_TO_ROOMS_LIST);

            // Get a list of all the files in the directory
            File[] files = folder.listFiles();

            // Loop through each file and read its contents
            for (File file : files) {
                String fileName = file.getName();
                String roomName = fileName.substring(0, fileName.lastIndexOf('.'));
                ArrayList<Appliance> appliances = new ArrayList<Appliance>();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] record = line.split(",");
                        if (record.length >= 2) {
                            String applianceName = record[0].trim();
                            String applianceType = record[1].trim();
                            Appliance appliance = null;
                            switch (applianceType) {
                                case "Light":
                                    appliance = new Light(applianceName);
                                    break;
                                case "AC":
                                    appliance = new AirConditioner(applianceName);
                                    break;
                                case "Dishwasher":
                                    appliance = new DishWasher(applianceName);
                                    break;
                                case "Dryer":
                                    appliance = new Dryer(applianceName);
                                    break;
                                case "TV":
                                    appliance = new TV(applianceName);
                                    break;
                                case "Fridge":
                                    appliance = new Fridge(applianceName);
                                    break;
                                case "Washer":
                                    appliance = new Washer(applianceName);
                                    break;
                                default:
                                    appliance = new Appliance(applianceName);
                            }
                            appliances.add(appliance);
                        } 
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (appliances.isEmpty()) {
                    Room room = new Room(roomName);
                    rooms.put(roomName, room);
                }
                else {
                    Room room = new Room(roomName, appliances);
                    rooms.put(roomName, room);
                }  
            } 
        }
        
        public HashMap<String, Room> getRooms() {
            return rooms;
        }

        public Room getRoom(String roomName) {
            return rooms.get(roomName);
        }

	/**
	 * 
	 * @param room
	 */
	public void addRoom(String roomName, Room room) {
            // TODO - implement SmartHome.addRoom
            rooms.put(roomName, room);

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

	/**
	 * 
	 * @param room
	 */
	public static void removeRoom(String room) {
            rooms.remove(room);
            File file = new File(PATH_TO_ROOMS_LIST + "/" + room + ".txt");
            if (file.delete()) {
                System.out.println("Deleted a file " + file.toString());
            }
            else {
                System.out.println("No file to delete.");
            }
	}

	/**
	 * 
	 * @param scene
	 */
	public void addScene(Scene scene) {
		// TODO - implement SmartHome.addScene
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param scene
	 */
	public void removeScene(Scene scene) {
		// TODO - implement SmartHome.removeScene
		throw new UnsupportedOperationException();
	}

	public ArrayList<EnergyReport> getEnergyReports() {
		return this.energyReports;
	}

	public SecuritySystem getSecuritySystem() {
		return this.securitySystem;
	}


	public Profile getEnergyReport() {
		// TODO - implement SmartHome.getEnergyReport
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param profile
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}