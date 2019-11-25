package logics;

import classes.Ticket;
import dbcode.dbUtilities;

import java.sql.*;
import java.util.ArrayList;

public class TicketLogic {

// Lager en kobling til riktig database for hele klassen
    dbUtilities db = new dbUtilities();

    //Lager et nytt objekt ut i fra den tomme constructoren i ticket.java.
    Ticket tickeT = new Ticket();

    //Denne metoden viser parameterne som vanligvis vises på en billett.
    public ArrayList<Ticket> showAll(int id) throws SQLException {

        //Lager en ny liste hvor alle billetter som returneres i senere SQL-query lagres
        ArrayList<Ticket> tickets = new ArrayList<>();
        // Lager et preparedstatement for å utføre sql kode senere
        PreparedStatement ps;
        //Lager en resultSet variabel som vil iterere over alle radene senere i databasen.
        ResultSet results;
        // Queriem som ble lagd for å hente alle ønskede variabler fra db
        String sql = "select * from ticket inner join customer on ticket.customerID = customer.customerID inner join flightDetails on ticket.flightID = flightdetails.flightID  where Ticket.customerID = ? limit 1";
        //Kobler til database
        Connection con = db.connect();

        try{
            //Utfører query
            ps = con.prepareStatement(sql);
            //Finner riktig billett ved hjelp av id
            ps.setInt(1, id);
            //Results som er variablen til resultSet settes som en iterator på første rad.
            results = ps.executeQuery();

            //En while loop for iteratoren
            while (results.next()){

            //Lager et nytt ticket objekt som skal inneholde variablene som står under.
            Ticket tic = new Ticket();

            //Results er iteratoren som står på radene i db. FInner alle referanser til navn i koden under og fyller de ut.
            tic.setTicketID(results.getInt("ticketID"));
            tic.setGate(results.getString("Gate"));
            tic.setFlightTo(results.getString("flightTo"));
            tic.setFlightFrom(results.getString("flightFrom"));
            //Et objekt med alle variablene blir lagt til i listen.
            tickets.add(tic);
            }

        } catch (SQLException e){
            e.printStackTrace();
            //Avslutter koblingen til db.
        } finally {
            if (con != null) {
                con.close();
            }

        }
        //Returnerer listen slik at den kan bli brukt senere.
        return tickets;
    }

// Denne metoden er en støttemetode for å returnere ID på kunden som er logget inn.
// ID skal kunne brukes i delete-metoden for å slette riktig billett.
    public int getTicID(String tic_id, String cus_id) throws SQLException {
        String sql = "select * from Ticket where ticketID=? and customerID =?";

        Connection con = db.connect();

        PreparedStatement myStmt = con.prepareStatement(sql);
        myStmt.setString(1, tic_id);
        myStmt.setString(2, cus_id);
        ResultSet rs = myStmt.executeQuery();
        while (rs.next()) {
            tickeT.setTicketID(rs.getInt("ticketID"));
        }
        con.close();
        //Returns the id associated to the username input parameter
        System.out.println(tickeT.getTicketID());
        return tickeT.getTicketID();
    }


    public void deleteTic(int id) throws SQLException {

        //Denne SQL kommandoen kjøres for å slette billetten til kunden med riktig ID.
        String query = "delete from Ticket where ticketID = " + id;

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
