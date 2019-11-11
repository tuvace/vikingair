package servlets.adminSearch;

import dbcode.dbUtilities;
import servlets.flights.Flight;

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
            String sql = "SELECT Customer FROM Ticket";

            Connection con = db.connect();

            PreparedStatement myStmt = con.prepareStatement(sql);

            ResultSet rs = myStmt.executeQuery();

            while (rs.next())
            {
                adminSearch search = new adminSearch();
                search.setFlight_ID(rs.getString("flight_ID"));
                search.setFirstName(rs.getString("firstName"));
                search.setMiddleName(rs.getString("middleName"));
                search.setLastName(rs.getString("lastName"));
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
