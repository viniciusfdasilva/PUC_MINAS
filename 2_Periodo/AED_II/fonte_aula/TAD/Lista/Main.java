public class Main{
	public static void main(String[] args) throws Exception{
		Lista lista = new Lista(6);
		lista.inserirInicio(4);
		lista.inserirFim(10);
		lista.inserir(19,2);
		lista.inserirInicio(5);
		lista.remover(2);
		lista.removerInicio();
		lista.removerFim();
		lista.inserirFim(100);
		lista.mostrar();
	}// End main()
}// End class Main