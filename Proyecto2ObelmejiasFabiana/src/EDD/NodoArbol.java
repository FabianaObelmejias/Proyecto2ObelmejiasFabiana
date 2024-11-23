/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Clase que representa un nodo en un árbol genérico.
 * Cada nodo puede contener un dato, un enlace a su nodo padre, 
 * y una lista de nodos hijos.
 * 
 * @author obelm
 */
public class NodoArbol {

    // Dato almacenado en el nodo
    private Object dato;

    // Nodo padre del nodo actual (puede ser null si es la raíz)
    private NodoArbol padre;

    // Lista de nodos hijos
    private Lista hijos;

    /**
     * Constructor que inicializa un nodo con un dato específico.
     * El nodo no tiene padre inicialmente y su lista de hijos está vacía.
     * 
     * @param dato el dato que almacena el nodo
     */
    public NodoArbol(Object dato) {
        this.dato = dato;
        this.padre = null;
        this.hijos = new Lista(); // Inicializa la lista de hijos vacía
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     * 
     * @return el dato del nodo
     */
    public Object getDato() {
        return dato;
    }

    /**
     * Asigna un nuevo dato al nodo.
     * 
     * @param dato el dato a asignar
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el nodo padre del nodo actual.
     * 
     * @return el nodo padre, o null si es la raíz
     */
    public NodoArbol getPadre() {
        return padre;
    }

    /**
     * Establece un nodo como el padre del nodo actual.
     * 
     * @param padre el nodo a establecer como padre
     */
    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }

    /**
     * Obtiene la lista de nodos hijos del nodo actual.
     * 
     * @return la lista de hijos
     */
    public Lista getHijos() {
        return hijos;
    }

    /**
     * Establece una lista de nodos como hijos del nodo actual.
     * 
     * @param hijos la lista de nodos hijos
     */
    public void setHijos(Lista hijos) {
        this.hijos = hijos;
    }

    /**
     * Agrega un nodo como hijo del nodo actual.
     * También establece al nodo actual como el padre del hijo agregado.
     * 
     * @param hijo el nodo a agregar como hijo
     */
    public void agregarHijo(NodoArbol hijo) {
        hijo.setPadre(this); // Establece el nodo actual como padre del hijo
        this.hijos.insertarFinal(hijo); // Agrega el hijo a la lista de hijos
    }

    /**
     * Verifica si el nodo actual es una hoja (no tiene hijos).
     * 
     * @return true si el nodo no tiene hijos, false en caso contrario
     */
    public boolean esHoja() {
        return hijos.isEmpty();
    }
}
