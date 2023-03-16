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
        //Metodo para la linea de comandos donde le pasaremos los comandos que queremos ejecutar.
        String comando;
        do {
            BufferedReader Terminal = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("> ");
            comando = Terminal.readLine();
            String[] datos = comando.split(" ");
            if (datos.length > 0) {
                switch (datos[0].toLowerCase()) {
                    //Metodo para añadir una casa a la base de datos junto con sus datos (NIF, Nombre del propietario y superficie del tejado.
                    case "addcasa":
                        if (datos.length < 4 || datos.length > 4) {
                            System.out.println("ERROR: Número de paràmetres incorrecte.\\nÚs: addCasa [nif] [nom] [superficie]");
                        } else {
                            String NIF = datos[1];
                            String nom = datos[2];
                            int superficie = Integer.parseInt(datos[3]);
                            Casa nueva = new Casa(NIF, nom, superficie);
                            Casa laLacasa = buscarcasa(nueva.getNIF());
                            if (laLacasa != null) {
                                System.out.println("ERROR: Ya n'hi ha una casa registrada amb aquest nif");
                            } else {
                                if (superficie < 10) {
                                    System.out.println("ERROR: Superficie incorrecta. Ha de ser més gran de 10.");
                                } else {
                                    if (casas.isEmpty()) {
                                        casas.add(nueva);
                                        System.out.println("OK: Casa registrada.");
                                    } else {
                                        casas.add(nueva);
                                        System.out.println("OK: Casa registrada.");
                                    }
                                }
                            }
                        }

                        break;

                    //Metodo para añadir una placa a la casa que le indiquemos con el NIF.
                    case "addplaca":
                        if (datos.length < 5 || datos.length > 5) {
                            System.out.println("ERROR: Número de paràmetres incorrecte.\\nÚs: addPlaca [nif] [superficie] [preu] [potència]");
                        } else {
                            String NIF = datos[1];
                            int Superficie = Integer.parseInt(datos[2]);
                            double precio = Double.parseDouble(datos[3]);
                            int potencia = Integer.parseInt(datos[4]);
                            Casa LaCasa = buscarcasa(NIF);
                            if (LaCasa != null && LaCasa.getNIF().equals(NIF)) {
                                if (Superficie < 0) {
                                    System.out.println("ERROR: Superficie incorrecta. Ha de ser més gran de 0.");
                                } else {
                                    if (Superficie > LaCasa.restaTeulada()) {
                                        System.out.println("ERROR: No hi ha espai disponible per a instal·lar aquesta placa.");
                                    } else {
                                        if (precio < 0) {
                                            System.out.println("ERROR: Preu incorrecte. Ha de ser més gran de 0.");
                                        } else {
                                            if (potencia < 0) {
                                                System.out.println("ERROR: Potència incorrecte. Ha de ser més gran de 0.");
                                            } else {
                                                Placa placanueva = new Placa(Superficie, precio, potencia);
                                                LaCasa.addplaca(placanueva);
                                                System.out.println("OK: Placa afegida a la casa.");
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                            }
                        }
                        break;

                    //Metodo para añadir un aparato a la casa que le indiquemos con el NIF.
                    case "addaparell":
                        if (datos.length < 4 || datos.length > 4) {
                            System.out.println("ERROR: Número de paràmetres incorrecte.\\nÚs: addAparell [nif] [descripció] [potència]");
                        } else {
                            String NIF = datos[1];
                            int Potencia = Integer.parseInt(datos[3]);
                            String descripcion = datos[2];
                            Casa LaCasa = buscarcasa(NIF);
                            if (LaCasa != null && LaCasa.getNIF().equals(NIF)) {
                                if (Potencia < 0) {
                                    System.out.println("ERROR: Potència incorrecte. Ha de ser més gran de 0.");
                                } else {
                                    Aparell ElAparell = LaCasa.buscaraparell(descripcion);
                                    if (ElAparell != null && ElAparell.getDescripcion().equalsIgnoreCase(descripcion)) {
                                        System.out.println("ERROR: Ja existeix un aparell amb aquesta descripció a la casa indicada.");
                                    } else {
                                        Aparell nuevo = new Aparell(Potencia, descripcion);
                                        LaCasa.addaparell(nuevo);
                                        System.out.println("OK: Aparell afegit a la casa.");
                                        LaCasa.saltarplomos(Potencia);
                                    }
                                }
                            } else {
                                System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                            }
                        }
                        break;

                    //Metodo para encender la casa buscandola por su NIF.
                    case "oncasa":
                        if (datos.length < 2 || datos.length > 2) {
                            System.out.println("ERROR: Número de paràmetres incorrecte.\\nÚs: onCasa [nif]");
                        } else {
                            String Nif = datos[1];
                            Casa Lacasa = buscarcasa(Nif);
                            if (Lacasa != null) {
                                if (Lacasa.getInterruptor() == true) {
                                    System.out.println("ERROR: La casa ja té l'interruptor encès.");
                                } else {
                                    Lacasa.oncasa();
                                    System.out.println("OK: Interruptor general activat.");
                                }
                            } else {
                                System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                            }
                        }
                        break;

                    //Metodo para encender un aparato buscando su casa con su respectivo NIF y revisando si existe un aparato o no con esa descripcion.
                    case "onaparell":
                        if (datos.length < 3 || datos.length > 3) {
                            System.out.println("ERROR: Número de paràmetres incorrecte \\nÚs: onAparell [nif] [descripció aparell]");
                        } else {
                            String NIF = datos[1];
                            String descripcion = datos[2];
                            Casa Lacasa = buscarcasa(NIF);
                            if (Lacasa != null) {
                                Aparell Elaparell = Lacasa.buscaraparell(descripcion);
                                if (Elaparell != null) {
                                    if (Lacasa.getInterruptor() == false) {
                                        System.out.println("ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.");
                                    } else {
                                        if (Elaparell.getInterruptor() == true) {
                                            System.out.println("ERROR: L'aparell ja està encès.");
                                        } else {
                                            Elaparell.onaparell();
                                            System.out.println("OK: Aparell encès.");
                                            Lacasa.saltarplomos(Elaparell.getPotencia());
                                        }
                                    }
                                } else {
                                    System.out.println("ERROR: No hi ha cap aparell registrat en aquesta casa.");
                                }

                            } else {
                                System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                            }
                        }
                        break;

                    //Metodo para apagar un aparato buscando su casa con su respectivo NIF y revisando si existe un aparato o no con esa descripcion.
                    case "offaparell":
                        if (datos.length < 3 || datos.length > 3) {
                            System.out.println("ERROR: Número de paràmetres incorrecte.\\nÚs: offAparell [nif] [descripció aparell]");
                        } else {
                            String NIF = datos[1];
                            String descripcion = datos[2];
                            Casa Lacasa = buscarcasa(NIF);
                            if (Lacasa != null) {
                                Aparell Elaparell = Lacasa.buscaraparell(descripcion);
                                if (Elaparell != null) {
                                    if (Elaparell.getInterruptor() == false) {
                                        System.out.println("ERROR: L'aparell ja està apagat.");
                                    } else {
                                        Elaparell.offaparell();
                                        System.out.println("OK: Aparell apagat.");
                                    }
                                } else {
                                    System.out.println("ERROR: No hi ha cap aparell registrat en aquesta casa.");
                                }

                            } else {
                                System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                            }
                        }
                        break;

                    //Metodo para poder listar todas las casas que existes en la ArrayList de casas.
                    case "list":
                        if (datos.length > 1) {
                            System.out.println("ERROR: Número de paràmetres incorrecte.\\nÚs: list");
                        } else {
                            if (casas.isEmpty()) {
                                System.out.println("ERROR: Encara no n'hi ha cap casa registrada.");
                            } else {
                                list();
                            }
                        }
                        break;

                    //Metodo para dar la información de la casa, la cual esta identificada con su nif.
                    case "info":
                        if (datos.length < 2 || datos.length > 2) {
                            System.out.println("ERROR: Número de paràmetres incorrecte.\\nÚs: info [nif]");
                        } else {
                            String NIF = datos[1];
                            info(NIF);
                        }
                        break;

                    //Metodo para salir del programa.
                    case "quit":
                        if (datos.length > 1) {
                            System.out.println("ERROR: Número de paràmetres incorrecte.\\nÚs: quit");
                        } else {
                            System.out.println("OK: Fins altre!");
                        }
                        break;

                    default:
                        System.out.println("ERROR: Aquesta comanda es incorrecte.");
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

//Funcion para listar todas las casas de la lista Casas.
    public static Endolls_Solars_SL_2 list() {
        System.out.println("---- Registre de les casas registrades en Endolls Solars SL 2 ----");
        int contador = 1;
        if (casas.isEmpty()) {
            System.out.println("ERROR: Encara no n'hi ha cap casa registrada.");
        } else {
            for (Casa i : casas) {
                System.out.println("Casa " + contador++ + ":");
                System.out.println("Client: " + i.getNIF() + " - " + i.getNom());
                System.out.println("Superfície de teulada: " + i.getSuperficie());
                System.out.println("Superfície disponible: " + i.restaTeulada());
                if (i.getPlacas().isEmpty()) {
                    System.out.println("No té plaques solars instal·lades.");
                } else {
                    System.out.println("Plaques solars instal·lades: " + i.getPlacas().size());
                }
                if (i.getAparells().isEmpty()) {
                    System.out.println("No té cap aparell elèctric registrat.");
                } else {
                    System.out.println("Aparells registrats: " + i.getAparells().size());
                }
                if (i.getInterruptor() == true) {
                    System.out.println("Interruptor general: Encès");
                } else {
                    System.out.println("Interruptor general: Apagat");
                }
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
                System.out.println("Plaques solars instal·lades: " + Lacasa.getPlacas().size());
                System.out.println("Potència total: " + Lacasa.potenciaTotal() + "W");
                System.out.println("Inversió total: " + Lacasa.inversioTotal() + "€");
                System.out.println("Aparells registrats: " + Lacasa.getAparells().size());
                System.out.println("Consum actual: " + Lacasa.consumTotal() + "W");
                if (Lacasa.consumTotal() != 0) {
                    System.out.println("Aparells encesos: ");
                    Lacasa.getAparellsEncesos();
                }
            } else {
                System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
            }
        }
        return null;
    }
}
