package servlets.registrer;

import dbcode.dbUtilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registrerLogic {
    dbUtilities db = new dbUtilities();

    public void addKunde(Registrer registrer) throws SQLException {
        PreparedStatement cs;
        Connection con = db.connect();
        try {
            String Customer = "insert into Customer (firstName, lastName, customerAddress, gender) "+"values(?, ?, ?, ?)";
            cs = con.prepareStatement(Customer);
            cs.setString(1, registrer.getFirstName());
            cs.setString(2, registrer.getLastName());
            cs.setString(3, registrer.getCustomerAddress());
            cs.setString(4, registrer.getGender());
            cs.execute();
            cs.close();

            String phone = "insert into phone (CustomerID, phoneNumber)" + "values(last_insert_id(), ?)";
            cs=con.prepareStatement(phone);
            cs.setString(1, registrer.getPhoneNumber());
            cs.execute();
            cs.close();

            String email = "insert into email(CustomerID, email)"+ "values(last_insert_id(), ?)";
            cs=con.prepareStatement(email);
            cs.setString(1, registrer.getEmail());
            cs.execute();
            cs.close();

            String password = "insert into UserRoles(customerID, roleID, userPassword)"+ "values(last_insert_id(), 2, ?)";
            cs=con.prepareStatement(password);
            cs.setString(1, registrer.getPassword());
            cs.execute();
            cs.close();
            System.out.println(registrer);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}

