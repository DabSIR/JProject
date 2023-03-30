package app;

import java.util.HashMap;

public class Scene {

	private String name;
	private HashMap<Room, RoomState> roomStates;

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param room
	 * @param state
	 */
	public void addRoomState(Room room, RoomState state) {
		// TODO - implement Scene.addRoomState
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param room
	 */
	public void removeRoomState(Room room) {
		// TODO - implement Scene.removeRoomState
		throw new UnsupportedOperationException();
	}

	public HashMap<Room, RoomState> getRoomStates() {
		return this.roomStates;
	}

	public void apply() {
		// TODO - implement Scene.apply
		throw new UnsupportedOperationException();
	}

}