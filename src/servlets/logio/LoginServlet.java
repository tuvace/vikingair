package servlets.logio;

import servlets.customers.Customer;
import servlets.customers.CustomerLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.AuthProvider;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import servlets.logio.LoginLogic;


@WebServlet(name="LoginServlet", urlPatterns ={"/LoginServlet"})

public class LoginServlet extends HttpServlet {
    CustomerLogic login = new CustomerLogic();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String username = request.getParameter("username");
        String password = request.getParameter("userPassword");


        Customer customer = login.login(username, password);
            if (customer != null) {
            HttpSession session = request.getSession();

        session.setAttribute("customer", customer);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else {
           // request.getSession().invalidate();
            request.setAttribute("errormsg", "Brukernavn eller passord er feil.");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
        }
    }





