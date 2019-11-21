package servlets.tickets;

public class Ticket {
    int ticketID;
    int customerID;
    int flightID;
    String gate;
    int seatRow;
    String seatLetter;
    String classType;
    String flightTo;
    String flightFrom;

public Ticket(int ticketID, int customerID, int flightID, String gate, int seatRow, String seatLetter, String classType, String flightTo, String flightFrom){

    this.ticketID = ticketID;
    this.customerID = customerID;
    this.flightID = flightID;
    this.gate = gate;
    this.seatRow = seatRow;
    this.seatLetter = seatLetter;
    this.classType = classType;
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

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatLetter() {
        return seatLetter;
    }

    public void setSeatLetter(String seatLetter) {
        this.seatLetter = seatLetter;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getFlightTo() { return flightTo; }

    public void setFlightTo(String flightTo) { this.flightTo = flightTo; }

    public String getFlightFrom() {return flightFrom;}

    public void setFlightFrom(String flightFrom) {this.flightFrom = flightFrom;}
}

