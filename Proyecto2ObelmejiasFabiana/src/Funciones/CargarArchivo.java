/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Modelo.ArbolGenealogico;
import Modelo.Persona;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author obelm
 */
public class CargarArchivo {
    private ArbolGenealogico arbolGenealogico;

    public CargarArchivo(ArbolGenealogico arbolGenealogico){
        this.arbolGenealogico = arbolGenealogico;
    }

    public ArbolGenealogico getArbolGenealogico() {
        return arbolGenealogico;
    }

    public void setArbolGenealogico(ArbolGenealogico arbolGenealogico) {
        this.arbolGenealogico = arbolGenealogico;
    }

    public void cargar(String rutaArchivo) {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            Gson gson = new Gson();
            JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);//con esto puedo iterar sobre el Json
            
            for (String nombreCasa : jsonObj.keySet()) {
                JsonArray miembros = jsonObj.getAsJsonArray(nombreCasa); //ya que tengo todos los values, puedo iterar sobre cada uno de los miembros
                for (JsonElement miembro : miembros) {
                    JsonObject personaObj = miembro.getAsJsonObject();
                    this.agregarHashTable(personaObj);

                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    private void agregarHashTable(JsonObject personaObj) {
        String nombreCompleto = personaObj.keySet().iterator().next();
        JsonArray atributos = personaObj.getAsJsonArray(nombreCompleto);

        Persona personaNueva = crearPersona(nombreCompleto, atributos);
            String clave = personaNueva.getNombreCompleto() +" "+ personaNueva.getNumeral();
            this.arbolGenealogico.getHashtable().insertar(clave, personaNueva);
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
        
        //le debo pasar el atributo
        for (JsonElement atributoElem : atributos) {//ahora estoy iterando dentro de atributos
            //¿qué voy a hacer dentro del iterador?
            JsonObject atributo = atributoElem.getAsJsonObject();
            if(atributo.has("Of his name")){ //de aqui en adelante debo hacer o mismo con todos
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

