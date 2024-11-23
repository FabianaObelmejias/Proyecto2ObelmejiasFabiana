/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * Clase que proporciona un método para abrir un cuadro de diálogo de selección de archivos.
 * 
 * Permite al usuario elegir un archivo con una extensión específica, como JSON,
 * y retorna la ruta del archivo seleccionado.
 * 
 * @author 
 */
public class FileChooser {

    /**
     * Abre un cuadro de diálogo para seleccionar un archivo JSON desde el sistema de archivos.
     * 
     * @param ventana la ventana principal desde donde se abre el cuadro de diálogo
     * @return la ruta absoluta del archivo seleccionado, o null si no se selecciona ningún archivo
     */
    public String abrirArchivo(JFrame ventana) {
        // Crear un selector de archivos
        JFileChooser fc = new JFileChooser();

        // Crear un filtro para mostrar solo archivos con extensión .json
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");

        // Asignar el filtro al selector de archivos
        fc.setFileFilter(filtro);

        // Mostrar el cuadro de diálogo de apertura y guardar la selección del usuario
        int seleccion = fc.showOpenDialog(ventana);

        // Si el usuario presiona "Aceptar"
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File fichero = fc.getSelectedFile();
            return fichero.getAbsolutePath(); // Retornar la ruta absoluta del archivo
        } else {
            // Si el usuario no selecciona ningún archivo, mostrar un mensaje
            JOptionPane.showMessageDialog(ventana, "No se ha seleccionado ningún archivo.");
            return null; // Retornar null en caso de no seleccionar archivo
        }
    }
}