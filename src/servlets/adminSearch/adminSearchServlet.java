package servlets.adminSearch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "adminSearchServlet", urlPatterns = {"/adminSearch"})
public class adminSearchServlet extends HttpServlet {
    adminSearchLogic SearchLogic = new adminSearchLogic();
    adminSearch adminSearch = new adminSearch();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            SearchLogic.getTickets(adminSearch);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
