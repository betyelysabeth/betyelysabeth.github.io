#ifndef TUBES_H_INCLUDED
#define TUBES_H_INCLUDED
#include <iostream>
#include <stdio.h>
#include <conio.h>
#include <string>

//typedef struct infotype_rm *adr_rm;
//typedef struct elmPasien *adr_pasien;
//typedef struct Rekam_Medis infotype_rm;
//typedef struct elmRekamMedis *adr_rm;


struct infotype_rm {
    int id_pasien;
    std::string nama_pasien;
    int tgl_lahir;
    std::string  alamat;
    int tb;
    int bb;
    //std::string nama_dokter;
    //int tanggal;
    //std::string diagnosa;
};

struct infotype_rek {
    std::string nama_dokter;
    int tanggal;
    std::string diagnosa;
};

typedef struct elmPasien *adr_rm;
typedef struct elmRek *adr_rek;

struct elmPasien
{
    adr_rm next_pasien, prev_pasien;
    infotype_rm infoPasien;
};

struct elmRek
{
    adr_rek next_rek;
    infotype_rek infoRek;
};

struct listPasien{
    adr_rm first, last;
};

struct listRek
{
    adr_rek first;
};

void createListPasien (listPasien &l);
adr_rm alokasi_pasien (infotype_rm x);
void dealokasi_pasien (adr_rm p);
void addPasien (listPasien &l, adr_rm);
adr_rm findElm(listPasien l, infotype_rm x);
adr_rm deleteFirstPasien (listPasien &l);
adr_rm deleteLastPasien (listPasien &l);
adr_rm deleteAfterPasien (listPasien &l, int x);
void editPasien (listPasien &l, int x);
adr_rm findPasienByName (listPasien l, int id);
int total (listPasien &l);
void viewPasien (listPasien &l1, listRek &l2);
void viewPasienByID (listPasien &l, int id);

void createListRekamMedis (listRek &l);
adr_rek alokasi_rm (infotype_rek x);
adr_rek dealokasi_rm (adr_rek q);
void addRekamMedis (listRek &l, adr_rek p);
void editPasienbyTanggalBerkunjung (listPasien &l1, listRek &l2);
//adr_rm deleteFirstRM (listPasien &l);
//adr_rm deleteLastRM (listPasien &l);
//adr_rm deleteAfterRM (listPasien &l, int x);
//void editRMbyDate (listPasien &l,string x);
//void viewRMbyIDPasienAndDate (listPasien l, adr_pasien q);


#endif // TUBES_H_INCLUDED
