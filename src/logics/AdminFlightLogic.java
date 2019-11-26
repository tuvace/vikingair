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
        String sql = "INSERT into Flightdetails(flightFrom, flightTo, flightDate, flightID, gate, airplaneType, duration, seatamount, baggage_limit, price)"+ "values (?,?,?,?,?,?,?,?,?,?)";
        Connection con = db.connect();

       try {
           myStmt = con.prepareStatement(sql);
           // setter stringene til der de skal være i databasen
           myStmt.setString(1, adminFlight.getFrom());
           myStmt.setString(2, adminFlight.getTo());
           myStmt.setString(3, adminFlight.getFlightDate());
           myStmt.setString(4, adminFlight.getFlightID());
           myStmt.setString(5, adminFlight.getGate());
           myStmt.setString(6, adminFlight.getAirplaneType());
           myStmt.setInt(7, adminFlight.getDuration());
           myStmt.setInt(8, adminFlight.getSeatAmount());
           myStmt.setInt(9, adminFlight.getBaggagelimit());
           myStmt.setInt(10, adminFlight.getPrice());
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
