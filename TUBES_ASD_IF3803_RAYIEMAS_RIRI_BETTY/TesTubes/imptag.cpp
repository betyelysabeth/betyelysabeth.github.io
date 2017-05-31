#include "adttag.h"
#include <iostream>
using namespace std;

addresstag alokTag(infotypetag x){
    addresstag p = new elmlistTag;
    infotag(p) = x;
    next(p) = NULL;
    firstC(p) = NULL;
    return p;
}

addresstchild alokChild(addressdoc d, addressuser u){
    addresstchild p = new elmlistTChild;
    infodoc(p) = d;
    infouser(p) = u;
    nextC(p) = NULL;
    return p;
}

void createTag(listTag &L){
    first(L) = NULL;
}

void insertTag(listTag &L, infotypetag x){
    addresstag p = alokTag(x);
    if(first(L) == NULL){
        first(L) = p;
    } else {
        next(p) = first(L);
        first(L) = p;
    }
}

void insertChildTag(addresstag t, addressuser u, addressdoc d){
    addresstchild q = alokChild(d,u);
    if(firstC(t) == NULL){
        firstC(t) = q;
    } else {
        nextC(q) = firstC(t);
        firstC(t) = q;
    }
}

addresstag findTag(listTag &T, infotypetag x){
        addresstag p = first(T);
        while((p != NULL) && (infotag(p) != x)) {
            p = next(p);
        }
        if((p != NULL)&&(infotag(p) == x)){
            return p;
        }
        else return NULL;
}

void viewTagDoc(listTag &T){
    listDoc DD;
    createDoc(DD);
    addresstag p = first(T);
    while(p != NULL){
        createDoc(DD);
        cout<<"TAG : ";
        cout<<infotag(p)<<endl<<"\n";
        addresstchild c = firstC(p);
        cout<<"    Article = ";
        while(c != NULL){
            addressdoc q = findDoc(DD, info(infodoc(c)));
            if(q == NULL){
                insertDoc(DD, info(infodoc(c)));
                cout<<info(infodoc(c))<<", ";
            }
            c = nextC(c);
        }
        cout<<endl<<endl;
        p = next(p);
    }
}

void findMostDoc(listDoc &D, listTag &T, string x){
    listTag TT;
    createTag(TT);
    addresstag t = first(T);
    int maxs = 0;
    addressdoc d = findDoc(D,x);
    addresstchild c;
    while(t != NULL){
        int maxt = 0;
        c = firstC(t);
        while(c != NULL){
            if(infodoc(c) == d){
                maxt++;
            }
            c = nextC(c);
        }
        if(maxs < maxt){
            createTag(TT);
            insertTag(TT, infotag(t));
            maxs = maxt;
        } else if (maxs == maxt){
            insertTag(TT, infotag(t));
        }
        t = next(t);
    }
    addresstag tc = first(TT);
    while(tc != NULL){
        cout<<infotag(tc)<<", ";
        tc = next(tc);
    }
    cout<<endl;
}

void printTag(listTag &T){
    addresstag t = first(T);
    int i = 1;
    while(t != NULL){
        cout<<"   "<<i<<". "<<infotag(t)<<endl;
        t = next(t);
        i++;
    }
}

