/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;


/**
 * Clase que representa un nodo de árbol junto con su nivel en el árbol.
 * 
 * Es útil para recorridos por niveles en estructuras de árboles,
 * donde es necesario conocer el nivel de cada nodo durante el recorrido.
 * 
 * @author obelm
 */
public class NodoNivel {

    // Nodo de tipo NodoArbol asociado a este nivel
    private NodoArbol nodo;

    // Nivel del nodo en el árbol (1 para la raíz, 2 para los hijos de la raíz, etc.)
    private int nivel;

    /**
     * Constructor que inicializa un nodo con su nivel asociado.
     * 
     * @param nodo el nodo de tipo {@link NodoArbol}
     * @param nivel el nivel del nodo en el árbol
     */
    public NodoNivel(NodoArbol nodo, int nivel) {
        this.nodo = nodo;
        this.nivel = nivel;
    }

    /**
     * Obtiene el nodo asociado a este objeto.
     * 
     * @return el nodo de tipo {@link NodoArbol}
     */
    public NodoArbol getNodo() {
        return nodo;
    }

    /**
     * Establece un nuevo nodo para este objeto.
     * 
     * @param nodo el nodo de tipo {@link NodoArbol} a establecer
     */
    public void setNodo(NodoArbol nodo) {
        this.nodo = nodo;
    }

    /**
     * Obtiene el nivel del nodo en el árbol.
     * 
     * @return el nivel del nodo
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece un nuevo nivel para el nodo.
     * 
     * @param nivel el nivel a establecer
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
