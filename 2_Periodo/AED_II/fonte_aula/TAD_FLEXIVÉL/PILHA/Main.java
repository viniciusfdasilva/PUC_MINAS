public class Main{
	public static void main(String[] args) throws Exception{
		Pilha pilha = new Pilha();
		pilha.inserir(4);
		pilha.inserir(22);
		pilha.inserir(3243242);
		pilha.inserir(3);
		pilha.inserir(1);
	/*
		System.out.println(pilha.somaElementos());
		System.out.println(pilha.somaElementosRec());
		pilha.mostrar();
		System.out.println(pilha.maiorValor());
		System.out.println(pilha.maiorValorRec());
	*/
		pilha.mostrarContrario();
	}// End main()
}// End class Main()

		