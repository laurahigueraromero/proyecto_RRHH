package modelo;

import java.sql.SQLException;
import java.util.Scanner;

import dao.NotaDao;

public class Nota {
Scanner sc = new Scanner (System.in);



public void registraNota() throws SQLException {
	
	System.out.println("Escriba id de empleado para registrar nota");
	String id = sc.nextLine();
	NotaDao noteDao = new NotaDao();
	noteDao.registrarNota(id);
	
	
	
	
	
	
}

	
	
	
	
	
	
	
	
	
}
