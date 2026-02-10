# 🚀 TaskTracker - Professional Task Management Application

![Java](https://img.shields.io/badge/Java-17+-orange?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue?style=flat-square)
![JUnit](https://img.shields.io/badge/JUnit-5+-green?style=flat-square)
![SQL Server](https://img.shields.io/badge/SQL%20Server-Database-red?style=flat-square)

> A modern, multi-user task management system built with Java, featuring authentication, database persistence, and comprehensive testing.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage Guide](#usage-guide)
- [Architecture](#architecture)
- [Testing](#testing)
- [Technology Stack](#technology-stack)
- [Learning Outcomes](#learning-outcomes)
- [Future Roadmap](#future-roadmap)
- [Contributing](#contributing)

---

## 📖 Overview

**TaskTracker** is a console-based task management application that allows users to create, update, manage, and track their tasks with persistent storage in a SQL Server database.

Built as a learning project based on the [roadmap.sh Task-Tracker Challenge](https://roadmap.sh/projects/task-tracker), this application demonstrates **professional Java development practices** including:

- ✅ Clean Object-Oriented Design (OOP)
- ✅ Design Patterns (Repository, Dependency Injection, Fake Objects)
- ✅ Multi-user Authentication & Authorization
- ✅ Database Integration with JDBC
- ✅ Comprehensive Unit Testing (JUnit 5 & Mockito)
- ✅ Input Validation & Error Handling
- ✅ Modern Java Features (Records, Enums, Pattern Matching)

---

## ⭐ Features

### Core Functionality
- ✅ **User Authentication** - Register and login with password hashing
- ✅ **Task Management** - Create, read, update, and delete tasks
- ✅ **Status Tracking** - Track task status (TODO, PROGRESS, DONE)
- ✅ **Filtering** - Filter tasks by status or view all tasks
- ✅ **Timestamps** - Automatic creation and update timestamps for all tasks
- ✅ **Multi-User Support** - Each user has isolated tasks
- ✅ **Persistent Storage** - All data stored in SQL Server database

### Technical Features
- ✅ **Repository Pattern** - Abstracted data access layer
- ✅ **Dependency Injection** - Loose coupling between components
- ✅ **Input Validation** - Robust input validation and error messages
- ✅ **Test Doubles** - Mock objects for unit testing
- ✅ **Type Safety** - Records and strong typing throughout

---

## 📁 Project Structure

```
TaskTracker/
├── src/
│   ├── main/java/org/example/
│   │   ├── Main.java                              # Application entry point
│   │   ├── Login/
│   │   │   ├── User.java                          # User record (Java 16+)
│   │   │   ├── UserService.java                   # Login/registration logic
│   │   │   ├── UserLoginManager.java              # Login flow controller
│   │   │   ├── SqlUserRepository.java             # DB operations for users
│   │   │   ├── PasswordService.java               # Password hashing (BCrypt)
│   │   │   └── Interface/
│   │   │       ├── UserRepository.java            # User repository interface
│   │   │       └── PasswordCreate.java            # Password service interface
│   │   ├── Task/
│   │   │   ├── Task.java                          # Task model
│   │   │   ├── TaskManager.java                   # Task business logic
│   │   │   ├── SystemManager.java                 # Main application flow
│   │   │   ├── TaskRepositoryImp.java             # DB operations for tasks
│   │   │   ├── UserQuestions.java                 # Console input/output
│   │   │   └── Interface/
│   │   │       ├── TaskRepository.java            # Task repository interface
│   │   │       └── FakeTaskRepository.java        # Mock repository for testing
│   │   ├── SQL/
│   │   │   ├── JdbcConnectionProvider.java        # JDBC connection factory
│   │   │   ├── SqlServerConnection.java           # SQL Server connection wrapper
│   │   │   └── Interface/
│   │   │       ├── DatabaseConnection.java       # DB connection interface
│   │   │       └── ConnectionProvider.java       # Connection provider interface
│   │   └── Enum/
│   │       └── TaskEnum.java                      # Status and Action enums
│   │
│   └── test/java/org/example/
│       ├── Task/
│       │   ├── TaskManagerTest.java               # Task manager unit tests
│       │   ├── UserQuestionsTest.java             # Input validation tests
│       │   └── Interface/
│       │       └── FakeTaskRepository.java        # Mock repository
│       └── Login/
│           └── LoginTest.java                     # Login/authentication tests
│
├── pom.xml                                        # Maven configuration
└── README.md                                      # This file
```

---

## 🚀 Getting Started

### Prerequisites

- **Java 17+** (or higher)
- **Maven 3.8+**
- **SQL Server** (or compatible database)
- **Git**

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/DKuss1994/TaskTracker.git
   cd TaskTracker
   ```

2. **Configure Database**
   - Ensure SQL Server is running
   - Update connection settings in `JdbcConnectionProvider.java`:
   ```java
   String url = "jdbc:sqlserver://localhost:1433;databaseName=TaskTracker";
   String user = "your_username";
   String password = "your_password";
   ```

3. **Create Database Schema**
   ```sql
   -- Create users table
   CREATE TABLE users (
       userID INT PRIMARY KEY IDENTITY(1,1),
       userName VARCHAR(100) UNIQUE NOT NULL,
       password VARCHAR(255) NOT NULL,
       role VARCHAR(50) DEFAULT 'USER'
   );

   -- Create tasks table
   CREATE TABLE tasks (
       taskID INT PRIMARY KEY IDENTITY(1,1),
       userID INT NOT NULL,
       description VARCHAR(500) NOT NULL,
       status VARCHAR(50) DEFAULT 'TODO',
       created_at TIMESTAMP DEFAULT GETDATE(),
       updated_at TIMESTAMP DEFAULT GETDATE(),
       FOREIGN KEY (userID) REFERENCES users(userID)
   );
   ```

4. **Build the Project**
   ```bash
   mvn clean install
   ```

5. **Run the Application**
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

---

## 📖 Usage Guide

### Starting the Application

```bash
$ java -jar TaskTracker.jar
# or
$ mvn exec:java -Dexec.mainClass="org.example.Main"
```

### Login/Registration Flow

```
Login or Registration or Exit: LOGIN
Username: maxmusername
Password: ••••••••
Welcome maxmusername
```

### Main Menu

Once logged in, you'll see the main menu:

```
What do u want? (ADD,DELETE,CHANGE,SHOW,EXIT): ADD
Description about it: Complete project documentation
Task successfully added
```

### Available Commands

#### **ADD** - Create a New Task
```
ADD
→ Description about it: Buy groceries
→ Task successfully added
```
Creates a new task with status `TODO` and current timestamp.

#### **SHOW** - View Tasks
```
SHOW
→ What do u want see? Status: (DONE,PROGRESS,TODO) or (ALL): ALL
TaskID: 1, Description: Buy groceries, Status: TODO, Create Time: 2026-02-10..., Last change time: 2026-02-10...
TaskID: 2, Description: Complete project, Status: PROGRESS, Create Time: 2026-02-09..., Last change time: 2026-02-10...
```

#### **CHANGE** - Update a Task
```
CHANGE
→ [Shows all tasks first]
→ We need the taskID: 1
→ Change Description? (YES/NO): YES
→ Your new Description: Buy groceries and milk
→ Do u want change Status? (YES/NO): YES
→ Description about Status.(DONE,PROGRESS,TODO): DONE
```

#### **DELETE** - Remove a Task
```
DELETE
→ [Shows all tasks first]
→ Take someone of the taskID number too delete the task: 1
→ TaskID: 1 successful delete.
```

#### **EXIT** - Save and Exit
```
EXIT
→ Bye 👋
```

---

## 🏗️ Architecture

### Layer Structure

```
┌─────────────────────────────────┐
│   Console UI / UserQuestions    │  ← User Input/Output
├─────────────────────────────────┤
│   SystemManager / TaskManager   │  ← Business Logic
├─────────────────────────────────┤
│   Repository Pattern            │  ← Data Access Abstraction
│   (TaskRepository Interface)    │
├─────────────────────────────────┤
│   SQL / JDBC Connection         │  ← Database Layer
├───────────────────────────────��─┤
│   SQL Server Database           │  ← Persistent Storage
└─────────────────────────────────┘
```

### Design Patterns Used

#### **Repository Pattern**
Abstracts data access, allowing easy swapping between different data sources:
```java
public interface TaskRepository {
    void addTaskDB(int userID, Task task);
    Task findeTaskByUserIDAndTaskID(int userID, int taskID);
    List<Task> findTasksByUserId(int userID);
    // ... more methods
}
```

#### **Dependency Injection**
Constructor injection for loose coupling:
```java
public TaskManager(User user, TaskRepository taskRepository) {
    this.userID = user.id();
    this.taskRepository = taskRepository;
}
```

#### **Fake Objects for Testing**
Test doubles to avoid database dependencies:
```java
TaskRepository fakeTask = new FakeTaskRepository();
TaskManager taskManager = new TaskManager(user, fakeTask);
```

#### **Enum-based State Management**
Type-safe status and action handling:
```java
public enum Status {
    TODO, PROGRESS, DONE, ALL
}

public enum Action {
    ADD, DELETE, CHANGE, SHOW, EXIT, LOGIN, REGISTRATION
}
```

---

## 🧪 Testing

### Test Coverage

The project includes comprehensive unit tests using **JUnit 5** and **Mockito**:

#### **TaskManagerTest** (9 test cases)
- ✅ Adding single and multiple tasks
- ✅ Deleting tasks
- ✅ Changing task descriptions
- ✅ Changing task status
- ✅ Filtering tasks by status
- ✅ Error handling (non-existent tasks)

#### **UserQuestionsTest** (11 test cases)
- ✅ Valid action input (ADD, DELETE, CHANGE, SHOW, EXIT)
- ✅ Case-insensitive input handling
- ✅ Invalid input handling with retry
- ✅ Status input validation
- ✅ Description validation (non-empty)

#### **LoginTest** (4 test cases)
- ✅ Successful login with correct credentials
- ✅ Failed login with wrong password
- ✅ Failed login with non-existent user
- ✅ Database repository mocking with Mockito

### Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=TaskManagerTest

# Run with coverage report
mvn jacoco:report
```

### Example Test

```java
@Test
void addTaskInTheDBTest() {
    taskManager1.add("Buy milk");
    Assertions.assertEquals(1, fakeTask.findTasksByUserId(1).size());
    Assertions.assertEquals("Buy milk", fakeTask.findTasksByUserId(1).getFirst().getDescription());
}
```

---

## 🛠️ Technology Stack

| Layer | Technology | Purpose |
|-------|-----------|---------|
| **Language** | Java 17+ | Modern Java with Records, Pattern Matching |
| **Build Tool** | Maven 3.8+ | Dependency management and build automation |
| **Testing** | JUnit 5 | Unit testing framework |
| **Mocking** | Mockito | Mock objects for isolated testing |
| **Database** | SQL Server | Relational database |
| **Database Driver** | JDBC | Java Database Connectivity |
| **Security** | BCrypt | Password hashing |
| **Code Organization** | Interfaces | Loose coupling, dependency injection |

### Dependencies (pom.xml)
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.2</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.2.1</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>mssql-jdbc</artifactId>
    <version>12.2.0.jre11</version>
</dependency>
```

---

## 📚 Learning Outcomes

This project is designed to teach the following concepts:

### Java Fundamentals
- ✅ Object-Oriented Programming (Classes, Interfaces, Inheritance)
- ✅ Records (Java 16+ feature)
- ✅ Enums for type-safe state management
- ✅ Exception Handling & Custom Exceptions
- ✅ Collections Framework (List, HashMap)
- ✅ Stream API basics

### Design Patterns
- ✅ Repository Pattern
- ✅ Dependency Injection
- ✅ Facade Pattern (SystemManager)
- ✅ Strategy Pattern (for different repositories)

### Database & Persistence
- ✅ JDBC Connection Management
- ✅ PreparedStatements (SQL Injection Prevention)
- ✅ SQL Queries (SELECT, INSERT, UPDATE, DELETE)
- ✅ Foreign Key Relationships
- ✅ Transaction Management

### Testing & Quality
- ✅ Unit Testing with JUnit 5
- ✅ Test Doubles (Fakes, Mocks)
- ✅ Assertion Testing
- ✅ Test-Driven Development (TDD) mindset

### Software Engineering
- ✅ Code Organization & Package Structure
- ✅ Input Validation
- ✅ Error Handling & Recovery
- ✅ Console UI/UX Design
- ✅ Git Version Control

---

## 🗺️ Future Roadmap

### Phase 1: Enhancement (In Progress)
- [ ] Add Task History/Audit Trail
- [ ] Role-based Permission System (Admin/User)
- [ ] Task Priority Levels
- [ ] Task Categories/Tags
- [ ] Enhanced Error Messages with Custom Exceptions

### Phase 2: API Development
- [ ] REST API Implementation
- [ ] Spring Framework Integration
- [ ] API Documentation (Swagger/OpenAPI)
- [ ] JWT Token Authentication

### Phase 3: Frontend
- [ ] Web UI (React/Vue)
- [ ] Mobile App (Android)
- [ ] Dashboard with Analytics

### Phase 4: DevOps
- [ ] Docker Containerization
- [ ] CI/CD Pipeline (GitHub Actions)
- [ ] Database Migration Tools (Flyway/Liquibase)
- [ ] Logging & Monitoring (SLF4J, Logback)

See the [open GitHub Issue #4](https://github.com/DKuss1994/TaskTracker/issues/4) for detailed roadmap.

---

## 🤝 Contributing

We welcome contributions! Here's how to get started:

### Steps to Contribute

1. **Fork the repository**
   ```bash
   git clone https://github.com/DKuss1994/TaskTracker.git
   cd TaskTracker
   ```

2. **Create a feature branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make your changes** and add tests
   ```bash
   # Edit files
   # Add/update tests
   mvn test
   ```

4. **Commit your changes**
   ```bash
   git commit -m "feat: Add your feature description"
   ```

5. **Push to your fork**
   ```bash
   git push origin feature/your-feature-name
   ```

6. **Open a Pull Request** on GitHub
   - Describe your changes
   - Link any related issues
   - Ensure tests pass

### Code Standards
- Follow Java naming conventions
- Write clear, self-documenting code
- Add JavaDoc for public methods
- Write unit tests for new features
- Keep methods small and focused

---

## 📝 License

This project is open source and available under the **MIT License**.

---

## 📞 Support & Questions

- 📧 **Issues**: Use [GitHub Issues](https://github.com/DKuss1994/TaskTracker/issues)
- 💬 **Discussions**: Open a GitHub Discussion
- 📖 **Documentation**: See this README and code comments

---

## 🌟 Acknowledgments

- Built following [roadmap.sh Task-Tracker Challenge](https://roadmap.sh/projects/task-tracker)
- Inspired by professional Java development best practices
- Thanks to the Java community for excellent tools and frameworks

---

**Created with ❤️ by [DKuss1994](https://github.com/DKuss1994)**

Last Updated: February 10, 2026
