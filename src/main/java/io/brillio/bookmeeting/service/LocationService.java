package io.brillio.bookmeeting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.brillio.bookmeeting.interfaces.ILocationService;
import io.brillio.bookmeeting.repo.LocationRepo;

/**
 * @author jghosh
 * This Service Implementation is for getting data for all meeting locations using Spring data JPA
 */
@Service
public class LocationService implements ILocationService {


	@Autowired
	private LocationRepo repository;

	/**
	 * Method to get all meetings
	 * @return Set<Location>
	 */
	@Override
	public ResponseEntity<Object> getLocations() {
		return ResponseEntity.ok().body(repository.findAll());
	}
}
