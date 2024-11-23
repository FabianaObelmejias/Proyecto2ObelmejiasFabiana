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


public class MostrarArbol extends JFrame{
    private ArbolGnral arbol;
    private Viewer visor;
    private ViewPanel panelVista;

    public MostrarArbol(ArbolGnral arbol) {
        this.arbol = arbol;
        configurarInterfaz();
        inicializarVisor();
        agregarBotonRegresar();
    }

    private void configurarInterfaz() {
        setTitle("Visualizador de Árbol");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
    }

    private void inicializarVisor() {
        Graph arbolVisual = new SingleGraph("Árbol");
        construirArbol(arbolVisual);

        // Mostrar el árbol sin crear una nueva ventana
        visor = arbolVisual.display(false);
        visor.enableAutoLayout();

        // Crear el panel de visualización si no existe ya
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();
            add(panelVista, BorderLayout.CENTER);
        }

       
    }

    private void construirArbol(Graph arbolVisual) {
        if (arbol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío.");
            return;
        }

        // Añadir nodos al grafo
        agregarNodoYSubarbol(arbol.getRaiz(), null, arbolVisual);

        // Estilo general del árbol
        arbolVisual.setAttribute("ui.stylesheet",
                "node { text-size: 14px; size: 30px; text-alignment: center; fill-color: yellow; }"
                        + "edge { size: 2px; }");
    }

    private void agregarNodoYSubarbol(NodoArbol nodoActual, String padreId, Graph arbolVisual) {
        Persona persona = (Persona) nodoActual.getDato();
        String nodoId = persona.nombreUnico();

        // Verificar si el nodo ya existe
        if (arbolVisual.getNode(nodoId) == null) {
            org.graphstream.graph.Node nodoVisual = arbolVisual.addNode(nodoId);
            nodoVisual.setAttribute("ui.label", persona.nombreUnico());
            nodoVisual.setAttribute("persona", persona); // Guardar información de la persona en el nodo
        }

        // Conectar con el padre si existe
        if (padreId != null && arbolVisual.getEdge(padreId + "-" + nodoId) == null) {
            arbolVisual.addEdge(padreId + "-" + nodoId, padreId, nodoId);
        }

        // Recursivamente añadir los hijos
        for (int i = 0; i < nodoActual.getHijos().getSize(); i++) {
            NodoArbol hijo = (NodoArbol) nodoActual.getHijos().getValor(i);
            agregarNodoYSubarbol(hijo, nodoId, arbolVisual);
        }
    }

    private void mostrarInfoPersona(Persona persona) {
        String info = "Información de la Persona:\n"
                + "Nombre: " + persona.getNombreCompleto() + "\n"
                + "Padre: " + persona.getPadre() + "\n"
                + "Madre: " + persona.getMadre();
        JOptionPane.showMessageDialog(this, info, "Detalles de Persona", JOptionPane.INFORMATION_MESSAGE);
    }

    private void agregarBotonRegresar() {
        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.addActionListener(e -> {
            cerrarVisor();
            dispose();
            abrirMenu();
        });
        add(botonRegresar, BorderLayout.SOUTH);
    }

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

    private void abrirMenu() {
        Menu menuPrincipal = new Menu();
        
    }
}
