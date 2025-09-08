package modelo;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuRH {
	Scanner sc = new Scanner(System.in);

	public void visualizaMenu() throws SQLException {

		int option = 0;
		// meter un login de empleado RH
		// control de fichajes
		// crear usuarioEmpleado
		// solicitudes
		// TODO: meter en consola las tablas de las bases de datos
		
		do {
			System.out.println("*******************************************************************************");
			System.out.println("******Seleccione opcion:\n1.Altas\n2.Bajas\n3.notas\n4.Buscar empleado*********");
			System.out.println("*******************************************************************************");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {

			case 1:
				Altas a = new Altas();
				a.altaEmpleado();
				break;
			case 2:
				Bajas b = new Bajas();
				b.darDeBaja();
				break;
			case 3:
				Nota note = new Nota();
				note.registraNota();

				break;
			case 4:
				Empleado e = new Empleado();
				e.buscarEmpleado();

				break;

			default:
				System.out.println("Escoja opción válida");

			}

		} while (option < 4);

	}

}
