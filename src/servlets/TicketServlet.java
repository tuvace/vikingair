package servlets;

import logics.TicketLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletContext;

//Denne servletten er en kontroller.
@WebServlet(name = "TicketServlet", urlPatterns = {"/TicketServlet"})
public class TicketServlet extends HttpServlet {
    //Kjører en kopi av ticketLogic klassen
        private TicketLogic ticLog = new TicketLogic();

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
            ServletContext sc = this.getServletContext();
            //Henter parameter i jsp som matcher variablen "action"
            String action = request.getParameter("action");
            //Hvis action i forrige linje referer til delete, utfør resten av koden.
            if (action.equalsIgnoreCase("delete")) {
                try {
                    //Kjører deleteTicket metoden i ticketLogic
                    deleteTicket(request,response);
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                RequestDispatcher redirect = sc.getRequestDispatcher("profil.jsp");
                redirect.forward(request, response);
            }
        }


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            //Henter customer_id for senere bruk
            int cus_id = Integer.parseInt(request.getParameter("cus_id"));
            ServletContext sc = this.getServletContext();
            try
            {
                HttpSession session = request.getSession();
                //Kjører metoden showAll fra ticketLogic
                session.setAttribute("tickets", ticLog.showAll(cus_id));
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            RequestDispatcher view = sc.getRequestDispatcher("/cusTicket.jsp");
            view.forward(request, response);
        }
    private void deleteTicket(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
            //Henter ticketID fra SQL
        String tic_id = request.getParameter("tic_id");
            //Henter customerID fra SQL
        String cus_id = request.getParameter("cus_id");
        ServletContext sc = this.getServletContext();
        int ticID = 0;
        try {
            //Kjører getTicID for å trekke ut ticketID for senere bruk
            ticID = ticLog.getTicID(tic_id,cus_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //Kjører deleteTic metoden fra ticLog med ticID som ble trukket ut fra forrige try-metode
            ticLog.deleteTic(ticID);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/profil.jsp");
        view.forward(request, response);
    }
/**
        public void funksjon1(){
            TicketLogic.delete();
        }*/
}
