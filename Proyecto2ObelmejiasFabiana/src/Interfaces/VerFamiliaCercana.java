/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.Lista;
import EDD.NodoArbol;
import static Interfaces.Iniciar.arbolGenealogico;
import Modelo.Persona;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author obelm
 */
public class VerFamiliaCercana extends javax.swing.JFrame {

    DefaultComboBoxModel modeloPersonas = new DefaultComboBoxModel();

    public VerFamiliaCercana() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.llenarModelo();
    }

    private void llenarModelo() {
        Lista nombres = arbolGenealogico.nombresPersonas();
        for (int i = 0; i < nombres.getSize(); i++) {
            modeloPersonas.addElement(nombres.getValor(i));
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
        personas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        buscarFamiliaCercana = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultPadre = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultAbuelo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultTios = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        resultPrimos = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        resultHijos = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        resultHermanos = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Buscar Parentescos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        personas.setModel(modeloPersonas);
        jPanel1.add(personas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 320, -1));

        jLabel2.setText("Seleccionar Persona");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        buscarFamiliaCercana.setText("Buscar Familia mas Cercana");
        buscarFamiliaCercana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFamiliaCercanaActionPerformed(evt);
            }
        });
        jPanel1.add(buscarFamiliaCercana, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 320, -1));

        resultPadre.setColumns(20);
        resultPadre.setRows(5);
        jScrollPane1.setViewportView(resultPadre);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 180, 90));

        jLabel3.setText("Hermanos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        resultAbuelo.setColumns(20);
        resultAbuelo.setRows(5);
        jScrollPane2.setViewportView(resultAbuelo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 180, 90));

        jLabel4.setText("Primos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        resultTios.setColumns(20);
        resultTios.setRows(5);
        jScrollPane3.setViewportView(resultTios);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 180, 90));

        jLabel5.setText("Padre");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        resultPrimos.setColumns(20);
        resultPrimos.setRows(5);
        jScrollPane4.setViewportView(resultPrimos);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 180, 90));

        jLabel6.setText("Tios");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        resultHijos.setColumns(20);
        resultHijos.setRows(5);
        jScrollPane5.setViewportView(resultHijos);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 180, 90));

        jLabel7.setText("Abuelo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        volver.setText("volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 590, -1, -1));

        resultHermanos.setColumns(20);
        resultHermanos.setRows(5);
        jScrollPane6.setViewportView(resultHermanos);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 170, 90));

        jLabel8.setText("Hijos");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Menu menu = new Menu();
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void buscarFamiliaCercanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFamiliaCercanaActionPerformed
        String nombreSeleccion = (String) personas.getSelectedItem();

        if (arbolGenealogico.getArbol().encontrarAbuelo(nombreSeleccion) != null) {
            Persona abuelo = (Persona) arbolGenealogico.getArbol().encontrarAbuelo(nombreSeleccion).getDato();
            resultAbuelo.setText(abuelo.nombreUnico());
        }

        if (arbolGenealogico.getArbol().buscarPorNombreClave(nombreSeleccion).getPadre() != null) {
            Persona padre = (Persona) arbolGenealogico.getArbol().buscarPorNombreClave(nombreSeleccion).getPadre().getDato();
            resultPadre.setText(padre.nombreUnico());
        }

        if (!arbolGenealogico.getArbol().encontrarTios(nombreSeleccion).isEmpty()) {
            Lista tiosEnc = arbolGenealogico.getArbol().encontrarTios(nombreSeleccion);
            String tios = "";
            for (int i = 0; i < tiosEnc.getSize(); i++) {
                Persona tioAct = (Persona) tiosEnc.getValor(i);
                tios += tioAct.nombreUnico() + "\n";
            }
            resultTios.setText(tios);
        }

        if (!arbolGenealogico.getArbol().encontrarPrimos(nombreSeleccion).isEmpty()) {
            Lista primosEnc = arbolGenealogico.getArbol().encontrarPrimos(nombreSeleccion);
            String primos = "";
            for (int i = 0; i < primosEnc.getSize(); i++) {
                Persona primoAct = (Persona) primosEnc.getValor(i);
                primos += primoAct.nombreUnico() + "\n";
            }
            resultPrimos.setText(primos);
        }

        if (!arbolGenealogico.getArbol().encontrarHermanos(nombreSeleccion).isEmpty()) {
            Lista hermanosEnc = arbolGenealogico.getArbol().encontrarHermanos(nombreSeleccion);
            String hermanos = "";
            for (int i = 0; i < hermanosEnc.getSize(); i++) {
                Persona hermanAct = (Persona) hermanosEnc.getValor(i);
                hermanos += hermanAct.nombreUnico() + "\n";
            }
            resultHermanos.setText(hermanos);
        }

        if (!arbolGenealogico.getArbol().buscarPorNombreClave(nombreSeleccion).getHijos().isEmpty()) {
            Lista hijosEnc = arbolGenealogico.getArbol().buscarPorNombreClave(nombreSeleccion).getHijos();
            String hijos = "";
            for (int i = 0; i < hijosEnc.getSize(); i++) {
                NodoArbol hijo1 = (NodoArbol) hijosEnc.getValor(i);
                Persona hijosAct = (Persona) hijo1.getDato();
                hijos += hijosAct.nombreUnico() + "\n";
            }
            resultHijos.setText(hijos);
        }


    }//GEN-LAST:event_buscarFamiliaCercanaActionPerformed

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
            java.util.logging.Logger.getLogger(VerFamiliaCercana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerFamiliaCercana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerFamiliaCercana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerFamiliaCercana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerFamiliaCercana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarFamiliaCercana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JComboBox<String> personas;
    private javax.swing.JTextArea resultAbuelo;
    private javax.swing.JTextArea resultHermanos;
    private javax.swing.JTextArea resultHijos;
    private javax.swing.JTextArea resultPadre;
    private javax.swing.JTextArea resultPrimos;
    private javax.swing.JTextArea resultTios;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
