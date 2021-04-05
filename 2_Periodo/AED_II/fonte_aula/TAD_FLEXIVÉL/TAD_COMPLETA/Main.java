import java.util.Scanner;
public class Main{
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int x1,x2,x3;
		x1 = x2 = x3 = 0;
		switch(str){
			case "LISTA":
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
				x1 = lista.removerFim();
				x2 = lista.removerInicio();
				x3 = lista.remover(2);
				System.out.println(x1 + " " + x2 + " " + x3);
				lista.mostrar();
				break;
			case "PILHA":
				Pilha pilha = new Pilha();
				pilha.inserir(4);
				pilha.inserir(3);
				pilha.inserir(2);
				pilha.inserir(1);
				pilha.inserir(0);
				x1 = pilha.remover();
				pilha.inserir(21);
				pilha.inserir(22);
				x2 = pilha.remover();
				pilha.mostrar();
				pilha.mostrarContrario();
				System.out.println(x1 + " " + x2);
				break;
			case "FILA":
				Fila fila = new Fila();
				fila.inserir(5);
				fila.inserir(1);
				fila.inserir(2);
				fila.inserir(9);
				fila.inserir(3);
				fila.inserir(23);
				fila.inserir(0);
				fila.mostrar();
				x1 = fila.remover();
				x2 = fila.remover();
				x3 = fila.remover();	
				fila.mostrar();
				System.out.println(x1 + " " + x2 + " " + x3);
				break;
			default: throw new Exception("ERRO");
		}// End switch
	}// End main()
}// End class Main()