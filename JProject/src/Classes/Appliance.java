package Classes;

public abstract class Appliance {

	private String name;
	private boolean isOn;
	private double waterUsage;
	private double powerUsage;

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public boolean isOn() {
		// TODO - implement Appliance.isOn
		throw new UnsupportedOperationException();
	}

	public void turnOn() {
		// TODO - implement Appliance.turnOn
		throw new UnsupportedOperationException();
	}

	public void turnOff() {
		// TODO - implement Appliance.turnOff
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param on
	 */
	public void setOn(boolean on) {
		// TODO - implement Appliance.setOn
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

}