/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author satrio
 */
public class Buku {
    private String idBuku;
    private String judulBuku;
    private String pengarang;
    private String genre;
    private String penerbit;
    private int stok;

    public Buku(String idBuku, String judulBuku, String pengarang, String genre, String penerbit) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.pengarang = pengarang;
        this.genre = genre;
        this.penerbit = penerbit;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    
}
