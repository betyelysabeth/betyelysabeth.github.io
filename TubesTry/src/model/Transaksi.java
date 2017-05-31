/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author satrio
 */
class Transaksi {
    private String idTransaksi;
    private String tanggalTransaksi;
    private AnggotaPerpustakaan anggotaPerpustakaan;
    private Buku buku;

    public Transaksi(String idTransaksi, String tanggalTransaksi, AnggotaPerpustakaan anggotaPerpustakaan, Buku buku) {
        this.idTransaksi = idTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.anggotaPerpustakaan = anggotaPerpustakaan;
        this.buku = buku;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }
    
    
}
