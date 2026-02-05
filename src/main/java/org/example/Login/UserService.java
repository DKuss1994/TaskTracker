package org.example.Login;

import org.example.Login.Interface.PasswordCreate;
import org.example.Login.Interface.UserRepository;

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
            System.out.println("Welcome "+user.getUser());
            return passwordService.verify(userPassword, user.getPasswordHash());


        }
        return false;
    }
}
