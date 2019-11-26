package logics;

import classes.TicketBooking;
import dbcode.dbUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** Denne klassen inneholder en metode som skal lagre billettene som blir kjøpt i databasen.
 Klassen fungerer som logic i MVC-mønstre.*/

public class TicketBookingLogic {
    dbUtilities db = new dbUtilities(); //Oppretter et nytt objekt av dbUtilities klassen.

    //Metoden skal lagre billetten som blir kjøpt.
    public void saveTicket(TicketBooking ticketBooking) throws SQLException {
        PreparedStatement cs; // Definerer statementet som cs.
        Connection con = db.connect(); //Oppretter connection til database.

        //Try catch skaal prøve å sette de parametre som trengs for å lagre en billett.
        try {
            //query som skal legge inn dataen som blir satt ved kjøp av en billett.
            String query = "insert into Ticket(customerID, flightID, baggage, flight_class)"+"values(?, ?, ?, ?)";
            cs = con.prepareStatement(query);//Forbreder spørringen. bygger opp med connection og spørring
            //Setter de ulike parameterne.
            cs.setString(1, ticketBooking.getCustomerID());
            cs.setString(2, ticketBooking.getFlightID());
            cs.setString(3, ticketBooking.getBaggage());
            cs.setString(4, ticketBooking.getFlight_class());

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

