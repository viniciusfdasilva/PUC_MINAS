class No{
	protected int elemento;
	protected No dir;
	protected No esq;
	protected int fator;

	public No(int elemento){
		this.elemento = elemento;
		this.dir = this.esq = null;
		this.fator = 0;
	}// End No()

	public No(){
		this(0);
	}// End No()
}// End class No