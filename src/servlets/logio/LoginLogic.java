package servlets.logio;

import dbcode.dbUtilities;

import java.io.PrintWriter;
import java.sql.*;

public class LoginLogic {
    static dbUtilities db = new dbUtilities();


    public static boolean validate(String username, String userPassword) throws SQLException {
        boolean status = false;

        CallableStatement myStmt;
        Connection con = db.connect();

        try {
            // Step 2:Create a statement using connection object
            String query = "{CALL log_in_user(?, ?)}";
            myStmt = con.prepareCall(query);
            int userID= 0;
            {
                myStmt.setString(1, username);
                myStmt.setString(2, userPassword);
                userID = myStmt.getInt("userID");

                System.out.println(myStmt);
                ResultSet rs = myStmt.executeQuery();
                status = rs.next();
            }


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
        finally
        {
            if(con != null)
            {
                con.close();
            }
        }
        return status;
    }
}

