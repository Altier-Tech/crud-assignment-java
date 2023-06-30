package tech.altier.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    // connect to localhost mysql server
    // with username root and password blank
    // and database name inventory
    private static final String _DB_URL = "jdbc:mysql://localhost:3306/inventory";
    private static final String _USERNAME = "root";
    private static final String _PASSWORD = "";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(_DB_URL, _USERNAME, _PASSWORD);
    }
}
