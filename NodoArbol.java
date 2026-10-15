//ESTE ES EL NODO binario 
public class NodoArbol<T> {

    private T dato;
    private NodoArbol<T> izquierdo;
    private NodoArbol<T> derecho;

    public NodoArbol(T dato) {
        this.dato = dato;
        this.izquierdo = null;//toma un espacio como vacio
        this.derecho = null;
    }

    public T getDato() { return dato; }
    public void setDato(T dato) { this.dato = dato; } //.dato guarda el nodo tipo generico

    public NodoArbol<T> getIzquierdo() { return izquierdo; }
    public void setIzquierdo(NodoArbol<T> izquierdo) { this.izquierdo = izquierdo; } //devuelve el nodo izuqierdo

    public NodoArbol<T> getDerecho() { return derecho; }
    public void setDerecho(NodoArbol<T> derecho) { this.derecho = derecho; }//devuelve el nodo derecho
}
