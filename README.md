Task Management System

A robust and scalable Task Management System built with Spring Boot, Java, and JPA, designed to help teams manage tasks efficiently. The system allows users to create, assign, track, and update tasks with support for prioritization and status monitoring.

Features

User Management

Create users

Retrieve user details

Task Management

Create tasks assigned to users

Update task status (PENDING, COMPLETED)

Retrieve tasks for a specific user

Response Structure

Standardized API response using ResponseDto with statusCode, statusMessage, and data.

Technologies Used

Java 17

Spring Boot

Spring Data JPA

Hibernate

H2 (configurable)

Lombok for boilerplate reduction

Swagger (Springdoc OpenAPI) for API documentation

Maven for dependency management

Getting Started
Prerequisites

Java 17+

Maven 3.8+

MySQL or H2 Database

IDE (Intellij)

Installation

Clone the repository:

git clone https://github.com/Collinsdaberechukwu/TaskManagementSystem
cd task-management-system

Configure the database in application.yml:

spring:
  datasource:
    url: jdbc:h2://localhost:3306/taskdb
    username: root
    password: password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

Build and run the application:

mvn clean install
mvn spring-boot:run
API Endpoints
User Endpoints
Method	URL	Description
POST	/api/v1/users	Create a new user
GET	/api/v1/users/{userId}	Retrieve a user by ID
Task Endpoints
Method	URL	Description
POST	/api/v1/tasks/tasks	Create a new task
PATCH	/api/v1/tasks/{taskId}/status	Update task status
GET	/api/v1/tasks/users/{userId}/tasks	Retrieve tasks for a specific user
Sample Request / Response

Create User:

POST /api/v1/users
{
  "name": "Collins Okafor",
  "email": "collinsdaberechi20@gmail.com"
}

Response:

{
  "statusCode": "201",
  "statusMessage": "User created successfully",
  "data": {
    "id": 1,
    "name": "Collins Okafor",
    "email": "collinsdaberechi20@gmail.com",
    "createdAt": "2026-03-18T19:00:00",
    "updatedAt": "2026-03-18T19:00:00"
  }
}
Swagger Documentation

Access Swagger UI at:

http://localhost:8080/swagger-ui.html

OpenAPI JSON spec available at:

http://localhost:8080/v3/api-docs
Error Handling

400 Bad Request – Invalid or missing request data

404 Not Found – User or Task not found

500 Internal Server Error – Unexpected errors

All responses follow the ResponseDto structure:

{
  "statusCode": "200",
  "statusMessage": "Message",
  "data": {}
}
