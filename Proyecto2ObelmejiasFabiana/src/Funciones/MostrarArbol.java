/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.ArbolGnral;
import EDD.NodoArbol;
import Interfaces.Menu;
import Modelo.Persona;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;


/**
 * Clase que permite visualizar un árbol genealógico utilizando la biblioteca GraphStream.
 * 
 * Proporciona una interfaz gráfica basada en {@link JFrame} para mostrar nodos y conexiones
 * del árbol genealógico, con opciones de interacción como ver información de nodos y regresar
 * al menú principal.
 * 
 * @author 
 */
public class MostrarArbol extends JFrame {
    // Árbol genealógico a visualizar
    private ArbolGnral arbol;

    // Visualizador y panel de visualización del árbol
    private Viewer visor;
    private ViewPanel panelVista;

    /**
     * Constructor de la clase.
     * Configura la interfaz, inicializa el visor y agrega los controles necesarios.
     * 
     * @param arbol el árbol genealógico a visualizar
     */
    public MostrarArbol(ArbolGnral arbol) {
        this.arbol = arbol;
        configurarInterfaz();
        inicializarVisor();
        agregarBotonRegresar();
    }

    /**
     * Configura las propiedades principales de la ventana.
     */
    private void configurarInterfaz() {
        setTitle("Visualizador de Árbol");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    /**
     * Inicializa el visor para mostrar el árbol utilizando GraphStream.
     */
    private void inicializarVisor() {
        // Crear un grafo para representar el árbol
        Graph arbolVisual = new SingleGraph("Árbol");
        construirArbol(arbolVisual);

        // Mostrar el grafo en la misma ventana
        visor = arbolVisual.display(false);
        visor.enableAutoLayout(); // Activar el ajuste automático de nodos

        // Crear el panel de visualización si no existe ya
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();
            add(panelVista, BorderLayout.CENTER);
        }
    }

    /**
     * Construye el grafo que representa el árbol genealógico.
     * 
     * @param arbolVisual el grafo donde se construirá el árbol
     */
    private void construirArbol(Graph arbolVisual) {
        if (arbol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío.");
            return;
        }

        // Añadir nodos y relaciones desde la raíz
        agregarNodoYSubarbol(arbol.getRaiz(), null, arbolVisual);

        // Configurar estilos para nodos y aristas
        arbolVisual.setAttribute("ui.stylesheet",
                "node { text-size: 14px; size: 30px; text-alignment: center; fill-color: yellow; }"
                        + "edge { size: 2px; }");
    }

    /**
     * Agrega un nodo y sus subárboles al grafo recursivamente.
     * 
     * @param nodoActual el nodo actual del árbol
     * @param padreId el identificador del nodo padre
     * @param arbolVisual el grafo donde se agregará el nodo
     */
    private void agregarNodoYSubarbol(NodoArbol nodoActual, String padreId, Graph arbolVisual) {
        Persona persona = (Persona) nodoActual.getDato();
        String nodoId = persona.nombreUnico();

        // Verificar si el nodo ya existe en el grafo
        if (arbolVisual.getNode(nodoId) == null) {
            org.graphstream.graph.Node nodoVisual = arbolVisual.addNode(nodoId);
            nodoVisual.setAttribute("ui.label", persona.nombreUnico());
            nodoVisual.setAttribute("persona", persona); // Guardar información de la persona en el nodo
        }

        // Conectar el nodo con su padre si existe
        if (padreId != null && arbolVisual.getEdge(padreId + "-" + nodoId) == null) {
            arbolVisual.addEdge(padreId + "-" + nodoId, padreId, nodoId);
        }

        // Recorrer y agregar los hijos del nodo actual
        for (int i = 0; i < nodoActual.getHijos().getSize(); i++) {
            NodoArbol hijo = (NodoArbol) nodoActual.getHijos().getValor(i);
            agregarNodoYSubarbol(hijo, nodoId, arbolVisual);
        }
    }

    /**
     * Muestra un cuadro de diálogo con información de una persona específica.
     * 
     * @param persona la persona de la que se mostrará la información
     */
    private void mostrarInfoPersona(Persona persona) {
        String info = "Información de la Persona:\n"
                + "Nombre: " + persona.getNombreCompleto() + "\n"
                + "Padre: " + persona.getPadre() + "\n"
                + "Madre: " + persona.getMadre();
        JOptionPane.showMessageDialog(this, info, "Detalles de Persona", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Agrega un botón para regresar al menú principal.
     */
    private void agregarBotonRegresar() {
        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.addActionListener(e -> {
            cerrarVisor();
            dispose();
            abrirMenu();
        });
        add(botonRegresar, BorderLayout.SOUTH);
    }

    /**
     * Cierra el visor y limpia el panel de visualización.
     */
    private void cerrarVisor() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panelVista != null) {
            remove(panelVista);
            panelVista = null;
        }
    }

    /**
     * Regresa al menú principal abriendo la ventana correspondiente.
     */
    private void abrirMenu() {
        Menu menuPrincipal = new Menu();
        menuPrincipal.setVisible(true); // Mostrar el menú principal
    }
}