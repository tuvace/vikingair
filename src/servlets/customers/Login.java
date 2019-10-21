package servlets.customers;

import java.io.Serializable;
import java.util.Scanner;

public class Login implements Serializable {

    private static final long serialVersionUID = 1 L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

https://www.javaguides.net/2019/01/jsp-login-form-jdbc-mysql-example.html