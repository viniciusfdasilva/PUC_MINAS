import java.util.*;
class Lista{
	int[] array;
	int n;
	
	public Lista(int tamanho){
		this.array = new int[tamanho];
		this.n = 0;
	}// End Lista()

	public void inserirInicio(int elemento) throws Exception{
		if(this.n >= this.array.length){
			throw new Exception("ERRO");
		}// End if
		for(int i = this.n; i > 0; i--){
			this.array[i] = this.array[i-1];
		}// End for
		this.array[0] = elemento;
		this.n++;
	}// End inserirInicio()

	public void inserirFim(int elemento) throws Exception{
		if(this.n >= this.array.length){
			throw new Exception("ERRO");
		}// End if
		this.array[this.n] = elemento;
		this.n++;
	}// End inserirFim()

	public void inserir(int elemento,int pos) throws Exception{
		if(this.n >= this.array.length || pos < 0 || pos > this.n){
			throw new Exception("ERRO");
		}// End if
		for(int i = this.n; i > pos; i--){
			this.array[i] = this.array[i-1];
		}// End for
		this.array[pos] = elemento;
		this.n++;
	}// End inserir()

	public int removerInicio() throws Exception{
		if(this.n == 0){
			throw new Exception("ERRO");
		}// End if
		int x = this.array[0];
		this.n--;
		for(int i = 1; i <= this.n; i++){
			this.array[i-1] = this.array[i];
		}// End for
		return x;
	}// End removerInicio()

	public int removerFim() throws Exception{
		if(this.n >= this.array.length){
			throw new Exception("ERRO");
		}// End if
		return this.array[--this.n];
	}// End removerFim()	

	public int remover(int pos) throws Exception{
		if(this.n >= this.array.length || pos < 0 || pos > this.n){
			throw new Exception("ERRO");
		}// End if
		int x = this.array[pos];
		this.n--;
		for(int i = pos; i < this.n;i++){
			this.array[i] = this.array[i+1]; 
		}// End for
		return x;
	}// End remover()

	public void mostrar() throws Exception{
		if(this.n == 0){
			throw new Exception("ERRO");
		}// End if
		for(int i = 0; i < this.n;i++){
			System.out.print("[ ");
			System.out.print("Valor da " + (i+1) + "° " + "posição do array é: " + this.array[i]);
			System.out.println(" ] ");
		}// End for
	}// End for
}// End class Lista