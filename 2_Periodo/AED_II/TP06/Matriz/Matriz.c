typedef struct Matriz{
	Celula* inicio;
}Matriz;

Matriz* startMatriz(int ln, int col){
	Matriz* matriz = (Matriz*)malloc(sizeof(Matriz)); 
	Celula* tmp = NULL;
	for(int i = 1; i <= col; i++){
		Celula* celula = (Celula*)malloc(sizeof(Celula));
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
		for(int j = 1; j <= ln; j++){
			Celula* nova = (Celula*)malloc(sizeof(Celula));
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
		}// End if
		cima = baixo = tmp = NULL;
		return matriz;
	}// End for
}// End Matriz()









