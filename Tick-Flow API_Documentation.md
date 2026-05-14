# TickFlow API Documentation
To ensure a seamless integration and clear understanding of the backend services, this project utilizes **Swagger (OpenAPI 3)** for API documentation. It provides a visual interface that allows you to interact with the API's resources without having any implementation logic in place.

### Accessing the Swagger UI
Once the application is running locally, you can access the interactive documentation at:

* **Swagger UI:** [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

### How to Use:
1. Start the Spring Boot application.
2. Open your browser and navigate to the Swagger UI link provided above.
3. From the dashboard, you can explore all available endpoints, see required request bodies, and test the API directly.
## Base URL
```http
http://localhost:8080/api/tasks
```
---

# Endpoints

## Create Task

```http
POST /api/tasks
```

### Request Body

```json
{
  "title": "Study Java",
  "description": "Practice Spring Boot CRUD",
  "dueDate": "2026-05-20",
  "status": "TODO",
  "priority": "HIGH",
  "tag": "WORK"
}
```

### Response

```http
201 Created
```

---

## Get All Tasks

```http
GET /api/tasks
```

### Response

```http
200 OK
```

---

## Get Task By ID

```http
GET /api/tasks/{id}
```

### Example

```http
GET /api/tasks/1
```

### Response

```http
200 OK
```

---

## Update Task

```http
PUT /api/tasks/{id}
```

### Example

```http
PUT /api/tasks/1
```

### Request Body

```json
{
  "title": "Study Spring Boot",
  "description": "Updated task description",
  "dueDate": "2026-05-25",
  "status": "IN_PROGRESS",
  "priority": "MEDIUM",
  "tag": "WORK"
}
```

### Response

```http
200 OK
```

---

## Delete Task

```http
DELETE /api/tasks/{id}
```

### Example

```http
DELETE /api/tasks/1
```

### Response

```http
204 No Content
```
