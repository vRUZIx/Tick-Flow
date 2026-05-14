# TickFlow API Documentation

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

---

# Filter and Search

## Filter by Status

```http
GET /api/tasks?status=TODO
```

---

## Filter by Priority

```http
GET /api/tasks?priority=HIGH
```

---

## Filter by Tag

```http
GET /api/tasks?tag=WORK
```

---

## Search by Title or Description

```http
GET /api/tasks?search=java
```

---

## Combined Filter and Search

```http
GET /api/tasks?status=TODO&priority=HIGH&tag=WORK&search=java
```

### Example Response

```json
[
  {
    "id": 1,
    "title": "Study Java",
    "description": "Practice Spring Boot CRUD",
    "dueDate": "2026-05-20",
    "createdAt": "2026-05-14",
    "status": "TODO",
    "priority": "HIGH",
    "tag": "WORK"
  }
]
```

---

# Enum Values

## Status

```text
TODO
IN_PROGRESS
DONE
```

## Priority

```text
LOW
MEDIUM
HIGH
```

## Tag

```text
WORK
PERSONAL
SHOPPING
```
