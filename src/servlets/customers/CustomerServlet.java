package servlets.customers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Denne servletten er en kontroller.

/** This class functions as the servlet class for Customer and works as a mediator between the user of
 * our system and the system. */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet"})
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CustomerLogic cusLog;

    //This is the constructor for CustomerServlet
    public CustomerServlet(){
        super();
        cusLog = new CustomerLogic();
    }

    /** This doPost method is responsible for updating and posting/sending information to the server according to what the input from the user is.
     * The method is responsible for receiving information from new customers when they are signing up. */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer cus = new Customer();

        String customerID = request.getParameter("customerID");
        cus.setFirstName(request.getParameter("firstName"));
        cus.setLastName(request.getParameter("lastName"));
        cus.setEmail(request.getParameter("email"));
        //Burde ha:
        //cus.setDateOfBirth(request.getParameter("dateOfBirth"));
        //cus.setPassword(request.getParameter("password"));

        //Trenger både en create og update metode i CustomerLogic for å fungere.
        if (customerID == null || customerID.isEmpty()) {

            cusLog.create(cus);
        } else {
            int cus_customerID = Integer.parseInt(customerID.trim());
            cus.setCustomerID(cus_customerID);
            cusLog.update(cus);

        }
        System.out.println(cus);

        //response.sendRedirect("customerRedirect.jsp");
        RequestDispatcher redirect = request.getRequestDispatcher("login.jsp");
        redirect.forward(request, response);
    }

    /** This doGet method is responsible for getting information from the server, in this case the actions printall, delete and update already
     * existing customers.  */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = this.getServletContext();
        String forward;
        String action = request.getParameter("action");

        //Trenger en showAll metode i CustomerLogic for å fungere.
        if(action.equalsIgnoreCase("printall")) {
            forward = "/printCustomers.jsp";
            try {
                request.setAttribute("customers", cusLog.showAll());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Trenger en delete metode i CustomerLogic for å fungere.
        } else if(action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("cus_id"));
            cusLog.delete(id);
            forward = "/printCustomers.jsp";
            request.setAttribute("customers", cusLog.showAll());

        } else if(action.equalsIgnoreCase("update")){
            forward = "/signup.jsp";
            int id = Integer.parseInt(request.getParameter("cus_id"));

         //Trenger en showOne metode i CustomerLogic for å fungere.
            try {
                Customer cus = cusLog.showOne(id);
                request.setAttribute("customer", cus);

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        else{
            forward="/index.jsp";
        }
        RequestDispatcher view = sc.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
