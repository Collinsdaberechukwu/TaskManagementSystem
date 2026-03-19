package com.collins.TaskManagementSystem.Event;

import com.collins.TaskManagementSystem.entity.Task;
import org.springframework.context.ApplicationEvent;

public class TasksCreatedEvent extends ApplicationEvent {
    public TasksCreatedEvent(Task task) {
        super(task);
    }
}
