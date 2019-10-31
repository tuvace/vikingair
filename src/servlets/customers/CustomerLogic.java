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
import servlets.tickets.Ticket;


public class CustomerLogic {
    dbUtilities db = new dbUtilities();


        //Denne metoden oppretter en ny kunde og sender informasjon til databasen.
        public void create(Customer cus) {

            PreparedStatement ps;

            //Lager en connection til databasen.
            Connection con = db.connect();

            //Denne SQL queryen kjører hver gang en ny kunde registrerer seg.
            String query = ("insert into Customer(cus_firstName, cus_lastName, cus_email"
                    + "values (?,?,?,?,?);");

            try {
                ps = con.prepareStatement(query); //Sender queryen til databasen sikkert.

                //Setter navn og mail
                ps.setString(1, cus.getFirstName());
                ps.setString(2, cus.getLastName());
                ps.setString(3, cus.getEmail());
               // ps.setString(4, cus.getDateOfBirth());
               // ps.setString(5, cus.getPassword());

                ps.execute(); //Oppdaterer databasen.


        } catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        } finally {
            if (con != null) {
                //  close JDBC
                con.close();
            }
        }

    //En metode som sletter en eksisterenede kunde fra databasen.

    public void delete(int customerID) {

        // Denne SQL queryen kjøres hver gang en kunde blir slettet,
        // slik at kunden også blir slettet fra databasen.
        String query = "delete from customer where cus_customerID =?";
        Connection con = db.connect();
        try {
            PreparedStatement ps = con.prepareStatement(query); //Sender queryen til databasen.
            ps.setInt(1, customerID);
            ps.execute(); //Oppdaterer databasen.

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //Denne metoden oppdaterer informasjonen om en kunde.
    }

    public void update(Customer customer) {

        //Denne SQL kommandoen kjøres når noe informasjon om kunde blir oppdatert.
        String query = "update Customer set cus_fname = ?, cus_lname = ?, cus_email = ?, cus_dateOfBirth = ?, cus_pw = ? where cus_id = ?";
        Connection con = db.connect();

        try {
            PreparedStatement ps = con.prepareStatement(query); ////Sends the query to the db safely.
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            // ps.setString(4, customer.getDateOfBirth());
            // ps.setString(5, customer.getPassword());
            ps.setInt(6, customer.getCustomerID());
            ps.executeUpdate(); //Oppdaterer databasen.

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    //Denne metoden oppretter en ArrayList for kunders basert på de eksisterende kundene i databasen.

    public ArrayList<Customer> showAll() throws SQLException {

        PreparedStatement ps;
        ArrayList<Customer> customers = new ArrayList<>();

        //A SQL query that lists all existing customers.
        String query = "select * from Customer";
        Connection con = db.connect(); //Kobler til databasen.
        try {


            ps = con.prepareStatement(query); //Sender kommandoen sikkert.
            ResultSet results = ps.executeQuery(); //Etter å sende kommandoen, får vi et resultat fra databasen.

            while (results.next()) { //This loop iterates through each element of the list. For every new element it returns a new value.
                Customer cus = new Customer();
                cus.setCustomerID(results.getInt("cus_CustomerID"));
                cus.setFirstName(results.getString("cus_firstName"));
                cus.setLastName(results.getString("cus_lastName"));
                cus.setEmail(results.getString("cus_email"));
                // cus.setDateOfBirth(results.getString("cus_dateOfBirth"));
                // cus.setPassword(results.getString("cus_pw"));

                customers.add(cus); //For every new iteration in the db a new customer is added to the list.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
            //Lukker forbindelsen til databasen.
        }

        return customers; //Returnerer alle eksisterende kunder i ArrayListen.
    }

    public Customer login(String brukernavn, String passord) {
        Customer cus = new Customer();
        Connection con = db.connect();
        PreparedStatement ps;

        String query = "{CALL log_in_user(?, ?)}";

       try{
           ps = con.prepareStatement(query);
           ps.setString(1,brukernavn);
           ps.setString(2,passord);

           ResultSet results = ps.executeQuery();

           if(
                   results.next()
           ){
               customer.setCustomerID(results.getInt("customerID"));
               customer.setFirstName(results.getString("firstName"));
               customer.setMiddleName(results.getString("middleName"));
               customer.setLastName(results.getString("lastName"));
               customer.setCustomerAddress(results.getString("customerAddress"));
               customer.setDisabilities(results.getInt("disabilities"));
               customer.setEmail(results.getString("email"));
               customer.setPhoneNumber(results.getString("phoneNumber"));

               System.out.println("user is logged in");

           }else{
               System.out.println("User is not found");
           }
       }catch(SQLException ex){
           System.out.println(ex);
       }

       return cus;
    }

        }



