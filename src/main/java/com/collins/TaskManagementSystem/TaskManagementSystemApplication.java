package com.collins.TaskManagementSystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

@EnableJpaAuditing(auditorAwareRef = "AuditAwareImp")
@OpenAPIDefinition(
		info = @Info(
				title = "Task Management System API Documentation",
				description = "A scalable Task Management System for creating, assigning, and tracking tasks efficiently, " +
						"with support for prioritization, status updates, and progress monitoring, designed for reliable " +
						"and high-performance team workflows.",
				version = " v1",
				contact = @Contact(
						name = "Collins Okafor",
						email = "collinsdaberechi20@gmail.com",
						url = "Digicore.com"
				)
		)
)
public class TaskManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementSystemApplication.class, args);
	}

}
