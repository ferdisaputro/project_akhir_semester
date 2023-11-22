/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package myTech;
import java.awt.Color;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Admin extends javax.swing.JInternalFrame {
    Koneksi conek = new Koneksi();
    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        datatable();
        IDADMIN.setBackground (new Color(0,0,0,0));
        NAMAADMIN.setBackground (new Color(0,0,0,0));
        USERNAME.setBackground(new Color(0,0,0,0));
        PASSWORD.setBackground(new Color(0,0,0,0));
        NOTELPON.setBackground(new Color(0,0,0,0));
        TTL.setBackground(new Color(0,0,0,0));
        ALAMAT.setBackground(new Color(0,0,0,0));
        tambah.setBackground(new Color(0,0,0,0));
        cari.setBackground(new Color(0,0,0,0));
        hapus.setBackground(new Color(0,0,0,0));
        Reset.setBackground(new Color(0,0,0,0));
        keluar.setBackground(new Color(0,0,0,0));
        IDADMIN.setBorder (null);
        NAMAADMIN.setBorder (null);
        USERNAME.setBorder(null);
        PASSWORD.setBorder(null);
        NOTELPON.setBorder(null);
        TTL.setBorder(null);
        ALAMAT.setBorder(null);
        tambah.setBorder(null);
        cari.setBorder(null);
        hapus.setBorder(null);
        Reset.setBorder(null);
        keluar.setBorder(null);
    }
    
    void datatable() {
        try {
            Statement statement=conek.GetConnection().createStatement();
            ResultSet res = (ResultSet) statement.executeQuery("select * from admin");
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("id admin");
            tbl.addColumn("nama");
            tbl.addColumn("username");
            tbl.addColumn("tanggal lahir");
            tbl.addColumn("no telp");
            tbl.addColumn("alamat");
            tbl.addColumn("created at");
            table.setModel(tbl);
            while (res.next()) {
                tbl.addRow(new Object[]{
                        res.getString("id_admin"),
                        res.getString("nama"),
                        res.getString("username"),
                        res.getString("tanggal_lahir"),
                        res.getString("no_telp"),
                        res.getString("alamat"),
                        res.getString("created_at"),
                    });
                table.setModel(tbl);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "salah "+e);
        }
    }
    
    void reset () {
        IDADMIN.setText("");
        NAMAADMIN.setText("");
        USERNAME.setText("");
        PASSWORD.setText("");
        NOTELPON.setText("");
        TTL.setText("");
        ALAMAT.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        cari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        IDADMIN = new javax.swing.JTextField();
        NAMAADMIN = new javax.swing.JTextField();
        USERNAME = new javax.swing.JTextField();
        PASSWORD = new javax.swing.JTextField();
        NOTELPON = new javax.swing.JTextField();
        TTL = new com.github.lgooddatepicker.components.DatePicker();
        ALAMAT = new javax.swing.JTextField();
        Reset = new javax.swing.JLabel();
        Breset = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tambah.setText("tambah");
        tambah.setBorder(null);
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 670, 130, 30));

        hapus.setText("hapus");
        hapus.setBorder(null);
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 660, 130, 40));

        keluar.setText("keluar");
        keluar.setBorder(null);
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 740, 150, 30));

        jButton7.setText("edit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 1008, -1, -1));

        cari.setText("cari");
        cari.setBorder(null);
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 660, 120, 40));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id admin", "nama admin", "username", "email", "no telephone", "tanggal lahir", "alamat", "create at"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 710, 490));

        IDADMIN.setBorder(null);
        IDADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDADMINActionPerformed(evt);
            }
        });
        getContentPane().add(IDADMIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 298, 30));

        NAMAADMIN.setBorder(null);
        getContentPane().add(NAMAADMIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 298, 30));

        USERNAME.setBorder(null);
        getContentPane().add(USERNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 298, 30));

        PASSWORD.setBorder(null);
        getContentPane().add(PASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 298, 30));

        NOTELPON.setBorder(null);
        getContentPane().add(NOTELPON, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 298, 30));

        TTL.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 300, 30));

        ALAMAT.setBorder(null);
        getContentPane().add(ALAMAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 532, 298, 30));

        Reset.setBackground(new java.awt.Color(255, 255, 255));
        Reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_component_asset/revisi admin.png"))); // NOI18N
        Reset.setText("jLabel1");
        getContentPane().add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1280, -1));

        Breset.setText("Reset");
        Breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BresetActionPerformed(evt);
            }
        });
        getContentPane().add(Breset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 670, 100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
       String nama = NAMAADMIN.getText();
       String user = USERNAME.getText();
       String password = PASSWORD.getText();
       String notelf = NOTELPON.getText();
       String ttl = TTL.getDate().toString();
       String alamat = ALAMAT.getText();
       LocalDate currentDate = LocalDate.now();
       Koneksi cn = new Koneksi();
       try {
           Statement statement = conek.GetConnection().createStatement();
           statement.executeUpdate("insert into admin(nama,tanggal_lahir,no_telp,alamat,password,username,created_at) VALUES ('"+nama+"','"+ttl+"','"+notelf+"','"+alamat+"','"+password+"','"+user+"', '"+currentDate+"')");
           datatable();
           reset();
       } catch(Exception e) {
           JOptionPane.showMessageDialog(null, e);
      }
    }//GEN-LAST:event_tambahActionPerformed
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         try {
            Statement statement = conek.GetConnection().createStatement();
            String query = "UPDATE admin SET "
                    +"nama = '" + NAMAADMIN.getText()+ "',"
                    +"username = '" + USERNAME.getText() + "',"
                    + "no_telp = '" + NOTELPON.getText() + "',"
                    + "tanggal_lahir = '" + TTL.getDate() + "',"
                    + "alamat = '" + ALAMAT.getText() + "' "
                    + "WHERE id_admin = '"+ IDADMIN.getText() +"'";
                    
            statement.executeUpdate(query);
            datatable();
            reset();
            
        }catch (Exception e){
           JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        try {
            Statement statement=conek.GetConnection().createStatement();
            ResultSet res = (ResultSet) statement.executeQuery("select * from admin");
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("id admin");
            tbl.addColumn("nama");
            tbl.addColumn("username");
            tbl.addColumn("tanggal lahir");
            tbl.addColumn("no telp");
            tbl.addColumn("alamat");
            tbl.addColumn("created at");
            table.setModel(tbl);
            while (res.next()) {
                tbl.addRow(new Object[]{
                        res.getString("id_admin"),
                        res.getString("nama"),
                        res.getString("username"),
                        res.getString("tanggal_lahir"),
                        res.getString("no_telp"),
                        res.getString("alamat"),
                        res.getString("created_at"),
                    });
                table.setModel(tbl);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "salah "+e);
        }
    }//GEN-LAST:event_cariActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        String idadmin = IDADMIN.getText();
        try {
            Statement statement=conek.GetConnection().createStatement();
            statement.executeUpdate("DELETE from admin where id_admin=('" + IDADMIN.getText() + "');" );          
            JOptionPane.showMessageDialog(null, "data berhasil di HAPUS");
            datatable();
            reset();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal di HAPUS" + e);
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void IDADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDADMINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDADMINActionPerformed

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        int row = table.getSelectedRow();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        IDADMIN.setText(tableModel.getValueAt(row, 0).toString());
        NAMAADMIN.setText(tableModel.getValueAt(row, 1).toString());
        USERNAME.setText(tableModel.getValueAt(row, 2).toString());
        LocalDate date = LocalDate.parse(tableModel.getValueAt(row, 3).toString());        
        TTL.setDate(date);
        NOTELPON.setText(tableModel.getValueAt(row, 4).toString());
        ALAMAT.setText(tableModel.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tableMouseReleased

    private void BresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BresetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_BresetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ALAMAT;
    private javax.swing.JButton Breset;
    private javax.swing.JTextField IDADMIN;
    private javax.swing.JTextField NAMAADMIN;
    private javax.swing.JTextField NOTELPON;
    private javax.swing.JTextField PASSWORD;
    private javax.swing.JLabel Reset;
    private com.github.lgooddatepicker.components.DatePicker TTL;
    private javax.swing.JTextField USERNAME;
    private javax.swing.JButton cari;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton keluar;
    private javax.swing.JTable table;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables

}
