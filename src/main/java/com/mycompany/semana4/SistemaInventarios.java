/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana4;

import java.sql.*;


import java.util.Date;

public class SistemaInventarios {
    public static void registrarCompra(Compra compra) {
        Connection conn = Semana4.conectar();
        
        try {
            // Insertar transacción en la base de datos
            String sql = "INSERT INTO Transacciones (fecha, idSucursal, idProducto, cantidad, precioUnitario, tipo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, new Timestamp(compra.getFecha().getTime()));
            stmt.setInt(2, compra.getIdSucursal());
            stmt.setInt(3, compra.getIdProducto());
            stmt.setInt(4, compra.getCantidad());
            stmt.setDouble(5, compra.getPrecioUnitario());
            stmt.setString(6, "Compra");
            stmt.executeUpdate();
            
            // Actualizar stock del producto
            String updateStock = "UPDATE Productos SET stock = stock + ? WHERE id = ?";
            PreparedStatement stmtStock = conn.prepareStatement(updateStock);
            stmtStock.setInt(1, compra.getCantidad());
            stmtStock.setInt(2, compra.getIdProducto());
            stmtStock.executeUpdate();
            
            System.out.println("Compra registrada exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al registrar la compra: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Crear una compra de ejemplo
        Compra compra = new Compra(1, new Date(), 1, 1, 5, 50.0); // 5 unidades del producto con id 1, a 50.0 cada uno
        registrarCompra(compra);
    }
}
