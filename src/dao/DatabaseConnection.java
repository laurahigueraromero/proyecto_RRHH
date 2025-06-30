package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConnection {
    private static Connection connection = null;
    private static boolean driverLoaded = false;


    private static final Dotenv dotenv = Dotenv.load();


    private static final String url = dotenv.get("DB_URL");
    private static final String user = dotenv.get("DB_USER");
    private static final String password = dotenv.get("DB_PASSWORD");

    private static void loadDriver() {
        if (!driverLoaded) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                driverLoaded = true;
            } catch (ClassNotFoundException e) {
                System.err.println("Error: No se encontró el controlador MySQL JDBC.");
                System.err.println("Asegúrate de tener mysql-connector-j en tu classpath.");
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        if (!driverLoaded) {
            loadDriver();
        }

        if (connection == null || !isConnected()) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.err.println("Error: No se pudo conectar a la base de datos.");
                System.err.println("Usuario: " + user);
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: No se pudo cerrar la conexión a la base de datos.");
                e.printStackTrace();
            }
        }
    }

    public static boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}