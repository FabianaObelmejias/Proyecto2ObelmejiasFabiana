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
 *
 * @author obelm
 */
public class MostrarAntepasados extends JFrame{
    private Lista antepasados;
    private Viewer visor;
    private ViewPanel panelVista;

    public MostrarAntepasados(Lista antepasados) {
        this.antepasados = antepasados;
        configurarInterfaz();
        inicializarVisor();
        agregarBotonCerrar();
    }

    private void configurarInterfaz() {
        setTitle("Visualizador de Antepasados");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
    }

    private void inicializarVisor() {
        Graph grafo = new MultiGraph("Antepasados");
        construirGrafo(grafo);

        // Mostrar el grafo sin crear una nueva ventana
        visor = grafo.display(false);
        visor.enableAutoLayout();

        // Crear el panel de visualización
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();
            add(panelVista, BorderLayout.CENTER);
        }
    }

    private void construirGrafo(Graph grafo) {
        if (antepasados == null || antepasados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay antepasados para mostrar.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Crear los nodos y arcos basados en la lista de antepasados
        Nodo aux = antepasados.getpFirst();
        Node nodoAnterior = null;

        while (aux != null) {
            Persona persona = (Persona) aux.getDato();
            String id = persona.nombreUnico();

            // Crear nodo si no existe
            Node nodoActual = grafo.addNode(id);
            nodoActual.setAttribute("ui.label", persona.nombreUnico());
            nodoActual.setAttribute("ui.style", "fill-color: yellow; size: 25px; text-alignment: center;");

            // Conectar con el nodo anterior
            if (nodoAnterior != null) {
                String edgeId = nodoAnterior.getId() + "-" + nodoActual.getId();
                grafo.addEdge(edgeId, nodoAnterior.getId(), nodoActual.getId());
            }

            // Pasar al siguiente nodo
            nodoAnterior = nodoActual;
            aux = aux.getpNext();
        }

        // Estilos del grafo
        grafo.setAttribute("ui.stylesheet",
                "node { text-size: 16px; }" +
                "edge { size: 2px; }");
    }

    private void agregarBotonCerrar() {
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> cerrarVentana());
        add(botonCerrar, BorderLayout.SOUTH);
    }

    private void cerrarVentana() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panelVista != null) {
            remove(panelVista);
            panelVista = null;
        }
        Menu menu = new Menu();
        dispose();
    }

}


