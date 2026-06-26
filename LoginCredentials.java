package Project;

import java.io.Serializable;

public class LoginCredentials implements Serializable {
    private static final long serialVersionUID = 2l;

    private String username;
    private String password;

    public LoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

