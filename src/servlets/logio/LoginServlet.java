package servlets.logio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

@WebServlet(
        urlPatterns = {"/servlets.logio.LoginServlet"})

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String user_password = request.getParameter("user_password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            boolean validate = LoginLogic.validate(username,user_password);

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
}
