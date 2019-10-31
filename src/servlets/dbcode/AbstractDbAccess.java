package dbcode;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * This is an abstract superclass for classes that access the database. You do
 * not use it directly, You make subclass for each type of access
 *
 * @author evenal
 */
public abstract class AbstractDbAccess {

    private static final String DATASOURCE_NAME = "jdbc:mysql://localhost:3306/FlightBooking";
    /**comp:env/jdbc/FlightBooking*/
    protected Connection con;

    /** This method runs one query */
    public void accessDb() {
        // getting the connection from a try-with-resources
        // will close it automatically at the end of
        // the try block
        try (Connection con = getConnection()) {
            useConnection();
        }
        catch (NamingException | SQLException e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
        }
    }

    /** this method does the actual db query. */
    public abstract void useConnection();

    /** This method carries out step 1 and 2 */
    Connection getConnection()
            throws NamingException, SQLException {
        // Step 1 - get initialContext
        InitialContext ic = new InitialContext();
        // Step 2 - get datasource from context
        DataSource ds = (DataSource) ic.lookup(DATASOURCE_NAME);
        // Step 3 - get connection from datasource
        return ds.getConnection();
    }

}


