package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NotaDao {
	DatabaseConnection dataConn = new DatabaseConnection();
	Scanner sc = new Scanner(System.in);

	public void registrarNota(String id) throws SQLException {

		Connection conn = dataConn.getConnection();

		String select = "select idEmpleado from notas where idEmpleado = ?";

		PreparedStatement ps = conn.prepareStatement(select);

		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();

		System.out.println("Escriba nota:");
		String note = sc.nextLine();
		String insert = "INSERT INTO notas (idEmpleado, nota) VALUES (?, ?)";
		PreparedStatement ps2 = conn.prepareStatement(insert);
		ps2.setString(1, id);
		ps2.setString(2, note);
		int row = ps2.executeUpdate();
		if (row > 0) {
			System.out.println("nota registrada");
		}
		ps.close();
		ps2.close();
		dataConn.closeConnection();

	}

}
