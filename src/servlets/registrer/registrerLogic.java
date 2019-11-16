package servlets.registrer;

import dbcode.dbUtilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registrerLogic {
    dbUtilities db = new dbUtilities();

    public void addKunde(Registrer registrer) throws SQLException {
        CallableStatement cs;
        Connection con = db.connect();
        try {
            String query = "{CALL proc_create_new_profile(?, ?, ?, ?, ?, ?, ? )}";
            cs = con.prepareCall(query);
            cs.setString(1, registrer.getFirstName());
            cs.setString(2, registrer.getLastName());
            cs.setString(3, registrer.getCustomerAddress());
            cs.setString(5, registrer.getGender());
            cs.setString(6, registrer.getPhoneNumber());
            cs.setString(7, registrer.getEmail());
            cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}

