package com.collins.TaskManagementSystem.Event;

import com.collins.TaskManagementSystem.entity.Task;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateTaskStatusCreatedEventListener implements ApplicationListener<@NonNull UpdateTaskStatusCreatedEvent> {
    @Override
    public void onApplicationEvent(@NonNull UpdateTaskStatusCreatedEvent event) {
        log.info("Event Received: {} ", event);

        Task task = (Task) event.getSource();
        String msg = "SMS For Task update sent " + task.getUpdatedBy();
        log.info("Task status updated Successfully: {} ", msg);

    }

    @Override
    public boolean supportsAsyncExecution() {
        return true;
    }
}
