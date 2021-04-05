/**
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista{
   private Serie[] array;
   private int n;
   int cont;
   /**
    * Construtor da classe.
    */
   public Lista(){
      this(6);
   }// End Lista

   /**
    * Construtor da classe.
    * @param tamanho Tamanho da lista.
    */
   public Lista(int tamanho){
      array = new Serie[tamanho];
      n = 0;
      cont = 0;
   }// End Lista()

   /**
    * Insere um elemento na primeira posicao da lista e move os demais
    * elementos para o fim da lista.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirInicio(Serie x) throws Exception {
      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }// End if

      //levar elementos para o fim do array
      for(int i = n; i > 0; i--){
         array[i] = array[i-1];
      }// End for

      array[0] = x;
      n++;
   }// End inserirInicio()

   /**
    * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirFim(Serie x) throws Exception {
      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }// End if

      array[n] = x;
      n++;
   }// End inserirFim()

   /**
    * Insere um elemento em uma posicao especifica e move os demais
    * elementos para o fim da lista.
    * @param x int elemento a ser inserido.
    * @param pos Posicao de insercao.
    * @throws Exception Se a lista estiver cheia ou a posicao invalida.
    */
   public void inserir(Serie x, int pos) throws Exception {
      //validar insercao
      if(n >= array.length || pos < 0 || pos > n){
         throw new Exception("Erro ao inserir!");
      }// End if

      //levar elementos para o fim do array
      for(int i = n; i > pos; i--){
         array[i] = array[i-1];
      }// End for

      array[pos] = x;
      n++;
   }// End inserir

   /**
    * Remove um elemento da primeira posicao da lista e movimenta 
    * os demais elementos para o inicio da mesma.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Serie removerInicio() throws Exception {
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }// End if

      Serie resp = array[0];
      n--;

      for(int i = 0; i < n; i++){
         array[i] = array[i+1];
      }// End for
      return resp;
   }// End removerInicio()

   /**
    * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Serie removerFim() throws Exception {
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }// End if
      return array[--n];
   }// End removerFim()

   /**
    * Remove um elemento de uma posicao especifica da lista e 
    * movimenta os demais elementos para o inicio da mesma.
    * @param pos Posicao de remocao.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
    */
   public Serie remover(int pos) throws Exception {
      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }// End if
      Serie resp = array[pos];
      n--;

      for(int i = pos; i < n; i++){
         array[i] = array[i+1];
      }// End for
      return resp;
   }// End remover()

   /**
    * Mostra os elementos da lista separados por espacos.
    */
   public void mostrar(){
      for(int i = 0; i < n; i++){
        array[i].imprimir();
      }// End for
   }// End mostrar()

   /**
    * Procura um elemento e retorna se ele existe.
    * @param x int elemento a ser pesquisado.
    * @return <code>true</code> se o array existir,
    * <code>false</code> em caso contrario.
    */
   public boolean pesquisar(Serie x){
      boolean retorno = false;
      for (int i = 0; i < n && retorno == false; i++) {
         retorno = (array[i] == x);
      }// End for
      return retorno;
   }// End pesquisar()
   public void mostrarRec (){
      mostrarRec(0);
   }// End mostrarRec()

   public void mostrarRec(int i){
      if(i < n){
         array[i].imprimir();
         mostrarRec(i+1);
      }// End if
   }// End mostrarRec()

   public boolean pesquisaBinaria(String str){
   		int esq = 0;
   		int dir = n-1;
   		int meio;
   		boolean resp = false;
   		while(esq <= dir){
   			meio = (esq+dir)/2;
   			contNumeroComparacoes();
   			if(str.equals(array[meio].getNome())){
   				resp = true;
   				esq = n;
   			}// End if
   			else if(str.compareTo(array[meio].getNome()) >= 1){
   				contNumeroComparacoes();
   				esq = meio+1;
   			}// End else if
   			else{
   				contNumeroComparacoes();
   				dir = meio-1;
   			}// End if
   		}// End while
   		return resp;
   }// End pesquisaBinaria()

   public int contNumeroComparacoes(){
		return cont++;
	}// End contnumeroComparacoes()
}// End class Lista
