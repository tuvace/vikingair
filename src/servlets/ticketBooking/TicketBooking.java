package servlets.ticketBooking;

public class TicketBooking {
    String flightID;
    String customerID;
    String baggage;
    String flight_class;


    public TicketBooking(String flightID, String customerID, String baggage, String flight_class) {
        this.flightID = flightID;
        this.customerID = customerID;
        this.baggage = baggage;
        this.flight_class = flight_class;


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

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public String getFlight_class() {
        return flight_class;
    }

    public void setFlight_class(String flight_class) {
        this.flight_class = flight_class;
    }



}

