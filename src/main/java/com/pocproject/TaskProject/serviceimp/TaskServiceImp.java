package com.pocproject.TaskProject.serviceimp;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocproject.TaskProject.entity.Task;
import com.pocproject.TaskProject.entity.User;
import com.pocproject.TaskProject.exceptions.UserNotFount;
import com.pocproject.TaskProject.payload.TaskDto;
import com.pocproject.TaskProject.reposotory.TaskRepository;
import com.pocproject.TaskProject.reposotory.UserReposetory;
import com.pocproject.TaskProject.service.TaskService;

@Service
public class TaskServiceImp implements TaskService{
	
	@Autowired
	private ModelMapper modelMapper; // it convert Dto to Entity & Entity To Dto;
	
	@Autowired
	private UserReposetory userReposetory;
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public TaskDto saveTask(long userid, TaskDto taskDto) {
		User users = userReposetory.findById(userid).orElseThrow(
				() -> new UserNotFount(String.format("User id  %d not found ", userid))
				);  // it check for user present id DB or not
		
		//it convert Dto to Entity  store in task
		Task task = modelMapper.map(taskDto, Task.class); 
	    task.setUsers(users);  //setting user in Task entity
		Task saveTask =taskRepository.save(task);
		//it convert Entity to dto  store in task 
	   return modelMapper.map(saveTask, TaskDto.class);
	}

	@Override
	public List<TaskDto> getAllTask(long userid) {
		User users = userReposetory.findById(userid).orElseThrow(
				() -> new UserNotFount(String.format("User id  %d not found ", userid))
		);
		System.out.println("==============================");
		System.out.println("User:"+users);
		System.out.println("==============================");
		List<Task> task = taskRepository.findAllByid(userid) ;//entity

		System.out.println("==============================");
		System.out.println("Task:"+task);
		System.out.println("==============================");


		return task.stream().map(
				tasks -> modelMapper.map(task,TaskDto.class)).collect(Collectors.toList());


	}


}
