/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.endolls_solars_s.l;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Placa {
    private int superficie;
    private double precio;
    private int potencia;


public Placa(int superficie, double precio, int potencia) {
    this.superficie = superficie;
    this.precio = precio;
    this.potencia = potencia;
}

public int getSuperficie() {
    return superficie;
}
public double getPrecio() {
    return precio;
}
public int getPotencia() {
    return potencia;
}
 
}
