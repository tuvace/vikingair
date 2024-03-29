package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

 // Denne funksjonen stopper session, slik at man blir logget ut, for så å sende bruker til index siden.
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 request.getSession().invalidate();
 response.sendRedirect(request.getContextPath() + "/index.jsp");

     System.out.println("You are logged out!");
 }
}
