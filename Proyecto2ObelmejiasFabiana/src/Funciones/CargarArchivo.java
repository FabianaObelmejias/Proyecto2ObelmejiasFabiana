/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.NodoArbol;
import Modelo.ArbolGenealogico;
import Modelo.Persona;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;


/**
 * Clase encargada de cargar un archivo JSON con información genealógica y
 * convertirla en una estructura de datos representada por un {@link ArbolGenealogico}.
 * 
 * Maneja errores relacionados con nombres repetidos o datos incompletos, y
 * utiliza una tabla hash y un árbol general para almacenar la información.
 * 
 * @author obelm
 */
public class CargarArchivo {

    // Árbol genealógico construido a partir del archivo
    private ArbolGenealogico arbolGenealogico;

    // Contador de errores durante el procesamiento del archivo
    private int errores = 0;

    // Contador de nombres repetidos detectados durante la carga
    private int nombreRepetido = 0;

    /**
     * Constructor por defecto.
     * Inicializa un árbol genealógico vacío.
     */
    public CargarArchivo() {
        this.arbolGenealogico = new ArbolGenealogico();
    }

    // Getters y setters para los atributos principales

    public ArbolGenealogico getArbolGenealogico() {
        return arbolGenealogico;
    }

    public void setArbolGenealogico(ArbolGenealogico arbolGenealogico) {
        this.arbolGenealogico = arbolGenealogico;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public int getNombreRepetido() {
        return nombreRepetido;
    }

    public void setNombreRepetido(int nombreRepetido) {
        this.nombreRepetido = nombreRepetido;
    }

    /**
     * Carga un archivo JSON desde la ruta especificada y lo convierte en un árbol genealógico.
     * 
     * @param rutaArchivo la ruta al archivo JSON
     */
    public void cargar(String rutaArchivo) {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Gson gson = new Gson();
            JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);

            // Primera pasada: cargar datos en la tabla hash
            for (String nombreCasa : jsonObj.keySet()) {
                JsonArray miembros = jsonObj.getAsJsonArray(nombreCasa);
                arbolGenealogico.setNombreLinaje(nombreCasa);
                for (JsonElement miembro : miembros) {
                    JsonObject personaObj = miembro.getAsJsonObject();
                    this.agregarHashTable(personaObj);
                }
            }

            // Segunda pasada: construir el árbol genealógico
            for (String nombreCasa : jsonObj.keySet()) {
                JsonArray miembros = jsonObj.getAsJsonArray(nombreCasa);
                for (JsonElement miembro : miembros) {
                    JsonObject personaObj = miembro.getAsJsonObject();
                    this.agregarArbol(personaObj);
                }
            }

            // Si hubo errores o nombres repetidos, invalidar el árbol genealógico
            if (errores != 0 || nombreRepetido != 0) {
                this.arbolGenealogico = null;
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Agrega una persona al árbol genealógico basado en su información.
     * 
     * @param personaObj objeto JSON que representa a la persona
     */
    private void agregarArbol(JsonObject personaObj) {
        String nombreCompleto = personaObj.keySet().iterator().next();
        JsonArray atributos = personaObj.getAsJsonArray(nombreCompleto);

        Persona personaNueva = crearPersona(nombreCompleto, atributos);

        if (personaNueva.getPadre().equalsIgnoreCase("[Unknown]")) {
            // Si no tiene padre conocido, se establece como la raíz del árbol
            this.arbolGenealogico.getArbol().crearRaiz(personaNueva);
        } else {
            // Manejar el caso de nombres ambiguos "of his name"
            if (personaNueva.getPadre().contains("of his name")) {
                personaNueva.setPadre(personaNueva.getPadre().replaceAll("of his name", "").replaceAll(",", "").trim());
            }

            // Buscar al padre en el árbol y agregar como hijo
            NodoArbol padre = this.arbolGenealogico.getArbol().buscarPorNombreClave(personaNueva.getPadre());
            if (padre != null) {
                if (this.arbolGenealogico.getArbol().agregarHijo(padre, personaNueva) == null) {
                    nombreRepetido++;
                }
            } else {
                errores++;
            }
        }
    }

    /**
     * Agrega una persona a la tabla hash basada en su información.
     * 
     * @param personaObj objeto JSON que representa a la persona
     */
    private void agregarHashTable(JsonObject personaObj) {
        String nombreCompleto = personaObj.keySet().iterator().next();
        JsonArray atributos = personaObj.getAsJsonArray(nombreCompleto);

        Persona personaNueva = crearPersona(nombreCompleto, atributos);

        String clave = personaNueva.getMote() != null ? personaNueva.getMote() : 
                       personaNueva.getNombreCompleto() + " " + personaNueva.getNumeral();
        this.arbolGenealogico.getHashTable().insertar(clave, personaNueva);
    }

    /**
     * Crea un objeto {@link Persona} a partir de un nombre completo y un conjunto de atributos.
     * 
     * @param nombreCompleto el nombre completo de la persona
     * @param atributos un arreglo JSON con los atributos de la persona
     * @return un objeto {@link Persona} con los datos proporcionados
     */
    private Persona crearPersona(String nombreCompleto, JsonArray atributos) {
        String numeral = null;
        String padre = null;
        String madre = null;
        String mote = null;
        String titulo = null;
        String esposa = null;
        String colorOjos = null;
        String colorCabello = null;
        String comentariosVida = null;
        String comentariosMuerte = null;

        // Procesar cada atributo de la persona
        for (JsonElement atributoElem : atributos) {
            JsonObject atributo = atributoElem.getAsJsonObject();

            if (atributo.has("Of his name")) {
                numeral = atributo.get("Of his name").getAsString();
            } else if (atributo.has("Born to")) {
                String parent = atributo.get("Born to").getAsString();
                if (padre == null) {
                    padre = parent;
                } else {
                    madre = parent;
                }
            } else if (atributo.has("Known throughout as")) {
                mote = atributo.get("Known throughout as").getAsString();
            } else if (atributo.has("Held title")) {
                titulo = atributo.get("Held title").getAsString();
            } else if (atributo.has("Wed to")) {
                esposa = atributo.get("Wed to").getAsString();
            } else if (atributo.has("Of eyes")) {
                colorOjos = atributo.get("Of eyes").getAsString();
            } else if (atributo.has("of hair")) {
                colorCabello = atributo.get("of hair").getAsString();
            } else if (atributo.has("Notes")) {
                comentariosVida = atributo.get("Notes").getAsString();
            } else if (atributo.has("Fate")) {
                comentariosMuerte = atributo.get("Fate").getAsString();
            }
        }

        return new Persona(nombreCompleto, numeral, padre, madre, mote, titulo, esposa, colorOjos, colorCabello, comentariosVida, comentariosMuerte);
    }
}
