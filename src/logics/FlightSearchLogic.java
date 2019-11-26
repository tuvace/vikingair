package logics;
import classes.FlightSearch;
import dbcode.dbUtilities;
import java.sql.*;
import java.util.ArrayList;

/**
 Denne klassen inneholder to ArrayLister.
 Hovedoppgaven til denne klassen er å kunne søke gjennom flyvninger,
 og kunne se spesifikk infromasjon om en flyvning.*/
public class FlightSearchLogic {
    dbUtilities db = new dbUtilities();

    /** Denne arraylisten brukes for å søke gjenom flyvninger, i søkemotoren.*/
    public ArrayList<FlightSearch> showAllFlights(String flightFrom, String flightTo, String flightDate) throws SQLException {


        PreparedStatement cs; //definerer en preraredstatment som cs.
        ArrayList<FlightSearch> flsResults = new ArrayList<>(); // Oppretter et arrayList objekt som heter flsResults
        ResultSet myRs;// Oppretter et Resultset som skal innholde resultatet fra databasen
        //SQL query som bruket et view for å finne flyvningene som søkes etter.
        String query =  "Select * from view_load_flight_details where flightTo = ? and flightFrom = ? and flightDate >= ? and bookedSeat < totalSeat";

        Connection con = db.connect(); //Kobler til databasen.

        //En try catch som prøver å finne de flyvninger som er søkt etter.
        try {

            cs = con.prepareStatement(query); //Bygger opp query.
            cs.setString(1, flightTo); //sette parameteren flightTo som er satt inn av bruker.
            cs.setString(2, flightFrom); //setter parameteren flightFrom som er satt inn av bruker.
            cs.setDate(3, java.sql.Date.valueOf (flightDate)); // setter parameteren flightDate som er satt inn av bruker.

            myRs = cs.executeQuery(); //fyller opp resultsettet med resultatene i fra spørringen.

            // Denne loopen går gjennom hvert record av listen. For hvert nye element vil den returnere en ny verdi.
            while (myRs.next()) {
                FlightSearch flightSearch = new FlightSearch(); // Oppretter get og set.

                flightSearch.setFlightID(myRs.getInt("flightID"));
                flightSearch.setFlightDate(myRs.getString("flightDate"));
                flightSearch.setPrice(myRs.getInt("Price"));
                flightSearch.setFlightFrom(myRs.getString("flightFrom"));
                flightSearch.setFlightTo(myRs.getString("flightTo"));
                flightSearch.setDuration(myRs.getInt("duration"));
                flightSearch.setBookedSeat(myRs.getInt("bookedSeat"));
                flightSearch.setTotalSeat(myRs.getInt("TotalSeat"));

                System.out.println("this flight exists"); //Test

                flsResults.add(flightSearch); // For hver nye gjennnomgang, legges det til de flyvninger som stemmer overens med informasjonen lagt inn av bruker som
                //den finner i databasen. Disse flyvninger blir lagt inn i listen.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
            //Lukker forbindelsen til databasen.
        }

        return flsResults; //Returnerer alle eksisterende flyvninger lagt inn i ArrayListen.

    }
    /** Denne ArrayListen brukes for å vise data til en valgt flyvning.*/
    public ArrayList<FlightSearch> getFlightData(String flightID) throws SQLException {


        PreparedStatement cs;

        ArrayList<FlightSearch> flsData = new ArrayList<>();// Oppretter en Arraylist objekt som bruker de parameterne satt i FlightSearch klassen.
        //ArrayListen heter flsData.
        ResultSet myRs; //Oppretter et Resultset og kaller det myRs.

        String query =  "Select * from view_load_flight_details where flightID = ?";
        Connection con = db.connect(); //Kobler til databasen.

        //Try catch som skal prøve å få ut informasjon om en flyvning.
        try {

            cs = con.prepareStatement(query); //Sender kommandoen sikkert.
            cs.setString(1, flightID); // Prøver å sette FlightID fått fra nettsiden.
            myRs = cs.executeQuery(); //Definerer resultsettet til å utføre sql queryen.
            System.out.println(query);

            // Denne loopen går gjennom hvert record av listen. For hvert nye element vil den returnere en ny verdi.
            while (myRs.next()) {
                FlightSearch flightSearch = new FlightSearch();

                flightSearch.setFlightID(myRs.getInt("flightID"));
                flightSearch.setFlightDate(myRs.getString("flightDate"));
                flightSearch.setPrice(myRs.getInt("Price"));
                flightSearch.setFlightFrom(myRs.getString("flightFrom"));
                flightSearch.setFlightTo(myRs.getString("flightTo"));

                flsData.add(flightSearch); //For hver nye gjennnomgang, legges det til de flyvninger som stemmer overens med
                // informasjonen lagt inn av bruker som
                //den finner i databasen. Disse flyvninger blir lagt inn i listen.
                System.out.println(flightSearch.getFlightID());//Test
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
            System.out.println(flsData.get(i)); //Test

        }

        System.out.println();
        return flsData;
}
}
