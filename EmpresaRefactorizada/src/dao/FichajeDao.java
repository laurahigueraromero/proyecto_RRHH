package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

import modelo.Fichaje;

public class FichajeDao {
    Scanner sc = new Scanner (System.in);
    DatabaseConnection dtbc;
    public void insertarFichajeDao(String idEmpleado, String tipo) throws SQLException {
    	if (idEmpleado == null || idEmpleado.trim().isEmpty()) {
            System.out.println("El ID del empleado no es válido. No se puede insertar el fichaje.");
            return;
        }
    	String insert = "INSERT INTO fichajes (tipo, registro, idempleado) VALUES (?, ?, ?)";

    	try (Connection conn = dtbc.getConnection();
    	         PreparedStatement pstmt = conn.prepareStatement(insert)) {

    	        pstmt.setString(1, tipo);
    	        pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now())); // Fecha/hora actual
    	        pstmt.setString(3, idEmpleado);

    	        int records = pstmt.executeUpdate();

    	        if (records > 0) {
    	            System.out.println("Fichaje registrado");
    	        } else {
    	            System.out.println("No se pudo registrar el fichaje.");
    	        }

    	    } catch (SQLException e) {
    	        System.err.println("Error al insertar fichaje: " + e.getMessage());
    	        throw e;
    	    }
    }

   

    
    public void listarFichajes(Fichaje fichaje) {
       
    	Connection cnn = dtbc.getConnection();
    	
    	
    	
    	
    	
    }
}
