/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package myTech;

import java.awt.event.MouseEvent;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Jual extends javax.swing.JInternalFrame {
    String string;
    /**
     * Creates new form Jual
     */
    public Jual() {
        initComponents();
    }

    private void autosum (){
        int total = 0;
        for (int i = 0; i <tablebarangfiks1.getRowCount(); i++){
            int amount = Integer.parseInt((String)tablebarangfiks1.getValueAt(i,4));
            total += amount;
        }
        txttotalharga.setText(""+total);
    }
    private void datatable(String select_from_jual) {
        
        DefaultTableModel tbl=new DefaultTableModel();
        tbl.addColumn("Id Barang");
        tbl.addColumn("Nama Barang");
        tbl.addColumn("Kategori");
        tbl.addColumn("Harga Jual");
        tbl.addColumn("Harga Beli");
        tbl.addColumn("Stok");
        tbl.addColumn("Deskripsi");
        tbl.addColumn("Satuan");
        tablebarangsementara.setModel(tbl);
        try{
            Statement statement = koneksi.GetConnection().createStatement();
            if (select_from_jual.equals("")) {
                sql = "SELECT barang.*, kategori.nama as kategori FROM barang inner join kategori on barang.id_kategori = kategori.id_kategori";
            } else {
                sql = select_from_jual;
            }
    ResultSet res = statement.executeQuery
                (sql);
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama"),
                    res.getString("kategori"),
                    res.getString("harga_jual"),
                    res.getString("harga_beli"),
                    res.getString("jumlah_stok"),
                    res.getString("deskripsi"),
                    res.getString("satuan"),
                });
                tablebarangsementara.setModel(tbl);
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
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */    
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bproses = new javax.swing.JButton();
        txtdiskon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttotalharga = new javax.swing.JTextField();
        txtuang = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        txtjumlahbarang = new javax.swing.JTextField();
        btambah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablebarangsementara = new javax.swing.JTable();
        txthargasatuan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bhapus = new javax.swing.JButton();
        txtidbarang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tglpenjualan = new com.github.lgooddatepicker.components.DatePicker();
        jLabel12 = new javax.swing.JLabel();
        txttotalpembayaran = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebarangfiks1 = new javax.swing.JTable();

        jLabel1.setText("PENJUALAN");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel7.setText("uang kembalian");

        bproses.setText("proses");

        jLabel4.setText("diskon");

        jLabel5.setText("total harga");

        txttotalharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalhargaActionPerformed(evt);
            }
        });

        txtuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuangActionPerformed(evt);
            }
        });

        txtnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamabarangActionPerformed(evt);
            }
        });

        txtkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembalianActionPerformed(evt);
            }
        });
        txtkembalian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtkembalianKeyTyped(evt);
            }
        });

        btambah.setText("tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        jLabel6.setText("uang yang dibayar");

        tablebarangsementara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Barang", "Nama Barang", "Kategori", "Harga Jual", "Harga Beli", "Jumlah Stock", "Deskripsi", "Satuan"
            }
        ));
        tablebarangsementara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablebarangsementaraMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tablebarangsementara);

        jLabel8.setText("Nama Barang");

        jLabel9.setText("Harga Satuan");

        jLabel10.setText("jumlah Barang");

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        txtidbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidbarangActionPerformed(evt);
            }
        });

        jLabel11.setText("Id Barang");

        jLabel12.setText("Tanggal Transaksi Penjualan");

        txttotalpembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalpembayaranActionPerformed(evt);
            }
        });
        txttotalpembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttotalpembayaranKeyTyped(evt);
            }
        });

        jLabel13.setText("total pembayaran");

        tablebarangfiks1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Barang", "Nama Barang", "Harga Satuan", "Jumlah Barang", "Subtotal"
            }
        ));
        tablebarangfiks1.setMinimumSize(new java.awt.Dimension(120, 80));
        tablebarangfiks1.setPreferredSize(new java.awt.Dimension(600, 80));
        tablebarangfiks1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablebarangfiks1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablebarangfiks1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tablebarangsementaraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebarangsementaraMouseReleased
        // TODO add your handling code here:
        int row = tablebarangsementara.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel) tablebarangsementara.getModel();
        txtidbarang.setText(table.getValueAt(row, 0).toString());
        txtnamabarang.setText(table.getValueAt(row, 1).toString());
        txthargasatuan.setText(table.getValueAt(row, 3).toString());

    }//GEN-LAST:event_tablebarangsementaraMouseReleased

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        String idbarang = txtidbarang.getText();
        String namabarang = txtnamabarang.getText();
        int hargasatuan = Integer.parseInt(txthargasatuan.getText());
        int jumlahbarang = Integer.parseInt(txtjumlahbarang.getText());
        
        int subtotal = hargasatuan*jumlahbarang;
        
        DefaultTableModel tbl= (DefaultTableModel) tablebarangfiks1.getModel();
        tbl.addRow(new Object[]{
            String.valueOf(idbarang),
            namabarang,
            String.valueOf(hargasatuan),
            String.valueOf(jumlahbarang),
            String.valueOf(subtotal)
        });
        autosum();
    }//GEN-LAST:event_btambahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        String idbarang = txtidbarang.getText();
        String namabarang = txtnamabarang.getText();
        int hargasatuan = Integer.parseInt(txthargasatuan.getText());
        int jumlahbarang = Integer.parseInt(txtjumlahbarang.getText());
        int subtotal = hargasatuan*jumlahbarang;
        
        int row = tablebarangfiks1.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel) tablebarangfiks1.getModel();
        table.removeRow(row);

    }//GEN-LAST:event_bhapusActionPerformed

    private void txttotalhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalhargaActionPerformed
        // TODO add your handling code here:
        String idbarang = txtidbarang.getText();
        String namabarang = txtnamabarang.getText();
        int hargasatuan = Integer.parseInt(txthargasatuan.getText());
        int jumlahbarang = Integer.parseInt(txtjumlahbarang.getText());
        int subtotal = hargasatuan*jumlahbarang;
        
        autosum ();
        
        // TODO add your handling code here:

    }//GEN-LAST:event_txttotalhargaActionPerformed

    private void txtkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembalianActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

    }//GEN-LAST:event_txtkembalianActionPerformed

    private void txtnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamabarangActionPerformed

    private void txtidbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidbarangActionPerformed

    private void txttotalpembayaranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalpembayaranKeyTyped
        // TODO add your handling code here:
        int totalharga1 = Integer.parseInt(txttotalharga.getText());
        int diskon = Integer.parseInt(txtdiskon.getText());
        int totalpembayaran = totalharga1 - diskon;
        txttotalpembayaran.setText(""+totalpembayaran);   
    }//GEN-LAST:event_txttotalpembayaranKeyTyped

    private void txtkembalianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkembalianKeyTyped
        // TODO add your handling code here:
        int uangpembayaran = Integer.parseInt(txtuang.getText());
        int totalpembayaran = Integer.parseInt(txttotalpembayaran.getText());
        int uangkembalian = uangpembayaran - totalpembayaran;
        txtkembalian.setText(""+uangkembalian);
    }//GEN-LAST:event_txtkembalianKeyTyped

    private void txttotalpembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalpembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalpembayaranActionPerformed

    private void txtuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuangActionPerformed

    private void tablebarangfiks1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebarangfiks1MouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablebarangfiks1MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bproses;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablebarangfiks1;
    private javax.swing.JTable tablebarangsementara;
    private com.github.lgooddatepicker.components.DatePicker tglpenjualan;
    private javax.swing.JTextField txtdiskon;
    private javax.swing.JTextField txthargasatuan;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtjumlahbarang;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txttotalharga;
    private javax.swing.JTextField txttotalpembayaran;
    private javax.swing.JTextField txtuang;
    // End of variables declaration//GEN-END:variables
}
