package classes;


/**
 Denne klassen definerer de parametre som trengs til den tilhørende logikken i TicketBookingLogic.
 Klassen er en del av modellen i MVC-mønstre.*/

/** Felte inneholder de ulike parameterne som trengs, og deres datatype blir definert.*/
public class TicketBooking {
    String flightID;
    String customerID;
    String baggage;
    String flight_class;

    /**Constructoren forsikrer oss om at objektet blir satt opp riktig, når de først blir lagd.*/
    public TicketBooking(String flightID, String customerID, String baggage, String flight_class) {
        this.flightID = flightID;
        this.customerID = customerID;
        this.baggage = baggage;
        this.flight_class = flight_class;


    }
    /** get og set for de ulike parametrene definert ovenfor. Set brukes for å sette en verdi, og get for å hente dem.*/
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

