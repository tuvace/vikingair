package servlets.tickets;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletContext;

//Denne servletten er en kontroller.
@WebServlet(name = "TicketServlet", urlPatterns = {"/TicketServlet"})
public class TicketServlet extends HttpServlet {
        TicketLogic ticLog = new TicketLogic();

    /**protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String gate = request.getParameter("gate");
        int id = 1;
        try {
            request.setAttribute("gate", ticLog.showAll(id));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }*/
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            ServletContext sc = this.getServletContext();
            int id = Integer.parseInt(request.getParameter("tic_id"));
            if (action.equalsIgnoreCase("delete")) {

                try {
                    ticLog.delete(id);
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                RequestDispatcher view = sc.getRequestDispatcher("/profil.jsp");
                view.forward(request, response);
            }
        }


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            ServletContext sc = this.getServletContext();

            int id = 1;

            try {
                request.setAttribute("tickets", ticLog.showAll(id));


            } catch (Exception ex) {
                System.out.println(ex);
            }

            RequestDispatcher view = sc.getRequestDispatcher("/cusTicket.jsp");
            view.forward(request, response);
        }

/**
        public void funksjon1(){
            TicketLogic.delete();
        }*/
}
