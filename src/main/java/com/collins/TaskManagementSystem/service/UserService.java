package com.collins.TaskManagementSystem.service;

import com.collins.TaskManagementSystem.dto.Request.UserRequest;
import com.collins.TaskManagementSystem.dto.Response.UserResponse;
import com.collins.TaskManagementSystem.dto.ResponseDto;
import com.collins.TaskManagementSystem.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    ResponseEntity<ResponseDto<UserResponse>> createUser(UserRequest request);

    ResponseEntity<ResponseDto<UserResponse>> getUserById(Long id);

    Users getUserEntity(Long id);
}
