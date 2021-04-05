/**
 * Algoritmo de ordenacao por insercao
 * @author Max do Val Machado
 * @adaptação Vinicius Francisco da Silva
 * @version 2 01/2015
 * @version 3 09/2017
 */
class Insercao extends Geracao{
	/**
	 * Construtor.
	 */
   public Insercao(){
      super();
   }// End Insercao()

	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Insercao(int tamanho){
      super(tamanho);
   }// End Insercao()

	/**
	 * Algoritmo de ordenacao por insercao.
	 */
	public static void insercao(){
		for (int i = 1; i < n; i++){
			Serie tmp = array[i];
         	int j = i-1;
         while ((j >= 0) && (array[j].getNome().compareTo(tmp.getNome()) >= 1)){
            array[j+1] = array[j];
            j--;
         }// End while
         array[j+1] = tmp;
      }// End for
	}// End insercao()
}// End class Insercao
