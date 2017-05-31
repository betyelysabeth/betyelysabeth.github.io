/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;
/**
 *
 * @author Hariyanto
 */
public class Transaksi {
    private String idTransaksi;
    private String tanggalPinjam;
    private String tanggalKembali;
    private String idAnggota;
    private String idBuku;
    private AnggotaPerpustakaan anggotaPerpustakaan;
    private Buku buku;

    public Transaksi(String idTransaksi, String tanggalPinjam, String idAnggota, String idBuku) {
        this.idTransaksi = idTransaksi;
        this.tanggalPinjam = tanggalPinjam;
        this.idAnggota = idAnggota;
        this.idBuku = idBuku;
    }
    
    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }
    
    
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }


    public String getIdAnggota() {
        return idAnggota;
    }

    public String getIdBuku() {
        return idBuku;
    }

    
    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }
    
}
