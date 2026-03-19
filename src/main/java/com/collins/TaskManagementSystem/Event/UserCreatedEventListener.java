package com.collins.TaskManagementSystem.Event;

import com.collins.TaskManagementSystem.entity.Users;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserCreatedEventListener implements ApplicationListener<@NonNull UserCreatedEvent> {


    @Override
    public void onApplicationEvent(@NonNull UserCreatedEvent event) {
        log.info("Event received: {}",event);

        Users users = (Users) event.getSource();

        String msg = "SMS Notification sent to user" + users.getName();
        log.info("User sms create success sent: {}", msg);


    }

    @Override
    public boolean supportsAsyncExecution() {
        return true;
    }
}
