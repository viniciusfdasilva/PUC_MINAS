class No{
	Serie elemento;
	No dir;
	No esq;

	public No(){
		this(null);
	}// End No()
	
	public No(Serie elemento){
		this.elemento = elemento;
		this.dir = null;
		this.esq = null;
	}// End No()
}// End class No