class Fila{
	Celula primeiro;
	Celula ultimo;

	public Fila(){
		this.primeiro = this.ultimo = new Celula();
	}// End Fila()	

	public boolean isVazia(){
		return this.primeiro == this.ultimo ? true : false;
	}// End isVazia()

	public void inserir(int elemento){
		Celula celula = new Celula(elemento);
		this.ultimo.prox = celula;
		this.ultimo = celula;
		celula = null;
	}// End inserir()

	public int remover() throws Exception{
		if(isVazia()) throw new Exception("erro");
		Celula tmp = this.primeiro.prox;
		int elemento = tmp.elemento;
		this.primeiro.prox = tmp.prox;
		tmp.prox = null;
		tmp = null;
		return elemento;
	}// End remover()

	public void mostrar(){
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

	public int maiorElemento(){
		int maior = 0;
		for(Celula i = this.primeiro.prox; i != null; i = i.prox){
			if(maior < i.elemento){
				maior = i.elemento;
			}// End maior
		}// End for
		return maior;
	}// End maiorElemento()

	public int somaElementos(){
		int soma = 0;
		for(Celula i = this.primeiro.prox; i != null; i = i.prox){	
			soma += i.elemento;
		}// End for
		return soma;
	}// End somaElementos()

	public void inverteElementos(){
		Celula inicio = this.primeiro.prox;
		Celula i = null;
		this.primeiro.prox = ultimo;
		while(i != inicio){
			i = inicio;
			while(i.prox != ultimo) i = i.prox;
			this.ultimo.prox = i;
			this.ultimo = i;
		}// End while
		inicio = inicio.prox = null;
	}// End inverteElementos()
}// End Fila