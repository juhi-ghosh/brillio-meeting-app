package io.brillio.bookmeeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.brillio.bookmeeting.interfaces.IMeetingRoomService;
import io.brillio.bookmeeting.model.MeetingRoom;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author jghosh
 * This controller manages requests for Meeting room crud operations
 */
@RestController
@RequestMapping("/meetingRoom")
@Api(value = "Meeting Room", description = "Operations on Meeting Room Module")
public class MeetingRoomController {
	
	@Autowired
	private  IMeetingRoomService service;
	
	/**
	 * Method to add a new meeting room
	 * @param room
	 * @return MeetingRoom
	 */
	@ApiOperation(value = "Add a new meeting room", response = Object.class)
	@RequestMapping(value="/addRoom", method=RequestMethod.POST)
	public ResponseEntity<Object> createNewRoom(@RequestBody MeetingRoom room) {
		return service.createNewMeetingRoom(room);
	}
	
	/**
	 * Method to retrieve meeting rooms for given type, building and floor
	 * @return Set<MeetingRoom>
	 * 
	 */
	@ApiOperation(value = "Retrieve meeting rooms for given type, building and floor", response = Object.class)
	@RequestMapping(value="/getRooms", method=RequestMethod.POST)
	public ResponseEntity<Object> getAllRooms(@RequestBody MeetingRoom room) {
		return service.getAllMeetingRooms(room);
	}
	
	/**
	 * Method to retrieve all meeting rooms 
	 * @return Set<MeetingRoom>
	 */
	@ApiOperation(value = "Retrieve all meeting rooms", response = Object.class)
	@RequestMapping(value="/getRooms", method=RequestMethod.GET)
	public ResponseEntity<Object> getRooms() {
		return service.getMeetingRooms();
	}
	
	/**
	 * Method to delete a meeting room for given id
	 * @param id
	 * @return room
	 */
	@ApiOperation(value = "Delete a meeting room for given id", response = Object.class)
	@RequestMapping(value="/removeRoom/{id}", method=RequestMethod.POST)
	public ResponseEntity<Object> deleteRoom(@PathVariable String id) {
		return service.deleteRoom(id);
	}
	
	/**
	 * Method to update a meeting room status for given id
	 * @param id
	 * @return room
	 */
	@ApiOperation(value = "Update a meeting room status for given id", response = Object.class)
	@RequestMapping(value="/updateRoomStatus/{id}/{status}", method=RequestMethod.POST)
	public ResponseEntity<Object> updateRoomStatus(@PathVariable String id,@PathVariable String status) {
		return service.updateRoomStatus(id, status);
	}
}
