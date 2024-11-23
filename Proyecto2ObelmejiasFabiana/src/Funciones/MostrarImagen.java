/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Interfaces.Menu;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Clase que muestra una imagen en una ventana y proporciona un botón para
 * regresar al menú principal. Extiende {@link JFrame}.
 *
 * La imagen se escala automáticamente para ajustarse al tamaño del panel.
 * Incluye un botón en la parte inferior para regresar al menú principal.
 *
 * @author obelm
 */
public class MostrarImagen extends JFrame {

    private JLabel labelImagen;
    private JButton botonRegresar;

    /**
     * Constructor que configura la ventana y carga la imagen especificada.
     *
     * @param rutaImagen la ruta de la imagen a mostrar
     */
    public MostrarImagen(String rutaImagen) {
        configurarInterfaz();
        cargarImagen(rutaImagen);
        agregarBotonRegresar();
    }

    /**
     * Configura las propiedades básicas de la ventana.
     */
    private void configurarInterfaz() {
        setTitle("Mostrar Imagen");
        setSize(2000, 1500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    /**
     * Carga una imagen de gran tamaño desde el paquete "Imagenes" y la muestra
     * escalada para ajustarse al tamaño del JFrame.
     *
     * @param nombreImagen el nombre del archivo de la imagen (por ejemplo,
     * "DiagramaFabi.jpg").
     */
    private void cargarImagen(String nombreImagen) {
        labelImagen = new JLabel();
        labelImagen.setHorizontalAlignment(JLabel.CENTER);
        labelImagen.setVerticalAlignment(JLabel.CENTER);

        // Cargar la imagen desde el paquete "Imagenes"
        ImageIcon imagenOriginal = new ImageIcon(getClass().getResource("/Imagenes/" + nombreImagen));

        // Obtener las dimensiones originales de la imagen
        int anchoOriginal = imagenOriginal.getIconWidth();
        int altoOriginal = imagenOriginal.getIconHeight();

        // Configurar el tamaño de la ventana en función del tamaño de la imagen
        int anchoVentana = Math.min(anchoOriginal, 800); // Limitar ancho máximo
        int altoVentana = Math.min(altoOriginal, 600);  // Limitar alto máximo

        setSize(anchoVentana, altoVentana + 50); // Ajustar ventana, +50 para el botón

        // Escalar la imagen para ajustarse al JFrame
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(
                anchoVentana, altoVentana - 50, Image.SCALE_SMOOTH); // Restar espacio para el botón
        ImageIcon imagenFinal = new ImageIcon(imagenEscalada);

        labelImagen.setIcon(imagenFinal);
        add(labelImagen, BorderLayout.CENTER);
    }

    /**
     * Agrega un botón para regresar al menú principal.
     */
    private void agregarBotonRegresar() {
        botonRegresar = new JButton("Regresar al Menú");
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarAlMenu();
            }
        });
        add(botonRegresar, BorderLayout.SOUTH);
    }

    /**
     * Cierra esta ventana y regresa al menú principal.
     */
    private void regresarAlMenu() {
        dispose(); // Cerrar la ventana actual
        Menu menuPrincipal = new Menu();
        menuPrincipal.setVisible(true); // Mostrar el menú principal
    }

}
