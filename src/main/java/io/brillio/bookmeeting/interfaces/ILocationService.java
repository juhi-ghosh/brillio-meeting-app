/**
 * 
 */
package io.brillio.bookmeeting.interfaces;

import org.springframework.http.ResponseEntity;

/**
 * @author jghosh
 * This Service Interface for getting data for all meeting locations using Spring data JPA
 */
public interface ILocationService {

	/**
	 * Method to get all meetings
	 * @return Set<Location>
	 */
	ResponseEntity<Object> getLocations();

}
