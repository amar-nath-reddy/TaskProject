package com.pocproject.TaskProject.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocproject.TaskProject.entity.User;
import com.pocproject.TaskProject.payload.UserDto;
import com.pocproject.TaskProject.reposotory.UserReposetory;
import com.pocproject.TaskProject.service.UserService;

@Service
public class UserServiceImp implements UserService{
	//Create Bean Object For UserReposetory using AutoWired
	
		@Autowired
		UserReposetory userReposetory; //interface
		
		
		@Override
		public UserDto createUser(UserDto userDto) { //convert userDto To User for that type cast
			User user = userDtoToEntity(userDto);  //these method return User Entity
			User savedUser = userReposetory.save(user);//this return database Data and save to saveUser
			return EntityToUserDto(savedUser);  // internally it was returning the USER Entity  jpa
		}
		
		private User userDtoToEntity(UserDto userDto) {
			User user = new User();
			user.setName(userDto.getName());
			user.setEmail(userDto.getEmail());             
			user.setPassword(userDto.getPassword());
			return user;
			
		}
		
		private UserDto EntityToUserDto(User savedUser) {
			UserDto userDto = new UserDto();
			userDto.setId(savedUser.getId());
			userDto.setName(savedUser.getName());
			userDto.setEmail(savedUser.getEmail());
			userDto.setName(savedUser.getName());
			return userDto;
			
		}
}
