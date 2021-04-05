class Pilha{
	Celula topo;

	public Pilha(){
		this.topo = null;
	}// End Pilha()
	
	public void inserir(int elemento){
		Celula celula = new Celula(elemento);
		celula.prox = this.topo;
		this.topo = celula;
		celula = null;		
	}// End inserir()

	public boolean isVazia(){
		return this.topo == null ? true : false;
	}// End isVazia()

	public int remover() throws Exception{
		if(isVazia()) throw new Exception("erro");
		Celula tmp = this.topo;
		int elemento = tmp.elemento;
		this.topo = this.topo.prox;
		tmp.prox = null;
		tmp = null;
		return elemento; 
	}// End remover()

	public int somaElementos(){
		int soma = 0;
		for(Celula i = this.topo; i != null; i = i.prox){
			soma += i.elemento;
		}// End for
		return soma;
	}// End somaElementos()

	public int somaElementosRec(){
		return somaElementosRec(this.topo);
	}// End somaElementosRec() 

	private int somaElementosRec(Celula i){
		int soma = 0;
		if(i != null){
			soma += (i.elemento + somaElementosRec(i.prox));
		}// End if
		return soma;
	}// End somaElementosRec()

	public int maiorValor(){
		int maior = this.topo.elemento;
		for(Celula i = this.topo.prox; i != null; i = i.prox){
			if(maior < i.elemento){
				maior = i.elemento;
			}// End if
		}// End for
		return maior;
	}// End maiorValor

	public int maiorValorRec(){
		return maiorValorRec(this.topo.prox,this.topo.elemento);
	}// End maiorValorRec()

	private int maiorValorRec(Celula i,int maior){
		if(i != null){
			if(maior < i.elemento){
				maior = i.elemento;
				maior = maiorValorRec(i.prox,maior);
			}// End if
			else{
				maior = maiorValorRec(i.prox,maior);
			}// End else
		}// End if
		return maior;
	}// End maiorValorRec()

	public void mostrar(){
		for(Celula i = this.topo; i != null; i = i.prox){
			System.out.println(i.elemento);
		}// End for
	}// End mostrar()

	public void mostrarRec(){
		mostrarRec(this.topo);
	}// End mostrarRec()

	private void mostrarRec(Celula i){
		if(i != null){
			System.out.println(i.elemento);
			mostrarRec(i.prox);
		}// End if
	}// End mostrarRec()

	public void mostrarContrarioRec(){
		mostrarRec(this.topo);
	}// End mostrarRec()

	private void mostrarContrarioRec(Celula i){
		if(i != null){
			mostrarRec(i.prox);
			System.out.println(i.elemento);
		}// End if
	}// End mostrarRec()

	public void mostrarContrario(){
		Celula i = null;
		Celula j = null;
		boolean resp = false;
		while(!resp){
			if(i == null){
				for(i = this.topo; i.prox != null; i = i.prox);
			}// End if
			j = this.topo;
			resp = i == this.topo && j == this.topo ? true : false;
			while(j.prox != i && !resp){ 
				j = j.prox;
			}// End while
			System.out.println(i.elemento);
			i = j;
		}// End while
		i = j = null;
	}// End mostrarContrario()
}// End class Pilha