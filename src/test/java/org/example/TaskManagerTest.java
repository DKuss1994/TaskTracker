package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TaskManagerTest {
    TaskManager taskManager = new TaskManager();
    @Test
    void addListTaskTest() {
        String text = "Hello";
        taskManager.add(text);
        Assertions.assertEquals(taskManager.getTaskMap().get(1).getDescription(),text);


    }
    @Test
    void addListMoreTaskTest() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals(taskManager.getTaskMap().get(3).getDescription(),text2);


    }
    @Test
    void addStatusTest() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals(taskManager.getTaskMap().get(1).getStatus(), Enum.Status.TODO);


    }
    @Test
    void addStatus3Test() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals(taskManager.getTaskMap().get(3).getStatus(), Enum.Status.TODO);


    }

    @Test
    void addTimeTest() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals(taskManager.getTaskMap().get(3).getTime(), "12.11.2025");


    }
    @Test
    void addUpdateTest() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals(taskManager.getTaskMap().get(3).getUpdate(), "12.11.2025");


    }
    @Test
    void deletTest(){
        taskManager.add("hello");
        taskManager.delete(1);
        Assertions.assertNull(taskManager.getTaskMap().get(1));
    }
    @Test
    void deletTest2(){
        taskManager.add("hello");
        taskManager.add("hello2");
        taskManager.add("hello3");
        taskManager.delete(1);
        Assertions.assertNull(taskManager.getTaskMap().get(1));
    }

}

