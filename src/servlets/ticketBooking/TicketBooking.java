package servlets.ticketBooking;

public class TicketBooking {
    String flightID;
    String customerID;


    public TicketBooking(String flightID, String customerID) {
        this.flightID = flightID;
        this.customerID = customerID;

    }

    public TicketBooking() {
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }


}

