/**
 * 
 */
package io.brillio.bookmeeting.interfaces;

import org.springframework.http.ResponseEntity;

import io.brillio.bookmeeting.model.MeetingRoom;

/**
 * @author jghosh
 * This Service Interface for adding and removing Meeting rooms using Spring data JPA
 */
public interface IMeetingRoomService {

	/**
	 * Method to add a new meeting room
	 * @param room
	 * @return MeetingRoom
	 * 
	 */
	public ResponseEntity<Object> createNewMeetingRoom(MeetingRoom room);
	
	/**
	 * Method to retrieve meeting rooms for given type, building and floor
	 * @return Set<MeetingRoom>
	 * 
	 */
	public ResponseEntity<Object> getAllMeetingRooms(MeetingRoom room);
	
	/**
	 * Method to delete meeting room by id
	 * @param roomId
	 * @return MeetingRoom
	 */
	public ResponseEntity<Object> deleteRoom(String roomId);
	
	/**
	 * Method to retrieve all meeting rooms 
	 * @return Set<MeetingRoom>
	 */
	public ResponseEntity<Object> getMeetingRooms();

	/**
	 * Method to update meeting room by id
	 * @param roomId
	 * @return MeetingRoom
	 */
	public ResponseEntity<Object> updateRoomStatus(String id, String status);
	
}
