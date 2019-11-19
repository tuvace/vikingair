package servlets.ticketBooking;

public class TicketBooking {
    String flightID;
    String customerID;
    String seatID;

    public TicketBooking(String flightID, String customerID, String seatID) {
        this.flightID = flightID;
        this.customerID = customerID;
        this.seatID = seatID;
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

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }
}

