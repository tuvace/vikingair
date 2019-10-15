package dbcode;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import servlets.customers.Customer;
import servlets.flights.Flight;


/**
     * This servlet establishes a connection to our database.
     * It also contains the functions that send SELECT, UPDATE, DROP queries etc
     */
    public class dbUtilities {

        Connection con;

        public Connection connect(){
            try{
                Context context = new InitialContext();

                DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Flybooking");
                con = dataSource.getConnection();



                return con;
            }catch(SQLException sql){
                System.out.println(sql);
            }catch(NamingException ne){
                System.out.println(ne);
            }
            return null;
        }

        public void close() {

            try {
                con.close();
            } catch (SQLException exc) {
                System.out.println(exc);
            }
        }}