package classes;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Customer")
public class Customer {

    private int customerID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String customerAddress;
    private int disabilities;
    private String email;
    private String phoneNumber;
    private int userID;
    private String role;

    public Customer(int customerID, String firstName, String middleName, String lastName,
                    String customerAddress, int disabilities, String email, String phoneNumber, int userID, String role) {
        super();
        this.customerID = customerID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.customerAddress = customerAddress;
        this.disabilities = disabilities;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userID = userID;
        this.role = role;
    }

    public Customer(){

    }

    public int getCustomerID() { return customerID; }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(int disabilities) {
        this.disabilities = disabilities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserID() { return userID; }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return "Full Name" + firstName + "" + middleName + "" + lastName + "/n"
        + "Address =" + customerAddress + "/n" +
        "Things to know about" + disabilities + "/n" +
        "Email= " + email + "/n" +
        "phoneNumber =" + phoneNumber;
    }

}







    /**
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
     */
