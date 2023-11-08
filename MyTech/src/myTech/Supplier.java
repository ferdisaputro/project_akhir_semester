/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package myTech;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USER
 */
public class Supplier extends javax.swing.JInternalFrame {
    Koneksi koneksi = new Koneksi();
    /**
     * Creates new form Supplier
     */
    public Supplier() {
        initComponents();
        datatable("");
        reset();        
    }
        public void reset(){
            txtalamat.setText("");
            txtnama.setText("");
            txtno.setText("");
            txtid.setText("");
            txtcreat.setText("");
            
        }
        public void datatable(String string){
            DefaultTableModel tbl=new DefaultTableModel();
            tbl.addColumn("Alamat");
            tbl.addColumn("Nama Supplier");
            tbl.addColumn("No Telephone");
            tbl.addColumn("Id Supplie");
            tbl.addColumn("Created Ad");
            table.setModel(tbl);
            try{
                Statement statement=koneksi.GetConnection().createStatement();
                ResultSet res=(ResultSet) statement.executeQuery("select * from supplier");
                while(res.next())
                {
                    tbl.addRow(new Object[]{
                        res.getString("Alamat"),
                        res.getString("Nama Supllier"),
                        res.getString("No Telephone"),
                        res.getString("Id Supllier"),
                        res.getString("Created Ad")
                    });
                    table.setModel(tbl);
                }
            }catch (Exception e){
                    JOptionPane.showMessageDialog(rootPane, ""+e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtcreat = new javax.swing.JTextField();
        btambah = new javax.swing.JButton();
        bcari = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bhapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bkeluar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bupdate = new javax.swing.JButton();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Alamat", "Nama Supllier", "No Telephone", "Id Supllier", "Created At"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel4.setText("Alamat");

        jLabel5.setText("Created At");

        jLabel6.setText("No Telephone");

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel1.setText("SUPPLIER");

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        jLabel2.setText("Id Supllier");

        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Supllier");

        bupdate.setText("Update");
        bupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bupdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bhapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bkeluar)
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtcreat, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4))
                                            .addGap(24, 24, 24)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtalamat, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtnama, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcreat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btambah)
                            .addComponent(bcari)
                            .addComponent(bhapus)
                            .addComponent(bkeluar)
                            .addComponent(bupdate)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        String alamat = txtalamat.getText();
        String nama = txtnama.getText();
        String notelephone = txtno.getText();
        String idsupplier = txtid.getText();
        String createdad = txtcreat.getText();
        try{
            Statement statement=koneksi.GetConnection().createStatement();
            statement.executeUpdate("insert into supplier(alamat, nama, no_telephone) VALUES"
                    + "('"+alamat+"', '"+nama+"', '"+notelephone+"', '"+idsupplier+"', '"+createdad+"')");
            datatable("SELECT * FROM tabmahasiswa");
        reset();               
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_btambahActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        // TODO add your handling code here:
        try {
            Statement statement=koneksi.GetConnection().createStatement();
            ResultSet res = (ResultSet) statement.executeQuery("select * from supplier where " + "alamat='" + bcari.getText() + "'");
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("alamat");
            tbl.addColumn("nama");
            tbl.addColumn("no telephone");
            tbl.addColumn("id supplier");
            tbl.addColumn("created ad");
            
            table.setModel(tbl);
            while (res.next()) {
                tbl.addRow(new Object[]{
                            res.getString("alamat"),
                            res.getString("nama"),
                            res.getString("no telephone"),
                            res.getString("id supplier"),
                        });
                table.setModel(tbl);
                
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
        }
    }//GEN-LAST:event_bcariActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        String alamat = txtalamat.getText();
        try {
            Statement statement=koneksi.GetConnection().createStatement();
            statement.executeUpdate("DELETE from supplier where npm=('" + alamat + "');" );          
            JOptionPane.showMessageDialog(null, "data berhasil di HAPUS");
            txtalamat.setText("");
            txtnama.setText("");
            txtno.setText("");
            txtid.setText("");
            txtcreat.setText("");
            txtalamat.requestFocus();
        }catch (Exception t) {
            JOptionPane.showMessageDialog(null, "Data gagal di HAPUS");
        }
        datatable("");
    }//GEN-LAST:event_bhapusActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void bupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bupdateActionPerformed
        // TODO add your handling code here:
        String alamat = txtalamat.getText();
        String nama = txtnama.getText();
        String notelephone = txtno.getText();
        String idsupplier = txtid.getText();
        String createdat = txtcreat.getText();
        try {
        Statement statement = (Statement) koneksi.GetConnection().createStatement();
        String query = "UPDATE supplier SET "
            + "alamat = '" + alamat + "', "
            + "nama = '" + nama + "', "
            + "notelephone = '" + notelephone + "', "
            + "idsupplier = '" + idsupplier + "', "
            + "createdat = '" + createdat + "' WHERE alamat = '" + alamat + "'";
        statement.executeUpdate(query);
        datatable("");
        reset();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_bupdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton btambah;
    private javax.swing.JButton bupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcreat;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtno;
    // End of variables declaration//GEN-END:variables
}
