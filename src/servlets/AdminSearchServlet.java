package servlets;

import logics.AdminSearchLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "adminSearchServlet", urlPatterns = {"/adminSearchServlet"})
public class AdminSearchServlet extends HttpServlet {
    private AdminSearchLogic SL = new AdminSearchLogic();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Her vurderer den verdien til "action" i forhold til hvilken knapp på jsp-siden som blir trykket, hver verdi utfører en unik handling
        String action = request.getParameter("action");
        if(action.equals("editFrom")){
            try {
                //endrer avgangsdetinasjon
                editFrom(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(action.equals("editTo")){
            try {
                //endrer reisested
                editTo(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(action.equals("editGate")){
            try {
                //endrer gate
                editGate(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(action.equals("editDuration")){
            try {
                //endrer reiselengde
                editDuration(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(action.equals("deleteFlight")){
            try {
                // sletter fly fra databasen
                deleteFlight(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //printer ut alle billetter som er booket
        ServletContext sc = this.getServletContext();
        try
        {
            request.setAttribute("searches", SL.selectAll());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = sc.getRequestDispatcher("/printTickets.jsp");
        view.forward(request, response);
    }

    private void editFrom(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        // kaller på en funksjon som henter ut riktig flyID fra databasen for så å endrer på den ønskede verdien i databasen
        String flightID = request.getParameter("flightID");
        String from = request.getParameter("from");
        ServletContext sc = this.getServletContext();
        int flight = 0;
        try {
            flight = SL.getFlightid(flightID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            SL.updateFrom(flight, from);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/flyEndring.jsp");
        view.forward(request, response);
    }
    private void editTo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        // kaller på en funksjon som henter ut riktig flyID fra databasen for så å endrer på den ønskede verdien i databasen
        String flightID = request.getParameter("flightID");
        String to = request.getParameter("to");
        ServletContext sc = this.getServletContext();
        int flight = 0;
        try {
            flight = SL.getFlightid(flightID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            SL.updateTo(flight, to);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/flyEndring.jsp");
        view.forward(request, response);
    }
    private void editGate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        // kaller på en funksjon som henter ut riktig flyID fra databasen for så å endrer på den ønskede verdien i databasen
        String flightID = request.getParameter("flightID");
        String gate = request.getParameter("gate");
        ServletContext sc = this.getServletContext();
        int flight = 0;
        try {
            flight = SL.getFlightid(flightID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            SL.updateGate(flight, gate);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/flyEndring.jsp");
        view.forward(request, response);
    }
    private void editDuration(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        // kaller på en funksjon som henter ut riktig flyID fra databasen for så å endrer på den ønskede verdien i databasen
        String flightID = request.getParameter("flightID");
        String duration = request.getParameter("duration");
        ServletContext sc = this.getServletContext();
        int flight = 0;
        try {
            flight = SL.getFlightid(flightID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            SL.updateDuration(flight, duration);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/flyEndring.jsp");
        view.forward(request, response);
    }
    private void deleteFlight(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        // kaller på en funksjon som henter ut riktig flyID fra databasen for så å slette flyet
        String flightID = request.getParameter("flightID");
        ServletContext sc = this.getServletContext();
        int flight = 0;
        try {
            flight = SL.getFlightid(flightID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            SL.deleteFlight(flight);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/flyEndring.jsp");
        view.forward(request, response);
    }
}
