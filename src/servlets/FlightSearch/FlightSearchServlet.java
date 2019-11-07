package servlets.FlightSearch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import servlets.FlightSearch.FlightSearchLogic;
import servlets.FlightSearch.FlightSearch;

//Denne servletten er en kontroller.
@WebServlet(name = "FlightSearchServlet", urlPatterns = {"/FlightSearchServlet"})
public class FlightSearchServlet extends HttpServlet {

    FlightSearchLogic fls = new FlightSearchLogic();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        String flightFrom = request.getParameter("flightFrom");
        String flightTo = request.getParameter("flightTo");
        String flightDate = request.getParameter("flightDate");
       // Date flightDate = (Date) request.getAttribute("flightDate");
        try {
            request.setAttribute("flights", fls.showAllFlights(flightFrom, flightTo, flightDate));

        } catch (SQLException ex) {
            System.out.println(ex);


        }
        


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ServletContext sc = this.getServletContext();
        String flightFrom = request.getParameter("flightFrom");
        String flightTo = request.getParameter("flightTo");
        String flightDate = request.getParameter("flightDate");
        try {
            request.setAttribute("flights", fls.showAllFlights(flightFrom, flightTo, flightDate));

        } catch (SQLException ex) {
            System.out.println(ex);


        }

        RequestDispatcher view = sc.getRequestDispatcher("/printFlights.jsp");
        view.forward(request, response);
    }
}




/**
    FlightSearchLogic fsl = new FlightSearchLogic();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



       response.setContentType("text//html");
        PrintWriter out = response.getWriter();

        String flightFrom = request.getParameter("flightFrom");
        String flightTo = request.getParameter("flightTo");
        Date flightDate = (Date) request.getAttribute("flightDate");
        ServletContext sc = this.getServletContext();

        try {
            request.setAttribute("flights", fsl.showAllFlights(flightFrom, flightTo, flightDate));

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        RequestDispatcher view = sc.getRequestDispatcher("/printFlights.jsp");
        view.forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = this.getServletContext();
       RequestDispatcher view = sc.getRequestDispatcher("/printFlights.jsp");
       view.forward(request, response);



    }
}

*/