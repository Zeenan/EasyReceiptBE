package com.papafranku.entities;


public class User extends ResponseStatus {

	private String firstName;
	private String lastName;
	private long id;
	private String email;
	private String username;
	private String password;
	private String authenticity_token = null;
	
	private boolean isActive;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthenticity_token() {
		return authenticity_token;
	}

	public void setAuthenticity_token(String authenticity_token) {
		this.authenticity_token = authenticity_token;
	}
	
	
	
}
