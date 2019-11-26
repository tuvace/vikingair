package classes;


/**
 Denne klassen definerer de parametre som trengs til den tilhørende logikken i FlightSearchLogic.
 Klassen er en del av modellen i MVC-mønstre.*/
/** Felte inneholder de ulike parameterne som trengs, og deres datatyper blir definert.*/

public class FlightSearch {
    private int flightID;
    private String flightDate;
    private int price;
    private String flightFrom;
    private String flightTo;
    private int duration;
    private int bookedSeat;
    private  int totalSeat;

    /**Constructoren forsikrer oss om at objektet blir satt opp riktig, når dte først blir lagd.*/
    public FlightSearch(int flightID, String flightDate, int price, String flightFrom, String flightTo, int duration, int bookedSeat, int totalSeat) {
        this.flightID = flightID;
        this.flightDate = flightDate;
        this.price = price;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.duration = duration;
        this.bookedSeat = bookedSeat;
        this.totalSeat = totalSeat;
    }

    /** get og set for de ulike parametrene definert ovenfor. Set brukes for å sette en verdi, og get for å hente dem.*/
    public FlightSearch(){

    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getBookedSeat() {
        return bookedSeat;
    }

    public void setBookedSeat(int bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

}
