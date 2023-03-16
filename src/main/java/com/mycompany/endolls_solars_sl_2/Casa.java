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
    private ArrayList<Placa> placas = new ArrayList();
    private ArrayList<Aparell> aparells = new ArrayList();

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
//Metodo para poder utilizar los datos de la ArrayList de placas y asi tanto en info como en list conseguir mostrar cuantas placas tenemos en la casa.
    public ArrayList getPlacas() {
        return placas;
    }
//Metodo para poder utilizar los datos de la ArrayList de aparells y asi tanto en info como en list conseguir mostrar cuantas aparatos tenemos en la casa.
    public ArrayList getAparells() {
        return aparells;
    }

    //Con este metodo reviso que aparatos estan encendidos y si es asi me imprimirá su descripcion en la info de su respectiva casa.
    public void getAparellsEncesos() {
        for (Aparell i : aparells) {
            if (i.getInterruptor() == true) {
                System.out.println("- " + i.getDescripcion());
            }
        } 
    }

    //Funciones para poder añadir una placa y un aparato a la casa.
    public void addplaca(Placa nueva) {
        placas.add(nueva);
    }

    public void addaparell(Aparell nuevo) {
        aparells.add(nuevo);
    }

    //Funcion para poder encender el interruptor general de la casa que se nos indique.
    public void oncasa() {
        if (interruptor == false) {
            this.interruptor = true;
        }
    }
//Funcion para poder apagar el interruptor general de la casa que se nos indique.
    public void offcasa() {
        if (interruptor == true) {
            this.interruptor = false;
        }
    }

    //Funcion para poder buscar el aparato que deseamos.
    public Aparell buscaraparell(String Descripcion) {
        for (Aparell i : aparells) {
            if (i != null && i.getDescripcion().equals(Descripcion)) {
                return i;
            }
        }
        return null;
    }
//Funcion la cual compara si el consumo total de todos los aparatos es mayor a la potencia total de las placas.
    public Casa saltarplomos(int potencia) {
        consumTotal();
        potenciaTotal();
        if (consumTotal() > potenciaTotal()) {
            System.out.println("ERROR: Han saltat els ploms. La casa ha quedat completament apagada.");
            offcasa();
            for (Aparell i : aparells) {
                if (i.getInterruptor() == true) {
                    i.offaparell();
                }
            }
        }
        return null;
    }
//Funcion la cual calcula lo que queda de la teulada de la casa restandole la superficie de la placa.
    public int restaTeulada() {
        int restaTeulada = superficie;
        for (Placa i : placas) {
            restaTeulada = restaTeulada - i.getSuperficie();
        }
        return restaTeulada;
    }
//Funcion la cual calcula la potencia total que dan todas las placas instaladas de la casa.
    public int potenciaTotal() {
        int potenciaTotal = 0;
        for (Placa i : placas) {
            potenciaTotal = potenciaTotal + i.getPotencia();
        }
        return potenciaTotal;
    }
//Funcion la cual calcula el precio total que cuestan todas las placas instaladas en la casa.
    public double inversioTotal() {
        double inversioTotal = 0;
        for (Placa i : placas) {
            inversioTotal = inversioTotal + i.getPrecio();
        }
        return inversioTotal;
    }
//Funcion la cual calcula el consumo total de todos los aparatos encendidos en la casa.
    public int consumTotal() {
        int consumTotal = 0;
        for (Aparell i : aparells) {
            if (i.getInterruptor() == true) {
                consumTotal = consumTotal + i.getPotencia();
            }
        }
        return consumTotal;
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
