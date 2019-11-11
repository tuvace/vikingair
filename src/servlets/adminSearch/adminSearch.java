package servlets.adminSearch;

public class adminSearch {
    private String flightID;
    private String customerID;

    public adminSearch(String flight_ID, String customerID){
        this.flightID = flightID;
        this.customerID = customerID;
    }

    public adminSearch()
    {
    }

    public String getFlight_ID()
    {
        return flightID;
    }
    public void setFlightID(String flightID)
    {
        this.flightID = flightID;
    }
    public void setCustomerID(String customerID)
    {
        this.customerID = customerID;
    }

}
