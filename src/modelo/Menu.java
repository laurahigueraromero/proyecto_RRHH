package modelo;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);

	public void visualizaMenu() throws SQLException {
		int option = 0;
		do {
			System.out.println("****************************************************************************************");
			System.out.println("**************Seleccione cargo\n1.Empleado  \n2.Recursos humanos****************");
			System.out.println("****************************************************************************************");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {

			case 1:
				MenuEmpleado mEm = new MenuEmpleado();
				mEm.visualizaMenuEmpleado();

				break;
			case 2:
				MenuRH mRh = new MenuRH();
				mRh.visualizaMenu();
				break;

			default:
				System.out.println("selecione opcion valida");

			}

		} while (option < 2);

	}

}
