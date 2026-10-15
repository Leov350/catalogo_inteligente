
public class ArbolBST {

    private NodoArbol<Integer> raiz;

    // contador de comparaciones de la ultima busqueda
    private int comparaciones;

    public ArbolBST() {
        raiz = null;
        comparaciones = 0;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoArbol<Integer> insertarRec(NodoArbol<Integer> nodo, int valor) {
        // caso base posicion vacia, se crea el nodo
        if (nodo == null) return new NodoArbol<>(valor);

        if (valor < nodo.getDato()) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), valor));
        } else {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), valor));
        }
        return nodo;
    }

  
    public boolean buscar(int valor) {
        comparaciones = 0;
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(NodoArbol<Integer> nodo, int valor) {
        if (nodo == null) return false;
        comparaciones++; // cada nodo visitado cuenta como una comparacion
        if (valor == nodo.getDato()) return true;
        return valor < nodo.getDato()
                ? buscarRec(nodo.getIzquierdo(), valor)
                : buscarRec(nodo.getDerecho(), valor);
    }

    public int getComparaciones() {
        return comparaciones;
    }

    // Devuelve el camino recorrido durante la busqueda
    public String buscarConCamino(int valor) {
        StringBuilder camino = new StringBuilder();
        NodoArbol<Integer> actual = raiz;
        while (actual != null) {
            if (camino.length() > 0) camino.append(" -> ");
            camino.append(actual.getDato());
            if (valor == actual.getDato()) {
                return camino + "  (ENCONTRADO)";
            }
            actual = (valor < actual.getDato()) ? actual.getIzquierdo() : actual.getDerecho();
        }
        if (camino.length() > 0) camino.append(" -> ");
        camino.append("null");
        return camino + "  (NO ENCONTRADO)";
    }

 //AQUI siempre baja por la izquierda 
    public int minValor(NodoArbol<Integer> nodo) { //toma un nodo lo define como integral
        int min = nodo.getDato();
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
            min = nodo.getDato();
        }
        return min;
    }

   
    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private NodoArbol<Integer> eliminarRec(NodoArbol<Integer> nodo, int valor) {
        if (nodo == null) return null;

        if (valor < nodo.getDato()) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getDato()) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), valor));
        } else {
            // se encontro el nodo a eliminar

           
            if (nodo.getIzquierdo() == null) return nodo.getDerecho();//toma el nodo 1 y 2 
            // caso 2: sin hijo derecho
            if (nodo.getDerecho() == null) return nodo.getIzquierdo();

    
            int sucesor = minValor(nodo.getDerecho());
            nodo.setDato(sucesor);
            // se elimina el valor duplicado del subarbol derecho
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor));
        }
        return nodo;
    }

  
    public int altura() {
        return alturaRec(raiz);//toma altura como un entero y lo regresa como raiz creando una nueva variable
    }

    private int alturaRec(NodoArbol<Integer> nodo) {
        if (nodo == null) return 0;//
        return 1 + Math.max(alturaRec(nodo.getIzquierdo()), alturaRec(nodo.getDerecho()));//math. devuelve el numero mas grande
    }

    public String inorden() {
        StringBuilder sb = new StringBuilder();//crea un objeto tpo cadena 
        inordenRec(raiz, sb);//toma la variable raiz 
        return sb.toString().trim(); //
    }

    private void inordenRec(NodoArbol<Integer> nodo, StringBuilder sb) {
        if (nodo == null) return;
        inordenRec(nodo.getIzquierdo(), sb);//
        sb.append(nodo.getDato()).append(" ");//SI NO HAY UN ELEMENTO SE AGREGA un caracter o al finalizar una secuencia 
        inordenRec(nodo.getDerecho(), sb);
    }

  //aqui estas las propiedades de BST
    public boolean esBST() {
        return esBSTRec(raiz, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean esBSTRec(NodoArbol<Integer> nodo, long min, long max) {//Integer devuelve un numero entero en un objeto
        if (nodo == null) return true;
        int d = nodo.getDato();
        // izquierda: estrictamente menor; derecha: mayor o igual
        if (d < min || d >= max) return false;
        return esBSTRec(nodo.getIzquierdo(), min, d)
            && esBSTRec(nodo.getDerecho(), d, max);
    }

    // hace el arbol de la raiz queda a la izquierda,
    // el subarbol derecho arriba y el izquierdo abajo.
    public void imprimirArbol() {
        if (raiz == null) {
            System.out.println("(arbol vacio)");
            return;
        }
        imprimirRec(raiz, 0);
    }

    private void imprimirRec(NodoArbol<Integer> nodo, int nivel) {
        if (nodo == null) return;
        imprimirRec(nodo.getDerecho(), nivel + 1);
        System.out.println("    ".repeat(nivel) + nodo.getDato());
        imprimirRec(nodo.getIzquierdo(), nivel + 1);
    }
}//el imprimirRec muestra en pantalla de fomra recursiva 
