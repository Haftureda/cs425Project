package edu.mum.cs5.airTicketbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crewmember")
public class CrewMember {
	
	private Long id;
	private String crewid;
	private String name;
	private String gender;
	private String position;

	public CrewMember() {

	}

	public CrewMember(String crewid, String name, String gender, String position) {
		super();
		this.crewid = crewid;
		this.name = name;
	
		this.gender = gender;
		this.position = position;
	}

	public String getCrewid() {
		return crewid;
	}

	public void setCrewid(String crewid) {
		this.crewid = crewid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
