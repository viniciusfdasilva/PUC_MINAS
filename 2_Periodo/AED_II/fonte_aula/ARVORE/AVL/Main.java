public class Main{
	public static void main(String[] args) throws Exception{
		Avl arvore = new Avl();
		arvore.inserir(1);
		arvore.inserir(2);
		arvore.inserir(3);
		arvore.inserir(0);
		arvore.inserir(23);
		arvore.inserir(34);
	//	System.out.println(arvore.raiz.elemento);
	//	arvore.mostrarCentral();
		System.out.println(arvore.tamanhoDir(arvore.raiz) + " DIREITA");
		System.out.println(arvore.tamanhoEsq(arvore.raiz) + " ESQUERDA");
		//No i = arvore.raiz;
	}// End main()
}// End class Main()