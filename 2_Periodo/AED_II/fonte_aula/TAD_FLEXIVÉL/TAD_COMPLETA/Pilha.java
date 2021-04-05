class Pilha{
	private Celula topo;
	public Pilha(){
		this.topo = null;
	}// End Pilha

	public void inserir(int x){
		Celula celula = new Celula(x);
		celula.prox = this.topo;
		this.topo = celula;
		celula = null; 
	}// End inserir()

	public int remover()throws Exception{
		if(isVazia()){
			throw new Exception("ERRO");
		}// End if
		int elemento = this.topo.elemento;
		Celula tmp = this.topo;
		this.topo = tmp.prox;
		tmp.prox = null;
		tmp = null;
		return elemento;
	}// End remover()

	public boolean isVazia(){
		return this.topo == null ? true : false;
	}// End isVazia()

	public void mostrar()throws Exception{
		if(isVazia()) throw new Exception("ERR0");
		for(Celula i = this.topo; i != null; i = i.prox){
			System.out.println(i.elemento);
		}// End for
	}// End mostrar()

	public void mostrarRec()throws Exception{
		if(isVazia()) throw new Exception("ERR0");
		mostrarRec(this.topo);
	}// End mostrarRec()

	public void mostrarRec(Celula i){
		if(i != null){
			System.out.println(i.elemento);
			mostrarRec(i.prox);
		}// End if
	}// End mostrarRec()

	public void mostrarContrario(){
		if(isVazia()) throw new Exception("ERR0");
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
}// End Class Pilha