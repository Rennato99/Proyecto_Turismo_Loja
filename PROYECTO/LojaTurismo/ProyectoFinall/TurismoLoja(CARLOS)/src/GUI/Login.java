/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.BLAdmin;
import BL.BLClient;
import CLASES.Admin;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import CLASES.Client;
import DATA.GlobalVariables;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Carlos
 */
public class Login extends javax.swing.JFrame {
    
    

    public Login() throws ClassNotFoundException, SQLException {

        initComponents();
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
        txtIdentification = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        jComboBoxRol = new javax.swing.JComboBox<>();
        jLabelIdentification = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Seleccione rol");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 30, 140, -1));

        txtIdentification.setEnabled(false);
        jPanel1.add(txtIdentification, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 123, 210, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Contraseña: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jPassword.setEnabled(false);
        jPanel1.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 210, 30));

        btnLogin.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnLogin.setText("Iniciar Sesión");
        btnLogin.setEnabled(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 40));

        btnRegister.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnRegister.setText("Registrarse");
        btnRegister.setEnabled(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 150, 40));

        jComboBoxRol.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComboBoxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Cliente" }));
        jComboBoxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRolActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 120, -1));

        jLabelIdentification.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabelIdentification.setForeground(new java.awt.Color(255, 102, 0));
        jLabelIdentification.setText("Usuario");
        jPanel1.add(jLabelIdentification, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegresar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 410, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        if(this.jComboBoxRol.getSelectedIndex() == 0){
            BLAdmin objBLAdmin = new BLAdmin();
            Admin objAdmin = new Admin();
            try {
                objAdmin = objBLAdmin.findAdminIdentificationDB(this.txtIdentification.getText());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (objAdmin.getIdAdmin() != 0) {
                objAdmin = objBLAdmin.ValidatePassword(objAdmin, String.valueOf(this.jPassword.getPassword()));
                if (objAdmin != null) {
                    GlobalVariables.loggedAdmin = objAdmin;
                    validateEvents objValidateEvents = new validateEvents();
                    objValidateEvents.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "La identificacion o contraseña no coinciden con ninguna cuenta\n\n"
                            + "Registrate para crea una cuenta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La identificacion o contraseña no coinciden con ninguna cuenta\n\n"
                        + "Registrate para crea una cuenta");
            }
                        
        }else{
            Client objClient = new Client();
            BLClient objBLClient = new BLClient();            
        
            try {
                objClient = objBLClient.findClientIdentificationDB(this.txtIdentification.getText());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

            }

            if (objClient.getIdClient() != 0) {
                objClient = objBLClient.ValidatePassword(objClient, String.valueOf(this.jPassword.getPassword()));
                if (objClient != null) {
                    GlobalVariables.loggedClient = objClient;
                    OptionClient objOptionClient = new OptionClient();
                    objOptionClient.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "La identificacion o contraseña no coinciden con ninguna cuenta\n\n"
                            + "Registrate para crea una cuenta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La identificacion o contraseña no coinciden con ninguna cuenta\n\n"
                        + "Registrate para crea una cuenta");
            }
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        CreateAccount objCrearAcount = new CreateAccount();
        objCrearAcount.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void jComboBoxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRolActionPerformed
        // TODO add your handling code here:
        this.txtIdentification.setText("");
        this.jPassword.setText("");
        this.txtIdentification.setEnabled(true);
        this.jPassword.setEnabled(true);
        this.btnLogin.setEnabled(true);
        if(this.jComboBoxRol.getSelectedIndex() == 0){
            this.jLabelIdentification.setText("Usuario");
            this.btnRegister.setEnabled(false);
        }else{
            this.btnRegister.setEnabled(true);
            this.jLabelIdentification.setText("Identificacion");
        }
        
    }//GEN-LAST:event_jComboBoxRolActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
        Main objMain = new Main();
        objMain.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JComboBox<String> jComboBoxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelIdentification;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField txtIdentification;
    // End of variables declaration//GEN-END:variables
}
