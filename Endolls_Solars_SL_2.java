/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.endolls_solars_sl_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Endolls_Solars_SL_2 {
    //Lista de las casas
    static ArrayList<Casa> casas = new ArrayList();

    public static void main(String[] args) throws IOException {
        //Metodo para la linea de comandos donde le pasaremos los comandos que queremos ejecutar
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
                //Metodo para añadir una placa a la casa que le indiquemos con el NIF
                case "addplaca":
                    NIF = datos[1];
                    int Superficie = Integer.parseInt(datos[2]);
                    double precio = Double.parseDouble(datos[3]);
                    int potencia = Integer.parseInt(datos[4]);
                    Casa LaCasa = buscarcasa(NIF);
                    if (LaCasa != null && LaCasa.getNIF().equals(NIF)) {
                        if (Superficie < 0) {
                            System.out.println("Error, la superficie tiene que ser superior a 0");
                        } else {
                            if (precio < 0) {
                                System.out.println("Error, el precio tiene que ser superior a 0");
                            } else {
                                if (potencia < 0) {
                                    System.out.println("Error, la potencia tiene que ser superior a 0");
                                } else {
                                    Placa placanueva = new Placa(Superficie, precio, potencia);
                                    LaCasa.addplaca(placanueva);
                                }
                            }
                        }

                    }
                //Metodo para añadir un aparato a la casa que le indiquemos con el NIF
                case "addaparell":
                    NIF = datos[1];
                    int Potencia = Integer.parseInt(datos[2]);
                    String descripcion = datos[3];
                    LaCasa = buscarcasa(NIF);
                    if (LaCasa != null && LaCasa.getNIF().equals(NIF)) {
                        if (Potencia < 0) {
                            System.out.println("Error, la potencia tiene que ser superior a 0");
                        } else {
                            Aparell nuevo = new Aparell(Potencia, descripcion);
                            LaCasa.addaparell(nuevo);
                        }
                    }
                //Metodo para encender la casa    
                case "oncasa":
                    String Nif = datos[1];
                    Casa Lacasa = buscarcasa(Nif);
                    if (Lacasa != null && Lacasa.getNIF().equals(Nif)) {
                        Lacasa.oncasa();
                    }
                //Metodo para encender un aparato    
                case "onaparell":
                    NIF = datos[1];
                    String Descripcion = datos[2];
                    Lacasa = buscarcasa(NIF);
                    if (Lacasa != null) {
                        Aparell Elaparell = buscaraparell(Descripcion);
                        
                    }
                //Metodo para apagar un aparato    
                case "offaparell":
                    NIF = datos[1];
                    descripcion = datos[2];
                    Lacasa = buscarcasa(NIF);
                    if (Lacasa != null) {
                        
                    }

                        
                //Metodo para salir del programa    
                case "quit":
                System.out.println(" ");
                break;
                                                    }
                          }
            } while(!"quit".equals(comando));
        }
       
//Funcion para buscar una casa en la lista de Casas
public static Casa buscarcasa(String NIF) {
        String buscada = NIF;
    for (Casa i : casas) {
        if (i != null && i.getNIF().equals(buscada)) {
            return i;        }
        
    }
        return null;
}
//Funcion para listar todas las casa de la lista Casas
public static Endolls_Solars_SL_2 list(){
    for (Casa i : casas) {
       System.out.println(i);
    }
        return null;
}
//Funcion para listar la casa cuyo NIF le indicamos
public static Endolls_Solars_SL_2 info(String NIF) {
    for (Casa i : casas) {
       Casa Lacasa = buscarcasa(NIF);
       if (Lacasa != null && Lacasa.getNIF().equals(NIF)) {
           System.out.println(Lacasa);
       }
    }
    return null;
}
}
