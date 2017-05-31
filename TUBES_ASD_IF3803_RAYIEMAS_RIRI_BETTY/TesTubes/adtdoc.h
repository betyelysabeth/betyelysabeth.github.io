#pragma once
#include <string>
#define info(p) (p)->info
#define next(p) (p)->next
#define first(L) ((L).first)

using namespace std;

typedef struct elmlistDoc *addressdoc;
typedef string infotypedoc;
struct listTag;

struct elmlistDoc{
    infotypedoc info;
    addressdoc next;
};

struct listDoc{
    addressdoc first;
};

addressdoc alokDoc(infotypedoc x);
void createDoc(listDoc &D);
void insertDoc(listDoc &L, infotypedoc x);
addressdoc findDoc(listDoc &D, infotypedoc x);
void printDoc(listDoc &D);
void viewDocTag(listDoc &D, listTag &T);
void findMostTag(listDoc &D, listTag &T, string x);



