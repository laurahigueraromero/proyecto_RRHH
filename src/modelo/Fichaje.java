package modelo;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

import dao.FichajeDao;

public class Fichaje {
	Scanner sc = new Scanner(System.in);
	private int id;
	private Empleado empleado;
	private LocalDateTime fechaHora;
	private String tipo; // "entrada" o "salida"

	public Fichaje() {
	}

	public Fichaje(int id, Empleado empleado, LocalDateTime fechaHora, String tipo) {
		this.id = id;
		this.empleado = empleado;
		this.fechaHora = fechaHora;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void insertarFichaje(String idEmpleado, String tipo) throws SQLException {

		// meter un login de empleado
		// solicitar vacaciones
		// TODO: menu de empleado
		System.out.println("inserte id de empleado");
		idEmpleado = sc.nextLine();
		System.out.println("Escriba entrada o salida");
		tipo= sc.nextLine();
		FichajeDao fd = new FichajeDao();
		fd.insertarFichajeDao(idEmpleado, tipo);

	}
	

}
