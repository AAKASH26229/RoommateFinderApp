package com.springrest.roommateapp.payloads;

import java.util.Date;

import com.springrest.roommateapp.entities.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;

public class RoomDto {

	

	@NotEmpty(message="Double sharing or Triple Sharing")
	private String occupancy;

	
	private Date addedDate;
	
	private Userdto user;
	
	
	
	public RoomDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}
	
	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Userdto getUser() {
		return user;
	}

	public void setUser(Userdto user) {
		this.user = user;
	}
}
