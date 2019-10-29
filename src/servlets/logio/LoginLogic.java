package servlets.logio;

import dbcode.dbUtilities;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginLogic {
    static dbUtilities db = new dbUtilities();

    public static boolean validate(PrintWriter out, String username , String user_password) throws SQLException {
        boolean status = false;

        PreparedStatement myStmt;


        try {
            Connection con = db.connect();

            // Step 2:Create a statement using connection object

            myStmt = con.prepareStatement("select * from UserLogin where username = ? and password = ? ");
            {
                myStmt.setString(1, username);
                myStmt.setString(2, user_password);

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
            if(db != null)
            {
                db.close();
            }
        }
        return status;
    }
}

