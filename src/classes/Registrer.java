package classes;

public class Registrer
{
    private String firstName;
    private String lastName;
    private String customerAddress;
    private String email;
    private String phoneNumber;
    private String gender;
    private String password;


    public Registrer()
    {
    }
    public Registrer(String firstName, String lastName, String customerAddress, String email, String phoneNumber, String gender, String password)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.customerAddress=customerAddress;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.gender=gender;
        this.password=password;

    }

    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getCustomerAddress()
    {
        return customerAddress;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getGender()
    {
        return gender;
    }
    public String getPassword()
    {
        return password;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String last_name)
    {
        this.lastName = lastName;
    }
    public void setCustomerAddress(String customerAddress)
    {
        this.customerAddress = customerAddress;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}
