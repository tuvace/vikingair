package servlets.registrer;

import dbcode.dbUtilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registrerLogic {
    dbUtilities db = new dbUtilities();
    public void addKunde(registrer registrer) throws SQLException
    {
        PreparedStatement cs;
        String customer = "insert into Customer(firstName, lastName, customerAddress, disabilities, gender)"+" values (?,?,?,?,?)";
        String phone ="insert into Phone(phoneNumber, customerID)"+ "values (?, last_insert_id())";
        String email = "insert into Email(email, customerID)"+ "values(?, last_insert_id())";
        String password = "insert into UserRoles(userPassword, roleID, customerID)"+"values(?,2,last_insert_id())";
        Connection con = db.connect();
        try
        {
           try
           {
               cs = con.prepareCall(customer);
               cs.setString(1, registrer.getFirstName());
               cs.setString(2, registrer.getLastName());
               cs.setString(3, registrer.getCustomer_address());
               cs.setString(4, registrer.getDisabilities());
               cs.setString(5, registrer.getGender());
               cs.executeQuery();
           }
           catch (SQLException e)
           {
               e.printStackTrace();
           }
           try
           {
               cs = con.prepareCall(phone);
               cs.setString(1, registrer.getPhone());
               cs.executeQuery();
           }
           catch (SQLException e)
           {
               e.printStackTrace();
           }
            try
           {
               cs = con.prepareCall(email);
               cs.setString(1, registrer.getEmail());
               cs.executeQuery();
           }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            try
           {
               cs = con.prepareCall(password);
               cs.setString(1, registrer.getPassword());
               cs.executeQuery();
           }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        finally {
            if(con != null)
            {
                con.close();
            }
        }
    }
}
