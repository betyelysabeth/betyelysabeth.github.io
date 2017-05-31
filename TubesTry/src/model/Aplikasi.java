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
    
    public boolean cekLoginPustakawan(Pustakawan p) throws SQLException {
        db.connect();
        String query = "select * from tPustakawan where nama_pelanggan = '"
                + p.getIdPustakawan() + "' and no_telp = '" + p.getPassword() + "'";
        ResultSet hasil = db.getData(query);
        if (hasil.next()) {
            db.disconnect();
            System.out.println("Login Sukses");
            return true;
        } else {
            db.disconnect();
            System.out.println("Gagal Login");
            return false;
        }
    }
    
    public boolean insertAnggota(AnggotaPerpustakaan a) throws SQLException {
        db.connect();
        String query = "insert into tAnggota values ('" + a.getId()
                + "', '" + a.getNama() + "', '" + a.getAlamat() + "')";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }

    public boolean insertBuku(Buku b) throws SQLException {
        db.connect();
        String query = "insert into tAnggota values ('" + b.getIdBuku()
                + "', '" + b.getJudulBuku() + "', '" + b.getPengarang() 
                + "', '" + b.getGenre() + "', '" + b.getPenerbit() + "')";
        if (db.manipulasiData(query)) {
            db.disconnect();
            return true;
        } else {
            db.disconnect();
            return false;
        }
    }
    
    
}
