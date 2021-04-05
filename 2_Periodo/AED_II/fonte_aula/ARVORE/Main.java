public class Main{
	public static void main(String[] args) throws Exception{
		Arvore arvore = new Arvore();
		arvore.inserir(1);
		arvore.inserir(0);
		arvore.inserir(4);
		arvore.inserir(2);
		arvore.inserir(3);
		arvore.inserir(7);
		arvore.inserir(8);
		arvore.inserir(9);
		arvore.inserir(10);
		//arvore.mostrarCentral();
		System.out.println(arvore.tamanhoDir());
	//	arvore.mostrarRaiz();
	}// End main()
}// End class Main()