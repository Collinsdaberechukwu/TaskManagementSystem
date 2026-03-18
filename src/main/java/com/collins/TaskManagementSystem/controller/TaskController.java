package com.collins.TaskManagementSystem.controller;

import com.collins.TaskManagementSystem.dto.Request.TaskCreationRequest;
import com.collins.TaskManagementSystem.dto.Request.UserRequest;
import com.collins.TaskManagementSystem.dto.Response.TaskResponse;
import com.collins.TaskManagementSystem.dto.Response.UserResponse;
import com.collins.TaskManagementSystem.dto.ResponseDto;
import com.collins.TaskManagementSystem.dto.TaskStatusUpdateRequest;
import com.collins.TaskManagementSystem.service.TaskService;
import com.collins.TaskManagementSystem.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name =  "CRUD REST API FOR USER & TASK",
        description = "CRUD REST API in Task management to create_user,create_task fetch user, update status "
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @Operation(
            summary = "Create User REST API",
            description = "This API is responsible for creating user in task management"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/create_user")
    public ResponseEntity<ResponseDto<UserResponse>> createUser(@RequestBody @Valid UserRequest request){
        return userService.createUser(request);
    }


    @Operation(
            summary = "Create Task REST API",
            description = "This API is responsible for creating task in task management"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/tasks")
    public ResponseEntity<ResponseDto<TaskResponse>> createTask(@RequestBody @Valid TaskCreationRequest request) {
        return taskService.createTask(request);
    }


    @Operation(
            summary = "Achieved User by  ID REST API",
            description = "This API is responsible for fetching user by ID on the task management"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 200"
    )
    @GetMapping("/users/{userId}/tasks")
    public ResponseEntity<ResponseDto<List<TaskResponse>>> getTasksByUser(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }


    @Operation(
            summary = "Updates Task status REST API",
            description = "This API is responsible for updating task status"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 200 OK"
    )
    @PatchMapping("/tasks/{taskId}/status")
    public ResponseEntity<ResponseDto<TaskResponse>> updateTaskStatus(
            @PathVariable Long taskId,
            @RequestBody @Valid TaskStatusUpdateRequest request
    ) {
        return taskService.updateTaskStatus(taskId, request);
    }


    @Operation(
            summary = "Fetch user by id REST API",
            description = "This API is responsible for for fetching user"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDto<UserResponse>> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
