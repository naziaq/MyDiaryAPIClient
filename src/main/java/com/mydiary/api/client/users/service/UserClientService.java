package com.mydiary.api.client.users.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mydiary.api.client.users.model.User;
import com.mydiary.api.client.users.model.UserLoginModel;

@Service
public class UserClientService {

	RestTemplate restTemplate;

	Environment environment;
	
	@Autowired
	HttpSession httpSession;

	public UserClientService(RestTemplate restTemplate, Environment environment) {
		super();
		this.restTemplate = restTemplate;
		this.environment = environment;
	}

	public User getUserById(String userId) {

		String getUserURL = String.format(environment.getProperty("users.getUser.url"), userId);

		ResponseEntity<User> userResponse = restTemplate.exchange(getUserURL, HttpMethod.GET, null,
				new ParameterizedTypeReference<User>() {
				});
		User user = userResponse.getBody();

		return user;
	}

	
	public User userLogin(UserLoginModel userDetails) {

		String userLoginURL = environment.getProperty("users.userLogin.url");

		HttpEntity<UserLoginModel> entity = new HttpEntity<>(userDetails);
		
		ResponseEntity<Void> userResponse = restTemplate.exchange(userLoginURL, HttpMethod.POST, entity,
				new ParameterizedTypeReference<Void>() {
				});		

		String userId =  userResponse.getHeaders().get("userId").get(0).toString();
		
		httpSession.setAttribute("authHeader", "Bearer " + userResponse.getHeaders().get("token").get(0).toString());
		httpSession.setAttribute("userId", userId);
		
		User loggedInUser = getUserById(userId);
		
		 return loggedInUser;
	}
}
