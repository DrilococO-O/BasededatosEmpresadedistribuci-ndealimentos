/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CierreDeMes {
    public static void realizarCierre() {
        Connection conn = Semana4.conectar();
        
        try {
            // Actualiza el precio de los productos si es necesario (aquí ejemplo de incremento del 2%)
            String sql = "UPDATE Productos SET precio = precio * 1.02 WHERE precio < 1000000"; // Incrementar 2% a los productos
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            System.out.println("Cierre de mes realizado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al realizar el cierre de mes: " + ex.getMessage());
        }
    }
}
