class Arvore{
	No raiz;

	public Arvore(){
		this.raiz = null;
	}// End Arvore()

	public void inserir(int elemento) throws Exception{
		this.raiz = inserir(this.raiz,elemento);
	}// End inserir()

	private No inserir(No i,int elemento) throws Exception{
		if(i == null){
			i = new No(elemento);
		}// End if
		else if(elemento > i.elemento){
			i.dir = inserir(i.dir,elemento);
		}// End else
		else if(elemento < i.elemento){
			i.esq = inserir(i.esq,elemento);
		}// End else if
		else{
			throw new Exception("erro");
		}// End else 
		return i;
	}// End inserir()

	public boolean pesquisar(int elemento) throws Exception{
		return pesquisar(this.raiz,elemento);
	}// End pesquisar()	

	private boolean pesquisar(No i, int elemento) throws Exception{
		boolean resp = false;
		if(i == null){
			throw new Exception("erro");
		}// End if
		else if(elemento > i.elemento){
			resp = pesquisar(i.dir,elemento);
		}// End else if
		else if(elemento < i.elemento){
			resp = pesquisar(i.esq,elemento);
		}// End else if
		else{
			resp = true;
		}// End else
		return resp;
	}// End pesquisar()

	public No remover(int elemento) throws Exception{
		return remover(this.raiz,elemento);
	}// End remover()

	private No remover(No i,int elemento) throws Exception{
		if(i == null){
			throw new Exception("erro");
		}// End if
		else if(elemento > i.elemento){
			i.dir = remover(i.dir,elemento);
		}// End else if
		else if(elemento < i.elemento){
			i.esq = remover(i.esq,elemento);
		}// End else if
		else if(i.dir == null){
			i = i.esq;
		}// End else if
		else if(i.esq == null){
			i = i.dir;
		}// End else if
		else{
			i.esq = anterior(i,i.esq);
		}// End remover()
		return i;
	}// End remover()

	private No anterior(No i,No j){
		if(j.dir != null){
			j.dir = anterior(i,j.dir);
		}// End if
		else{
			i.elemento = j.elemento;
			j = j.esq;
		}// End esle 
		return j;
	}// End anterior()

	public void mostrarCentral(){
		mostrarCentral(this.raiz);
	}// End mostrarCentral()

	private void mostrarCentral(No i){
		if(i != null){
			mostrarCentral(i.esq);
			System.out.println(i.elemento);
			mostrarCentral(i.dir);
		}// End if
	}// End mostrarCentral()
}// End Arvore












