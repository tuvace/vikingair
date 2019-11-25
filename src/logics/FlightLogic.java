package logics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Flight;
import dbcode.dbUtilities;

public class FlightLogic {
    dbUtilities db = new dbUtilities();

    public ArrayList<Flight> selectAll() throws SQLException {


        ArrayList<Flight> flights = new ArrayList<>();
        PreparedStatement myStmt;
        // Step 1: create sql statement
        String sql = "SELECT * FROM FlightDetails";

        try {
            Connection con = db.connect();
            // Step 2: get a connection
            myStmt = con.prepareStatement(sql);

            ResultSet results = myStmt.executeQuery();
            //For hvert element i results (hver rad i databasen) så lager vi et nytt flight objekt og fyller ut feltene
            //med den tilsvarende infoen fra databasen.
            while (results.next()) {
                Flight flight = new Flight();
                flight.setFlightId(results.getInt("flightID"));
                flight.setFlightDate(results.getDate("flightDate"));
                flight.setPrice(results.getInt("price"));
                flight.setFlightTo(results.getString("flightTo"));
                flight.setFlightFrom(results.getString("flightFrom"));
                flight.setAirplaneType(results.getString("airplaneType"));
                flight.setDuration(results.getInt("duration"));
                flight.setBaggage_limit(results.getInt("baggage_limit"));
                //Vi legger til flight i arraylisten flights.
                flights.add(flight);
            }

        }
        catch (SQLException sqlEx)
            {
                sqlEx.printStackTrace();
            }
        // close JDBC objects


        //Når resultset er tomt (arraylisten har blitt fyllt opp) så returnerer vi flights.
          return flights;

    }}

