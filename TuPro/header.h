#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

#include <iostream>
#define top(S) S.top

using namespace std;

typedef string infotype;
struct Stack{
    infotype info[20];
    int top;
};

void createStack(Stack &S);
void push (Stack &S, infotype x);
infotype pop(Stack &S);

#endif // HEADER_H_INCLUDED
