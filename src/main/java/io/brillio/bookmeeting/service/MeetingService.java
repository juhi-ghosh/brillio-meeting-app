package io.brillio.bookmeeting.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.brillio.bookmeeting.util.MeetingConstants;
import io.brillio.bookmeeting.interfaces.IMeetingService;
import io.brillio.bookmeeting.model.Meeting;
import io.brillio.bookmeeting.model.MeetingRoom;
import io.brillio.bookmeeting.repo.MeetingRepo;

/**
 * @author jghosh
 * This Service Implementation is for create/cancel meetings using Spring data JPA
 */
@Service
public class MeetingService implements IMeetingService {

	@Autowired
	private MeetingRoomService roomService;

	@Autowired
	private MeetingRepo repository;

	/**
	 * Method to retrieve meeting for given id
	 * @param roomId
	 * @return booking reference Id
	 */
	public Meeting getMeeting(Long id) {
		return repository.findById(id).get();
	}

	/**
	 * Method to add a new booking for given room number
	 * @param roomId
	 * @return booking reference Id
	 */
	public ResponseEntity<Object> makeBooking(String roomId) {
		MeetingRoom room = null;
		
		// check if given meeting roomId is valid
		try {
			room = roomService.getRoom(roomId);
		} catch (NoSuchElementException e) {
			if (room == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MeetingConstants.ERR_MEETING_ROOM_INVALID);
			}
		}

		// check meeting room status if 'available'
		if (room.getStatus().equalsIgnoreCase(MeetingConstants.STR_AVAILABLE)) {
			return addMeeting(room);
		}
		// otherwise return room is busy
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MeetingConstants.ERR_MEETING_ROOM_UNAVAILABLE);
	}

	/**
	 * Method to save a new meeting if room available
	 * @param MeetingRoom room
	 * @return booking reference Id
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<Object> addMeeting(MeetingRoom room) {
		Meeting meeting = null;
		String roomId = String.valueOf(room.getId());

		// save new meeting entry in database
		Meeting newMeet = new Meeting();
		newMeet.setRoom(room);
		meeting = repository.save(newMeet);

		// update meeting room status as 'busy'
		roomService.updateRoomStatus(roomId, MeetingConstants.STR_BUSY);

		return ResponseEntity.ok().body(MeetingConstants.MEETING_CREATED + ": " + meeting.getId());
	}

	/**
	 * Method to cancel an existing booking for given meeting id
	 * @param meetingId
	 * @return String message with meetingId
	 */
	public ResponseEntity<Object> cancelBooking(String meetingId) {
		long id = Long.parseLong(meetingId);

		Meeting meeting = null;
		try {
			meeting = getMeeting(id);
		} catch (NoSuchElementException e) {
			if (meeting == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MeetingConstants.ERR_MEETING_NOT_EXISTS);
			}
		}

		return deleteMeeting(meeting);
	}

	/**
	 * Method to delete meeting and update room status
	 * @param MeetingRoom room
	 * @return String message with meetingId
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<Object> deleteMeeting(Meeting meeting) {
		// update meeting room status to 'available'
		String roomId = String.valueOf(meeting.getRoom().getId());
		roomService.updateRoomStatus(roomId, MeetingConstants.STR_AVAILABLE);

		// delete meeting
		repository.deleteById(meeting.getId());
		return ResponseEntity.ok().body(MeetingConstants.MEETING_CANCELLED  + meeting.getId());
	}

	/**
	 * Method to retrieve all meetings 
	 * @return Set<Meeting>
	 */
	@Override
	public ResponseEntity<Object> getAllMeeting() {
		return ResponseEntity.ok().body(repository.findAll());
	}
}
