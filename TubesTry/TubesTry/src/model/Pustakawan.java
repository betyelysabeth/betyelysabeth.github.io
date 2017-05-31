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
public class Pustakawan {
    private String idPustakawan;
    private String namaPustakawan;
    private String password;

    public Pustakawan(String idPustakawan, String namaPustakawan, String password) {
        this.idPustakawan = idPustakawan;
        this.namaPustakawan = namaPustakawan;
        this.password = password;
    }

    public Pustakawan(String idPustakawan, String password) {
        this.idPustakawan = idPustakawan;
        this.password = password;
    }
    
    public String getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(String idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public String getNamaPustakawan() {
        return namaPustakawan;
    }

    public void setNamaPustakawan(String namaPustakawan) {
        this.namaPustakawan = namaPustakawan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
