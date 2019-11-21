package servlets.ticketBooking;

import servlets.FlightSearch.FlightSearch;
import servlets.FlightSearch.FlightSearchLogic;
import servlets.ticketBooking.TicketBooking;
import servlets.ticketBooking.TicketBookingLogic;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TicketBookingServlet", urlPatterns = {"/TicketBookingServlet"})
public class TicketBookingServlet extends HttpServlet {

    TicketBookingLogic ticBook = new TicketBookingLogic();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            ServletContext sc = this.getServletContext();
            String flightID = request.getParameter("flightID");
            String customerID = request.getParameter("customerID");
            TicketBooking TB = new TicketBooking(flightID, customerID);


           try {
               ticBook.saveTicket(TB);

           } catch (SQLException e) {
               e.printStackTrace();
           }
        request.getRequestDispatcher("index.jsp").forward(request, response);
        RequestDispatcher view = sc.getRequestDispatcher("/bestillingsBekreftelse.jsp");
        view.forward(request, response);
        }
    }

