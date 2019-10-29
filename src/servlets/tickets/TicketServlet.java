package servlets.tickets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//Denne servletten er en kontroller.
@WebServlet(name = "TicketServlet", urlPatterns = {"/TicketServlet"})
public class TicketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TicketLogic ticLog;

    public TicketServlet(){
        super();
        ticLog = new TicketLogic();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Ticket tic = new Ticket();

        String TicketID = request.getParameter("TicketID");
        tic.setFirstName(request.getParameter("FirstName"));
        tic.setLastName(request.getParameter("LastName"));
        tic.setClassType(request.getParameter("classType"));


        if (TicketID == null || TicketID.isEmpty()) {

            try {
                ticLog.create(tic);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            int tic_TicketID = Integer.parseInt(TicketID.trim());
            tic.setTicketID(tic_TicketID);
            ticLog.update(tic);

        }
        System.out.println(tic);

        //response.sendRedirect("customerRedirect.jsp");
        RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
        redirect.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
