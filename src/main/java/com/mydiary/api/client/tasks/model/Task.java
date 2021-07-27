package com.mydiary.api.client.tasks.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Task {

	private String id;
	
	@NotNull(message = "Please enter Task.")
	private String task;
	
	@NotNull(message = "Please enter Description.")
	private String description;
	
	private String userId;
	
	private boolean isStarted;
	
	private boolean completed;
	
	private String remarks;
	
	@NotNull(message = "Please select Target Date.")
	private Date targetDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
}
