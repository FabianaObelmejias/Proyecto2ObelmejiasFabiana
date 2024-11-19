/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author obelm
 */
public class HashTable {
    private Lista[] tabla; //es mi primer atributo, es basicamente un arreglo de listas
    private int capacidad;

    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Lista(capacidad);
    }
    //Esto me resulta en un arreglo pero en cada funcion del arreglo no hay una lista sino que esta vacia
    
}
