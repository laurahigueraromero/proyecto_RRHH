package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BajasDao {

	public void confirmarDatos(String nombre, String apellidoUno, String apellidoDos, String movil, String email) {
		try {
			Connection conn = DatabaseConnection.getConnection();
			String deleteFichajes = "DELETE FROM fichajes WHERE idEmpleado IN (SELECT idEmpleado FROM empleado WHERE nombre = ? AND apellidoPrimero = ? AND apellidoSegundo = ? AND movil = ? AND email = ?)";
			String deleteEmpleado = "DELETE FROM empleado WHERE nombre = ? AND apellidoPrimero = ? AND apellidoSegundo = ? AND movil = ? AND email = ?";

			PreparedStatement pstmt1 = conn.prepareStatement(deleteFichajes);
			PreparedStatement pstmt2 = conn.prepareStatement(deleteEmpleado);
			pstmt1.setString(1, nombre);
			pstmt1.setString(2, apellidoUno);
			pstmt1.setString(3, apellidoDos);
			pstmt1.setString(4, movil);
			pstmt1.setString(5, email);

			pstmt2.setString(1, nombre);
			pstmt2.setString(2, apellidoUno);
			pstmt2.setString(3, apellidoDos);
			pstmt2.setString(4, movil);
			pstmt2.setString(5, email);

			int rowsFichajes = pstmt1.executeUpdate();
			int rowsEmpleado = pstmt2.executeUpdate();

			System.out.println("Fichajes eliminados: " + rowsFichajes);
			System.out.println("Empleados eliminados: " + rowsEmpleado);
			if (rowsEmpleado < 1) {
				System.out.println("no se ha encontrado al empleado en la base de datos");
			}

			pstmt1.close();
			pstmt2.close();
			DatabaseConnection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
