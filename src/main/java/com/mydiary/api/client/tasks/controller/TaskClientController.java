package com.mydiary.api.client.tasks.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mydiary.api.client.tasks.model.Task;
import com.mydiary.api.client.tasks.service.TaskClientService;

@Controller
@RequestMapping("/task-client")
public class TaskClientController {

	@Autowired
	TaskClientService taskClientService;
	
	@GetMapping("/list-tasks/{username}")
	public String showTaskList(@PathVariable String username, ModelMap modelMap, HttpSession httpSession) {
		
		String userId = null;
		if (httpSession != null) {
			userId = httpSession.getAttribute("userId").toString();
			
		}
		
		List<Task> userTasks = taskClientService.getUserTasks(userId);
		modelMap.addAttribute("taskList", userTasks);
		modelMap.addAttribute("username", username);
		
		return "showTaskList";
	}
	
	@GetMapping("/create-new-task")
	public String createNewTask(ModelMap modelMap) {
		
		modelMap.addAttribute("taskObj", new Task());
		
		return "createNewTask";
	}
	
	@PostMapping("/save-task")
	public String saveTaskToDB(ModelMap modelMap) {
		
		return "showTaskList";
	}
}
