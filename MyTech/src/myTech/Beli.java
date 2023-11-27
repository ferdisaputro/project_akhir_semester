/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package myTech;

import java.awt.Color;
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
public class Beli extends javax.swing.JInternalFrame {
    Koneksi koneksi = new Koneksi();
    String sql;
    /**
     * Creates new form Beli
     */
    public Beli() {
        initComponents();
        datatable("");
        setSupplier();
        autosum(); 
        txtidbarang.setBackground(new Color (0,0,0,0));
        txtidbarang.setBorder(null);
        txtnamabarang.setBackground(new Color (0,0,0,0));
        txtnamabarang.setBorder(null);
        txthargasatuan.setBackground(new Color (0,0,0,0));
        txthargasatuan.setBorder(null);
        txtjumlahbarang.setBackground(new Color (0,0,0,0));
        txtjumlahbarang.setBorder(null);
        txttotal.setBackground(new Color (0,0,0,0));
        txttotal.setBorder(null);
        txtuang.setBackground(new Color (0,0,0,0));
        txtuang.setBorder(null);
        txtkembalian.setBackground(new Color (0,0,0,0));
        txtkembalian.setBorder(null);
        tglpembelian.setBackground(new Color (0,0,0,0));
        tglpembelian.setBorder(null);
        btambah.setBackground(new Color (0,0,0,0));
        btambah.setBorder(null);
        Csupplier.setBackground(new Color (0,0,0,0));
        Csupplier.setBorder(null);
        bproses.setBackground(new Color (0,0,0,0));
        bproses.setBorder(null);
        bhapus.setBackground(new Color (0,0,0,0));
        bhapus.setBorder(null);
    }
    
    private void setSupplier () {
        try {
            Statement stat = koneksi.GetConnection().createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM supplier");
            while(res.next()) Csupplier.addItem(res.getString("nama"));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error "+e);
        }
    }
 
    private void autosum (){
        int total = 0;
        
        for (int i = 0; i <tablebarangfiks.getRowCount(); i++){
            int amount = Integer.parseInt((String)tablebarangfiks.getValueAt(i,4));
            total += amount;
        }
        txttotal.setText(""+total);
    }   
    
    private void datatable(String select_from_beli) {
        
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
            if (select_from_beli.equals("")) {
                sql = "SELECT barang.*, kategori.nama as kategori FROM `barang` inner join kategori on barang.id_kategori = kategori.id_kategori";
            } else {
                sql = select_from_beli;
            }
            ResultSet res = statement.executeQuery(sql);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txttotal = new javax.swing.JTextField();
        txtuang = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        txtjumlahbarang = new javax.swing.JTextField();
        btambah = new javax.swing.JButton();
        bproses = new javax.swing.JButton();
        Csupplier = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablebarangsementara = new javax.swing.JTable();
        txthargasatuan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablebarangfiks = new javax.swing.JTable();
        bhapus = new javax.swing.JButton();
        tglpembelian = new com.github.lgooddatepicker.components.DatePicker();
        jLabel18 = new javax.swing.JLabel();
        txtidbarang = new javax.swing.JTextField();
        BJual = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txttotal.setBorder(null);
        txttotal.setForeground(new java.awt.Color(255, 255, 255));
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, 290, 30));

        txtuang.setBorder(null);
        txtuang.setForeground(new java.awt.Color(255, 255, 255));
        txtuang.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtuangCaretUpdate(evt);
            }
        });
        txtuang.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtuangInputMethodTextChanged(evt);
            }
        });
        txtuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuangActionPerformed(evt);
            }
        });
        txtuang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtuangKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtuangKeyTyped(evt);
            }
        });
        getContentPane().add(txtuang, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 290, 30));

        txtnamabarang.setBorder(null);
        txtnamabarang.setForeground(new java.awt.Color(255, 255, 255));
        txtnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamabarangActionPerformed(evt);
            }
        });
        getContentPane().add(txtnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, 80, 30));

        txtkembalian.setBorder(null);
        txtkembalian.setForeground(new java.awt.Color(255, 255, 255));
        txtkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembalianActionPerformed(evt);
            }
        });
        txtkembalian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkembalianKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkembalianKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtkembalianKeyTyped(evt);
            }
        });
        getContentPane().add(txtkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, 290, 30));

        txtjumlahbarang.setBorder(null);
        txtjumlahbarang.setForeground(new java.awt.Color(255, 255, 255));
        txtjumlahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahbarangActionPerformed(evt);
            }
        });
        getContentPane().add(txtjumlahbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 150, 90, 30));

        btambah.setBorder(null);
        btambah.setForeground(new java.awt.Color(255, 255, 255));
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });
        getContentPane().add(btambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 150, 40, 30));

        bproses.setBorder(null);
        bproses.setForeground(new java.awt.Color(255, 255, 255));
        bproses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprosesActionPerformed(evt);
            }
        });
        getContentPane().add(bproses, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 590, 110, 30));

        Csupplier.setBorder(null);
        Csupplier.setForeground(new java.awt.Color(255, 255, 255));
        Csupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsupplierActionPerformed(evt);
            }
        });
        getContentPane().add(Csupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 170, 30));

        jLabel3.setText("Nama Barang");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, -1, -1));

        jLabel8.setText("jumlah barang");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, -1, -1));

        tablebarangsementara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Barang", "Nama barang", "Kategori", "Harga Jual", "Harga Beli", "Stok", "Deskripsi", "Satuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablebarangsementara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebarangsementaraMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablebarangsementaraMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tablebarangsementara);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 430, 390));

        txthargasatuan.setBorder(null);
        txthargasatuan.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txthargasatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 90, 30));

        jLabel9.setText("Harga satuan");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, -1, -1));

        tablebarangfiks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_barang", "Nama Barang", "Harga Satuan", "Jumlah Barang", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablebarangfiks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablebarangfiksMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tablebarangfiks);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 430, 160));

        bhapus.setBorder(null);
        bhapus.setForeground(new java.awt.Color(255, 255, 255));
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        getContentPane().add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 380, 120, 30));

        tglpembelian.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tglpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 260, 30));

        jLabel18.setText("Tanggal Transaksi Pembelian");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 166, -1));

        txtidbarang.setBorder(null);
        txtidbarang.setForeground(new java.awt.Color(255, 255, 255));
        txtidbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidbarangActionPerformed(evt);
            }
        });
        getContentPane().add(txtidbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 80, 30));

        BJual.setBorder(null);
        BJual.setForeground(new java.awt.Color(255, 255, 255));
        BJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BJualActionPerformed(evt);
            }
        });
        getContentPane().add(BJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 120, 40));

        jLabel4.setText("Id Barang");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_component_asset/Pembelian.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setText("Nama Supplier");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamabarangActionPerformed

    private void CsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CsupplierActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        String idbarang = txtidbarang.getText();
        String namabarang = txtnamabarang.getText();
        int hargasatuan = Integer.parseInt(txthargasatuan.getText());
        int jumlahbarang = Integer.parseInt(txtjumlahbarang.getText());
        
        int subtotal = hargasatuan*jumlahbarang;
        
        DefaultTableModel tbl= (DefaultTableModel) tablebarangfiks.getModel();
        tbl.addRow(new Object[]{
            String.valueOf (idbarang),
            namabarang,
            String.valueOf(hargasatuan),
            String.valueOf(jumlahbarang),
            String.valueOf(subtotal)
        });
        autosum();
    }//GEN-LAST:event_btambahActionPerformed

    private void tablebarangsementaraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebarangsementaraMouseReleased
        // TODO add your handling code here:
        int row = tablebarangsementara.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel) tablebarangsementara.getModel();
        txtidbarang.setText(table.getValueAt(row, 0).toString());        
        txtnamabarang.setText(table.getValueAt(row, 1).toString());
        txthargasatuan.setText(table.getValueAt(row, 4).toString());
        
    }//GEN-LAST:event_tablebarangsementaraMouseReleased

    private void tablebarangsementaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebarangsementaraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablebarangsementaraMouseClicked

    private void tablebarangfiksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebarangfiksMouseReleased
        
        // TODO add your handling code here:
    }//GEN-LAST:event_tablebarangfiksMouseReleased

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        String idbarang = txtidbarang.getText();                               
        String namabarang = txtnamabarang.getText();
        int hargasatuan = Integer.parseInt(txthargasatuan.getText());
        int jumlahbarang = Integer.parseInt(txtjumlahbarang.getText());
        int subtotal = hargasatuan*jumlahbarang;
        
        int row = tablebarangfiks.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel) tablebarangfiks.getModel();
        table.removeRow(row);
    }//GEN-LAST:event_bhapusActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        String idbarang = txtidbarang.getText();
        String namabarang = txtnamabarang.getText();
        int hargasatuan = Integer.parseInt(txthargasatuan.getText());
        int jumlahbarang = Integer.parseInt(txtjumlahbarang.getText());
        int subtotal = hargasatuan*jumlahbarang;
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembalianActionPerformed
        
    }//GEN-LAST:event_txtkembalianActionPerformed

    private void txtuangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuangKeyReleased

    }//GEN-LAST:event_txtuangKeyReleased

    private void txtkembalianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkembalianKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtkembalianKeyPressed

    private void txtkembalianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkembalianKeyReleased

    }//GEN-LAST:event_txtkembalianKeyReleased

    private void txtuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuangActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuangActionPerformed

    private void bprosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprosesActionPerformed
        int uangpembayaran = Integer.parseInt(txtuang.getText());
        int total = Integer.parseInt(txttotal.getText());
        int uangkembalian = Integer.parseInt(txtkembalian.getText());
        LocalDate tgltransaksi = tglpembelian.getDate();
        int jumlahbarang = Integer.parseInt(txtjumlahbarang.getText());
        int subtotal = Integer.getInteger(sql);
        LocalDate currentDate = LocalDate.now();

        Koneksi cn = new Koneksi();
        try {
           Statement statement = koneksi.GetConnection().createStatement();
           statement.executeUpdate("insert into pembelian(total,uang,kembalian,tanggal_transaksi) "
                   + "VALUES ('"+total+"','"+uangpembayaran+"','"+uangkembalian+"','"+tgltransaksi+"')"); 
           ResultSet res =  statement.executeQuery("SELECT * FROM pembelian WHERE total = '"+total+"' AND uang = '"+uangpembayaran+"' AND kembalian = '"+uangkembalian+"' AND tanggal_transaksi = '"+tgltransaksi+"'"); 
            if (res.next()) {
                String idpembelian = res.getString("id_pembelian");
                
                for (int i = 0; i <tablebarangfiks.getRowCount(); i++){
                String idbarang = tablebarangfiks.getValueAt(i,0).toString();
                String namabarang = tablebarangfiks.getValueAt(i,1).toString();
                String jumlahbarang1 = tablebarangfiks.getValueAt(i,3).toString();
                String subtotal1 = tablebarangfiks.getValueAt(i,4).toString();
                } 
            }
            statement.executeUpdate("insert into detail_pembelian(jumlah_barang,sub_total,created_at) "
                   + "VALUES ('"+jumlahbarang+"','"+subtotal+"','"+currentDate+"')");
        datatable("");
        } catch(Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bprosesActionPerformed

    private void txtuangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuangKeyTyped
 
    // TODO add your handling code here:
    }//GEN-LAST:event_txtuangKeyTyped

    private void txtkembalianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkembalianKeyTyped

    }//GEN-LAST:event_txtkembalianKeyTyped

    private void txtidbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidbarangActionPerformed

    private void txtuangInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtuangInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuangInputMethodTextChanged

    private void txtuangCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtuangCaretUpdate
        // TODO add your handling code here:
        int uangpembayaran = Integer.parseInt(txtuang.getText());
        int total = Integer.parseInt(txttotal.getText());
        int uangkembalian = uangpembayaran - total;
        txtkembalian.setText(String.valueOf(uangkembalian)); 
    }//GEN-LAST:event_txtuangCaretUpdate

    private void txtjumlahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumlahbarangActionPerformed

    private void BJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BJualActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BJual;
    private javax.swing.JComboBox<String> Csupplier;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bproses;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablebarangfiks;
    private javax.swing.JTable tablebarangsementara;
    private com.github.lgooddatepicker.components.DatePicker tglpembelian;
    private javax.swing.JTextField txthargasatuan;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtjumlahbarang;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txtuang;
    // End of variables declaration//GEN-END:variables
}
