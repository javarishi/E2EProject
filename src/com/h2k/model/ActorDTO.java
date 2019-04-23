package com.h2k.model;

import java.sql.Timestamp;


// TO. DTO. Bean. Persistent
public class ActorDTO {
	
	public ActorDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private int actorId;
	private String firstName;
	private String lastName;
	private Timestamp timestamp;
	
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}



}
