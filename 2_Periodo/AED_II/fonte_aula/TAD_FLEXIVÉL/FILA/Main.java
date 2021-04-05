public class Main{
	public static void main(String[] args) throws Exception{
		Fila fila = new Fila();
		fila.inserir(500);
		fila.inserir(1);
		fila.inserir(2);
		fila.inserir(9);
		fila.inserir(67);
		fila.inserir(1);
		fila.inserir(400);
		fila.inserir(0);
		//System.out.println(fila.maiorElemento());
	
		fila.inverteElementos();
	///	fila.remover();	
		fila.mostrar();
	}// End main()
}// End class Main