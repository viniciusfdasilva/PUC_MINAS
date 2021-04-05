class Arvore{
	No raiz;

	public Arvore(){
		this.raiz = null;
	}// End Arvore()

	/**
	 * Metodo publico iterativo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(Serie x) throws Exception {
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No inserir(Serie x, No i) throws Exception {
		if (i == null) {
         i = new No(x);
      } else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
         i.esq = inserir(x, i.esq);

      } else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
         i.dir = inserir(x, i.dir);
      } else {
         throw new Exception("Erro ao inserir!");
      }

		return i;
	}
	
	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(String x) {
		MyIO.print("raiz ");
		return pesquisar(x,raiz);
	}

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @param i No em analise.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	private boolean pesquisar(String x, No i){
      boolean resp;
		if (i == null) {
         resp = false;

      }else if(x.compareTo(i.elemento.getNome()) < 0){
      	 MyIO.print("esq ");
         resp = pesquisar(x,i.esq);
      }else if(x.compareTo(i.elemento.getNome()) > 0){
      	 MyIO.print("dir ");
         resp = pesquisar(x, i.dir);
      }else{
         resp = true;
      }// End else
      return resp;
	}// End pesquisar()

	/**
	 * Metodo publico iterativo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
	public void remover(String x) throws Exception{
		raiz = remover(x, raiz);
	}

	/**
	 * Metodo privado recursivo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se nao encontrar elemento.
	 */
	private No remover(String x, No i) throws Exception{
		if (i == null) {
         //throw new Exception("Erro ao remover!");
      } else if (x.compareTo(i.elemento.getNome()) < 0) {
         i.esq = remover(x, i.esq);

      } else if (x.compareTo(i.elemento.getNome()) > 0) {
         i.dir = remover(x, i.dir);

      // Sem no a direita.
      } else if (i.dir == null) {
         i = i.esq;

      // Sem no a esquerda.
      } else if (i.esq == null) {
         i = i.dir;

      // No a esquerda e no a direita.
      } else {
         i.esq = antecessor(i, i.esq);
		}
		return i;
	}

	/**
	 * Metodo para trocar no removido pelo antecessor.
	 * @param i No que teve o elemento removido.
	 * @param j No da subarvore esquerda.
	 * @return No em analise, alterado ou nao.
	 */
	private No antecessor(No i, No j) {

      // Existe no a direita.
		if (j.dir != null) {
         // Caminha para direita.
			j.dir = antecessor(i, j.dir);

      // Encontrou o maximo da subarvore esquerda.
		} else {
			i.elemento = j.elemento; // Substitui i por j.
			j = j.esq; // Substitui j por j.ESQ.
		}
		return j;
	}

	public void mostrarCentral(){
		mostrarCentral(this.raiz);
	}// End mostrarCentral()

	private void mostrarCentral(No i){
		if(i != null){
			mostrarCentral(i.esq);
			System.out.println(i.elemento.getNome());
			mostrarCentral(i.dir);
		}// End if
	}// End mostrarCentral()
}// End Arvore












