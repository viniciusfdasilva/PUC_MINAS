/**
 * No da arvore binaria
 * 
 * @author Max do Val Machado
 */
class No {
	public int elemento; // Conteudo do no.
	public No esq; // No da esquerda.
	public No dir; // No da direita.
	public int nivel; // Numero de niveis abaixo do no

	/**
	 * Construtor da classe.
	 * 
	 * @param elemento
	 *            Conteudo do no.
	 */
	No(int elemento) {
		this(elemento, null, null, 1);
	}

	/**
	 * Construtor da classe.
	 * 
	 * @param elemento
	 *            Conteudo do no.
	 * @param esq
	 *            No da esquerda.
	 * @param dir
	 *            No da direita.
	 */
	No(int elemento, No esq, No dir, int nivel) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.nivel = nivel;
	}

	// Cálculo do número de níveis a partir de um vértice
	public No setNivel() {
		this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
		return this;
	}

	// Retorna o número de níveis a partir de um vértice
	public static int getNivel(No no) {
		return (no == null) ? 0 : no.nivel;
	}

}
