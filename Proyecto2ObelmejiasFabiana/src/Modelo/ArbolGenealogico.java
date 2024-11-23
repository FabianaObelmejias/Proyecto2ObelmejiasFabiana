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

/**
 * Clase que representa un árbol genealógico.
 * 
 * Combina un árbol general ({@link ArbolGnral}) y una tabla hash ({@link HashTable})
 * para facilitar el almacenamiento y búsqueda de personas por diferentes criterios,
 * como nombre, título o generación.
 * 
 * También proporciona métodos para mostrar resultados, obtener generaciones, 
 * y explorar descendencia y antepasados de una persona.
 * 
 * @author obelm
 */
public class ArbolGenealogico {

    // Árbol general para organizar la jerarquía genealógica
    private ArbolGnral arbol;

    // Tabla hash para búsquedas rápidas de personas
    private HashTable hashTable;

    // Nombre del linaje representado por este árbol
    private String nombreLinaje;

    /**
     * Constructor que inicializa el árbol genealógico con un árbol general vacío
     * y una tabla hash con capacidad inicial de 100.
     */
    public ArbolGenealogico() {
        this.arbol = new ArbolGnral();
        this.hashTable = new HashTable(100);
    }

    // Getters y setters para los atributos principales

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

    /**
     * Busca personas en el árbol genealógico que coincidan con un nombre.
     * 
     * @param nombre el nombre a buscar
     * @return un arreglo de personas encontradas, o null si no hay resultados
     */
    public Persona[] buscarNombre(String nombre) {
        Lista resultados = hashTable.buscarNombre(nombre);
        if (!resultados.isEmpty()) {
            return convertirResultadosArreglo(resultados);
        }
        return null;
    }

    /**
     * Busca personas en el árbol genealógico que coincidan con un título.
     * 
     * @param titulo el título a buscar
     * @return un arreglo de personas encontradas, o null si no hay resultados
     */
    public Persona[] buscarTitulo(String titulo) {
        Lista resultados = hashTable.buscarTitulo(titulo);
        if (!resultados.isEmpty()) {
            return convertirResultadosArreglo(resultados);
        }
        return null;
    }

    /**
     * Convierte una lista de personas en un arreglo para facilitar su manejo.
     * 
     * @param resultados la lista de personas
     * @return un arreglo de objetos {@link Persona}
     */
    public Persona[] convertirResultadosArreglo(Lista resultados) {
        Persona[] resultadosArray = new Persona[resultados.getSize()];
        Nodo temp = resultados.getpFirst();
        int count = 0;

        while (temp != null) {
            Persona personaActual = (Persona) temp.getDato();
            resultadosArray[count] = personaActual;
            temp = temp.getpNext();
            count++;
        }

        return resultadosArray;
    }

    /**
     * Muestra los resultados de una búsqueda en formato de cadena.
     * 
     * @param resultado el arreglo de personas encontrado
     * @return una cadena con los resultados de la búsqueda
     */
    public String mostrarResultados(Persona[] resultado) {
        StringBuilder resultStr = new StringBuilder("Resultados de la Búsqueda:\n");
        for (int i = 0; i < resultado.length; i++) {
            resultStr.append(i).append(" ")
                     .append("Mote: ").append(resultado[i].getMote()).append(" ")
                     .append("Nombre: ").append(resultado[i].getNombreCompleto()).append(" ")
                     .append(resultado[i].getNumeral()).append("\n");
        }
        return resultStr.toString();
    }

    /**
     * Muestra los detalles de una persona específica buscándola en la tabla hash.
     * 
     * @param persona la persona de la que se quieren mostrar los detalles
     * @return una cadena con la información de la persona
     */
    public String detallesPersona(Persona persona) {
        String clave = persona.getMote() != null ? persona.getMote() : 
                       persona.getNombreCompleto() + " " + persona.getNumeral();
        return hashTable.buscar(clave).toString();
    }

    /**
     * Muestra todas las personas de una generación específica.
     * 
     * @param nivel el nivel de la generación (1 para la raíz, 2 para los hijos, etc.)
     * @return una cadena con los detalles de las personas en esa generación
     */
    public String mostrarGeneracion(int nivel) {
        Lista generacion = arbol.obtenerNodosEnNivel(nivel);
        StringBuilder generacionStr = new StringBuilder("Generación " + nivel + ":\n");
        String separacion = "==================================";

        Nodo temp = generacion.getpFirst();
        while (temp != null) {
            Persona personaActual = (Persona) temp.getDato();
            generacionStr.append(separacion).append("\n")
                         .append(personaActual.toString()).append("\n")
                         .append(separacion).append("\n");
            temp = temp.getpNext();
        }

        return generacionStr.toString();
    }

    /**
     * Genera una lista de opciones con las generaciones disponibles en el árbol.
     * 
     * @return una lista de cadenas representando cada generación
     */
    public Lista opcionesDeGeneracion() {
        Lista generaciones = new Lista();
        int max = arbol.maximoNivel();
        for (int i = 0; i < max; i++) {
            generaciones.insertarFinal("Generacion " + (i + 1));
        }
        return generaciones;
    }

    /**
     * Crea un subárbol de descendencia a partir de una persona seleccionada.
     * 
     * @param arreglo el arreglo de personas a buscar
     * @param index el índice de la persona seleccionada
     * @return un árbol general representando la descendencia, o null si el índice es inválido
     */
    public ArbolGnral descendencia(Persona[] arreglo, int index) {
        if (index >= 0 && index < arreglo.length) {
            String clave = arreglo[index].getMote() != null ? arreglo[index].getMote() : 
                           arreglo[index].getNombreCompleto() + " " + arreglo[index].getNumeral();

            NodoArbol raiz = arbol.buscarPorNombreClave(clave);
            ArbolGnral arbolDesc = new ArbolGnral();
            arbolDesc.setRaiz(raiz);
            return arbolDesc;
        }
        return null;
    }

    /**
     * Obtiene la lista de antepasados de una persona seleccionada.
     * 
     * @param arreglo el arreglo de personas a buscar
     * @param index el índice de la persona seleccionada
     * @return una lista de antepasados, o null si no se encuentra la persona
     */
    public Lista mostrarAntepasados(Persona[] arreglo, int index) {
        if (index >= 0 && index < arreglo.length) {
            String clave = arreglo[index].getMote() != null ? arreglo[index].getMote() : 
                           arreglo[index].getNombreCompleto() + " " + arreglo[index].getNumeral();

            NodoArbol raiz = arbol.buscarPorNombreClave(clave);
            if (raiz != null) {
                return arbol.listaAncestros(raiz);
            }
        }
        return null;
    }
    
    public Lista nombresPersonas(){
        Lista nombres = new Lista();
        for (int i = 0; i < this.hashTable.getCapacidad(); i++) {
            if(!this.hashTable.getTabla()[i].isEmpty()){
                for (int j = 0; j < this.hashTable.getTabla()[i].getSize(); j++) {
                    Persona personaActual = (Persona) this.hashTable.getTabla()[i].getValor(j);
                    nombres.insertarFinal(personaActual.nombreUnico());
                }
            }
        }
        
        return nombres;
    }
}
