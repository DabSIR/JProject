package app;

public class Sensor extends Appliance implements Security_Interface {

	private int id;
	private String location;
	private boolean isOn;

	public int getId() {
		return this.id;
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

	public void turnOff() {
		// TODO - implement Sensor.turnOff
		throw new UnsupportedOperationException();
	}

	public void turnOn() {
		// TODO - implement Sensor.turnOn
		throw new UnsupportedOperationException();
	}

	public boolean isOn() {
		// TODO - implement Sensor.isOn
		throw new UnsupportedOperationException();
	}

    @Override
    public void alert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}