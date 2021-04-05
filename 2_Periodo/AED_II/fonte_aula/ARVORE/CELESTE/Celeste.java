class No{
	int elemento;
	boolean cor;
	No esq;
	No dir;

	public No(int elemento,boolean cor){
		this.cor = cor;
		this.elemento = elemento;
		this.esq = this.dir = null;
	}// End No()

	public No(int elemento){
		this.cor = false;
		this.elemento = elemento;
		this.esq = this.dir = null;
	}// End No()
}// End No

class Celeste{
	No raiz;

	public Celeste(){
		this.raiz = null;
	}// End Celeste()

	public void inserir(int elemento) throws Exception{
		if(this.raiz == null){
			this.raiz = new No(elemento,false);
		}// End if
		else if(raiz.esq == null && raiz.dir == null){
			if(raiz.elemento > elemento){
				raiz.esq.elemento = elemento;
			}// End if
			else if(raiz.elemento < elemento){
				raiz.dir.elemento = elemento;
			}// End else if
			else{
				throw new Exception("erro");
			}// End else 
		}// End else if
		else if(raiz.esq == null){
			if(this.raiz.elemento > elemento){
				raiz.esq = new No(elemento,true);
			}// End if	
			else if(raiz.dir.elemento > elemento && raiz.dir.esq == null){
				raiz.dir.esq = new No(elemento,true);
				this.raiz = rotacionarEsquerdaDireita(this.raiz);
			}// End else if
			else if(raiz.dir.elemento < elemento && raiz.dir.dir == null){
				raiz.dir.dir = new No(elemento,true);
				this.raiz = rotacionarEsquerda(this.raiz);
			}// End else if
		}// End else if
		else if(raiz.dir == null){
			if(raiz.elemento < elemento){
				raiz.dir = new No(elemento,true);
			}// End if
			else if(raiz.esq.elemento > elemento && raiz.esq.esq == null){
				raiz.esq.esq = new No(elemento,true);
				this.raiz = rotacionarDireita(this.raiz);
			}// End else if
			else if(raiz.esq.elemento < elemento && raiz.esq.dir == null){
				raiz.esq.dir = new No(elemento,true);
				this.raiz = rotacionarDireitaEsquerda(this.raiz);
			}// End else if
		}// End else if
		this.raiz.cor = false;
		this.raiz.esq.cor = this.raiz.dir.cor = true;
		this.raiz = inserir(this.raiz,elemento); 
	}// End inserir()

	public No inserir(No i,int elemento){
		if(i.elemento > elemento){
			i.esq = inserir(i.esq,elemento);
		}// End if
		else if(i.elemento < elemento){
			i.dir = inserir(i.dir,elemento);
		}// End else if
		else{

		}// End else
	}// End inserir()


	private No rotacionarDireita(No no){
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;
		noEsq.dir = no;
		no.esq = noEsqDir;
		return noEsq;
	}// End rotacionarDireita()

	private No rotacionarEsquerda(No no){
		No noDir = no.dir;
		No noDirEsq = noDir.esq;
		noDir.esq = no;
		no.dir = noDirEsq;
		return noDir;
	}// End rotacionarEsquerda()

	private No rotacionarDireitaEsquerda(No no) {
      no.dir = rotacionarDireita(no.dir);
      return rotacionarEsquerda(no);
   }// End rota

   private No rotacionarEsquerdaDireita(No no){
      no.esq = rotacionarEsquerda(no.esq);
      return rotacionarDireita(no);
   }// End rotacionarEsquedaDireita()
}// End Celeste