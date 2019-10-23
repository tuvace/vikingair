package servlets.logio;

import dbcode.dbUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginLogic {
    dbUtilities db = new dbUtilities();

    public boolean validate(Login login) throws ClassNotFoundException {
        boolean status = false;

        PreparedStatement myStmt;
        //Class.forName("com.mysql.jdbc.Driver");
        String sql = "select * from UserLogin where username = ? and user_password = ?";
            try {
                ResultSet results = myStmt.executeQuery();
                Connection con = db.connect();
                myStmt = con.prepareStatement(sql);
                // Step 2:Create a statement using connection object
                while (results.next()) {
                    Login.setUsername(results.getString("username"));
                    Login.setUser_password(results.getString("user_password"));

                /**myStmt = con.prepareStatement("select * from login where username = ? and password = ? ");
                {
                myStmt.setString(1, login.getUsername());
                myStmt.setString(2, login.getPassword());

                System.out.println(myStmt);
                ResultSet rs = myStmt.executeQuery();
                status = rs.next();*/
                }
             db.close();
            return status;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        private void printSQLException(SQLException e) {
            for (Throwable e: e) {
                if (e instanceof SQLException) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = e.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
    }

