package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;
import modelo.Fichaje;

public class FichajeDao {
    Scanner sc = new Scanner(System.in);

    public void insertarFichajeDao(String idEmpleadoStr, String tipo) throws SQLException {
        if (idEmpleadoStr == null || idEmpleadoStr.trim().isEmpty()) {
            System.out.println("El ID del empleado no es válido. No se puede insertar el fichaje.");
            return;
        }

        // Convertir String a int y añadir debug
        int idEmpleado;
        try {
            idEmpleado = Integer.parseInt(idEmpleadoStr.trim());
            System.out.println("DEBUG: Intentando insertar fichaje para empleado ID: " + idEmpleado);
        } catch (NumberFormatException e) {
            System.out.println("Error: El ID del empleado debe ser un número válido.");
            return;
        }

        String insert = "INSERT INTO fichajes (tipo, registro, idEmpleado) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); // Usar método estático
             PreparedStatement pstmt = conn.prepareStatement(insert)) {
             
            pstmt.setString(1, tipo);
            pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setInt(3, idEmpleado); // Usar setInt en lugar de setString
            
            int records = pstmt.executeUpdate();
            if (records > 0) {
                System.out.println("Fichaje registrado exitosamente para empleado ID: " + idEmpleado);
            } else {
                System.out.println("No se pudo registrar el fichaje.");
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar fichaje: " + e.getMessage());
            throw e;
        }
    }

    public void listarFichajes(Fichaje fichaje) {
        // Implementar método
    }
}