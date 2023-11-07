/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package myTech;

import java.sql.*;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Barang extends javax.swing.JInternalFrame {
    Koneksi koneksi = new Koneksi();
    private Object tabel;
    private String title;

    public Barang() {
        initComponents();
        datatable("SELECT * FROM barang");       
    }
    private void datatable(String select__from_barang) {
        DefaultTableModel tbl=new DefaultTableModel();
        tbl.addColumn("Id Barang");
        tbl.addColumn("Nama Barang");
        tbl.addColumn("Harga Jual");
        tbl.addColumn("Harga Beli");
        tbl.addColumn("Kategori");
        tbl.addColumn("Deskripsi");
        tablebarang.setModel(tbl);
        try{
            Statement statement = koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery
                ("select * from barang");
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("npm"),
                    res.getString("nama"),
                    res.getString("jurusan"),
                    res.getString("jeniskelamin"),
                    res.getString("alamat"),
                });
                tablebarang.setModel(tbl);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane,"salah" +e);
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

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtidbarang = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txthargajual = new javax.swing.JTextField();
        txthargabeli = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtkategori = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdeskripsi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btambah = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        bcari = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bhapus = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablebarang = new javax.swing.JTable();
        bsimpan = new javax.swing.JButton();

        jLabel6.setText("Kategori");

        jLabel7.setText("Deskripsi");

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        jLabel1.setText("BARANG");

        jLabel2.setText("Id Barang");

        jLabel3.setText("Nama Barang");

        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        jLabel4.setText("Harga Jual");

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        jLabel5.setText("Harga Beli");

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        tablebarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Barang", "Nama Barang", "Harga Jual", "Harga Beli", "Kategori", "Deskripsi"
            }
        ));
        jScrollPane3.setViewportView(tablebarang);

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
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
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidbarang, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(txtnamabarang)
                            .addComponent(txthargajual)
                            .addComponent(txthargabeli)
                            .addComponent(txtkategori)
                            .addComponent(txtdeskripsi)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bsimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bhapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bkeluar)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txthargajual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txthargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtdeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btambah)
                            .addComponent(bcari)
                            .addComponent(bkeluar)
                            .addComponent(bhapus)
                            .addComponent(bsimpan))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        String idbarang = txtidbarang.getText();
        String namabarang = txtnamabarang.getText();
        String hargajual = txthargajual.getText();
        String hargabeli = txthargabeli.getText();
        String kategori = txtkategori.getText();
        String deskripsi = txtdeskripsi.getText();
        try{
            Statement statement = koneksi.getConnection().createStatement();
            statement.executeUpdate("insert into barang VALUES ('"
                    + idbarang + "', '" + namabarang + "', '" + hargajual + "', '" 
                    + hargabeli + "', '" + kategori +"', '" + deskripsi + "')"); 
            datatable("SELECT * FROM barang");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btambahActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        String idbarang = txtidbarang.getText();
        String namabarang = txtnamabarang.getText();
        String hargajual = txthargajual.getText();
        String hargabeli = txthargabeli.getText();
        String kategori = txtkategori.getText();
        String deskripsi = txtdeskripsi.getText();
        
        try{
                Statement statement = koneksi.getConnection().createStatement();
                ResultSet res = statement.executeQuery
                    ("SELECT * from barang where idbarang = ('" + idbarang + "');");
                DefaultTableModel tbl = new DefaultTableModel();
                tbl.addColumn("Id Barang");
                tbl.addColumn("Nama Barang");
                tbl.addColumn("Harga Jual");
                tbl.addColumn("Harga Beli"); 
                tbl.addColumn("Kategori");
                tbl.addColumn("Deskripsi");
                tablebarang.setModel(tbl);

                while(res.next()){
                    tbl.addRow(new Object[]{
                        res.getString("Id Barang"),
                        res.getString("Nama Barang"),
                        res.getString("Harga Jual"),
                        res.getString("Harga Beli"),
                        res.getString("Kategori"),
                        res.getString("Deskripsi")
                    });
                    tablebarang.setModel(tbl);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "salah" +e);
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_bcariActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        String idbarang = txtidbarang.getText();
        String namabarang = txtnamabarang.getText();
        String hargajual = txthargajual.getText();
        String hargabeli = txthargabeli.getText();
        String kategori = txtkategori.getText();
        String deskripsi = txtdeskripsi.getText();
        
            try{
                Statement statement = koneksi.getConnection().createStatement();
                statement.executeUpdate
                    ("DELETE from barang where idbarang= ('" + idbarang + "');");
                JOptionPane.showMessageDialog
                    (null, "data berhasil dihapus");
                txtidbarang.setText("");
                txtnamabarang.setText("");
                txthargajual.setText("");
                txthargabeli.setText("");
                txtkategori.setText("");
                txtdeskripsi.setText("");
            } catch (Exception t){
                JOptionPane.showMessageDialog
                (null, "Data gagal dihapus" +t);
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_bhapusActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
            dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bkeluarActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed

        String idbarang1 = txtidbarang.getText();
        String namabarang1 = txtnamabarang.getText();
        String hargajual = txthargajual.getText();
        String hargabeli = txthargabeli.getText();
        String kategori = txtkategori.getText();
        String deskripsi = txtdeskripsi.getText();

        try{
            Statement statement = koneksi.getConnection().createStatement();
            String query = "UPDATE tabmahasiswa SET " 
                + "namabarang = '" +namabarang1+ "',"
                + "hargajual = '" +hargajual+ "',"
                + "hargabeli = '" +hargabeli+ "',"
                + "kategori = '" +kategori+ "',"
                + "deskripsi = '" +deskripsi+ "'WHERE idbarang = '" +
                idbarang1+"'";
            statement.executeUpdate(query);
            datatable("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "gagal "+e);
        }
               
        // TODO add your handling code here:
    }//GEN-LAST:event_bsimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablebarang;
    private javax.swing.JTextField txtdeskripsi;
    private javax.swing.JTextField txthargabeli;
    private javax.swing.JTextField txthargajual;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtkategori;
    private javax.swing.JTextField txtnamabarang;
    // End of variables declaration//GEN-END:variables


}
