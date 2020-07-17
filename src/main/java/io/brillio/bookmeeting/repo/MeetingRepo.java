/**
 * 
 */
package io.brillio.bookmeeting.repo;

import org.springframework.data.repository.CrudRepository;

import io.brillio.bookmeeting.model.Meeting;

/**
 * @author jghosh
 * Repository of Meetings created
 */
public interface MeetingRepo extends CrudRepository<Meeting, Long>{

}
