/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package myTech;
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

        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        IDADMIN = new javax.swing.JTextField();
        NAMAADMIN = new javax.swing.JTextField();
        USERNAME = new javax.swing.JTextField();
        PASSWORD = new javax.swing.JTextField();
        NOTELPON = new javax.swing.JTextField();
        TTL = new com.github.lgooddatepicker.components.DatePicker();
        ALAMAT = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel15.setText("password");

        jLabel19.setText("alamat");

        jLabel14.setText("username");

        jLabel11.setText("Admin");

        jLabel17.setText("no telephone");

        jButton6.setText("tambah");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton9.setText("hapus");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel13.setText("nama admin");

        jButton10.setText("keluar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel12.setText("Id admin");

        jButton7.setText("edit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel18.setText("tanggal lahir");

        jButton8.setText("cari");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

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

        IDADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDADMINActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(NOTELPON, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                            .addComponent(PASSWORD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(USERNAME, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NAMAADMIN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDADMIN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ALAMAT)
                            .addComponent(TTL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(666, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 286, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NAMAADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(NOTELPON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
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
    }//GEN-LAST:event_jButton6ActionPerformed
    
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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
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
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
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
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ALAMAT;
    private javax.swing.JTextField IDADMIN;
    private javax.swing.JTextField NAMAADMIN;
    private javax.swing.JTextField NOTELPON;
    private javax.swing.JTextField PASSWORD;
    private com.github.lgooddatepicker.components.DatePicker TTL;
    private javax.swing.JTextField USERNAME;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
