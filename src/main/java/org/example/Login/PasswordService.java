package org.example.Login;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordService {
    public static String hash(String password) {
        return BCrypt.hashpw(password,BCrypt.gensalt(12));
    }

    public static boolean verify(String password, String hash) {
        return BCrypt.checkpw(password,hash);
    }
}
