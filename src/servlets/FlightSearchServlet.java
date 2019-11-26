package servlets;

import logics.FlightSearchLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**Dette er en Servlet, som skal fungere som en Controller i MVC-mønstre.
 Den fungerer som et mellomledd mellom view og logikken.
 Den skal vise informasjon om de flyvninger søkt etter.*/

@WebServlet(name = "FlightSearchServlet", urlPatterns = {"/FlightSearchServlet"})
public class FlightSearchServlet extends HttpServlet { //Klassen extends...

    //klassen FlightSerachLogic som blir opprettet.
    FlightSearchLogic fls = new FlightSearchLogic();//Oppretter logikken og kaller den fls. Dette gjør at man får en kobling til


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = this.getServletContext();
        String flightFrom = request.getParameter("flightFrom"); //Prøver å hente parametre som er satt inn av bruker.
        String flightTo = request.getParameter("flightTo"); //Prøver å hente parametre som er satt inn av bruker.
        String flightDate = request.getParameter("flightDate"); //Prøver å hente parametre som er satt inn av bruker.

        //Prøver å sette parameterne over inn i arrayen showAllFlights.
        try {
            request.setAttribute("flsResults", fls.showAllFlights(flightFrom, flightTo, flightDate));

        } catch (SQLException ex) {
            System.out.println(ex);


        }
        //Etter å ha gjort alt over vil bruker bli sendt videre til jsp siden under.
        RequestDispatcher view = sc.getRequestDispatcher("/printFlights.jsp");
        view.forward(request, response);
    }
}