package Classes;

import java.util.ArrayList;
import java.util.HashMap;

public class SmartHome {

	private HashMap<String, Room> rooms = new HashMap<>();
	private ArrayList<Scene> scenes;
	private ArrayList<EnergyReport> energyReports;
	private SecuritySystem securitySystem;
	private Profile profile;
        
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
	}

	/**
	 * 
	 * @param room
	 */
	public void removeRoom(Room room) {
		// TODO - implement SmartHome.removeRoom
		throw new UnsupportedOperationException();
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