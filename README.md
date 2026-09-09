# Student Management System

A **Student Management System** developed using **Java and Spring Boot** that provides REST APIs for managing student records. The project follows a layered architecture and implements **Global Exception Handling** to provide consistent and meaningful error responses.

## 🚀 Features

* Create a new student
* Get all students
* Get student by ID
* Update student details
* Delete student
* Input validation
* Global Exception Handling
* Custom Exceptions
* Proper HTTP status codes
* RESTful API architecture
* MySQL database integration
* Spring Data JPA for database operations

## 🛠️ Technologies Used

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Maven**
* **REST API**
* **Git & GitHub**

## 📂 Project Structure

```text
Student-Management
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.studentmanagement
│   │   │       │
│   │   │       ├── controller
│   │   │       │   └── StudentController.java
│   │   │       │
│   │   │       ├── service
│   │   │       │   └── StudentService.java
│   │   │       │
│   │   │       ├── repository
│   │   │       │   └── StudentRepository.java
│   │   │       │
│   │   │       ├── entity
│   │   │       │   └── StudentData.java
│   │   │       │
│   │   │       ├── exception
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── StudentNotFoundException.java
│   │   │       │
│   │   │       └── StudentManagementApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

> Package and class names may differ depending on the actual project implementation.

## 🏗️ Architecture

The project follows a layered architecture:

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL Database
```

Exception handling is implemented separately:

```text
Exception
    ↓
GlobalExceptionHandler
    ↓
Error Response
    ↓
Client
```

## ⚠️ Global Exception Handling

The project uses:

* `@RestControllerAdvice`
* `@ExceptionHandler`
* Custom Exceptions
* `ResponseEntity`

### Custom Exception

```java
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}
```

### Global Exception Handler

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFound(
            StudentNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(
            IllegalArgumentException ex) {

        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }
}
```

This allows exceptions from different controllers to be handled in one centralized location.

## 🔄 Exception Handling Flow

For example, if a student with ID `100` does not exist:

```text
GET /students/100
        ↓
StudentController
        ↓
StudentService
        ↓
StudentNotFoundException
        ↓
GlobalExceptionHandler
        ↓
HTTP 404 NOT_FOUND
```

Example response:

```text
Student not found with id: 100
```

## 📡 REST API Endpoints

### Create Student

```http
POST /students
```

Example request:

```json
{
    "name": "Rahul",
    "age": 22,
    "email": "rahul@gmail.com"
}
```

### Get All Students

```http
GET /students
```

### Get Student By ID

```http
GET /students/{id}
```

Example:

```http
GET /students/1
```

### Update Student

```http
PUT /students/{id}
```

Example request:

```json
{
    "name": "Rahul Kumar",
    "age": 23,
    "email": "rahulkumar@gmail.com"
}
```

### Delete Student

```http
DELETE /students/{id}
```

Example:

```http
DELETE /students/1
```

> Update the endpoint paths above if your actual controller uses different mappings.

## 🗄️ Database Configuration

Configure your MySQL database in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=9092
```

**Important:** Do not commit your actual database password or other sensitive information to GitHub.

## ▶️ How to Run the Application

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/student-management-global-exception-handling.git
```

### 2. Navigate to the Project Directory

```bash
cd Student-Management
```

### 3. Start the Application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

For Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start on:

```text
http://localhost:9092
```

### 4. Configure MySQL

Make sure MySQL is running and configure your database details in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=9092
```

After starting the application, you can test the REST APIs using **Postman** or another REST API client.

## 🧪 Testing

You can test the APIs using:

* Postman
* Swagger/OpenAPI, if configured
* Any REST API client

Example:

```text
GET http://localhost:9092/students
```

Example:

```text
GET http://localhost:9092/students/1
```

## 📋 HTTP Status Codes

| Status Code                 | Meaning                      |
| --------------------------- | ---------------------------- |
| `200 OK`                    | Request successful           |
| `201 CREATED`               | Student successfully created |
| `400 BAD REQUEST`           | Invalid request/input        |
| `404 NOT FOUND`             | Student not found            |
| `500 INTERNAL SERVER ERROR` | Unexpected server error      |

## 🎯 Learning Objectives

This project demonstrates practical knowledge of:

* Java
* Spring Boot
* REST API development
* Spring Data JPA
* Hibernate
* MySQL
* CRUD Operations
* Layered Architecture
* Custom Exceptions
* Global Exception Handling
* HTTP Status Codes
* API Testing

## 🔮 Future Enhancements

Possible future improvements:

* Add Spring Boot Validation
* Add DTO and Mapper layers
* Add Swagger/OpenAPI documentation
* Add Spring Security
* Add JWT Authentication
* Add Pagination and Sorting
* Add Unit Testing using JUnit and Mockito
* Add frontend using React or Angular

## 👨‍💻 Author

**Bichitra Gouda**

## 📄 License

This project is created for learning and demonstration purposes.
