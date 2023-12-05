/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package myTech;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Jual extends javax.swing.JFrame {
    Koneksi koneksi = new Koneksi();
    String sql;
    /**
     * Creates new form Jual
     */
    public Jual() {
        initComponents();
        datatable("");
        txtidbarang.setBackground(new Color (0,0,0,0));
        txtidbarang.setBorder(null);
        txtnamabarang.setBackground(new Color (0,0,0,0));
        txtnamabarang.setBorder(null);
        txthargasatuan.setBackground(new Color (0,0,0,0));
        txthargasatuan.setBorder(null);
        txtjumlahbarang.setBackground(new Color (0,0,0,0));
        txtjumlahbarang.setBorder(null);
        txttotalharga.setBackground(new Color (0,0,0,0));
        txttotalharga.setBorder(null);
        txtdiskon.setBackground(new Color (0,0,0,0));
        txtdiskon.setBorder(null);
        txttotalpembayaran.setBackground(new Color (0,0,0,0));
        txttotalpembayaran.setBorder(null);
        txtuang.setBackground(new Color (0,0,0,0));
        txtuang.setBorder(null);
        txtkembalian.setBackground(new Color (0,0,0,0));
        txtkembalian.setBorder(null);
        tglpenjualan.setBackground(new Color (0,0,0,0));
        tglpenjualan.setBorder(null);
        btambah.setBackground(new Color (0,0,0,0));
        btambah.setBorder(null);
        bproses.setBackground(new Color (0,0,0,0));
        bproses.setBorder(null);
        bhapus.setBackground(new Color (0,0,0,0));
        bhapus.setBorder(null);     
    }
    private void autosum (){
        int total = 0;
        for (int i = 0; i <tablebarangfiks1.getRowCount(); i++){
            int amount = Integer.parseInt(tablebarangfiks1.getValueAt(i,4).toString());
            total += amount;
        }
        txttotalharga.setText(""+total);
        int diskon = Integer.parseInt(txtdiskon.getText());
        txttotalpembayaran.setText(""+(total-diskon));
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
    
    void resetTambah() {
        txtidbarang.setText("");
        txtnamabarang.setText("");
        txthargasatuan.setText("");
        txtjumlahbarang.setText("");
    }
    
    void uangUpdate() {
        int totalPembayaran = Integer.parseInt(txttotalpembayaran.getText());
        int uang = Integer.parseInt(txtuang.getText());
        int kembalian = uang-totalPembayaran;
        txtkembalian.setText(String.valueOf(kembalian));
    }
    
    void diskonUpdate() {
        int totalHarga = Integer.parseInt(txttotalharga.getText());
        int diskon = Integer.parseInt(txtdiskon.getText());
        int totalPembayaran = totalHarga - diskon;
        txttotalpembayaran.setText(String.valueOf(totalPembayaran));
    }
    
    void resetJual() {
        DefaultTableModel tableModel = (DefaultTableModel) tablebarangfiks1.getModel();
        tableModel.setRowCount(0);
        autosum();
        txtuang.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        bproses = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtdiskon = new javax.swing.JTextField();
        txttotalharga = new javax.swing.JTextField();
        txtuang = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        txttotalpembayaran = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        btambah = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablebarangsementara = new javax.swing.JTable();
        txthargasatuan = new javax.swing.JTextField();
        txtjumlahbarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bhapus = new javax.swing.JButton();
        txtidbarang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tglpenjualan = new com.github.lgooddatepicker.components.DatePicker();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebarangfiks1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Keluar");
        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setBorder(null);
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 650, 110, 30));

        bproses.setForeground(new java.awt.Color(255, 255, 255));
        bproses.setBorder(null);
        bproses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprosesActionPerformed(evt);
            }
        });
        getContentPane().add(bproses, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 603, 120, 30));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 130, 30));

        txtdiskon.setBorder(null);
        txtdiskon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtdiskonCaretUpdate(evt);
            }
        });
        getContentPane().add(txtdiskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 300, 40));

        txttotalharga.setBorder(null);
        txttotalharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalhargaActionPerformed(evt);
            }
        });
        getContentPane().add(txttotalharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 300, 40));

        txtuang.setBorder(null);
        txtuang.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtuangCaretUpdate(evt);
            }
        });
        txtuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuangActionPerformed(evt);
            }
        });
        getContentPane().add(txtuang, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 300, 40));

        txtkembalian.setBorder(null);
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
        getContentPane().add(txtkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 600, 300, 40));

        txttotalpembayaran.setBorder(null);
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
        getContentPane().add(txttotalpembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, 300, 40));

        txtnamabarang.setForeground(new java.awt.Color(255, 255, 255));
        txtnamabarang.setBorder(null);
        txtnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamabarangActionPerformed(evt);
            }
        });
        getContentPane().add(txtnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 80, 30));

        btambah.setForeground(new java.awt.Color(255, 255, 255));
        btambah.setBorder(null);
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });
        getContentPane().add(btambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 150, 40, 30));

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

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 440, 410));

        txthargasatuan.setForeground(new java.awt.Color(255, 255, 255));
        txthargasatuan.setBorder(null);
        getContentPane().add(txthargasatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, 90, 30));

        txtjumlahbarang.setForeground(new java.awt.Color(255, 255, 255));
        txtjumlahbarang.setBorder(null);
        getContentPane().add(txtjumlahbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 150, 90, 30));

        jLabel8.setText("Nama Barang");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, -1, -1));

        jLabel9.setText("Harga Satuan");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, -1, -1));

        jLabel10.setText("jumlah Barang");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 130, -1, -1));

        bhapus.setForeground(new java.awt.Color(255, 255, 255));
        bhapus.setBorder(null);
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        getContentPane().add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 380, 120, 30));

        txtidbarang.setForeground(new java.awt.Color(255, 255, 255));
        txtidbarang.setBorder(null);
        txtidbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidbarangActionPerformed(evt);
            }
        });
        getContentPane().add(txtidbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 90, 30));

        jLabel11.setText("Id Barang");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, -1, -1));

        tglpenjualan.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tglpenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 149, 302, 30));

        jLabel12.setText("Tanggal Transaksi Penjualan");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 440, 150));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_component_asset/Penjualan.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bprosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprosesActionPerformed
        int idAdmin = admin.UserAdmin.getId();
        String total = txttotalpembayaran.getText();
        String diskon = txtdiskon.getText();
        String uang = txtuang.getText();
        String kembalian = txtkembalian.getText();
        String tglTransaksi = tglpenjualan.getDateStringOrEmptyString();
        Statement stat;
        LocalDate currentDate = LocalDate.now();
        if (tglTransaksi == "") {
            JOptionPane.showMessageDialog(null, "Tanggal Transaksi tidak boleh kosong");
            return;
        }
        try {
            stat = koneksi.GetConnection().createStatement();
            sql = "INSERT INTO penjualan(id_admin, total, diskon, tanggal_transaksi) VALUES "
            + "('"+idAdmin+"','"+total+"','"+diskon+"','"+tglTransaksi+"')";
            stat.executeUpdate(sql, stat.RETURN_GENERATED_KEYS);
            ResultSet res = stat.getGeneratedKeys();
            if (res.next()) {
                String idPenjualan = res.getString(1);
                DefaultTableModel tableModel = (DefaultTableModel) tablebarangfiks1.getModel();
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String idBarang = tableModel.getValueAt(i, 0).toString();
                    String jumlahBarang = tableModel.getValueAt(i, 3).toString();
                    String subTotal = tableModel.getValueAt(i, 4).toString();
                    sql = "INSERT INTO detail_penjualan(id_penjualan, id_barang, jumlah_barang, sub_total, created_at) VALUES "
                    + "('"+idPenjualan+"','"+idBarang+"','"+jumlahBarang+"','"+subTotal+"','"+currentDate+"')";
                    if (stat.executeUpdate(sql) > 0) {
                        sql = "UPDATE barang SET jumlah_stok = jumlah_stok - "+jumlahBarang+" where id_barang = "+idBarang;
                        stat.executeUpdate(sql);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Transaksi berhasil diproses");
            datatable("");
            Jual jual = new Jual();
            jual.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Transaksi gagal diproses "+e);
        }
    }//GEN-LAST:event_bprosesActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Beli beli = new Beli();
        beli.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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

    private void txtuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuangActionPerformed

    private void txtnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamabarangActionPerformed

    private void txtkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembalianActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkembalianActionPerformed

    private void txtkembalianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkembalianKeyTyped
        // TODO add your handling code here:
        int uangpembayaran = Integer.parseInt(txtuang.getText());
        int totalpembayaran = Integer.parseInt(txttotalpembayaran.getText());
        int uangkembalian = uangpembayaran - totalpembayaran;
        txtkembalian.setText(""+uangkembalian);
    }//GEN-LAST:event_txtkembalianKeyTyped

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        String idbarang = txtidbarang.getText();
        String namabarang = txtnamabarang.getText();
        int hargasatuan = Integer.parseInt(txthargasatuan.getText());
        int jumlahbarang = Integer.parseInt(txtjumlahbarang.getText());
//        int diskon = Integer.parseInt(txtdiskon.getText());
        int subtotal = hargasatuan*jumlahbarang;

        DefaultTableModel tbl= (DefaultTableModel) tablebarangfiks1.getModel();
        tbl.addRow(new Object[]{
            idbarang,
            namabarang,
            String.valueOf(hargasatuan),
            String.valueOf(jumlahbarang),
            String.valueOf(subtotal)
        });
        resetTambah();
        autosum();
    }//GEN-LAST:event_btambahActionPerformed

    private void tablebarangsementaraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebarangsementaraMouseReleased
        // TODO add your handling code here:
        int row = tablebarangsementara.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel) tablebarangsementara.getModel();
        txtidbarang.setText(table.getValueAt(row, 0).toString());
        txtnamabarang.setText(table.getValueAt(row, 1).toString());
        txthargasatuan.setText(table.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tablebarangsementaraMouseReleased

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        String idbarang = txtidbarang.getText();
        String namabarang = txtnamabarang.getText();
        int hargasatuan = Integer.parseInt(txthargasatuan.getText());
        int jumlahbarang = Integer.parseInt(txtjumlahbarang.getText());
        int diskon = Integer.parseInt(txtdiskon.getText());

        int subtotal = hargasatuan*jumlahbarang-diskon;

        int row = tablebarangfiks1.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel) tablebarangfiks1.getModel();
        table.removeRow(row);
        autosum();
        uangUpdate();
        diskonUpdate();
    }//GEN-LAST:event_bhapusActionPerformed

    private void txtidbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidbarangActionPerformed

    private void txttotalpembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalpembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalpembayaranActionPerformed

    private void txttotalpembayaranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalpembayaranKeyTyped
        // TODO add your handling code here:
        int totalharga1 = Integer.parseInt(txttotalharga.getText());
        int diskon = Integer.parseInt(txtdiskon.getText());
        int totalpembayaran = totalharga1 - diskon;
        txttotalpembayaran.setText(""+totalpembayaran);
    }//GEN-LAST:event_txttotalpembayaranKeyTyped

    private void tablebarangfiks1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebarangfiks1MouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tablebarangfiks1MouseReleased

    private void txtdiskonCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtdiskonCaretUpdate
        // TODO add your handling code here:
        int totalharga1 = Integer.parseInt(txttotalharga.getText());
        int diskon = Integer.parseInt(txtdiskon.getText());
        int totalpembayaran = totalharga1 - diskon;
        txttotalpembayaran.setText(""+totalpembayaran);
    }//GEN-LAST:event_txtdiskonCaretUpdate

    private void txtuangCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtuangCaretUpdate
        // TODO add your handling code here:
        int uangpembayaran = Integer.parseInt(txtuang.getText());
        int total = Integer.parseInt(txttotalpembayaran.getText());
        int uangkembalian = uangpembayaran - total;
        txtkembalian.setText(String.valueOf(uangkembalian)); 
    }//GEN-LAST:event_txtuangCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (admin.UserAdmin.getName() == null) {
                    Login login = new Login();
                    login.setVisible(true);
                    login.setExtendedState(Login.MAXIMIZED_BOTH);
                } else {
                    new Jual().setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bproses;
    private javax.swing.JButton btambah;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
