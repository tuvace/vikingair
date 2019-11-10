package servlets.adminSearch;

public class adminSearch {
    private String flight_ID;
    private String firstName;
    private String middleName;
    private String lastName;

    public adminSearch(String flight_ID, String firstName, String middleName, String lastName){
        this.flight_ID = flight_ID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public adminSearch()
    {
    }

    public String getFlight_ID()
    {
        return flight_ID;
    }
    public void setFlight_ID(String flight_ID)
    {
        this.flight_ID = flight_ID;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
