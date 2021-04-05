#include <stdlib.h>
typedef struct Celula{
	int elemento;
	struct Celula* prox;
	struct Celula* ant;
    struct Celula* sup;
	struct Celula* inf;
}Celula;

void inicioCelula(int x){
	Celula* celula = (Celula*)malloc(sizeof(Celula));
	celula->elemento = x;
	celula->prox = NULL;
	celula->ant = NULL;
	celula->sup = NULL;
	celula->inf = NULL;
}// End startCelula()

void start(){
	Celula* celula = (Celula*)malloc(sizeof(Celula));
	celula->elemento = 0;
	celula->prox = NULL;
	celula->ant = NULL;
	celula->sup = NULL;
	celula->inf = NULL;
}// End startCelula() 
int main(void){
	return 0;
}