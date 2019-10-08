package servlets.flights;

import servlets.dbUtilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightLogic {
dbUtilities db;
    public ArrayList<Flight> selectAll() throws Exception {

        Flight flight = new Flight();
        ArrayList<Flight> flights = new ArrayList<>();
        PreparedStatement myStmt;
        // Step 2: create sql statement
        String sql = "SELECT * FROM flightDetail LIMIT 5";
        try {
            // Step 1: get a connection
            Connection con = db.connect();

            myStmt = con.prepareStatement(sql);

            ResultSet results = myStmt.executeQuery();
            //For hvert element i results (hver rad i databasen) så lager vi et nytt flight objekt og fyller ut feltene
            //med den tilsvarende infoen fra databasen.
            while(results.next()){
                flight.setFlightId(results.getInt("flight_ID"));
                flight.setPrice(results.getInt("price"));
                //osv..


                //Vi legger til flight i arraylisten flights.
                flights.add(flight);

            }


        }catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        finally {
            // close JDBC objects
            db.close();
        }

        //Når resultset er tomt (arraylisten har blitt fyllt opp) så returnerer vi flights.
        return flights;

    }


}
