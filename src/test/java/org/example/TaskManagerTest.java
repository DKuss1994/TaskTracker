package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TaskManagerTest {
    TaskManager taskManager = new TaskManager();
    @Test
    void addListTaskTest() {
        String text = "Hello";
        taskManager.add(text);
        Assertions.assertEquals(text, taskManager.getTaskMap().get(1).getDescription());


    }
    @Test
    void addListMoreTaskTest() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals(text2, taskManager.getTaskMap().get(3).getDescription());


    }
    @Test
    void addStatusTest() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals(Enum.Status.TODO, taskManager.getTaskMap().get(1).getStatus());


    }
    @Test
    void addStatus3Test() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals(Enum.Status.TODO, taskManager.getTaskMap().get(3).getStatus());


    }

    @Test
    void addTimeTest() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals("12.11.2025", taskManager.getTaskMap().get(3).getTime());


    }
    @Test
    void addUpdateTest() {
        String text = "Hello";
        String text2 = "WOW!";
        taskManager.add(text);
        taskManager.add(text);
        taskManager.add(text2);
        Assertions.assertEquals("12.11.2025", taskManager.getTaskMap().get(3).getUpdate());


    }
    @Test
    void deleteTest(){
        taskManager.add("hello");
        taskManager.delete(1);
        Assertions.assertNull(taskManager.getTaskMap().get(1));
    }
    @Test
    void deleteTest2(){
        taskManager.add("hello");
        taskManager.add("hello2");
        taskManager.add("hello3");
        taskManager.delete(1);
        Assertions.assertNull(taskManager.getTaskMap().get(1));
    }
    @Test
    void deleteTrueTest(){
        taskManager.add("hello");
        taskManager.add("hello2");
        taskManager.add("hello3");
        boolean test = taskManager.delete(1);
        Assertions.assertTrue(test);
    }
    @Test
    void deleteFalseTest(){
        taskManager.add("hello");
        taskManager.add("hello2");
        taskManager.add("hello3");
        boolean test = taskManager.delete(1);
        boolean test2 = taskManager.delete(1);
        Assertions.assertFalse(test2);
    }

}

