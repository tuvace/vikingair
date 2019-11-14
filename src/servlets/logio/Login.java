package servlets.logio;

import java.io.Serializable;

public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String userPassword;

    public Login(String username, String userPassword) {
        this.username = username;
        this.userPassword = userPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
