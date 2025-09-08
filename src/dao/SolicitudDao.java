package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SolicitudDao {

    /**
     * Inserta una nueva solicitud de vacaciones en la base de datos.
     * @param idEmpleado El ID del empleado que realiza la solicitud.
     * @param fechaInicio La fecha de inicio de las vacaciones (en formato "YYYY-MM-DD").
     * @param fechaFin La fecha de fin de las vacaciones (en formato "YYYY-MM-DD").
     * @return true si la solicitud se insertó correctamente, false en caso contrario.
     */
    public boolean insertarSolicitudDao(String idEmpleado, String fechaInicio, String fechaFin) {

        String sql = "INSERT INTO solicitud (idEmpleado, fechaInicio, fechaFin) VALUES (?, ?, ?)";

        // Usar try-with-resources para asegurar que la conexión y el statement se cierren automáticamente
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idEmpleado);
            pstmt.setDate(2, Date.valueOf(fechaInicio));  // Convertir String a java.sql.Date
            pstmt.setDate(3, Date.valueOf(fechaFin));

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("✅ Solicitud de vacaciones insertada correctamente.");
                return true;
            } else {
                System.out.println("❌ No se pudo insertar la solicitud.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar la solicitud: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}