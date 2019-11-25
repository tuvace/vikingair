package logics;

import classes.adminSearch;
import dbcode.dbUtilities;
import java.sql.*;
import java.util.ArrayList;

public class adminSearchLogic
{
    dbUtilities db = new dbUtilities();
    public ArrayList<adminSearch> selectAll() throws SQLException
    {
        ArrayList<adminSearch> searches = new ArrayList<>();
        try
        {
            String sql = "SELECT flightID, customerID FROM Ticket";

            Connection con = db.connect();

            PreparedStatement myStmt = con.prepareStatement(sql);

            ResultSet rs = myStmt.executeQuery();

            while (rs.next())
            {
                adminSearch search = new adminSearch();
                search.setFlightID(rs.getInt("flightID"));
                search.setCustomerID(rs.getString("customerID"));
                searches.add(search);
            }
            con.close();
        }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        return searches;
    }
    public int getFlightid(String flightID) throws SQLException {

        String sql = "select * from FlightDetails where flightID=?";

        Connection con = db.connect();

        PreparedStatement myStmt = con.prepareStatement(sql);
        myStmt.setString(1, flightID);
        ResultSet rs = myStmt.executeQuery();
        adminSearch adminS = new adminSearch();
        while (rs.next())
        {
            adminS.setFlightID(rs.getInt("flightID"));
        }
        //Returns the id associated to the username input parameter
        System.out.println(adminS.getFlightID());
        return adminS.getFlightID();

    }
    public void updateFlightID(int flightID) throws SQLException {

        //Denne SQL kommandoen kjøres når fornavn til kunde blir oppdatert.
        String query = "update FlightDetails set flightID = '"+flightID+"' where flightID = " + flightID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }
    public void updateFrom(int flightID, String from) throws SQLException {

        //Denne SQL kommandoen kjøres når fornavn til kunde blir oppdatert.
        String query = "update FlightDetails set flightFrom = '"+from+"' where flightID = " + flightID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }
    public void updateTo(int flightID, String to) throws SQLException {

        //Denne SQL kommandoen kjøres når fornavn til kunde blir oppdatert.
        String query = "update FlightDetails set flightTo = '"+to+"' where flightID = " + flightID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }
    public void updateGate(int flightID, String gate) throws SQLException {

        //Denne SQL kommandoen kjøres når fornavn til kunde blir oppdatert.
        String query = "update FlightDetails set gate = '"+gate+"' where flightID = " + flightID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }
    public void updateDuration(int flightID, String duration) throws SQLException {

        //Denne SQL kommandoen kjøres når fornavn til kunde blir oppdatert.
        String query = "update FlightDetails set duration = '"+duration+"' where flightID = " + flightID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }
    public void deleteFlight(int id) throws SQLException {

        //Denne SQL kommandoen kjøres for å slette billetten til kunden med riktig ID.
        String query = "delete from FlightDetails where flightID = " + id;

        // Kboler til database
        Connection con = db.connect();

        //Lager et statement for å kunne utføre SQL koden som står over.
        Statement ps = con.createStatement();

        // Utfører SQL-koden som står over, og oppdaterer databasen.
        ps.execute(query);

        // Avslutter koblingen til databasen.
        con.close();
    }
}
