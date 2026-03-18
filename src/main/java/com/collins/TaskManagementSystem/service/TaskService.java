package com.collins.TaskManagementSystem.service;

import com.collins.TaskManagementSystem.dto.Request.TaskCreationRequest;
import com.collins.TaskManagementSystem.dto.Request.UserRequest;
import com.collins.TaskManagementSystem.dto.Response.TaskResponse;
import com.collins.TaskManagementSystem.dto.Response.UserResponse;
import com.collins.TaskManagementSystem.dto.ResponseDto;
import com.collins.TaskManagementSystem.dto.TaskStatusUpdateRequest;
import com.collins.TaskManagementSystem.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
//    ResponseEntity<ResponseDto<UserResponse>> createUser(UserRequest request);

    ResponseEntity<ResponseDto<TaskResponse>> createTask(TaskCreationRequest request);

    ResponseEntity<ResponseDto<List<TaskResponse>>> getTasksByUserId(Long userId);

    ResponseEntity<ResponseDto<TaskResponse>> updateTaskStatus(Long taskId, TaskStatusUpdateRequest request);

//    ResponseEntity<ResponseDto<UserResponse>> getUserById(Long id);
//
//    Users getUserEntity(Long id);

//    Users getUserEntity(Long id);
}
