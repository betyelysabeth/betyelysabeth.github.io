#pragma once
#include <string>
#define info(p) (p)->info
#define next(p) (p)->next
#define first(L) ((L).first)

using namespace std;

typedef struct elmlistUser *addressuser;
typedef string infotypeuser;
struct listTag;

struct elmlistUser{
    infotypeuser info;
    addressuser next;
};

struct listUser{
    addressuser first;
};

addressuser alokUser(infotypeuser x);
void createUser(listUser &L);
void insertUser(listUser &L, infotypeuser x);
void printUser(listUser &U);
addressuser findUser(listUser &U, infotypeuser x);
void viewUserTagDoc(listUser &U, listTag &T);
void viewUserInTD(listUser &U, listTag &T, string t, string d);

