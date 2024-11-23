/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 * Clase que representa una lista enlazada básica.
 * Esta estructura permite almacenar datos de forma dinámica con nodos que apuntan al siguiente nodo en la lista.
 * 
 * @author obelm
 */
public class Lista {

    // Nodo que apunta al primer elemento de la lista.
    private Nodo pFirst;

    // Contador que almacena el tamaño actual de la lista.
    private int size;

    /**
     * Constructor por defecto.
     * Inicializa la lista como vacía (sin nodos y con tamaño 0).
     */
    public Lista() {
        this.pFirst = null;
        this.size = 0;
    }

    /**
     * Obtiene el primer nodo de la lista.
     * 
     * @return el primer nodo de la lista
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * Asigna un nuevo primer nodo a la lista.
     * 
     * @param pFirst el nodo a establecer como primer nodo
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Obtiene el tamaño actual de la lista.
     * 
     * @return el número de elementos en la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Asigna un nuevo tamaño a la lista.
     * 
     * @param size el tamaño a establecer
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return this.pFirst == null;
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     * 
     * @param dato el dato que se desea agregar
     */
    public void insertarFinal(Object dato) {
        // Crear un nodo con el dato proporcionado
        Nodo pNew = new Nodo(dato);

        if (this.isEmpty()) {
            // Si la lista está vacía, el nuevo nodo se convierte en el primero
            this.setpFirst(pNew);
        } else {
            // Si no está vacía, buscar el último nodo
            Nodo temp = this.pFirst;
            while (temp.getpNext() != null) {
                temp = temp.getpNext(); // Avanzar al siguiente nodo
            }
            // Establecer el nuevo nodo como el siguiente del último
            temp.setpNext(pNew);
        }

        this.size++; // Incrementar el tamaño de la lista
    }

    /**
     * Busca un dato en la lista.
     * 
     * @param dato el dato a buscar
     * @return true si se encuentra el dato, false si no
     */
    public boolean buscar(Object dato) {
        if (!this.isEmpty()) {
            Nodo temp = this.pFirst;

            while (temp != null) {
                if (temp.getDato() == dato) {
                    return true; // Dato encontrado
                }
                temp = temp.getpNext(); // Avanzar al siguiente nodo
            }
        }
        return false; // Dato no encontrado
    }

    /**
     * Obtiene el valor almacenado en una posición específica de la lista.
     * 
     * @param posicion la posición del elemento a obtener (inicia en 0)
     * @return el valor en la posición dada, o null si la posición no es válida
     */
    public Object getValor(int posicion) {
        if (posicion >= 0 && posicion < size) {
            Nodo aux = pFirst;

            for (int i = 0; i < posicion; i++) {
                aux = aux.getpNext(); // Avanzar hasta la posición deseada
            }

            return aux.getDato();
        }
        return null; // Posición inválida
    }

    /**
     * Muestra los elementos de la lista en un cuadro de diálogo.
     * Si la lista está vacía, muestra un mensaje indicando que está vacía.
     */
    public void mostrar() {
        if (!this.isEmpty()) {
            String listaString = "";

            Nodo temp = this.pFirst;
            while (temp != null) {
                listaString += temp.getDato() + "\n"; // Concatenar el dato del nodo
                temp = temp.getpNext();
            }

            JOptionPane.showMessageDialog(null, listaString);
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
        }
    }

    /**
     * Destruye la lista, eliminando todos sus nodos.
     */
    public void destruir() {
        this.pFirst = null; // Eliminar la referencia al primer nodo
        this.size = 0;      // Reiniciar el tamaño de la lista
    }
}

