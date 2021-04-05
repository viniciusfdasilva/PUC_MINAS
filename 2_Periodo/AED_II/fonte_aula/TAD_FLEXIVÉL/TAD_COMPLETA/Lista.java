class Lista{
	Celula primeiro;
	Celula ultimo;

	public Lista(){
		this.primeiro = this.ultimo = new Celula();
	}// End Celula()

	public void inserirInicio(int x){
		Celula celula = new Celula(x);
		celula.prox = primeiro.prox;
		primeiro.prox = celula;
		if(isVazia()){
			this.ultimo = celula;
		}// End if
	}// End inserirInicio()

	public void inserirFim(int x){
		Celula celula = new Celula(x);
		ultimo.prox = celula;
		this.ultimo = celula;
	}// End inserirFim()

	public void inserir(int x, int pos) throws Exception{
		if(pos < 0 || pos >= length()){
			throw new Exception("ERRO");
		}// End if
		else if(pos == 0){
			inserirInicio(x);
		}// End else if
		else if(pos == length()){
			inserirFim(x);
		}// End else if
		Celula tmp = this.primeiro;
		for(int i = 0; i < pos; i++, tmp = tmp.prox);
			Celula celula = new Celula(x);
			celula.prox = tmp.prox;
			tmp.prox = celula;
			tmp = null;
	}// End inserir()

	public int removerInicio() throws Exception{
		if(isVazia()){
			throw new Exception("ERRO");
		}// End if
		Celula tmp = this.primeiro.prox;
		int elemento = tmp.elemento;
		this.primeiro.prox = tmp.prox;
		tmp.prox = null;
		tmp = null;
		return elemento;
	}// End removerInicio()

	public int removerFim() throws Exception{
		if(isVazia()){
			throw new Exception("ERRO");
		}// End if
		int elemento = this.ultimo.elemento;
		Celula i = this.primeiro.prox;
		 while(i.prox != ultimo){
		 	i = i.prox;
		 }// End while
			this.ultimo = i;
			i.prox = null;
			i = null;
		return elemento;
	}// End removerFim()

	public int remover(int pos) throws Exception{
		if(pos < 0 || pos >= length()){
			throw new Exception("ERRO");
		}// End if
		else if(pos == 0){
			removerInicio();
		}// End else if
		else if(pos == length()){
			removerFim();
		}// End else if
		Celula tmp = this.primeiro;
		Celula j = this.primeiro;
		for(int i = 0; i <= pos; i++, tmp = tmp.prox);
			while(j.prox != tmp){
				j = j.prox;
			}// End while
			int elemento = tmp.elemento;
			j.prox = tmp.prox;
			tmp.prox = null;
			tmp = null;
			j = null;
		return elemento;
	}// End remover()

	public boolean isVazia(){
		return this.primeiro == this.ultimo ? true : false;
	}// End isVazia()

	public int length(){
		return length(this.primeiro.prox);
	}// End length()

	public int length(Celula i){
		int soma = 0;
		if(i != null){
			soma++;
			return soma += length(i.prox);
		}// End if
		return soma;
	}// End length()

	public void mostrar() throws Exception{
		if(isVazia()){
			throw new Exception("ERRO");
		}// End if
		for(Celula i = this.primeiro.prox; i != null; i = i.prox){
			System.out.println(i.elemento);
		}// End for
	}// End mostrar()	

	public void mostrarRec(){
		mostrarRec(this.primeiro.prox);
	}// End mostrarRec()

	public void mostrarRec(Celula i){
		if(i != null){
			System.out.println(i.elemento);
			mostrarRec(i.prox);
		}// End if
	}// End mostrarRec()	
}// End class Lista()