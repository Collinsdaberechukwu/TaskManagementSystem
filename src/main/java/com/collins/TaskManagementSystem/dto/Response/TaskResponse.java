package com.collins.TaskManagementSystem.dto.Response;

import com.collins.TaskManagementSystem.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;

    private Long userId;
    private String userName;
    private String createdAt;
    private String updatedAt;
}
