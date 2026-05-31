package org.example.algoritmos_proyectofinal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("-------------Proyecto grafos ---------------");
        System.out.println("By: Melissa Rico Aguilar & Jose Gonzalo Pimienta Cisneros");
        System.out.println("---------------------------------------------");

        System.out.println("\nPASO 1 - CREACION DEL GRAFO");

        //Crear grafo, vertices y aristas
        System.out.print("\n¿Cuántos vértices tendrá tu grafo? ");
        int numVertices = leer.nextInt();
        leer.nextLine(); //Limpiar el buffer

        GrafoDirigidoAciclico grafo = new GrafoDirigidoAciclico(numVertices);

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

            System.out.print("\nIngresa 0 para seguir agregando o -1 para terminar el proceso!!\n");
            opcionAristas = leer.nextInt();
            //pendiete una comprobacion de que ingrese bien la opcion

        }while(opcionAristas != -1);

        boolean salida = false;


        while(!salida) {
            System.out.println("\nBienvenidos al menu de opciones.");
            System.out.println("\n1. Mostrar informacion");
            System.out.println("\n2. Insertar aristas");
            System.out.println("\n3. Eliminar todas las aristas");
            System.out.println("\n4. Ordenar con Topological Sort");
            System.out.println("\n5. Salir");
            int opcionMenu = leer.nextInt();
            leer.nextLine(); //Limpiar el buffer

            //comprobacion de que ponga una opcion correcta o le permita regresar???

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
                    grafo.eliminarAristas();
                    System.out.println("\nLas aristas han sido eliminadas!");
                    break;
                case 4:
                    System.out.println("Grafo ordenado: ");
                    System.out.println(grafo.topologicalSort());
                    break;
                case 5:
                    System.out.println("FIN DEL PROGRAMA!!");
                    salida=true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}