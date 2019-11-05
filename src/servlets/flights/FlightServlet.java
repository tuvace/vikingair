package servlets.flights;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

//Denne servletten er en kontroller.
@WebServlet(name = "/FlightServlet", urlPatterns = {"/FlightServlet"})
public class FlightServlet extends HttpServlet {
    FlightLogic fl = new FlightLogic();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ServletContext sc = this.getServletContext();

        try {
            request.setAttribute("flights", fl.selectAll());

        }
            catch(SQLException ex){
            System.out.println(ex);


       }

        RequestDispatcher view = sc.getRequestDispatcher("/printFlights.jsp");
        view.forward(request, response);




    }
}
