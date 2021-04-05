class Agenda {
   private No raiz;
   public Agenda(){
      raiz = null;
      inserir('M');
      inserir('G');
      inserir('T');
      //inserir as demais letras do alfabeto (todas maiusculas e sem acento)
   }
	public void inserir(char x) throws Exception {
		raiz = inserir(x, raiz);
	}
	private No inserir(char x, No i) throws Exception {
		if (i == null) {
         i = new No(x);

      } else if (x < i.letra) {
         i.esq = inserir(x, i.esq);

      } else if (x > i.letra) {
         i.dir = inserir(x, i.dir);

      } else {
         throw new Exception("Erro ao inserir!");
      }

		return i;
	}
   public void inserir(Contato contato){
      inserir(contato, raiz);
   }

   public void inserir(Contato contato, No i){
		if (i == null) {
         throw new Exception("Erro ao inserir!");

      } else if (contato.nome.charAt(0) < i.letra) {
         inserir(contato, i.esq);

      } else if (contato.nome.charAt(0) > i.letra) {
         inserir(contato, i.dir);

      } else {
         inserir(contato, i.primeiro, i.ultimo);
      }

		return i;
   }
   public void inserir(Contato contato, Celula primeiro, Celula ultimo){
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
   }

   public void remover(String nome){
   }

   public boolean pesquisar(String nome){
   }

   public boolean pesquisar(int cpf){
      return pesquisar(cpf, raiz);
   }
   public boolean pesquisar(int cpf, No i){
      boolean resp = false;
      if(i != null){
         resp = pesquisar(cpf, i.primeiro, i.ultimo);
         if(resp == false){
            resp = pesquisar(cpf, i.esq);
            if(resp == false){
               resp = pesquisar(cpf, i.dir);
            }
         }
      }
      return resp;
   }
   public boolean pesquisar(int cpf, Celula primeiro, Celula ultimo){
      //...
   }
}
