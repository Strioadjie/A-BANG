/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Penumpang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author satri
 */
public class PemesananTiket extends javax.swing.JFrame {

    /**
     * Creates new form PemesananTiket
     */
    public PemesananTiket() {
        initComponents();
        buttonGroup1 = new javax.swing.ButtonGroup();
         myInit(); 
    }
         
    // Method custom untuk semua pengaturan awal form
    private void myInit() {
        setLocationRelativeTo(null); // Form di tengah layar
        groupCheckBoxes();           // Kelompokkan checkbox kelas
        tampilkanDataPemesanan();    // Tampilkan data awal di tabel

        // Membuat beberapa field tidak bisa diedit manual
        jTextField5.setEditable(false); // Field Harga
        jTextField7.setEditable(false); // Field Total Harga
        
        // Membuat satu event listener yang akan digunakan oleh semua komponen
        // yang mempengaruhi harga, agar lebih efisien.
        java.awt.event.ActionListener priceUpdater = new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                updateHarga();
            }
        };
        
        // Menerapkan event listener ke semua komponen relevan
        jComboBox1.addActionListener(priceUpdater); // Ganti jComboBoxTujuan dengan nama ComboBox-mu
        jCheckBox1.addActionListener(priceUpdater);
        jCheckBox2.addActionListener(priceUpdater);
        jCheckBox3.addActionListener(priceUpdater);
    }
    
    // Method untuk mengisi item ke dalam ComboBox Tujuan
   

    // Method PENTING: Otak dari penentuan harga otomatis
    private void updateHarga() {
       String tujuan = (String) jComboBox1.getSelectedItem(); // Menggunakan jComboBox1
        String kelas = "";
        
        if (jCheckBox1.isSelected()) kelas = "Ekonomi";
        else if (jCheckBox2.isSelected()) kelas = "Bisnis";
        else if (jCheckBox3.isSelected()) kelas = "Eksekutif";

        if (tujuan == null || tujuan.equals("-- Pilih Tujuan --") || kelas.isEmpty()) {
            jTextField5.setText("");
            return;
        }

        int harga = 0;
        // Logika penentuan harga
        if (tujuan.equals("Jakarta - Bandung")) {
            if (kelas.equals("Ekonomi")) harga = 20000;
            else if (kelas.equals("Bisnis")) harga = 30000;
            else if (kelas.equals("Eksekutif")) harga = 40000;
        } else if (tujuan.equals("Jakarta - Semarang")) {
            if (kelas.equals("Ekonomi")) harga = 70000;
            else if (kelas.equals("Bisnis")) harga = 80000;
            else if (kelas.equals("Eksekutif")) harga = 90000;
        } else if (tujuan.equals("Jakarta - Surabaya")) {
            if (kelas.equals("Ekonomi")) harga = 100000;
            else if (kelas.equals("Bisnis")) harga = 120000;
            else if (kelas.equals("Eksekutif")) harga = 150000;
        }
        
        jTextField5.setText(String.valueOf(harga));
    }

    // Method untuk mengelompokkan JCheckBox
    private void groupCheckBoxes() {
        // Ganti buttonGroup1 jika kamu menamainya berbeda di Inspector
        buttonGroup1.add(jCheckBox1);
        buttonGroup1.add(jCheckBox2);
        buttonGroup1.add(jCheckBox3);
    }

    // Method untuk membersihkan form
    private void clearForm() {
        jTextField1.setText(""); // Nama
        jTextField2.setText(""); // NIK
        jComboBox1.setSelectedIndex(0); // Ganti jComboBoxTujuan
        jTextField3.setText(""); // Jadwal
        jTextField5.setText(""); // Harga
        jTextField6.setText(""); // Jumlah Beli
        jTextField7.setText(""); // Total Harga
        buttonGroup1.clearSelection();
    }

    // Method untuk menampilkan data dari database ke JTable
    private void tampilkanDataPemesanan() {
    DefaultTableModel model = new DefaultTableModel();
    // Sesuaikan header kolom dengan data yang akan ditampilkan
    model.addColumn("No. Tiket");
    model.addColumn("Nama");
    model.addColumn("NIK");
    model.addColumn("Kelas");
    model.addColumn("Tujuan");
    model.addColumn("Harga");
    model.addColumn("Jumlah");
    model.addColumn("Total Harga");

    try (Connection conn = Admin.DatabaseConnection.connect()) {
        // Ambil SEMUA kolom yang relevan dari pemesanan_tiket
        String sql = "SELECT nomor_tiket, nama, nik, kelas_kereta, tujuan, harga, jumlah, total FROM pemesanan_tiket";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("nomor_tiket"),
                rs.getString("nama"),
                rs.getLong("nik"), // Gunakan getLong untuk NIK
                rs.getString("kelas_kereta"),
                rs.getString("tujuan"),
                rs.getDouble("harga"),
                rs.getInt("jumlah"),
                rs.getInt("total")
                // Kolom tanggal tidak dimasukkan ke tabel sesuai permintaan sebelumnya
            });
        }
        jTable1.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Kelas Kereta");

        jLabel2.setText("Nama");

        jLabel3.setText("Nik");

        jLabel4.setText("Tanggal");

        jLabel5.setText("Tujuan");

        jLabel6.setText("Harga");

        jLabel7.setText("Jumlah Beli");

        jLabel8.setText("Total Harga");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton2.setText("Hitung Total");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Simpan ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jCheckBox1.setText("Ekonomi");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Bisnis");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Eksekutif");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jakarta - Bandung", "Jakarta - Semarang", "Jakarta - Surabaya" }));
        jComboBox1.setSelectedIndex(-1);

        jLabel9.setText("No. Tiket");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(3, 3, 3))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel9)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField5)
                                    .addComponent(jTextField6)
                                    .addComponent(jComboBox1, 0, 304, Short.MAX_VALUE)
                                    .addComponent(jTextField4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(173, 173, 173))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox2)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:                                        
          try {
            if (jTextField5.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih tujuan dan kelas kereta dahulu.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (jTextField6.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Isi jumlah tiket yang akan dibeli.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            int harga = Integer.parseInt(jTextField5.getText());
            int jumlah = Integer.parseInt(jTextField6.getText());
            int total = harga * jumlah;
            jTextField7.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah beli dengan angka yang valid.", "Error Input", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          String nama = jTextField1.getText().trim();
    String nikStr = jTextField2.getText().trim();
    String tanggalStr = jTextField3.getText().trim(); // Jadwal diganti jadi Tanggal
    String jumlahBeliStr = jTextField6.getText().trim();
    String hargaStr = jTextField5.getText().trim();
    String totalHargaStr = jTextField7.getText().trim();
    String tujuan = (String) jComboBox1.getSelectedItem();

    String kelasKereta = "";
    if (jCheckBox1.isSelected()) kelasKereta = "Ekonomi";
    else if (jCheckBox2.isSelected()) kelasKereta = "Bisnis";
    else if (jCheckBox3.isSelected()) kelasKereta = "Eksekutif";

    // 2. Validasi input
    if (nama.isEmpty() || nikStr.isEmpty() || tanggalStr.isEmpty() || tujuan == null || tujuan.equals("-- Pilih Tujuan --") || kelasKereta.isEmpty() || jumlahBeliStr.isEmpty() || totalHargaStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua data wajib diisi dan total dihitung!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // 3. Konversi dan Transaksi Database
    Connection conn = null;
    try {
        long nik = Long.parseLong(nikStr);
        int jumlahBeli = Integer.parseInt(jumlahBeliStr);
        double harga = Double.parseDouble(hargaStr);
        double total = Double.parseDouble(totalHargaStr);
        java.sql.Date tanggal = java.sql.Date.valueOf(tanggalStr); // Konversi string ke tanggal SQL

        conn = Admin.DatabaseConnection.connect();
        conn.setAutoCommit(false); // Memulai Transaksi

        // Langkah A: Cek Stok
        int stokSaatIni = 0;
        String sqlCekStok = "SELECT stok FROM stok_tiket WHERE tujuan = ? AND kelas_kereta = ?";
        try (PreparedStatement stmtCek = conn.prepareStatement(sqlCekStok)) {
            stmtCek.setString(1, tujuan);
            stmtCek.setString(2, kelasKereta);
            ResultSet rs = stmtCek.executeQuery();
            if (rs.next()) {
                stokSaatIni = rs.getInt("stok");
            } else {
                throw new SQLException("Jadwal tiket untuk tujuan dan kelas ini tidak tersedia di stok.");
            }
        }
        if (jumlahBeli > stokSaatIni) {
            throw new SQLException("Stok tidak cukup. Sisa stok hanya: " + stokSaatIni);
        }

        // Langkah B: Simpan ke pemesanan_tiket
        String sqlInsert = "INSERT INTO pemesanan_tiket (nama, nik, kelas_kereta, tanggal, tujuan, harga, jumlah, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
            stmtInsert.setString(1, nama);
            stmtInsert.setLong(2, nik);
            stmtInsert.setString(3, kelasKereta);
            stmtInsert.setDate(4, tanggal);
            stmtInsert.setString(5, tujuan);
            stmtInsert.setDouble(6, harga);
            stmtInsert.setInt(7, jumlahBeli);
            stmtInsert.setDouble(8, total);
            stmtInsert.executeUpdate();
        }

        // Langkah C: Kurangi stok di stok_tiket
        String sqlUpdateStok = "UPDATE stok_tiket SET stok = stok - ? WHERE tujuan = ? AND kelas_kereta = ?";
        try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdateStok)) {
            stmtUpdate.setInt(1, jumlahBeli);
            stmtUpdate.setString(2, tujuan);
            stmtUpdate.setString(3, kelasKereta);
            stmtUpdate.executeUpdate();
        }

        conn.commit(); // Simpan semua perubahan jika berhasil
        JOptionPane.showMessageDialog(this, "Transaksi berhasil! Stok tiket telah diperbarui.");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "NIK atau Jumlah Beli harus berupa angka yang valid.", "Error Tipe Data", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, "Format tanggal salah. Gunakan format YYYY-MM-DD.", "Error Format Tanggal", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        try { if (conn != null) conn.rollback(); } catch (SQLException ex) {}
        JOptionPane.showMessageDialog(this, "Transaksi Gagal: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }
    
    tampilkanDataPemesanan();
    clearForm();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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
            java.util.logging.Logger.getLogger(PemesananTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PemesananTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PemesananTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PemesananTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PemesananTiket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
    private javax.swing.ButtonGroup buttonGroup1;
}
