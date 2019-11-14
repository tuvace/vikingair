package servlets.registrer;

import servlets.customers.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import servlets.customers.CustomerLogic;
import servlets.logio.Login;

@WebServlet(name = "registrerServlet", urlPatterns = {"/registrerServlet"})
public class registrerServlet extends HttpServlet
{
    registrerLogic registrerLogic = new registrerLogic();
    CustomerLogic logic = new CustomerLogic();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String first = request.getParameter("firstName");
        String last = request.getParameter("lastName");
        String address = request.getParameter("customer_address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String disabilities = request.getParameter("disabilities");
        String password = request.getParameter("password");
        registrer regi = new registrer(first, last, address, email, phone, gender, disabilities, password);

        try
        {
            registrerLogic.addKunde(regi);
            if(logic != null)
            {
                Customer customer = logic.login(email,password);
                HttpSession session = request.getSession();
                session.setAttribute("customer", customer);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else
            {
                request.getSession().invalidate();
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                System.out.println("Username or password is wrong");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
