class Matriz{
	private Celula inicio;
	public Matriz(int ln, int col){
		Celula tmp;
		for(int i = 1; i <= col; i++){
			Celula celula = new Celula();
			if(isVazia()){
				tmp = celula;
				this.inicio = celula;
			}// End if
			else{
				tmp = this.inicio;
				while(tmp.inf != null){
					tmp = tmp.inf;
				}// End while	
				tmp.inf = celula;
				celula.sup = tmp;
				tmp = tmp.inf;
			}// End else
			for(int j = 1; j <= ln; j++){
				Celula nova = new Celula();
				tmp.prox = nova;
				nova.ant = tmp;
				tmp = nova;
			}// End for
			if(i >= 2){
				Celula cima = this.inicio;
				Celula baixo = this.inicio;
				while(baixo.inf != null){
					baixo = baixo.inf;
				}// End while
				while(cima.inf != baixo){
					cima = cima.inf;
				}// End while
				while(cima.prox != null && baixo.prox != null){
					cima.prox.inf = baixo.prox;
					baixo.prox.sup = cima.prox;
					cima = cima.prox;
					baixo = baixo.prox;
				}// End while
			}// End if
			tmp = null;
		}// End for
	}// End Matriz()

	public boolean isVazia(){
		return this.inicio == null ? true : false;
	}// End isVazia()

	public int lengthCol(){
		int cont = 0;
		for(Celula i = this.inicio; i != null; i = i.inf){
			cont++;
		}// End for
		return cont;
	}// End lengthCol()

	public int lengthLn(){
		int cont = 0;
		for(Celula i = this.inicio; i != null; i = i.prox){
			cont++;
		}// End for
		return cont;
	}// End lengthCol()

	public int somaElementos(Matriz matriz){
		int soma = 0;
		for(Celula i = matriz.inicio; i != null; i = i.inf){
			for(Celula j = i; j != null; j = j.prox){
				soma += i.elemento;
			}// End for
		}// End for
		return soma;
	}// End somaElementos()

	public int multiplicacaoElementos(Matriz matriz){
		int soma = 0;
		for(Celula i = matriz.inicio; i != null; i = i.inf){
			for(Celula j = i; j != null; j = j.prox){
				soma *= i.elemento;
			}// End for
		}// End for
		return soma;
	}// End multiplicacaoElementos()

	public void mostrarDiagonalSecundaria(){
		Celula j = null;
		for(Celula i = this.inicio; i != null; i = i.inf){
			if(j == null){
				while(j.prox != null){
					j = j.prox)
				}// End while
			}// End if
			MyIO.println(k.elemento);
			j = j.ant.inf;
		}// End for
	}// End mostrarDiagonalSecundaria() 

	public void mostrar(){
		for(Celula i = this.inicio; i != null; i = i.inf){
			for(Celula j = i; j != null; j = j.prox){
				System.out.println(i.elemento);
			}// End for
		}// End for
	}// End mostrar()
}// End Matriz