/**
 * Metodo de ordenacao por insercao
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include "geracao.h"

void insercaoPorCor(int cor, int h){
   for (int i = (h + cor); i < n; i+=h) {
      int tmp = array[i];
      int j = i - h;
      while ((j >= 0) && (array[j] > tmp)) {
         array[j + h] = array[j];
         j-=h;
      }
      array[j + h] = tmp;
   }
}

// Algoritmo de ordenacao
void shellsort() {
   int h = 1;

   do { h = (h * 3) + 1; } while (h < n);

   do {
      h /= 3;
      for(int cor = 0; cor < h; cor++){
         insercaoPorCor(cor, h);
      }
   } while (h != 1);
}


int main() {
   srand(time(NULL));
   decrescente();
   //mostrar();		
   clock_t comeco = clock();
   shellsort();
   clock_t fim = clock();
   double total = (clock() - comeco) / (double)CLOCKS_PER_SEC / 1000.0;

   mostrar();
   printf("Tempo para ordenar: %f ms (%i).", total, isOrdenado());
}
