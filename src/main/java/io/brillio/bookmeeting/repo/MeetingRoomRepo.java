/**
 * 
 */
package io.brillio.bookmeeting.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.brillio.bookmeeting.model.MeetingRoom;

/**
 * @author jghosh
 * Repository of Meeting Rooms added in the database
 */
public interface MeetingRoomRepo extends CrudRepository<MeetingRoom, Long> {

	public List<MeetingRoom> findByTypeAndLocation_buildingAllIgnoreCase(String type, String building);

	public List<MeetingRoom> findByTypeAndLocation_buildingAndLocation_floorAllIgnoreCase(String type, String building,
			String floor);
}