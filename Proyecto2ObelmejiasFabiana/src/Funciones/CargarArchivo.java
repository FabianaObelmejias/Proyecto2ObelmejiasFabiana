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


public class CargarArchivo {

    private ArbolGenealogico arbolGenealogico;
    private int errores = 0;
    private int nombreRepetido = 0;

    public CargarArchivo() {
        this.arbolGenealogico = new ArbolGenealogico();
    }

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
    
    public void cargar(String rutaArchivo) {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Gson gson = new Gson();
            JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);
            
            for (String nombreCasa : jsonObj.keySet()) {
                JsonArray miembros = jsonObj.getAsJsonArray(nombreCasa);
                arbolGenealogico.setNombreLinaje(nombreCasa);
                for (JsonElement miembro : miembros) {
                    JsonObject personaObj = miembro.getAsJsonObject();
                    this.agregarHashTable(personaObj);
                }
            }
            
            
            for (String nombreCasa : jsonObj.keySet()) {
                JsonArray miembros = jsonObj.getAsJsonArray(nombreCasa);
                for (JsonElement miembro : miembros) {
                    JsonObject personaObj = miembro.getAsJsonObject();
                    this.agregarArbol(personaObj);
                }
            }
            
            if(errores != 0 || nombreRepetido!= 0){
                this.arbolGenealogico = null;
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    private void agregarArbol(JsonObject personaObj){
        String nombreCompleto = personaObj.keySet().iterator().next();
        JsonArray atributos = personaObj.getAsJsonArray(nombreCompleto);

        Persona personaNueva = crearPersona(nombreCompleto, atributos);
        
        
        if (personaNueva.getPadre().equalsIgnoreCase("[Unknown]")){
           this.arbolGenealogico.getArbol().crearRaiz(personaNueva);
        }else{
            if(personaNueva.getPadre().contains("of his name")){
                personaNueva.setPadre(personaNueva.getPadre().replaceAll("of his name", "").replaceAll(",", "").trim());
                
                NodoArbol padre = this.arbolGenealogico.getArbol().buscarPorNombreClave(personaNueva.getPadre());
                if(padre != null){
                    if(this.arbolGenealogico.getArbol().agregarHijo(padre, personaNueva) == null){
                        nombreRepetido++;
                    }
                }else{
                   errores++; 
                }
            }else{
                NodoArbol padre = this.arbolGenealogico.getArbol().buscarPorNombreClave(personaNueva.getPadre());
                if(padre != null){
                    if(this.arbolGenealogico.getArbol().agregarHijo(padre, personaNueva) == null){
                        nombreRepetido++;
                    }
                }else{
                    errores++;
                }
            }
        }
    }

    private void agregarHashTable(JsonObject personaObj) {
        String nombreCompleto = personaObj.keySet().iterator().next();
        JsonArray atributos = personaObj.getAsJsonArray(nombreCompleto);

        Persona personaNueva = crearPersona(nombreCompleto, atributos);
        
        if(personaNueva.getMote() != null){
            String clave = personaNueva.getMote();
            this.arbolGenealogico.getHashTable().insertar(clave, personaNueva);
        }else{
            String clave = personaNueva.getNombreCompleto() +" "+ personaNueva.getNumeral();
            this.arbolGenealogico.getHashTable().insertar(clave, personaNueva);
        }
    }

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
        
        for (JsonElement atributoElem : atributos) {
            JsonObject atributo = atributoElem.getAsJsonObject();
            if(atributo.has("Of his name")){
                numeral = atributo.get("Of his name").getAsString();
            }else if(atributo.has("Born to")){
                String parent = atributo.get("Born to").getAsString();
                if(padre == null){
                    padre = parent;
                }else{
                    madre = parent;
                }
            }else if(atributo.has("Known throughout as")){
               mote = atributo.get("Known throughout as").getAsString();
            }else if(atributo.has("Held title")){
                titulo = atributo.get("Held title").getAsString();
            }else if(atributo.has("Wed to")){
                esposa = atributo.get("Wed to").getAsString();
            }else if(atributo.has("Of eyes")){
                 colorOjos = atributo.get("Of eyes").getAsString();
            }else if(atributo.has("of hair")){
                colorCabello = atributo.get("of hair").getAsString();
            }else if(atributo.has("of hair")){
                colorCabello = atributo.get("of hair").getAsString();
            }else if(atributo.has("of hair")){
                colorCabello = atributo.get("of hair").getAsString();
            }else if(atributo.has("Notes")){
                comentariosVida = atributo.get("Notes").getAsString();
            }else if(atributo.has("Fate")){
                comentariosMuerte = atributo.get("Fate").getAsString();
            }
        }
        return new Persona(nombreCompleto, numeral, padre, madre, mote, titulo, esposa, colorOjos, colorCabello, comentariosVida, comentariosMuerte);
    }
}
