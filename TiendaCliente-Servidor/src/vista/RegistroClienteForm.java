/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.PersonaController;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import modelo.Persona;

/**
 *
 * @author esanarru
 */
public class RegistroClienteForm extends javax.swing.JFrame {

    private ConexionBD conexionBD;
    private PersonaController controlador;
    
    public RegistroClienteForm() {
        initComponents();
        conexionBD = new ConexionBD("root", "admin");
        controlador = new PersonaController();
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

        JTFCorreoCliente = new javax.swing.JTextField();
        JBRegistrarCliente = new javax.swing.JButton();
        JLRegresarMenu = new javax.swing.JLabel();
        JLRegistroCliente = new javax.swing.JLabel();
        JLNombreCliente = new javax.swing.JLabel();
        JLCorreoCliente = new javax.swing.JLabel();
        JLTelefonoCliente = new javax.swing.JLabel();
        JTFNombreCliente = new javax.swing.JTextField();
        JTFTelefonoCliente = new javax.swing.JTextField();
        JTFCedulaCliente = new javax.swing.JTextField();
        JLCedulaCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBRegistrarCliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JBRegistrarCliente.setText("Registrar Cliente");
        JBRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRegistrarClienteActionPerformed(evt);
            }
        });

        JLRegresarMenu.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        JLRegresarMenu.setText("Regresar a Menú Principal");
        JLRegresarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLRegresarMenuMouseClicked(evt);
            }
        });

        JLRegistroCliente.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        JLRegistroCliente.setText("Registro Cliente:");

        JLNombreCliente.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        JLNombreCliente.setText("Nombre:");

        JLCorreoCliente.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        JLCorreoCliente.setText("Correo:");

        JLTelefonoCliente.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        JLTelefonoCliente.setText("Teléfono:");

        JTFNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNombreClienteActionPerformed(evt);
            }
        });

        JLCedulaCliente.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        JLCedulaCliente.setText("Cédula:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(JLRegistroCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLCorreoCliente)
                                    .addComponent(JLNombreCliente)
                                    .addComponent(JLTelefonoCliente)
                                    .addComponent(JTFTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTFCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTFNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLCedulaCliente)
                                    .addComponent(JTFCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 125, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLRegresarMenu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JBRegistrarCliente, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLRegistroCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLNombreCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLCorreoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLTelefonoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLCedulaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(JBRegistrarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLRegresarMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRegistrarClienteActionPerformed
        if (!JTFNombreCliente.getText().trim().equals("")
            && !JTFTelefonoCliente.getText().trim().equals("")
            && !JTFCorreoCliente.getText().trim().equals("")
            && !JTFCedulaCliente.getText().trim().equals("")) {
            Persona miPersona = new Persona();
            miPersona.setNombre(JTFNombreCliente.getText().trim());
            miPersona.setCorreo(JTFCorreoCliente.getText().trim());
            miPersona.setTelefono(JTFTelefonoCliente.getText().trim());
            miPersona.setCedula(Integer.parseInt(JTFCedulaCliente.getText().trim()));
            if (conexionBD.setConexion()) {
                if (controlador.insertarUsuario(miPersona)) {
                    JOptionPane.showMessageDialog(null, "Cliente agregado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al conectar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe rellenar todas las opciones");
        }
    }//GEN-LAST:event_JBRegistrarClienteActionPerformed

    private void JLRegresarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLRegresarMenuMouseClicked
        this.dispose();
        MenuPrincipal menu = new MenuPrincipal(conexionBD);

        menu.show();
    }//GEN-LAST:event_JLRegresarMenuMouseClicked

    private void JTFNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNombreClienteActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroClienteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBRegistrarCliente;
    private javax.swing.JLabel JLCedulaCliente;
    private javax.swing.JLabel JLCorreoCliente;
    private javax.swing.JLabel JLNombreCliente;
    private javax.swing.JLabel JLRegistroCliente;
    private javax.swing.JLabel JLRegresarMenu;
    private javax.swing.JLabel JLTelefonoCliente;
    private javax.swing.JTextField JTFCedulaCliente;
    private javax.swing.JTextField JTFCorreoCliente;
    private javax.swing.JTextField JTFNombreCliente;
    private javax.swing.JTextField JTFTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
