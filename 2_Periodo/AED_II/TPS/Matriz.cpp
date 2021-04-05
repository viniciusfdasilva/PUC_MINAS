#include<stdio.h>
#include<string.h>
#include<stdlib.h>
typedef struct Celula{
   int elemento;
   struct Celula* inf; 
   struct Celula* sup; 
   struct Celula* ant; 
   struct Celula* prox;
}Celula;

Celula* inicioCelula(){
   Celula* celula = (Celula*)malloc(sizeof(Celula));
   celula->elemento = 0; 
   celula->inf = NULL; 
   celula->sup = NULL;
   celula->ant = NULL;
   celula->prox = NULL;
   return celula;
}// End inicioCelula

typedef struct Matriz{
	Celula* inicio;
}Matriz;

Matriz* startMatriz(int ln, int col){
	Matriz* matriz = (Matriz*)malloc(sizeof(Matriz));
	Celula* tmp = NULL;
	for(int i = 1; i <= col; i++){
		Celula* celula = inicioCelula();
		if(matriz->inicio == NULL){
			tmp = celula;
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
		for(int j = 1; j < ln; j++){
			Celula* nova = inicioCelula();
			tmp->prox = nova;
			nova->ant = tmp;
			tmp = nova;
		}// End for
		if(i >= 2){
			Celula* cima = matriz->inicio;
			Celula* baixo = matriz->inicio;
			while(baixo->inf != NULL) baixo = baixo->inf;
			while(cima->inf != baixo) cima = cima->inf;
			while(cima->prox != NULL && baixo->prox != NULL){
				cima->prox->inf = baixo->prox;
				baixo->prox->sup = cima->prox;
				cima = cima->prox;
				baixo = baixo->prox;
			}// End while
			cima = baixo = NULL;
		}// End if
		tmp = NULL;
	}// End for
	return matriz;
}// End Matriz()

void inserir(Matriz* matriz,int elemento,int col,int ln){
	int i = 1;
	int j = 1;
	Celula* tmp = matriz->inicio;
	while(j < col){
		tmp = tmp->inf;
		j++;
	}// End while
	while(i < ln){
		tmp = tmp->prox;
		i++;
	}// End while
	tmp->elemento = elemento;
}// End inserir()

int lengthLn(Matriz* matriz){
	int tam = 1;
	for(Celula* i = matriz->inicio; i != NULL; i = i->prox, tam++);
	return tam;
}// End lengthLn()

int lengthCol(Matriz* matriz){
	int tam = 1;
	for(Celula* i = matriz->inicio; i != NULL; i = i->inf, tam++);
	return tam;
}// End lengthCol() 

void mostrarDiagonalPrincipal(Matriz* matriz){
	Celula* j = matriz->inicio;
	while(j != NULL){
		printf("%d ",j->elemento);
		if(j->prox != NULL){
			j = j->prox->inf;
		}// End if
		else{
			j = NULL;
		}// End else
	}// End while
	printf("\n");
}// End mostrarDiagonalPrincipal() 

void mostrarDiagonalSecundaria(Matriz* matriz){
	Celula* j = matriz->inicio;
	while(j->prox != NULL) j = j->prox;
	while(j != NULL){
		printf("%d ",j->elemento);
		if(j->ant != NULL){
			j = j->ant->inf;
		}// End if
		else{
			j = NULL;
		}// End else
	}// End while
	printf("\n");
}// End mostrarDiagonalSecundaria()

void mostrar(Matriz* matriz){
	Celula* indice = matriz->inicio;
	while(indice != NULL){
		for(Celula* i = indice; i != NULL; i = i->prox){
			printf("%d ",i->elemento);
		}// End for
		printf("\n");
		indice = indice->inf;
	}// End while
}// End mostrar()

Matriz* somaMatriz(Matriz* matriz1,Matriz* matriz2){
	if(lengthCol(matriz2) != lengthCol(matriz1) || lengthLn(matriz2) != lengthLn(matriz1)){
		printf("erro");
		exit(1);
	}// End if
	Matriz* nova = startMatriz(lengthLn(matriz1)-1,lengthCol(matriz1)-1);
	Celula* i = matriz1->inicio;
	Celula* j = matriz2->inicio;
	Celula* l = NULL;
	Celula* lne = NULL;
	for(int col = 1; col <= lengthCol(matriz1)-1; col++){
		l = i;
		lne = j;
		for(int ln = 1; ln <= lengthLn(matriz1)-1; ln++){
			inserir(nova,(l->elemento+lne->elemento),col,ln);
			l = l->prox;
			lne = lne->prox;
		}// End for
		i = i->inf;
		j = j->inf;
	}// End for
	return nova;
}// End Matriz

Matriz* multiplicacao(Matriz* matriz1, Matriz* matriz2){
	int soma = 0;
	Matriz* matriz3 = NULL;
	if(lengthCol(matriz1) == lengthLn(matriz2)){
		matriz3 = startMatriz(lengthLn(matriz1)-1,lengthCol(matriz2)-1);
		Celula* ln = matriz1->inicio;
		Celula* col = matriz2->inicio;
		Celula* lne = NULL;
		Celula* colu = NULL;
		for(int linha = 1; linha <= lengthLn(matriz2)-1; linha++){
			for(int coluna = 1; coluna <= lengthCol(matriz1)-1; coluna++){
				lne = ln;
				colu = col;
				while(lne != NULL && colu != NULL){
					soma += (lne->elemento*colu->elemento);
					lne = lne->prox;
					colu = colu->inf;
				}// End while
				inserir(matriz3,soma,coluna,linha);
				ln = ln->inf;
				soma = 0;
			}// End for
			soma = 0;
			ln = matriz1->inicio;
			col = col->prox;
		}// End for
	}// End if
	else{
		printf("erro");
		exit(1);
	}// End else
	return matriz3;
}// End multiplicacao() 

int main(void){
	int i = 0;
	Matriz* m1 = NULL;
	Matriz* m2 = NULL;
	Matriz* m3 = NULL;
	int ocorrencia;
	scanf("%d",&ocorrencia);
	while(i < ocorrencia){
		int ln;
		int col;
		scanf("%d",&ln);
		scanf("%d",&col);
		m1 = startMatriz(ln,col);
		for(int coluna = 1; coluna <= col; coluna++){
			for(int linha = 1; linha <= ln; linha++){
				int x;
				scanf("%d",&x);
				inserir(m1,x,coluna,linha);
			}// End for
		}// End for
		
		int lne;
		int colu;
		scanf("%d",&lne);
		scanf("%d",&colu);
		m2 = startMatriz(lne,colu);
		for(int coluna = 1; coluna <= colu; coluna++){
			for(int linha = 1; linha <= lne; linha++){
				int x;
				scanf("%d",&x);
				inserir(m2,x,coluna,linha);
			}// End for
		}// End for
		mostrarDiagonalPrincipal(m1);
		mostrarDiagonalSecundaria(m1);
		m3 = somaMatriz(m1,m2);
		mostrar(m3);
		Matriz* m4 = multiplicacao(m1,m2);
		mostrar(m4);
		i++;
	}// End while
	return 0; 
}// End main()
 
