/**
 * Metodo de ordenacao da bolha
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include "geracao.h"

// Algoritmo de ordenacao
void bubbleSort() {
   for (i = (n - 1); i > 0; i--) {
      for (j = 0; j < i; j++) {
         if (array[j] > array[j + 1]) {
            int auxiliar = array[j + 1];
            array[j + 1] = array[j];
            array[j] = auxiliar;
         }
      }
   }
}


int main() {
   decrescente();
   srand(time(NULL));
   //mostrar();		
   clock_t comeco = clock();
   bubbleSort();
   clock_t fim = clock();
   double total = (clock() - comeco) / (double)CLOCKS_PER_SEC / 1000.0;

   mostrar();
   printf("Tempo para ordenar: %f ms (%i).", total, isOrdenado());
}
