package servlets.logio;

import dbcode.dbUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginLogic {
    static dbUtilities db = new dbUtilities();

    public static boolean validate(Login login) throws SQLException {
        boolean status = false;

        PreparedStatement myStmt;
        //Class.forName("com.mysql.jdbc.Driver");
        String sql = "select * from UserLogin where username = ? and user_password = ?";
        try {
            Connection con = db.connect();
            myStmt = con.prepareStatement(sql);
            // Step 2:Create a statement using connection object

            myStmt = con.prepareStatement("select * from UserLogin where username = ? and password = ? ");
            {
                myStmt.setString(1, login.getUsername());
                myStmt.setString(2, login.getUser_password());

                System.out.println(myStmt);
                ResultSet rs = myStmt.executeQuery();
                status = rs.next();
            }
            db.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            while (ex != null) {
                String errorMessage = ex.getMessage();
                System.err.println("sql error message:" + errorMessage);

                // This vendor-independent string contains a code.
                String sqlState = ex.getSQLState();
                System.err.println("sql state:" + sqlState);

                int errorCode = ex.getErrorCode();
                System.err.println("error code:" + errorCode);
                // String driverName = conn.getMetaData().getDriverName();
                // System.err.println("driver name:"+driverName);
                // processDetailError(drivername, errorCode);
                ex = ex.getNextException();
            }
        }
        return status;
    }
}

