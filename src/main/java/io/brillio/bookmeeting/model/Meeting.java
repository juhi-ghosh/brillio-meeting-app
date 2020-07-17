/**
 * 
 */
package io.brillio.bookmeeting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author jghosh
 * Meeting Data storing reference for Meeting Room
 */
@Entity
@Table(name = "MEETING")
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private MeetingRoom room;

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
	 * @return the room
	 */
	public MeetingRoom getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(MeetingRoom room) {
		this.room = room;
	}

}
