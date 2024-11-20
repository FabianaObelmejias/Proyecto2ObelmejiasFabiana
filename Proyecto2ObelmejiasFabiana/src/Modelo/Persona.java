/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author obelm
 */
public class Persona {
    //primero verifico que tipo de datos tengo en el Json
    private String nombreCompleto;
    private String numeral;
    private String padre;
    private String madre;
    private String mote;
    private String titulo;
    private String esposa;
    private String colorOjos;
    private String colorCabello;
    private String comentariosVida;
    private String comentariosMuerte;

    public Persona(String nombreCompleto, String numeral, String padre, String madre, String mote, String titulo, String esposa, String colorOjos, String colorCabello, String comentariosVida, String comentariosMuerte) {
        this.nombreCompleto = nombreCompleto;
        this.numeral = numeral;
        this.padre = padre;
        this.madre = madre;
        this.mote = mote;
        this.titulo = titulo;
        this.esposa = esposa;
        this.colorOjos = colorOjos;
        this.colorCabello = colorCabello;
        this.comentariosVida = comentariosVida;
        this.comentariosMuerte = comentariosMuerte;
    }

    public Persona(String nombreCompleto, String numeral, String padre, String titulo){
        this.nombreCompleto = nombreCompleto;
        this.numeral = numeral;
        this.padre = padre;
        this.titulo = titulo;
    }
    public String getComentariosMuerte() {
        return comentariosMuerte;
    }

    public void setComentariosMuerte(String comentariosMuerte) {
        this.comentariosMuerte = comentariosMuerte;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeral() {
        return numeral;
    }

    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getMadre() {
        return madre;
    }

    public void setMadre(String madre) {
        this.madre = madre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEsposa() {
        return esposa;
    }

    public void setEsposa(String esposa) {
        this.esposa = esposa;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public String getColorCabello() {
        return colorCabello;
    }

    public void setColorCabello(String colorCabello) {
        this.colorCabello = colorCabello;
    }

    public String getComentariosVida() {
        return comentariosVida;
    }

    public void setComentariosVida(String comentariosVida) {
        this.comentariosVida = comentariosVida;
    }
    
    public String nombreUnico(){
        return this.nombreCompleto + " " + this.numeral;
    }
    
    //es necesario retornar el toString, me sirve para todo lo que tenga que mostrar
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Información Completa: ");
        sb.append("\nNombreCompleto: ").append(this.nombreUnico());
        sb.append("\nPadre: ").append(padre);
        sb.append("\nMadre: ").append(madre);
        sb.append("\nMote: ").append(mote);
        sb.append("\nTitulo: ").append(titulo);
        sb.append("\nEsposa: ").append(esposa);
        sb.append("\nColor de Ojos: ").append(colorOjos);
        sb.append("\nColor de Cabello: ").append(colorCabello);
        sb.append("\nComentarios de su Vida: ").append(comentariosVida);
        sb.append("\nComentarios de su Muerte: ").append(comentariosMuerte);
        return sb.toString();
    }
    
    
    
}
