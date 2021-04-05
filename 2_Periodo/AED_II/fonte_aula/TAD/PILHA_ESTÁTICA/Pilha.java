class Pilha{
	int[] array;
	int n;

	public Pilha(){
		this.array = new int[0];
		this.n = 0;
	}// End Pilha

	public Pilha(int tamanho){
		this.array = new int[tamanho];
		this.n = 0;
	}// End Pilha()

	public void empilhar(int x)throws Exeption{
		if(this.n >= this.array.length){
			throw new Exeption("erro: 404");
		}// End if
		this.array[this.n] = x;
		this.n++;
	}// End empilhar()

	public int desempilhar(){
		if(this.n == 0){
			throw new Exeption("erro: 404");
		}// End if
		return this.array[--n];
	}// End desempilhar()

	public boolean pesquisaRec(int x){
		if(this.n == 0){
			throw new Exeption("erro 404:");
		}// End if
		return pesquisaRec(int x,0);
	}// End pesquisaRec

	public boolean pesquisaRec(int x,int i){
		boolean resp = false;
		if(i < this.n){	
			if(this.array[i] == x){
				return resp && pesquisaRec(x,i+1);
			}// End if
		}// End if
		return true;
	}// End pesquisaRec()

	public void mostrar(){
		if(this.n == 0){
			throw new Exeption("erro 404:");
		}// End if
		for(int i = 0; i < this.n; i++){
			System.out.println(this.array[i]);
		}// End for
	}// End mostrar()

	public void mostrarContrario(){
		if(this.n == 0){
			throw new Exeption("erro 404:");
		}// End if
		for(int i = this.n; i <= 0; i--){
			System.out.println(this.array[i]);
		}// End for
	}// End mostrarContrario()

	public void mostrarRec(){
		if(this.n == 0){
			throw new Exeption("erro 404:");
		}// End if
		mostrarRec(0);	
	}// End mostrarRec()

	public void mostrarRec(int i){
		if(i < this.n){
			System.out.println(this.array[i]);
			mostrarRec(i+1);
		}// End if
	}// End mostrarRec

	public void mostrarRecContrario(){
		if(this.n == 0){
			throw new Exeption("erro 404:");
		}// End if
		mostrarRecContrario(0);	
	}// End mostrarRec()

	public void mostrarRec(int i){
		if(i < this.n){
			mostrarRec(i+1);
			System.out.println(this.array[i]);
		}// End if
	}// End mostrarRec
}// End class Pilha