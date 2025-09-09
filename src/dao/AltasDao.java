package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement;   
import java.util.Scanner;

public class AltasDao {
    Scanner sc = new Scanner(System.in);
    
    public AltasDao() {
        // Constructor vacío
    }
    
    public void confirmarDatos(String nombre, String apellidoUno, String apellidoDos,
                              String movil, String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO empleado (nombre, apellidoPrimero, apellidoSegundo, movil, email) " +
                        "VALUES (?, ?, ?, ?, ?)";
            
           
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidoUno);
            pstmt.setString(3, apellidoDos);
            pstmt.setString(4, movil);
            pstmt.setString(5, email);
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Filas insertadas: " + rowsAffected);
            
            // Obtener el ID del empleado recién insertado
            generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idEmpleadoGenerado = generatedKeys.getInt(1);
                System.out.println("Empleado creado con ID: " + idEmpleadoGenerado);
                
                // Llamar a crearLogin con el ID generado
                crearLogin(idEmpleadoGenerado);
            } else {
                System.err.println("No se pudo obtener el ID del empleado generado");
            }
            
        } catch (SQLException e) {
            System.err.println("Error al insertar datos del empleado:");
            e.printStackTrace();
        } finally {
            // Cerrar recursos en orden inverso
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (pstmt != null) pstmt.close();
                DatabaseConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void crearLogin(int idEmpleado) {
        String tipo = "empleado";
        System.out.println("\n--- Crear usuario para empleado ID: " + idEmpleado + " ---");
        System.out.println("Introduce usuario: ");
        String usuario = sc.nextLine();
        System.out.println("Introduce contraseña: ");
        String pass = sc.nextLine();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DatabaseConnection.getConnection();
            String insert = "INSERT INTO usuario (idEmpleado, login, pass, tipo) VALUES (?, ?, ?, ?)";
            
            pstmt = conn.prepareStatement(insert);
            pstmt.setInt(1, idEmpleado);
            pstmt.setString(2, usuario);
            pstmt.setString(3, pass);
            pstmt.setString(4, tipo);
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Usuario creado: " + rowsAffected + " fila(s)");
            
        } catch (SQLException e) {
            System.err.println("Error al insertar login del empleado:");
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (pstmt != null) pstmt.close();
                DatabaseConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}