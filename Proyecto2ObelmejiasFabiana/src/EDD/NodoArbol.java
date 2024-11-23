/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author obelm
 */
public class NodoArbol {
    private Object dato;
    private NodoArbol padre;
    private Lista hijos;

    public NodoArbol(Object dato) {
        this.dato = dato;
        this.padre = null;
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
    
    public void agregarHijo(NodoArbol hijo){
        hijo.setPadre(this);
        this.hijos.insertarFinal(hijo);
    }
    
    public boolean esHoja(){
        return hijos.isEmpty();
    }
}
