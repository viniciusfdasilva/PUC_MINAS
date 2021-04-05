class No{
	No esq;
	No dir;
	char letra;
	Celula primeiro;
	Celula ultimo;

	public No(char letra){
		this.letra = letra;
		this.dir = this.esq = null;
		this.primeiro = this.ultimo = null;
	}// End No()

	public No(){
		this.letra = ' ';
		this.dir = this.esq = null;
		this.primeiro = this.ultimo = null;
	}// End No()
}// End No