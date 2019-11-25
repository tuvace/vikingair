package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import logics.registrerLogic;
import classes.Registrer;

@WebServlet(name = "registrerServlet", urlPatterns = {"/registrerServlet"})
public class registrerServlet extends HttpServlet
{
    registrerLogic registrerLogic = new registrerLogic();
    //CustomerLogic logic = new CustomerLogic();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServletContext sc = this.getServletContext();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String customerAddress = request.getParameter("customerAddress");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        Registrer regi = new Registrer(firstName, lastName, customerAddress, email, phoneNumber, gender, password);

        try
        {
            registrerLogic.addKunde(regi);
           /** if(logic != null)
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
            }*/
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        RequestDispatcher view = sc.getRequestDispatcher("/login.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
