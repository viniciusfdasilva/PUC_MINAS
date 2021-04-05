/**
 * Metodo de ordenacao por selecao
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include "geracao.h"

// Algoritmo de ordenacao
void selectionSort() {
   for (i = 0; i < (n - 1); i++) {
      int indice = i;
      for (j = (i + 1); j < n; j++){
         if (array[indice] > array[j]){
            indice = j;
         }
      }
      int auxiliar = array[indice];
      array[indice] = array[i];
      array[i] = auxiliar;
   }
}

int main() {
   srand(time(NULL));
   decrescente();
   //mostrar();		
   clock_t comeco = clock();
   selectionSort();
   clock_t fim = clock();
   double total = (clock() - comeco) / (double)CLOCKS_PER_SEC / 1000.0;

   mostrar();
   printf("Tempo para ordenar: %f ms (%i).", total, isOrdenado());
}
