package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AltasDao {
    
    public AltasDao() {
        // Constructor vacío
    }
    
    public void confirmarDatos(String nombre, String apellidoUno, String apellidoDos, 
                               String movil, String email) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO empleado (nombre, apellidoPrimero, apellidoSegundo, movil, email) " +
                       "VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidoUno);
            pstmt.setString(3, apellidoDos);
            pstmt.setString(4, movil);
            pstmt.setString(5, email);
    
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Filas insertadas: " + rowsAffected);
            pstmt.close();
            DatabaseConnection.closeConnection();
            
            
        } catch (SQLException e) {
        	 System.err.println("Error al insertar datos del empleado:");
             e.printStackTrace();

        }
    }
}
