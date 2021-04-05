typedef struct Celula{
	int elemento;
	Celula* prox;
}Celula;

void startCelula(int elemento_c){
	Celula* celula = (Celula*)malloc(sizeof(Celula));
	celula->elemento = elemento_c;
	celula->prox = NULL;
}// End startCelula()

void start(){
	Celula* celula = (Celula*)malloc(sizeof(Celula));
	celula->elemento = 0;
	celula->prox = NULL;
}// End start()

