package servlets.adminSearch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "adminSearchServlet", urlPatterns = {"/adminSearch"})
public class adminSearchServlet extends HttpServlet {
    adminSearchLogic SL = new adminSearchLogic();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServletContext sc = this.getServletContext();
        try
        {
            request.setAttribute("searches", SL.selectAll());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = sc.getRequestDispatcher("/printTickets.jsp");
        view.forward(request, response);
    }
}
