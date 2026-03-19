package com.collins.TaskManagementSystem.Event;

import com.collins.TaskManagementSystem.entity.Task;
import org.springframework.context.ApplicationEvent;

public class UpdateTaskStatusCreatedEvent extends ApplicationEvent {
    public UpdateTaskStatusCreatedEvent(Task task) {
        super(task);
    }
}
