package servlets;

import classes.Customer;
import logics.CustomerLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;


@WebServlet(name="LoginServlet", urlPatterns ={"/LoginServlet"})

public class LoginServlet extends HttpServlet {
    CustomerLogic cuslo = new CustomerLogic();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String username = request.getParameter("username");
        String password = request.getParameter("userPassword");


        //Hvis brukernavn og passord stemmer med databasen vil man bli 'logget inn',
        //session blir tatt i bruk, og man blir sendt til index.jsp.
        Customer customer = cuslo.login(username, password);
            if (customer != null) {
            HttpSession session = request.getSession();

        session.setAttribute("customer", customer);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else {
           // Sender en feilmelding om brukernavn eller passord ikke stemmer med databasen.
            request.setAttribute("errormsg", "Brukernavn eller passord er feil.");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
        }
    }





