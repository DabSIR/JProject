package Classes;

public class AirConditioner extends Appliance {
    
    private float temperature;

    public AirConditioner(String name) {
        super(name);
        this.temperature = 22;
    }
    
    public AirConditioner(float temperature, String name) {
        super(name);
        this.temperature = temperature;
    }

    public AirConditioner(float temperature, String name, double waterUsage, double powerUsage) {
        super(name, waterUsage, powerUsage);
        this.temperature = temperature;
    }

        
        
	public float getTemperature() {
		return this.temperature;
	}

	/**
	 * 
	 * @param temperature
	 */
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public void togglePower() {
		// TODO - implement AirConditioner.togglePower
		throw new UnsupportedOperationException();
	}

}