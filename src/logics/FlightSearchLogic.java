package logics;
import classes.FlightSearch;
import dbcode.dbUtilities;
import java.sql.*;
import java.util.ArrayList;


public class FlightSearchLogic {
    dbUtilities db = new dbUtilities();


    public ArrayList<FlightSearch> showAllFlights(String flightFrom, String flightTo, String flightDate) throws SQLException {


        PreparedStatement cs;
        ArrayList<FlightSearch> flsResults = new ArrayList<>();
        ResultSet myRs;
        String query =  "Select * from view_load_flight_details where flightTo = ? and flightFrom = ? and flightDate >= ? and bookedSeat < totalSeat";

        Connection con = db.connect(); //Kobler til databasen.
        try {

            cs = con.prepareStatement(query); //Sender kommandoen sikkert.
            cs.setString(1, flightTo);
            cs.setString(2, flightFrom);
            cs.setDate(3, java.sql.Date.valueOf (flightDate));

            myRs = cs.executeQuery(); //Etter å sende kommandoen, får vi et resultat fra databasen.


            while (myRs.next()) { //This loop iterates through each element of the list. For every new element it returns a new value.
                FlightSearch flightSearch = new FlightSearch();

                flightSearch.setFlightID(myRs.getInt("flightID"));
                flightSearch.setFlightDate(myRs.getString("flightDate"));
                flightSearch.setPrice(myRs.getInt("Price"));
                flightSearch.setFlightFrom(myRs.getString("flightFrom"));
                flightSearch.setFlightTo(myRs.getString("flightTo"));
                flightSearch.setDuration(myRs.getInt("duration"));
                flightSearch.setBookedSeat(myRs.getInt("bookedSeat"));
                flightSearch.setTotalSeat(myRs.getInt("TotalSeat"));

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

    public ArrayList<FlightSearch> getFlightData(String flightID) throws SQLException {


        PreparedStatement cs;

        ArrayList<FlightSearch> flsData = new ArrayList<>();
        ResultSet myRs;

        String query =  "Select * from view_load_flight_details where flightID = ?";
        Connection con = db.connect(); //Kobler til databasen.
        try {

            cs = con.prepareStatement(query); //Sender kommandoen sikkert.
            cs.setString(1, flightID);
            myRs = cs.executeQuery(); //Etter å sende kommandoen, får vi et resultat fra databasen.
            System.out.println(query);

            while (myRs.next()) { //This loop iterates through each element of the list. For every new element it returns a new value.
                FlightSearch flightSearch = new FlightSearch();

                flightSearch.setFlightID(myRs.getInt("flightID"));
                flightSearch.setFlightDate(myRs.getString("flightDate"));
                flightSearch.setPrice(myRs.getInt("Price"));
                flightSearch.setFlightFrom(myRs.getString("flightFrom"));
                flightSearch.setFlightTo(myRs.getString("flightTo"));

                flsData.add(flightSearch); //For every new iteration in the db a new customer is added to the list.
                System.out.println(flightSearch.getFlightID());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
            //Lukker forbindelsen til databasen.
        }
        for(int i =0; i< flsData.size(); i++){
            System.out.println(flsData.get(i));

        }

        System.out.println();
        return flsData;
}
}
