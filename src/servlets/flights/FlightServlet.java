package servlets.flights;

import dbcode.dbUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


@WebServlet(name = "FlightServlet", urlPatterns = {"/FlightServlet"})
public class FlightServlet extends HttpServlet {
    FlightLogic fl = new FlightLogic();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     System.out.println(fl.selectAll());



       }





    }

