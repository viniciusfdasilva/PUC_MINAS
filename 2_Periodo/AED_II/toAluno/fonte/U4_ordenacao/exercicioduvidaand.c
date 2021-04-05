#include "geracao.h"

bool m1(){
   printf("\nm1");
   return false;
}
bool m2(){
   printf("\nm2");
   return true;
}
int main () {
   printf("\ninicio");
   bool operacao = m1() && m2();
   printf("\nfim: %i", operacao);
}
