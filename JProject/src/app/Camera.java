package app;

public class Camera extends Appliance implements Security_Interface {

	private int id;
	private String location;
	private boolean isRecording;

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

    @Override
    public void alert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}