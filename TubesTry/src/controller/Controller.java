/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.AnggotaPerpustakaan;
import model.Aplikasi;
import model.Buku;
import model.Pustakawan;
import view.*;

/**
 *
 * @author satrio
 */
public class Controller implements ActionListener {
    private Aplikasi aplikasi;
    private Login login;
    private vBuku buku;
    private Keanggotaan keanggotaan;
    private vTransaksi transaksi;
    private MenuUtama menu;
    private TambahBuku tambahBuku;
    private EditBuku editBuku;
    private LihatBuku lihatBuku;
    private TambahAnggota tambahAnggota;
    private EditAnggota editAnggota;
    private LihatAnggota lihatAnggota;
    private Peminjaman peminjaman;
    private Pengembalian pengembalian;
    private LihatTransaksi riwayat;

    public Controller() {
        aplikasi = new Aplikasi();
        login = new Login();
        buku = new vBuku();
        menu = new MenuUtama();
        keanggotaan = new Keanggotaan();
        transaksi = new vTransaksi();
        tambahBuku = new TambahBuku();
        editBuku = new EditBuku();
        lihatBuku = new LihatBuku();
        riwayat = new LihatTransaksi();
        tambahAnggota = new TambahAnggota();
        lihatAnggota = new LihatAnggota();
        editAnggota = new EditAnggota();
        peminjaman = new Peminjaman();
        pengembalian = new Pengembalian();
        login.addActionListener(this);
        buku.addActionListener(this);
        keanggotaan.addActionListener(this);
        transaksi.addActionListener(this);      
        menu.addActionListener(this);
        tambahBuku.addActionListener(this);
        editBuku.addActionLIstener(this);
        lihatBuku.addActionListener(this);
        tambahAnggota.addActionListener(this);
        editAnggota.addActionListener(this);
        lihatAnggota.addActionListener(this);
        peminjaman.addActionListener(this);
        pengembalian.addActionListener(this);
        riwayat.addActionListener(this);
        //login.setVisible(true);
        menu.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        //Login
        if(src.equals(login.getbLogin())){
            try {
                JTextField id = login.gettIDPustakawan();
                JTextField pass = login.gettPassword();
                Pustakawan p = new Pustakawan(id.toString(), pass.toString());
                if(aplikasi.cekLoginPustakawan(p)) {
                    login.setVisible(false);
                    menu.setVisible(true);
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Menu Utama
        if(src.equals(menu.getbKeluar())){
            try {
                menu.setVisible(false);
                login.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(menu.getbBuku())) {
            try {
                menu.setVisible(false);
                buku.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(menu.getbKeanggotaan())) {
            try {
                menu.setVisible(false);
                keanggotaan.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(menu.getbTransaksi())) {
            try {
                menu.setVisible(false);
                transaksi.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Buku
        if (src.equals(buku.getbKembali())) {
            try {
                buku.setVisible(false);
                menu.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(buku.getbTambahBuku())) {
            try {
                buku.setVisible(false);
                tambahBuku.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(buku.getbEditBuku())) {
            try {
                buku.setVisible(false);
                editBuku.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(buku.getbLihatBuku())) {
            try {
                buku.setVisible(false);
                editBuku.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Keanggotaan
        if (src.equals(keanggotaan.getbKembali())) {
            try {
                keanggotaan.setVisible(false);
                menu.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(keanggotaan.getbTambahAnggota())) {
            try {
                keanggotaan.setVisible(false);
                tambahAnggota.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(keanggotaan.getbEditAnggota())) {
            try {
                keanggotaan.setVisible(false);
                editAnggota.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(keanggotaan.getbLihatAnggota())) {
            try {
                keanggotaan.setVisible(false);
                lihatAnggota.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Transaksi
        if (src.equals(transaksi.getbKembali())) {
            try {
                transaksi.setVisible(false);
                menu.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(transaksi.getbPeminjaman())) {
            try {
                transaksi.setVisible(false);
                peminjaman.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(transaksi.getbPengembalian())) {
            try {
                transaksi.setVisible(false);
                pengembalian.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(transaksi.getbRiwayat())) {
            try {
                transaksi.setVisible(false);
                riwayat.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //tambah Anggota
        if (src.equals(tambahAnggota.getbKembali())) {
            try {
                tambahAnggota.setVisible(false);
                keanggotaan.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(tambahAnggota.getbTambahAnggota())) {
            try {
                
                AnggotaPerpustakaan p = new AnggotaPerpustakaan(tambahAnggota.gettIDAnggota().getText(), tambahAnggota.gettNama().getText(), tambahAnggota.gettAlamat().getText());
                if (aplikasi.insertAnggota(p)) {
                    tambahAnggota.setShowMessage("Tambah Anggota Berhasil!");
                }
                else {
                    tambahAnggota.setShowMessage("Tambah Anggota Gagal!");
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Edit Anggota
        if (src.equals(editAnggota.getbKembali())) {
            try {
                editAnggota.setVisible(false);
                keanggotaan.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(editAnggota.getbCari())) {
            try {
                
                
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(editAnggota.getbSimpan())) {
            try {
                
                
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Lihat Anggota
        if (src.equals(lihatAnggota.getbKembali())) {
            try {
                lihatAnggota.setVisible(false);
                keanggotaan.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Tambah Buku
        if (src.equals(tambahBuku.getbKembali())) {
            try {
                tambahBuku.setVisible(false);
                buku.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(tambahAnggota.getbTambahAnggota())) {
            try {
                
                Buku b = new Buku(tambahBuku.gettID().getText(), tambahBuku.gettJudul().getText(), tambahBuku.gettPengarang().getText(), tambahBuku.gettGenre().getText(), tambahBuku.gettPenerbit().getText());
                if (aplikasi.insertBuku(b)) {
                    tambahAnggota.setShowMessage("Tambah Anggota Berhasil!");
                }
                else {
                    tambahAnggota.setShowMessage("Tambah Anggota Gagal!");
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Lihat Buku
        if (src.equals(lihatAnggota.getbKembali())) {
            try {
                lihatAnggota.setVisible(false);
                keanggotaan.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        
    }
    
}
