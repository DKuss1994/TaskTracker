package org.example.Task;

import org.example.Enum.Enum;
import org.example.Login.User;
import org.example.Task.Interface.FakeTaskRepository;
import org.example.Task.Interface.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


public class TaskManagerTest {
    TaskManager taskManager = new TaskManager();

    @Test
    void addListTaskTest() {
        String text = "Hello";
        taskManager.add(text);
        Assertions.assertTrue(taskManager.containsKey(1));
        Assertions.assertEquals(1, taskManager.mapSize());
        Assertions.assertEquals(text, taskManager.getTask(1).getDescription());


    }

    @Test
    void addListMoreTaskTest() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertTrue(taskManager.containsKey(3));
        Assertions.assertEquals(3, taskManager.mapSize());
        Assertions.assertEquals(text2, taskManager.getTask(3).getDescription());


    }

    @Test
    void addStatusTest() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertTrue(taskManager.containsKey(1));
        Assertions.assertEquals(3, taskManager.mapSize());
        Assertions.assertEquals(Enum.Status.TODO, taskManager.getTask(1).getStatus());


    }

    @Test
    void addStatus3Test() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals(Enum.Status.TODO, taskManager.getTask(3).getStatus());


    }

    @Test
    void deleteTest() {
        taskManager.add("hello");
        taskManager.delete(1);
        Assertions.assertNull(taskManager.getTask(1));
    }

    @Test
    void deleteTest2() {
        taskManager.add("hello");
        taskManager.add("hello2");
        taskManager.add("hello3");
        taskManager.delete(1);
        Assertions.assertNull(taskManager.getTask(1));
    }


    @Test
    void getAllTasks_shouldReturnAllTasks() {

        taskManager.add("A");
        taskManager.add("B");
        Map<Integer, Task> allTask = taskManager.getMap();
        Assertions.assertEquals(2, allTask.size());
    }
    @Test
    void getAllTaskFromUserID(){
        User user = new User(1,"Max","123456");
        TaskRepository fakeTask = new FakeTaskRepository();
        TaskManager taskManager1 = new TaskManager(user,fakeTask);
        taskManager1.add("Cook water");
        List<Task> tasks = taskManager1.getAllTask();
        Assertions.assertNotNull(tasks);
        System.out.println(tasks.getFirst().getDescription());
        Assertions.assertFalse(tasks.isEmpty());
        Assertions.assertEquals("Cook water",tasks.getFirst().getDescription());
    }
    @Test
    void getAllTaskFromUserIDMoreTask(){
        User user = new User(1,"Max","123456");
        TaskRepository fakeTask = new FakeTaskRepository();
        TaskManager taskManager1 = new TaskManager(user,fakeTask);
        taskManager1.add("Cook water");
        taskManager1.add("Cook milk");
        List<Task> tasks = taskManager1.getAllTask();
        Assertions.assertNotNull(tasks);
        Assertions.assertFalse(tasks.isEmpty());
        Assertions.assertEquals("Cook water",tasks.get(0).getDescription());
        Assertions.assertEquals("Cook milk",tasks.get(1).getDescription());
    }
    @Test
    void addTaskInTheDBTest(){
        User user = new User(1,"Max","123456");
        FakeTaskRepository fakeTaskRepository = new FakeTaskRepository();
        TaskManager taskManager1 = new TaskManager(user,fakeTaskRepository);
        taskManager1.add("Buy milk");
        Assertions.assertEquals(1,fakeTaskRepository.findTasksByUserId(1).size());
        Assertions.assertEquals("Buy milk",fakeTaskRepository.findTasksByUserId(1).getFirst().getDescription());

    }

    @Test
    void getAllTaskStatusTODOFromUserID(){
        User user = new User(1,"Max","123456");
        TaskRepository fakeTask = new FakeTaskRepository();
        TaskManager taskManager1 = new TaskManager(user,fakeTask);
        taskManager1.add("Cook water");
        List<Task> tasks = taskManager1.getAllTask();
        Assertions.assertNotNull(tasks);
        System.out.println(tasks.getFirst().getDescription());
        Assertions.assertFalse(tasks.isEmpty());
        Assertions.assertEquals(Enum.Status.TODO,tasks.getFirst().getStatus());
    }
    @Test
    void changeTaskTest(){
        User user = new User(1,"Max","123456");
        TaskRepository fakeTask = new FakeTaskRepository();
        TaskManager taskManager1 = new TaskManager(user,fakeTask);
        taskManager1.add("Cook Water");
        taskManager1.changeTask(user.getId(),1,"Cook milk");
        List<Task> allTask = taskManager1.getAllTask();
        Assertions.assertFalse(allTask.isEmpty());
        Assertions.assertEquals("Cook milk",fakeTask.findTasksByUserId(1).getFirst().getDescription());
    }


}