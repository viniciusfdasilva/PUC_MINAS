class Celula{
	int elemento;
	Celula prox;
	Celula ant;
	Celula sup;
	Celula inf;

	public Celula(int elemento){
		this.elemento = elemento;
		this.prox = null;
		this.ant = null;
		this.sup = null;
		this.inf = null;
	}// End Celula()

	public Celula(){
		this.elemento = 0;
		this.prox = null;
		this.ant = null;
		this.sup = null;		
	}// End Celula()
}// End class Celula