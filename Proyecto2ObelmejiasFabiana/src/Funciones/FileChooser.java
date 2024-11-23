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


public class FileChooser {
    
    public String abrirArchivo(JFrame ventana){
        JFileChooser fc = new JFileChooser();

        // Creo el filtro para archivos .json
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");

        // Le indico el filtro
        fc.setFileFilter(filtro);

        // Abrimos la ventana, guardamos la opción seleccionada por el usuario
        int seleccion = fc.showOpenDialog(ventana);

        // Si el usuario presiona aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            // Selecciono el fichero
            File fichero = fc.getSelectedFile();
            return fichero.getAbsolutePath();

        } else {
            // Si el usuario no seleccionó ningún archivo, muestra un mensaje
            JOptionPane.showMessageDialog(ventana, "No se ha seleccionado ningún archivo.");
            return null;
        }
    }
}
