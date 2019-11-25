package logics;

import classes.TicketBooking;
import dbcode.dbUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketBookingLogic {
    dbUtilities db = new dbUtilities();

    public void saveTicket(TicketBooking ticketBooking) throws SQLException {
        PreparedStatement cs;
        Connection con = db.connect();
        try {
            String query = "insert into Ticket(customerID, flightID, baggage, flight_class)"+"values(?, ?, ?, ?)";
            cs = con.prepareStatement(query);
            cs.setString(1, ticketBooking.getCustomerID());
            cs.setString(2, ticketBooking.getFlightID());
            cs.setString(3, ticketBooking.getFlight_class());
            cs.setString(4, ticketBooking.getBaggage());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

}

