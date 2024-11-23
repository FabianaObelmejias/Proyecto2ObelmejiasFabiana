/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Modelo.Persona;
import javax.swing.JOptionPane;

/**
 *
 * @author obelm
 */
public class ArbolGeneral{
   //solamenta va a tener la raiz 
    private NodoArbol raiz;

    public ArbolGeneral() {
        this.raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    public boolean isEmpty(){
        return this.raiz == null;
    }
    
    public NodoArbol crearRaiz(Object dato){//primero creo la raiz y despues le agrego los hijos
        this.raiz = new NodoArbol(dato);
        return this.raiz;
        
    }
    
    public NodoArbol agregarHijo(NodoArbol padre, Object dato){
        NodoArbol hijo = new NodoArbol(dato);
        padre.agregarHijo(hijo);
        return hijo;
    }
    
    //voy por cada nivel del arbol para buscar los nodos en cada nivel
    
    public NodoArbol buscarPorNombre(String nombre) {
        if (this.isEmpty()) {
            return null;
        }

        Cola cola = new Cola();
        cola.encolar(raiz);

        while (!cola.isEmpty()) {
            NodoArbol nodoActual = (NodoArbol) cola.desencolar();
            Persona persona = (Persona) nodoActual.getDato();
            if (persona.getNombreCompleto().equalsIgnoreCase(nombre)) {
                return nodoActual;
            }

            Nodo hijoNodo = nodoActual.getHijos().getpFirst();
            while (hijoNodo != null) {
                NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                cola.encolar(hijo);
                hijoNodo = hijoNodo.getpNext();
            }
        }

        return null;
    }
    
    public NodoArbol buscarPorNombreClave(String nombre) {
        if (this.isEmpty()) {
            return null;
        }

        Cola cola = new Cola();
        cola.encolar(raiz);

        while (!cola.isEmpty()) {
            NodoArbol nodoActual = (NodoArbol) cola.desencolar();
            Persona persona = (Persona) nodoActual.getDato();

            if (persona.getMote() != null) {
                if (persona.getMote().equalsIgnoreCase(nombre)) {
                    return nodoActual;
    
    
    public void mostrarPorNivel(){
        //depende del buscarPorNombre AJURO, con ello podremos probar la funcionalidad del arbol
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Arbol se encuentra Vacio");
        } else {
            String arbolStr = "Arbol:\n";
            Cola cola = new Cola();
            cola.encolar(raiz);

            while (!cola.isEmpty()) {
                NodoArbol nodoActual = (NodoArbol) cola.desencolar();
                Persona persona = (Persona) nodoActual.getDato();
                
                arbolStr += persona + "\n\n";

                Nodo hijoNodo = nodoActual.getHijos().getpFirst();
                while (hijoNodo != null) {
                    NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                    cola.encolar(hijo);
                    hijoNodo = hijoNodo.getpNext();
                }
            }

            System.out.println(arbolStr);


        }
    }
}
