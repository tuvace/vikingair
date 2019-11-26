package logics;

import classes.AdminSearch;
import dbcode.dbUtilities;
import java.sql.*;
import java.util.ArrayList;

public class AdminSearchLogic
{
    dbUtilities db = new dbUtilities();
    public ArrayList<AdminSearch> selectAll() throws SQLException
    {
        //lager en arraylist som printer ut alle biletter og hvilke kunder som har booket til hvilken flyreise
        ArrayList<AdminSearch> searches = new ArrayList<>();
        try
        {
            String sql = "SELECT flightID, customerID FROM Ticket";

            Connection con = db.connect();

            PreparedStatement myStmt = con.prepareStatement(sql);

            ResultSet rs = myStmt.executeQuery();

            while (rs.next())
            {
                //itererer gjennom databasen for å finne alle billetter
                AdminSearch search = new AdminSearch();
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
        //finner riktig flyID fra databasen i forhold til verdien på jsp-siden
        String sql = "select * from FlightDetails where flightID=?";

        Connection con = db.connect();

        PreparedStatement myStmt = con.prepareStatement(sql);
        myStmt.setString(1, flightID);
        ResultSet rs = myStmt.executeQuery();
        AdminSearch adminS = new AdminSearch();
        while (rs.next())
        {
            adminS.setFlightID(rs.getInt("flightID"));
        }
        //Returns the id associated to the username input parameter
        System.out.println(adminS.getFlightID());
        return adminS.getFlightID();

    }

    public void updateFrom(int flightID, String from) throws SQLException {

        //Denne SQL kommandoen kjøres når avgangssted til flyet blir oppdatert.
        String query = "update FlightDetails set flightFrom = '"+from+"' where flightID = " + flightID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }

    public void updateTo(int flightID, String to) throws SQLException {

        //Denne SQL kommandoen kjøres når reisedestinasjon til flyet blir oppdatert.
        String query = "update FlightDetails set flightTo = '"+to+"' where flightID = " + flightID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }

    public void updateGate(int flightID, String gate) throws SQLException {

        //Denne SQL kommandoen kjøres når gate til fly blir oppdatert.
        String query = "update FlightDetails set gate = '"+gate+"' where flightID = " + flightID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }

    public void updateDuration(int flightID, String duration) throws SQLException {

        //Denne SQL kommandoen kjøres når flytid til kunde blir oppdatert.
        String query = "update FlightDetails set duration = '"+duration+"' where flightID = " + flightID;
        Connection con = db.connect();
        Statement ps = con.createStatement();
        ps.executeUpdate(query); //Oppdaterer databasen.

    }

    public void deleteFlight(int id) throws SQLException {

        //Denne SQL kommandoen kjøres for å slette flyet fra databasen
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
