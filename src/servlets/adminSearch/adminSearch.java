package servlets.adminSearch;

public class adminSearch {
    private String flightID;
    private String customerID;

    public adminSearch(String flightID, String customerID){
        this.flightID = flightID;
        this.customerID = customerID;
    }

    public adminSearch()
    {
    }
    public String getCustomerID()
    {
        return customerID;
    }
    public String getFlightID()
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
