/**
 * 
 */
package io.brillio.bookmeeting.interfaces;

import org.springframework.http.ResponseEntity;

/**
 * @author jghosh
 * This Service Interface for create/cancel meetings using Spring data JPA
 */
public interface IMeetingService {

	/**
	 * Method to add a new booking for given room number
	 * @param roomId
	 * @return booking reference Id
	 */
	public ResponseEntity<Object> makeBooking(String roomId);

	/**
	 * Method to cancel an existing booking for given meeting id
	 * @param meetingId
	 * @return String message with meetingId
	 */
	public ResponseEntity<Object> cancelBooking(String meetingId);

	/**
	 * Method to retrieve all meetings
	 * @return Set<MeetingRoom>
	 */
	public ResponseEntity<Object> getAllMeeting();

}
