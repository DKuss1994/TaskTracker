package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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
    void changeTest() {
        String text = "Hello";
        String text2 = "WOW!";
        String change = "BYB";
        taskManager.add(text);
        taskManager.changeTask(1,change);
        taskManager.add(text2);
        Assertions.assertEquals(change, taskManager.getTask(1).getDescription());;



    }

}