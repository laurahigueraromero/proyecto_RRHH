package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import modelo.Empleado;

public class EmpleadoDao {
	Scanner sc = new Scanner(System.in);

	DatabaseConnection dataConn = new DatabaseConnection();

	public void buscarEmpleado(String name, String surName) throws SQLException {

		Connection conn = dataConn.getConnection();

		String select = "select * from empleado where nombre = ? and apellidoPrimero = ?";

		PreparedStatement pst = conn.prepareStatement(select);

		pst.setString(1, name);
		pst.setString(2, surName);

		ResultSet rs = pst.executeQuery();

		boolean encontrado = false;
		int id=0;
		while (rs.next()) {
			id = rs.getInt("idEmpleado");
			String nombre = rs.getString("nombre");
			String apellidoPrimero = rs.getString("apellidoPrimero");
			String apellidoSegundo = rs.getString("apellidoSegundo");
			String movil = rs.getString("movil");
			String email = rs.getString("email");

			System.out.println("ID: " + id);
			System.out.println("Nombre: " + nombre);
			System.out.println("Apellido Primero: " + apellidoPrimero);
			System.out.println("Apellido Segundo: " + apellidoSegundo);
			System.out.println("movil: " + movil);
			System.out.println("email: " + email);
			System.out.println("-----");

			encontrado = true;

		}

		if (!encontrado) {
			System.out.println("No se encontró el empleado.");
		} else {

			System.out.print("¿Desea ver los avisos de este empleado? (s/n): ");
			String respuesta = sc.nextLine();

			if (respuesta.equalsIgnoreCase("s")) {
				mostrarAvisos(id);
			}
		}

		rs.close();
		pst.close();
		conn.close();
	}

	public void mostrarAvisos(int idEmpleado) throws SQLException {
		Connection conn = dataConn.getConnection();

		String select = "SELECT * FROM notas WHERE idEmpleado = ?";
		PreparedStatement pst = conn.prepareStatement(select);
		pst.setInt(1, idEmpleado);

		ResultSet rs = pst.executeQuery();

		boolean tieneNotas = false;
		while (rs.next()) {
			String nota = rs.getString("nota");

			System.out.println("Nota: " + nota);
			tieneNotas = true;
		}

		if (!tieneNotas) {
			System.out.println("Este empleado no tiene avisos.");
		}

		rs.close();
		pst.close();
		conn.close();
	}

}
