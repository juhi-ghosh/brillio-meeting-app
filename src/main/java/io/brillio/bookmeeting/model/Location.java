/**
 * 
 */
package io.brillio.bookmeeting.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author jghosh
 * Meeting Room Location specific data
 */
@Entity
@Table(name = "LOCATION")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "BUILDING")
	private String building;

	@Column(name = "FLOOR")
	private String floor;

	@OneToMany(mappedBy = "location", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonManagedReference
	private Set<MeetingRoom> rooms;
	
	public Set<MeetingRoom> getRooms() {
		return rooms;
	}

	public void setRooms(Set<MeetingRoom> rooms) {
		this.rooms = rooms;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * @return the floor
	 */
	public String getFloor() {
		return floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public void setFloor(String floor) {
		this.floor = floor;
	}

}
