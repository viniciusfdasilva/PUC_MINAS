public class Main{
	public static void main(String[] args) throws Exception{ 
		Lista lista = new Lista();
		lista.inserirInicio(0);
		lista.inserirInicio(1);
		lista.inserirInicio(9);
		lista.removerInicio();
		lista.removerInicio();
		lista.inserirInicio(10);
		lista.inserirInicio(30);
		lista.inserir(18,2);
		lista.inserir(22,2);
		lista.inserirFim(21);
		lista.inserirFim(23);
		int x1 = lista.removerFim();
		int x2 = lista.removerInicio();
		int x3 = lista.remover(2);
		System.out.println(x1 + " " + x2 + " " + x3);
		lista.mostrar();
	}// End main()
}// End class Main