/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana4;
import java.util.Date;

public class Compra extends Transaccion {
    private int idProducto;
    private int cantidad;
    private double precioUnitario;

    public Compra(int id, Date fecha, int idSucursal, int idProducto, int cantidad, double precioUnitario) {
        super(id, fecha, idSucursal);
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double calcularTotal() {
        return cantidad * precioUnitario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}
