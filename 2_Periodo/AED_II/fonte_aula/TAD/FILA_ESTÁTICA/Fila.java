class Fila{
	int[] array;
	int primeiro;
	int ultimo;

	public Fila(){
		this.array = new int[0];
		this.primeiro = 0;
		this.ultimo = 0;
	}// End Fila

	public Fila(int tamanho){
		this.array = new int[tamanho+1];
		this.primeiro = 0;
		this.ultimo = 0;
	}// End Fila

	public void enfileirar(int x){ 
		if((this.ultimo + 1) % this.array.length == this.primeiro){
			throw new Exeption("erro");
		}// End if
		this.array[this.ultimo] = x;
		this.ultimo = (this.ultimo + 1) % this.array.length;
	}// End enfileirar()

	public int desenfileirar(){
		if(this.ultimo == this.primeiro){
			throw new Exeption("erro");
		}// End if
		int value = this.array[this.primeiro];
		this.primeiro = (this.primeiro + 1) % this.array.length;
		return value;
	}// End desenfileirar() 

	public void mostrar(){
		int i = this.primeiro;
		while(i != this.ultimo){
			System.out.println(this.array[i]);
			i = (i + 1) % this.array.length;
		}// End while
	}// End mostrar()

	public void mostrarRec(){
		mostrarRec(this.primeiro);
	}// End if

	public void mostrarRec(int i){
		if(i != this.ultimo){
			System.out.println(this.array[i]);
			mostrarRec((i + 1) % this.array.length);
		}// End if
	}// End mostrarRec()

	public boolean pesquisar(int x){
		boolean resp = false;
		int i = this.primeiro;
		while(i != this.ultimo){
			if(this.array[i] == x){
				resp = true;
				i = this.ultimo;
			}// End if
			i = (i + 1) % this.array.length;
		}// End while
	}// End pesquisar()

	public boolean pesquisarRec(int x){
		return pesquisarRec(this.primeiro,x);
	}// End pesquisarRec

	public boolean pesquisarRec(int i, int x){
		boolean resp = false;
		if(i != this.ultimo){
			if(this.array[i] == x){
				return resp && pesquisarRec((i + 1) % this.array.length,x);
			}// End if
		}// End if
		return true;
	}// End pesquisarRec() 
}// End class Fila