package modelo;

import java.util.Scanner;
import dao.SolicitudDao;

public class MenuEmpleado {
	
    private Scanner sc;

    public MenuEmpleado() {
        this.sc = new Scanner(System.in);
    }

    public void visualizaMenuEmpleado() {
        int option = 0;
        
        do {
            try {
                System.out.println("\n=== MENÚ EMPLEADO ===");
                System.out.println("1. Fichaje");
                System.out.println("2. Solicitar vacaciones");
                System.out.println("3. Ver mis vacaciones");
                System.out.println("4. Salir");
                System.out.print("Seleccione opción: ");
                
                option = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                
                switch (option) {
                    case 1:
                        Fichaje fichaje = new Fichaje();
                        fichaje.insertarFichaje(null, null); 
                        break;
                        
                    case 2:
                        solicitarVacaciones();
                        break;
                        
                    case 3:
                        //TODO: verMisVacaciones();
                        break;
                        
                    case 4:
                        System.out.println("Saliendo del menú empleado...");
                        break;
                        
                    default:
                        System.out.println("❌ Opción no válida. Seleccione entre 1-4.");
                        break;
                }
                
            } catch (Exception e) {
                System.err.println("❌ Error: Debe introducir un número.");
                sc.nextLine(); // Limpiar buffer en caso de error
                option = 0; // Resetear para evitar bucle infinito si la entrada no es un entero
            }
            
        } while (option != 4);
    }

    private void solicitarVacaciones() {
        System.out.println("\n--- SOLICITAR VACACIONES ---");
        System.out.print("Ingrese su ID de empleado: ");
        String idEmpleado = sc.nextLine();
        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        String fechaInicio = sc.nextLine();
        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
        String fechaFin = sc.nextLine();

        SolicitudDao solicitudDao = new SolicitudDao();
        solicitudDao.insertarSolicitudDao(idEmpleado, fechaInicio, fechaFin);
    }

    private void verMisVacaciones() {
        System.out.println("\n--- MIS VACACIONES ---");
        System.out.println("Funcionalidad aún no implementada.");
    }
}