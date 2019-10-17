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

/**
public class CustomerLogic {
    dbUtilities db = new dbUtilities();

    public ArrayList<Customer> selectAll(){
        PreparedStatement myStmt;
        //  Creating a customer
        Customer customer = new Customer();

        //  Creating the Arraylist to be  containing customers
        ArrayList<Customer> customers = new ArrayList<>();

        // Step 1: Create sql statements
        String sql = "SELECT* FROM Customer LIMIT 5";

        try{
            //  Step 2: get a connection
            // Work in progress, have not added the DB
            Connection con = db.connect();

            myStmt = con.prepareStatement(sql);

            ResultSet results = myStmt.executeQuery();

            //  For hvert element i databasen (results) blir det lagd et nytt objekt
            //  og alle feltene blir fylt opp med tilsvarende info fra DB
            while (results.next())  {
                customer.setCustomerID(results.getInt("customerID"));
                customer.setFirstName(results.getString("firstName"));
                customer.setMiddleName(results.getString("middleName"));
                customer.setLastName(results.getString("lastName"));
                customer.setCustomerAddress(results.getString("customerAddress"));
                customer.setDisabilities(results.getInt("disabilities"));

                //  Legger til customer i arraylisten Customer.
                customers.add(customer);
            }


        }   catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        }

        //  close JDBC
        db.close();

        //  Returnerer liste customers når den er full for å bruke
        //  den et annet sted
        return customers;
    }
}
*/