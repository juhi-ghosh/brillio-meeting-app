/**
 * 
 */
package io.brillio.bookmeeting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.brillio.bookmeeting.util.MeetingConstants;
import io.brillio.bookmeeting.interfaces.IMeetingRoomService;
import io.brillio.bookmeeting.model.MeetingRoom;
import io.brillio.bookmeeting.repo.MeetingRoomRepo;

/**
 * @author jghosh This is Service Implementation for adding and removing Meeting
 *         rooms It checks and updates room status as applicable
 */
@Service
public class MeetingRoomService implements IMeetingRoomService {

	@Autowired
	private MeetingRoomRepo repository;

	/**
	 * Method to add a new meeting room
	 * 
	 * @param room
	 * @return MeetingRoom
	 * 
	 */
	@Override
	public ResponseEntity<Object> createNewMeetingRoom(MeetingRoom room) {
		return ResponseEntity.ok().body(repository.save(room));
	}

	/**
	 * Method to retrieve meeting rooms for given type, building and floor
	 * 
	 * @return Set<MeetingRoom>
	 * 
	 */
	@Override
	public ResponseEntity<Object> getAllMeetingRooms(MeetingRoom room) {

		String type = room.getType();
		String building = room.getLocation().getBuilding();
		String floor = room.getLocation().getFloor();

		// meeting room floor information is optional
		if (floor == null) {
			return ResponseEntity.ok().body(repository.findByTypeAndLocation_buildingAllIgnoreCase(type, building));
		}

		return ResponseEntity.ok()
				.body(repository.findByTypeAndLocation_buildingAndLocation_floorAllIgnoreCase(type, building, floor));
	}

	/**
	 * Method to delete meeting room by id
	 * 
	 * @param roomId
	 * @return MeetingRoom
	 */
	@Override
	public ResponseEntity<Object> deleteRoom(String roomId) {

		try {
			repository.deleteById(Long.parseLong(roomId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MeetingConstants.ERR_MEETING_ROOM_INVALID);
		}
		return ResponseEntity.ok().body(MeetingConstants.MEETING_ROOM_DELETED + " " + roomId);
	}

	/**
	 * Method to retrieve meeting room by id
	 * 
	 * @param roomId
	 * @return MeetingRoom
	 */
	public MeetingRoom getRoom(String roomId) {
		return repository.findById(Long.parseLong(roomId)).get();
	}

	/**
	 * Method to update meeting room status by id
	 * 
	 * @param roomId
	 * @param status
	 * @return String Message with Meeting Room id updated
	 */
	@Override
	public ResponseEntity<Object> updateRoomStatus(String roomId, String status) {
		MeetingRoom room = repository.findById(Long.parseLong(roomId)).get();
		room.setStatus(status);
		repository.save(room);
		return ResponseEntity.ok().body(MeetingConstants.MEETING_ROOM_UPDATED + " " + roomId);
	}

	/**
	 * Method to retrieve all meeting rooms
	 * 
	 * @return Set<MeetingRoom>
	 */
	@Override
	public ResponseEntity<Object> getMeetingRooms() {
		return ResponseEntity.ok().body(repository.findAll());
	}

}
