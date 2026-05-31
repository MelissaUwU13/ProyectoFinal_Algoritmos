package org.example.algoritmos_proyectofinal;

public class GrafoDirigidoAciclico {
    private int numVertices;
    private int numAristas=0;
    private boolean[][] matrizAdyacencia;
    private String[] nombresVertices; //Para guardar los nombres

    //Constructor
    public GrafoDirigidoAciclico(int n){
        numVertices = n-1;
        this.matrizAdyacencia = new boolean[n][n];
        this.nombresVertices = new String[n];

        //DE MIENTRAS!!!
        //Los numeramos de 0 a n-1
        for (int i = 0; i < n; i++) {
            this.nombresVertices[i] = String.valueOf(i);
        }
    }

    //METODOS DE ACCESO

    //Regresa el grado de entrada del vértice i.
    //Si i está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
    public int gradoDeEntrada(int i){

        //si el vertice esta fuera de rango es INVALIDO
        if(i<0 || i>=numVertices){
            throw new IllegalArgumentException("El vertice " + i + " esta fuera de rango.");
        }
        //grado de entrada
        int contador  = 0;

        for(int fila = 0 ; fila < numVertices ; fila ++){
            //si un vertice se dirige a i incrementa
            if(matrizAdyacencia[fila][i]){
                contador++;
            }
        }
        return contador;
    }

    //Regresa el grado de salida del vértice i.
    //Si i está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
    public int gradoDeSalida(int i){
        //si el vertice esta fuera de rango es INVALIDO
        if(i<0 || i>=numVertices){
            throw new IllegalArgumentException("El vertice " + i + " esta fuera de rango.");
        }
        //grado de entrada
        int contador  = 0;

        for(int columna = 0 ; columna < numVertices ; columna ++){
            //si i se dirige a un vertice incrementa
            if(matrizAdyacencia[i][columna]){
                contador++;
            }
        }
        return contador;
    }

    //Regresa el número de aristas del grafo.
    public int cuantasAristasHay(){
        //Recorremos la matriz buscando los "true"
        for (int fila = 0; fila < numVertices; fila++) {
            for (int col = 0; col < numAristas; col++) {
                if (matrizAdyacencia[fila][col]) {
                    numAristas++;
                }
            }
        }
        return numAristas;
    }

    //Regresa true si existe una arista del vértice i al vértice j.
    //Si i o j está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
    public boolean adyacente(int i, int j){
        if(i < 0 || i>=numVertices){
            throw new IllegalArgumentException("El vertice " + i + " esta fuera de rango.");
        }
        if(j < 0 || j>=numVertices){
            throw new IllegalArgumentException("El vertice " + j + " esta fuera de rango.");
        }

        return matrizAdyacencia[i][j];
    }

    //Regresa true si existe un camino directo del vértice i al j.
    //Considere utilizar una Cola. También pregúntate: ¿es i un camino?.
    //Si j está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
    public boolean conectados(int i, int j){
        return false; // de mientras
    }

    // Regrese el ordenamiento topológico de los vértices, separe cada prioridad del vértice por un guión -.
    //La restricción es, si existen varias posibilidades para incluir dentro del ordenamiento, se debe seleccionar el que tenga más prioridad.
    //Recuerde que se deben mostrar todos los vértices del grafo.
    public String topologicalSort(){
        return null; // de mientras
    }

    //Regresa true si el grafo tiene ciclos, regresa falso en caso contrario.
    //Utiliza busqeuda en profundidad
    public boolean tieneCiclos(){
        return false; // de mientras
    }

    //Regresará los datos del grafo en forma de matriz, para mostrar en consola.
    public String mostrarEstructura(){
        StringBuilder GrafoDirigido = new StringBuilder();

        //Imprimir encabezado de columnas con los nombres de los vértices
        GrafoDirigido.append("\t");
        for (int i = 0; i < numVertices; i++) {
            GrafoDirigido.append(nombresVertices[i]).append("\t");
        }
        GrafoDirigido.append("\n");

        //Imprimir las filas de la matriz
        for (int fila = 0; fila < numVertices; fila++) {
            GrafoDirigido.append(nombresVertices[fila]).append("\t"); // Nombre de la fila

            for (int col = 0; col < numVertices; col++) {
                    GrafoDirigido.append(matrizAdyacencia[fila][col] ? "1\t" : "0\t");
            }

            GrafoDirigido.append("\n");

        }
        return GrafoDirigido.toString();
    }

    //METODOS PARA ESTABLECER VALORES

    // Inserta una nueva arista del vértice i al vértice j, siempre y cuando esto no ocasione la aparición de un ciclo.
    //Regresa true si la inserción tuvo éxito, en otro caso regresa falso. Si i y j son iguales regresa falso y si la arista de i a j ya existe, de nuevo, regresa falso.
    //Si i o j está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
    public boolean insertarArista(int i, int j){
        return false; // de mientras
    }

    //Elimina todas las aristas del grafo
    public void eliminarAristas(){
        for(int i = 0; i < numVertices; i++){
            for(int j = 0; j < numVertices; i++){
                matrizAdyacencia[i][j] = false;
            }
        }
        this.numAristas = 0;
    }



    //METODO DE PRUEBAAAA PARA EL MAIN!!
    public boolean insertarAristaTemporal(int i, int j) {
        if (i < 0 || i >= numVertices || j < 0 || j >= numVertices){
            throw new IllegalArgumentException("Índices fuera de rango.");
        }
        if (i == j || matrizAdyacencia[i][j]) {
            return false;
        }
        matrizAdyacencia[i][j] = true;
        return true;
    }

}