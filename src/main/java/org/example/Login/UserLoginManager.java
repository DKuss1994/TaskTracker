package org.example.Login;

import org.example.Enum.Enum;
import org.example.SQL.JdbcConnectionProvider;
import org.example.SQL.SqlServerConnection;

import org.example.Task.SystemManager;
import org.example.Task.UserQuestions;

import java.util.Scanner;

public class UserLoginManager {
    private final Scanner sc = new Scanner(System.in);
    private final UserQuestions userQuestions = new UserQuestions(sc);
    private final JdbcConnectionProvider jdbcConnectionProvider = new JdbcConnectionProvider();
    private final SqlServerConnection sqlServerConnection = new SqlServerConnection(jdbcConnectionProvider);
    private final SqlUserRepository sqlUserRepository = new SqlUserRepository(sqlServerConnection);
    private final PasswordService passwordService = new PasswordService();
    private final UserService userService = new UserService(sqlUserRepository, passwordService);

    public Enum.Action loginOrRegistrierung() {
        return userQuestions.userAction("Login or Registration or Exit: ");
    }

    public void start() {
        UserLoginManager userLoginManager = new UserLoginManager();
        Enum.Action action = userLoginManager.loginOrRegistrierung();
        while (true){
        switch (action) {
            case LOGIN -> {
                User user = userLoginManager.login();
                if (user!=null) {
                    SystemManager systemManager = new SystemManager(user);
                    systemManager.start();

                }
            }
            case REGISTRATION -> {
                userLoginManager.registrierung();
            }
            case EXIT -> System.exit(0);
        }}


    }

    public void registrierung() {
        String userName = userService.userNameRegistrierung(userQuestions,sqlUserRepository);
        String password = userService.passwordRegistrierung(userQuestions);
        String hash = passwordService.hash(password);
        sqlUserRepository.createANewUserWithHashPassword(userName,hash);

    }





    public User login() {
        String userName = userQuestions.userDescription("Username: ");
        String password = userQuestions.userDescription("Password: ");
        return userService.login(userName, password);

    }
}
