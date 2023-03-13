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
            if (datos.length > 0) {
                switch (datos[0].toLowerCase()) {
                    //Metodo para añadir una casa a la base de datos junto con sus datos (NIF, Nombre del propietario y superficie del tejado.
                    case "addcasa":
                        String NIF = datos[1];
                        String nom = datos[2];
                        int superficie = Integer.parseInt(datos[3]);
                        Casa nueva = new Casa(NIF, nom, superficie);
                        if (casas.equals(NIF)) {
                            System.out.println("ERROR: Ya n'hi ha una casa registrada amb aquest nif");
                        } else {
                            if (superficie < 10) {
                                System.out.println("ERROR: Superficie incorrecta. Ha de ser més gran de 10.");
                            } else {
                                for (int i = 0; i < casas.size(); i++) {
                                    if (casas.get(i) != null && nueva != casas.get(i)) {
                                        casas.add(nueva);
                                        System.out.println("OK: Casa registrada.");
                                        break;
                                    }
                                }
                            }
                        }
                    //Metodo para añadir una placa a la casa que le indiquemos con el NIF.
                    case "addplaca":
                        NIF = datos[1];
                        int Superficie = Integer.parseInt(datos[2]);
                        double precio = Double.parseDouble(datos[3]);
                        int potencia = Integer.parseInt(datos[4]);
                        Casa LaCasa = buscarcasa(NIF);
                        if (LaCasa != null && LaCasa.getNIF().equals(NIF)) {
                            if (Superficie < 0) {
                                System.out.println("ERROR: Superficie incorrecta. Ha de ser més gran de 0.");
                            } else {
                                if (precio < 0) {
                                    System.out.println("ERROR: Preu incorrecte. Ha de ser més gran de 0.");
                                } else {
                                    if (potencia < 0) {
                                        System.out.println("ERROR: Potencia incorrecte. Ha de ser més gran de 0.");
                                    } else {
                                        Placa placanueva = new Placa(Superficie, precio, potencia);
                                        LaCasa.addplaca(placanueva);
                                        System.out.println("OK: Placa afegida a la casa.");
                                    }
                                }
                            }

                        } else {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                        break;

                    //Metodo para añadir un aparato a la casa que le indiquemos con el NIF.
                    case "addaparell":
                        NIF = datos[1];
                        int Potencia = Integer.parseInt(datos[2]);
                        String descripcion = datos[3];
                        LaCasa = buscarcasa(NIF);
                        if (LaCasa != null && LaCasa.getNIF().equals(NIF)) {
                            if (Potencia < 0) {
                                System.out.println("ERROR: Potència incorrecte. Ha de ser més gran de 0.");
                            } else {
                                Aparell nuevo = new Aparell(Potencia, descripcion);
                                Aparell ElAparell = LaCasa.buscaraparell(descripcion);
                                LaCasa.addaparell(nuevo);
                                break;
                            }
                        } else {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    //Metodo para encender la casa buscandola por su NIF.
                    case "oncasa":
                        String Nif = datos[1];
                        Casa Lacasa = buscarcasa(Nif);
                        if (Lacasa != null) {
                            Lacasa.oncasa();
                        } else {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    //Metodo para encender un aparato buscando su casa con su respectivo NIF y revisando si existe un aparato o no con esa descripcion.
                    case "onaparell":
                        NIF = datos[1];
                        descripcion = datos[2];
                        Lacasa = buscarcasa(NIF);
                        if (Lacasa != null) {
                            Aparell Elaparell = Lacasa.buscaraparell(descripcion);
                            if (Elaparell != null) {
                                Elaparell.onaparell();
                                Lacasa.saltarplomos(Elaparell.getPotencia());
                                break;
                            } else {
                                System.out.println("ERROR: No hi ha cap aparell registrat en aquesta casa.");
                            }

                        } else {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    //Metodo para apagar un aparato buscando su casa con su respectivo NIF y revisando si existe un aparato o no con esa descripcion.
                    case "offaparell":
                        NIF = datos[1];
                        descripcion = datos[2];
                        Lacasa = buscarcasa(NIF);
                        if (Lacasa != null) {
                            Aparell Elaparell = Lacasa.buscaraparell(descripcion);
                            if (Elaparell != null) {
                                Elaparell.offaparell();
                                break;
                            } else {
                                System.out.println("ERROR: No hi ha cap aparell registrat en aquesta casa.");
                            }

                        } else {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }

                    //Metodo para salir del programa.
                    case "quit":
                        System.out.println("OK: Fins altre!");
                        break;
                }
            }
        } while (!"quit".equals(comando));
    }

//Funcion para buscar una casa en la lista de Casas.
    public static Casa buscarcasa(String NIF) {
        String buscada = NIF;
        for (Casa i : casas) {
            if (i != null && i.getNIF().equalsIgnoreCase(buscada)) {
                return i;
            }

        }
        return null;
    }
    
//Funcion para listar todas las casa de la lista Casas.
    public static Endolls_Solars_SL_2 list() {
        for (Casa i : casas) {
            System.out.println("Client: " + i.getNIF() + " - " + i.getNom());
            System.out.println("Superfície de teulada: " + i.getSuperficie());
            System.out.println("Superfície disponible: " + i.restaTeulada(i.getSuperficie()));
            if (i.placas.isEmpty()) {
                System.out.println("No té plaques solars instal·lades.");
            } else {
                System.out.println("Plaques solars instal·lades: " + i.placas.size());
            }
            if (i.aparells.isEmpty()) {
                System.out.println("No té cap aparell elèctric registrat.");
            } else {
                System.out.println("Aparells registrats: " + i.aparells.size());
            }
        }
        return null;
    }
    
//Funcion para listar la casa cuyo NIF le indicamos.
    public static Casa info(String NIF) {
        for (Casa i : casas) {
            Casa Lacasa = buscarcasa(NIF);
            if (Lacasa != null) {
                System.out.println("Client: " + Lacasa.getNIF() + " - " + Lacasa.getNom());
                System.out.println("Plaques solars instal·lades: " + Lacasa.placas.size());
                System.out.println("Potència total: " + Lacasa.potenciaTotal());
                System.out.println("Inversió total: " + Lacasa.inversioTotal());
                System.out.println("Aparells registrats: " + Lacasa.aparells.size());
                System.out.println("Consum actual: " + Lacasa.consumTotal());
            }
        }
        return null;
    }
}
