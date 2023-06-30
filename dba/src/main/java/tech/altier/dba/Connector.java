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

    public static void closeConnection() {
        try {
            _connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return _connection;
    }

    private static int getCount() throws SQLException {
        String SQL = "SELECT COUNT(*) FROM `inventory`.`items`;";
        var result = _connection.createStatement().executeQuery(SQL);
        result.next();
        System.out.println("Number of records: " + result.getInt(1));
        return result.getInt(1);
    }

    public static Item[] getAllItems() throws SQLException {
        // get number of items in the items table
        int count = getCount();

        // query the database for all items in the items table
        String SQL = "SELECT * FROM `inventory`.`items`";

        Item[] items = new Item[count];

        // execute query
        try {
            var result = _connection.createStatement().executeQuery(SQL);

            // loop through the result set
            int i = 0;
            while (result.next()) {
                // create a new item
                Item item = new Item(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description"),
                        result.getInt("quantity"),
                        result.getDouble("price")
                );

                // add the item to the items array
                items[i] = item;

                // increment the counter
                i++;
            }

            // return the items array
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean delete(Item item) {
        return delete(item.getId());
    }

    public static boolean delete(int id) {
        String SQL = "DELETE FROM `inventory`.`items` WHERE (`id` = '" + id + "');";

        try {
            _connection.createStatement().execute(SQL);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean editItem(Item item) {
        return edit(item.getId(), item.getName(), item.getDescription(), item.getQuantity(), item.getPrice());
    }

    public static boolean edit(int id, String name, String description, int quantity, double price) {
        String SQL = "UPDATE `inventory`.`items` SET `name` = '" + name + "', `description` = '" + description + "', `quantity` = '" + quantity + "', `price` = '" + price + "' WHERE (`id` = '" + id + "');";

        try {
            _connection.createStatement().execute(SQL);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Item getItemByID(int id) {
        String SQL = "SELECT * FROM `inventory`.`items` WHERE `id` = " + id + ";";

        try {
            var result = _connection.createStatement().executeQuery(SQL);
            if (result.next()) {
                return new Item(result.getInt("id"), result.getString("name"), result.getString("description"), result.getInt("quantity"), result.getDouble("price"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addItem(Item item) {
        return add(item.getName(), item.getDescription(), item.getQuantity(), item.getPrice());
    }

    public static boolean add(String name, String description, int quantity, double price) {
        String SQL = "INSERT INTO `inventory`.`items` (`name`, `description`, `quantity`, `price`) VALUES ('" + name + "', '" + description + "', '" + quantity + "', '" + price + "');";

        try {
            _connection.createStatement().execute(SQL);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void createTable() {
        String SQL =    "CREATE TABLE IF NOT EXISTS `inventory`.`items` (\n" +
                        "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `name` VARCHAR(45) NOT NULL,\n" +
                        "  `description` VARCHAR(45) NOT NULL,\n" +
                        "  `quantity` INT NOT NULL,\n" +
                        "  `price` DOUBLE NOT NULL,\n" +
                        "  PRIMARY KEY (`id`));";

        try {
            _connection.createStatement().execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(_DB_URL, _USERNAME, _PASSWORD);
    }
}
