package classes;

public class AdminSearch {
    private int flightID;
    private String customerID;

    public AdminSearch(int flightID, String customerID){
        this.flightID = flightID;
        this.customerID = customerID;
    }

    public AdminSearch()
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
