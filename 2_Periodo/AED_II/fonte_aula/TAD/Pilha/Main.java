public class Main{
	public static void main(String[] args) throws Exception{
		Pilha pilha = new Pilha(6);
		pilha.empilhar(2);
		pilha.empilhar(1);
		pilha.empilhar(6);
		pilha.desempilhar();
		pilha.desempilhar();
		pilha.desempilhar();
		pilha.mostrar();
	}// End main()
}// End class Main