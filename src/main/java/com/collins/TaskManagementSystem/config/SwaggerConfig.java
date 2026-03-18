package com.collins.TaskManagementSystem.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Task Management System API",
                description = "A robust and scalable Task Management System that enables users to create, assign, \" +\n" +
                        "\"and track tasks efficiently. The system supports task prioritization, status updates, \" +\n" +
                        "\"and progress monitoring, designed for reliability, auditability, and high-performance \" +\n" +
                        "  \"workflow management suitable for team and enterprise environments.",
                version = "1.0.0",
                contact = @Contact(
                        name = "Okafor Collins Daberechukwu",
                        email = "collinsdaberechi20@gmail.com"
                )
        ),

                servers =  {
                     @Server(
                             description = "Local Environment",
                             url = "https://localhost:8080"
                     ),
                        @Server(
                                description = "Docker Container Network",
                                url = "https://localhost:"
                        )
                }
)
public class SwaggerConfig {
}
