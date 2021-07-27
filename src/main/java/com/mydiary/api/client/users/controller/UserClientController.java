package com.mydiary.api.client.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mydiary.api.client.users.model.User;
import com.mydiary.api.client.users.model.UserLoginModel;
import com.mydiary.api.client.users.service.UserClientService;

@Controller
@RequestMapping("/user-client")
public class UserClientController {

	@Autowired
	UserClientService userClientService;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/status/check")
	public String status() {

		return "My Client microservice is working on port " + env.getProperty("local.server.port");
	}

//	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<User> getUserById(@PathVariable String userId) {
//		
//		User user = userClientService.getUserById(userId);
//
//		return ResponseEntity.status(HttpStatus.OK).body(user);
//	}
	
	@GetMapping("/showLoginPage")
	public String showLoginPage(ModelMap modelMap) {
		
		UserLoginModel userLoginModel = new UserLoginModel();
		modelMap.addAttribute("userLoginModel", userLoginModel);
		
		return "showLoginPage";
	}
	
	@PostMapping("/userLogin")
	public String userLogin(UserLoginModel userLoginModel,
			ModelMap modelMap) {
		
		User loggedInUser = userClientService.userLogin(userLoginModel);
		modelMap.addAttribute("name", loggedInUser.getFirstName());
		modelMap.addAttribute("tasks", loggedInUser.getTasks());
		
		return "home";
	}

}
