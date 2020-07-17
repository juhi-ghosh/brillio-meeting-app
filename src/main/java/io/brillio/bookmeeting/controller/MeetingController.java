/**
 * 
 */
package io.brillio.bookmeeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.brillio.bookmeeting.interfaces.IMeetingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author jghosh
 * This controller is accepting requests for create/cancel meetings
 */
@RestController
@RequestMapping("/meeting")
@Api(value = "Meeting", description = "Operations on Meeting Module, accepting requests for create/cancel meetings")
public class MeetingController {
	
	@Autowired
	private IMeetingService service;

	/**
	 * Method to add a new booking for given room number
	 * @param roomId
	 * @return booking reference Id
	 */
	@ApiOperation(value = "Add a new booking for given room number", response = Object.class)
	@RequestMapping(value="/addMeeting/{roomId}", method=RequestMethod.POST)
	public ResponseEntity<Object> makeBooking(@PathVariable String roomId) {
		return service.makeBooking(roomId);
	}

	/**
	 * Method to cancel an existing booking for given meeting id
	 * @param meetingId
	 * @return String message with meetingId
	 */
	@ApiOperation(value = "Cancel an existing booking for given meeting id", response = Object.class)
	@RequestMapping(value="/cancelMeeting/{meetingId}", method=RequestMethod.POST)
	public ResponseEntity<Object> cancelBooking(@PathVariable String meetingId) {
		return service.cancelBooking(meetingId);
	}
	
	/**
	 * Method to get all meetings
	 * @return Set<Meeting>
	 */
	@ApiOperation(value = "Get all Meetings", response = Object.class)
	@RequestMapping(value="/getMeetings", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllMeeting() {
		return service.getAllMeeting();
	}
}
