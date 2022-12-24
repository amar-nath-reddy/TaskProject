package com.pocproject.TaskProject.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@UniqueConstraint --> no duplicate allows for email in DB
//nullable ---> name column should  not be null
//@Entity ----> it create table in DB with name of User
/*@Data
@NoArgsConstructor    no need to create setter getters and constructers
@AllArgsConstructo*/


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User" , uniqueConstraints = {
		@UniqueConstraint(columnNames= {"email"})
})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	

	@Column(name="name", nullable = false)
	private String name;
	
    @Column(name="Email", nullable = false)
	private String email; 
	
	@Column(name="password", nullable = false)
	private int password;
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
}
