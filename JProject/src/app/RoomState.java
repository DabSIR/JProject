package app;

import java.util.HashMap;

public class RoomState {

	private double temperature;
	private boolean lightOn;
	private HashMap<Appliance, ApplianceState> applianceState;

	public double getTemperature() {
		return this.temperature;
	}

	/**
	 * 
	 * @param temp
	 */
	public void setTemperature(double temp) {
		this.temperature = temp;
	}

	public boolean isLightOn() {
		return this.lightOn;
	}

	/**
	 * 
	 * @param on
	 */
	public void setLightOn(boolean on) {
		this.lightOn = on;
	}

	/**
	 * 
	 * @param appliance
	 * @param state
	 */
	public void addApplianceState(Appliance appliance, ApplianceState state) {
		// TODO - implement RoomState.addApplianceState
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param appliance
	 */
	public void removeApplianceState(Appliance appliance) {
		// TODO - implement RoomState.removeApplianceState
		throw new UnsupportedOperationException();
	}

	public HashMap<Appliance, ApplianceState> getApplianceStates() {
		// TODO - implement RoomState.getApplianceStates
		throw new UnsupportedOperationException();
	}

	public void apply() {
		// TODO - implement RoomState.apply
		throw new UnsupportedOperationException();
	}

}