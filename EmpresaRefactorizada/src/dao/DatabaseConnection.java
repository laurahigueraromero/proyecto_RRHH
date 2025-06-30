package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;
    private static boolean driverLoaded = false;
    private static String url = "jdbc:mysql://localhost:3306/empleadosProyecto";
    private static String user = "root";
    private static String password = "userroot";   

    private static void loadDriver() {
        if (!driverLoaded) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                driverLoaded = true;
            } catch (ClassNotFoundException e) {
                System.err.println("Error: No se encontró el controlador MySQL JDBC.");
                System.err.println("Por favor, asegúrate de que mysql-connector-j-9.3.0.jar está en tu classpath.");
                e.printStackTrace();
            }
        }
    }

    private static void createTablaEmpleados() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            
            String createTableSQL = "CREATE TABLE IF NOT EXISTS empleados (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nombre VARCHAR(50) NOT NULL," +
                "apellidoUno VARCHAR(50) NOT NULL," +
                "apellidoDos VARCHAR(50)," +
                "movil VARCHAR(20)," +
                "email VARCHAR(100)," +
                "registrado BOOLEAN DEFAULT false)";
                
            stmt.executeUpdate(createTableSQL);
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla empleados: " + e.getMessage());
        }
    }
    
    public static Connection getConnection() {
        if (!driverLoaded) {
            loadDriver();
        }
        
        if (connection == null || !isConnected()) {
            try {
                connection = DriverManager.getConnection(
                   url,
                    user,
                    password
                );
                createTablaEmpleados();
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
