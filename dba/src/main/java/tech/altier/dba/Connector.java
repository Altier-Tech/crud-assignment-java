package tech.altier.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static final String _DB_URL = "jdbc:mysql://localhost:3306/inventory";
    private static final String _USERNAME = "root";
    private static final String _PASSWORD = "";

    private static Connection _connection;

    static {
        try {
            _connection = connect();
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean createTable() {
        String SQL =    "CREATE TABLE IF NOT EXISTS `inventory`.`items` (\n" +
                        "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `name` VARCHAR(45) NOT NULL,\n" +
                        "  `description` VARCHAR(45) NOT NULL,\n" +
                        "  `quantity` INT NOT NULL,\n" +
                        "  `price` DOUBLE NOT NULL,\n" +
                        "  PRIMARY KEY (`id`));";

        try {
            _connection.createStatement().execute(SQL);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(_DB_URL, _USERNAME, _PASSWORD);
    }
}
