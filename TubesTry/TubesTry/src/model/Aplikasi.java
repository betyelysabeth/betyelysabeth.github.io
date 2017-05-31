/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author satrio
 */
    public class Aplikasi {
        private ArrayList<AnggotaPerpustakaan> anggota = new ArrayList<>();
        private ArrayList<Buku> buku = new ArrayList<>();
        private ArrayList<Pustakawan> pustakawan = new ArrayList<>();
        private ArrayList<Transaksi> transaksi = new ArrayList<>();
        private Database db;
        private AnggotaPerpustakaan a;
        private Buku bk;
        private Transaksi ts;
       
    
    public Aplikasi() {
        this.pustakawan = new ArrayList<>();
        this.anggota = new ArrayList<>();
        this.buku = new ArrayList<>();
        this.transaksi = new ArrayList<>();
        this.db = new Database();
        db.connect();
    }
    
    public ArrayList<Pustakawan> getALLPustakawan(){ 
         pustakawan = db.getTabelPustakawan();
         return pustakawan; 
    }
    
    public ArrayList<AnggotaPerpustakaan> getALLAnggota(){ 
         anggota = db.getTabelAnggota();
         return anggota; 
    }
    
    public ArrayList<Buku> getALLBuku(){ 
         buku = db.getTabelBuku();
         return buku; 
    }
    
    public ArrayList<Transaksi> getALLTransaksi(){ 
         transaksi = db.getTabelTransaksi();
         return transaksi; 
    }
    
    public AnggotaPerpustakaan cariAnggota(String idp){
         int x = 0;
        for(AnggotaPerpustakaan ap : anggota){
            if(ap.getId().equals(idp)){
                x=1;
                a = ap;
            }
        }
        if(x==1){
            return a;
        }else{
            return null;
        }
    }
    
    public Buku cariBuku(String idb){
         int x = 0;
        for(Buku b : buku){
            if(b.getIdBuku().equals(idb)){
                x=1;
                bk = b;
            }
        }
        if(x==1){
            return bk;
        }else{
            return null;
        }
    }
    
    public Transaksi cariTransaksi(String idt){
         int x = 0;
        for(Transaksi trs : transaksi){
            if(trs.getIdTransaksi().equals(idt)){
                x=1;
                ts = trs;
            }
        }
        if(x==1){
            return ts;
        }else{
            return null;
        }
    }
    
    public void updateAnggota(AnggotaPerpustakaan ap){
        db.updateAnggota(ap);
    }
    
    public void updateBuku(Buku b){
        db.updateBuku(b);
    }
    
    public boolean cekLoginPustakawan(Pustakawan p) throws SQLException{
        int x = 0;
       for (Pustakawan ps : pustakawan) {
            if (ps.getIdPustakawan().equals(p.getIdPustakawan())) {
                if(ps.getPassword().equals(p.getPassword())){
                    x=1;
                }else{
                    x=0;
                }
            }
        }
       if(x==1){
           return true;
       }else{
           return false;
       }
    }
    
    public void createAnggota(String id,String nama,String alamat) {
        AnggotaPerpustakaan ap = new AnggotaPerpustakaan(id,nama,alamat);
        anggota.add(ap);
        db.saveAnggota(ap);
    }
    
    public void createBuku(String id,String judul,String pengarang, String genre, String penerbit) {
        Buku b = new Buku(id, judul, pengarang, genre, penerbit);
        buku.add(b);
        db.saveBuku(b);
    }
    
    public void createPeminjaman(String idTransaksi,String tanggalTransaksi,String idAnggota, String idBuku) {
        Transaksi ts = new Transaksi(idTransaksi, tanggalTransaksi, idAnggota, idBuku);
        transaksi.add(ts);
        db.savePeminjaman(ts);
    }
    
    public void updateTransaksi(Transaksi ts){
        db.savePengembalian(ts);
    }
    
}
      

