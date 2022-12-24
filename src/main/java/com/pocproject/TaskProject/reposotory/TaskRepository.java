package com.pocproject.TaskProject.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pocproject.TaskProject.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>{


    List<Task> findAllByid(long userid);

}
