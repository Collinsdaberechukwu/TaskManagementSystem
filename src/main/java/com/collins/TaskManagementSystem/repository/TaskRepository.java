package com.collins.TaskManagementSystem.repository;

import com.collins.TaskManagementSystem.entity.Task;
import com.collins.TaskManagementSystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByUser(Users user);
}
