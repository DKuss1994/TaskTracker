package org.example.Login;

import org.example.Login.Interface.PasswordCreate;
import org.example.Login.Interface.UserRepository;
import org.example.UserQuestions;

public class UserService {
    UserRepository userRepository;
    PasswordCreate passwordService;

    public UserService(UserRepository userRepository, PasswordCreate passwordCreate) {
        this.userRepository = userRepository;
        this.passwordService = passwordCreate;

    }

    public boolean login(String userName, String userPassword) {
        User user = userRepository.findePasswordUserIDByUserName(userName);
        if (user != null) {
            System.out.println("Welcome " + user.getUser());
            return passwordService.verify(userPassword, user.getPasswordHash());


        }
        return false;
    }

    public String passwordRegistrierung(UserQuestions userQuestions) {
        while (true) {
            String password = userQuestions.userDescription("Password: ");
            String CheckPassword = userQuestions.userDescription("Password: ");
            if (!password.equals(CheckPassword)) {
                System.out.println("Password are not the same.");
                continue;
            }
            return password;
        }
    }

    public String userNameRegistrierung(UserQuestions userQuestions, SqlUserRepository sqlUserRepository) {
        while (true) {
            String userName = userQuestions.userDescription("We need a unique Username: ");
            User user = sqlUserRepository.findePasswordUserIDByUserName(userName);
            if (user != null) {
                System.out.println("Assign names. Take a new name!");
                continue;
            }
            return userName;
        }
    }
}
