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


@WebServlet(name="LoginServlet", urlPatterns ={"/LoginServlet"})

public class LoginServlet extends HttpServlet {
    CustomerLogic login = new CustomerLogic();
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String userPassword = request.getParameter("userPassword");
        System.out.print(userPassword);

        try{
            boolean validate = LoginLogic.validate(username, userPassword);

            if (validate)
            {
                out.print("<h1>Welcome " + username + "</h1>");
            }
            else {
                out.print("Sorry username or password error");
                RequestDispatcher rd=request.getRequestDispatcher("index.html");
                rd.include(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Username: " + username);
        // get response writer
        PrintWriter writer = response.getWriter();

        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Welcome " + username + "<br/>";
        htmlRespone += "Travel safe </h2>";
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("userPassword");

        Customer customer = login.login(username, password);

        HttpSession session = request.getSession();

        session.setAttribute("customer", customer);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    }
