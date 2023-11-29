/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package myTech;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author USER
 */
public class Laporan extends javax.swing.JInternalFrame {
    Koneksi cn = new Koneksi();
    DefaultTableModel tableModel;
    Statement stat;
    String sql;
    
    /**
     * Creates new form Laporan
     */
    public Laporan() {
        initComponents();
    }
    
    void resetTablePenjualan() {
        tableModel = (DefaultTableModel) tablePenjualan.getModel();
        tableModel.setRowCount(0);
    }
    
    void resetTablePembelian() {
        tableModel = (DefaultTableModel) tablePembelian.getModel();
        tableModel.setRowCount(0);
    }
    
    void tampilPembelian() {
        String start = tanggalMulai.getDateStringOrEmptyString();
        String end = tanggalAkhir.getDateStringOrEmptyString();
        resetTablePembelian();
        try {
            stat = cn.GetConnection().createStatement();
            sql = "select * from pembelian "
                    + "inner join detail_pembelian on pembelian.id_pembelian = detail_pembelian.id_pembelian "
                    + "INNER JOIN barang on detail_pembelian.id_barang = barang.id_barang "
                    + "where pembelian.tanggal_transaksi between \""+start+"\" and \""+end+"\"";
            ResultSet res = stat.executeQuery(sql);
            tableModel = (DefaultTableModel) tablePembelian.getModel();
            while (res.next()) {                
                tableModel.addRow(new Object[] {
                    res.getString("id_pembelian"),
                    res.getString("tanggal_transaksi"),
                    res.getString("nama"),
                    res.getString("jumlah_barang"),
                    res.getString("sub_total"),
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void tampilPenjualan() {
        String start = tanggalMulai.getDateStringOrEmptyString();
        String end = tanggalAkhir.getDateStringOrEmptyString();
        resetTablePenjualan();
        try {
            stat = cn.GetConnection().createStatement();
            sql = "SELECT penjualan.*, detail_penjualan.*, barang.nama AS nama_barang, admin.nama AS nama_admin FROM penjualan "
                    + "INNER JOIN detail_penjualan ON penjualan.id_penjualan = detail_penjualan.id_penjualan "
                    + "INNER JOIN barang ON detail_penjualan.id_barang = barang.id_barang "
                    + "INNER JOIN admin ON penjualan.id_admin = admin.id_admin "
                    + "WHERE penjualan.tanggal_transaksi between \""+start+"\" and \""+end+"\"";
            ResultSet res = stat.executeQuery(sql);
            tableModel = (DefaultTableModel) tablePenjualan.getModel();
            while (res.next()) {                
                tableModel.addRow(new Object[] {
                    res.getString("id_penjualan"),
                    res.getString("tanggal_transaksi"),
                    res.getString("nama_barang"),
                    res.getString("nama_admin"),
                    res.getString("jumlah_barang"),
                    res.getString("sub_total"),
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void countFieldText() {
        try {
            stat = cn.GetConnection().createStatement();
            String sql = "SELECT (SELECT SUM(total) FROM penjualan) AS total_penjualan, (SELECT SUM(total) FROM pembelian) AS total_pembelian";
            ResultSet res = stat.executeQuery(sql);
            if (res.next()) {
                String penjualan = res.getString("total_penjualan");
                String pembelian = res.getString("total_pembelian");
                String labaPenjualan = String.valueOf(Integer.parseInt(penjualan) - Integer.parseInt(pembelian));
                pendapatanPenjualan.setText(penjualan);
                totalPembelian.setText(pembelian);
                laba.setText(labaPenjualan);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void lineChart(String tableName) {
        String start = tanggalMulai.getDateStringOrEmptyString();
        String end = tanggalAkhir.getDateStringOrEmptyString();
        try {
            stat = cn.GetConnection().createStatement();
            sql = "SELECT tanggal_transaksi, total FROM "+tableName.toLowerCase() +" WHERE "+tableName.toLowerCase()+".tanggal_transaksi between \""+start+"\" and \""+end+"\" order by tanggal_transaksi desc";
            ResultSet res = stat.executeQuery(sql);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            while(res.next()){
                dataset.addValue(Integer.parseInt(res.getString("total")), tableName, res.getString("tanggal_transaksi"));
            }
            JFreeChart chart = ChartFactory.createLineChart("Line Chart Penjualan", "", "", dataset);
            CategoryPlot plot = chart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.YELLOW);

            ChartFrame frame = new ChartFrame("Line Chart", chart);
            if (tableName.toLowerCase().equals("pembelian")) {
                panelPembelian.add(frame.getContentPane());
                frame.setSize(panelPembelian.getWidth(), panelPembelian.getHeight()+60);
            } else {
                panelPenjualan.add(frame.getContentPane());
                frame.setSize(panelPenjualan.getWidth(), panelPenjualan.getHeight()+60);
            }
            frame.setState(ChartFrame.ICONIFIED);
            frame.setVisible(true);
            frame.setAlwaysOnTop(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        pendapatanPenjualan = new javax.swing.JTextField();
        totalPembelian = new javax.swing.JTextField();
        laba = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePenjualan = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePembelian = new javax.swing.JTable();
        tanggalMulai = new com.github.lgooddatepicker.components.DatePicker();
        tanggalAkhir = new com.github.lgooddatepicker.components.DatePicker();
        panelPenjualan = new javax.swing.JPanel();
        panelPembelian = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pendapatanPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendapatanPenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(pendapatanPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 310, -1));
        getContentPane().add(totalPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 310, -1));
        getContentPane().add(laba, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 640, 310, -1));

        jButton1.setText("LIHAT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 93, -1));

        tablePenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Penjualan", "Tanggal Penjualan", "Nama Barang", "Admin", "Jumlah Barang", "Sub Total"
            }
        ));
        jScrollPane1.setViewportView(tablePenjualan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 450, 140));

        tablePembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Transaksi", "Tanggal Transaksi", "Nama Barang", "Jumlah Barang", "Sub Total"
            }
        ));
        jScrollPane2.setViewportView(tablePembelian);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 417, -1, 140));
        getContentPane().add(tanggalMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 220, -1));
        getContentPane().add(tanggalAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 220, -1));

        panelPenjualan.setPreferredSize(new java.awt.Dimension(500, 158));

        javax.swing.GroupLayout panelPenjualanLayout = new javax.swing.GroupLayout(panelPenjualan);
        panelPenjualan.setLayout(panelPenjualanLayout);
        panelPenjualanLayout.setHorizontalGroup(
            panelPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelPenjualanLayout.setVerticalGroup(
            panelPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        getContentPane().add(panelPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 822, -1, -1));

        javax.swing.GroupLayout panelPembelianLayout = new javax.swing.GroupLayout(panelPembelian);
        panelPembelian.setLayout(panelPembelianLayout);
        panelPembelianLayout.setHorizontalGroup(
            panelPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );
        panelPembelianLayout.setVerticalGroup(
            panelPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        getContentPane().add(panelPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 822, 478, 158));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_component_asset/laporan fix.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pendapatanPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendapatanPenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendapatanPenjualanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tampilPembelian();
        tampilPenjualan();
        countFieldText();
        lineChart("pembelian");
        lineChart("penjualan");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField laba;
    private javax.swing.JPanel panelPembelian;
    private javax.swing.JPanel panelPenjualan;
    private javax.swing.JTextField pendapatanPenjualan;
    private javax.swing.JTable tablePembelian;
    private javax.swing.JTable tablePenjualan;
    private com.github.lgooddatepicker.components.DatePicker tanggalAkhir;
    private com.github.lgooddatepicker.components.DatePicker tanggalMulai;
    private javax.swing.JTextField totalPembelian;
    // End of variables declaration//GEN-END:variables
}
