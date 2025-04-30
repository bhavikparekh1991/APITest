package utils;

import java.util.Base64;

public class AuthUtil {
    public static String getBasicAuthToken(String username, String password) {
        String token = username + ":" + password;
        return Base64.getEncoder().encodeToString(token.getBytes());
    }
}
