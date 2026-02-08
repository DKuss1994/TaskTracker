package org.example.Login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordHashTest {
    PasswordService passwordService = new PasswordService();
    @Test
    void shouldHashPassword(){
        String password ="hello";
        String hash = passwordService.hash(password);

        Assertions.assertNotNull(hash);
        Assertions.assertFalse(hash.isEmpty());
        Assertions.assertNotEquals(password,hash);
    }
    @Test
    void shouldVerifyCorrectPassword(){
        String password = "Hello?";
        String hash = passwordService.hash(password);
        boolean result = passwordService.verify(password,hash);

        Assertions.assertTrue(result);
    }
    @Test
    void shouldRejectWrongPassword(){
        String password = "Hello?";
        String wrongPassword = "hacker";
        String hash = passwordService.hash(password);
        boolean result = passwordService.verify(wrongPassword,hash);

        Assertions.assertFalse(result);
    }

}
