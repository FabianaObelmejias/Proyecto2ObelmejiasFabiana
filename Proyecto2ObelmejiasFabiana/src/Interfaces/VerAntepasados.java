/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.Lista;
import Funciones.MostrarAntepasados;
import static Interfaces.Iniciar.arbolGenealogico;
import static Interfaces.Menu.validar;
import Modelo.Persona;
import javax.swing.JOptionPane;

/**
 *
 * @author obelm
 */
public class VerAntepasados extends javax.swing.JFrame {

    private Persona[] arregloResultado;

    public VerAntepasados() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        inputNombreB = new javax.swing.JTextField();
        buscarNombre = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadosBusqueda = new javax.swing.JTextArea();
        indexArray = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Ver Antepasados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        volver.setText("volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, -1));

        jLabel2.setText("Escriba el nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));
        jPanel1.add(inputNombreB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 240, -1));

        buscarNombre.setText("buscar");
        buscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarNombreActionPerformed(evt);
            }
        });
        jPanel1.add(buscarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 90, -1));

        jLabel3.setText("Resultados");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        resultadosBusqueda.setColumns(20);
        resultadosBusqueda.setRows(5);
        jScrollPane1.setViewportView(resultadosBusqueda);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 350, 170));
        jPanel1.add(indexArray, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 210, -1));

        jButton1.setText("ver detalles");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 130, -1));

        jLabel4.setText("Ingrese el numero asociado a uno de los resultados para ver ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        jLabel5.setText("sus antepasados");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo1.0.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarNombreActionPerformed
        if (!inputNombreB.getText().isEmpty()) {
            String nombre = inputNombreB.getText();
            arregloResultado = arbolGenealogico.buscarNombre(nombre);
            if (arregloResultado != null) {
                resultadosBusqueda.setText(arbolGenealogico.mostrarResultados(arregloResultado));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron nombres o motes que coincidan con la busqueda");
            }

            inputNombreB.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "EL INPUT NO PUEDE SER VACIO");
        }


    }//GEN-LAST:event_buscarNombreActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Menu menu = new Menu();
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!indexArray.getText().isEmpty()) {
            String indexStr = indexArray.getText();

            if (validar.validarNumeros(indexStr) != -1) {
                int index = validar.validarNumeros(indexStr);

                Lista listaAencestros = arbolGenealogico.mostrarAntepasados(arregloResultado, index);
                if (listaAencestros != null) {

                    System.setProperty("org.graphstream.ui", "swing");
                    MostrarAntepasados verAntepasados = new MostrarAntepasados(listaAencestros);
                    verAntepasados.setVisible(true);
                    this.dispose();

//arbolDesc.mostrarPorNivel();
                } else {
                    JOptionPane.showMessageDialog(null, "Indice invalido. El indice debe estar entre 0 y " + arregloResultado.length);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El input solo pueder un numero entero.");
            }

            indexArray.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "EL INPUT NO PUEDE SER VACIO");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerAntepasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerAntepasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerAntepasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerAntepasados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerAntepasados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarNombre;
    private javax.swing.JTextField indexArray;
    private javax.swing.JTextField inputNombreB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultadosBusqueda;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
