/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Interfaces.Iniciar;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author obelm
 */
public class FileChooser {
    public String abrirArchivo(JFrame ventana){
        JFileChooser fc = new JFileChooser();

        //se crea el filtro para archivos .json
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");

        //se indica el filtro
        fc.setFileFilter(filtro);

        // abro la ventana mientras guardamos la opción seleccionada por el usuario
        int seleccion = fc.showOpenDialog(ventana);

        //en caso de que el usuario acepte
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            //escojo el fichero
            File fichero = fc.getSelectedFile();
            return fichero.getAbsolutePath();

        } else {
            //en caso de que el usuario no seleccione ningun archivo
            JOptionPane.showMessageDialog(ventana, "No se ha seleccionado ningún archivo.");
            return null;
    }
}

    public String abrirArchivo(Iniciar aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
