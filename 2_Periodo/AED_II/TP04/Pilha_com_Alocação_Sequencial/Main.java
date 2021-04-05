public class Main{
	public static void main(String[] args) throws Exception{
		MyIO.setCharset("UTF-8");
		String str;
		Serie[] serie = new Serie[1000];
		Pilha pilha = new Pilha(1000);
		int i = 0;
		int pos = 0;
		Serie s = null;
		for(str = MyIO.readLine();!str.equals("FIM");str = MyIO.readLine()){
			serie[i] = new Serie();
			serie[i].ler(str);
			pilha.inserir(serie[i]);	
			i++;
	  	}// End for
		int n = MyIO.readInt();
		i = 0;
		while(i < n){
			str = MyIO.readString();
			switch(str){
				case "I":
					str = MyIO.readString();
					s = new Serie();
					s.ler(str);
					pilha.inserir(s);
					break;
				case "R":
					s = pilha.remover();
					MyIO.println("(R) " + s.getNome());
					break;
				default: throw new Exception("ERRO");
			}// End switch
			i++;
		}// End while
		pilha.mostrar();
	}// End main()
}// End class Main()	