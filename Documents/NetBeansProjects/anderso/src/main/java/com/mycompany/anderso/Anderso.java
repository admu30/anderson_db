/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.anderso;

import java.sql.*;

/**
 *
 * @author Hogar
 */
public class Anderso {

   

    // Configuración de la conexión
    private static final String URL = "jdbc:mysql://localhost:3306/Anderson_db";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para insertar dos registros en la base de datos
    public static void insertTwoRecords() {
        String sql = "INSERT INTO users (username, password, email, first_name, last_name) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Primer registro
            pstmt.setString(1, "john_doe");
            pstmt.setString(2, "password123");
            pstmt.setString(3, "john.doe@example.com");
            pstmt.setString(4, "John");
            pstmt.setString(5, "Doe");
            pstmt.executeUpdate();

            // Segundo registro
            pstmt.setString(1, "jane_smith");
            pstmt.setString(2, "password456");
            pstmt.setString(3, "jane.smith@example.com");
            pstmt.setString(4, "Jane");
            pstmt.setString(5, "Smith");
            pstmt.executeUpdate();

            System.out.println("Registros insertados correctamente.");
        }catch (SQLException e){
        }
    }

    public static void main(String[] args) {
        insertTwoRecords();
    }
}  