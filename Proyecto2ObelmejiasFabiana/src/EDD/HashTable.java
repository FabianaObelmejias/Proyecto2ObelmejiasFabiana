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
public class HashTable {

    private Lista[] tabla;
    private int capacidad;

    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Lista[capacidad];
        this.inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < this.capacidad; i++) {
            tabla[i] = new Lista();
        }
    }

    private int hash(Object clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    public void insertar(Object clave, Object dato) {
        int indice = hash(clave);
        Lista listaEnIndice = tabla[indice];

        if (!listaEnIndice.buscar(dato)) {
            listaEnIndice.insertarFinal(dato);
        }
    }

    public Object buscar(String clave) {
        int indice = hash(clave);
        Lista listaEnIndice = tabla[indice];

        if (!listaEnIndice.isEmpty()) {
            Nodo temp = listaEnIndice.getpFirst();
            while (temp != null) {
                Persona personaActual = (Persona) temp.getDato();
                if (personaActual.nombreUnico().equalsIgnoreCase(clave)) {
                    return personaActual;
                }

                temp = temp.getpNext();
            }

            return null;
        }

        return null;
    }

    public Lista buscarNombre(String nombre) {
        Lista resultado = new Lista();

        for (int i = 0; i < this.capacidad; i++) {
            if (!tabla[i].isEmpty()) {
                Nodo temp = tabla[i].getpFirst();
                while (temp != null) {
                    Persona personaAct = (Persona) temp.getDato();
                    if (personaAct.getMote() != null) {
                        if (personaAct.getMote().toLowerCase().contains(nombre.toLowerCase())) {
                            resultado.insertarFinal(personaAct);
                        } else if (personaAct.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase())) {
                            resultado.insertarFinal(personaAct);
                        }
                    } else {
                        if (personaAct.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase())) {
                            resultado.insertarFinal(personaAct);
                        }
                    }
                    temp = temp.getpNext();
                }
            }
        }

        return resultado;
    }

    public Lista buscarTitulo(String titulo) {
        Lista personasFiltradas = new Lista();
        for (int i = 0; i < this.capacidad; i++) {
            if (!tabla[i].isEmpty()) {
                Nodo temp = tabla[i].getpFirst();
                while (temp != null) {
                    Persona personaAct = (Persona) temp.getDato();
                    if (personaAct.getTitulo() != null) {
                        if (personaAct.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                            personasFiltradas.insertarFinal(personaAct);
                        }
                    }
                    temp = temp.getpNext();
                }

            }
        }

        return personasFiltradas;
    }

    public void destruir() {
        for (int i = 0; i < this.capacidad; i++) {
            tabla[i] = new Lista();
        }
    }

    public void mostrar() {
        for (int i = 0; i < capacidad; i++) {
            if (!tabla[i].isEmpty()) {
                System.out.println("\nInidice" + i + ":");
                Nodo temp = tabla[i].getpFirst();
                while (temp != null) {
                    Persona personaAct = (Persona) temp.getDato();
                    System.out.print(personaAct.nombreUnico() + "->");
                    temp = temp.getpNext();
                }
                System.out.println("null");
            }
        }
    }
}
