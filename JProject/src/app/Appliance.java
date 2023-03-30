package app;

public abstract class Appliance {

	private String name;
	private String type;
	private boolean isOn;
	private ApplianceState state;
	private Schedule schedule;

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

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
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

	public ApplianceState getState() {
		return this.state;
	}

	/**
	 * 
	 * @param state
	 */
	public void setState(ApplianceState state) {
		this.state = state;
	}

}