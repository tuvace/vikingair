package servlets.adminSearch;

public class adminSearch {
    private int flightID;
    private String customerID;

    public adminSearch(int flightID, String customerID){
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
    public int getFlightID()
    {
        return flightID;
    }
    public void setFlightID(int flightID)
    {
        this.flightID = flightID;
    }
    public void setCustomerID(String customerID)
    {
        this.customerID = customerID;
    }

}
