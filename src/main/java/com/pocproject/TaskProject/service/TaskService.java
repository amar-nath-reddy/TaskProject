package com.pocproject.TaskProject.service;

import com.pocproject.TaskProject.payload.TaskDto;

import java.util.List;


public interface TaskService {
	
   // to save the task 
	public TaskDto saveTask(long userid, TaskDto taskDto);

	public List<TaskDto> getAllTask(long userid);
	
}
