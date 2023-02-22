/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.endolls_solars_s.l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Endolls_Solars_SL {

    static ArrayList<Casa> casas = new ArrayList();

    public static void main(String[] args) throws IOException {
      
        String comando;
        do {
            BufferedReader Terminal = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("> ");
        comando = Terminal.readLine();
        String[] datos = comando.split(" ");
        boolean comprovador = false;
        if (datos.length > 0) {
            switch (datos[0].toLowerCase()) {
                case "addcasa":
                    String NIF = datos[1];
                    String nom = datos[2];
                    int superficie = Integer.parseInt(datos[3]);
                    Casa nueva = new Casa(NIF, nom, superficie); 
                    if (casas.equals(NIF)) {
                        System.out.println("Error, ya hay una casa registrada con este NIF");
                    } else {
                         if (superficie < 10) {
                        System.out.println("Error, la superficie tiene que ser mas grande de 10");
                    } else {
                        for (int i = 0; i < casas.size(); i++) {
                            if (casas.get(i) != null && nueva != casas.get(i)) {
                            casas.add(nueva);
                }
            }
        }
                    }
                   
                case "addplaca":
                    String nif = datos[1];
                    int Superficie = Integer.parseInt(datos[2]);
                    double precio = Double.parseDouble(datos[3]);
                    int potencia = Integer.parseInt(datos[4]);
                    Casa laCasa = buscarcasa(nif);
                    if (laCasa != null) {
                        Placa placanueva = new Placa(Superficie, precio, potencia);
                        laCasa.addplaca(placanueva);
                    }


                
                case "addaparell":
                    String Nif = datos[1];
                    int Potencia = Integer.parseInt(datos[2]);
                    String descripcion = datos[3];
                    Casa LaCasa = buscarcasa(Nif);
                    if (LaCasa != null) {
                        Aparell nuevo = new Aparell(Potencia, descripcion);
                        LaCasa.addaparell(nuevo);
                    }
                    
                    
                case "quit":
                System.out.println(" ");
                break;
                                                    }
                          }
            } while(!"quit".equals(comando));
        }
       

public static Casa buscarcasa(String NIF) {
        String buscada = NIF;
    for (Casa i : casas) {
        if (i != null && i.getNIF() == NIF) {
            return i;        }
        
    }
        return null;
}
}
                