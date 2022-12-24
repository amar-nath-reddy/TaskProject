package com.pocproject.TaskProject.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pocproject.TaskProject.entity.User;

public interface UserReposetory extends JpaRepository<User, Long> {

}
