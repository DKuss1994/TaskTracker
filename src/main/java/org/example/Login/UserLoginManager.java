package org.example.Login;

import org.example.Enum;
import org.example.SQL.JdbcConnectionProvider;
import org.example.SQL.SqlServerConnection;
import org.example.SystemManager;
import org.example.UserQuestions;

import java.util.Scanner;

public class UserLoginManager {
    private final Scanner sc = new Scanner(System.in);
    private final UserQuestions userQuestions = new UserQuestions(sc);

    public Enum.Action loginOrRegistrierung() {
        return userQuestions.userAction("Login or Registration or Exit");
    }

    public void start() {
        UserLoginManager userLoginManager = new UserLoginManager();
        Enum.Action action = userLoginManager.loginOrRegistrierung();
        switch (action) {
            case LOGIN -> {
                if (userLoginManager.login()) {
                    SystemManager systemManager = new SystemManager();
                    systemManager.start();

                }
            }
            case REGISTRATION -> {
                userLoginManager.registrierung();
            }
            case EXIT -> System.exit(0);
        }


    }

    private void registrierung() {

    }

    public boolean login() {
        JdbcConnectionProvider jdbcConnectionProvider = new JdbcConnectionProvider();
        SqlServerConnection sqlServerConnection = new SqlServerConnection(jdbcConnectionProvider);
        SqlUserRepository sqlUserRepository = new SqlUserRepository(sqlServerConnection);
        PasswordService passwordService = new PasswordService();
        UserService userService = new UserService(sqlUserRepository, passwordService);
        String userName = userQuestions.userDescription("Username: ");
        String password = userQuestions.userDescription("Password: ");
        return userService.login(userName, password);

    }
}
