/**
 * Pilha estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Pilha {
   private int[] array;
   private int topo;


   /**
    * Construtor da classe.
    */
   public Pilha () {
      this(6);
   }


   /**
    * Construtor da classe.
    * @param tamanho Tamanho da pilha.
    */
   public Pilha (int tamanho){
      array = new int[tamanho];
      topo = 0;
   }


   /**
    * Insere um elemento na ultima posicao da pilha.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a pilha estiver cheia.
    */
   public void inserir(int x) throws Exception {

      //validar insercao
      if(topo >= array.length){
         throw new Exception("Erro ao inserir!");
      }

      array[topo] = x;
      topo++;
   }


   /**
    * Remove um elemento da ultima posicao da pilha.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a pilha estiver vazia.
    */
   public int remover() throws Exception {

      //validar remocao
      if (topo == 0) {
         throw new Exception("Erro ao remover!");
      }

      return array[--topo];
   }


   /**
    * Mostra os array separados por espacos.
    */
   public void mostrar (){
      System.out.print("[ ");
      for(int i = topo -1; i >= 0; i--){
         System.out.print(array[i] + " ");
      }
      System.out.println("]");
   }


   /**
    * Retorna um boolean indicando se a pilha esta vazia
    * @return boolean indicando se a pilha esta vazia
    */
   public boolean isVazia() {
      return topo == 0; 
   }
}
