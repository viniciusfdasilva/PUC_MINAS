import java.util.*;
class Avl{
	No raiz;

	public Avl(){	
		this.raiz = null;
	}// End Avl()

	public void inserir(int elemento) throws Exception{
		this.raiz = inserir(this.raiz,elemento);
		set(this.raiz);
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
	//	if(i.fator == 2 || i.fator == -2){
	//		i = balancear(i);
	//	}// End if
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
	//	if(i.fator == 2 || i.fator == -2){
	//		i = balancear(i);
	//	}// End if
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
			System.out.println(i.elemento + " " + i.fator);
			mostrarCentral(i.dir);
		}// End if
	}// End mostrarCentral()

	private void set(No i){
		if(i != null){
			set(i.esq);
			i.fator = setFator(i);
			set(i.dir);
		}// End if
	}// End set()

	public void mostrarPre(){
		mostrarPre(this.raiz);
	}// End mostrarPre()

	private void mostrarPre(No i){
		if(i != null){
			System.out.println(i.elemento);
			mostrarPre(i.esq);
			mostrarPre(i.dir);
		}// End if
	}// End mostrarPre()

	public void mostrarPos(){
		mostrarPos(this.raiz);
	}// End mostrarPos()

	private void mostrarPos(No i){
		mostrarPos(i.esq);
		mostrarPos(i.dir);
		System.out.println(i.elemento);
	}// End mostrarPos()

	public int tamanhoDir(No i){
		int tamanho = 0;
		if(i != null && i.dir != null){
			if(i.dir == null) tamanho += (1 + tamanhoDir(i.esq));
			else if(i.esq == null) tamanho += (1 + tamanhoDir(i.dir));
			else tamanho += (1 + Math.max(tamanhoDir(i.esq),tamanhoDir(i.dir)));
		}// End if
		return tamanho;
	}// End tamanhoDir()

	public int tamanhoEsq(No i){
		int tamanho = 0;
		if(i != null && i.esq != null){
			if(i.dir == null) tamanho += (1 + tamanhoEsq(i.esq));
			else if(i.esq == null) tamanho += (1 + tamanhoEsq(i.dir));
			else tamanho += (1 + Math.max(tamanhoEsq(i.esq),tamanhoEsq(i.dir)));
		}// End if
		return tamanho;	
	}// End tamanhoEsq()

	public int setFator(No i){
		return (tamanhoDir(i)-tamanhoEsq(i));
	}// End setFator()

	public No balancear(No i) throws Exception{
		if(i.fator == 2){
			if(i.dir.fator == 0 || i.dir.fator == 1){
				i = rotacionarEsq(i);
			}// End if
			else if(i.dir.fator == -1){
				i = rotacionarEsqDir(i);
			}// End else if
		}// End if
		else if(i.fator == -2){
			if(i.esq.fator == 0 || i.esq.fator == -1){
				i = rotacionarDir(i);
			}// End if
			else if(i.esq.fator == 1){
				i = rotacionarDirEsq(i);
			}// End else if
		}// End else if
		return i;
	}// End balancear()

	public No rotacionarEsq(No no){
		No dir = no.dir;
		No diresq = no.dir.esq;
		dir.esq = no;
		no.dir = diresq;
		return dir;
	}// End rotacionarEsq()

	public No rotacionarDir(No no){
		No esq = no.esq;
		No esqdir = esq.dir;
		esq.dir = no;
		no.esq = esqdir;
		return esq;
	}// End rotacionarDir()

	public No rotacionarDirEsq(No no){
		no.dir = rotacionarDir(no.dir);
		return rotacionarEsq(no);
	}// End rotacionarDirEsq()

	public No rotacionarEsqDir(No no){
		no.esq = rotacionarEsq(no.esq);
		return rotacionarDir(no);
	}// End rotacionarEsqDir()
}// End class Avl

