class Arvore{
	private No raiz;
	char indice_inicio;
	char indice_fim;

	public Arvore(){
		this(null,' ',' ');
	}// End Arvore

	public Arvore(char indice_inicio,char indice_fim){
		this.raiz = null;
		this.indice_inicio = indice_inicio;
		this.indice_fim = indice_fim;
	}// End Arvore()

	public char getMeio(){
		return (((int)this.indice_inicio+(int)this.indice_fim)/2);
	}// End getMeio()

	public void inserir(char letra) throws Exception{
		if((int)letra >= (int)this.indice_inicio && (int)letra <= (int)this.indice_fim){
			this.raiz = inserir(this.raiz,letra);
		}// End if
		else throw new Exception("erro");
	}// End inserir()

	private No inserir(No i, char letra) throws Exception{
		if(i == null){
			i = new No(letra);
		}// End if
		else if((int)letra > (int)i.letra){
			i.dir = inserir(i.dir,letra);
		}// End else if
		else if((int)letra < (int)i.letra){
			i.esq = inserir(i.esq.letra);
		}// End else if
		else throw new Exception("erro");
		return i;
	}// End inserir()
}// End Arvore