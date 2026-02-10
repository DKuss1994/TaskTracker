package org.example.Login;

import org.example.Login.Interface.PasswordCreate;
import org.example.Login.Interface.UserRepository;
import org.example.Task.UserQuestions;

public class UserService {
    UserRepository userRepository;
    PasswordCreate passwordService;

    public UserService(UserRepository userRepository, PasswordCreate passwordCreate) {
        this.userRepository = userRepository;
        this.passwordService = passwordCreate;

    }

    public User login(String userName, String userPassword) {
        User user = userRepository.findePasswordUserIDByUserName(userName);
        if (user != null) {
            System.out.println("Welcome " + user.user());
            if( passwordService.verify(userPassword, user.passwordHash())){
             return user;
            }


        }
        return null;
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
