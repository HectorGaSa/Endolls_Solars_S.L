/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.endolls_solars_sl_2;

/**
 *
 * @author Admin
 */
public class Aparell {
    private boolean interruptor;
    private int potencia;
    private String descripcion;
    
public Aparell(int potencia, String descripcion) {
    this.interruptor = false;
    this.potencia = potencia;
    this.descripcion = descripcion;
}

public boolean getInterruptor() {
    return interruptor;
}
public int getPotencia() {
    return potencia;
}
public String getDescripcion() {
    return descripcion;
}

}
