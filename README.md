Task Manager Console Application

This project is a simple console based task manager written in Java.
Users can create, view, update and delete tasks.
All tasks are persisted in a JSON file and loaded automatically on startup.

The project focuses on clean object oriented design, enum usage, user input validation and unit testing with JUnit.

Features

Create new tasks with a description

Update task descriptions

Change task status

Delete tasks by ID

Filter tasks by status

Persistent storage using JSON

Console based user interaction

Unit tests for core logic and user input

Project Structure

org.example

Main
Entry point of the application

SystemManager
Controls the application flow
Handles user interaction
Loads and saves tasks from and to a JSON file

Task
Represents a single task
Contains description, status, creation time and last update time
Supports JSON serialization and deserialization

TaskManager
Manages all tasks using a map
Responsible for adding, deleting, updating tasks and changing status

UserQuestions
Handles all console input
Validates user actions, task descriptions, status input and IDs

Enum
Contains enums for application states

Status
TODO PROGRESS DONE ALL

Action
ADD DELETE CHANGE SHOW EXIT YES NO

Tests

TaskManagerTest
Tests the business logic of the task manager

UserQuestionsTest
Tests user input handling and validation

How to Use

When the application starts, it automatically loads tasks from tasks.json if the file exists.
If the file does not exist, the application starts with an empty task list.

Available console actions:

ADD
Create a new task

SHOW
Display tasks filtered by status or show all tasks

CHANGE
Change the description of a task
Optionally update the task status

DELETE
Delete a task by its ID

EXIT
Exit the application and save all tasks

Task Status Values

TODO
Task is newly created

PROGRESS
Task is currently in progress

DONE
Task is completed

ALL
Used only for filtering output

Data Persistence

All tasks are saved automatically to tasks.json when the application exits.
Tasks are stored in JSON format including all task details.
On the next startup, tasks are restored automatically.

Tests

The project uses JUnit 5 for testing.

Covered test cases include:

Adding and removing tasks

Default task status

Updating task descriptions

Valid and invalid user input handling

Requirements

Java 17 or higher
JUnit 5
org.json library

Purpose of This Project

This project is intended as a learning and practice application to improve skills in:

Object oriented programming

Enum based state management

Console user interfaces

JSON based persistence

Unit testing with JUnit
