/**
 * Pilha estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <stdlib.h>

#define MAXTAM    6
#define bool      short
#define true      1
#define false     0

int array[MAXTAM];   // Elementos da pilha 
int topo;            // Quantidade de array.


/**
 * Inicializacoes
 */
void start(){
   topo = 0;
}


/**
 * Insere um elemento na ultima posicao da 
 * @param x int elemento a ser inserido.
 */
void inserir(int x) {

   //validar insercao
   if(topo >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   }

   array[topo] = x;
   topo++;
}


/**
 * Remove um elemento da ultima posicao da 
 * @return resp int elemento a ser removido.
 */
int remover() {

   //validar remocao
   if (topo == 0) {
      printf("Erro ao remover!");
      exit(1);
   }

   return array[--topo];
}


/**
 * Mostra os array separados por espacos.
 */
void mostrar (){
   int i;

   printf("[ ");

   for(i = topo-1; i >= 0; i--){
      printf("%d ", array[i]);
   }

   printf("]\n");
}


//METODO PRINCIPAL ==============================================================
int main(int argc, char** argv){
   int x1, x2, x3;

   printf("==== PILHA ESTATICA ====\n");

   start();

   inserir(0);
   inserir(1);
   inserir(2);
   inserir(3);
   inserir(4);
   inserir(5);

   printf("Apos insercoes: \n");
   mostrar();

   x1 = remover();
   x2 = remover();
   x3 = remover();

   printf("Apos as remocoes (%d, %d, %d): ", x1, x2, x3);
   mostrar();
}
