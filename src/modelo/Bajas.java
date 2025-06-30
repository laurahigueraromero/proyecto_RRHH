package modelo;

import java.util.Scanner;

import dao.AltasDao;
import dao.BajasDao;

public class Bajas {
	private Empleado empleado;

	public Bajas() {

	}

	public Bajas(Empleado empleado) {
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void darDeBaja() {
		// mensaje de baja
		// confirmar operacion
		// conectar a la base de datos
		// borrar el empleado
		// cerrar la conexión
		// mensaje de confirmacion

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("*******Baja empleado*********** ");
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

			BajasDao bajasDao = new BajasDao();
			bajasDao.confirmarDatos(nombreEmpleado, apellidoUno, apellidoDos, movil, email);

		} catch (Exception e) {

		}

	}

}
