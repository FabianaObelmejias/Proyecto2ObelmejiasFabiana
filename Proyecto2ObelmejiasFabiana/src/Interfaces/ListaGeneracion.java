/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.Lista;
import EDD.Nodo;
import static Interfaces.Iniciar.arbolGenealogico;
import static Interfaces.Menu.validar;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author obelm
 */
public class ListaGeneracion extends javax.swing.JFrame {

    DefaultComboBoxModel modeloGeneracion = new DefaultComboBoxModel();
    public ListaGeneracion() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.iniciarComboBox();
    }
    
    private void iniciarComboBox(){
        Lista generaciones = arbolGenealogico.opcionesDeGeneracion();
        
        Nodo temp = generaciones.getpFirst();
        while(temp != null){
            String generacionActual = (String) temp.getDato();
            modeloGeneracion.addElement(generacionActual);
            temp = temp.getpNext();
        }  
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
        listaGeneraciones = new javax.swing.JComboBox<>();
        listarGeneracion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        generacionStr = new javax.swing.JTextArea();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Listar Generacion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        listaGeneraciones.setModel(modeloGeneracion);
        jPanel1.add(listaGeneraciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 270, -1));

        listarGeneracion.setText("Listar Generacion");
        listarGeneracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarGeneracionActionPerformed(evt);
            }
        });
        jPanel1.add(listarGeneracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 270, -1));

        generacionStr.setColumns(20);
        generacionStr.setRows(5);
        jScrollPane1.setViewportView(generacionStr);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 380, 320));

        volver.setText("volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Menu menu = new Menu();
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void listarGeneracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarGeneracionActionPerformed
        String opcionCombo = (String) listaGeneraciones.getSelectedItem();
        String numeroStr = opcionCombo.replaceAll("Generacion ", "");
        int numero = validar.validarNumeros(numeroStr);
        
        generacionStr.setText(arbolGenealogico.mostrarGeneracion(numero));
    }//GEN-LAST:event_listarGeneracionActionPerformed

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
            java.util.logging.Logger.getLogger(ListaGeneracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaGeneracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaGeneracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaGeneracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaGeneracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea generacionStr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listaGeneraciones;
    private javax.swing.JButton listarGeneracion;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
