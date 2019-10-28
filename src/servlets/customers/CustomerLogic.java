package servlets.customers;

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


public class CustomerLogic {
    dbUtilities db = new dbUtilities();

    public ArrayList<Customer> selectAll() {

        //  Creating a customer
        Customer customer = new Customer();

        //  Creating the Arraylist to be  containing customers
        ArrayList<Customer> customers = new ArrayList<>();

        PreparedStatement myStmt;


        // Step 1: Create sql statements
        String sql = "SELECT* FROM Customer LIMIT 5";

        try {
            //  Step 2: get a connection
            // Work in progress, have not added the DB
            Connection con = db.connect();

            myStmt = con.prepareStatement(sql);

            ResultSet results = myStmt.executeQuery();

            //  For hvert element i databasen (results) blir det lagd et nytt objekt
            //  og alle feltene blir fylt opp med tilsvarende info fra DB
            while (results.next()) {
                customer.setCustomerID(results.getInt("customerID"));
                customer.setFirstName(results.getString("firstName"));
                customer.setMiddleName(results.getString("middleName"));
                customer.setLastName(results.getString("lastName"));
                customer.setCustomerAddress(results.getString("customerAddress"));
                customer.setDisabilities(results.getInt("disabilities"));
                customer.setEmail(results.getString("email"));
                customer.setPhoneNumber(results.getString("phoneNumber"));

                //  Legger til customer i arraylisten Customer.
                customers.add(customer);
            }


        } catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }

        //  close JDBC
        db.close();

        //  Returnerer liste customers når den er full for å bruke
        //  den et annet sted
        return customers;
    }
}
    //En metode som sletter en eksisterenede kunde fra databasen.
    @Override
    public void delete(int customerID) {

        // Denne SQL kommandoen kjøres hver gang en kunde blir slettet,
        // slik at kunden også blir slettet fra databasen.
        String query = "delete from customer where cus_customerID =?";
        Connection con = db.connect();
        try {
            PreparedStatement ps = con.prepareStatement(query); //Sender kommandoen til databasen.
            ps.setInt(1, customerID);
            ps.execute(); //Oppdaterer databasen.

        } catch(SQLException ex){
            System.out.println(ex);
        }
        //Denne metoden oppdaterer informasjonen om en kunde.
        @Override
        public void update(Customer customer) {

            //Denne SQL kommandoen kjøres når noe informasjon om kunde blir oppdatert.
            String query = "update Customer set cus_fname = ?, cus_lname = ?, cus_email = ?, cus_dateOfBirth = ?, cus_pw = ? where cus_id = ?";
            Connection con = db.connect();

            try {
                PreparedStatement ps = con.prepareStatement(query); ////Sends the query to the db safely.
                ps.setString(1, customer.getFirstname());
                ps.setString(2, customer.getLastname());
                ps.setString(3, customer.getEmail());
               // ps.setString(4, customer.getDateOfBirth());
               // ps.setString(5, customer.getPassword());
                ps.setInt(6, customer.getCustomerID());
                ps.executeUpdate(); //Oppdaterer databasen.

            } catch(SQLException ex){
                System.out.println(ex);
            }
            //Denne metoden oppretter en ArrayList for kunders basert på de eksisterende kundene i databasen.
            @Override
            public ArrayList<Customer> showAll() {

                PreparedStatement ps;
                ArrayList<Customer> customers = new ArrayList<>();

                //A SQL query that lists all existing customers.
                String query = "select * from Customer";
                try {

                    Connection con = db.connect(); //Kobler til databasen.
                    ps = con.prepareStatement(query); //Sender kommandoen sikkert.
                    ResultSet results = ps.executeQuery(); //Etter å sende kommandoen, får vi et resultat fra databasen.

                    while (results.next()) { //This loop iterates through each element of the list. For every new element it returns a new value.
                        Customer cus = new Customer();
                        cus.setCustomerID(results.getInt("cus_CustomerID"));
                        cus.setFirstname(results.getString("cus_firstName"));
                        cus.setLastname(results.getString("cus_lastName"));
                        cus.setEmail(results.getString("cus_email"));
                       // cus.setDateOfBirth(results.getString("cus_dateOfBirth"));
                       // cus.setPassword(results.getString("cus_pw"));

                        customers.add(cus); //For every new iteration in the db a new customer is added to the list.
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    db.close(); //Lukker forbindelsen til databasen.
                }

                return customers; //Returnerer alle eksisterende kunder i ArrayListen.
            }
        }
    }

}
