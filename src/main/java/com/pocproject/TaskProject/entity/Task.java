package com.pocproject.TaskProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="taskName", nullable=false)
	private String taskName;
	
	
	//it gets only the detals of id and tasknam  fetch = FetchType.LAZY
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_id")//this join the user table 
	private User users; //calling a User class details


	public User getUsers() {
		return users;
	}


	public void setUsers(User users) {
		this.users = users;
	}

}
