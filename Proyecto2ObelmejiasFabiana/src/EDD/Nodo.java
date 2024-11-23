/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Clase que representa un nodo de una estructura enlazada.
 * Puede almacenar un dato genérico y una referencia al siguiente nodo en la lista.
 * 
 * @author obelm
 */
public class Nodo {

    // Atributo que almacena el dato del nodo.
    private Object dato;

    // Referencia al siguiente nodo en la lista (puede ser null si es el último nodo).
    private Nodo pNext;

    /**
     * Constructor por defecto.
     * Inicializa el nodo con un dato null y sin referencia a un nodo siguiente.
     */
    public Nodo() {
        this.dato = null;
        this.pNext = null;
    }

    /**
     * Constructor que permite inicializar el nodo con un dato específico.
     * La referencia al siguiente nodo se establece como null por defecto.
     * 
     * @param dato el dato que se almacenará en el nodo
     */
    public Nodo(Object dato) {
        this.dato = dato;
        this.pNext = null;
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
     * @param dato el dato a almacenar en el nodo
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la lista.
     * 
     * @return el siguiente nodo, o null si no hay uno
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * Asigna una referencia al siguiente nodo en la lista.
     * 
     * @param pNext el siguiente nodo
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
}

