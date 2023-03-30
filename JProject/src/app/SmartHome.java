package app;

import java.util.ArrayList;

public class SmartHome {

	private ArrayList<Room> rooms;
	private ArrayList<Scene> scenes;
	private ArrayList<EnergyReport> energyReports;
	private SecuritySystem securitySystem;
	private ArrayList<Notification> notifications;
	private Profile profile;

	/**
	 * 
	 * @param room
	 */
	public void addRoom(Room room) {
		// TODO - implement SmartHome.addRoom
		throw new UnsupportedOperationException();
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

	/**
	 * 
	 * @param notification
	 */
	public void addNotification(Notification notification) {
		// TODO - implement SmartHome.addNotification
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param notification
	 */
	public void removeNotification(Notification notification) {
		// TODO - implement SmartHome.removeNotification
		throw new UnsupportedOperationException();
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