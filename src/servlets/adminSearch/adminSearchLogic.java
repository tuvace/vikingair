package servlets.adminSearch;

import dbcode.dbUtilities;
import java.sql.*;
import java.util.ArrayList;

public class adminSearchLogic
{
    dbUtilities db = new dbUtilities();
    public ArrayList<adminSearch> selectAll() throws SQLException
    {
        ArrayList<adminSearch> searches = new ArrayList<>();
        try
        {
            String sql = "SELECT flightID and customerID FROM Ticket";

            Connection con = db.connect();

            PreparedStatement myStmt = con.prepareStatement(sql);

            ResultSet rs = myStmt.executeQuery();

            while (rs.next())
            {
                adminSearch search = new adminSearch();
                search.setFlightID(rs.getString("flightID"));
                search.setCustomerID(rs.getString("customerID"));
                searches.add(search);
            }
            con.close();
        }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        return searches;
    }
}
