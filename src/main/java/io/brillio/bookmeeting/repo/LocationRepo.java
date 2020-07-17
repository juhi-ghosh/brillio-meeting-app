/**
 * 
 */
package io.brillio.bookmeeting.repo;

import org.springframework.data.repository.CrudRepository;

import io.brillio.bookmeeting.model.Location;

/**
 * @author jghosh
 * Repository of Locations in Database
 */
public interface LocationRepo extends CrudRepository<Location, Long>{

}
