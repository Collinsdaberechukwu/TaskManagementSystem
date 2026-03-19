package com.collins.TaskManagementSystem.service.impl;

import com.collins.TaskManagementSystem.Event.UserCreatedEvent;
import com.collins.TaskManagementSystem.dto.Request.UserRequest;
import com.collins.TaskManagementSystem.dto.Response.UserResponse;
import com.collins.TaskManagementSystem.dto.ResponseDto;
import com.collins.TaskManagementSystem.entity.Users;
import com.collins.TaskManagementSystem.exception.ResourceNotFoundException;
import com.collins.TaskManagementSystem.exception.UserAlreadyExistException;
import com.collins.TaskManagementSystem.mapper.UserMapper;
import com.collins.TaskManagementSystem.repository.UserRepository;
import com.collins.TaskManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    @Override
    public ResponseEntity<ResponseDto<UserResponse>> createUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistException("Email already registered: " + request.getEmail());
        }

        Users user = Users.builder()
                .name(request.getName())
                .email(request.getEmail().toLowerCase(Locale.ROOT))
                .build();

        Users savedUser = userRepository.save(user);
        publisher.publishEvent(new UserCreatedEvent(savedUser));

        UserResponse response = UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .createdAt(String.valueOf(LocalDateTime.now()))
                .updatedAt(String.valueOf(LocalDateTime.now()))
                .build();


        ResponseDto<UserResponse> responseDto = ResponseDto.<UserResponse>builder()
                .statusMessage("User created successfully")
                .statusCode("201")
                .data(response)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }




    @Override
    public ResponseEntity<ResponseDto<UserResponse>> getUserById(Long id) {
        Users user = getUserEntity(id);
        UserResponse response = UserMapper.toUserResponse(user);

        ResponseDto<UserResponse> responseDto = ResponseDto.<UserResponse>builder()
                .statusCode("200 OK")
                .statusMessage("User retrieved successfully")
                .data(response)
                .build();

        return ResponseEntity.ok(responseDto);
    }

    @Override
    public Users getUserEntity(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }


}
