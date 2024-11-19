/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author obelm
 */
public class ArbolGeneral {
    //primero se crea el nodo del árbol
    private Object dato;
    private NodoArbol padre; // no esta en las instrucciones pero es importante para que cada nodo sepa quie es su padre
    private Lista hijos;

    public ArbolGeneral(Object dato) { //solo necesito el dato
        this.dato = dato;
        this.padre = null; //el padre cuando lo cree en un principio va a ser nulo
        this.hijos = new Lista();
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoArbol getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }

    public Lista getHijos() {
        return hijos;
    }

    public void setHijos(Lista hijos) {
        this.hijos = hijos;
    }
    
    
    
    
}
