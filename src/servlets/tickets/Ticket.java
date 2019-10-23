package servlets.tickets;

public class Ticket {
    int ticketID;
    int customerID;
    int flightID;
    String gate;
    String firstName;
    String lastName;
    int seatRow;
    String seatLetter;
    String classType;

public Ticket(int ticketID, int customerID, int flightID, String gate, String firstName, String lastName, int seatRow, String seatLetter, String classType){

    this.ticketID = ticketID;
    this.customerID = customerID;
    this.flightID = flightID;
    this.gate = gate;
    this.firstName = firstName;
    this.lastName = lastName;
    this.seatRow = seatRow;
    this.seatLetter = seatLetter;
    this.classType = classType;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

}

