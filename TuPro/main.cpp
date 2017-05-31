#include "header.h"

int main()
{
    string input;
    string token[100];
    int counter [100];
    int i,j,k;

    cout<<"Inputan : ";
    getline(cin,input);
    j = input.length();
    bool check = true;
    k = 0;
    i = 0;

    while ( i <= j && input[i]!='\0' && check ) {
        while (input[i] == ' ' && check) {
            i++;
        }
        if (input[i] == 'p' || input[i] == 'q' || input[i] == 'r' || input[i] == 's') {
            i++;
            if (input[i] == ' ' || input[i] == '\0') {
                k++;
                token[k] = '1';
            } else {
                check = false;
            }

        } else if (input[i] == 'n') {
            i++;
            if (input[i] == 'o') {
                i++;
                if (input[i] == 't') {
                    i++;
                    if (input[i] == ' ' || input[i] == '\0') {
                        k++;
                        token[k] = '2';
                    } else {
                        check = false;
                    }
                } else {
                    check = false;
                }
            } else {
                check = false;
            }

        } else if (input[i] == 'a') {
            i++;
            if (input[i] == 'n') {
                i++;
                if (input[i] == 'd') {
                    i++;
                    if (input[i] == ' ' || input[i] == '\0') {
                        k++;
                        token[k] = '3';
                    } else {
                        check = false;
                    }
                } else {
                    check = false;
                }
            } else {
                check = false;
            }

        } else if (input[i] == 'o') {
            i++;
            if (input[i] == 'r') {
                i++;
                if (input[i] == ' ' || input[i] == '\0') {
                    k++;
                    token[k] = '4';
                } else {
                    check = false;
                }
            } else {
                check = false;
            }

        } else if (input[i] == 'x') {
            i++;
            if (input[i] == 'o') {
                i++;
                if (input[i] == 'r') {
                    i++;
                    if (input[i] == ' ' || input[i] == '\0') {
                        k++;
                        token[k] = '5';
                    } else {
                        check = false;
                    }
                } else {
                    check = false;
                }
            } else {
                check = false;
            }

        } else if (input[i] == 'i') {
            i++;
            if (input[i] == 'f') {
                i++;
                if (input[i] == ' ' || input[i] == '\0') {
                    k++;
                    token[k] = '6';
                } else if (input[i] == 'f') {
                    i++;
                    if (input[i] != ' ' || input[i] != '\0') {
                        k++;
                        token[k] = '8';
                    }
                } else {
                    check = false;
                }
            } else {
                check = false;
            }

        } else if (input[i] == 't') {
            i++;
            if (input[i] == 'h') {
                i++;
                if (input[i] == 'e') {
                    i++;
                    if (input[i] == 'n') {
                        i++;
                        if (input[i] == ' ' || input[i] == '\0') {
                            k++;
                            token[k] = '7';
                        }
                    } else {
                        check = false;
                    }
                } else {
                    check = false;
                }
            } else {
                check = false;
            }

        } else if (input[i] == '(') {
            i++;
            if (input[i] == ' ' || input[i] == '\0') {
                k++;
                token[k] = '9';
            } else {
                check = false;
            }

        } else if (input[i] == ')') {
            i++;
            if (input[i] == ' ' || input[i] == '\0') {
                k++;
                token[k] = "10";
            } else {
                check = false;
            }
        } else {
            check = false;
        }
        if (check == false) {
            while (input[i] != ' ' && input[i] != '\0') {
                i++;
            }
            k++; //token
            token[k] = "error";
        }
    }
    cout<<"Token : ";
    for(i=1; i<=k; i++)
    {
        cout<<token[i]<<" ";
    }

    Stack S;
    bool cekToken;
    createStack(S);
    push(S, "#");
    i=1;
    cekToken = true;

    while (token[i] != "" && cekToken) {
        if (token[i] == "1"  && (S.info[top(S)] == "S" || S.info[top(S)]== "H" ||S.info[top(S)]=="#" || S.info[top(S)]=="W" || S.info[top(S)]=="I" || S.info[top(S)] == "Y") ) {
            if (S.info[top(S)]=="S" || S.info[top(S)]=="H" || S.info[top(S)]=="I") {
                pop(S);
                push(S, "X");

            }
            else if (S.info[top(S)]=="#" || S.info[top(S)]=="W" || S.info[top(S)] == "Y") {
                push(S,"X");
            }
            else {
                cekToken = false;
            }
        }
        else if(token[i] == "2" && (S.info[top(S)] == "#" || S.info[top(S)] == "Y" || S.info[top(S)] == "I" || S.info[top(S)] == "H")) {
            if (S.info[top(S)] == "I" || S.info[top(S)] == "H") {
                pop(S);
                push(S, "S");
            }
            else if (S.info[top(S)]=="#" || S.info[top(S)] == "Y")
                push(S, "S");
        }
        else if(token[i] == "6" && (S.info[top(S)]=="Y" || S.info[top(S)]=="#" || S.info[top(S)]=="Y")) {
            if (token[i]=="6")
                push(S,"W");
        }
        else if((token[i] == "3" || token[i] == "4" || token[i] == "5" || token[i] == "8" )&& (S.info[top(S)] == "J"||S.info[top(S)] == "X" ))
        {
            pop(S);
            push(S, "H");
        }
        else if(token[i] == "7" && (S.info[top(S)]=="X" || S.info[top(S)] == "J"))
        {
            if (S.info[top(S)] == "X" || S.info[top(S)] == "J")
            {
                pop(S);
                if (S.info[top(S)] == "W")
                {
                    pop(S);
                    push(S, "I");
                }
            }
        }
        else if(token[i] == "9" && (S.info[top(S)] == "X" ||S.info[top(S)] == "#" || S.info[top(S)] == "W" || S.info[top(S)] == "Y" || S.info[top(S)] == "H" || S.info[top(S)] == "S" || S.info[top(S)] == "I"))
        {
            if (S.info[top(S)] == "H" || S.info[top(S)] == "S" || S.info[top(S)] == "I")
            {
                pop(S);
                push(S, "Y");
            }
            else if ((S.info[top(S)] == "X" ||S.info[top(S)] == "#" || S.info[top(S)] == "W" || S.info[top(S)] == "Y"))
            {
                push(S, "Y");
            }
        }
        else if(token[i] == "10" && (S.info[top(S)] == "X" || S.info[top(S)] == "J"))
        {
            if (S.info[top(S)] == "X" || S.info[top(S)] == "J")
            {
                pop(S);
                if (S.info[top(S)] == "Y")
                {
                    pop(S);
                    push(S, "J");
                }
            }
        }
        else
        {
            cekToken = false;
        }
        i++;
    }
    if (S.info[top(S)]=="X" || S.info[top(S)]=="J")
        pop(S);
        pop(S);
    if (top(S)== -1 && cekToken)
    {
        cout<<"\nVALID";
    }
    else
    {
        cout<<"\nTIDAK VALID";
    }
    cout<<endl;

    return 0;
}
