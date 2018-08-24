package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordService {

    public static String makeHashed(String passwordToHash) {
        return BCrypt.hashpw(passwordToHash, BCrypt.gensalt());
    }
}
