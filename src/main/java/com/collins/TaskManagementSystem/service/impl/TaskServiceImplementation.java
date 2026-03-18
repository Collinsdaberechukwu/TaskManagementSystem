package com.collins.TaskManagementSystem.service.impl;

import com.collins.TaskManagementSystem.dto.Request.TaskCreationRequest;
import com.collins.TaskManagementSystem.dto.Request.UserRequest;
import com.collins.TaskManagementSystem.dto.Response.TaskResponse;
import com.collins.TaskManagementSystem.dto.Response.UserResponse;
import com.collins.TaskManagementSystem.dto.ResponseDto;
import com.collins.TaskManagementSystem.dto.TaskStatusUpdateRequest;
import com.collins.TaskManagementSystem.entity.Task;
import com.collins.TaskManagementSystem.entity.Users;
import com.collins.TaskManagementSystem.enums.TaskStatus;
import com.collins.TaskManagementSystem.exception.ResourceNotFoundException;
import com.collins.TaskManagementSystem.exception.UserAlreadyExistException;
import com.collins.TaskManagementSystem.mapper.TaskMapper;
import com.collins.TaskManagementSystem.mapper.UserMapper;
import com.collins.TaskManagementSystem.repository.TaskRepository;
import com.collins.TaskManagementSystem.repository.UserRepository;
import com.collins.TaskManagementSystem.service.TaskService;
import com.collins.TaskManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImplementation implements TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;



    @Override
    public ResponseEntity<ResponseDto<TaskResponse>> createTask(TaskCreationRequest request) {

        if (!StringUtils.hasText(request.getTitle())) {
            throw new IllegalArgumentException("Task title cannot be blank");
        }
        if (!StringUtils.hasText(request.getDescription())) {
            throw new IllegalArgumentException("Task description cannot be blank");
        }
        if (request.getUserId() == null) {
            throw new IllegalArgumentException("UserId is required");
        }

        Users user = userService.getUserEntity(request.getUserId());


        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .user(user)
                .taskStatus(TaskStatus.PENDING)
                .build();


        Task saved = taskRepository.save(task);


        TaskResponse taskResponse = TaskMapper.mapToTaskResponse(saved);


        ResponseDto<TaskResponse> responseDto = ResponseDto.<TaskResponse>builder()
                .statusCode("201")
                .statusMessage("Task created successfully")
                .data(taskResponse)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }



    @Override
    public ResponseEntity<ResponseDto<TaskResponse>> updateTaskStatus(Long taskId, TaskStatusUpdateRequest request) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));


        String statusStr = request.getTaskStatus();
        if (!StringUtils.hasText(statusStr)) {
            throw new IllegalArgumentException("Status cannot be blank");
        }

        try {
            task.setTaskStatus(TaskStatus.valueOf(statusStr.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status. Allowed values: PENDING, COMPLETED");
        }


        Task updatedTask = taskRepository.save(task);


        TaskResponse taskResponse = TaskMapper.mapToTaskResponse(updatedTask);

        ResponseDto<TaskResponse> responseDto = ResponseDto.<TaskResponse>builder()
                .statusCode("200")
                .statusMessage("Task status updated successfully")
                .data(taskResponse)
                .build();

        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<ResponseDto<List<TaskResponse>>> getTasksByUserId(Long userId) {
        Users user = userService.getUserEntity(userId);

        List<Task> tasks = taskRepository.findByUser(user);
        List<TaskResponse> taskResponses = tasks.stream()
                .map(TaskMapper::mapToTaskResponse)
                .collect(Collectors.toList());

        ResponseDto<List<TaskResponse>> responseDto = ResponseDto.<List<TaskResponse>>builder()
                .statusMessage("Tasks retrieved successfully")
                .statusCode("200")
                .data(taskResponses)
                .build();

        return ResponseEntity.ok(responseDto);
    }


}
