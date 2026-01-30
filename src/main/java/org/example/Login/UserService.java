package org.example.Login;

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
            return passwordService.verify(userPassword, user.getPasswordHash());


        }
        return false;
    }
}
