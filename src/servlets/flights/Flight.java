package servlets.flights;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.format.DateTimeFormatter;


public class Flight {
    private int flightId;
    private Date flightDate;
    private int price;
    private String flightTo;
    private String flightFrom;
    private String airplaneType;
    private int duration;
    private int seatAmount;
    private int seatRow;
    private String seatLetter;
    private int baggage_limit;


    public Flight(int flightId, Date flightDate, int price, String flightTo, String flightFrom, String airplaneType,
                  int duration, int seatAmount, int seatRow, String seatLetter, int baggage_limit) {
        super();
        this.flightId = flightId;
        this.flightDate = flightDate;
        this.price = price;
        this.flightTo = flightTo;
        this.flightFrom = flightFrom;
        this.airplaneType = airplaneType;
        this.duration = duration;
        this.seatAmount = seatAmount;
        this.seatRow = seatRow;
        this.seatLetter = seatLetter;
        this.baggage_limit = baggage_limit;
    }

    public Flight() {

    }
    // Getters and Setters

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
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
    public int getBaggage_limit(){
        return baggage_limit;
    }

    public void setBaggage_limit(int baggage_limit) {
        this.baggage_limit = baggage_limit;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightDate=" + flightDate +
                ", price=" + price +
                ", flightTo='" + flightTo + '\'' +
                ", flightFrom='" + flightFrom + '\'' +
                ", airplaneType='" + airplaneType + '\'' +
                ", duration=" + duration +
                ", seatAmount=" + seatAmount +
                ", seatRow=" + seatRow +
                ", seatLetter='" + seatLetter + '\'' +
                ", baggage_limit=" + baggage_limit +
                '}';
    }
}