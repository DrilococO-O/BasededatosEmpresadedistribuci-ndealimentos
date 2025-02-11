/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana4;

import java.util.Date;

public class Transaccion {
    private int id;
    private Date fecha;
    private int idSucursal;
    
    public Transaccion(int id, Date fecha, int idSucursal) {
        this.id = id;
        this.fecha = fecha;
        this.idSucursal = idSucursal;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getIdSucursal() {
        return idSucursal;
    }
}
