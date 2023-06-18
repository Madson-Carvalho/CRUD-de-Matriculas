package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
        private static final String URL = "jdbc:mysql://localhost:3306/matriculas";
        private static final String USER = "root";
        private static final String PASSWORD = "Silent2*";

        private static Connection connection;

        private ConnectionFactory() {}

        public static Connection getConexao() throws SQLException {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }

            return connection;
        }
}
