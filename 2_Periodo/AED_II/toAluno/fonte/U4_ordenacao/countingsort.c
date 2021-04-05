/**
 * Metodo de ordenacao por contagem
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include "geracao.h"

//Retorna o maior elemento do arranjo.
int getMaior() {
   int maior = array[0];

   for (i = 0; i < n; i++) {
      if(maior < array[i]){
         maior = array[i];
      }
   }
   return maior;
}


// Algoritmo de ordenacao
void countingSort() {

   //Array para contar o numero de ocorrencias de cada elemento
   int tamCount = getMaior() + 1;
   int* count = (int*) malloc(tamCount * sizeof(int));
   int ordenado[n];

   //Inicializar cada posicao do array de contagem
   for (i = 0; i < tamCount; count[i] = 0, i++);

   //Agora, o count[i] contem o numero de elemento iguais a i
   for (i = 0; i < n; count[array[i]]++, i++);

   //Agora, o count[i] contem o numero de elemento menores ou iguais a i
   for(i = 1; i < tamCount; count[i] += count[i-1], i++);

   //Ordenando
   for(i = n-1; i >= 0; ordenado[count[array[i]]-1] = array[i], count[array[i]]--, i--);

   //Copiando para o array original
   for(i = 0; i < n; array[i] = ordenado[i], i++);
}

int main() {
   srand(time(NULL));
   decrescente();
   //mostrar();		
   clock_t comeco = clock();
   countingSort();
   clock_t fim = clock();
   double total = (clock() - comeco) / (double)CLOCKS_PER_SEC / 1000.0;

   mostrar();
   printf("Tempo para ordenar: %f ms (%i).", total, isOrdenado());
}
