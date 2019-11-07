package servlets.adminSearch;

import dbcode.dbUtilities;

import java.sql.*;

public class adminSearchLogic
{
    dbUtilities db = new dbUtilities();
    adminSearch adminSearch = new adminSearch();
    public void getTickets(adminSearch adminSearch) throws SQLException
    {
        adminSearch.getFlight_ID();
        try
        {
            String sql = "SELECT Customer FROM Ticket";

            Connection con = db.connect();

            PreparedStatement myStmt = con.prepareStatement(sql);

            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next())
            {
                String firstName =rs.getString("firstName");
                String middleName = rs.getString("middleName");
                String lastName =rs.getString("lastName");
                System.out.format("%s, %s, %s", firstName, middleName, lastName);
            }
            con.close();
        }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
    }
}
