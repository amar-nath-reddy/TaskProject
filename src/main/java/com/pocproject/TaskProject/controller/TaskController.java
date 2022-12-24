package com.pocproject.TaskProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocproject.TaskProject.payload.TaskDto;
import com.pocproject.TaskProject.service.TaskService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TaskController {
	@Autowired
	private TaskService taskService;

	@PostMapping("/{userid}/task")
	public ResponseEntity<TaskDto> saveTask(
			@PathVariable(name ="userid") long userid,
			@RequestBody TaskDto taskDto
			){
		return new ResponseEntity<>(taskService.saveTask(userid, taskDto),HttpStatus.CREATED);
		
	}

	@GetMapping("/{userid}/task")
	public ResponseEntity<List<TaskDto>> getAllDetails(
			@PathVariable (name = "userid" )long userid
	){
		return new ResponseEntity<>(taskService.getAllTask(userid),HttpStatus.OK);

	}
	
	
}
