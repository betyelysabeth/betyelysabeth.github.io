#include "adtuser.h"
#include "adttag.h"
#include <iostream>
using namespace std;

addressuser alokUser(infotypeuser x){
    addressuser p = new elmlistUser;
    info(p) = x;
    next(p) = NULL;
    return p;
}

void createUser(listUser &U){
    first(U) = NULL;
}

void insertUser(listUser &U, infotypeuser x){
    addressuser p = alokUser(x);
    if(first(U) == NULL){
        first(U) = p;
    } else {
        next(p) = first(U);
        first(U) = p;
    }
}

addressuser findUser(listUser &U, infotypeuser x){
        addressuser p = first(U);
        while((p != NULL) && (info(p) != x)) {
            p = next(p);
        }
        if((p != NULL)&&(info(p) == x)){
            return p;
        }
        else return NULL;
}

void viewUserTagDoc(listUser &U, listTag &T){
    addressuser u = first(U);
    while(u != NULL){
        cout<<"User : ";
        cout<<info(u)<<endl<<"\n";
        addresstag t = first(T);
        cout<<"   Tag & Artikel = ";
        while(t != NULL){
            addresstchild c = firstC(t);
            while(c != NULL){
                if(infouser(c) == u){
                cout<<infotag(t)<<"-";
                cout<<info(infodoc(c))<<", ";
                }
                c = nextC(c);
            }
            t = next(t);
        }
        cout<<endl<<endl;
        u = next(u);
    }
}

void viewUserInTD(listUser &U, listTag &T, string t, string d){
    addresstag p = findTag(T, t);
    addresstchild q = firstC(p);
    int i = 1;
    while(q != NULL){
        if(info(infodoc(q)) == d){
            cout<<i<<". "<<info(infouser(q))<<endl;
            i++;
        }
        q = nextC(q);
    }
    cout<<endl;
}

void printUser(listUser &U){
    addressuser u = first(U);
    int i = 1;
    while(u != NULL){
        cout<<"   "<<i<<". "<<info(u)<<endl;
        u = next(u);
        i++;
    }
}
