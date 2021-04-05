class Lista{
	Celula primeiro;
	Celula ultimo;

	public Lista(){
		this.primeiro = this.ultimo = new Celula();
	}// End Lista

	public void inserirInicio(int elemento){
		Celula celula = new Celula(elemento);
		if(primeiro.prox == null){
			primeiro.prox = celula;
			this.ultimo = celula;
			celula = null;
		}// End if
		else{
			Celula tmp = primeiro.prox;
			primeiro.prox = celula;
			celula.prox = tmp;
			celula = tmp = null;
		}// End else
	}// End inserirInicio()

	public void inserirFim(int elemento){
		ultimo.prox = new Celula(elemento);
		this.ultimo = ultimo.prox;
	}// Emd inserirFim()

	public void inserir(int pos,int elemento) throws Exception{
		if(pos == 0) inserirInicio();
		else if(pos == tamanho()) inserirFim();
		else if(pos < 0 || pos > tamanho()) throw new Exception("erro");
		int i = 0;
		Celula tmp = this.primeiro;
		while(i < pos){
			i++;
			tmp = tmp.prox;
		}// End while
		Celula celula = new Celula(elemento);
		celula.prox = tmp.prox;
		tmp.prox = celula;
		tmp = celula = null;
	}// End inserir()

	public int remover()

}// End Lista