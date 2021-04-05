/**
 * Metodo de ordenacao quicksort
 * @author Max do Val Machado
 * @version 2 01/2015
 */

#include "geracao.h"

void quicksortRec (int esq, int dir) {
   int i = esq, j = dir;
   int pivo = array[(dir+esq)/2];
   while (i <= j) {
      while (array[i] < pivo) i++;
      while (array[j] > pivo) j--;
      if (i <= j) {
         swap(i, j);
         i++;
         j--;
      }
   }
   if (esq < j)  quicksortRec(esq, j);
   if (i < dir)  quicksortRec(i, dir);
}

// Algoritmo de ordenacao
void quicksort() {
   quicksortRec(0, n-1);
}


int main() {
   srand(time(NULL));
   decrescente();
   //mostrar();		
   clock_t comeco = clock();
   quicksort();
   clock_t fim = clock();
   double total = (clock() - comeco) / (double)CLOCKS_PER_SEC / 1000.0;

   mostrar();
   printf("Tempo para ordenar: %f ms (%i).", total, isOrdenado());
}
