#include "adtdoc.h"
#include "adttag.h"
#include <iostream>

using namespace std;

addressdoc alokDoc(infotypedoc x){
    addressdoc p = new elmlistDoc;
    info(p) = x;
    next(p) = NULL;
    return p;
}

void createDoc(listDoc &L){
    first(L) = NULL;
}

void insertDoc(listDoc &L, infotypedoc x){
    addressdoc p = alokDoc(x);
    if(first(L) == NULL){
        first(L) = p;
    } else {
        next(p) = first(L);
        first(L) = p;
    }
}

addressdoc findDoc(listDoc &D, infotypedoc x){
        addressdoc p = first(D);
        while((p != NULL) && (info(p) != x)) {
            p = next(p);
        }
        if((p != NULL)&&(info(p) == x)){
            return p;
        }
        else return NULL;
}

void viewDocTag(listDoc &D, listTag &T){
    addressdoc p = first(D);
    while(p != NULL){
        cout<<"Artikel : ";
        cout<<info(p)<<endl<<"\n";
        addresstag t = first(T);
        cout<<"    Tag = ";
        while(t != NULL){
            addresstchild c = firstC(t);
            while(c != NULL){
                if(infodoc(c) == p){
                    cout<<infotag(t)<<", ";
                    break;
                }
                c = nextC(c);
            }
            t = next(t);
        }
        cout<<endl<<endl<<endl;
        p = next(p);
    }
}

void findMostTag(listDoc &D, listTag &T, string x){
    listDoc DD;
    createDoc(DD);

    addressdoc d = first(D);
    int maxs = 0;
    string maxps;
    addresstag q = findTag(T,x);
    addresstchild c = firstC(q);
    while(d != NULL){
        int maxt = 0;
        c = firstC(q);
        while(c != NULL){
            if(infodoc(c) == d){
                maxt++;
            }
            c = nextC(c);
        }
        if(maxs < maxt){
            createDoc(DD);
            insertDoc(DD, info(d));
            maxs = maxt;
        } else if (maxs == maxt){
            insertDoc(DD, info(d));
        }
        d = next(d);
    }
    addressdoc dc = first(DD);
    while(dc != NULL){
        cout<<info(dc)<<", ";
        dc = next(dc);
    }
    cout<<endl;
}

void printDoc(listDoc &D){
    cout<<endl;
    addressdoc d = first(D);
    int i = 1;
    while(d != NULL){
        cout<<"    "<<i<<". "<<info(d)<<endl<<endl;
        d = next(d);
        i++;
    }
}
