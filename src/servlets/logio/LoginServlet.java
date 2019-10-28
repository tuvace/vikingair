package servlets.logio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import servlets.logio.LoginLogic;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String user_password = request.getParameter("user_password");
        Login Login = new Login(username, user_password);

        try{
            LoginLogic.validate(Login);
            if (status = false)
            {
                String htmlRespone = "<html>";
                htmlRespone += "<h2>Welcome " + username + "<br/>";
                htmlRespone += "Travel safe </h2>";
                htmlRespone += "</html>";
            }
            else {

            }
        } catch (ClassNotFoundException e) {
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
