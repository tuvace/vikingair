package servlets.customers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import servlets.customers.Customer;
import servlets.customers.CustomerLogic;

//Denne servletten er en kontroller.

//DoPost sikker å bruke for å hente ut informasjon.

/** This class functions as the servlet class for Customer and works as a mediator between the user of
 * our system and the system.*/
@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet"})
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    CustomerLogic CustomerLogic = new CustomerLogic();
    Customer Customer = new Customer();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action.equals("editFirstName")) {
            try {
                editFirstName(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("editLastName")) {
            try {
                editLastName(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         if (action.equals("editAddress"))
         {
             try {
                 editAddress(request, response);
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
        if (action.equals("editPhone"))
        {
            try {
                editPhone(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("editEmail"))
        {
            try {
                editEmail(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher redirect = request.getRequestDispatcher("login.jsp");
        redirect.forward(request, response);
    }

    /**
     * This doGet method is responsible for getting information from the server, in this case the actions printall, delete and update already
     * existing customers.
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = this.getServletContext();
        String forward;
        String action = request.getParameter("action");

        //Skal kunne vise alle kunder.
        if (action.equalsIgnoreCase("delete")) {
            int customerID = Integer.parseInt(request.getParameter("customerID"));
            CustomerLogic.delete(customerID);
            forward = "/login.jsp";
            try {
                request.setAttribute("customers", CustomerLogic.showAll());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //Oppdaterer
        } else if (action.equalsIgnoreCase("update")) {
            forward = "/signup.jsp"; //Trenger en signup i jsp format.
            int customerID = Integer.parseInt(request.getParameter("customerID"));

        } else {
            forward = "/index.jsp";
        }
        RequestDispatcher view = sc.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    private void editFirstName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String firstName = request.getParameter("firstName");
        String username = request.getParameter("username");
        ServletContext sc = this.getServletContext();
        int customerID = 0;
        try {
            customerID = CustomerLogic.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            CustomerLogic.updateFirstname(customerID, firstName);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/profil.jsp");
        view.forward(request, response);
    }

    private void editLastName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        ServletContext sc = this.getServletContext();
        int customerID = 0;
        try {
            customerID = CustomerLogic.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            CustomerLogic.updateLastname(customerID, lastName);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/profil.jsp");
        view.forward(request, response);
    }
    private void editAddress(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String customerAddress = request.getParameter("customerAddress");
        String username = request.getParameter("username");
        ServletContext sc = this.getServletContext();
        int customerID = 0;
        try {
            customerID = CustomerLogic.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            CustomerLogic.updateAddress(customerID, customerAddress);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/profil.jsp");
        view.forward(request, response);
    }
    private void editPhone(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String phoneNumber = request.getParameter("phoneNumber");
        String username = request.getParameter("username");
        ServletContext sc = this.getServletContext();
        int customerID = 0;
        try {
            customerID = CustomerLogic.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            CustomerLogic.updatePhone(customerID, phoneNumber);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/profil.jsp");
        view.forward(request, response);
    }
    private void editEmail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        ServletContext sc = this.getServletContext();
        int customerID = 0;
        try {
            customerID = CustomerLogic.getcustomerID(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            CustomerLogic.updateEmail(customerID, email);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = sc.getRequestDispatcher("/profil.jsp");
        view.forward(request, response);
    }
}