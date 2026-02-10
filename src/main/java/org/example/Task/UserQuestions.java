package org.example.Task;

import org.example.Enum.TaskEnum;

import java.util.Scanner;


public record UserQuestions(Scanner sc) {

    public TaskEnum.Action userAction(String text) {
        while (true) {
            System.out.print(text);
            String input = sc.nextLine().trim().toUpperCase();
            try {
                return TaskEnum.Action.valueOf(input);
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


    public TaskEnum.Status userStatusDescription(String text) {
        while (true) {
            System.out.print(text);
            String input = sc.nextLine().trim().toUpperCase();
            try {
                return TaskEnum.Status.valueOf(input);
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