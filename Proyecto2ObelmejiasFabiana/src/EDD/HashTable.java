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

    private Lista[] tabla; //es mi primer atributo, es basicamente un arreglo de listas
    private int capacidad;

    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Lista[capacidad];
        this.inicializar();
    }

    //Esto me resulta en un arreglo pero en cada funcion del arreglo no hay una lista sino que esta vacia
    private void inicializar() {
        for (int i = 0; i < this.capacidad; i++) {
            tabla[i] = new Lista();
        }
    }

    private int hash(Object clave) { //esta fucnion me devuelve el indice que voy a insertar en la tabla
        return Math.abs(clave.hashCode()) % capacidad; //manejo la posible colision con listas
    }

    public void insertar(Object clave, Object dato) {
        int indice = hash(clave);//busco el indice que viene definido por la funcion hash, el indice me va a retornar un entero
        Lista listaEnIndice = tabla[indice]; //busco cual es ese indice

        //¿como se si la persona ya existe? me valgo del BUSCAR que tengo en lista
        if (!listaEnIndice.buscar(dato)) {
            listaEnIndice.insertarFinal(dato);
            JOptionPane.showMessageDialog(null, "Elemento agregado");
        }
    }

    public Object buscar(Object clave) {
        int indice = hash(clave);
        Lista listaEnIndice = tabla[indice];

        if (!listaEnIndice.isEmpty()) {

            Nodo temp = listaEnIndice.getpFirst();
            while (temp != null) {
                Persona personaActual = (Persona) temp.getDato();
                if (personaActual.nombreUnico().equalsIgnoreCase((String) clave)) {
                    return personaActual;
                }

                temp = temp.getpNext();

            }
            return null;

        }
        
        return null;
    }
    
    //DEBO utilizar el destruir para reinicializar todas las listas que estan en la tabla en caso tal de ser necesario
    public void destruir(){
        for(int i = 0; i < this.capacidad; i++)
            tabla[i] = new Lista();
    }
}
