/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Modelo.Persona;

/**
 * Clase que implementa una tabla hash para almacenar objetos de tipo {@link Persona}.
 * Utiliza una lista enlazada en cada índice del arreglo para manejar colisiones mediante encadenamiento.
 * 
 * @author obelm
 */
public class HashTable {

    // Arreglo que representa la tabla hash, cada posición contiene una lista enlazada.
    private Lista[] tabla;

    // Capacidad de la tabla hash, es decir, el número de "buckets" disponibles.
    private int capacidad;

    /**
     * Constructor que inicializa la tabla hash con una capacidad especificada.
     * 
     * @param capacidad el número de buckets en la tabla hash
     */
    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Lista[capacidad];
        this.inicializar(); // Inicializa cada índice de la tabla con una lista vacía.
    }

    /**
     * Método privado para inicializar las listas en cada posición de la tabla.
     */
    private void inicializar() {
        for (int i = 0; i < this.capacidad; i++) {
            tabla[i] = new Lista(); // Cada índice de la tabla contiene una lista enlazada.
        }
    }

    /**
     * Calcula el índice de la tabla hash para una clave dada utilizando su valor hash.
     * 
     * @param clave la clave para la cual calcular el índice
     * @return el índice calculado dentro del rango de la capacidad
     */
    private int hash(Object clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    /**
     * Inserta un objeto en la tabla hash basado en su clave.
     * Si el dato ya está presente en la lista correspondiente al índice, no lo agrega.
     * 
     * @param clave la clave que determina el índice
     * @param dato el objeto a insertar en la tabla hash
     */
    public void insertar(Object clave, Object dato) {
        int indice = hash(clave);
        Lista listaEnIndice = tabla[indice];

        // Verificar si el dato ya está en la lista antes de agregarlo.
        if (!listaEnIndice.buscar(dato)) {
            listaEnIndice.insertarFinal(dato);
        }
    }

    /**
     * Busca un objeto en la tabla hash basado en una clave.
     * 
     * @param clave la clave para buscar el objeto
     * @return el objeto encontrado, o null si no existe
     */
    public Object buscar(String clave) {
        int indice = hash(clave);
        Lista listaEnIndice = tabla[indice];

        if (!listaEnIndice.isEmpty()) {
            Nodo temp = listaEnIndice.getpFirst();

            while (temp != null) {
                Persona personaActual = (Persona) temp.getDato();

                // Comparar el nombre único de la persona (mote o combinación de nombre y numeral).
                if (personaActual.nombreUnico().equalsIgnoreCase(clave)) {
                    return personaActual; // Retornar la persona si coincide con la clave.
                }

                temp = temp.getpNext(); // Avanzar al siguiente nodo.
            }
        }

        return null; // Retornar null si no se encuentra el objeto.
    }

    /**
     * Busca todas las personas cuyo nombre (completo o mote) contiene la cadena especificada.
     * 
     * @param nombre el nombre a buscar
     * @return una lista con las personas que coinciden con el nombre
     */
    public Lista buscarNombre(String nombre) {
        Lista resultado = new Lista();

        for (int i = 0; i < this.capacidad; i++) {
            if (!tabla[i].isEmpty()) {
                Nodo temp = tabla[i].getpFirst();

                while (temp != null) {
                    Persona personaAct = (Persona) temp.getDato();

                    // Verificar si el mote o el nombre completo contiene el texto buscado.
                    if (personaAct.getMote() != null && personaAct.getMote().toLowerCase().contains(nombre.toLowerCase())) {
                        resultado.insertarFinal(personaAct);
                    } else if (personaAct.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase())) {
                        resultado.insertarFinal(personaAct);
                    }

                    temp = temp.getpNext();
                }
            }
        }

        return resultado; // Retornar la lista con los resultados.
    }

    /**
     * Busca todas las personas cuyo título contiene la cadena especificada.
     * 
     * @param titulo el título a buscar
     * @return una lista con las personas que coinciden con el título
     */
    public Lista buscarTitulo(String titulo) {
        Lista personasFiltradas = new Lista();

        for (int i = 0; i < this.capacidad; i++) {
            if (!tabla[i].isEmpty()) {
                Nodo temp = tabla[i].getpFirst();

                while (temp != null) {
                    Persona personaAct = (Persona) temp.getDato();

                    // Verificar si el título contiene el texto buscado.
                    if (personaAct.getTitulo() != null && personaAct.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                        personasFiltradas.insertarFinal(personaAct);
                    }

                    temp = temp.getpNext();
                }
            }
        }

        return personasFiltradas; // Retornar la lista con los resultados.
    }

    /**
     * Destruye la tabla hash, eliminando todos los datos en cada índice.
     */
    public void destruir() {
        for (int i = 0; i < this.capacidad; i++) {
            tabla[i] = new Lista(); // Reemplazar cada lista por una nueva lista vacía.
        }
    }

    /**
     * Muestra el contenido de la tabla hash, imprimiendo los elementos en cada índice.
     */
    public void mostrar() {
        for (int i = 0; i < capacidad; i++) {
            if (!tabla[i].isEmpty()) {
                System.out.println("\nÍndice " + i + ":");
                Nodo temp = tabla[i].getpFirst();

                while (temp != null) {
                    Persona personaAct = (Persona) temp.getDato();

                    // Mostrar el nombre único de la persona.
                    System.out.print(personaAct.nombreUnico() + " -> ");
                    temp = temp.getpNext();
                }

                System.out.println("null");
            }
        }
    }
}
