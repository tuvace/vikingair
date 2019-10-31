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
        String sql = "INSERT into Flightdetail(flightFrom, flightTo, flightYear, flightMonth, flightDay, flight_ID, airplaneType, duration, seatAmount, baggage_limit)";
        Connection con = db.connect();

       try {
           myStmt = con.prepareStatement(sql);

           myStmt.setString(1, adminFlight.getFrom());
           myStmt.setString(2, adminFlight.getTo());
           myStmt.setInt(3, adminFlight.getYear());
           myStmt.setInt(4, adminFlight.getMonth());
           myStmt.setInt(5, adminFlight.getDay());
           myStmt.setString(6, adminFlight.getFlight_ID());
           myStmt.setString(7, adminFlight.getAirplaneType());
           myStmt.setInt(8, adminFlight.getDuration());
           myStmt.setInt(9, adminFlight.getSeatAmount());
           myStmt.setInt(9, adminFlight.getBaggagelimit());

           /*
           ResultSet results = myStmt.executeQuery();
           while (results.next()) {
               adminFlight.setFlightId(results.getInt("flight_ID"));
               adminFlight.setYear(results.getInt("flightYear"));
               adminFlight.setMonth(results.getInt("flightMonth"));
               adminFlight.setDay(results.getInt("flightDay"));
               adminFlight.setTo(results.getString("flightTo"));
               adminFlight.setFrom(results.getString("flightFrom"));
               adminFlight.setAirplaneType(results.getString("airplaneType"));
               adminFlight.setDuration(results.getInt("duration"));
               adminFlight.setSeatAmount(results.getInt("seatAmount"));
               adminFlight.setBaggagelimit(results.getInt("baggage_limit"));

               //Vi legger til flight i arraylisten flights.
           }

            */
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
