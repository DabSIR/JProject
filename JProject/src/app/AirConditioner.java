package app;

public class AirConditioner extends Appliance {

	private float temperature;

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