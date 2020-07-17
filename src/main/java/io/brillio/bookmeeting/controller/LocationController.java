/**
 * 
 */
package io.brillio.bookmeeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.brillio.bookmeeting.interfaces.ILocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author jghosh
 * This controller is used to display all available locations
 */
@RestController
@RequestMapping("/location")
@Api(value = "Meeting Room Location", description = "Operations on Meeting Room Location Module, used to display all available locations")
public class LocationController {
	
	@Autowired
	private ILocationService service;
	
	/**
	 * Method to get all meetings
	 * @return Set<Location>
	 */
	@ApiOperation(value = "Get all Locations", response = Object.class)
	@RequestMapping(value="/getLocations", method=RequestMethod.GET)
	public ResponseEntity<Object> getLocations() {
		return service.getLocations();
	}
}
