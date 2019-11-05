package servlets.FlightSearch;

import dbcode.dbUtilities;
import sun.util.calendar.LocalGregorianCalendar;

import java.sql.*;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class FlightSearchLogic {
    dbUtilities db = new dbUtilities();
    FlightSearch flightSearch = new FlightSearch();

    public ArrayList<FlightSearch> showAllFlights(String flightFrom, String flightTo, String flightDate) throws SQLException {

        CallableStatement cs;
        ArrayList<FlightSearch> flsResults = new ArrayList<>();


        //A SQL query that lists all existing customers.

        Connection con = db.connect(); //Kobler til databasen.
        try {
            String query = "{CALL load_flightDetails(?, ?, ?)}";
            cs = con.prepareCall(query); //Sender kommandoen sikkert.
            {
                cs.setString(1,flightFrom);
                cs.setString(2, flightTo);
                cs.setString(3, flightDate);
            }
            ResultSet results = cs.executeQuery(); //Etter å sende kommandoen, får vi et resultat fra databasen.

            while (results.next()) { //This loop iterates through each element of the list. For every new element it returns a new value.
                flightSearch.setFlightDate(results.getString("flightDate"));
                flightSearch.setPrice(results.getInt("Price"));
                flightSearch.setFlightFrom(results.getString("flightFrom"));
                flightSearch.setFlightTo(results.getString("flightTo"));
                flightSearch.setDuration(results.getInt("duration"));
                flightSearch.setBookedSeat(results.getInt("bookedSeat"));
                flightSearch.setTotalSeat(results.getInt("TotalSeat"));

                System.out.println("this flight exists");

                flsResults.add(flightSearch); //For every new iteration in the db a new customer is added to the list.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
            //Lukker forbindelsen til databasen.
        }

        return flsResults; //Returnerer alle eksisterende kunder i ArrayListen.

    }


}
