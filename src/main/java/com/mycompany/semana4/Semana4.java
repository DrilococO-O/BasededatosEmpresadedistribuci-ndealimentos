/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.semana4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Semana4 {
    public static Connection conectar() {
        Connection conn = null;
        try {
            // Reemplaza "localhost" por tu servidor MySQL si es necesario
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventarios", "root", "");
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos: " + ex.getMessage());
        }
        return conn;
    }

public static void mostrarProductos() {
    Connection conn = Semana4.conectar();
    try {
        String sql = "SELECT * FROM Productos";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nombre: " + rs.getString("nombre"));
            System.out.println("Descripción: " + rs.getString("descripcion"));
            System.out.println("Precio: " + rs.getDouble("precio"));
            System.out.println("Stock: " + rs.getInt("stock"));
            System.out.println("----------------------");
        }
    } catch (SQLException ex) {
        System.out.println("Error al mostrar productos: " + ex.getMessage());
    }
}}