/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 * Clase que representa una cola (estructura de datos FIFO: First In, First Out).
 * Permite agregar elementos al final y retirar elementos del frente.
 * Utiliza nodos enlazados para su implementación.
 * 
 * @author obelm
 */
public class Cola {

    // Nodo que apunta al final de la cola (último elemento).
    private Nodo cola;

    // Nodo que apunta al inicio de la cola (primer elemento).
    private Nodo cabeza;

    // Tamaño actual de la cola (número de elementos).
    private int size;

    /**
     * Constructor por defecto.
     * Inicializa una cola vacía.
     */
    public Cola() {
        this.cola = this.cabeza = null;
        this.size = 0;
    }

    /**
     * Obtiene el nodo que está al final de la cola.
     * 
     * @return el nodo al final de la cola
     */
    public Nodo getCola() {
        return cola;
    }

    /**
     * Asigna un nuevo nodo como el final de la cola.
     * 
     * @param cola el nodo a establecer como el último nodo
     */
    public void setCola(Nodo cola) {
        this.cola = cola;
    }

    /**
     * Obtiene el nodo que está al inicio de la cola.
     * 
     * @return el nodo al inicio de la cola
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * Asigna un nuevo nodo como el inicio de la cola.
     * 
     * @param cabeza el nodo a establecer como el primer nodo
     */
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Obtiene el tamaño actual de la cola.
     * 
     * @return el número de elementos en la cola
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece un nuevo tamaño para la cola.
     * 
     * @param size el tamaño a establecer
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si la cola no tiene elementos, false en caso contrario
     */
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    /**
     * Agrega un nuevo elemento al final de la cola.
     * 
     * @param dato el dato que se desea agregar a la cola
     */
    public void encolar(Object dato) {
        // Crear un nuevo nodo con el dato proporcionado
        Nodo pNew = new Nodo(dato);

        if (this.isEmpty()) {
            // Si la cola está vacía, el nuevo nodo será tanto la cabeza como la cola
            this.setCabeza(pNew);
            this.setCola(pNew);
        } else {
            // Si no está vacía, enlazar el nuevo nodo al final de la cola
            this.cola.setpNext(pNew);
            this.setCola(pNew); // Actualizar la referencia del último nodo
        }

        size++; // Incrementar el tamaño de la cola
    }

    /**
     * Retira y devuelve el elemento al inicio de la cola.
     * 
     * @return el dato almacenado en el primer nodo de la cola, o null si la cola está vacía
     */
    public Object desencolar() {
        if (!this.isEmpty()) {
            // Guardar el dato del primer nodo
            Object eliminar = this.cabeza.getDato();
            // Mover la referencia de la cabeza al siguiente nodo
            this.setCabeza(this.cabeza.getpNext());

            // Disminuir el tamaño de la cola
            size--;
            return eliminar; // Devolver el dato eliminado
        }
        return null; // Si está vacía, no hay nada que eliminar
    }

    /**
     * Muestra todos los elementos de la cola en un cuadro de diálogo.
     * Si la cola está vacía, muestra un mensaje indicándolo.
     */
    public void mostrar() {
        if (!this.isEmpty()) {
            String listaString = "";

            // Recorrer la cola desde la cabeza hasta el final
            Nodo temp = this.cabeza;
            while (temp != null) {
                listaString += temp.getDato() + "\n"; // Concatenar los datos en un string
                temp = temp.getpNext(); // Avanzar al siguiente nodo
            }

            JOptionPane.showMessageDialog(null, listaString);
        } else {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
        }
    }
}