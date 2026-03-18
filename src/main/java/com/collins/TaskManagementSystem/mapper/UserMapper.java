package com.collins.TaskManagementSystem.mapper;

import com.collins.TaskManagementSystem.dto.Response.UserResponse;
import com.collins.TaskManagementSystem.entity.Users;

import java.time.format.DateTimeFormatter;

public class UserMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static UserResponse toUserResponse(Users user) {
        if (user == null) return null;

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt() != null ? user.getCreatedAt().format(FORMATTER) : null)
                .updatedAt(user.getUpdatedAt() != null ? user.getUpdatedAt().format(FORMATTER) : null)
                .build();
    }
}
