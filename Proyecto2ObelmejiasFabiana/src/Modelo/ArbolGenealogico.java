/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import EDD.ArbolGeneral;
import EDD.HashTable;
import EDD.Lista;

/**
 *
 * @author obelm
 */
public class ArbolGenealogico {
    private ArbolGeneral arbol;
    private HashTable hashtable;

    public ArbolGenealogico() {
        this.arbol = new ArbolGeneral();
        this.hashtable = new HashTable(100);
    }
    
    public ArbolGeneral getArbol() {
        return arbol;
    }

    public void setArbol(ArbolGeneral arbol) {
        this.arbol = arbol;
    }

    public HashTable getHashtable() {
        return hashtable;
    }

    public void setHashtable(HashTable hashtable) {
        this.hashtable = hashtable;
    }
    
    
    //es necesario agregar una persona
    public void agregarPersona(Persona persona){
        
    }
    
    public void mostrarAntepasados(Persona persona){
        
    }
    
    public void buscarNombre(String nombre){
        
    }
    
    public void buscarTitulo(String titulo){
        
    }
    
    public void mostrarGeneracion(int generacion){
        
    }
    
    public Lista opcionesDeGeneracion(){
        return null;
    }

   
    
    
    
}
