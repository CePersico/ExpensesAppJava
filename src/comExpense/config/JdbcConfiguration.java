package comExpense.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfiguration {

    // conexión a DB: GESTIONDB
        private static final String DB_DRIVER = "org.h2.Driver";
        private static final String DB_URL = "jdbc:h2:~/gestionDB";
        private static final String DB_USER = "sa";
        private static final String DB_PASSWORD = "";

        public static Connection getConnection() {
            try {
                Class.forName(DB_DRIVER);
                return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

}
