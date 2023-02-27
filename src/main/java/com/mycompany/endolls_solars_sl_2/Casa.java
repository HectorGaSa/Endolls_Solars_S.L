/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.endolls_solars_sl_2;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Casa {

    private String NIF;
    private String nom;
    private int superficie;
    private boolean interruptor;
    private ArrayList<Placa> placas = new ArrayList();
    private ArrayList<Aparell> aparells = new ArrayList();


    public Casa(String NIF, String nom, int superficie) {
        this.NIF = NIF;
        this.nom = nom;
        this.superficie = superficie;
        this.interruptor = true;
    }

    public String getNIF() {
        return NIF;
    }

    public String getNom() {
        return nom;
    }

    public int getSuperficie() {
        return superficie;
    }

    public boolean getInterruptor() {
        return interruptor;
    }
    
    
    public void addplaca(Placa nueva) {
    placas.add(nueva);
    }
    public void addaparell(Aparell nuevo) {
    aparells.add(nuevo);
    }
    
    public void oncasa(String NIF) {
    boolean comprovador = interruptor;
    if (comprovador == false) {
        this.interruptor = true;
    } 
    }
    
    public void onaparell(String NIF, String descripcion) {
    boolean comprovador = interruptor;
    if (comprovador == false) {
        this.interruptor = true;
    }
    }
    
    public void offaparell(String NIF, String descripcion) {
    boolean comprovador = interruptor;
    if (comprovador == true) {
        this.interruptor = false;
    }
    }
    public Aparell buscaraparell(String Descripcion) {
        String buscado = Descripcion;
        for (Aparell i : aparells) {
            if (i != null && i.getDescripcion().equals(buscado)) {
                return i;
            }
        } return null;
    }
//    int potencia = datosPlaca.getPotencia();
//    int superficiePlaca = datosPlaca.getSuperficie();
//    double precio = datosPlaca.getPrecio();

//    public void addPlaca(String NIF, int superficie, double precio, int potencia) {
//        if (superficie < 0) {
//            System.out.println("Error, la superficie tiene que ser mas grande de 0");
//        } else {
//            if (precio < 0) {
//                System.out.println("Error, el precio tiene que ser mas grande de 0");
//            } else {
//                if (potencia < 0) {
//                    System.out.println("Error, la potencia tiene que ser mas grande de 0");
//                } else {
//                    for (int i = 0; i < placas.size(); i++) {
//                        if (placas.get(i) != null && nueva != placas.get(i)) {
//                            placas.add(nueva);
//                        }
//                    }
//                }
//
//            }
//        }
//    }
}
