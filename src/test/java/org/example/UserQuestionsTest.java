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
        Action result = userQuestions.userAction(fake);


    }
    @Test
    public void WrongThamADDTest() {
        String simultan = "wrong\nadd\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(Action.ADD, result);

    }
    @Test
    public void ADDThanWrongTest() {
        String simultan = "add\nwrong\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(Action.ADD, result);

    }
    @Test
    public void DeleteTest() {
        String simultan = "DeLeTe\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(Action.DELETE, result);

    }
    @Test
    public void SearchTest() {
        String simultan = "seARch\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(Action.SEARCH, result);

    }
    @Test
    public void ChangeTest() {
        String simultan = "change\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(Action.CHANGE, result);

    }
    @Test
    public void ExitTest() {
        String simultan = "exIt\n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(Action.EXIT, result);

    }
    @Test
    public void infoTest() {
        String simultan = "INFO       \n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(Action.INFO, result);

    }
    @Test
    public void showTest() {
        String simultan = "            show       \n";
        Scanner fake = new Scanner(new ByteArrayInputStream(simultan.getBytes()));
        UserQuestions userQuestions = new UserQuestions(fake);
        Action result = userQuestions.userAction(fake);
        Assertions.assertEquals(Action.SHOW, result);

    }

}

