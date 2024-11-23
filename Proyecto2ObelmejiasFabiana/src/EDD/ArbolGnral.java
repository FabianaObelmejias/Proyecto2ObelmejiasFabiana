/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Modelo.Persona;
import javax.swing.JOptionPane;

/**
 * Clase que representa un árbol general, donde cada nodo puede tener múltiples hijos.
 * Los nodos se organizan jerárquicamente, con una raíz inicial y ramas de nodos hijos.
 * 
 * Este árbol permite almacenar datos de tipo {@link Persona} y realizar operaciones
 * como agregar nodos, buscar, mostrar por nivel y calcular el nivel máximo.
 * 
 * Se implementa utilizando nodos del tipo {@link NodoArbol}.
 * 
 * @author obelm
 */
public class ArbolGnral {

    // Nodo raíz del árbol
    private NodoArbol raiz;

    /**
     * Constructor que inicializa un árbol vacío.
     */
    public ArbolGnral() {
        this.raiz = null;
    }

    /**
     * Obtiene el nodo raíz del árbol.
     * 
     * @return el nodo raíz
     */
    public NodoArbol getRaiz() {
        return raiz;
    }

    /**
     * Establece un nodo como la raíz del árbol.
     * 
     * @param raiz el nodo a establecer como raíz
     */
    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    /**
     * Verifica si el árbol está vacío.
     * 
     * @return true si el árbol no tiene nodos, false en caso contrario
     */
    public boolean isEmpty() {
        return this.raiz == null;
    }

    /**
     * Crea la raíz del árbol con un dato específico.
     * 
     * @param dato el dato que se almacenará en la raíz
     * @return el nodo raíz creado
     */
    public NodoArbol crearRaiz(Object dato) {
        this.raiz = new NodoArbol(dato);
        return this.raiz;
    }

    /**
     * Agrega un hijo a un nodo específico del árbol.
     * Si el nodo ya existe en el árbol (verificado por su nombre único o mote), no lo agrega.
     * 
     * @param padre el nodo al que se agregará el hijo
     * @param dato el dato que se almacenará en el nuevo nodo hijo
     * @return el nodo hijo agregado, o null si ya existía
     */
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
            if (this.buscarPorNombreClave(nombreUnico) == null) {
                padre.agregarHijo(hijo);
                return hijo;
            }
        }

        return null; // No se agrega el hijo si ya existe
    }

    /**
     * Busca un nodo en el árbol cuyo nombre completo coincide con el proporcionado.
     * La búsqueda se realiza en orden por niveles.
     * 
     * @param nombre el nombre completo del nodo a buscar
     * @return el nodo encontrado, o null si no se encuentra
     */
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

            // Encolar los hijos del nodo actual
            Nodo hijoNodo = nodoActual.getHijos().getpFirst();
            while (hijoNodo != null) {
                NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                cola.encolar(hijo);
                hijoNodo = hijoNodo.getpNext();
            }
        }

        return null; // No encontrado
    }

    /**
     * Busca un nodo en el árbol cuyo mote o nombre único coincide con el proporcionado.
     * La búsqueda se realiza en orden por niveles.
     * 
     * @param nombre el mote o nombre único del nodo a buscar
     * @return el nodo encontrado, o null si no se encuentra
     */
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

            // Encolar los hijos del nodo actual
            Nodo hijoNodo = nodoActual.getHijos().getpFirst();
            while (hijoNodo != null) {
                NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                cola.encolar(hijo);
                hijoNodo = hijoNodo.getpNext();
            }
        }

        return null; // No encontrado
    }

    /**
     * Muestra el contenido del árbol por niveles en la consola.
     * Si el árbol está vacío, muestra un mensaje indicando que está vacío.
     */
    public void mostrarPorNivel() {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Árbol vacío");
        } else {
            String arbolStr = "Árbol:\n";
            Cola cola = new Cola();
            cola.encolar(raiz);

            while (!cola.isEmpty()) {
                NodoArbol nodoActual = (NodoArbol) cola.desencolar();
                Persona persona = (Persona) nodoActual.getDato();

                arbolStr += persona + "\n\n";

                // Encolar los hijos del nodo actual
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

    /**
     * Calcula el nivel máximo (profundidad) del árbol.
     * 
     * @return el nivel máximo del árbol
     */
    public int maximoNivel() {
        if (this.isEmpty()) {
            return 0; // Si el árbol está vacío, el nivel máximo es 0
        }

        int maxNivel = 0;
        Cola cola = new Cola();
        cola.encolar(new NodoNivel(raiz, 1)); // Nodo con nivel inicial 1

        while (!cola.isEmpty()) {
            NodoNivel nodoActual = (NodoNivel) cola.desencolar();
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

    /**
     * Obtiene los nodos de un nivel específico del árbol.
     * 
     * @param nivelBuscado el nivel a buscar
     * @return una lista con los nodos en el nivel especificado
     */
    public Lista obtenerNodosEnNivel(int nivelBuscado) {
        Lista nodosEnNivel = new Lista();

        if (this.isEmpty()) {
            return nodosEnNivel; // Retorna lista vacía si el árbol está vacío
        }

        Cola cola = new Cola();
        cola.encolar(new NodoNivel(raiz, 1)); // Nodo raíz con nivel inicial 1

        while (!cola.isEmpty()) {
            NodoNivel nodoActual = (NodoNivel) cola.desencolar();

            if (nodoActual.getNivel() == nivelBuscado) {
                nodosEnNivel.insertarFinal(nodoActual.getNodo().getDato());
            }

            Nodo hijoNodo = nodoActual.getNodo().getHijos().getpFirst();
            while (hijoNodo != null) {
                NodoArbol hijo = (NodoArbol) hijoNodo.getDato();
                cola.encolar(new NodoNivel(hijo, nodoActual.getNivel() + 1));
                hijoNodo = hijoNodo.getpNext();
            }
        }

        return nodosEnNivel;
    }

    /**
     * Obtiene la lista de ancestros de un nodo específico.
     * 
     * @param nodo el nodo del cual obtener los ancestros
     * @return una lista de ancestros, o null si el nodo es null
     */
    public Lista listaAncestros(NodoArbol nodo) {
        if (nodo != null) {
            Lista ancestros = new Lista();
            NodoArbol nodoActual = nodo.getPadre();

            while (nodoActual != null) {
                Persona personaAct = (Persona) nodoActual.getDato();
                ancestros.insertarFinal(personaAct);
                nodoActual = nodoActual.getPadre();
            }

            return ancestros;
        }

        return null; // Si el nodo es null, no hay ancestros
    }
}
