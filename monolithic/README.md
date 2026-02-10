# Monolithic Architecture Example – Task Manager

## Technologies Used

* **Java 17+**

* **Spring Boot** (Web, Data JPA, Thymeleaf)

* **H2 Database** (in-memory)

* **Maven**

## 📌 Description

This project is an **example of a monolithic application** implemented in **Java with Spring Boot**, which manages simple tasks (add, list, and complete tasks).

In a **monolithic architecture**, the entire application is developed and deployed as a single unit. This means that the frontend, backend, and database live in the same project and run together.

This example includes:

* Frontend web: User interface with Thymeleaf.

* Backend: Controllers and services with Spring Boot.

* Database: H2 in-memory database for temporary task storage.

## Project Structure
```
taskmanager-monolith/
├── src/main/java/com/example/taskmanager
│   ├── TaskManagerApplication.java      # Main class
│   ├── controller/TaskController.java  # Web controller
│   ├── model/Task.java                  # Data model
│   ├── repository/TaskRepository.java  # Database access
│   └── service/TaskService.java         # Business logic
├── src/main/resources
│   ├── application.properties           # DB & Spring configuration
│   └── templates/
│       └── index.html                   # Frontend with Thymeleaf
└── pom.xml                               # Dependencies and build

```

## Monolithic Features
### 1. Single Deployment Unit

* The entire application runs as one process.

* No independent services; frontend, backend, and database are integrated.

### 2. Simple to Start

* Easy to develop and deploy for small projects.

### 3. Tightly Coupled Components

* All layers are interconnected.

* Changes in one module can affect the whole system.

### 4. Project Example

* Frontend: Web form to add tasks.

* Backend: Logic to add, list, and complete tasks.

* Database: H2 in-memory storage for tasks.

## How to Run the Project
1. Clone the repository
```bash
    git clone https://github.com/chiwii8/Arquitecture-Pattern.git
    cd monolith
    
```

2. Run the application with maven:

```bash
    mvn spring-boot:run
```

3. Open in your browser
```
http:localhost:8080
```
