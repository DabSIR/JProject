package Classes;

import Classes.Security_Interface;

public abstract class Camera extends Appliance implements Security_Interface {

    
	private int id;
	private String location;
	private boolean isRecording;

    public Camera(int id, String name) {
        super(name);
        this.id = id;
    }

    public Camera(int id, String name, double waterUsage, double powerUsage) {
        super(name, waterUsage, powerUsage);
        this.id = id;
    }

        
        
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

	public boolean isRecording() {
		// TODO - implement Camera.isRecording
		throw new UnsupportedOperationException();
	}

	public void startRecording() {
		// TODO - implement Camera.startRecording
		throw new UnsupportedOperationException();
	}

	public void stopRecording() {
		// TODO - implement Camera.stopRecording
		throw new UnsupportedOperationException();
	}

}