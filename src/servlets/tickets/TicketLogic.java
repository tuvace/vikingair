package servlets.tickets;

import dbcode.dbUtilities;
import servlets.interfaces.VikingAir;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketLogic {


    dbUtilities db = new dbUtilities();


    public void create(Ticket tic) throws SQLException {

        PreparedStatement ps;
        //Makes an connection to the db.
        Connection con = db.connect();

        //The SQL query is executed whenever a new customer is signing up.
        String query = ("insert into Ticket(ticketID, customerID, flightID, gate, firstName, lastName, seatRow, seatLetter, classType)"
                + "values (?,?,?,?,?,?,?,?,?);");

        try {
            ps = con.prepareStatement(query); //Sends the query to the db safely.

            //Sets the name, type and the price
            ps.setInt(1, tic.getTicketID());
            ps.setInt(2, tic.getCustomerID());
            ps.setInt(3, tic.getFlightID());
            ps.setString(3, tic.getGate());
            ps.setString(3, tic.getFirstName());
            ps.setString(3, tic.getLastName());
            ps.setInt(3, tic.getSeatRow());
            ps.setString(3, tic.getSeatLetter());
            ps.setString(3, tic.getClassType());

            ps.execute(); //Updates the db.

        } catch (SQLException ex) {
            ex.printStackTrace();

            //Closes the connection to the db.
        } finally {
            if(con != null)
            {
                con.close();
            }
        }
    }

    public void delete(int id) {

    }

    public void update(Ticket ticket) {

    }

    public ArrayList<Ticket> showAll(String gate) throws SQLException {

        ArrayList<Ticket> tickets = new ArrayList<>();
        PreparedStatement myStmt;

        String sql = "SELECT * FROM TICKET LIMIT 1";

        Connection con = db.connect();

        try{
            myStmt = con.prepareStatement(sql);
            ResultSet results = myStmt.executeQuery();

            while (results.next()){
            Ticket tic = new Ticket();

            tic.setGate(results.getString("gate"));

            tickets.add(tic);
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }

        }

        return tickets;
    }

    public Ticket showOne(int id) {
        return null;
    }

}
