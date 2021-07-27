package com.mydiary.api.client.users.model;

import java.util.List;

import com.mydiary.api.client.tasks.model.Task;

/*@JsonIgnoreProperties(ignoreUnknown = true)*/
public class User {

	private String firstName;
	private String lastName;
	private String email;
	private String userId;
	private String statusMessage;
	private String password;
	private List<Task> tasks;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, String userId, String statusMessage, String password, List<Task> tasks) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userId = userId;
		this.statusMessage = statusMessage;
		this.password = password;
		this.tasks = tasks;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}	

}
