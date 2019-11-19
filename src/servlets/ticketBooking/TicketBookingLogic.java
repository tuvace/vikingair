package servlets.ticketBooking;

import dbcode.dbUtilities;
import servlets.customers.Customer;
import servlets.ticketBooking.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketBookingLogic {
    dbUtilities db = new dbUtilities();

    public void saveTicket(TicketBooking ticketBooking) throws SQLException {
        PreparedStatement cs;
        Connection con = db.connect();
        try {
            String query = "insert into Ticket(customerID, flightID, seatID) values(?, ?, ?);";
            cs = con.prepareStatement(query);
            cs.setString(1, ticketBooking.getCustomerID());
            cs.setString(2, ticketBooking.getFlightID());
            cs.setString(3, ticketBooking.getSeatID());
            cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

}

