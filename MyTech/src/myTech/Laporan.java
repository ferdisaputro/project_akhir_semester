/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package myTech;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author USER
 */
public class Laporan extends javax.swing.JFrame {
    Koneksi cn = new Koneksi();
    DefaultTableModel tableModel;
    Statement stat;
    String sql;
    
    /**
     * Creates new form Laporan
     */
    public Laporan() {
        initComponents();
        panelPenjualan.setOpaque(false);
        panelPembelian.setOpaque(false);
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
                    + "where pembelian.tanggal_transaksi between \""+start+"\" and \""+end+"\" "
                    + "order by pembelian.tanggal_transaksi, pembelian.id_pembelian desc";
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
                    + "WHERE penjualan.tanggal_transaksi between \""+start+"\" and \""+end+"\" "
                    + "order by penjualan.tanggal_transaksi, penjualan.id_penjualan desc";
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
                String labaPenjualan = String.valueOf(Long.parseLong(penjualan) - Long.parseLong(pembelian));
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
            sql = "SELECT tanggal_transaksi, total FROM "+tableName.toLowerCase() +" WHERE "+tableName.toLowerCase()+".tanggal_transaksi between \""+start+"\" and \""+end+"\" order by tanggal_transaksi asc";
            ResultSet res = stat.executeQuery(sql);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            while(res.next()){
                dataset.addValue(Integer.parseInt(res.getString("total")), tableName, res.getString("tanggal_transaksi"));
            }
            JFreeChart chart = ChartFactory.createLineChart("Line Chart "+tableName, "", "", dataset);
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
    
    public static void exportToExcel(DefaultTableModel table, DefaultTableModel table1, String fileName) {
        String filePath = System.getProperty("user.dir") + "/export/"+fileName+".xls";
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");
            
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < table.getColumnCount()+table1.getColumnCount()+1; col++) {
                Cell cell = headerRow.createCell(col);
                if (col == table.getColumnCount()) {
                    cell.setCellValue("");
                } else if (col < table.getColumnCount()) {
                    cell.setCellValue(table.getColumnName(col));
                } else {
                    cell.setCellValue(table1.getColumnName(col - table.getColumnCount()-1));
                }
                
            }

            // Create data rows
            int biggestRow = table.getRowCount() > table1.getRowCount()? table.getRowCount() : table1.getRowCount();
            for (int row = 0; row < biggestRow; row++) {
                Row dataRow = sheet.createRow(row + 1);
                for (int col = 0; col < table.getColumnCount() + table1.getColumnCount() + 1; col++) {
                    Cell cell = dataRow.createCell(col);
                    if (col == table.getColumnCount()) {
                        cell.setCellValue("");
                    } 
                    else if (col < table.getColumnCount()) {
                        if (table.getRowCount()-1 < row) {
                            cell.setCellValue("");
                        } else {
                            cell.setCellValue(table.getValueAt(row, col).toString());
                        }
                    } else {
                        if (table1.getRowCount()-1 < row) {
                            cell.setCellValue("");
                        } else {
                            cell.setCellValue(table1.getValueAt(row, col - table.getColumnCount()-1).toString());
                        }
                    }
                }
            }
            
            // Write the workbook to the file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(null, "Export berhasil, file berada di \"MyTech\\export\"\\"+fileName+".xls");
            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        pendapatanPenjualan = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelPenjualan = new javax.swing.JPanel();
        panelPembelian = new javax.swing.JPanel();
        totalPembelian = new javax.swing.JTextField();
        laba = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePenjualan = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePembelian = new javax.swing.JTable();
        tanggalMulai = new com.github.lgooddatepicker.components.DatePicker();
        tanggalAkhir = new com.github.lgooddatepicker.components.DatePicker();
        jLabel9 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 90, 20));

        pendapatanPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendapatanPenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(pendapatanPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 310, -1));

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("EXPORT EXCEL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 140, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("KELUAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 640, 120, 30));

        javax.swing.GroupLayout panelPenjualanLayout = new javax.swing.GroupLayout(panelPenjualan);
        panelPenjualan.setLayout(panelPenjualanLayout);
        panelPenjualanLayout.setHorizontalGroup(
            panelPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        panelPenjualanLayout.setVerticalGroup(
            panelPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        getContentPane().add(panelPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 450, 170));

        javax.swing.GroupLayout panelPembelianLayout = new javax.swing.GroupLayout(panelPembelian);
        panelPembelian.setLayout(panelPembelianLayout);
        panelPembelianLayout.setHorizontalGroup(
            panelPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        panelPembelianLayout.setVerticalGroup(
            panelPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        getContentPane().add(panelPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));
        getContentPane().add(totalPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 310, -1));
        getContentPane().add(laba, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 640, 310, -1));

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

        tanggalMulai.setBackground(new java.awt.Color(0, 153, 153));
        getContentPane().add(tanggalMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 220, -1));

        tanggalAkhir.setBackground(new java.awt.Color(0, 153, 153));
        getContentPane().add(tanggalAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 220, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_component_asset/laporan fix.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pendapatanPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendapatanPenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendapatanPenjualanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        tampilPembelian();
        tampilPenjualan();
        countFieldText();
        lineChart("pembelian");
        lineChart("penjualan");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String fileName = JOptionPane.showInputDialog("Masukkan nama file");
        exportToExcel((DefaultTableModel) tablePenjualan.getModel(), (DefaultTableModel) tablePembelian.getModel(), fileName);
    }//GEN-LAST:event_jButton3ActionPerformed

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
//                if (admin.UserAdmin.getName() == null) {
//                    Login login = new Login();
//                    login.setVisible(true);
//                    login.setExtendedState(Login.MAXIMIZED_BOTH);
//                } else {
                    new Laporan().setVisible(true);
//                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
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
