package dao.implementation;

import org.postgresql.jdbc3.Jdbc3PoolingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastro", "postgres", "12345");
        return connection;
    }
}
