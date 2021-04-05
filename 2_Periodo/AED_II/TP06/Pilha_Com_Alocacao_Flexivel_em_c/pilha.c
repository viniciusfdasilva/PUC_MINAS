/**
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <stdlib.h>
#include <err.h>

//====TIPO CELULA =====
typedef struct Celula {
	Serie* elemento;        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

Celula* novaCelula(int elemento){
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}// End novaCelula()

//PILHA PROPRIAMENTE DITA
Celula* topo; // Sem celula cabeca.

/**
 * Cria uma fila sem elementos.
 */
void start(){
   topo = NULL;
}// End start()

/**
 * Insere elemento na pilha (politica FILO).
 * @param x int elemento a inserir.
 */
void inserir(Serie* x){
   Celula* tmp = novaCelula(x);
   tmp->prox = topo;
   topo = tmp;
   tmp = NULL;
}// End inserir()

/**
 * Remove elemento da pilha (politica FILO).
 * @return Elemento removido.
 */
Serie* remover(){
   if (topo == NULL){
      errx(1, "Erro ao remover!");
   }// End remover()
   Serie* resp = topo->elemento;
   Celula* tmp = topo;
   topo = topo->prox;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}// End remover()

/**
 * Mostra os elementos separados por espacos, comecando do topo.
 */
void mostrar(){
   Celula* i;
   for(i = topo; i != NULL; i = i->prox) {
      imprimir(i->elemento);
   }// End for
}// End mostrar()


//METODO PRINCIPAL ==============================================================
int main(int argc, char** argv){
   int x1, x2, x3;

   printf("==== PILHA FLEXIVEL ====\n");

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

   printf("Apos as remocoes (%d, %d, %d) \n ", x1, x2, x3);
   mostrar();
}
