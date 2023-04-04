package Classes;

public class Sensor extends Appliance implements Security_Interface {

	private String location;
	private boolean isOn;

    public Sensor(String name) {
        super(name);
    }

    public Sensor(int id, String name, double waterUsage, double powerUsage) {
        super(name, waterUsage, powerUsage);
 
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
        
        public void alert() {
            
        }

}