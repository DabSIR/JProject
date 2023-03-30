package app;

import java.util.HashMap;

public class ApplianceState {

	private boolean isOn;
	private HashMap<String, Object> preferences;
	private double powerUsage;
	private double waterUsage;

	public boolean isOn() {
		// TODO - implement ApplianceState.isOn
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param on
	 */
	public void setOn(boolean on) {
		// TODO - implement ApplianceState.setOn
		throw new UnsupportedOperationException();
	}

	public double getPowerUsage() {
		return this.powerUsage;
	}

	/**
	 * 
	 * @param usage
	 */
	public void setPowerUsage(double usage) {
		this.powerUsage = usage;
	}

	public double getWaterUsage() {
		return this.waterUsage;
	}

	/**
	 * 
	 * @param waterUsage
	 */
	public void setWaterUsage(double waterUsage) {
		this.waterUsage = waterUsage;
	}

	public void operation() {
		// TODO - implement ApplianceState.operation
		throw new UnsupportedOperationException();
	}

}