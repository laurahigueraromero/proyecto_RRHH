package modelo;

import java.util.Scanner;
import dao.AltasDao;

public class Altas {

	private Empleado empleado;

	public Altas() {
	}

	public Altas(Empleado empleado) {
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void altaEmpleado() {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("*******Alta empleado*********** ");
			System.out.println("Nombre de empleado: ");
			String nombreEmpleado = sc.nextLine();
			System.out.println("Apellido primero: ");
			String apellidoUno = sc.nextLine();
			System.out.println("Apellido segundo: ");
			String apellidoDos = sc.nextLine();
			System.out.println("Móvil con extensión: ");
			String movil = sc.nextLine();
			System.out.println("Email: ");
			String email = sc.nextLine();

			AltasDao altasDao = new AltasDao();
			altasDao.confirmarDatos(nombreEmpleado, apellidoUno, apellidoDos, movil, email);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en el proceso de alta: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
