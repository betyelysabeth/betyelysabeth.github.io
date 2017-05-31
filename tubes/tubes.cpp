#include <iostream>
#include <string>
#include <windows.h>
#include <conio.h>
#include "tubes.h"

using namespace std;


void createListPasien(listPasien &l)
{
    l.first = NULL;
    l.last = NULL;
}

adr_rm alokasi_pasien (infotype_rm x)
{
    adr_rm p = new elmPasien;
    p -> infoPasien = x;
    p -> next_pasien = NULL;
    p -> prev_pasien = NULL;
    return p;
}

void dealokasi_pasien (adr_rm p)
{
    free(p);
}

void createListRekamMedis(listRek &l)
{
    l.first = NULL;
}

adr_rek alokasi_rm (infotype_rek x)
{
    adr_rek p = new elmRek;
    p -> infoRek = x;
    p -> next_rek = NULL;
    return p;
}

adr_rek dealokasi_rm (adr_rek q)
{
    free(q);
}

adr_rm findElm(listPasien l, infotype_rm x)
{
    adr_rm q =l.first;
    while(q!=NULL)
    {
        if(q -> infoPasien.id_pasien==x.id_pasien)
            return q;
        else
            q = q -> next_pasien;
    }
    return NULL;
}

void addPasien(listPasien &l, adr_rm p)
{
    if (l.first == NULL)
    {
        l.first = p;
        l.last = p;
    }
    else
    {
        p -> next_pasien = l.first;
        l.first = p;
    }
}

void addRekamMedis (listRek &l, adr_rek q)
{
    if (l.first == NULL)
    {
        l.first = q;
    }
    else
    {
        q -> next_rek = l.first;
        l.first = q;
    }
}

adr_rm deleteFirstPasien (listPasien &l)
{
    adr_rm p = l.first;
    if (l.first == NULL)
    {
        return NULL;
    }
    else
    {
        if (p -> next_pasien == NULL)
        {
           l.first = NULL;
           l.last = NULL;
           return p;
        }
        else
        {
            l.first = p -> next_pasien;
            p -> next_pasien = NULL;
            return p;
        }
    }
}

adr_rm deleteLastPasien (listPasien &l)
{
    adr_rm p =l.last;
    if (l.first== NULL)
    {
        return NULL;
    }
    else
    {
        if (p -> prev_pasien == NULL)
        {
            l.first = NULL;
            l.last = NULL;
            return p;
        }
        else
        {
            l.last = p -> prev_pasien;
            (l.last) -> next_pasien = NULL;
            p -> prev_pasien = NULL;
            return p;
        }
    }
    return NULL;
}

adr_rm deleteAfterPasien (listPasien &l, int x)
{
    adr_rm r;
    adr_rm q = l.first;
    if (l.first == NULL)
    {
        return NULL;
    }
    else
    {
        while ((q != r) && (q != NULL)) {
            q = q -> next_pasien;
        }
        r = q -> prev_pasien;
        if (r != NULL) {
            r -> next_pasien = q -> next_pasien;
            (q -> next_pasien) -> prev_pasien = r;
            q -> prev_pasien = NULL;
            q -> next_pasien = NULL;
            return q;
        }
        return NULL;
    }
    return NULL;
}

void editPasienbyTanggalBerkunjung (listPasien &l1, listRek &l2)
{
adr_rm p = l1.first;
adr_rek q = l2.first;
    system("cls");
    int tgldatang;

    cout << "Masukkan Tanggal berkunjung Pasien : ";
    cin >> tgldatang;
        if ((q -> infoRek).tanggal == tgldatang)
        {
            cout << "Masukkan Diagnosa yang baru: ";
            cin >> (q -> infoRek).diagnosa;
        }
        else
        {
            cout << "Tidak ada tanggal yang sesuai" << endl;
        }
}

adr_rm findPasienByName (listPasien l1, listRek l2, string x)
{
    adr_rm p = l1.first;
    adr_rek q = l2.first;
    while (p != NULL)
    {
        if ((p -> infoPasien).nama_pasien == x)
        {
            cout << "ID Pasien : " << (p -> infoPasien).id_pasien << endl;
            cout << "Nama Pasien : " << (p -> infoPasien).nama_pasien << endl;
            cout << "Tanggal lahir : " << (p -> infoPasien).tgl_lahir << endl;
            cout << "Alamat : " << (p -> infoPasien).alamat << endl;
            cout << "Tinggi Badan : " << (p -> infoPasien).tb << endl;
            cout << "Berat Badan : " << (p -> infoPasien).bb << endl;
            cout << "Nama Dokter : " << (q -> infoRek).nama_dokter << endl;
            cout << "Tanggal Berkunjung : " << (q -> infoRek).tanggal << endl;
            cout << "Diagnosa : " << (q -> infoRek).diagnosa << endl;
            cout << endl;
        }
        p = p -> next_pasien;
    }
}

int total(listPasien &l)
{
    adr_rm p = l.first;
    int total = 0;
    while (p != NULL)
    {
        total = total + 1;
        p = p -> next_pasien;
    }
    return total;
}

void viewPasien (listPasien &l1, listRek &l2)
{
    system("cls");
    adr_rm p = l1.first;
    adr_rek q = l2.first;
    int n=1;
    int t = total(l1);
    cout << "==========Data Pasien=========" << endl;
    if (p == NULL)
        cout << "Data Kosong" << endl;
    else
    {
        while (p != NULL)
        {
            cout << "ID Pasien : " << (p -> infoPasien).id_pasien << endl;
            cout << "Nama Pasien : " << (p -> infoPasien).nama_pasien << endl;
            cout << "Tanggal lahir : " << (p -> infoPasien).tgl_lahir << endl;
            cout << "Alamat : " << (p -> infoPasien).alamat << endl;
            cout << "Tinggi Badan : " << (p -> infoPasien).tb << endl;
            cout << "Berat Badan : " << (p -> infoPasien).bb << endl;
            cout << "Nama Dokter : " << (q -> infoRek).nama_dokter << endl;
            cout << "Tanggal Berkunjung : " << (q -> infoRek).tanggal << endl;
            cout << "Diagnosa : " << (q -> infoRek).diagnosa << endl;
            cout << endl;
            p = p -> next_pasien;
            cout << endl;
            n++;
        }
        cout << (" Total Pasien : ", t) << endl;
    }
}

void viewPasienByID (listPasien l, int id)
{
adr_rm p = l.first;
    while (((p -> infoPasien).id_pasien != id) && (p -> next_pasien != NULL)) {
        p = p -> next_pasien;
    }
    if ((p -> infoPasien).id_pasien == id) {
            cout << "ID Pasien : " << (p -> infoPasien).id_pasien << endl;
            cout << "Nama Pasien : " << (p -> infoPasien).nama_pasien << endl;
            cout << "Tanggal lahir : " << (p -> infoPasien).tgl_lahir << endl;
            cout << "Alamat : " << (p -> infoPasien).alamat << endl;
            cout << "Tinggi Badan : " << (p -> infoPasien).tb << endl;
            cout << "Berat Badan : " << (p -> infoPasien).bb << endl;
    } else {
        cout << "Pasien tidak ditemukan" << endl;
    }
}
