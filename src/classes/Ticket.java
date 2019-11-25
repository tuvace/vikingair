package classes;

public class Ticket {
   private int ticketID;
   private int customerID;
   private int flightID;
   private String gate;
   private String flightTo;
   private String flightFrom;

    //Constructor med alle variabler
public Ticket(int ticketID, int customerID, int flightID, String gate, String flightTo, String flightFrom){

    this.ticketID = ticketID;
    this.customerID = customerID;
    this.flightID = flightID;
    this.gate = gate;
    this.flightTo=flightTo;
    this.flightFrom=flightFrom;
}

//En tom constructor som kan bli kalt for å legge til egne variabler
public Ticket(){
}

// Settere og gettere for alle variablene i klassen
    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getFlightTo() { return flightTo; }

    public void setFlightTo(String flightTo) { this.flightTo = flightTo; }

    public String getFlightFrom() {return flightFrom;}

    public void setFlightFrom(String flightFrom) {this.flightFrom = flightFrom;}
}

