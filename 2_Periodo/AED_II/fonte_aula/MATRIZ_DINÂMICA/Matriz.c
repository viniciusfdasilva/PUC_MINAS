#include <stdlib.h>
#include <stdbool.h>
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

typedef struct Matriz{
	Celula* inicio;
}Matriz;

void startMatriz(int ln, int col){
	Matriz* matriz = (Matriz*)malloc(sizeof(Matriz));
	Celula* tmp;
	for(int i = 1; i <= col; i++){
		Celula* celula = (Celula*)malloc(sizeof(Celula));
		bool isVazia();
		if(isVazia()){
			matriz->inicio = celula; 
		}// End if
		else{
			tmp = matriz->inicio;	
			while(tmp->inf != NULL){
				tmp = tmp->inf;
			}// End while
			tmp->inf = celula;
			celula->sup = tmp;
			tmp = tmp->inf;
		}// End else
		for(int j = 1; j <= ln; j++){
			Celula* nova = (Celula*)malloc(sizeof(Celula));
			tmp->prox = nova;
			nova->ant = tmp;
			tmp = nova;
		}// End for
		if(i >= 2){
			Celula* cima = matriz->inicio;
			Celula* baixo = matriz->inicio;
			while(baixo->inf != NULL){
				baixo = baixo->inf;
			}// End while
			while(cima->inf != baixo){
				cima = cima->inf;
			}// End while
			while(cima->prox != NULL && baixo->prox != NULL){
				cima->prox->inf = baixo->prox;
				baixo->prox->sup = cima->prox;
				cima = cima->prox;
				baixo = baixo->prox;
			}// End while
		}// End if
		free(tmp);
	}// End for
}// End startMatriz()

bool isVazia(){
	Matriz* matriz = (Matriz*)malloc(sizeof(Matriz));
	bool resp = false;
	if(matriz->inicio == NULL) resp = true;
	free(matriz);
	return resp;
}// End isVazia()

int main(void){
	return 0;
}// End main()