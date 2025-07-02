/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class TambahTiket extends javax.swing.JFrame {

    /**
     * Creates new form TambahTiket
     */
    public TambahTiket() {
        initComponents();
        
         myInit();       
    }
    
    
  // Method untuk semua pengaturan awal form
    private void myInit() {
        setLocationRelativeTo(null); // Form di tengah layar
        groupCheckBoxes();           // Kelompokkan checkbox
        populateTujuanComboBox();    // Isi pilihan ComboBox
        tampilkanDataStok();         // Tampilkan data stok yang sudah ada
        
        // Harga diatur otomatis, jadi fieldnya tidak bisa diedit
        jTextField3.setEditable(false); // Field untuk Harga

        // Listener untuk harga otomatis
        java.awt.event.ActionListener priceUpdater = e -> updateHarga();
        jComboBox1.addActionListener(priceUpdater);
        jCheckBox1.addActionListener(priceUpdater);
        jCheckBox2.addActionListener(priceUpdater);
        jCheckBox3.addActionListener(priceUpdater);
    }
    
    // Method untuk menampilkan data dari tabel stok_tiket
    private void tampilkanDataStok() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No. Tiket");
        model.addColumn("Kelas");
        model.addColumn("Tanggal");
        model.addColumn("Tujuan");
        model.addColumn("Harga");
        model.addColumn("Stok");

        try (Connection conn = Admin.DatabaseConnection.connect()) {
            String sql = "SELECT nomor_tiket, kelas_kereta, tanggal, tujuan, harga, stok FROM stok_tiket";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("nomor_tiket"),
                    rs.getString("kelas_kereta"),
                    rs.getDate("tanggal"), // Tipe data DATE
                    rs.getString("tujuan"),
                    rs.getDouble("harga"),
                    rs.getInt("stok")       // Tipe data INT
                });
            }
            jTable1.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data stok: " + e.getMessage());
        }
    }

    // Method untuk menentukan harga otomatis
    private void updateHarga() {
        String tujuan = (String) jComboBox1.getSelectedItem();
        String kelas = "";
        if (jCheckBox1.isSelected()) kelas = "Ekonomi";
        else if (jCheckBox2.isSelected()) kelas = "Bisnis";
        else if (jCheckBox3.isSelected()) kelas = "Eksekutif";

        if (tujuan == null || tujuan.equals("-- Pilih Tujuan --") || kelas.isEmpty()) {
            jTextField3.setText(""); // jTextField3 adalah field Harga
            return;
        }

        int harga = 0;
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
        
        jTextField3.setText(String.valueOf(harga));
    }

    private void groupCheckBoxes() {
    // Pastikan sudah ada komponen ButtonGroup di form dan namanya buttonGroup1
    buttonGroup1 = new javax.swing.ButtonGroup(); // <--- INI KUNCINYA
    buttonGroup1.add(jCheckBox1);
    buttonGroup1.add(jCheckBox2);
    buttonGroup1.add(jCheckBox3);
}
    
    // Method untuk mengisi ComboBox Tujuan
    private void populateTujuanComboBox() {
        jComboBox1.addItem("-- Pilih Tujuan --");
        jComboBox1.addItem("Jakarta - Bandung");
        jComboBox1.addItem("Jakarta - Semarang");
        jComboBox1.addItem("Jakarta - Surabaya");
    }
    private void clearForm() {
    jTextField1.setText(""); // No. Tiket
    jTextField1.setEditable(true); // BUAT BISA DIEDIT KEMBALI
    
    buttonGroup1.clearSelection();
    jTextField2.setText(""); // Tanggal
    jComboBox1.setSelectedIndex(0);
    jTextField3.setText(""); // Harga
    jTextField4.setText(""); // Satuan
    jTextField5.setText(""); // Stok
    jTextField1.requestFocus();
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
        jTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("No. Tiket");

        jLabel2.setText("Kelas Kereta");

        jLabel3.setText("Tanggal");

        jLabel4.setText("Tujuan");

        jLabel5.setText("Harga");

        jLabel6.setText("Satuan");

        jLabel7.setText("Stok");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Ekonomi");

        jCheckBox2.setText("Bisnis");

        jCheckBox3.setText("Eksekutif");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jakarta - Bandung", "Jakarta - Semarang", "Jakarta - Surabaya" }));
        jComboBox1.setSelectedIndex(-1);

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(44, 44, 44)
                            .addComponent(jTextField1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jCheckBox1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCheckBox2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckBox3))
                                .addComponent(jTextField2)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4)
                                .addComponent(jTextField5)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1)
                        .addComponent(jCheckBox2)
                        .addComponent(jCheckBox3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          String noTiketStr = jTextField1.getText().trim();
    String tanggalStr = jTextField2.getText().trim(); 
    String hargaStr = jTextField3.getText().trim();   
    String satuan = jTextField4.getText().trim();     
    String stokStr = jTextField5.getText().trim();      
    String tujuan = (String) jComboBox1.getSelectedItem();

    String kelasKereta = "";
    if (jCheckBox1.isSelected()) kelasKereta = "Ekonomi";
    else if (jCheckBox2.isSelected()) kelasKereta = "Bisnis";
    else if (jCheckBox3.isSelected()) kelasKereta = "Eksekutif";

    // 2. Validasi input
    if (noTiketStr.isEmpty() || kelasKereta.isEmpty() || tanggalStr.isEmpty() || tujuan.equals("-- Pilih Tujuan --") || hargaStr.isEmpty() || stokStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field wajib diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // 3. Proses INSERT ke tabel 'stok_tiket' yang BENAR
    try (Connection conn = Admin.DatabaseConnection.connect()) {
        String sql = "INSERT INTO stok_tiket (nomor_tiket, kelas_kereta, tanggal, tujuan, harga, satuan, stok) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setInt(1, Integer.parseInt(noTiketStr));
        stmt.setString(2, kelasKereta);
        stmt.setDate(3, java.sql.Date.valueOf(tanggalStr)); // Format YYYY-MM-DD
        stmt.setString(4, tujuan);
        stmt.setDouble(5, Double.parseDouble(hargaStr));
        stmt.setString(6, satuan);
        stmt.setInt(7, Integer.parseInt(stokStr));

        stmt.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data stok tiket baru berhasil disimpan!");
        tampilkanDataStok(); // Langsung refresh tabel
        // clearForm(); // Panggil ini jika kamu punya method clearForm

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "No. Tiket, Harga, dan Stok harus berupa angka!", "Error Tipe Data", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, "Format tanggal salah. Gunakan format YYYY-MM-DD.", "Error Format Tanggal", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        if (e.getMessage().contains("Duplicate entry")) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan: No. Tiket " + noTiketStr + " sudah ada.", "Database Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan ke database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         jTextField1.setEditable(false);

    // Mengambil nomor baris yang diklik
    int baris = jTable1.getSelectedRow();

    // Mengambil data dari setiap kolom di baris tersebut dan menampilkannya di form
    String noTiket = jTable1.getValueAt(baris, 0).toString();
    jTextField1.setText(noTiket);

    String kelas = jTable1.getValueAt(baris, 1).toString();
    if (kelas.equals("Ekonomi")) {
        jCheckBox1.setSelected(true);
    } else if (kelas.equals("Bisnis")) {
        jCheckBox2.setSelected(true);
    } else {
        jCheckBox3.setSelected(true);
    }

    // Ambil tanggal dari tabel, formatnya mungkin perlu disesuaikan
    String tanggal = jTable1.getValueAt(baris, 2).toString();
    jTextField2.setText(tanggal);

    String tujuan = jTable1.getValueAt(baris, 3).toString();
    jComboBox1.setSelectedItem(tujuan);
    
    String harga = jTable1.getValueAt(baris, 4).toString();
    jTextField3.setText(harga);
    
    // Asumsi Satuan dan Stok ada di kolom selanjutnya jika ditampilkan
    // String satuan = jTable1.getValueAt(baris, 5).toString();
    // jTextField4.setText(satuan);
    
    String stok = jTable1.getValueAt(baris, 6).toString();
    jTextField5.setText(stok);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         String noTiketStr = jTextField1.getText().trim();
    String tanggalStr = jTextField2.getText().trim();
    String hargaStr = jTextField3.getText().trim();
    String satuan = jTextField4.getText().trim();
    String stokStr = jTextField5.getText().trim();
    String tujuan = (String) jComboBox1.getSelectedItem();

    String kelasKereta = "";
    if (jCheckBox1.isSelected()) kelasKereta = "Ekonomi";
    else if (jCheckBox2.isSelected()) kelasKereta = "Bisnis";
    else if (jCheckBox3.isSelected()) kelasKereta = "Eksekutif";

    // Validasi
    if (noTiketStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan diedit terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Query UPDATE untuk mengubah data di database berdasarkan nomor_tiket
    try (Connection conn = Admin.DatabaseConnection.connect()) {
        String sql = "UPDATE stok_tiket SET kelas_kereta = ?, tanggal = ?, tujuan = ?, harga = ?, satuan = ?, stok = ? WHERE nomor_tiket = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        // Set parameter. Hati-hati dengan urutannya, nomor_tiket (kunci WHERE) ada di paling akhir.
        stmt.setString(1, kelasKereta);
        stmt.setDate(2, java.sql.Date.valueOf(tanggalStr));
        stmt.setString(3, tujuan);
        stmt.setDouble(4, Double.parseDouble(hargaStr));
        stmt.setString(5, satuan);
        stmt.setInt(6, Integer.parseInt(stokStr));
        stmt.setInt(7, Integer.parseInt(noTiketStr)); // Parameter untuk WHERE

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data stok tiket berhasil diubah.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal mengubah data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    // Refresh tabel dan bersihkan form
    tampilkanDataStok();
    clearForm();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String noTiketStr = jTextField1.getText().trim();

    if (noTiketStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Konfirmasi sebelum menghapus, ini sangat penting!
    int konfirmasi = JOptionPane.showConfirmDialog(this, 
        "Apakah Anda yakin ingin menghapus tiket nomor " + noTiketStr + "?", 
        "Konfirmasi Hapus Data", 
        JOptionPane.YES_NO_OPTION);

    if (konfirmasi == JOptionPane.YES_OPTION) {
        try (Connection conn = Admin.DatabaseConnection.connect()) {
            String sql = "DELETE FROM stok_tiket WHERE nomor_tiket = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(noTiketStr));
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data stok tiket berhasil dihapus.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        tampilkanDataStok();
        clearForm();
    }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(TambahTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahTiket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
     private javax.swing.ButtonGroup buttonGroup1;
}

