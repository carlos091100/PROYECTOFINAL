package com.cr.main;

import java.util.Scanner;
import com.cr.proyecto.proyecto;

public class Main {

    public static void main(String[] args) {

        proyecto agregarContacto = new proyecto();
        Scanner scanner = new Scanner(System.in);

        
        String username, password;
        boolean loggedIn = false;

        
        while (!loggedIn) {
            System.out.println("\nIngreso al Sistema de Contactos:");
            System.out.print("Usuario: ");
            username = scanner.nextLine();
            System.out.print("Contraseña: ");
            password = scanner.nextLine();

           
            if (username.equals("progra1") && password.equals("proyecto")) {
                loggedIn = true;
                System.out.println("\n¡Bienvenido al gestor de contactos de Mario, Kevin y Carlos !");
            } else {
                System.out.println("Credenciales incorrectas. Intente nuevamente.");
            }
        }

        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\nMenú de Contactos:");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Consultar contactos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
                scanner.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    try {
                        agregarContacto.agregarContacto(scanner);
                       
                    } catch (Exception e) {
                        System.err.println("Error al agregar contacto: " + e.getMessage());
                    }
                    break;

                case 2:
                    int idContacto;
                    do {
                        System.out.print("Ingrese el ID del contacto a eliminar: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Entrada no válida. Ingrese un número entero.");
                            scanner.next();
                        }
                        idContacto = scanner.nextInt();
                        scanner.nextLine();
                    } while (idContacto <= 0);

                    try {
                        agregarContacto.eliminarContacto(idContacto);
                    } catch (Exception e) {
                        System.err.println("Error al eliminar contacto: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        agregarContacto.consultarContactos();
                    } catch (Exception e) {
                        System.err.println("Error al consultar contactos: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
