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
        }
        finally {
             //  close JDBC
                db.close();
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
        public void update (Customer customer){

            //Denne SQL queryen kjøres når noe informasjon om kunde blir oppdatert.
            String query = "update Customer set cus_fname = ?, cus_lname = ?, cus_email = ?, cus_dateOfBirth = ?, cus_pw = ? where cus_id = ?";
            Connection con = db.connect();

            try {
                PreparedStatement ps = con.prepareStatement(query); //Sender queryen til db sikkert.
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

                //E SQL query som lister alle eksisterende kunder.
                String query = "select * from Customer";
                Connection con = db.connect(); //Kobler til databasen.
                try {


                    ps = con.prepareStatement(query); //Sender queryen sikkert.
                    ResultSet results = ps.executeQuery(); //Etter å sende queryen, får vi et resultat fra databasen.

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
                    if(con !=null){
                        con.close();
                    }
                    //Lukker forbindelsen til databasen.
                }

                return customers; //Returnerer alle eksisterende kunder i ArrayListen.
            }

            //Denne metoden skal gjøre det mulig å hente ut elementer fra 1 kunde fra databasen.
        public Customer showOne(int customerID) {
            Customer cus = new Customer();
            String query = "SELECT * from CUSTOMER where cus_customerID = ?";

            try {
                Connection con = db.connect();
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, customerID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    cus.setCustomerID(rs.getInt("cus_customerID"));
                    cus.setFirstName(rs.getString("cus_firstName"));
                    cus.setLastName((rs.getString("cus_lastName")));
                    cus.setEmail(rs.getString("cus_email"));
                    //cus.setDateOfBirth(rs.getString("cus_dateOfBirth"));
                    //cus.setPassword(rs.getString("cus_pw"));
                }

            } catch (SQLException ex) {
                System.out.println(ex);

            }
            return cus;
        }

    //Denne metoden sjekker om brukernavnet og passordet matcher kunden soom er registrert i databasen
    //Hvis det er en match vil man bli logget inn - skal bli mulig gjennom LoginServlet.
    public Customer Login(String email, String password){

        Customer cus = new Customer();
        PreparedStatement ps;
        Connection con = db.connect();

        String query = "select * from Customer where cus_email = ? and cus_pw = ?";

        try{
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet results = ps.executeQuery();

            if (results.next()) {
                cus.setCustomerID(results.getInt(1));
                cus.setFirstName(results.getString( 2));
                cus.setLastName(results.getString(3));
                cus.setEmail(results.getString(4));
                //cus.setPassword(results.getString(5));
                System.out.println("User is logged in");
            } else {
                System.out.println("User is not found");

            }

        }catch(SQLException e){
            e.printStackTrace();

        } return cus;
    }
}



