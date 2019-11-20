package servlets.adminFlight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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

        ServletContext sc = this.getServletContext();

        String to = request.getParameter("flightTo");
        String from = request.getParameter("flightFrom");
        String flightDate = request.getParameter("flightDate");
        String flightID = request.getParameter("flightID");
        String airplaneType = request.getParameter("airplaneType");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int price = Integer.parseInt(request.getParameter("price"));
        int baggage_limit = Integer.parseInt(request.getParameter("baggage_limit"));
        adminFlight flight = new adminFlight(to, from, flightDate, duration, flightID, airplaneType, price, baggage_limit);

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
