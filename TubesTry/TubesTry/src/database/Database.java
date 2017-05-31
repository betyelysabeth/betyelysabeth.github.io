/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.AnggotaPerpustakaan;
import model.Buku;
import model.Pustakawan;
import model.Transaksi;
import view.Peminjaman;

/**
 *
 * @author satrio
 */
public class Database {
    
    private String server = "jdbc:mysql://localhost:3306/perpus", dbuser ="root", dbpass ="";
    private Statement st;
    private Connection con;
    
    public void connect() {
        try {
            con = DriverManager.getConnection(server, dbuser, dbpass);
            st = con.createStatement();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public ArrayList getTabelPustakawan(){
            ArrayList<Pustakawan> listPustakawan = new ArrayList<>();
            Pustakawan p = null;
            int x = 0;
        try {
            String query = "SELECT * FROM `pustakawan`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Pustakawan(rs.getString(1), rs.getString(3));
                p.setNamaPustakawan(rs.getString(2));
                listPustakawan.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listPustakawan;
     }
    
    public ArrayList getTabelAnggota(){
            ArrayList<AnggotaPerpustakaan> listAnggota = new ArrayList<>();
            AnggotaPerpustakaan ap = null;
            int x = 0;
        try {
            String query = "SELECT * FROM `anggota`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ap = new AnggotaPerpustakaan(rs.getString(1),rs.getString(2),rs.getString(3));
                listAnggota.add(ap);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listAnggota;
     }
    
    public ArrayList getTabelTransaksi(){
            ArrayList<Transaksi> listTransaksi = new ArrayList<>();
            Transaksi t = null;
            int x = 0;
        try {
            String query = "SELECT * FROM `transaksi`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                t = new Transaksi(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(5));
                t.setTanggalKembali(rs.getString(3));
                listTransaksi.add(t);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listTransaksi;
     }
    
    public Transaksi getTransaksi(String idTransaksi) {
        Transaksi ts = null;
        try {
            String query = "SELECT * FROM `transaksi` WHERE `id` = " + idTransaksi;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ts = new Transaksi(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ts;
    }
    
     public void savePeminjaman(Transaksi ts) {

        try {

            String query = "INSERT INTO `transaksi`(`id`, `tanggalPinjam`, `idAnggota`, `idBuku`) VALUES ("
                    + "'" + ts.getIdTransaksi()+ "',"
                    + "'" + ts.getTanggalPinjam()+ "',"
                    + "'" + ts.getIdAnggota()+ "',"
                    + "'" + ts.getIdBuku()+ "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     public void savePengembalian(Transaksi ts) {

        try {
            String query = "UPDATE `transaksi` SET "
                    + "`tanggalPinjam`='" + ts.getTanggalPinjam()+ "',"
                    + "`tanggalKembali`='" + ts.getTanggalKembali()+ "',"
                    + "`idAnggota`='" + ts.getIdAnggota()+ "',"
                    + "`idBuku`='" + ts.getIdBuku()+ "' "
                    + "WHERE id='" + ts.getIdTransaksi()+ "'";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public AnggotaPerpustakaan getAnggota(String idAnggota) {
        AnggotaPerpustakaan ap = null;
        try {
            String query = "SELECT * FROM `anggota` WHERE `id` = " + idAnggota;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ap = new AnggotaPerpustakaan(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ap;
    }
     
    public void saveAnggota(AnggotaPerpustakaan ap) {

        try {

            String query = "INSERT INTO `anggota`(`id`, `nama`, `alamat`) VALUES ("
                    + "'" + ap.getId()+ "',"
                    + "'" + ap.getNama()+ "',"
                    + "'" + ap.getAlamat()+ "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateAnggota(AnggotaPerpustakaan ap){
        try{
            String query = "UPDATE `anggota` SET "
                    + "`nama`='" + ap.getNama()+ "',"
                    + "`alamat`='" + ap.getAlamat()+ "' "
                    + "WHERE id='" + ap.getId()+ "'";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     public void saveBuku(Buku b) {

        try {

            String query = "INSERT INTO `buku`(`id`, `judul`, `pengarang`, `genre`, `penerbit`) VALUES ("
                    + "'" + b.getIdBuku()+ "',"
                    + "'" + b.getJudulBuku()+ "',"
                    + "'" + b.getPengarang()+ "',"
                    + "'" + b.getGenre()+ "',"
                    + "'" + b.getPenerbit()+ "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     public ArrayList getTabelBuku(){
            ArrayList<Buku> listbuku = new ArrayList<>();
            Buku b = null;
            int x = 0;
        try {
            String query = "SELECT * FROM `buku`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                b = new Buku(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                listbuku.add(b);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listbuku;
     }
     
      public Buku getBuku(String idBuku) {
        Buku b = null;
        try {
            String query = "SELECT * FROM `buku` WHERE `id` = " + idBuku;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                b = new Buku(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return b;
    }
      
      public void updateBuku(Buku b){
        try{
            String query = "UPDATE `buku` SET "
                    + "`judul`='" + b.getJudulBuku()+ "',"
                    + "`pengarang`='" + b.getPengarang()+ "',"
                    + "`genre`='" + b.getGenre()+ "',"
                    + "`penerbit`='" + b.getPenerbit()+ "' "
                    + "WHERE id='" + b.getIdBuku()+ "'";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
