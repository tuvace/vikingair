package servlets.adminFlight;

import java.io.Serializable;
import java.sql.Date;

public class adminFlight implements Serializable
{
    private String from;
    private String to;
    private String flightDate;
    private int duration;
    private String flightID;
    private String airplaneType;
    private int seatAmount;
    private int baggage_limit;
    private int price;

    public adminFlight(String from, String to, String flightDate, int duration, String flightID, String airplaneType, int baggage_limit, int price)
    {
        this.from = from;
        this.to = to;
        this.flightDate = flightDate;
        this.duration = duration;
        this.flightID = flightID;
        this.airplaneType = airplaneType;
        this.seatAmount = seatAmount;
        this.baggage_limit = baggage_limit;
        this.price = price;
    }
    public adminFlight() {

    }
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFlightDate(String flightDate){this.flightDate = flightDate;}

    public String getFlightDate() {return flightDate;}

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setBaggagelimit(int baggage_limit) {
        this.baggage_limit =baggage_limit;
    }
    public int getBaggagelimit() {
        return baggage_limit;
    }
    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}
}

