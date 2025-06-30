package modelo;

import java.sql.SQLException;
import java.util.Scanner;

import dao.EmpleadoDao;

public class Empleado {
	Scanner sc = new Scanner(System.in);
	private int id;
	private String nombre;
	private String apellidoUno;
	private String apellidoDos;
	private String movil;
	private String email;

	public Empleado() {

	}

	public Empleado(int id, String nombre, String apellidoUno, String apellidoDos, String movil, String email) {
		this.id = id;
		this.nombre = nombre;
		this.apellidoUno = apellidoUno;
		this.apellidoDos = apellidoDos;
		this.movil = movil;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoUno() {
		return apellidoUno;
	}

	public void setApellidoUno(String apellidoUno) {
		this.apellidoUno = apellidoUno;
	}

	public String getApellidoDos() {
		return apellidoDos;
	}

	public void setApellidoDos(String apellidoDos) {
		this.apellidoDos = apellidoDos;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void darDeAlta() {
		Altas a = new Altas();
		a.altaEmpleado();
	}

	public void darDeBaja() {

		Bajas b = new Bajas();
		b.darDeBaja();

	}

	public void buscarEmpleado() throws SQLException {
    	System.out.println("nombre empleado");
    	String name = sc.nextLine();
    	System.out.println("apellido empleado");
    	String surName = sc.nextLine();
    	EmpleadoDao eDao = new EmpleadoDao();
    	eDao.buscarEmpleado(name, surName);
    	
    }

}
