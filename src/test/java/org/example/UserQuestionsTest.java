package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;


public class UserQuestionsTest {

    @Test
    public void AddTest() {
        String simultan = "add\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(UserQuestions.Action.ADD,result);


    }
    @Test
    public void WrongThanADDTest() {
        String simultan = "wrong\nadd\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(UserQuestions.Action.ADD, result);

    }
    @Test
    public void ADDThanWrongTest() {
        String simultan = "add\nwrong\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(UserQuestions.Action.ADD, result);

    }
    @Test
    public void DeleteTest() {
        String simultan = "DeLeTe\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(UserQuestions.Action.DELETE, result);

    }
    @Test
    public void SearchTest() {
        String simultan = "seARch\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(UserQuestions.Action.SEARCH, result);

    }
    @Test
    public void ChangeTest() {
        String simultan = "change\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(UserQuestions.Action.CHANGE, result);

    }
    @Test
    public void ExitTest() {
        String simultan = "exIt\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(UserQuestions.Action.EXIT, result);

    }
    @Test
    public void infoTest() {
        String simultan = "INFO       \n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(UserQuestions.Action.INFO, result);

    }
    @Test
    public void showTest() {
        String simultan = "            show       \n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(UserQuestions.Action.SHOW, result);

    }
    @Test
    public void userDescriptionTest() {
        String simultan = "Hello!";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        String result = userQuestions.userDescription(fake);
        Assertions.assertEquals("Hello!", result);

    }
    @Test
    public void userDescriptionTestMoreText() {
        String simultan = "Hello World!";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        String result = userQuestions.userDescription();
        Assertions.assertEquals("Hello World!", result);

    }
    @Test
    public void userDescriptionTestIsEmpty() {
        String simultan = "\nHello";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        String result = userQuestions.userDescription();
        Assertions.assertEquals("Hello", result);

    }
    @Test
    public void userDescriptionTestSpaceIsEmpty() {
        String simultan = "          \nHello";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        String result = userQuestions.userDescription();
        Assertions.assertEquals("Hello", result);

    }
    @Test
    public void userStatusDescriptionTest() {
        String simultan = "done\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Status result = userQuestions.userStatusDescription(fake);
        Assertions.assertEquals(UserQuestions.Status.DONE, result);


    }
    @Test
    public void userStatusDescriptionWrongTest() {
        String simultan = "WASWS\nPROGRESS";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        UserQuestions.Status result = userQuestions.userStatusDescription(fake);
        Assertions.assertEquals(UserQuestions.Status.PROGRESS, result);


    }

}

