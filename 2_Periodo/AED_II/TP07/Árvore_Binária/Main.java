public class Main{
	public static void main(String[] args) throws Exception{
		Serie[] serie = new Serie[10000];
		int i = 0;
		Serie s = null;
		Arvore arvore = new Arvore();
		String str = null;
		for(str = MyIO.readLine(); !str.equals("FIM"); str = MyIO.readLine()){
			serie[i] = new Serie();
			serie[i].ler(str);
			arvore.inserir(serie[i]);
			i++;
		}// End for
		int n = MyIO.readInt();
		i = 0;
		while(i < n){
			str = MyIO.readString();
			switch(str){
				case "I":
					s = new Serie();
					s.ler(MyIO.readLine());
					arvore.inserir(s);
					break;
				case "R":
					arvore.remover(MyIO.readLine());
					break;
				default: throw new Exception("ERRO " + str);
			}// End switch
			i++;
		}// End while
		for(str = MyIO.readLine(); !str.equals("FIM"); str = MyIO.readLine()){
			MyIO.println(arvore.pesquisar(str) ? "SIM" : "NAO");
		}// End for
	}// End main()
}// End class Main