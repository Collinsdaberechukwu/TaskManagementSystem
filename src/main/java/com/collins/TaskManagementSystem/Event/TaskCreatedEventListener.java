package com.collins.TaskManagementSystem.Event;

import com.collins.TaskManagementSystem.entity.Task;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskCreatedEventListener implements ApplicationListener<@NonNull TasksCreatedEvent> {
    @Override
    public void onApplicationEvent(@NonNull TasksCreatedEvent event) {
        log.info("Event Received: {}", event);
        Task task = (Task) event.getSource();

        String message= "Task Successfully created sms " + task.getCreatedBy();
        log.info("Sms Notification for task creation sent : {}",message);

    }

    @Override
    public boolean supportsAsyncExecution() {
        return true;
    }
}
