#include <stdio.h>
#include <stdlib.h>
typedef struct Pilha{
	Celula* topo;
}Pilha;

void startPilha(){
	Pilha* pilha = (Pilha*)malloc(sizeof(Pilha));
	pilha->topo = NULL
}// End startPilha()

void inserir(int x){
	Pilha* pilha = (Pilha*)malloc(sizeof(Pilha));
	Celula* celula = (Celula*)malloc(sizeof(Celula));
	celula->elemento = x;
	celula->prox = topo;
	topo = topo->prox;
	free(pilha);
}// End inserir()

int remover(){
	if(isVazia()){
		printf("ERRO\n");
		exit(1);
	}// End if
	Pilha* pilha = (Pilha*)malloc(sizeof(Pilha))
	Celula* celula = (Celula*)malloc(sizeof(Celula));
	int resp =	pilha->topo->elemento;
	Celula* tmp = pilha->topo;
	pilha->topo = pilha->tmp->prox;
	free(tmp);
}// End remover()

bool isVazia(){
	Pilha* pilha = (Pilha*)malloc(sizeof(Pilha));
	bool resp = false;
	if(pilha->topo == NULL){
		resp = true;
	}// End if
	free(pilha);
	return resp;
}// End isVazia()
