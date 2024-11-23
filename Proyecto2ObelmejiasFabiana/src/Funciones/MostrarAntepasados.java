/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Funciones;

import EDD.Lista;
import EDD.Nodo;
import Interfaces.Menu;
import Modelo.Persona;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
/**
 * Clase que visualiza una lista de antepasados en un grafo utilizando la biblioteca GraphStream.
 * 
 * Proporciona una interfaz gráfica basada en {@link JFrame}, donde cada antepasado es representado
 * como un nodo, y las conexiones parentales se representan como aristas.
 * 
 * Permite cerrar la ventana y regresar al menú principal.
 * 
 * @author obelm
 */
public class MostrarAntepasados extends JFrame {
    // Lista de antepasados a visualizar
    private Lista antepasados;

    // Visualizador y panel para mostrar el grafo
    private Viewer visor;
    private ViewPanel panelVista;

    /**
     * Constructor que inicializa la ventana y configura el grafo para mostrar los antepasados.
     * 
     * @param antepasados lista de antepasados a visualizar
     */
    public MostrarAntepasados(Lista antepasados) {
        this.antepasados = antepasados;
        configurarInterfaz();
        inicializarVisor();
        agregarBotonCerrar();
    }

    /**
     * Configura las propiedades principales de la ventana.
     */
    private void configurarInterfaz() {
        setTitle("Visualizador de Antepasados");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    /**
     * Inicializa el visor utilizando GraphStream para construir y mostrar el grafo.
     */
    private void inicializarVisor() {
        Graph grafo = new MultiGraph("Antepasados");
        construirGrafo(grafo);

        // Mostrar el grafo dentro de la ventana
        visor = grafo.display(false);
        visor.enableAutoLayout(); // Activar el ajuste automático de nodos

        // Crear el panel de visualización si no existe ya
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();
            add(panelVista, BorderLayout.CENTER);
        }
    }

    /**
     * Construye el grafo que representa los antepasados, basado en la lista proporcionada.
     * 
     * @param grafo el grafo donde se añadirán los nodos y las aristas
     */
    private void construirGrafo(Graph grafo) {
        if (antepasados == null || antepasados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay antepasados para mostrar.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Nodo aux = antepasados.getpFirst(); // Nodo inicial de la lista de antepasados
        Node nodoAnterior = null;

        while (aux != null) {
            Persona persona = (Persona) aux.getDato();
            String id = persona.nombreUnico();

            // Crear nodo si no existe
            Node nodoActual = grafo.addNode(id);
            nodoActual.setAttribute("ui.label", persona.nombreUnico());
            nodoActual.setAttribute("ui.style", "fill-color: yellow; size: 25px; text-alignment: center;");

            // Conectar con el nodo anterior, si existe
            if (nodoAnterior != null) {
                String edgeId = nodoAnterior.getId() + "-" + nodoActual.getId();
                grafo.addEdge(edgeId, nodoAnterior.getId(), nodoActual.getId());
            }

            // Pasar al siguiente nodo en la lista
            nodoAnterior = nodoActual;
            aux = aux.getpNext();
        }

        // Aplicar estilos generales al grafo
        grafo.setAttribute("ui.stylesheet",
                "node { text-size: 16px; }" +
                        "edge { size: 2px; }");
    }

    /**
     * Agrega un botón para cerrar la ventana y regresar al menú principal.
     */
    private void agregarBotonCerrar() {
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> cerrarVentana());
        add(botonCerrar, BorderLayout.SOUTH);
    }

    /**
     * Cierra la ventana, detiene el visor y regresa al menú principal.
     */
    private void cerrarVentana() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panelVista != null) {
            remove(panelVista);
            panelVista = null;
        }
        dispose(); // Cierra la ventana actual
        Menu menu = new Menu(); // Abre el menú principal
        menu.setVisible(true);
    }
}