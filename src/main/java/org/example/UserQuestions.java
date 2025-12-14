package org.example;

import java.util.Scanner;


public class UserQuestions {
    private final Scanner sc;
    TaskManager taskManager = new TaskManager();


    public UserQuestions(Scanner sc) {
        this.sc = sc;
    }

    public Enum.Action userAction() {
        while (true) {
            System.out.print("What do u want? (ADD,DELETE,SEARCH,CHANGE,INFO,SHOW,EXIT) ");
            String input = sc.nextLine().trim().toUpperCase();
            try {
                return Enum.Action.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }
        }
    }


    public String userDescription(String text) {
        System.out.print(text);
        while (true) {
            String userText = sc.nextLine().trim();
            if (!userText.isEmpty()) {
                return userText;
            }
            System.out.println("Description must not be empty.");
        }
    }


    public Enum.Status userStatusDescription() {
        while (true) {
            System.out.print("Description about Status.(DONE,PROGRESS,TODO) ");
            String input = sc.nextLine().trim().toUpperCase();
            try {
                return Enum.Status.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal input.");
            }
        }
    }


    public int userKey(String text) {
        while (true) {
            System.out.println(text);

            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input < 0) {
                    System.out.println("Number are negativ.");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }


}