package ivan1.db;

import java.sql.Connection;

public interface IConnectionManager {
    Connection getConnection();
}
