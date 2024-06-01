package com.cr.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.cr.connection.MariaDbconnection;

public class proyecto {

    public void agregarContacto(Scanner scanner) {

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese el correo electrónico: ");
        String email = scanner.nextLine();

        Connection connection = MariaDbconnection.getConnection();
        if (connection != null) {
            try {
                String sql = "INSERT INTO contactos (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setString(3, telefono);
                statement.setString(4, email);
                statement.executeUpdate();
                System.out.println("¡Contacto agregado exitosamente!");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void eliminarContacto(int idContacto) {
        Connection connection = MariaDbconnection.getConnection();
        if (connection != null) {
            try {
                String sql = "DELETE FROM contactos WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, idContacto);
                
                int filasAfectadas = statement.executeUpdate();

              
                if (filasAfectadas > 0) {
                    System.out.println("Contacto eliminado exitosamente!");
                } else {
                    System.out.println("No se encontró el contacto con el ID especificado.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void consultarContactos() {
        Connection connection = MariaDbconnection.getConnection();
        if (connection != null) {
            try {

               
                String sql = "SELECT * FROM contactos";
                Statement statement = connection.createStatement();

                
                ResultSet resultSet = statement.executeQuery(sql);

               
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Apellido: " + resultSet.getString("apellido"));
                    System.out.println("Teléfono: " + resultSet.getString("telefono"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("--------------------------------");
                }

                
                resultSet.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
