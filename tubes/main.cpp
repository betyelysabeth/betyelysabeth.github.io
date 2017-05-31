#include <iostream>
#include <windows.h>
#include <conio.h>
#include "tubes.h"

using namespace std;

int pil;

    listPasien l1;
    listRek l2;
    adr_rm p;
    adr_rek q;
    infotype_rm x1;
    infotype_rek x2;

int main()
{

    createListPasien(l1);
    menu:
    while(pil != 5) {
        //system("cls");
        cout << ("Sistem Klinik Sederhana") << endl;
        cout << ("================================") << endl;
        cout << ("1. Add Pasien") << endl;
        cout << ("2. Add Rekam Medis") << endl;
        cout << ("3. View Data Pasien") << endl;
        cout << ("4. Edit Rekam Medis by Tanggal Berkunjung") << endl;
        cout << ("5. Exit") << endl;
        cout << ("=================================\n") << endl;
        cout << ("Masukkan Pilihan : ");
        cin >> pil;
        switch(pil)
        {
        case 1:{
            system("cls");
            infotype_rm x1;
            cout << ("Menu Input") << endl;
            cout << ("ID Pasien : ");
            cin >> x1.id_pasien;
            cout << ("Nama Pasien : ");
            cin >> x1.nama_pasien;
            cout << ("Tanggal Lahir : ");
            cin >> x1.tgl_lahir;
            cout << ("Alamat : ");
            cin >> x1.alamat;
            cout << ("Tinggi Badan : ");
            cin >> x1.tb;
            cout << ("Berat Badan : ");
            cin >> x1.bb;
            adr_rm p = alokasi_pasien(x1);

            addPasien(l1, p);

            cout << "Berhasil Di Inputkan" ;
            getch();
            goto menu;
            break;
        }
        case 2:{
                system("cls");
                int id_pasien;

                cout << ("ID Pasien : \n\n");
                cin >> id_pasien;
                adr_rm s = findElm(l1,x1);

                if (s==NULL)
                {
                    s = l1.first;
                    cout << "Data Pasien Ditemukan" << endl;
                    cout << ("Menu Input") << endl;
                    cout << ("Nama Dokter: ");
                    cin >> x2.nama_dokter;
                    cout << ("Tanggal Berkunjung: ");
                    cin >> x2.tanggal;
                    cout << ("Diagnosa: ");
                    cin >> x2.diagnosa;
                    s = s -> next_pasien;
    } else
    {
        cout << "ID Tidak ada yang sesuai\n\n" << endl;
    }

                adr_rek q = alokasi_rm(x2);
                addRekamMedis(l2, q);
                cout << "Berhasil Di Inputkan\n\n" << endl;

                getch();
            goto menu;
            break;
        }
        case 3:{
                system("cls");
                viewPasien(l1,l2);
                getch();
                cout << "\n\n";
                getch();
            goto menu;
        break;
        }
        case 4:{
            system("cls");
            editPasienbyTanggalBerkunjung(l1, l2);
            cout << "\n\n";
            getch();
            goto menu;
        break;
        }
        }
        return 0;
    }
}
