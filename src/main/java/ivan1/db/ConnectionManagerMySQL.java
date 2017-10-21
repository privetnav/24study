package ivan1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerMySQL  implements IConnectionManager{
    private static final ConnectionManagerMySQL INSTANCE = new ConnectionManagerMySQL();
    private Connection connection;

    private ConnectionManagerMySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Study24",
                            "root",
                            "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionManagerMySQL getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }
}
