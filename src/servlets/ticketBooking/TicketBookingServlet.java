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

    TicketBookingLogic ticketBooking = new TicketBookingLogic();
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
     /**   ServletContext sc = this.getServletContext();
        String flightID = request.getParameter("flightID");
        String customerID = request.getParameter("customerID");
        String seatID = request.getParameter("seatID");


        try {
            request.setAttribute("addTicket", ticketBooking.saveTicket(flightID, customerID, seatID));

        } catch (SQLException ex) {
            System.out.println(ex);


        }

        RequestDispatcher view = sc.getRequestDispatcher("/printFlights.jsp");
        view.forward(request, response);
    }
}
*/
