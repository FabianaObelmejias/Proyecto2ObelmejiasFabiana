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
public class ArbolGnral {

    private NodoArbol raiz;

    public ArbolGnral() {
        this.raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public NodoArbol crearRaiz(Object dato) {
        this.raiz = new NodoArbol(dato);
        return this.raiz;
    }

    public NodoArbol agregarHijo(NodoArbol padre, Object dato) {
        NodoArbol hijo = new NodoArbol(dato);
        Persona personaNueva = (Persona) dato;
        if (personaNueva.getMote() != null) {
            String nombreUnico = personaNueva.getNombreCompleto() + " " + personaNueva.getNumeral();
            if (this.buscarPorNombreClave(nombreUnico) == null && this.buscarPorNombreClave(personaNueva.getMote()) == null) {
                padre.agregarHijo(hijo);
                return hijo;
            }
        } else {
           String nombreUnico = personaNueva.getNombreCompleto() + " " + personaNueva.getNumeral();
           if (this.buscarPorNombreClave(nombreUnico) == null){
               padre.agregarHijo(hijo);
               return hijo;
           } 
        }
        
        return null;
    }

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
                } else {
                    String nombreComparar = persona.getNombreCompleto() + " " + persona.getNumeral();

                    if (nombreComparar.equalsIgnoreCase(nombre)) {
                        return nodoActual;
                    }

                }
            } else {
                String nombreComparar = persona.getNombreCompleto() + " " + persona.getNumeral();

                if (nombreComparar.equalsIgnoreCase(nombre)) {
                    return nodoActual;
                }
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

    public void mostrarPorNivel() {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Arbol Vacio");
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

    public int maximoNivel() {
        if (this.isEmpty()) {
            return 0; // Si el árbol está vacío, el nivel máximo es 0
        }

        int maxNivel = 0;

        // Cola para realizar el recorrido por niveles
        Cola cola = new Cola();
        cola.encolar(new NodoNivel(raiz, 1)); // Nodo con nivel inicial 1

        while (!cola.isEmpty()) {
            NodoNivel nodoActual = (NodoNivel) cola.desencolar();

            // Actualizar el nivel máximo si encontramos un nivel mayor
            maxNivel = Math.max(maxNivel, nodoActual.getNivel());

            // Encolar todos los hijos con su nivel correspondiente
            Nodo hijoNodo = nodoActual.getNodo().getHijos().getpFirst();
            while (hijoNodo != null) {
                NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                cola.encolar(new NodoNivel(hijo, nodoActual.getNivel() + 1));
                hijoNodo = hijoNodo.getpNext();
            }
        }

        return maxNivel;
    }

    public Lista obtenerNodosEnNivel(int nivelBuscado) {
        Lista nodosEnNivel = new Lista();

        if (this.isEmpty()) {
            return nodosEnNivel; // Retorna lista vacía si el árbol está vacío
        }

        // Cola para realizar el recorrido por niveles
        Cola cola = new Cola();
        cola.encolar(new NodoNivel(raiz, 1)); // Nodo raíz con nivel inicial 1

        while (!cola.isEmpty()) {
            NodoNivel nodoActual = (NodoNivel) cola.desencolar();

            // Si estamos en el nivel buscado, agregar el nodo a la lista
            if (nodoActual.getNivel() == nivelBuscado) {
                nodosEnNivel.insertarFinal(nodoActual.getNodo().getDato());
            }

            // Continuar explorando hasta terminar todos los nodos
            Nodo hijoNodo = nodoActual.getNodo().getHijos().getpFirst();
            while (hijoNodo != null) {
                NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                cola.encolar(new NodoNivel(hijo, nodoActual.getNivel() + 1));
                hijoNodo = hijoNodo.getpNext();
            }
        }

        return nodosEnNivel;
    }

}
