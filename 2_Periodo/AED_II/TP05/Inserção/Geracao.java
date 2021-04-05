/**
 * Geracao de elementos de um array
 * @author Max do Val Machado
 * @version 2 01/2015
 */

import java.util.*;

class Geracao {
   protected static Serie[] array;
   protected static int n;


	/**
	 * Construtor.
	 */
   public Geracao(){
      array = new Serie[100];
      n = array.length;
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Geracao(int tamanho){
      array = new Serie[tamanho];
      n = array.length;
   }

	/**
	 * Mostra os array de um array.
	 * @param int k indica a quantidade de elementos do array a serem mostrados.
	 */
	public static void mostrar(int k) {
		for (int i = 0; i < k; i++) {
			array[i].imprimir();
		}
	}


	/**
	 * Mostra os array de um array.
	 */
   public static void mostrar() {
      for (int i = 0; i < n; i++) {
         array[i].imprimir();
      }
   }


   /**
    * Troca o conteudo de duas posicoes do array
    * @param i int primeira posicao
    * @param j int segunda posicao
    */
   public static void swap(int i, int j) {
      Serie temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }


   /**
    * Retorna o timestamp atual
    * @return timestamp atual
    */
   public static long now(){
      return new Date().getTime();
   }
}
