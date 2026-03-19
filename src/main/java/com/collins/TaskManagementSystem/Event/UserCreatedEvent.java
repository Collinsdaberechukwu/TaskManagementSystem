package com.collins.TaskManagementSystem.Event;

import com.collins.TaskManagementSystem.entity.Users;
import org.springframework.context.ApplicationEvent;

public class UserCreatedEvent extends ApplicationEvent {
    public UserCreatedEvent(Users users) {
        super(users);
    }
}
