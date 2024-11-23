/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import EDD.ArbolGeneral;
import EDD.HashTable;
import EDD.Lista;
import static Interfaces.Iniciar.arbolGenealogico;

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
    
    public Persona[] buscarNombre(String nombre) {

        Lista resultados = arbolGenealogico.getHashTable().buscarNombre(nombre);
        if (!resultados.isEmpty()) {
           return this.convertirResultadosArreglo(resultados);
        }
        
        return null;
    }
    
    
    
    public void buscarTitulo(String titulo){
        
    }
    
    public void mostrarGeneracion(int generacion){
        
    }
    
    public Lista opcionesDeGeneracion(){
        return null;
    }

    public Object getHashTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String mostrarResultados(Persona[] arregloResultado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String mostrarResultadoos(Persona[] arregloResultado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    
    
}
