package servlets.tickets;

public class Ticket {
    int ticketID;
    int customerID;
    int flightID;
    String gate;
    String flightTo;
    String flightFrom;

public Ticket(int ticketID, int customerID, int flightID, String gate, String flightTo, String flightFrom){

    this.ticketID = ticketID;
    this.customerID = customerID;
    this.flightID = flightID;
    this.gate = gate;
    this.flightTo=flightTo;
    this.flightFrom=flightFrom;
}

public Ticket(){
}

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

