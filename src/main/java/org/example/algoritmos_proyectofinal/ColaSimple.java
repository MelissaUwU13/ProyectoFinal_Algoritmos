package org.example.algoritmos_proyectofinal;

public class ColaSimple<T> {
    private T[] cola;
    private int inicio;
    private int fin;

    public ColaSimple(int capacidad) {
        cola = (T[]) new Object[capacidad];
        inicio = -1;
        fin = -1;
    }

    public ColaSimple() {
        inicio = -1;
        fin = -1;
        cola = (T[]) new Object[5];
    }

    public void setCola(T[] cola) {
        this.cola = cola;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public T[] getCola() {
        return cola;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFin() {
        return fin;
    }


    public void insertar(T dato){
        if(fin<cola.length) {
            fin++;
            cola[fin] = dato;

            if(fin==0) {
                inicio = 0;
            }
        }
        else{
            System.out.println("Desbordamiento");
        }
    }

    public T eliminar(){
        T dato = null;

        if(inicio!=-1){
            dato = cola[inicio];

            if(inicio==fin){
                inicio=-1;
                fin=-1;
            }
            else{
                inicio++;
            }
        }
        else{
            System.out.println("Subesbordamiento");
        }
        return dato;
    }


    public T verPrimero(){
        if(inicio!=-1){
            return cola[inicio];
        }
        return null;
    }

    public boolean estaVacia() {
        return inicio == -1;
    }

}