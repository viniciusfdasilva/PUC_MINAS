

CelulaDupla* getMeio(int esq,int dir){
   int cont = 0;
   CelulaDupla i = primeiro->prox;
   while(cont < (int)((esq+dir)/2)){
      i = i->prox;
      cont++;
   }// End while
   return i;
}// End getMeio() 

void quicksortRecNome(CelulaDupla* esq,CelulaDupla* dir,int begin,int end){
   // Criando as referencias de ponteiro para o inicio e final da estrutura
   Serie* i = esq; 
   Serie* j = dir;
   //Criando referencias inteiras de um ponteiro para o inicio e final da estrutura
   int inicio = begin;
   int fim = end;
   Serie* pivo = getMeio(esq,dir)->elemento;
   while(inicio <= fim){
      while(strcmp(array[i]->nome,pivo->nome) > 0){ 
         i = i->prox;
         inicio++;
      }// End while
      while(strcmp(array[j]->nome,pivo->nome) < 0){ 
         j = j->ant;
         fim--;
      }// End while
      if(inicio <= fim){
         swap(i,j);
         i = i->prox;
         j = j->ant;
         inicio++;
         fim--;
      }// End if
   }// End while
   if (begin < fim) quicksortRecNome(esq,j,begin,fim);
   if (inicio < end) quicksortRecNome(i,dir,inicio,end);
}// End quicksortRecNome()

void quicksortPais(){
   quicksortRecPais(primeiro->prox,ultimo,0,tamanho()-1);
}// End quicksortPais

void quicksortRecPais(CelulaDupla* esq,CelulaDupla* dir,int begin,int end){
   // Criando as referencias de ponteiro para o inicio e final da estrutura
   Serie* i = esq; 
   Serie* j = dir;
   //Criando referencias inteiras de um ponteiro para o inicio e final da estrutura
   int inicio = begin;
   int fim = end;
   quicksortRecNome(esq,dir,begin,end);
   Serie* pivo = getMeio(esq,dir)->elemento;
   while(inicio <= fim){
      while(strcmp(array[i]->pais,pivo->pais) < 0){ 
         i = i->prox;
         inicio++;
      }// End while
      while(strcmp(array[j]->pais,pivo->pais) > 0){ 
         j = j->ant;
         fim--;
      }// End while
      if(inicio <= fim){
         swap(i,j);
         i = i->prox;
         j = j->ant;
         inicio++;
         fim--;
      }// End if
   }// End while
   if (begin < fim) quicksortRecPais(esq,j,begin,fim);
   if (inicio < end) quicksortRecPais(i,dir,inicio,end);
}// End quicksort()


int main() {
   srand(time(NULL));
   decrescente();
   //mostrar();		
   clock_t comeco = clock();
   quicksort();
   clock_t fim = clock();
   double total = (clock() - comeco) / (double)CLOCKS_PER_SEC / 1000.0;

   mostrar();
   printf("Tempo para ordenar: %f ms (%i).", total, isOrdenado());
}
