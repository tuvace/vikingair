package logics;

import classes.Customer;
import dbcode.dbUtilities;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;


public class CustomerLogic {
    dbUtilities db = new dbUtilities();
    Customer customer = new Customer();

    //En metode som sletter en eksisterenede kunde fra databasen.

    public void delete(int customerID) {

        // Denne SQL kommandoen kjøres hver gang en kunde blir slettet,
        // slik at kunden også blir slettet fra databasen.
        String query = "delete from customer where customerID =?";
        Connection con = db.connect();
        try {
            PreparedStatement ps = con.prepareStatement(query); //Sender kommandoen til databasen.
            ps.setInt(1, customerID);
            ps.execute(); //Oppdaterer databasen.

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //Denne metoden oppdaterer informasjonen om en kunde.
    }

    public void updateFirstname(int customerID, String firstName) throws SQLException {

        //Denne SQL kommandoen kjøres når fornavn til kunde blir oppdatert.
        String query = "update Customer set firstName = '"+firstName+"' where customerID = " + customerID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }
    public void updateLastname(int customerID, String lastName) throws SQLException {

        //Denne SQL kommandoen kjøres når fornavn til kunde blir oppdatert.
        String query = "update Customer set lastName = '" + lastName + "' where customerID = " + customerID;
        Connection con = db.connect();
        Statement ps = con.createStatement(); //Sender queryen til db sikkert.
        ps.executeUpdate(query); //Oppdaterer databasen.

        //Denne metoden oppretter en ArrayList for kunders basert på de eksisterende kundene i databasen.
    }
    public void updateAddress(int customerID, String customerAddress) throws SQLException {

        //Denne SQL kommandoen kjøres når fornavn til kunde blir oppdatert.
        String query = "update Customer set customerAddress = '"+customerAddress+"' where customerID = " + customerID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }
    public void updatePhone(int customerID, String phoneNumber) throws SQLException {

        //Denne SQL kommandoen kjøres når fornavn til kunde blir oppdatert.
        String query = "update phone set phoneNumber = '"+phoneNumber+"' where customerID = " + customerID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }
    public void updateEmail(int customerID, String email) throws SQLException {

        //Denne SQL kommandoen kjøres når fornavn til kunde blir oppdatert.
        String query = "update email set email = '"+email+"' where customerID = " + customerID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }
    public ArrayList<Customer> showAll() throws SQLException {

        PreparedStatement ps;
        ArrayList<Customer> customers = new ArrayList<>();

        //EN SQL query som lister alle eksisterende kunder.
        String query = "select * from Customer";
        Connection con = db.connect(); //Kobler til databasen.
        try {
            ps = con.prepareStatement(query); //Sender kommandoen sikkert.
            ResultSet results = ps.executeQuery(); //Etter å sende kommandoen, får vi et resultat fra databasen.

            while (results.next()) { //This loop iterates through each element of the list. For every new element it returns a new value.
                Customer cus = new Customer();
                cus.setCustomerID(results.getInt("CustomerID"));
                cus.setFirstName(results.getString("firstName"));
                cus.setLastName(results.getString("lastName"));
                cus.setEmail(results.getString("email"));
                cus.setUserID(results.getInt("userID"));

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

    public Customer login(String brukernavn, String passord) throws SQLException {
        Customer cus = new Customer();
        Connection con = db.connect();
        PreparedStatement ps;

        String query = "{CALL log_in_user(?, ?)}";

        try{
            ps = con.prepareStatement(query);
            ps.setString(1, brukernavn);
            ps.setString(2, passord);

            ResultSet results  = ps.executeQuery(); //Hver gang du kaller på results utføres en get i databasen.

            if(results.next()){

                cus.setCustomerID(results.getInt(1));
                cus.setFirstName(results.getString(2));
                cus.setMiddleName(results.getString(3));
                cus.setLastName(results.getString(4));
                cus.setCustomerAddress(results.getString(5));
                cus.setDisabilities(results.getInt(6));
                cus.setEmail(results.getString(7));
                cus.setPhoneNumber(results.getString(8));
                cus.setRole(results.getString(9));
                cus.setUserID(results.getInt(10));

                System.out.println("user is logged in");


            }else{
                System.out.println("User is not found");
                return null;
            }
        }catch(SQLException ex){
            System.out.println(ex);
        } finally {
            if (con != null) {
                con.close();
            }
            //Lukker forbindelsen til databasen.
        }

        System.out.println(cus);
        return cus;
    }
    public int getcustomerID(String username) throws SQLException {

        String sql = "select * from Customer where customerID=?";

        Connection con = db.connect();

        PreparedStatement myStmt = con.prepareStatement(sql);
        myStmt.setString(1, username);
        ResultSet rs = myStmt.executeQuery();
        Customer customeR = new Customer();
        while (rs.next()) {
            customeR.setCustomerID(rs.getInt("customerID"));
        }

        //Returns the id associated to the username input parameter
        System.out.println(customeR.getCustomerID());
        return customeR.getCustomerID();

    }

}



