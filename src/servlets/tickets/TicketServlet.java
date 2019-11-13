package servlets.tickets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletContext;

//Denne servletten er en kontroller.
@WebServlet(name = "TicketServlet", urlPatterns = {"/TicketServlet"})
public class TicketServlet extends HttpServlet {
        TicketLogic ticLog = new TicketLogic();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String gate = request.getParameter("gate");

        try {
            request.setAttribute("gate", ticLog.showAll(gate));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

        /**response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String firstName = request.getParameter("firstName");


        try {
            boolean validate = TicketLogic(firstName);

            if (validate) {
                out.print("<h1 Hi" + firstName + "</h1>");
            } else {
                out.print("Wrong shit bookaroo");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request, response);
            }

        } catch (SQLException e) {
                    e.printStackTrace();
                }

            System.out.println("FirstName", firstName);

            PrintWriter writer = response.getWriter();

            String htmlResponse = "<html>";
            htmlResponse += "<h2> Yo biiiitch" + firstName + "<br/>";
            htmlResponse += "This a ticket mate </h2>";
            htmlResponse += "</html>";



            //response.sendRedirect("customerRedirect.jsp");
            writer.println(htmlResponse);
        }





        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {

        String gate = request.getParameter("gate");

        Ticket ticket = ticLog.showAll(gate);

        HttpSession session=request.getSession();

        session.setAttribute("gate",ticket);

        request.getRequestDispatcher("printTicket.jsp").forward(request,response);
        }*/

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            ServletContext sc = this.getServletContext();
            String gate = request.getParameter("gate");

            try {
                request.setAttribute("ticket", ticLog.showAll(gate));

            } catch (SQLException ex) {
                System.out.println(ex);


            }

            RequestDispatcher view = sc.getRequestDispatcher("/cusTicket.jsp");
            view.forward(request, response);
        }

/**
        public void funkjon1(){
            TicketLogic.delete();
        }*/
}
