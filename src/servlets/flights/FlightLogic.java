package servlets.flights;

import dbcode.dbUtilities;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;
import servlets.PNR;
import servlets.customers.Customer;

public class FlightLogic {
    dbUtilities db;
    public ArrayList<Flight> selectAll() throws Exception {

        Flight flight = new Flight();
        ArrayList<Flight> flights = new ArrayList<>();
        PreparedStatement myStmt;
        // Step 1: create sql statement
        String sql = "SELECT * FROM flightDetail LIMIT 5";
        try {
            // Step 2: get a connection
            Connection con = db.connect();

            myStmt = con.prepareStatement(sql);

            ResultSet results = myStmt.executeQuery();
            //For hvert element i results (hver rad i databasen) så lager vi et nytt flight objekt og fyller ut feltene
            //med den tilsvarende infoen fra databasen.
            while(results.next()){
                flight.setFlightId(results.getInt("flight_ID"));
                flight.setFlightNumber(results.getInt("flightNumber"));
                flight.setPrice(results.getInt("price"));
                flight.setFlightDate(results.getString("flightDate"));
                flight.setTo(results.getString("To"));
                flight.setFrom(results.getString("From"));
                flight.setFlightClass(results.getString("flightClass"));
                flight.setDuration(results.getString("duration"));
                flight.setSeatAmount(results.getInt("seatAmount"));
                flight.setAirplaneType(results.getString("airplaneType"));
                flight.setGate(results.getString("gate"));

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

    // SE GJENNOM


    public Flight getFlightDetail (String flight_ID) throws Exception {
        Flight theFlight = new Flight();

        PreparedStatement myStmt;
        Connection con = db.connect();
        ResultSet results = null;
        Connection con = db.connect();



        //ResultSet results = myStmt.executeQuery();

        try {
            // Step 1: create sql statement
            String sql = "SELECT * FROM flightDetail WHERE flight_ID=" + flight_ID;

            myStmt = con.prepareStatement(sql);
            System.out.println("getFlight is called.");

            // Step 2: get a connection
            con = dataSource.getConnection();
            myStmt = con.createStatement();

            // Step 3: execute query
            results = myStmt.executeQuery(sql);

            // Step 4: process result set
            while (results.next()) {

                // Defining the variables
                 int flight_Id = results.getInt("flight_ID");
                 int price = results.getInt("price");
                 String departure = results.getString("departure");
                 String arrival = results.getString("arrival");
                 String from = results.getString("from");
                 String to = results.getString("to");
                 //Boolean business = myRs.getBoolean("business_class");
                 int seatRow = results.getInt("seatRow");
                 int seatNumber = results.getInt("seatNumber");
                 String gate = results.getString("gate");

            }

            return theFlight;
        } finally {
            // close JDBC objects
            close(con, myStmt, results);
        }
    }

    public boolean bookFlight (String flightNumber){
        // Get flightID
        // Get costumerID
        return false;
    }


    public PNR getPNR (String RN) throws Exception {
        PNR thePNR = null;

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            System.out.println("getFlight is called.");
            // Step 1: get a connection
            myConn = dataSource.getConnection();

            // Step 2: create sql statement
            String sql = "SELECT * FROM pnr WHERE rn=" + RN;

            myStmt = myConn.createStatement();

            // Step 3: execute query
            myRs = myStmt.executeQuery(sql);

            // Step 4: process result set
            while (myRs.next()) {

                // Defining the variables
                int rn = myRs.getInt("rn");
                int customerID = myRs.getInt("customerID");
                int flightID = myRs.getInt("flightID");
                String seatNumber = myRs.getString("seatNumber");
                String specialNeeds = myRs.getString("specialNeeds");

                // create new PNR object
                thePNR = new PNR(rn, customerID,
                        flightID, seatNumber, specialNeeds);

                System.out.println("PNR:" + rn + customerID + flightID + seatNumber + specialNeeds);
            }

            return thePNR;
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }
    public Customer getCustomer ( int CID) throws Exception {
        Customer theCustomer = null;

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            System.out.println("getFlight is called.");
            // Step 1: get a connection
            myConn = dataSource.getConnection();

            // Step 2: create sql statement
            String sql = "SELECT * FROM customer WHERE customerID=" + CID;

            myStmt = myConn.createStatement();

            // Step 3: execute query
            myRs = myStmt.executeQuery(sql);

            // Step 4: process result set
            while (myRs.next()) {

                // Defining the variables
                int customerID = myRs.getInt("customerID");
                String name = myRs.getString("name");
                String gender = myRs.getString("gender");
                String email = myRs.getString("email");

                System.out.println("kundeinfo:" + customerID + name + gender + email);
                // create new PNR object
                Customer = new Customer(customerID,
                        name, gender, email);
            }

            return Customer;
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }
    public void createCustomer (String name, String gender, String email) throws SQLException {

        Connection myConn = null;
        PreparedStatement st = null;


        try {
            // Step 1: get a connection
            myConn = dataSource.getConnection();

            st = myConn.prepareStatement("insert into customer(name, gender, email) values(?, ?, ?)");


            st.setString(1, name);

            st.setString(2, gender);

            st.setString(3, email);

            st.executeUpdate();
            System.out.println("Customer added.");
        } finally {
            // close JDBC objects
            myConn.close();
            st.close();

        }


        // Close all the connections
        st.close();
        myConn.close();


    }

    public ArrayList<Flight> filtering (String filterString) throws Exception {

        ArrayList<Flight> flights = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String querryString = null;

        if (filterString == "highToLow") {
            querryString = "SELECT * FROM flight order by price DESC";
        } else if (filterString == "lowToHigh") {
            querryString = "SELECT * FROM flight order by price ASC";
        }
        try {
            System.out.println("Filtering flights as requested.");
            // Step 1: get a connection
            myConn = dataSource.getConnection();

            // Step 2: create sql statement
            String sql = querryString;

            myStmt = myConn.createStatement();

            // Step 3: execute query
            myRs = myStmt.executeQuery(sql);

            // Step 4: process result set
            while (myRs.next()) {

                // Defining the variables
                int flightID = myRs.getInt("flightID");
                int price = myRs.getInt("price");
                String airline = myRs.getString("airline_name");
                String date = myRs.getString("flight_date");
                String from = myRs.getString("from_location");
                String to = myRs.getString("to_location");
                int revenue = myRs.getInt("revenue");
                Boolean business = myRs.getBoolean("business_class");
                String duration = myRs.getString("duration");
                int seatAmount = myRs.getInt("seat_amount");
                String visibleSeatAmount = VisibleSeatAmount(seatAmount);
                String airplaneType = myRs.getString("airplane_type");
                String gate = myRs.getString("gate");

                //very fancy code below
                String flightClass = business ? "Business" : "Economy";


                // create new flight object
                /**    Flight tempFlight = new Flight(flightID, price,
                 airline, date, from, to, revenue,
                 flightClass, duration, seatAmount, visibleSeatAmount, airplaneType, gate);

                 // add it to the list of flights
                 flights.add(tempFlight);
                 */
            }

            return flights;
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }

    }
}
