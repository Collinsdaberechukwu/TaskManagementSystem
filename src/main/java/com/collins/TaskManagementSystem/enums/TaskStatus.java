package com.collins.TaskManagementSystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatus {

    PENDING("PENDING"),
    COMPLETED("COMPLETED");

    private final String taskStatus;


}
