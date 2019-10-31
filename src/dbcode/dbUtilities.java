package dbcode;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import servlets.customers.Customer;
import servlets.flights.Flight;


/**
     * This servlet establishes a connection to our database.
     * It also contains the functions that send SELECT, UPDATE, DROP queries etc*/

    public class dbUtilities {
    Connection con;

    public Connection connect(){
        try{
            Context context = new InitialContext();

            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/FlightBooking");
            Connection con = dataSource.getConnection();
            //con = dataSource.getConnection();
            //jdbc:mysql://localhost:3306/FlightBooking denne gir en naming ex



            return con;
        }catch(SQLException sql){
            System.out.println(sql);
        }catch(NamingException ne){
            System.out.println(ne);
        }
        return null;
    }

    public void close(){

        try{
            con.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }

        public void close(){
            try{
                con.close();
            }
            catch(SQLException ex){
                System.out.println("<br>Cannor close Connection " + ex);
            }
        }
    }
}


