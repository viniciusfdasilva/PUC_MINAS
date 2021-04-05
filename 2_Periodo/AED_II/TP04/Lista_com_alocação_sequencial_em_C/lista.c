/**
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#define MAXTAM    6
#define bool      short
#define true      1
#define false     0

Serie* array[MAXTAM];   // Elementos da pilha 
int n;              // Quantidade de array.

/**
 * Inicializacoes
 */
void start(){
   n = 0;
}// End start()

/**
 * Insere um elemento na primeira posicao da lista e move os demais
 * elementos para o fim da 
 * @param x int elemento a ser inserido.
 */
void inserirInicio(Serie* x){
   int i;
   //validar insercao
   if(n >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   }// End if

   //levar elementos para o fim do array
   for(i = n; i > 0; i--){
      array[i] = array[i-1];
   }// End for
   array[0] = x;
   n++;
}// End inserirInicio()

/**
 * Insere um elemento na ultima posicao da 
 * @param x int elemento a ser inserido.
 */
void inserirFim(Serie* x){
   //validar insercao
   if(n >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   }// End if

   array[n] = x;
   n++;
}// End inserirFim()

/**
 * Insere um elemento em uma posicao especifica e move os demais
 * elementos para o fim da 
 * @param x int elemento a ser inserido.
 * @param pos Posicao de insercao.
 */
void inserir(Serie* x, int pos){
   int i;
   //validar insercao
   if(n >= MAXTAM || pos < 0 || pos > n){
      printf("Erro ao inserir!");
      exit(1);
   }// End if

   //levar elementos para o fim do array
   for(i = n; i > pos; i--){
      array[i] = array[i-1];
   }// End for

   array[pos] = x;
   n++;
}// End inserir()

/**
 * Remove um elemento da primeira posicao da lista e movimenta 
 * os demais elementos para o inicio da mesma.
 * @return resp int elemento a ser removido.
 */
Serie* removerInicio(){
   int i; 
   Serie* resp;
   //validar remocao
   if (n == 0) {
      printf("Erro ao remover!");
      exit(1);
   }// End if
   resp = array[0];
   n--;

   for(i = 0; i < n; i++){
      array[i] = array[i+1];
   }// End for
   return resp;
}// End removerInicio()

/**
 * Remove um elemento da ultima posicao da 
 * @return resp int elemento a ser removido.
 */
Serie* removerFim(){
   //validar remocao
   if (n == 0) {
      printf("Erro ao remover!");
      exit(1);
   }// End if
   return array[--n];
}// End removerFim()

/**
 * Remove um elemento de uma posicao especifica da lista e 
 * movimenta os demais elementos para o inicio da mesma.
 * @param pos Posicao de remocao.
 * @return resp int elemento a ser removido.
 */
Serie* remover(int pos){
   int i, resp;
   //validar remocao
   if (n == 0 || pos < 0 || pos >= n) {
      printf("Erro ao remover!");
      exit(1);
   }// End remover()
   resp = array[pos];
   n--;

   for(i = pos; i < n; i++){
      array[i] = array[i+1];
   }// End for
   return resp;
}// End remover()

/**
 * Mostra os array separados por espacos.
 */
void mostrar(){
   for(int i = 0; i < n; i++){
      imprimir(array[i]);
   }// End for
}// End mostrar()

/**
 * Procura um array e retorna se ele existe.
 * @param x int elemento a ser pesquisado.
 * @return <code>true</code> se o array existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(int x){
   bool retorno = false;
   int i;
   for(i = 0; i < n && retorno == false; i++){
      retorno = (array[i] == x);
   }// End for
   return retorno;
}// End pesquisar()




static bool equals(char* str);
int main(){
   int i = 0;
   const int tamanho = 1000;
   Serie* serie[1000]; 
   char str[tamanho]; 
   char line[tamanho];
   int n = 0;
   int pos = 0;
   Serie* s = NULL;
   for(scanf("%[^\n]\n",str); !equals(str); scanf("%[^\n]\n",str)){     
      serie[i] = serieStart(); 
      ler(serie[i],str);
      imprimir(serie[i]);
      i++;
   }// End for 
