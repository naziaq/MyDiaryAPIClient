package com.mydiary.api.client.tasks.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mydiary.api.client.tasks.model.Task;

@Service
public class TaskClientService {
	
	RestTemplate restTemplate;
	
	Environment environment;
	
	@Autowired
	HttpSession httpSession;

	public TaskClientService(RestTemplate restTemplate, Environment environment) {
		super();
		this.restTemplate = restTemplate;
		this.environment = environment;
	}
	
	
	public List<Task> getUserTasks(String userId){
		
		String getUserTasksURL = String.format(environment.getProperty("tasks.getAllTasks.url"), userId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, httpSession.getAttribute("authHeader").toString());
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		
		ResponseEntity<List<Task>> taskResponse = restTemplate.exchange(getUserTasksURL, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Task>>() {
		});
		
		List<Task> userTasks = taskResponse.getBody();
		
		return userTasks;
	}

}
