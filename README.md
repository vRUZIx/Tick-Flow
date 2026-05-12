# TickFlow

TickFlow is a lightweight task management REST API built with Spring Boot.  
The project focuses on managing daily tasks through clean CRUD operations, Docker support, CI/CD pipeline integration, and cloud deployment.

## Project Management

Trello Board: https://trello.com/invite/b/6a030cccf1b35d70050113fa/ATTI45ea57e33fa459c34ba3056a6e826567E476AA6E/tick-flow 

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- MySQL
- PostgreSQL
- H2 Database
- Docker
- GitHub Actions
- Render
- Lombok

## Features

- Create, read, update, and delete tasks
- Task categorization using enums
- Input validation
- RESTful API architecture
- H2 integration testing
- Dockerized application
- CI/CD pipeline with GitHub Actions
- Cloud deployment with Render

## Entity

### Task

The application contains a single core entity: `Task`.

Example fields:

- id
- title
- description
- status
- tag
- priority
- deadline
- created date

## API Endpoints

| Method | Endpoint | Description |
|------|----------|-------------|
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get task by ID |
| POST | `/api/tasks` | Create a new task |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |

## Local Setup

### 1. Clone repository

```bash
git clone <repository-url>
cd TickFlow
```

### 2. Configure database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tickflow
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run application

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw spring-boot:run
```

## Running Tests

The project uses H2 database for integration testing.

```bash
mvnw test
```

## Docker Setup

Run the application and MySQL database:

```bash
docker compose up --build
```

## CI/CD Pipeline

GitHub Actions workflow:

```bash
.github/workflows/ci.yml
```

Pipeline steps:

- Checkout repository
- Setup Java 17
- Cache Maven dependencies
- Run tests using `mvn clean verify`

## Collaboration Workflow

The project is developed collaboratively using a branch-based workflow.

Each contributor works on their own feature branch and creates pull requests before merging into the `master` branch.

## Deployment

The application is deployed on Render.

Deployed URL: [Add Render URL Here](#)

Environment variables:

```properties
SPRING_PROFILES_ACTIVE=prod
DATABASE_URL=<render-database-url>
```

## Project Timeline

### Day 1 — Scaffold + CRUD

- Generated Spring Boot project
- Implemented Task entity
- Added CRUD endpoints
- Added validation
- Added integration tests

### Day 2 — Docker + CI/CD

- Added Dockerfile
- Added docker-compose.yml
- Configured GitHub Actions pipeline

### Day 3 — Deploy + Polish

- Deployed application on Render
- Configured PostgreSQL
- Improved validation and error handling

### Day 4 — Presentation

- Live API demo
- CRUD demonstration
- CI/CD walkthrough
- Technical discussion

## What Is Not Included

- Authentication / Authorization
- Frontend application

## Contributor

- Ruzi Xancanov
- Revan Abushov
- Ayhan Aghayev

## License

This project is created for educational and portfolio purposes.
