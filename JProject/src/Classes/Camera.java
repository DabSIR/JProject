package Classes;

import Classes.Security_Interface;

public class Camera extends Appliance implements Security_Interface {

	private String location;
	private boolean isRecording;

    public Camera(String name) {
        super(name);
    }

    public Camera(int id, String name, double waterUsage, double powerUsage) {
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

    @Override
    public void alert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}