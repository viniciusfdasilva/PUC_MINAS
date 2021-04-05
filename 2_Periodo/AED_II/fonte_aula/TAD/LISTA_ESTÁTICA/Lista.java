import java.util.*;
class Lista{
	int[] array;
	int n;

	public Lista(){
		this.array = new int[0];
		this.n = 0;
	}// End Lista()

	public Lista(int tamanho){
		this.array = new int[tamanho];
		this.n = 0;
	}// End Lista()

	public void inserirInicio(int x)throws Exeption{
		if(this.n >= this.array.lenth-1){
			throw new Exeption("erro 404:");
		}// End if
		for(int i = this.n; i >= 0; i--){
			this.array[i+1] = this.array[i]; 
		}// End for
		this.array[0] = x;
		this.n++;
	}// End inserirInicio()

	public void inserirFim(int x){
		if(this.n >= this.array.lenth-1){
			throw new Exeption("erro 404:");
		}// End if
		this.array[this.n+1] = x;
		this.n++;
	}// End inserirFim()
	
	public void inserir(int x,int pos){
		if((this.n >= this.array.lenth-1) || (pos <= 0 || pos >= this.n)){
			throw new Exeption("erro 404:");
		}// End if
		for(int i = this.n; i >= pos; i--){
			this.array[i+1] = this.array[i];
		}// End for
		this.array[pos] = x;
		this.n++;
	}// End inserir

	public int removerInicio(){
		if(this.n == 0){
			throw new Exeption("erro 404:");
		}// End if
		int value = this.array[0];
		for(int i = 0; i < this.n; i++){
			this.array[i] = this.array[i+1];
		}// End for
		this.n--;
		return value;
	}// End removerInicio()

	public int removerFim(){
		if(this.n == 0){
			throw new Exeption("erro 404:");
		}// End if
		int i = this.n;
		this.n--;
		return this.array[i];
	}// End removerFim()

	public int remover(int pos){
		if(this.n == 0 || pos <= 0 || pos >= this.n){
			throw new Exeption("erro 404:");
		}// End if
		int value = this.array[pos];
		for(int i = pos; i < n; i++){
			this.array[i] = this.array[i+1];
		}// End for
		this.n--;
		return value;
	}// End remover()

	public boolean pesquisa(int x){
		if(this.n == 0){
			throw new Exeption("erro 404:");
		}// End if
		boolean resp = false;
		for(int i = 0; i < this.n; i++){
			if(this.array[i] == x){
				resp = true;
				i = this.n;
			}// End if
		}// End for
		return resp;
	}// End pesquisa()

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
}// End class Lista