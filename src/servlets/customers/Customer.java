package servlets.customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Customer")
public class Customer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private int customerID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String customerAddress;
    private int disabilities;
    private String email;


    public Customer() {
        super();
        this.email = email;
        this.customerID = customerID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.customerAddress = customerAddress;
        this.disabilities = disabilities;


    }


    public String fullName(String fullName) {
        fullName = (firstName+lastName);
        return fullName;
    }

    public String setFirstName(String firstName) {
        return firstName;
    }

    public String setLastName(String lastName) {
        return lastName;
    }

    public String setMiddleName (String middleName) {
        return middleName;
    }

    public String setCustomerAddress (String customerAddress) {
        return customerAddress;
    }

    public int setDisabilities (int disabilities) {
        return disabilities;
    }




    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void setMail(String email) {

        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("You must provide a valid email address");
        }

    }
}
