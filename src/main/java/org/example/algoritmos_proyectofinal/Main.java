package org.example.algoritmos_proyectofinal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("-------------Proyecto grafos ---------------");
        System.out.println("By: Melissa Rico Aguilar & Jose Gonzalo Pimienta Cisneros");

        //Crear grafo, vertices y aristas
        System.out.print("¿Cuántos vértices tendrá tu grafo?: ");
        int numVertices = leer.nextInt();
        leer.nextLine(); //Limpiar el buffer

        GrafoDirigidoAciclico grafo = new GrafoDirigidoAciclico(numVertices);

        //ES TEMPORAL!!! FALTAN RESTRINCCIONES
        System.out.println("Ahora toca introducir las flechas al grafo");

        int opcionAristas=0;
        do{
            System.out.print("\nIngresa el vértice ORIGEN: ");
            int origen = leer.nextInt();

            System.out.print("Ingresa el vértice DESTINO: ");
            int destino = leer.nextInt();

            try {
                //Usamos el metodo temporal
                boolean exito = grafo.insertarAristaTemporal(origen, destino);
                if (exito) {
                    System.out.println("¡Arista (" + origen + " -> " + destino + ") agregada!");
                }
                else {
                    System.out.println("No se pudo agregar!!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("\nIngresa 0 para seguir agregando o -1 para terminar el proceso!!\n");
            opcionAristas = leer.nextInt();
            //pendiete una comprobacion de que ingrese bien la opcion

        }while(opcionAristas != -1);

        //Ahora mostrar la info!!
        System.out.println("\n=============================================");

        System.out.println("\nMatriz de Adyacencia:");
        System.out.println(grafo.mostrarEstructura());

        System.out.println("Total de aristas registradas: " + grafo.cuantasAristasHay());

        System.out.println("\nResumen de Grados por Vértice:");
        for (int i = 0; i < numVertices-1; i++) {
            System.out.println("Vértice " + i + " -> Grado Entrada: " + grafo.gradoDeEntrada(i)
                    + " | Grado Salida: " + grafo.gradoDeSalida(i));
        }
    }
}