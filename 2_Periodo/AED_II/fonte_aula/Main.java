class Fila{
	Pilha f1;
	Pilha f2;
	
	public void inserir(int value){
		f1.inserir(value);
	}// End inserir() 

	public void remover(){
		remover(f1.quantos());
	}// End remover

	public void remover(int i){
		if(i > 0){
			f2.inserir(f1.Array[i]);		
		}// End if
		f2.remover();
	}// End remover()

	public void mostrar(){
		for(int i = 0; i < n; i++){
			System.out.println(Array[i]);
		}// End for
	}// End mostrar()
}// End fila
public class Main{
	public static void main(String[] args){
		Fila fila = new Fila();
		fila.inserir(2);
		fila.remover();
	}// End main()
}// End class Main


