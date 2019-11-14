package servlets.FlightSearch;
import dbcode.dbUtilities;
import java.sql.*;
import java.util.ArrayList;


public class FlightSearchLogic {
    dbUtilities db = new dbUtilities();


    public ArrayList<FlightSearch> showAllFlights(String flightFrom, String flightTo, String flightDate) throws SQLException {

        //CallableStatement cs;
        PreparedStatement cs;

        ArrayList<FlightSearch> flsResults = new ArrayList<>();
        ResultSet myRs;
        //String query = "Select * from FlightDetails";

        String query =  "Select * from view_load_flight_details where flightTo = ? and flightFrom = ? and flightDate >= ?";
        //String query = "{ CALL load_flightDetails(?, ?, ?) }";
        //A SQL query that lists all existing customers.

        Connection con = db.connect(); //Kobler til databasen.
        try {
            //String query = "select * from flightDetails where flightFrom = ? and flightTo = ? and flightDate >= ?";

            //cs = con.prepareCall(query); //Sender kommandoen sikkert.
            cs = con.prepareStatement(query); //Sender kommandoen sikkert.


           cs.setString(1, flightTo);
           cs.setString(2, flightFrom);
           cs.setDate(3, java.sql.Date.valueOf (flightDate));

            System.out.println(query);
           // System.out.println(cs);

            System.out.println("Henriette er veldig stressa");

            myRs = cs.executeQuery(); //Etter å sende kommandoen, får vi et resultat fra databasen.

            System.out.println("Henriette er utrolig stressa");
            if (myRs.wasNull()){
                System.out.println("tomt");
            }
            while (myRs.next()) { //This loop iterates through each element of the list. For every new element it returns a new value.
                System.out.println("Nå er Henriette rolig");
                FlightSearch flightSearch = new FlightSearch();

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
            for(FlightSearch f: flsResults){
                System.out.println(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
            //Lukker forbindelsen til databasen.
        }
        for(FlightSearch f: flsResults){
            System.out.println(f);
        }
        return flsResults; //Returnerer alle eksisterende kunder i ArrayListen.

    }


}