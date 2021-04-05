/**
 * Celula simplesmente encadeada
 * @author Joao Paulo Domingos Silva
 * @version 1.1 02/2012
 */
class Celula{
	public Serie elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.

	/**
	 * Construtor da classe.
	 * @param elemento Elemento inserido na celula.
	 */
	Celula(int elemento) {
		this.elemento = elemento;
		this.prox = null;
	}// End Celula()

	/**
	 * Construtor da classe.
	 * @param elemento Elemento inserido na celula.
	 * @param prox Aponta a celula prox.
	 */
	Celula(int elemento, Celula prox){
		this.elemento = elemento;
		this.prox = prox;
	}// End Celula()
}// End class Celula()

/**
 * Lista dinamica simplesmente encadeada
 * @author Joao Paulo Domingos Silva
 * @version 1.1 02/2012
 */
public class Lista{
	private Celula primeiro; // Primeira celula: SEM elemento valido.
	private Celula ultimo; // Ultima celula: COM elemento valido.

	/**
	 * Construtor da classe: Instancia uma celula (primeira e ultima).
	 */
	public Lista(){
		primeiro = new Celula(-1);
		ultimo = primeiro;
	}// End Lista()
	
	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(String x){
		boolean retorno = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         		if(i.elemento.getNome() == x){
            			retorno = true;
            			i = ultimo;
         		}// End if 
		}// End for
		return retorno;
	}// End pesquisar()
	
	/**
	 * Insere um elemento na ultima posicao da sequencia.
	 * @param elemento Elemento a inserir.
	 */
	public void inserirFim(int elemento){
		Celula tmp = new Celula(elemento);
		ultimo.prox = tmp;
		ultimo = ultimo.prox;
      		tmp = null;
	}// End inserirFim()
	
	public String remover(String str){
		
	}// End remover()
}// End class Lista
