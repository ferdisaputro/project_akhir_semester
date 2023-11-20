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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pendapatanPenjualan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        totalPembelian = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        laba = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePenjualan = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePembelian = new javax.swing.JTable();
        tanggalMulai = new com.github.lgooddatepicker.components.DatePicker();
        tanggalAkhir = new com.github.lgooddatepicker.components.DatePicker();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelPenjualan = new javax.swing.JPanel();
        panelPembelian = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel4.setText("Pendapatan Penjualan");

        jLabel5.setText("Total Pembelian");

        jLabel6.setText("Laba Bersih");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LAPORAN");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        pendapatanPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendapatanPenjualanActionPerformed(evt);
            }
        });

        jLabel2.setText("Tanggal Mulai");

        jLabel3.setText("Tanggal Akhir");

        jButton1.setText("LIHAT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Penjualan");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        tablePenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Penjualan", "Tanggal Penjualan", "Nama Barang", "Admin", "Jumlah Barang", "Sub Total"
            }
        ));
        jScrollPane1.setViewportView(tablePenjualan);

        jLabel8.setText("Pembelian");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        tablePembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Transaksi", "Tanggal Transaksi", "Nama Barang", "Jumlah Barang", "Sub Total"
            }
        ));
        jScrollPane2.setViewportView(tablePembelian);

        jButton2.setText("Grafik penjualan");

        jButton3.setText("Grafik pembelian");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelPembelianLayout = new javax.swing.GroupLayout(panelPembelian);
        panelPembelian.setLayout(panelPembelianLayout);
        panelPembelianLayout.setHorizontalGroup(
            panelPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPembelianLayout.setVerticalGroup(
            panelPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(415, 415, 415))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tanggalMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addGap(223, 223, 223))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(laba, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pendapatanPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(panelPenjualan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                            .addComponent(panelPembelian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(tanggalMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPembelian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pendapatanPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totalPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(laba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
