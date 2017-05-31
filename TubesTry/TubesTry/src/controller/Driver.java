/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import model.AnggotaPerpustakaan;
import model.Buku;
import model.Pustakawan;

/**
 *
 * @author satrio
 */
public class Driver {
    public static void main(String[] args) {
        Aplikasi model = new Aplikasi();
        new Controller(model);
    }
}
