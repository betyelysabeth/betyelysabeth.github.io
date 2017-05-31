#include <iostream>
#include <conio.h>
#include <cstdlib>
#include <stdio.h>
#include "adttag.h"
#include "adtdoc.h"
#include "adtuser.h"

using namespace std;

string status = "NotLogged";
string inuser, intag, indoc;
string chs, log;
int x;
listUser U;
listDoc D;
listTag T;

addressdoc d;
addresstag t;
addressuser u;
addresstchild c;


void menuUnlog()
{
    system("cls");
    cout<<"Status User : "<<status<<endl<<endl<<endl;
    cout<<"======================================"<<endl;
    cout<<"           Mini Nebula Blog"<<endl;
    cout<<"======================================"<<endl;
    cout<<"  1. List Article"<<endl;
    cout<<"  2. Beri Tag"<<endl;
    cout<<"  3. View Article with Tag"<<endl;
    cout<<"  4. Find Article with MostTagged by"<<endl;
    cout<<"  5. Find MostTag on Article"<<endl;
    cout<<"  6. LOGIN"<<endl;
    cout<<"  7. Admin"<<endl;
    cout<<"  8. Exit"<<endl;
    cout<<"======================================"<<endl<<endl;
}

void menuAdmin()
{
    system("cls");
    cout<<"Status User : "<<status<<endl<<endl<<endl;
    cout<<"   ================================================"<<endl;
    cout<<"                    A D M I N"<<endl;
    cout<<"   ================================================"<<endl;
    cout<<"     1. Lihat Seluruh Article"<<endl;
    cout<<"     2. Create New Article"<<endl;
    cout<<"     3. Lihat Seluruh User"<<endl;
    cout<<"     4. Lihat Seluruh Tag"<<endl;
    cout<<"     5. View Article with Tag"<<endl;
    cout<<"     6. View Tag with Article"<<endl;
    cout<<"     7. View User with Article & Tag"<<endl;
    cout<<"     8. View User who Give a Tag on an Article"<<endl;
    cout<<"     9. Find Article with MostTagged by"<<endl;
    cout<<"     10. Find MostTag on Article"<<endl;
    cout<<"     11. Back To Main Menu"<<endl;
    cout<<"     12. Exit"<<endl;
    cout<<"  ================================================"<<endl;
}

void logIn()
{
    system("cls");
    cout<<"====================="<<endl;
    cout<<"      L O G I N"<<endl;
    cout<<"====================="<<endl;
    cout<<"   1. Sign In"<<endl;
    cout<<"   2. Sign Up"<<endl;
    cout<<"   3. Back to menu"<<endl;
    cout<<"====================="<<endl;
    cout<<"   Pilih Menu : ";
    cin>>x;
    switch(x)
    {
    case 1:
logawal:
        system("cls");
        cout<<"====================="<<endl;
        cout<<"      L O G I N"<<endl;
        cout<<"====================="<<endl;
        cout<<"  Username : ";
        cin>>log;
        u = findUser(U, log);
        if(u != NULL)
        {
            status = info(u);
        }
        else
        {
            cout<<"User Tidak Ditemukan !";
            getch();
            goto logawal;
        }
        break;

    case 2:
signawal:
    system("cls")   ;
        cout<<"====================="<<endl;
        cout<<"      SIGN UP"<<endl;
        cout<<"====================="<<endl;
        cout<<"Make Username : ";
        cin>>log;
        u = findUser(U, log);
        if(u == NULL)
        {
            insertUser(U, log);
            u = findUser(U, log);
            status = info(u);
        }
        else
        {
            cout<<"Username Sudah Terdaftar, Gunakan Username Lain !";
            getch();
            goto signawal;
        }
        break;
    default :
        break;
    }
}

void makeArtikel(){
    awalartikel:
        system("cls");
        cout<<"========================="<<endl;
        cout<<"   Create New Article"<<endl;
        cout<<"========================="<<endl;
        cout<<"Judul Artikel : ";
        cin>>indoc;
        d = findDoc(D, indoc);
        if(d == NULL)
        {
            insertDoc(D, indoc);
            cout<<endl;
            cout<<"Artikel Berhasil Dibuat.";
            getch();
        }
        else
        {
            cout<<"Judul sudah digunakan, Gunakan Judul Lain !";
            getch();
            goto awalartikel;
        }
}

int main()
{
    createDoc(D);
    createUser(U);
    createTag(T);

    insertUser(U,"Rayie");
    insertUser(U,"Bety");
    insertUser(U,"Riri");
    insertUser(U,"Bagus");

    insertDoc(D,"Pertanian");
    insertDoc(D,"JusAlpukat");
    insertDoc(D,"GreenBay");

    insertTag(T, "Nature");
    insertTag(T, "Cooking");
    insertTag(T, "Health");
    insertTag(T, "Travelling");


    u = findUser(U, "Rayie");
    d = findDoc(D, "Pertanian");
    t = findTag(T, "Nature");
    insertChildTag(t,u,d);

    u = findUser(U, "Rayie");
    d = findDoc(D, "JusAlpukat");
    t = findTag(T, "Cooking");
    insertChildTag(t,u,d);

    u = findUser(U, "Bety");
    d = findDoc(D, "Pertanian");
    t = findTag(T, "Nature");
    insertChildTag(t,u,d);

    u = findUser(U, "Rayie");
    d = findDoc(D, "GreenBay");
    t = findTag(T, "Nature");
    insertChildTag(t,u,d);

    u = findUser(U, "Bety");
    d = findDoc(D, "GreenBay");
    t = findTag(T, "Nature");
    insertChildTag(t,u,d);

    u = findUser(U, "Riri");
    d = findDoc(D, "GreenBay");
    t = findTag(T, "Nature");
    insertChildTag(t,u,d);

    u = findUser(U, "Bagus");
    d = findDoc(D, "JusAlpukat");
    t = findTag(T, "Nature");
    insertChildTag(t,u,d);

    u = findUser(U, "Bagus");
    d = findDoc(D, "Pertanian");
    t = findTag(T, "Nature");
    insertChildTag(t,u,d);
awal :
    menuUnlog();
    cout<< "Pilih Menu : ";
    cin>>x;
    if (x == 1)
    {
        system("cls");
        cout<<"====================="<<endl;
        cout<<"    List Artikel"<<endl;
        cout<<"====================="<<endl;
        printDoc(D);
        cout<<"====================="<<endl<<endl;
        cout<<"Beri Tag ? (y/n) : ";
        cin>>chs;
        if((chs == "Y") || (chs == "y"))
        {
            if(status == "NotLogged")
            {
                logIn();
                goto awal;
            }
            else
            {
                cout<<endl;
                u = findUser(U, status);
                cout<<"Masukkan Judul Artikel : ";
                cin>>indoc;
                d = findDoc(D, indoc);
                cout<<endl;
                cout<<"Masukkan Tag : ";
                cin>>intag;
                t = findTag(T, intag);

                if (t == NULL)
                {
                    insertTag(T, intag);
                    t = findTag(T, intag);
                    insertChildTag(t, u, d);
                    goto awal;
                }
                else
                {
                    insertChildTag(t, u, d);
                    goto awal;
                }
            }
        }
        else
        {
            goto awal;
        }
    }
    else if (x == 2)
    {
        if(status == "NotLogged")
        {
            logIn();
            goto awal;
        }
        else
        {
            u = findUser(U, status);
            system("cls");
            cout<<"====================="<<endl;
            cout<<"    List Artikel"<<endl;
            cout<<"====================="<<endl;
            printDoc(D);
            cout<<"====================="<<endl;
            cout<<endl;
            cout<<"Masukkan Judul Artikel : ";
            cin>>indoc;
            d = findDoc(D, indoc);

            cout<<"Masukkan Tag : ";
            cin>>intag;
            t = findTag(T, intag);

            if (t == NULL)
            {
                insertTag(T, intag);
                t = findTag(T, intag);
                insertChildTag(t, u, d);
                goto awal;
            }
            else
            {
                insertChildTag(t, u, d);
                goto awal;
            }
        }
    }
    else if (x == 3)
    {
        system("cls");
        cout<<"========================================================="<<endl;
        cout<<"                    List Article"<<endl;
        cout<<"========================================================="<<endl<<endl;
        viewDocTag(D,T);
        cout<<"========================================================="<<endl;
        cout<<"Back to menu...";
        getch();
        goto awal;
    }
    else if (x == 4)
    {
        system("cls");
        cout<<endl;
        cout<<"Input Tag : ";
        cin>> intag;
        cout<<endl;
        cout<<"======================================"<<endl;
        cout<<"     The Most Tagged with "<<intag<<endl;
        cout<<"======================================"<<endl<<endl;
        findMostTag(D,T,intag);
        cout<<endl;
        cout<<"======================================"<<endl;
        cout<<"Back to menu...";
        getch();
        goto awal;

    }
    else if (x == 5)
    {
        system("cls");
        cout<<endl;
        cout<<"Input Doc : ";
        cin>> indoc;
        cout<<"======================================"<<endl;
        cout<<"   "<<indoc<<" Got Most Tagged with "<<endl;
        cout<<"======================================"<<endl<<endl;
        findMostDoc(D,T,indoc);
        cout<<endl;
        cout<<"======================================"<<endl;
        cout<<"Back to menu...";
        getch();
        goto awal;
    }
    else if (x == 6)
    {
        if(status == "NotLogged")
        {
            logIn();
            goto awal;
        }
        else
        {
            cout<<endl;
            cout<<"You've Logged In !"<<endl;
            cout<<"Do you want to Logout (y/n) ? ";
            cin>>chs;
            if((chs == "y") || (chs == "Y")) {
                status = "NotLogged";
            }
            goto awal;
        }
    }
    else if (x == 7)
    {
    awaladmin:
        system("cls");
        log = "";
        cout<<"================================="<<endl;
        cout<<"           A D M I N"<<endl;
        cout<<"================================="<<endl;
        cout<<"  Password : ";
        char ch = getch();
        while(ch != 13){
            log.push_back(ch);
            cout<< '*';
            ch = getch();
        }
        if (log == "tubesASD"){
        adminjadi:
            status = "A D M I N";
            menuAdmin();
            cout<<endl;
            cout<<"   Pilih Menu : ";
            cin>>x;
            if(x == 1){
                system("cls");
                cout<<"====================="<<endl;
                cout<<"    List Artikel"<<endl;
                cout<<"====================="<<endl;
                printDoc(D);
                cout<<"====================="<<endl;
                cout<<"Back to menu...";
                getch();
                goto adminjadi;
            }
            else if (x == 2)
            {
                makeArtikel();
                goto adminjadi;
            }
            else if (x == 3)
            {
                system("cls");
                cout<<"====================="<<endl;
                cout<<"     List User"<<endl;
                cout<<"====================="<<endl;
                printUser(U);
                cout<<"====================="<<endl;
                cout<<"Back to menu...";
                getch();
                goto adminjadi;
            }
            else if (x == 4)
            {
                system("cls");
                cout<<"====================="<<endl;
                cout<<"     List TAG "<<endl;
                cout<<"====================="<<endl;
                printTag(T);
                cout<<"====================="<<endl;
                cout<<"Back to menu...";
                getch();
                goto adminjadi;
            }
            else if (x == 5)
            {
                system("cls");
                cout<<"========================================================="<<endl;//NOMOR 4
                cout<<"                 List Article With Tag"<<endl;
                cout<<"========================================================="<<endl<<endl;
                viewDocTag(D,T);
                cout<<"========================================================="<<endl;
                cout<<"Back to menu...";
                getch();
                goto adminjadi;
            }
            else if (x == 6)
            {
                system("cls");
                cout<<"========================================================="<<endl; //NOMOR 5
                cout<<"                  List Tag With Article"<<endl;
                cout<<"========================================================="<<endl<<endl;
                viewTagDoc(T);
                cout<<"========================================================="<<endl;
                cout<<"Back to menu...";
                getch();
                goto adminjadi;
            }
            else if (x == 7)
            {
                system("cls");
                cout<<"========================================================="<<endl; //NOMOR 6
                cout<<"              List User With Tag & Article"<<endl;
                cout<<"========================================================="<<endl<<endl;
                viewUserTagDoc(U,T);
                cout<<"========================================================="<<endl;
                cout<<"Back to menu...";
                getch();
                goto adminjadi;
            }
            else if (x == 8)
            {
                system("cls");
                cout<<endl;
                cout<<"Input TAG : ";
                cin>> intag;
                cout<<"Input Article : ";
                cin>> indoc;
                cout<<endl;
                cout<<"========================================================="<<endl; // NOMOR 7
                cout<<"  List User Who Tag : "<<intag<<" on Article : "<<indoc<<endl;
                cout<<"========================================================="<<endl<<endl;
                viewUserInTD(U,T,intag,indoc);
                cout<<"========================================================="<<endl;
                cout<<"Back to menu...";
                getch();
                goto adminjadi;
            }
            else if (x == 9)
            {
                system("cls");
                cout<<endl;
                cout<<"Input Tag : ";
                cin>> intag;
                cout<<endl;
                cout<<"======================================"<<endl; //NOMOR 8
                cout<<"     The Most Tagged with "<<intag<<endl;
                cout<<"======================================"<<endl<<endl;
                findMostTag(D,T,intag);
                cout<<endl;
                cout<<"======================================"<<endl;
                cout<<"Back to menu...";
                getch();
                goto adminjadi;
            }
            else if (x == 10)
            {
                system("cls");
                cout<<endl;
                cout<<"Input Doc : ";
                cin>> indoc;
                cout<<"======================================"<<endl; //NOMOR 9
                cout<<"  "<<indoc<<" Got Most Tagged with "<<endl;
                cout<<"======================================"<<endl<<endl;
                findMostDoc(D,T,indoc);
                cout<<endl;
                cout<<"======================================"<<endl;
                cout<<"Back to menu...";
                getch();
                goto adminjadi;
            }
            else if(x == 11)
            {
                status = "NotLogged";
                goto awal;
            }
            else {

            }
        } else {
            goto awaladmin;
        }
    } else {
        exit(0);
    }
}
