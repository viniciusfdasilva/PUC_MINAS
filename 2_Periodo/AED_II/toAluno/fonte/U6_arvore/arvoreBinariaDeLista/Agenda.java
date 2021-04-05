public class Contato {
	private No raiz; 

	public Contato() {
		raiz = new No ('M');
      raiz.esq = new No ('F');
      raiz.dir = new No ('T');
      raiz.esq.esq = new No ('C');

      //outros
	}

	public boolean pesquisarNome(String nome) {
		return pesquisarNome(raiz, nome);
	}

	private boolean pesquisarNome(No no, String nome) {
      boolean resp;
		if (no == null) { 
         resp = false;

      } else if (Char.toUpper(nome.charAt(0)) == no.letra) { 
         resp = false;
         for(Celula i = no.primeiro.prox; i != null; i = i.prox){
            if(i.nome.equals(nome) == true){
               i = null;
               resp = true;
            }
         }

      } else if (Char.toUpper(nome.charAt(0)) < no.letra) { 
         resp = pesquisarNome(no.esq, nome); 

      } else { 
         resp = pesquisarNome(no.dir, nome); 
      }
      return resp;
	}

	public void inserir(Contato contato) throws Exception {
		raiz = inserir(raiz, contato);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * @param no No em analise.
	 * @param x Elemento a ser inserido.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No inserir(No no, Contato contato) throws Exception {
		if (no == null) { 
         no = new No(x); 
      
      } else if (x < no.elemento) { 
         no.esq = inserir(no.esq, x); 

      } else if (x > no.elemento) { 
         no.dir = inserir(no.dir, x); 
      
      } else { 
         throw new Exception("Erro ao inserir!"); 
      }

		return no;
	}

	/**
	 * Metodo publico iterativo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
	public void remover(int x) throws Exception {
		raiz = remover(raiz, x);
	}

	/**
	 * Metodo privado recursivo para remover elemento.
	 * @param no No em analise.
	 * @param x Elemento a ser removido.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se nao encontrar elemento.
	 */
	private No remover(No no, int x) throws Exception {

		if (no == null) { 
         throw new Exception("Erro ao remover!"); 
      
      } else if (x < no.elemento) { 
         no.esq = remover(no.esq, x); 
      
      } else if (x > no.elemento) { 
         no.dir = remover(no.dir, x); 
      
      // Sem no a direita.
      } else if (no.dir == null) { 
         no = no.esq; 

      // Sem no a esquerda.
      } else if (no.esq == null) { 
         no = no.dir; 
         
      // No a esquerda e no a direita.
      } else { 
         no.esq = antecessor(no, no.esq); 
		}
		
		return no;
	}

	/**
	 * Metodo para trocar no removido pelo antecessor.
	 * @param n1 No que teve o elemento removido.
	 * @param n2 No da subarvore esquerda.
	 * @return No em analise, alterado ou nao.
	 */
	private No antecessor(No n1, No n2) {

      // Existe no a direita.
		if (n2.dir != null) { 
         // Caminha para direita.
			n2.dir = antecessor(n1, n2.dir); 

      // Encontrou o maximo da subarvore esquerda.
		} else { 
			n1.elemento = n2.elemento; // Substitui N1 por N2.
			n2 = n2.esq; // Substitui N2 por N2.ESQ.
		}
		return n2;
	}
}
