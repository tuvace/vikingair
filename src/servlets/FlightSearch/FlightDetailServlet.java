package servlets.FlightSearch;

import servlets.ticketBooking.TicketBookingLogic;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;



@WebServlet(name = "FlightDetailServlet", urlPatterns = {"/FlightDetailServlet"})
public class FlightDetailServlet extends HttpServlet {

    FlightSearchLogic fls = new FlightSearchLogic();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flightID = request.getParameter("flightID");


        try {
            request.setAttribute("flsData", fls.getFlightData(flightID));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/ticketBooking.jsp");
        dispatcher.forward(request,response);
    }
}
