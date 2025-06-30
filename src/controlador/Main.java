package controlador;

import java.sql.SQLException;

import modelo.Altas;
import modelo.Bajas;
import modelo.Empleado;
import modelo.Fichaje;
import modelo.Menu;
import modelo.Nota;

public class Main {

	public static void main(String[] args) throws SQLException {

		Menu menu = new Menu();
		menu.visualizaMenu();

	}

}
