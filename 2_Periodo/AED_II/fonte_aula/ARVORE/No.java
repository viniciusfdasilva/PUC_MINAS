class No{
	int elemento;
	No esq;
	No dir;

	public No(int elemento){
		this(elemento,null,null);
	}// End class No()

	public No(int elemento, No esq, No dir){
		this.elemento = elemento;
		this.esq = this.dir = null;
	}// End No()
}// End class No