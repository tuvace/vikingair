package servlets.adminFlight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "adminFlightServlet", urlPatterns = {"/adminFlight"})
public class adminFlightServlet extends HttpServlet {
    adminFlightLogic flightLogic = new adminFlightLogic();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String to = request.getParameter("flightTo");
        String from = request.getParameter("flightFrom");
        int year =  Integer.parseInt(request.getParameter("flightYear"));
        int month = Integer.parseInt(request.getParameter("flightMonth"));
        int day = Integer.parseInt(request.getParameter("flightDay"));
        int duration = Integer.parseInt(request.getParameter("duration"));
        String flight_ID = request.getParameter("flight_ID");
        String airplaneType = request.getParameter("airplaneType");
        int seatAmount = Integer.parseInt(request.getParameter("seatAmount"));
        int baggage_limit = Integer.parseInt(request.getParameter("baggage_limit"));
        adminFlight flight = new adminFlight(to, from, year, month, day, duration, flight_ID, airplaneType, seatAmount, baggage_limit);

        try {
            flightLogic.addFlight(flight);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
