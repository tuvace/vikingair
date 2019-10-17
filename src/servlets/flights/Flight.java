package servlets.flights;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    public class Flight {
        private int flightId;
        private int price;
        private String flightDate;
        private String flightTo;
        private String flightFrom;
        private int duration;
        private int seatRow;
        private int seatAmount;
        private String seatLetter;
        private String airplaneType;


        public Flight(int flightId, int price, String flightDate, String flightTo, String flightFrom,
                      int duration, int seatRow, int seatAmount, String seatLetter, String airplaneType) {
            super();
            this.flightId = flightId;
            this.price = price;
            this.flightDate = flightDate;
            this.flightTo = flightTo;
            this.flightFrom = flightFrom;
            this.duration = duration;
            this.seatRow = seatRow;
            this.seatAmount = seatAmount;
            this.seatLetter = seatLetter;
            this.airplaneType = airplaneType;
        }

        public Flight(){

        }
        // Getters and Setters

        public int getFlightId() {
            return flightId;
        }

        public void setFlightId(int flightId) {
            this.flightId = flightId;
        }

        public int getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }
        public String getFlightDate() {
            return flightDate;
        }
        public void setFlightDate(String flightDate) {
            this.flightDate = flightDate;
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
        public int getDuration() {
            return duration;
        }
        public void setDuration(int duration) {
            this.duration = duration;
        }
        public int getSeatRow() {
            return seatRow;
        }
        public void setSeatRow(int seatRow) {
            this.seatRow = seatRow;
        }
        public int getSeatAmount() {
            return seatAmount;
        }
        public void setSeatAmount(int seatAmount) {
            this.seatAmount = seatAmount;
        }
        public String getSeatLetter() {
            return seatLetter;
        }
        public void setSeatLetter(String seatLetter){
            this.seatLetter = seatLetter;
        }
        public String getAirplaneType() {
            return airplaneType;
        }
        public void setAirplaneType(String airplaneType) {
            this.airplaneType = airplaneType;
        }

        @Override
        public String toString() {
            return "Flight{" +
                    "flightId=" + flightId +
                    ", price=" + price +
                    ", flightDate='" + flightDate + '\'' +
                    ", flightTo='" + flightTo + '\'' +
                    ", flightFrom='" + flightFrom + '\'' +
                    ", duration='" + duration + '\'' +
                    ", seatRow=" + seatRow +
                    ", seatAmount=" + seatAmount +
                    ", seatLetter='" + seatLetter + '\'' +
                    ", airplaneType='" + airplaneType + '\'' +
                    '}';
        }
    }

