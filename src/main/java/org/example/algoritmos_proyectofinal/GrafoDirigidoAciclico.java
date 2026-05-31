package org.example.algoritmos_proyectofinal;

public class GrafoDirigidoAciclico {
    private int numVertices;
    private int numAristas=0;
    private boolean[][] matrizAdyacencia;
    private String[] nombresVertices; //Para guardar los nombres


    //Constructor
    public GrafoDirigidoAciclico(int n){
        numVertices = n;
        this.matrizAdyacencia = new boolean[n][n];
        this.nombresVertices = new String[n];

        //DE MIENTRAS!!!
        //Los numeramos de 0 a n-1
        for (int i = 0; i < n; i++) {
            this.nombresVertices[i] = String.valueOf(i);
        }
    }

    //METODOS DE ACCESO

    /**
     * Regresa el grado de entrada del vértice i.
     * Si i está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
    */
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

    /**
     * Regresa el grado de salida del vértice i.
     * Si i está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
    */
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

    /**
     * Regresa el número de aristas del grafo.
    */
     public int cuantasAristasHay(){
        int contador = 0;
        for (int fila = 0; fila < numVertices; fila++) {
            for (int col = 0; col < numVertices; col++) {
                if (matrizAdyacencia[fila][col]) {
                    contador++;
                }
            }
        }
        this.numAristas = contador;
        return this.numAristas;
    }

    /**
      * Regresa true si existe una arista del vértice i al vértice j.
      * Si i o j está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
    */
     public boolean adyacente(int i, int j){
        if(i < 0 || i>=numVertices){
            throw new IllegalArgumentException("El vertice " + i + " esta fuera de rango.");
        }
        if(j < 0 || j>=numVertices){
            throw new IllegalArgumentException("El vertice " + j + " esta fuera de rango.");
        }

        return matrizAdyacencia[i][j];
    }

    /**
        * Regresa true si existe un camino directo del vértice i al j.
        * Considere utilizar una Cola. También pregúntate: ¿es i un camino?.
        * Si j está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
        * Regresa true si existe un camino directo o indirecto del vértice i al j
     */
    public boolean conectados(int i, int j) {
        if (i < 0 || i >= numVertices || j < 0 || j >= numVertices) {
            throw new IllegalArgumentException("Los índices están fuera del rango permitido.");
        }

        //No ciclos!!
        if (i == j) {
            return false;
        }

        ColaSimple<Integer> cola = new ColaSimple<>(numVertices);
        boolean[] VerticesVisitados = new boolean[numVertices];

        //Empezamos la búsqueda desde el nodo i
        cola.insertar(i);
        VerticesVisitados[i] = true;

        //Mientras la cola no este vacia, estaremos revisando todos los nodos
        while (!cola.estaVacia()) {
            int actual = cola.eliminar(); //Sacamos el elemento de la cola

            //Revisamos los vecinos del nodo actual
            for (int vecino = 0; vecino < numVertices; vecino++) {
                //si es true significa que hay una arista que los conecta ->
                if (adyacente(actual, vecino)) {
                    //Si encontramos el destino j, hay conexión
                    if (vecino == j) {
                        return true;
                    }

                    //Si no está visitado, lo agregamos a la cola
                    if (!VerticesVisitados[vecino]) {
                        VerticesVisitados[vecino] = true;
                        cola.insertar(vecino);
                    }
                }
            }
        }

        return false; //Regresa false si no hay camino
    }

    /**
        * Regrese el ordenamiento topológico de los vértices, separe cada prioridad del vértice por un guión -.
        * restricción es, si existen varias posibilidades para incluir dentro del ordenamiento, se debe seleccionar el que tenga más prioridad.
        * Recuerde que se deben mostrar todos los vértices del grafo.
     */
    public String topologicalSort(){
        return null; // de mientras
    }

    /**
     * Regresa true si el grafo tiene ciclos, regresa falso en caso contrario.
     */
    public boolean tieneCiclos(){
        ColaSimple<Integer> cola = new ColaSimple<>(numVertices);
        int[] gradosEntradaDeVertices = new int[numVertices];
        int nodosProcesados = 0;

        for(int i = 0; i<numVertices;i++){
            gradosEntradaDeVertices[i] = gradoDeEntrada(i);
            if(gradosEntradaDeVertices[i] == 0){
                cola.insertar(i);//mete los que tienen grado 0 de ENTRADA
            }
        }

        while(!cola.estaVacia()){
            int verticeActual = cola.eliminar(); //guardamos un nodo libre en vertice actual
            nodosProcesados++;

            //busqueda de vecinos de vertice actual
            for(int j = 0; j< numVertices ; j++){
                //si existe una relacion entre el actual y j
                if(matrizAdyacencia[verticeActual][j]){
                    gradosEntradaDeVertices[j]--;//quitamos la conexion

                    //si el vertice ya no tiene conexiones se agrega
                    if(gradosEntradaDeVertices[j] == 0){
                        cola.insertar(j);
                    }
                }
            }
        }

        return nodosProcesados != numVertices;//true si tiene ciclos, false si no
    }

    /**
      * Regresará los datos del grafo en forma de matriz, para mostrar en consola.
     */
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

    /**
     * Inserta una nueva arista del vértice i al vértice j, siempre y cuando esto no ocasione la aparición de un ciclo.
     * Regresa true si la inserción tuvo éxito, en otro caso regresa falso. Si i y j son iguales regresa falso y si la arista de i a j ya existe, de nuevo, regresa falso.
     * Si i o j está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
    */
    // Inserta una nueva arista del vértice i al vértice j, siempre y cuando esto no ocasione la aparición de un ciclo.
    //Regresa true si la inserción tuvo éxito, en otro caso regresa falso. Si i y j son iguales regresa falso y si la arista de i a j ya existe, de nuevo, regresa falso.
    //Si i o j está fuera del rango de n -1, lance una excepción Ilegal argument value Exception.
    public boolean insertarArista(int i, int j){
        //validaciones
        if (i < 0 || i >= numVertices) {
            throw new IllegalArgumentException("El vertice " + i + " esta fuera de rango.");
        }
        if (j < 0 || j >= numVertices) {
            throw new IllegalArgumentException("El vertice " + j + " esta fuera de rango.");
        }

        //si son iguales generaria un ciclo
        if (i == j) {
            return false;
        }

        // si la conexion existe regresa false
        if (matrizAdyacencia[i][j]) {
            return false;
        }

       //si no hay errores anteriores suponemos que esta bien
        matrizAdyacencia[i][j] = true;

        //verificamos si tiene ciclos
        if (this.tieneCiclos()) {
           //si tiene ciclos eliminamos la relacion intentada por el usuario
            matrizAdyacencia[i][j] = false;
            return false;
        }

        //si no hubo errores incrementamos numero de aristas y true
        this.numAristas++;
        return true;
    }

    /**
      * Elimina todas las aristas del grafo
     */
    public void eliminarAristas(){
        for(int i = 0; i < numVertices; i++){
            for(int j = 0; j < numVertices; j++){
                matrizAdyacencia[i][j] = false;
            }
        }
        this.numAristas = 0;
    }
}