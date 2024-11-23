/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import EDD.ArbolGnral;
import EDD.HashTable;
import EDD.Lista;
import EDD.Nodo;
import EDD.NodoArbol;
import static Interfaces.Iniciar.arbolGenealogico;

/**
 *
 * @author obelm
 */
public class ArbolGenealogico {

    private ArbolGnral arbol;
    private HashTable hashTable;
    private String nombreLinaje;

    public ArbolGenealogico() {
        this.arbol = new ArbolGnral();
        this.hashTable = new HashTable(100);
    }

    public ArbolGnral getArbol() {
        return arbol;
    }

    public void setArbol(ArbolGnral arbol) {
        this.arbol = arbol;
    }

    public HashTable getHashTable() {
        return hashTable;
    }

    public void setHashTable(HashTable hashTable) {
        this.hashTable = hashTable;
    }

    public String getNombreLinaje() {
        return nombreLinaje;
    }

    public void setNombreLinaje(String nombreLinaje) {
        this.nombreLinaje = nombreLinaje;
    }

    

    public Persona[] buscarNombre(String nombre) {

        Lista resultados = arbolGenealogico.getHashTable().buscarNombre(nombre);
        if (!resultados.isEmpty()) {
            return this.convertirResultadosArreglo(resultados);
        }

        return null;
    }

    public Persona[] buscarTitulo(String titulo) {

        Lista resultados = arbolGenealogico.getHashTable().buscarTitulo(titulo);
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

    public String mostrarResultados(Persona[] resultado) {
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

        return this.hashTable.buscar(clave).toString();
    }

    public String mostrarGeneracion(int nivel) {
        Lista generacion = this.arbol.obtenerNodosEnNivel(nivel);
        String generacionStr = "Generacion " + nivel + ":\n";
        String separacion = "==================================";

        Nodo temp = generacion.getpFirst();
        while (temp != null) {
            Persona personaActual = (Persona) temp.getDato();
            generacionStr += separacion + "\n" + personaActual.toString() + "\n" + separacion + "\n";
            temp = temp.getpNext();
        }

        return generacionStr;
    }

    public Lista opcionesDeGeneracion() {
        Lista generaciones = new Lista();
        int max = this.arbol.maximoNivel();
        for (int i = 0; i < max; i++) {
            int numero = i + 1;
            String generacionActual = "Generacion " + numero;
            generaciones.insertarFinal(generacionActual);
        }

        return generaciones;
    }

    public ArbolGnral descendencia(Persona[] arreglo, int index) {
        if (index >= 0 && index < arreglo.length) {
            String clave = "";

            if (arreglo[index].getMote() != null) {
                clave = arreglo[index].getMote();
            } else {
                clave = arreglo[index].getNombreCompleto() + " " + arreglo[index].getNumeral();
            }

            NodoArbol raiz2 = this.getArbol().buscarPorNombreClave(clave);

            ArbolGnral arbolDesc = new ArbolGnral();
            arbolDesc.setRaiz(raiz2);

            
            return arbolDesc;
        } else {
           
            return null;
        }
    }
    
     public Lista mostrarAntepasados(Persona[] arreglo, int index) {
        if (index >= 0 && index < arreglo.length) {
            String clave = "";

            if (arreglo[index].getMote() != null) {
                clave = arreglo[index].getMote();
            } else {
                clave = arreglo[index].getNombreCompleto() + " " + arreglo[index].getNumeral();
            }

            NodoArbol raiz2 = this.getArbol().buscarPorNombreClave(clave);
            if(raiz2 != null){
                return this.arbol.listaAncestros(raiz2);
            }

            
        }
        
        return null;

    }

}
