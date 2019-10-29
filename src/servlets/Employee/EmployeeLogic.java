package servlets.Employee;

import dbcode.dbUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeLogic {
    dbUtilities db = new dbUtilities();

    public ArrayList<Employee> selectAll() throws SQLException {

        Employee employee = new Employee();

        ArrayList<Employee> employees = new ArrayList<>();

        PreparedStatement myStmt;


        String sql = "SELECT* FROM Employee LIMIT 5";
        Connection con = db.connect();

        try{


            myStmt = con.prepareStatement(sql);

            ResultSet results = myStmt.executeQuery();

            while (results.next()) {
                employee.setEmployeeID(results.getInt("employeeID"));
                employee.setFirstName(results.getString("firstName"));
                employee.setMiddleName(results.getString("middleName"));
                employee.setLastName(results.getString("lastName"));
                employee.setEmployeeAddress(results.getString("employeeAddress"));
                employee.setEmail(results.getString("email"));
                employee.setPhoneNumber(results.getString("phoneNumber"));
            }
        }

        catch (SQLException sqlEX) {
            sqlEX.printStackTrace();
        } finally {
            if(con != null){ con.close();}
        }



        return employees;

    }
}
