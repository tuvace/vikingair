package servlets.registrer;

public class registrer
{
    private String firstName;
    private String lastName;
    private String customer_address;
    private String email;
    private String phone;
    private String gender;
    private String password;
    private String disabilities;

    public registrer()
    {
    }
    public registrer(String firstName, String lastName, String customer_address, String email, String phone, String gender, String password, String disabilities)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.customer_address=customer_address;
        this.email=email;
        this.phone=phone;
        this.gender=gender;
        this.password=password;
        this.disabilities=disabilities;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getCustomer_address()
    {
        return customer_address;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPhone()
    {
        return phone;
    }
    public String getGender()
    {
        return gender;
    }
    public String getPassword()
    {
        return password;
    }
    public String getDisabilities()
    {
        return disabilities;
    }
    public void setDisabilities(String disabilities)
    {
        this.disabilities = disabilities;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLast_name(String last_name)
    {
        this.lastName = lastName;
    }
    public void setCustomer_address(String customer_address)
    {
        this.customer_address = customer_address;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
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
