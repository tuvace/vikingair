package logics;

import classes.AdminFlight;
import dbcode.dbUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminFlightLogic
{
     dbUtilities db = new dbUtilities();
    public void addFlight(AdminFlight adminFlight) throws SQLException {

        PreparedStatement myStmt;
        // En insert setning som legger til parameterne i databsen
        String sql = "INSERT into Flightdetails(flightFrom, flightTo, flightDate, flightID, airplaneType, duration, price, baggage_limit)"+ "values (?,?,?,?,?,?,?,?)";
        Connection con = db.connect();

       try {
           myStmt = con.prepareStatement(sql);
           // setter stringene til der de skal være i databasen
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
