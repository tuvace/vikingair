package servlets.adminFlight;

import java.io.Serializable;
import java.sql.Date;

public class adminFlight implements Serializable
{
    private String from;
    private String to;
    private int year;
    private int month;
    private int day;
    private int duration;
    private String flightID;
    private String airplaneType;
    private int seatAmount;
    private int baggage_limit;

    public adminFlight(String from, String to, int year, int month, int day, int duration, String flightID, String airplaneType, int seatAmount, int baggage_limit)
    {
        this.from = from;
        this.to = to;
        this.year = year;
        this.month = month;
        this.day = day;
        this.duration = duration;
        this.flightID = flightID;
        this.airplaneType = airplaneType;
        this.seatAmount = seatAmount;
        this.baggage_limit = baggage_limit;
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
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int Month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int Day) {
        this.day = day;
    }

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
}

