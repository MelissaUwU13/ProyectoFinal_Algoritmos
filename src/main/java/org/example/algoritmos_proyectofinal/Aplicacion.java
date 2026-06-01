package org.example.algoritmos_proyectofinal;

import java.util.Scanner;

public class Aplicacion {
    private Scanner leer = new Scanner(System.in);

    public void Ejecutar() {
        System.out.println("------------------- Proyecto grafos ----------------------");
        System.out.println("   Melissa Rico Aguilar & Jose Gonzalo Pimienta Cisneros  ");
        System.out.println("----------------------------------------------------------");

        System.out.println("\nCREACION DEL GRAFO");

        //Crear grafo, vertices y aristas
        System.out.print("\n¿Cuántos vértices tendrá tu grafo? ");
        int numVertices = leer.nextInt();
        leer.nextLine(); //Limpiar el buffer

        //Creamos un grafo para iniciar
        GrafoDirigidoAciclico grafo = crearGrafo(numVertices);

        int opcionMenu = 0;

        do{
            System.out.println("\n=============================================");
            System.out.println("\nBienvenidos al menu de opciones.");
            System.out.println("\n1. Mostrar informacion");
            System.out.println("2. Insertar aristas");
            System.out.println("3. Eliminar todas las aristas");
            System.out.println("4. Ordenar con Topological Sort");
            System.out.println("5. Crear nuevo grafo");
            System.out.println("6. Salir");
            opcionMenu = leer.nextInt();
            leer.nextLine(); //Limpiar el buffer

            switch (opcionMenu) {
                case 1:
                    System.out.println("\n=============================================");

                    System.out.println("\nMatriz de Adyacencia:");
                    System.out.println(grafo.mostrarEstructura());

                    System.out.println("Total de aristas registradas: " + grafo.cuantasAristasHay());

                    System.out.println("\nResumen de Grados por Vértice:");
                    for (int i = 0; i < numVertices; i++) {
                        System.out.println("Vértice " + i + " -> Grado Entrada: " + grafo.gradoDeEntrada(i)
                                + " | Grado Salida: " + grafo.gradoDeSalida(i));
                    }

                    System.out.println("\n¿Tiene ciclos? " + grafo.tieneCiclos());
                    break;
                case 2:
                    System.out.println("\n=============================================");
                    System.out.print("\nIngresa el vértice ORIGEN: ");
                    int origen = leer.nextInt();

                    System.out.print("Ingresa el vértice DESTINO: ");
                    int destino = leer.nextInt();

                    try {
                        boolean exito = grafo.insertarArista(origen, destino);
                        if (exito) {
                            System.out.println("¡Arista (" + origen + " -> " + destino + ") agregada!");
                        } else {
                            System.out.println("No se pudo agregar!!");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\n=============================================");
                    grafo.eliminarAristas();
                    System.out.println("\nLas aristas han sido eliminadas!");
                    break;
                case 4:
                    System.out.println("\n=============================================");
                    System.out.println("Grafo ordenado: ");
                    System.out.println(grafo.topologicalSort());
                    break;
                case 5:
                    System.out.println("\nCREACION DEL GRAFO");

                    //Crear grafo, vertices y aristas
                    System.out.print("\n¿Cuántos vértices tendrá tu grafo? ");
                    numVertices = leer.nextInt();
                    leer.nextLine(); //Limpiar el buffer

                    //Creamos un grafo para iniciar
                    grafo = crearGrafo(numVertices);
                    break;
                case 6:
                    System.out.println("\n=============================================");
                    System.out.println("FIN DEL PROGRAMA!!");
                    break;
                default:
                    System.out.println("\n=============================================");
                    System.out.println("Opcion no valida");
            }
        }while (opcionMenu!=6);
    }

    public GrafoDirigidoAciclico crearGrafo(int numVertices){
        GrafoDirigidoAciclico grafo = new GrafoDirigidoAciclico(numVertices);

        /**
         System.out.println("\nEJEMPLO GRAFOOOO");
         try {
         grafo.insertarArista(0, 2);
         grafo.insertarArista(0, 3);
         grafo.insertarArista(2, 1);
         } catch (IllegalArgumentException e) {
         System.out.println("Error: " + e.getMessage());
         }
         */

        System.out.println("Ahora toca introducir las flechas al grafo");

        int opcionAristas=0;
        do{
            System.out.print("\nIngresa el vértice ORIGEN: ");
            int origen = leer.nextInt();

            System.out.print("Ingresa el vértice DESTINO: ");
            int destino = leer.nextInt();

            try {
                boolean exito = grafo.insertarArista(origen, destino);
                if (exito) {
                    System.out.println("¡Arista (" + origen + " -> " + destino + ") agregada!");
                }
                else {
                    System.out.println("No se pudo agregar!!");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }


            System.out.print("\nIngresa 0 para seguir agregando o ingresa -1 para terminar el proceso!!\n");
            opcionAristas = leer.nextInt();
            leer.nextLine(); //Limpiar el buffer

            //comprobacion en caso de poner la variable incorrecta
            while (opcionAristas != 0 && opcionAristas != -1) {
                System.out.println("\nERROR: Entrada no válida!!");
                System.out.print("\nIngresa 0 para seguir agregando o ingresa -1 para terminar el proceso!!\n");
                opcionAristas = leer.nextInt();
                leer.nextLine(); //Limpiar el buffer
            }

        }while(opcionAristas != -1);

        return grafo;
    }
}
