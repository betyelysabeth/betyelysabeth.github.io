#pragma once
#include "adtuser.h"
#include "adtdoc.h"
#include <string>
#define infotag(p) (p)->infotag
#define infouser(p) (p)->infouser
#define infodoc(p) (p)->infodoc
#define next(p) (p)->next
#define nextC(p) (p)->nextC
#define firstC(p) (p)->firstC
#define first(L) ((L).first)

typedef struct elmlistTag *addresstag;
typedef struct elmlistTChild *addresstchild;
typedef string infotypetag;

struct elmlistTag{
    infotypetag infotag;
    addresstag next;
    addresstchild firstC;
};

struct elmlistTChild{
    addressuser infouser;
    addressdoc infodoc;
    addresstchild nextC;
};

struct listTag{
    addresstag first;
};

addresstag alokTag(infotypetag x);
void createTag(listTag &T);
void insertTag(listTag &L, infotypetag x);
addresstchild alokChild(addressdoc d, addressuser u);
addresstag findTag(listTag &T, infotypetag x);
void insertChildTag(addresstag t, addressuser u, addressdoc d);
void viewTagDoc(listTag &T);
void findMostDoc(listDoc &D, listTag &T, string x);
void printTag(listTag &T);


