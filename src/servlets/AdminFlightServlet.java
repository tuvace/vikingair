package servlets;

import classes.AdminFlight;
import logics.AdminFlightLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "adminFlightServlet", urlPatterns = {"/adminFlight"})
public class AdminFlightServlet extends HttpServlet {
    private AdminFlightLogic flightLogic = new AdminFlightLogic();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Denne metoden henter ut parameterene fra adminFlight.jsp og sender de videre til hjelpeklassen som legger de inn i databasen.
        ServletContext sc = this.getServletContext();

        String to = request.getParameter("flightTo");
        String from = request.getParameter("flightFrom");
        String flightDate = request.getParameter("flightDate");
        String flightID = request.getParameter("flightID");
        String airplaneType = request.getParameter("airplaneType");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int price = Integer.parseInt(request.getParameter("price"));
        int baggage_limit = Integer.parseInt(request.getParameter("baggage_limit"));
        AdminFlight flight = new AdminFlight(from, to, flightDate, duration, flightID, airplaneType, price, baggage_limit);

        try {
            flightLogic.addFlight(flight);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = sc.getRequestDispatcher("/adminHovedside.jsp");
        view.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
