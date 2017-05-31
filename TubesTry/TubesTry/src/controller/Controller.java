/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.AnggotaPerpustakaan;
import model.Aplikasi;
import model.Buku;
import model.Pustakawan;
import model.Transaksi;
import view.*;

/**
 *
 * @author satrio
 */
public class Controller implements ActionListener {
    private Aplikasi aplikasi;
    private AnggotaPerpustakaan anggota;
    private Buku cbuku;
    private Pustakawan pustakawan;
    private Transaksi ctransaksi;
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
    private DefaultTableModel modeltable;
    private DefaultTableModel modeltable1;
    private DefaultTableModel modeltable2;
    private AnggotaPerpustakaan ap;
    private Buku bk;

    public Controller(Aplikasi aplikasi) {
        this.aplikasi = aplikasi;
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
        login.setVisible(true);
        aplikasi.getALLPustakawan();
        aplikasi.getALLAnggota();
        aplikasi.getALLBuku();
        aplikasi.getALLTransaksi();
        viewTabelAnggota();
        viewTabelBuku();
        viewTabelTransaksi();
    }
    
    public final void viewTabelAnggota(){
        Object [][] objek = new Object[aplikasi.getALLAnggota().size()][3]; 
        int i = 0;
        for (AnggotaPerpustakaan ap: aplikasi.getALLAnggota()) { 
            String arrayAnggotaPerpustakaan[] = { 
                ap.getId(),
                ap.getNama(), 
                ap.getAlamat()
            };
            objek[i] = arrayAnggotaPerpustakaan; 
            i++;
        }
        modeltable = new DefaultTableModel(objek, lihatAnggota.getnamakolom()); 
        lihatAnggota.setModel(modeltable);
    }
    
    public final void viewTabelBuku(){
        Object [][] objek = new Object[aplikasi.getALLBuku().size()][5]; 
        int i = 0;
        for (Buku b: aplikasi.getALLBuku()) { 
            String arrayBuku[] = { 
                b.getIdBuku(),
                b.getJudulBuku(),
                b.getPengarang(),
                b.getGenre(),
                b.getPenerbit()
            };
            objek[i] = arrayBuku; 
            i++;
        }
        modeltable1 = new DefaultTableModel(objek, lihatBuku.getnamakolom()); 
        lihatBuku.setModel(modeltable1);
    }
    
     public final void viewTabelTransaksi(){
        Object [][] objek = new Object[aplikasi.getALLTransaksi().size()][5]; 
        int i = 0;
        for (Transaksi ts: aplikasi.getALLTransaksi()) { 
            String arrayTransaksi[] = { 
                ts.getIdTransaksi(),
                ts.getIdAnggota(),
                ts.getIdBuku(),
                ts.getTanggalPinjam(),
                ts.getTanggalKembali()
            };
            objek[i] = arrayTransaksi; 
            i++;
        }
        modeltable2 = new DefaultTableModel(objek, riwayat.getnamakolom()); 
        riwayat.setModel(modeltable2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        //Login
        if(src.equals(login.getbLogin())){
            try {
                String id = login.gettIDPustakawan();
                String pass = login.gettPassword();
                Pustakawan p = new Pustakawan(id, pass);  
                if(aplikasi.cekLoginPustakawan(p)==true) {
                    JOptionPane.showMessageDialog(login, "Berhasil Login");
                    login.setVisible(false);
                    menu.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(login, "Gagal Login");
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
                lihatBuku.setVisible(true);
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
                viewTabelTransaksi();
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
                String id = tambahAnggota.gettIDAnggota();
                String nama = tambahAnggota.gettNama();
                String alamat = tambahAnggota.gettAlamat();
                if(anggota == null){
                    if((id.length()==0) || (nama.length() == 0) || (alamat.length()==0)){
                        JOptionPane.showMessageDialog(tambahAnggota, "field tidak boleh kosong");
                    }else{
                    aplikasi.createAnggota(id,nama,alamat);
                    }
                }
                JOptionPane.showMessageDialog(tambahAnggota, "Berhasil di tambah");
                tambahAnggota.settIDAnggota("");
                tambahAnggota.settNama("");
                tambahAnggota.settAlamat("");
                anggota = null;
                viewTabelAnggota();
                keanggotaan.setVisible(false);
                tambahAnggota.setVisible(true);
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
                String id = editAnggota.getId();
                ap = aplikasi.cariAnggota(id);
                if(ap==null){
                    JOptionPane.showMessageDialog(editAnggota, "Data Tidak Ditemukan");
                }else{
                    editAnggota.settNama(ap.getNama());
                    editAnggota.settAlamat(ap.getAlamat());
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(editAnggota.getbSimpan())) {
            try {
                String id = editAnggota.getId();
                String nama = editAnggota.getNama();
                String alamat = editAnggota.getAlamat();
                ap = new AnggotaPerpustakaan(id, nama, alamat);
                aplikasi.updateAnggota(ap);
                JOptionPane.showMessageDialog(editAnggota, "Berhasil di update");
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Lihat Anggota
         if (src.equals(lihatAnggota.getbKembali())) {
            try {
                viewTabelAnggota();
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
        
        if (src.equals(tambahBuku.getbTambah())) {
            try {
                String id = tambahBuku.gettID();
                String judul = tambahBuku.gettJudul();
                String pengarang = tambahBuku.gettPengarang();
                String genre = tambahBuku.gettGenre();
                String penerbit = tambahBuku.gettPenerbit();
                if(cbuku == null){
                    if((id.length()==0) || (judul.length() == 0) || (pengarang.length()==0) 
                            || (genre.length()==0) || (penerbit.length()==0)){
                        JOptionPane.showMessageDialog(tambahBuku, "field tidak boleh kosong");
                    }else{
                    aplikasi.createBuku(id, judul, pengarang, genre, penerbit);
                    JOptionPane.showMessageDialog(tambahAnggota, "Berhasil di tambah");
                    }
                }
                
                tambahAnggota.settIDAnggota("");
                tambahAnggota.settNama("");
                tambahAnggota.settAlamat("");
                cbuku = null;
                tambahBuku.setVisible(true);
                buku.setVisible(false);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Edit Buku
        if (src.equals(editBuku.getbKembali())) {
            try {
                editBuku.setVisible(false);
                buku.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(editBuku.getbCari())) {
            try {
                String id = editBuku.gettID();
                bk = aplikasi.cariBuku(id);
                if(bk==null){
                    JOptionPane.showMessageDialog(editBuku, "Data Tidak Ditemukan");
                }else{
                    editBuku.settJudul(bk.getJudulBuku());
                    editBuku.settPengarang(bk.getPengarang());
                    editBuku.settGenre(bk.getGenre());
                    editBuku.settPenerbit(bk.getPenerbit());
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(editBuku.getbSimpan())) {
            try {
                String id = editBuku.gettID();
                String judul = editBuku.gettJudul();
                String pengarang = editBuku.gettPengarang();
                String genre = editBuku.gettGenre();
                String penerbit = editBuku.gettPenerbit();
                bk = new Buku(id, judul, pengarang, genre, penerbit);
                aplikasi.updateBuku(bk);
                JOptionPane.showMessageDialog(editBuku, "Berhasil di update");
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
       
        //Lihat Buku
        if (src.equals(lihatBuku.getbKembali())) {
            try {
                viewTabelBuku();
                lihatBuku.setVisible(false);
                buku.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Peminjaman
        if (src.equals(peminjaman.getbKembali())) {
            try {
                peminjaman.setVisible(false);
                transaksi.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(peminjaman.getbTambah())) {
            try {
                String id = peminjaman.gettIDTransaksi();
                String tanggalPinjam = peminjaman.gettTanggal();
                String idAnggota = peminjaman.gettIDAnggota();
                String idBuku = peminjaman.gettIDBuku();
                if(ctransaksi == null){
                    if((id.length()==0) || (tanggalPinjam.length() == 0) || (idAnggota.length()==0) || (idBuku.length()==0)){
                    JOptionPane.showMessageDialog(peminjaman, "Field tidak boleh kosong");
                    }else{
                    aplikasi.createPeminjaman(idAnggota, tanggalPinjam, idAnggota, idBuku);
                    JOptionPane.showMessageDialog(peminjaman, "Berhasil di tambah");
                    }
                } 
                peminjaman.settIDTransaksi("");
                peminjaman.settTanggal("");
                peminjaman.settIDAnggota("");
                peminjaman.settIDBuku("");
                ctransaksi = null;
                peminjaman.setVisible(true);
                transaksi.setVisible(false);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Pengembalian
        if (src.equals(pengembalian.getbKembali())) {
            try {
                pengembalian.setVisible(false);
                transaksi.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        if (src.equals(pengembalian.getbCari())) {
            try {
                String id = pengembalian.gettIDTransaksi();
                ctransaksi = aplikasi.cariTransaksi(id);
                if(ctransaksi==null){
                    JOptionPane.showMessageDialog(pengembalian, "Data Tidak Ditemukan");
                }else{
                    pengembalian.settIDTransaksi(ctransaksi.getIdTransaksi());
                    pengembalian.settTanggalPinjam(ctransaksi.getTanggalPinjam());
                    pengembalian.settTanggalKembali(ctransaksi.getTanggalKembali());
                    pengembalian.settIDAnggota(ctransaksi.getIdAnggota());
                    pengembalian.settIDBuku(ctransaksi.getIdBuku());
                    pengembalian.setVisible(true);
                    transaksi.setVisible(false);
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        
        if (src.equals(pengembalian.getbTambah())) {
            try {
                String id = pengembalian.gettIDTransaksi();
                String tglpinjam = pengembalian.gettTanggalPinjam();
                String tglkembali = pengembalian.gettTanggalKembali();
                String idanggota = pengembalian.gettIDAnggota();
                String idbuku = pengembalian.gettIDBuku();
                ctransaksi = new Transaksi(id, tglpinjam, idanggota, idbuku);
                ctransaksi.setTanggalKembali(tglkembali);
                aplikasi.updateTransaksi(ctransaksi);
                JOptionPane.showMessageDialog(pengembalian, "Berhasil di tambah");
                pengembalian.setVisible(false);
                transaksi.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
        
        //Lihat Transaksi
         if (src.equals(riwayat.getbKembali())) {
            try {
                riwayat.setVisible(false);
                transaksi.setVisible(true);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
      
        
    }
    
}
 