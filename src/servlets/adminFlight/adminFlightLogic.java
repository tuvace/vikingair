package servlets.adminFlight;

import dbcode.dbUtilities;
import servlets.adminFlight.adminFlight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class adminFlightLogic
{
     dbUtilities db = new dbUtilities();
    public void addFlight(adminFlight adminFlight) throws SQLException {

        PreparedStatement myStmt;
        // Step 1: create sql statement
        String sql = "INSERT into Flightdetails(flightFrom, flightTo, flightDate, flightID, airplaneType, duration, price, baggage_limit)"+ "values (?,?,?,?,?,?,?,?)";
        Connection con = db.connect();

       try {
           myStmt = con.prepareStatement(sql);

           myStmt.setString(1, adminFlight.getFrom());
           myStmt.setString(2, adminFlight.getTo());
           myStmt.setString(3, adminFlight.getFlightDate());
           myStmt.setString(4, adminFlight.getFlightID());
           myStmt.setString(5, adminFlight.getAirplaneType());
           myStmt.setInt(6, adminFlight.getDuration());
           myStmt.setInt(7, adminFlight.getPrice());
           myStmt.setInt(8, adminFlight.getBaggagelimit());
           myStmt.execute();

       }
       catch (SQLException sqlEx)
       {
           sqlEx.printStackTrace();
       }
       // close JDBC objects
       finally {
           if(con != null)
           {
               con.close();
           }
       }
    }
}
