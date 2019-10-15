package servlets.flights;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


    public class Flight {
        private int flightId;
        private int flightNumber;
        private int price;
        private String flightDate;
        private String to;
        private String from;
        private String flightClass;
        private String duration;
        private int seatRow;
        private int seatAmount;
        private String airplaneType;
        private String gate;


        public Flight(int flightId, int flightNumber, int price, String flightDate, String to, String from,
                      String flightClass, String duration, int seatRow, int seatAmount, String airplaneType, String gate) {
            super();
            this.flightId = flightId;
            this.flightNumber = flightNumber;
            this.price = price;
            this.flightDate = flightDate;
            this.to = to;
            this.from = from;
            this.flightClass = flightClass;
            this.duration = duration;
            this.seatRow = seatRow;
            this.seatAmount = seatAmount;
            this.airplaneType = airplaneType;
            this.gate = gate;
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

        public int getFlightNumber() {
            return flightNumber;
        }
        public void setFlightNumber(int flightNumber) {
            this.flightNumber = flightNumber;
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
        public String getTo() {
            return to;
        }
        public void setTo(String to) {
            this.to = to;
        }
        public String getFrom() {
            return from;
        }
        public void setFrom(String from) {
            this.from = from;
        }
        public String getFlightClass() {
            return flightClass;
        }
        public void setFlightClass(String flightClass) {
            this.flightClass = flightClass;
        }
        public String getDuration() {
            return duration;
        }
        public void setDuration(String duration) {
            this.duration = duration;
        }
        public int getSeatRow() { return seatRow;}
        public void setSeatRow(int seatRow) { this.seatRow = seatRow;}
        public int getSeatAmount() {
            return seatAmount;
        }
        public void setSeatAmount(int seatAmount) {
            this.seatAmount = seatAmount;
        }
        public String getAirplaneType() {
            return airplaneType;
        }
        public void setAirplaneType(String airplaneType) {
            this.airplaneType = airplaneType;
        }
        public String getGate() {
            return gate;
        }
        public void setGate(String gate) {
            this.gate = gate;
        }

        @Override
        public String toString() {
            return "Flight{" +
                    "flightId=" + flightId +
                    ", flightNumber=" + flightNumber +
                    ", price=" + price +
                    ", flightDate='" + flightDate + '\'' +
                    ", to='" + to + '\'' +
                    ", from='" + from + '\'' +
                    ", flightClass='" + flightClass + '\'' +
                    ", duration='" + duration + '\'' +
                    ", seatRow=" + seatRow +
                    ", seatAmount=" + seatAmount +
                    ", airplaneType='" + airplaneType + '\'' +
                    ", gate='" + gate + '\'' +
                    '}';
        }
    }

