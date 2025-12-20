# Task Manager Console Application

This project is a simple console based task manager written in Java.
The application allows users to manage tasks directly from the command line and stores all data persistently in a JSON file.

This project was built as part of the task from the roadmap.sh project list
https://roadmap.sh/projects/task-tracker

The project focuses on clean object oriented design, enum usage, input validation and unit testing with JUnit.

## Overview

This application allows you to

1. Create tasks with a description
2. Update existing tasks
3. Change task status
4. Delete tasks by ID
5. Filter tasks by status
6. Automatically save and load tasks using JSON
7. Interact through a simple console interface

## Project Structure

### org.example

### Main  
Entry point of the application  
Starts the SystemManager

### SystemManager  
Controls the full application flow  
Handles user interaction  
Loads tasks on startup  
Saves tasks on shutdown

### Task  
Represents a single task  
Contains description, status, creation time and last update time  
Supports JSON serialization and deserialization

### TaskManager  
Stores all tasks in a TreeMap  
Responsible for adding, deleting and updating tasks  
Manages task IDs and status changes

### UserQuestions  
Handles all console input  
Validates user actions, descriptions, status input and numeric IDs

### Enum  
Contains all application enums

#### Status  
TODO  
PROGRESS  
DONE  
ALL

#### Action  
ADD  
DELETE  
CHANGE  
SHOW  
EXIT  
YES  
NO

## How the Application Works

When the application starts, it checks if a file called `tasks.json` exists.

1. If the file exists, all tasks are loaded automatically
2. If the file does not exist, the application starts with an empty task list
3. The user interacts with the application via console commands
4. When the application exits, all tasks are saved automatically

## Available Console Actions

### ADD  
Creates a new task with a description

### SHOW  
Displays tasks filtered by status or shows all tasks

### CHANGE  
Changes the description of a task  
Optionally allows updating the task status

### DELETE  
Deletes a task by its ID

### EXIT  
Exits the application and saves all tasks

## Task Status Values

### TODO  
Task is newly created

### PROGRESS  
Task is currently being worked on

### DONE  
Task is completed

### ALL  
Used only for displaying all tasks

## Data Persistence

All tasks are stored in a file called `tasks.json`.

1. Tasks are saved automatically when the application exits
2. Tasks are stored in JSON format
3. Each task contains description, status, creation time and update time
4. Tasks are restored automatically on the next start

## Testing

The project uses JUnit 5 for automated testing.

### TaskManagerTest covers

1. Adding tasks
2. Deleting tasks
3. Updating task descriptions
4. Default task status handling
5. Task collection size validation

### UserQuestionsTest covers

1. Valid user actions
2. Invalid input handling
3. Case insensitive input
4. Status input validation

## Requirements

1. Java 17 or higher
2. JUnit 5
3. org.json library

## Purpose of This Project

This project was built as a learning and practice application to improve skills in

1. Object oriented programming
2. Enum based state management
3. Console application design
4. JSON based persistence
5. Unit testing with JUnit