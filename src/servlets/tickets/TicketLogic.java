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

        PreparedStatement ps;
        ResultSet results;
        String sql = "DELETE FROM ticket WHERE ticketID=?";

        Connection con = db.connect();

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            results = ps.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();

        } finally {
            if (con!= null){
                db.close();

            }
        }

    }

    public void update(Ticket ticket) {

    }

    public ArrayList<Ticket> showAll(int id) throws SQLException {

        ArrayList<Ticket> tickets = new ArrayList<>();
        PreparedStatement ps;
        ResultSet results;
        String sql = "select *from ticket inner join customer on ticket.customerID = customer.customerID inner join flightDetails on ticket.flightID = flightdetails.flightID inner join seat on ticket.seatID = seat.seatID where ticket.customerId = ?";

        Connection con = db.connect();

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            results = ps.executeQuery();

            while (results.next()){

            Ticket tic = new Ticket();

            tic.setGate(results.getString("Gate"));
            tic.setSeatRow(results.getInt("seatRow"));
            tic.setSeatLetter(results.getString("Seatletter"));
            tic.setClassType(results.getString("Class"));
            tic.setFlightTo(results.getString("flightTo"));
            tic.setFlightFrom(results.getString("flightFrom"));
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
