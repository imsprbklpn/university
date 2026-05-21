# University Management System

Backend REST API built with Spring Boot for managing university data.

## Tech Stack

- Java 17
- Spring Boot 3.5.14
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Swagger / OpenAPI
- Docker + Docker Compose
- Gradle

## Features

- User registration and authentication with JWT
- Course management (CRUD)
- Student enrollment with async notifications
- Assignment and submission management
- File upload and download
- Pagination, sorting, and search
- Global exception handling
- Request/response logging
- Swagger UI documentation

## Getting Started

### Run locally

1. Create PostgreSQL database:
```sql
CREATE DATABASE university_db;
```

2. Configure `application.properties` with your DB credentials

3. Run the application:
```bash
./gradlew bootRun
```

4. Open Swagger UI: http://localhost:8080/swagger-ui/index.html

5.### Run with Docker

```bash
docker-compose up --build
```

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login and get JWT token |
| GET | /api/users | Get all users |
| GET | /api/courses | Get all courses (with search & pagination) |
| POST | /api/courses | Create course |
| PUT | /api/courses/{id} | Update course |
| DELETE | /api/courses/{id} | Delete course |
| POST | /api/enrollments | Enroll student to course |
| GET | /api/assignments | Get all assignments |
| POST | /api/assignments | Create assignment |
| POST | /api/submissions | Submit assignment |
| POST | /api/files/upload | Upload file |
| GET | /api/files/download/{filename} | Download file |

## Author

Saparbek Ulpan