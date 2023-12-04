/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import modelo.ActualizacionInventario;
import modelo.ConexionBD;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayaka
 */
public class VentasForm extends javax.swing.JFrame {
    
    private ConexionBD conexionBD;
    private ActualizacionInventario actualizacionInventario;
    
    /**
     * Creates new form VentasForn
     */
    public VentasForm() {
        initComponents();
        inicializarConexion();
    }
    
    private void inicializarConexion() {
        ConexionBD conexion = new ConexionBD("root", "admin");

        if (conexionBD.setConexion()) {
            actualizacionInventario = new ActualizacionInventario(conexionBD);
        } else {
            JOptionPane.showMessageDialog(this, "Error al conectarse a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
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

        JTFidProducto = new javax.swing.JTextField();
        JTFcantidadProducto = new javax.swing.JTextField();
        JBvender = new javax.swing.JButton();
        JLidProducto = new javax.swing.JLabel();
        JLcantidadProducto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTFidProducto.setText("ID Producto");
        JTFidProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFidProductoActionPerformed(evt);
            }
        });

        JTFcantidadProducto.setText("Cantidad");
        JTFcantidadProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFcantidadProductoActionPerformed(evt);
            }
        });

        JBvender.setText("Realizar Venta");
        JBvender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBvenderActionPerformed(evt);
            }
        });

        JLidProducto.setText("ID del producto:");

        JLcantidadProducto.setText("Cantidad a vender:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLidProducto))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFcantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLcantidadProducto)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(JBvender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLcantidadProducto)
                    .addComponent(JLidProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFcantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(JBvender)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBvenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBvenderActionPerformed
        // TODO add your handling code here:
        try {
            // obtener los datos de la interfaz gráfica
            int idProducto = Integer.parseInt(JTFidProducto.getText());
            int cantidadVendida = Integer.parseInt(JTFcantidadProducto.getText());

            // actualización del inventario
            actualizacionInventario.actualizarInventario(idProducto, cantidadVendida);

            JOptionPane.showMessageDialog(this, "Venta realizada con exito", "exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numericos validos", "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBvenderActionPerformed

    private void JTFidProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFidProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFidProductoActionPerformed

    private void JTFcantidadProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFcantidadProductoActionPerformed
        // TODO add your handling code here:
        JBvenderActionPerformed(evt);
    }//GEN-LAST:event_JTFcantidadProductoActionPerformed

    public int getIdProducto() {
        try {
            return Integer.parseInt(JTFidProducto.getText());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    public int getCantidadVendida() {
        try {
            return Integer.parseInt(JTFcantidadProducto.getText());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
    
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
            java.util.logging.Logger.getLogger(VentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBvender;
    private javax.swing.JLabel JLcantidadProducto;
    private javax.swing.JLabel JLidProducto;
    private javax.swing.JTextField JTFcantidadProducto;
    private javax.swing.JTextField JTFidProducto;
    // End of variables declaration//GEN-END:variables
}
