#include "header.h"

void createStack(Stack &S)
{
    top(S)= -1;
}

void push (Stack &S, infotype x)
{
    if(top(S)!=19)
    {
        top(S)++;
        S.info[top(S)] = x;
    }
}

infotype pop(Stack &S)
{
    if(top(S)>=0)
    {
        string x = S.info[top(S)];
        top(S)--;
        return x;
    }
}
