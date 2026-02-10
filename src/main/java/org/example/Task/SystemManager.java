package org.example.Task;
import org.example.Enum.TaskEnum;
import org.example.Login.User;
import org.example.SQL.JdbcConnectionProvider;
import org.example.SQL.SqlServerConnection;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SystemManager {
    private final Scanner sc = new Scanner(System.in);
    private final UserQuestions userQuestions = new UserQuestions(sc);
    private boolean loop = true;
    private User user;
    private final TaskManager taskManager ;
    public SystemManager(User user){
        this.user = user;

        TaskRepositoryImp taskService = new TaskRepositoryImp(new SqlServerConnection(new JdbcConnectionProvider()));
        this.taskManager = new TaskManager(user, taskService);
    }

    public void start() {
        while (loop) {
            TaskEnum.Action action = userQuestions.userAction("What do u want? (ADD,DELETE,CHANGE,SHOW,EXIT) ");
            switch (action) {
                case ADD -> extractedAddUserDescription();
                case CHANGE -> extractedChangeUserDescription();
                case DELETE -> extractedDeleteUserIDAndTaskID();
                case SHOW -> extractedShow();
                case EXIT -> exit();

            }
        }
    }


    public void extractedChangeUserDescription() {
        extractedShow();
        int userID = taskManager.getUserID();
        int taskID = userQuestions.userKey("We need the taskID. ");
        TaskEnum.Action yesOrNo = userQuestions.userAction("Change Description? (YES/NO)");
        if(yesOrNo == TaskEnum.Action.YES){
            String description = userQuestions.userDescription("Your new Description. ");

            try {
                taskManager.changeTask(userID,taskID,description);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        TaskEnum.Action action = userQuestions.userAction("Do u want change Status ?(YES/NO)");
        if (Objects.requireNonNull(action) == TaskEnum.Action.YES) {
            extractedChangeStatus(userID,taskID);
        }
    }
    private void extractedChangeStatus(int userID, int taskID) {
        TaskEnum.Status status = userQuestions.userStatusDescription("Description about Status.(DONE,PROGRESS,TODO) ");
        taskManager.changeStatus(userID, taskID, status);
    }
    public void exit() {
        this.loop = false;
    }
    private void showTasks() {
        List<Task> listTask = taskManager.getAllTask();
        if (listTask.isEmpty()) {
            throw new IllegalArgumentException("Not task found! Pls add Task.");
        } else {
            for (Task task : listTask) {
                System.out.println(task.getPrintout());
            }
        }
    }
    private void showTasksStatus(TaskEnum.Status status) {
        List<Task> listTask = taskManager.getStatusTask(status);
        if (listTask.isEmpty()) {
            throw new IllegalArgumentException("Not task found! Pls add Task.");
        } else {
            for (Task task : listTask) {
                System.out.println(task.getPrintout());
            }
        }
    }

    private void extractedShow() {
        try {
            TaskEnum.Status status = userQuestions.userStatusDescription("What do u want see? Status: (DONE,PROGRESS,TODO) or (ALL) ");
            switch (status) {
                case ALL -> showTasks();
                case TODO, PROGRESS, DONE -> showTasksStatus(status);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void extractedAddUserDescription() {

        String description = userQuestions.userDescription("Description about it. ");
        try {
            taskManager.add(description);
            System.out.println("Task successfully added");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private void extractedDeleteUserIDAndTaskID() {
        try {
            showTasks();
            int taskID = userQuestions.userKey("Take someone of the taskID number too delete the task ");
            taskManager.delete(user.id(),taskID);
            System.out.println("TaskID: " + taskID + " successful delete.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Number not found. Try again.");
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

