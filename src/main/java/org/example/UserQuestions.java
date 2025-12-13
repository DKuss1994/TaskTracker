package org.example;

import java.util.Scanner;


public class UserQuestions extends Enum {
    private final Scanner sc;
    TaskManager taskManager = new TaskManager();

    public UserQuestions(Scanner sc) {
        this.sc = sc;
    }


    public Action userAction() {
        while (true) {
            System.out.print("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
            String input = sc.next().trim().toUpperCase();
            try {
                return Enum.Action.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }

        }


    }

    public Action userAction(Scanner sc) {
        while (true) {
            System.out.print("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
            String input = sc.next().trim().toUpperCase();
            try {
                return Action.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }

        }


    }


    public String userDescription(Scanner sc) {
        while (sc.hasNextLine()) {
            System.out.print("Description about it. ");
            String text = sc.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
        }
        return "";
    }

    public String userDescription() {
        while (sc.hasNextLine()) {
            System.out.print("Description about it. ");
            String text = sc.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
        }
        return "";
    }

    public Status userStatusDescription(Scanner sc) {
        while (true) {
            System.out.print("Description about Status.(DONE,PROGRESS,TODO) ");
            String input = sc.next().trim().toUpperCase();
            try {
                return Status.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }

        }


    }

    public Status userStatusDescription() {
        while (true) {
            System.out.print("Description about Status.(DONE,PROGRESS,TODO) ");
            String input = sc.next().trim().toUpperCase();
            try {
                return Status.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }

        }


    }

    public int userKeyDelete(Scanner sc) {

        while (true) {

            System.out.println(taskManager.getTaskMap().keySet());
            System.out.println("Take someone of the key number too delete the task ");

            int input = sc.nextInt();
            try {
                if (taskManager.getTaskMap().keySet().stream().allMatch(n -> n == input)) {
                    return input;
                } else {
                    System.out.println("Number not found. Try again.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }

        }


    }


    public int userKeyDelete() {

        while (true) {

            System.out.println(taskManager.getTaskMap().keySet());
            System.out.println("Take someone of the key number too delete the task ");

            int input = sc.nextInt();
            try {
                if (taskManager.getTaskMap().keySet().stream().allMatch(n -> n == input)) {
                    return input;
                } else {
                    System.out.println("Number not found. Try again.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }

        }


    }


}


