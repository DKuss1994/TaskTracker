package org.example.Task;

import org.example.Enum.TaskEnum;
import org.example.Login.User;
import org.example.Task.Interface.FakeTaskRepository;
import org.example.Task.Interface.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TaskManagerTest {
    User user = new User(1, "Max", "123456");
    TaskRepository fakeTask = new FakeTaskRepository();
    TaskManager taskManager1 = new TaskManager(user, fakeTask);

    @Test
    void getAllTaskFromUserID() {
        taskManager1.add("Cook water");
        List<Task> tasks = taskManager1.getAllTask();
        Assertions.assertNotNull(tasks);
        System.out.println(tasks.getFirst().getDescription());
        Assertions.assertFalse(tasks.isEmpty());
        Assertions.assertEquals("Cook water", tasks.getFirst().getDescription());
    }

    @Test
    void getAllTaskFromUserIDMoreTask() {
        taskManager1.add("Cook water");
        taskManager1.add("Cook milk");
        List<Task> tasks = taskManager1.getAllTask();
        Assertions.assertNotNull(tasks);
        Assertions.assertFalse(tasks.isEmpty());
        Assertions.assertEquals("Cook water", tasks.get(0).getDescription());
        Assertions.assertEquals("Cook milk", tasks.get(1).getDescription());
    }

    @Test
    void addTaskInTheDBTest() {
        taskManager1.add("Buy milk");
        Assertions.assertEquals(1, fakeTask.findTasksByUserId(1).size());
        Assertions.assertEquals("Buy milk", fakeTask.findTasksByUserId(1).getFirst().getDescription());
    }

    @Test
    void deleteTaskInTheDBTest() {
        taskManager1.add("Buy milk");
        taskManager1.delete(user.id(), 1);
        List<Task> tasks = taskManager1.getAllTask();
        Assertions.assertTrue(fakeTask.findTasksByUserId(user.id()).isEmpty());
        Assertions.assertTrue(tasks.isEmpty());
    }
    @Test
    void deleteTaskInTheDBTest2() {
        taskManager1.add("Buy milk");
        taskManager1.add("Buy water");
        taskManager1.delete(user.id(), 1);
        List<Task> tasks = taskManager1.getAllTask();
        Assertions.assertEquals(1, fakeTask.findTasksByUserId(1).size());
        Assertions.assertEquals("Buy water",tasks.getFirst().getDescription());
        Assertions.assertEquals(2, tasks.getFirst().getTaskID());
    }
    @Test
    void deleteTaskInTheDBTest3() {
        taskManager1.add("Buy milk");

        Assertions.assertThrows(IllegalArgumentException.class,()-> {
            taskManager1.delete(user.id(), 99999);
        });
    }

    @Test
    void getAllTaskStatusTODOFromUserID() {
        taskManager1.add("Cook water");
        List<Task> tasks = taskManager1.getAllTask();
        Assertions.assertNotNull(tasks);
        System.out.println(tasks.getFirst().getDescription());
        Assertions.assertFalse(tasks.isEmpty());
        Assertions.assertEquals(TaskEnum.Status.TODO, tasks.getFirst().getStatus());
    }

    @Test
    void changeTaskTest() {
        taskManager1.add("Cook Water");
        taskManager1.changeTask(user.id(), 1, "Cook milk");
        List<Task> allTask = taskManager1.getAllTask();
        Assertions.assertFalse(allTask.isEmpty());
        Assertions.assertEquals("Cook milk", fakeTask.findTasksByUserId(1).getFirst().getDescription());
    }

    @Test
    void changeStatusTest() {
        taskManager1.add("Cook Water");
        TaskEnum.Status done = TaskEnum.Status.DONE;
        taskManager1.changeStatus(user.id(), 1, done);
        List<Task> allTask = taskManager1.getAllTask();
        Assertions.assertFalse(allTask.isEmpty());
        Assertions.assertEquals(done, fakeTask.findTasksByUserId(1).getFirst().getStatus());
    }
}