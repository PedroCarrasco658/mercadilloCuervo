/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.loginModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarFila {

    private Connection con; // La conexión a la base de datos

    // Constructor que recibe la conexión
    public InsertarFila(Connection con) {
        this.con = con;
    }

    public void insertarFila() throws SQLException {
        // Definir la consulta SQL de inserción
        String query = "INSERT INTO `user` (Username, Email, Password, VerifyCode) VALUES (?, ?, ?, ?)";

        // Crear el PreparedStatement
        try (PreparedStatement p = con.prepareStatement(query)) {
            
            // Establecer los valores de los parámetros en la consulta SQL
            p.setString(1, "usuarioEjemplo");  // Username
            p.setString(2, "correo@ejemplo.com");  // Email
            p.setString(3, "contraseñaSegura");  // Password
            p.setString(4, "codigoDeVerificacion123");  // VerifyCode
            
            
            // Ejecutar la inserción
            int rowsAffected = p.executeUpdate();
            System.out.println("Filas insertadas: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;  // Relanzar la excepción en caso de error
        }
    }

    public static void main(String[] args) {
        // Ejemplo de cómo llamar al método, usando una conexión (conexión debe estar abierta)
        try {
            // Conexión a la base de datos (asegúrate de configurarla previamente)
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginmercadillo", "root", "");
            InsertarFila inserter = new InsertarFila(con);
            inserter.insertarFila();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

