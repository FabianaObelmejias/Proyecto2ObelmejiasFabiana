/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import EDD.ArbolGeneral;
import EDD.HashTable;
import EDD.Lista;
import EDD.Nodo;
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
    
    public Persona[] convertirResultadosArreglo(Lista resultados) {
        Persona[] resultadosStr = new Persona[resultados.getSize()];

        Nodo temp = resultados.getpFirst();
        int count = 0;
        while (temp != null) {
            Persona personaActual = (Persona) temp.getDato();
            resultadosStr[count] = personaActual;
            temp = temp.getpNext();
            count++;
        }

        return resultadosStr;

    }
    public String mostrarResultados(Persona[] resultado){
        String resultStr = "Resultados de la Busqueda:\n";
        for (int i = 0; i < resultado.length; i++) {
             
            resultStr += i + " " + "Mote: " + resultado[i].getMote() + " Nombre: " + resultado[i].getNombreCompleto() + " " + resultado[i].getNumeral() + "\n";
        }
        
        return resultStr;
    }
    
    public String detallesPersona(Persona persona) {
        String clave = "";
        if (persona.getMote() != null) {
            clave = persona.getMote();
        } else {
            clave = persona.getNombreCompleto() + " " + persona.getNumeral();
        }

        return this.hashtable.buscar(clave).toString();
    }


    public void buscarTitulo(String titulo) {

    }

    public void mostrarGeneracion(int generacion) {

    }

    public Lista opcionesDeGeneracion() {
        return null;
    }
    

    public Object getHashTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public String mostrarResultadoos(Persona[] arregloResultado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    
    
}
