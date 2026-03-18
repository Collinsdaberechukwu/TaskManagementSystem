package com.collins.TaskManagementSystem.mapper;

import com.collins.TaskManagementSystem.dto.Response.TaskResponse;
import com.collins.TaskManagementSystem.entity.Task;

import java.time.format.DateTimeFormatter;

public class TaskMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static TaskResponse mapToTaskResponse(Task task) {
        if (task == null) {
            return null;
        }

        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getTaskStatus())
                .userId(task.getUser() != null ? task.getUser().getId() : null)
                .userName(task.getUser() != null ? task.getUser().getName() : null)
                .createdAt(task.getCreatedAt() != null ? task.getCreatedAt().format(FORMATTER) : null)
                .updatedAt(task.getUpdatedAt() != null ? task.getUpdatedAt().format(FORMATTER) : null)
                .build();
    }
}
