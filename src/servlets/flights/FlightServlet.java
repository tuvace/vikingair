//package servlets.flights;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

//Denne servletten er en kontroller.
//@WebServlet("/FlightServlet")
/** public class FlightServlet extends HttpServlet {
    FlightLogic fl = new FlightLogic();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Flight> flights = fl.selectAll();

        for(Flight f: flights){
            System.out.println(f);
        }



       }





    }

*/