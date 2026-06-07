# A-BANG

Aplikasi Java berbasis desktop yang dirancang untuk mempermudah operasional pemesanan tiket kereta api. Sistem ini menyediakan antarmuka khusus untuk administrator, pegawai, dan penumpang, memastikan alur kerja yang terstruktur untuk manajemen dan pengadaan tiket.

## Arsitektur dan Modul

Proyek ini dibangun menggunakan framework Java Swing dan mengikuti struktur paket modular untuk memisahkan fungsi berdasarkan peran pengguna:

*   **Modul Admin:** Mengelola manajemen pengguna, inventaris tiket (operasi CRUD), dan pengawasan dasbor sistem.
*   **Modul Pegawai:** Menyediakan formulir operasional untuk mengelola tugas pertiketan sehari-hari dan memverifikasi informasi penumpang.
*   **Modul Penumpang:** Menampilkan antarmuka interaktif untuk pencarian tiket, pemesanan tiket, dan melihat riwayat pemesanan. Dilengkapi dengan registrasi pengguna dan sistem login yang aman.

## Teknologi yang Digunakan

*   **Bahasa Pemrograman:** Java (JDK 8+)
*   **Framework GUI:** Java Swing
*   **Basis Data:** MySQL / MariaDB
*   **Konektivitas Basis Data:** JDBC (MySQL Connector/J)
*   **Keamanan:** Hashing SHA-256 untuk perlindungan kata sandi
*   **Build Tool:** Ant (NetBeans)

## Instalasi dan Persiapan

1.  **Kloning Repositori:**
    ```bash
    git clone <url-repositori-anda>
    ```

2.  **Konfigurasi Basis Data:**
    *   Impor file `kai.sql` yang berada di direktori utama ke dalam server MySQL Anda.
    *   Perbarui kredensial koneksi basis data di file `A-BANG/src/Admin/DatabaseConnection.java` agar sesuai dengan pengaturan basis data lokal Anda.

3.  **Build dan Jalankan:**
    *   Buka folder `A-BANG` sebagai proyek di NetBeans IDE.
    *   Pastikan library MySQL Connector/J telah ditambahkan ke dalam library proyek.
    *   Lakukan proses *Clean and Build* pada proyek.
    *   Jalankan file `Login.java` yang berada di dalam paket `Admin` untuk memulai aplikasi.

## Deployment

Proyek ini mencakup konfigurasi installer. File setup dapat ditemukan di direktori `A-BANG-SetupFiles` untuk menginstal aplikasi sebagai executable native Windows (.msi).

## Lisensi

Proyek ini dilisensikan di bawah Lisensi MIT.
