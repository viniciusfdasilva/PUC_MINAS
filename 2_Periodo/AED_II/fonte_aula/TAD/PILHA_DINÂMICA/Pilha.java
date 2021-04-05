import java.util.*;
class Pilha{
	private Celula topo;
	public Pilha(){
		topo = null;
	}// End Pilha()

	public void inserir(int x){
		Celula celula = new Celula(x);
		celula.prox = this.topo;
		this.topo = celula;
		celula = null; 
	}// End inserir()

	public int remover() throws Exception{
		if(isVazia()){
			throw new Exception("erro");
		}// End if
		Celula tmp = topo;
		int elemento = tmp.elemento;
		this.topo = tmp.prox;
		tmp.prox = null;
		return elemento;
	}// End remover()

	public boolean isVazia(){
		return topo == null ? true : false;
	}// End isVazia()

	public void mostrar(){
		for(Celula i = this.topo; i != null; i = i.prox){
			System.out.println(i.elemento);
		}// End for
	}// End mostrar()

	public void mostrarRec(){
		mostrarRec(this.topo);
	}// End mostrarRec()

	public void mostrarRec(Celula i){
		if(i != null){
			System.out.println(i.elemento);
			mostrarRec(i.prox);
		}// End if
	}// End mostrarRec

	public void mostrarContrario(){
		Celula i = this.topo; 
		Celula j = null; 
		while(i != this.topo || j != this.topo){
			j = this.topo;
			if(i == this.topo){
				while(i.prox != null){
					i = i.prox;
				}// End while
			}// End if
			System.out.println(i.elemento);
			while(j.prox != i){
				j = j.prox;
			}// End while
				i = j;
				j = this.topo;
		}// End while
		System.out.println(this.topo.elemento);
	}// End mostrar()

	public void mostrarContrarioRec(){
		mostrarContrarioRec(this.topo);
	}// End mostrarRec()

	public void mostrarContrarioRec(Celula i){
		if(i != null){
			mostrarContrarioRec(i.prox);
			System.out.println(i.elemento);
		}// End if
	}// End mostrarRec()

	public int somaElementos(){
		int soma = 0;
		for(Celula i = this.topo; i != null; i = i.prox){
			soma += i.elemento;
		}// End for
		return soma;
	}// End somaelementos()

	public int somaElementosRec(){
		return somaElementosRec(this.topo);
	}// End somaElementosRec()

	public int somaElementosRec(Celula i){
		int soma = i.elemento;
		if(i.prox != null){
			return soma += somaElementosRec(i.prox);
		}// End if
		return i.elemento;
	}// End somaElementosRec()

	public int maiorElemento(){
		int valor = this.topo.elemento;
		for(Celula i = this.topo.prox; i != null; i = i.prox){
			if(i.elemento > valor){
				valor = i.elemento;
			}// End if
		}// End for
		return valor;
	}// End maiorElemento()

	public int maiorElementoRec(){
		return maiorElementoRec(this.topo);
	}// End maiorElementoRec()

	public int maiorElementoRec(Celula i){
		int valor = 0;
		if(i.prox != null){
			if(i.elemento > valor){
				valor = maiorElementoRec(i.prox);
			}// End if
		}// End if
		return i.elemento;
	}// End maiorElementoRec()
}// End Pilha