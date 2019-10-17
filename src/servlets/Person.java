package servlets;

import sun.util.calendar.LocalGregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "Person")
public class Person extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

// Personalia

        private String firstName;
        private String middleName;
        private String lastName;
        private static Date DOB;
        private int phoneNumber;
        private String address;}

        /**public Person(String n, int pn, String ad) {
            Name = n;
            phoneNumber = pn;
            address = ad;
            System.out.println(n + " " + pn + " " + ad);
        }

        public void setName(String n) {
            this.Name = n;
        }

        public void setPhoneNumber(int pn) {
            phoneNumber = pn;
        }

        public void setAddress(String ad) {
            address = ad;
        }

        public String getName() {
            return Name;
        }

        public int getPhoneNumber() {
            return phoneNumber;
        }

        public String getAddress() {
            return address;
        }
    }
*/
