package dbcode;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.sql.*;


import javax.sql.DataSource;


/**
     * This servlet establishes a connection to our database.*/

    public class dbUtilities {
    Connection con;

    public Connection connect(){
        try{
            Context context = new InitialContext();

            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/FlightBooking");
            Connection con = dataSource.getConnection();




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

        }
    }



