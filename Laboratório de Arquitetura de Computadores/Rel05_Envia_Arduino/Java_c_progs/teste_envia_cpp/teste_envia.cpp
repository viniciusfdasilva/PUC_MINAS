#include <iostream>
#include <windows.h>
#include <cstdlib>
#include <string.h>
#include <stdio.h>
#include <time.h>


// Para este programa o arduino deverá estar esperando 3 números !
using namespace std;

int main()
{

    string p1, p2, p3, porta, linha;
    char *manda;
//    clock_t inicio, fim;

// Nas linhas abaixo você deve substituir com23 pela porta onde o Arduino está
    system("pause");
//    inicio = clock();
    system ("envia.exe com23 1 0 0");
//    fim = clock();
//    double Tempo = (fim - inicio) * 1000.0 / CLOCKS_PER_SEC;
//    printf("Tempo gasto: %g ms.", Tempo);

    system ("envia.exe com23 2 0 0");
    system ("envia.exe com23 1 0 0");
    system ("envia.exe com23 2 0 0");
    system ("envia.exe com23 1 0 0");
    system ("envia.exe com23 2 0 0");
    system ("envia.exe com23 1 0 0");
    system ("envia.exe com23 2 0 0");
    system ("envia.exe com23 1 0 0");
    system ("envia.exe com23 2 0 0");
    system("pause");

    cout<<"\n Digite a porta ->";
    cin>>porta;

// piscando 10 vezes
    for(int i=0;i<10;i++)
    {
        linha = "envia.exe ";
        if(i%2==0) p1="1";
        else p1="0";
        p2="1";
        p3="0";
        linha = linha + porta + " " + p1 + " " + p2 + " " + p3;
        manda = new char[linha.length()+1];
        memcpy(manda, linha.c_str(), linha.length() + 1);
      //system("pause");
        system(manda);

    }

// Um segundo teste

    linha = "envia.exe ";
    cout<<"\n\n\n Digite primeiro numero ->";
    cin>>p1;
    cout<<"\n Digite segundo numero ->";
    cin>>p2;
    p3="0";
    linha = linha + porta + " " + p1+ " "+p2+ " " + p3;
    manda = new char[linha.length()+1];
    memcpy(manda, linha.c_str(), linha.length() + 1);
    cout<<linha;
    system(manda);

    return 0;
}
