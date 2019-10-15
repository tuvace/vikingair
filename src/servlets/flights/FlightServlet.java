package servlets.flights;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import servlets.dbUtilities;

@WebServlet(name = "FlightServlet")
public class FlightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //Get conncection
    public class TestDBConnection {

        public static void main(String[] args) {
            String Url = "jdbc:sqlserver://serverURL;DatabaseName=DBname;user=dbUsername;Password=dbPassword";
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                System.out.println("Trying to connect");
                Connection connection = DriverManager.getConnection(Url);

                System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
                        + connection.getMetaData().getDatabaseProductName());
            } catch (Exception e) {
                System.out.println("Unable to make connection with DB");
                e.printStackTrace();
            }
        }
    }

}
}
