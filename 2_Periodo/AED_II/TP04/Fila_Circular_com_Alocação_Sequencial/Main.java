public class Main{
	public static void main(String[] args) throws Exception{
		MyIO.setCharset("UTF-8");
		String str;
		Serie[] serie = new Serie[1000];
		Fila fila = new Fila(5);
		int i = 0;
		int pos = 0;
		Serie s = null;
		for(str = MyIO.readLine();!str.equals("FIM");str = MyIO.readLine()){
			serie[i] = new Serie();
			serie[i].ler(str);
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
					try{
						fila.inserir(s);
					}// End try
					catch(Exception e){
						MyIO.println("erro" + e);
					}// End catch
					break;
				case "R":
					str = MyIO.readString();
					s = new Serie();
					s.ler(str);
					try{
						fila.remover();
					}// End try
					catch(Exception e){
						MyIO.println("erro" + e);
					}// End catch
					break;
				default: throw new Exception("ERRO");
			}// End switch
			i++;
		}// End while
		fila.mostrar();
	}// End main()
}// End class Main()	