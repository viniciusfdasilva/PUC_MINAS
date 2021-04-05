class Fila{
	Celula primeiro;
	Celula ultimo;

	public Fila(){
		this.primeiro = this.ultimo = new Celula();
	}// End Fila

	public void inserir(int x){
		Celula tmp = new Celula(x);
		ultimo.prox = tmp;
		this.ultimo = ultimo.prox;
	}// End inserir()

	public int remover() throws Exception{
		if(isVazia()){
			throw new Exception("ERRO");
		}// End if
		Celula tmp = this.primeiro;
		int elemento = tmp.elemento;
		this.primeiro = tmp.prox;
		tmp.prox = null;
		tmp = null;
		return elemento;
	}// End remover()

	public boolean isVazia(){
		return this.primeiro == this.ultimo ? true : false;
	}// End isVazia(

	public void mostrar()throws Exception{
		if(isVazia()) throw new Exception("ERRO");
		for(Celula i = this.primeiro.prox; i != null; i = i.prox){
			System.out.println(i.elemento);
		}// End for
	}// End mostrar()

	public void mostrarRec() throws Exception{
		if(isVazia()) throw new Exception("ERRO");
		mostrarRec(this.primeiro.prox);
	}// End mostrarRec()

	public void mostrarRec(Celula i){
		if(i != null){
			System.out.println(i.elemento);
			mostrarRec(i.prox);
		}// End if
	}// End mostrarRec()
}// End class Fila