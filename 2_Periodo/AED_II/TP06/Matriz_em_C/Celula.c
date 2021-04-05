#include<stdio.h>
#include<string.h>
#include<stdlib.h>
typedef struct Celula{
   int elemento;
   struct Celula* inf; 
   struct Celula* sup; 
   struct Celula* esq; 
   struct Celula* dir;
}Celula;

Celula* startCelula(){
   Celula* celula = (Celula*)malloc(sizeof(Celula));
   celula->elemento = 0; 
   celula->inf = NULL; 
   celula->sup = NULL;
   celula->esq = NULL;
   celula->dir = NULL;
   return celula;
}// End startCelula
