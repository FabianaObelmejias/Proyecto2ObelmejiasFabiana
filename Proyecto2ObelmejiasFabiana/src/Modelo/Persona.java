/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Clase que representa a una persona con diversos atributos, como su nombre completo, parentesco, 
 * características físicas, y comentarios sobre su vida y muerte.
 * Es útil para almacenar y gestionar información personal detallada.
 * 
 * @author obelm
 */
public class Persona {

    // Nombre completo de la persona
    private String nombreCompleto;

    // Numeral asociado al nombre
    private String numeral;

    // Nombre del padre de la persona
    private String padre;

    // Nombre de la madre de la persona
    private String madre;

    // Mote o apodo de la persona
    private String mote;

    // Título asociado a la persona 
    private String titulo;

    // Nombre de la esposa de la persona, si aplica
    private String esposa;

    // Color de ojos de la persona
    private String coloarOjos;

    // Color de cabello de la persona
    private String colorCabello;

    // Comentarios generales sobre la vida de la persona
    private String comentariosVida;

    // Comentarios sobre la muerte de la persona
    private String comentariosMuerte;

    /**
     * Constructor que inicializa todos los atributos de la persona.
     * 
     * @param nombreCompleto el nombre completo de la persona
     * @param numeral el numeral asociado al nombre
     * @param padre el nombre del padre
     * @param madre el nombre de la madre
     * @param mote el mote o apodo
     * @param titulo el título de la persona
     * @param esposa el nombre de la esposa
     * @param coloarOjos el color de los ojos
     * @param colorCabello el color del cabello
     * @param comentariosVida comentarios sobre la vida de la persona
     * @param comentariosMuerte comentarios sobre la muerte de la persona
     */
    public Persona(String nombreCompleto, String numeral, String padre, String madre, String mote, 
                   String titulo, String esposa, String coloarOjos, String colorCabello, 
                   String comentariosVida, String comentariosMuerte) {
        this.nombreCompleto = nombreCompleto;
        this.numeral = numeral;
        this.padre = padre;
        this.madre = madre;
        this.mote = mote;
        this.titulo = titulo;
        this.esposa = esposa;
        this.coloarOjos = coloarOjos;
        this.colorCabello = colorCabello;
        this.comentariosVida = comentariosVida;
        this.comentariosMuerte = comentariosMuerte;
    }

    // Getters y setters para cada atributo. Permiten acceder y modificar los datos.

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

    public String getColoarOjos() {
        return coloarOjos;
    }

    public void setColoarOjos(String coloarOjos) {
        this.coloarOjos = coloarOjos;
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

    /**
     * Método que genera un nombre único para la persona.
     * Si la persona tiene un mote, se utiliza este como nombre único. 
     * Si no, se combina su nombre completo y numeral.
     * 
     * @return el nombre único de la persona
     */
    public String nombreUnico() {
        if (this.getMote() != null) {
            return this.getMote();
        }
        return this.nombreCompleto + " " + this.numeral;
    }

    /**
     * Método que genera una representación en texto de la información completa de la persona.
     * 
     * @return un string con todos los datos de la persona
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Información Completa:");
        sb.append("\nNombre Completo: ").append(this.nombreUnico());
        sb.append("\nPadre: ").append(padre);
        sb.append("\nMadre: ").append(madre);
        sb.append("\nMote: ").append(mote);
        sb.append("\nTítulo: ").append(titulo);
        sb.append("\nEsposa: ").append(esposa);
        sb.append("\nColor de Ojos: ").append(coloarOjos);
        sb.append("\nColor de Cabello: ").append(colorCabello);
        sb.append("\nComentarios de su Vida: ").append(comentariosVida);
        sb.append("\nComentarios de su Muerte: ").append(comentariosMuerte);
        return sb.toString();
    }
}

