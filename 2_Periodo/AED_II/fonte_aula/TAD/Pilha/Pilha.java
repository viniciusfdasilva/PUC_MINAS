import java.util.*;
class Pilha{
	int[] array;
	int topo;

	public Pilha(int tamanho){
		this.array = new int[tamanho];
		this.topo = 0;
	}// End Pilha()

	public void empilhar(int elemento) throws Exception{
		if(this.topo >= this.array.length){
			throw new Exception("ERRO");
		}// end if
		this.array[topo] = elemento;
		this.topo++;
	}// End empilhar()

	public int desempilhar() throws Exception{
		if(this.topo == 0){
			throw new Exception("ERRO");
		}// End if
		return this.array[--this.topo];
	}// End desempilhar

	public void mostrar() throws Exception{
		if(this.topo == 0){
			throw new Exception("ERRO");
		}// End if
		for(int i = 0; i < this.topo;i++){
			System.out.print("[ ");
			System.out.print("Valor da " + (i+1) + "° " + "posição do array é: " + this.array[i]);
			System.out.println(" ] ");
		}// End for
	}// End for
}// End Pilha