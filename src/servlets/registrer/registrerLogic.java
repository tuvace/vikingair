package servlets.registrer;

import dbcode.dbUtilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registrerLogic {
    dbUtilities db = new dbUtilities();

    public void addKunde(Registrer regi) throws SQLException {
        PreparedStatement cs;
        Connection con = db.connect();
        try {
            String Customer = "insert into Customer (firstName, lastName, customerAddress, gender)"+"values(?, ?, ?, ?)";
            cs = con.prepareStatement(Customer);
            cs.setString(1, regi.getFirstName());
            cs.setString(2, regi.getLastName());
            cs.setString(3, regi.getCustomerAddress());
            cs.setString(4, regi.getGender());
            cs.execute();
            cs.close();

            String phone = "insert into phone (CustomerID, phoneNumber)" + "values(last_insert_id(), ?)";
            cs=con.prepareStatement(phone);
            cs.setString(1, regi.getPhoneNumber());
            cs.execute();
            cs.close();

            String email = "insert into email(CustomerID, email)"+ "values(last_insert_id(), ?)";
            cs=con.prepareStatement(email);
            cs.setString(1, regi.getEmail());
            cs.execute();
            cs.close();

            String password = "insert into UserRoles(customerID, roleID, userPassword)"+ "values(last_insert_id(), 2, ?)";
            cs=con.prepareStatement(password);
            cs.setString(1, regi.getPassword());
            cs.execute();
            cs.close();
            System.out.println(regi);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}

