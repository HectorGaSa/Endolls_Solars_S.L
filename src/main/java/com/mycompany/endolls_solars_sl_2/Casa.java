/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.endolls_solars_sl_2;

import static com.mycompany.endolls_solars_sl_2.Endolls_Solars_SL_2.buscarcasa;
import static com.mycompany.endolls_solars_sl_2.Endolls_Solars_SL_2.casas;
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
    static ArrayList<Placa> placas = new ArrayList();
    static ArrayList<Aparell> aparells = new ArrayList();

    //Constructor de la clase "Casa"
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
    
    //Funciones para poder añadir una placa y un aparato a la casa
    public void addplaca(Placa nueva) {
    placas.add(nueva);
    }
    public void addaparell(Aparell nuevo) {
    aparells.add(nuevo);
    }
    //Funcion para poder encender el interruptor general de la casa que se nos indique
    public void oncasa() {
    if (interruptor == false) {
        this.interruptor = true;
    } 
    }
    
    public void offcasa() {
    if (interruptor == true) {
        this.interruptor = false;
    }
    }
    
    //Funcion para poder buscar el aparato que deseamos
    public Aparell buscaraparell(String Descripcion) {
        String buscado = Descripcion;
        for (Aparell i : aparells) {
            if (i != null && i.getDescripcion().equals(buscado)) {
                return i;
            }
        } return null;
    }
    public Casa saltarplomos(int potencia){
       Placa potenciaTotal = null;
       int sumaPotencia = 0;
       sumaPotencia = sumaPotencia + potencia;
       if (sumaPotencia > potenciaTotal.getPotencia()){
           System.out.println("ERROR: Han saltat els ploms. La casa ha quedat completament apagada.");
           Aparell ElAparell = null;
           Casa LaCasa = null;
           LaCasa.offcasa();
           for (Aparell i : aparells) {
               if (i.getInterruptor() == true) {
                   ElAparell.offaparell();
               }
           }
       }
       return null;
    }
    public Casa restaTeulada(int superficie){
        Placa superficiePlaca = null;
        Casa superficieTeulada = null;
        int restantTeulada = superficieTeulada.getSuperficie();
        restantTeulada = restantTeulada - superficiePlaca.getSuperficie();
        if (superficiePlaca.getSuperficie() > restantTeulada){
            System.out.println("ERROR: No hi ha espai disponible per a instal·lar aquesta placa.");
        }
        return null;
    }
    public Casa potenciaTotal(){
        int PotenciaTotal = 0;
        for (Placa i : placas) {
        PotenciaTotal = PotenciaTotal + i.getPotencia();
    } return null;
    }
    
    public Casa inversioTotal() {
        double InversioTotal = 0;
        for (Placa i : placas){
            InversioTotal = InversioTotal + i.getPrecio();
        } return null;
    }
    
    public Casa consumTotal() {
        int ConsumTotal = 0;
        for (Aparell i : aparells) {
            ConsumTotal = ConsumTotal + i.getPotencia();
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
