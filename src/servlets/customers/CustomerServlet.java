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
    private CustomerLogic cusLog;

    //The constructor
    public CustomerServlet(){
        cusLog = new CustomerLogic();
    }

    /** This doPost method is responsible for updating and posting/sending information to the server according to what the input from the user is.
     * The method is responsible for receiving information from new customers when they are signing up.*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer cus = new Customer();

        String customerID = request.getParameter("customerID");
        cus.setFirstName(request.getParameter("firstName"));
        cus.setLastName(request.getParameter("lastName"));
        cus.setEmail(request.getParameter("email"));
        //Burde ha(?):
        //cus.setDateOfBirth(request.getParameter("dateOfBirth"));
        //cus.setPassword(request.getParameter("password"));


        //Hvis det ikke eksisterer noen kunder vil det bli opprettet en.
        if (customerID == null || customerID.isEmpty()) {

            //cusLog.create(cus);

        //
        } else {
            int cus_customerID = Integer.parseInt(customerID.trim());
            cus.setCustomerID(cus_customerID);
            cusLog.update(cus);

        }
        //Printer ut kunder. Burde ha i jsp heller?
        System.out.println(cus);

        //response.sendRedirect("customerRedirect.jsp");
        RequestDispatcher redirect = request.getRequestDispatcher("login.jsp");
        redirect.forward(request, response);
    }

    /** This doGet method is responsible for getting information from the server, in this case the actions printall, delete and update already
     * existing customers.  */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = this.getServletContext();
        String forward;
        String action = request.getParameter("action");

        //Skal kunne vise alle kunder.
        if(action.equalsIgnoreCase("printall")) {
            forward = "/printCustomers.jsp";
            try {
                request.setAttribute("customers", cusLog.showAll());
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Gjør det mulig å slette en kunde fra databasen.
        } else if(action.equalsIgnoreCase("delete")){
            int customerID = Integer.parseInt(request.getParameter("cus_customerID"));
            cusLog.delete(customerID);
            forward = "/printCustomers.jsp";
            try {
                request.setAttribute("customers", cusLog.showAll());
            } catch (SQLException e) {
                e.printStackTrace();
            }

        //Oppdaterer
        } else if(action.equalsIgnoreCase("update")){
            forward = "/signup.jsp"; //Trenger en signup i jsp format.
            int customerID = Integer.parseInt(request.getParameter("cus_customerID"));

        }

        else{
            forward="/index.jsp"; //Index.jsp må oppdateres.
        }
        RequestDispatcher view = sc.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    }