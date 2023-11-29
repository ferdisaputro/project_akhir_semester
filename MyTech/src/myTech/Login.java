/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myTech;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Login extends javax.swing.JFrame {
    Statement stat;
    Koneksi cn = new Koneksi();
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        username.setBackground (new Color(0,0,0,0));
        password.setBackground (new Color(0,0,0,0));
        showPassword.setBackground(new Color(0,0,0,0));
        jButton1.setBackground(new Color(0,0,0,0));
        username.setBorder (null);
        password.setBorder (null);
        showPassword.setBorder(null);
        jButton1.setBorder(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        showPassword = new javax.swing.JCheckBox();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setBorder(null);
        username.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 260, 50));

        jButton1.setBorder(null);
        jButton1.setForeground(new Color(0,0,0,0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 290, 40));

        showPassword.setBackground(new java.awt.Color(255, 255, 255));
        showPassword.setForeground(new Color(0,0,0,0));
        showPassword.setBorder(null);
        showPassword.setMargin(new java.awt.Insets(4, 4, 4, 4));
        showPassword.setPreferredSize(new java.awt.Dimension(20, 20));
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 20, 20));

        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setBorder(null);
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 260, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_component_asset/Login.png"))); // NOI18N
        jLabel1.setText("    ");
        jLabel1.setPreferredSize(new java.awt.Dimension(1280, 800));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 1280, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        // TODO add your handling code here:
        if(showPassword.isSelected()) password.setEchoChar((char)0);
        else password.setEchoChar('*');
    }//GEN-LAST:event_showPasswordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            stat = cn.GetConnection().createStatement();
            String sql = "SELECT * FROM admin WHERE username = "
            + "'"+username.getText()+"' AND "
            + "password = '"+password.getText()+"';";
            ResultSet res = stat.executeQuery(sql);
            if (res.next()) {
                admin.UserAdmin userAdmin = new admin.UserAdmin();
                admin.UserAdmin.setId(res.getInt("id_admin"));
                admin.UserAdmin.setName(res.getString("nama"));
                admin.UserAdmin.setUsername(res.getString("username"));
                Home home = new Home();
                home.setSize(1200, 700);
                home.setVisible(true);
                home.setExtendedState(Home.MAXIMIZED_BOTH);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username/password salah");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
