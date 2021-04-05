/**
 * Celula
 * @author Vinicius Francisco da Silva
 * @version 1 11/2017
 */
class Celula{
	int elemento;
	Celula prox;
	Celula ant;
	Celula sup;
	Celula inf;

	/*
 	* Função que seta os
 	* valores ao atributo 
 	* da classe 
 	* @param int
 	*/
	public Celula(int elemento){
		this.elemento = elemento;
		this.prox = null;
		this.ant = null;
		this.sup = null;
		this.inf = null;
	}// End Celula()

	/*
 	* Função que seta os
 	* valores ao atributo 
 	* da classe 
 	*/
	public Celula(){
		this.elemento = 0;
		this.prox = null;
		this.ant = null;
		this.sup = null;		
	}// End Celula()
}// End class Celula

/**
 * Matriz
 * @author Vinicius Francisco da Silva
 * @version 1 11/2017
 */
class Matriz{
	private Celula inicio;
	
	/*
 	* Construtor que seta os  	
 	* atributos 
 	* @param int
 	*/
	public Matriz(int ln, int col){
		Celula tmp = null;
		for(int i = 1; i <= col; i++){
			Celula celula = new Celula();
			if(isVazia()){
				tmp = celula;
				this.inicio = celula;
			}// End if
			else{
				tmp = this.inicio;
				while(tmp.inf != null){
					tmp = tmp.inf;
				}// End while	
				tmp.inf = celula;
				celula.sup = tmp;
				tmp = tmp.inf;
			}// End else
			for(int j = 1; j < ln; j++){
				Celula nova = new Celula();
				tmp.prox = nova;
				nova.ant = tmp;
				tmp = nova;
			}// End for
			if(i >= 2){
				Celula cima = this.inicio;
				Celula baixo = this.inicio;
				while(baixo.inf != null) baixo = baixo.inf;
				while(cima.inf != baixo) cima = cima.inf;
				while(cima.prox != null && baixo.prox != null){
					cima.prox.inf = baixo.prox;
					baixo.prox.sup = cima.prox;
					cima = cima.prox;
					baixo = baixo.prox;
				}// End while
				cima = baixo = null;
			}// End if
			tmp = null;
		}// End for
	}// End Matriz()

	/*
 	* Método que  insere
 	* valores a estrutura de matriz 
 	* dinamica
 	* @param int
 	* @return void
 	*/
	public void inserir(int elemento,int col,int ln) throws Exception{
		int i = 1;
		int j = 1;
		Celula tmp = this.inicio;
		while(j < col){
			tmp = tmp.inf;
			j++;
		}// End while
		while(i < ln){
			tmp = tmp.prox;
			i++;
		}// End while
		tmp.elemento = elemento;
	}// End inserir()

	/*
 	* Método que indica se
 	* a matriz está vazia ou não
 	* @param void
 	* @return boolean
 	*/
	public boolean isVazia(){
		return this.inicio == null ? true : false;
	}// End isVazia()

	/*
 	* Metodo que retorna
 	* o tamanho da linha
	* @param void
 	* @return int
 	*/
	public int lengthLn(){
		int tam = 1;
		for(Celula i = this.inicio; i != null; i = i.prox, tam++);
		return tam;
	}// End lengthLn()

	/*
 	* Metodo que retorna
 	* o tamanho da coluna
	* @param void
 	* @return int
 	*/
	public int lengthCol(){
		int tam = 1;
		for(Celula i = this.inicio; i != null; i = i.inf, tam++);
		return tam;
	}// End lengthCol() 

	/*
 	* Metodo que mostra os valores
	* da diagonal principal de uma matriz
 	* @param void
 	* @return void
 	*/
	public void mostrarDiagonalPrincipal(){
		Celula j = this.inicio;
		while(j != null){
			MyIO.print(j.elemento + " ");
			if(j.prox != null){
				j = j.prox.inf;
			}// End if
			else{
				j = null;
			}// End else
		}// End while
				MyIO.println("");
	}// End mostrarDiagonalPrincipal() 

	/*
 	* Metodo que mostra os valores
	* da diagonal secundaria de uma matriz
 	* @param void
 	* @return void
 	*/	
	public void mostrarDiagonalSecundaria(){
		Celula j = this.inicio;
		while(j.prox != null) j = j.prox;
		while(j != null){
			MyIO.print(j.elemento + " ");
			if(j.ant != null){
				j = j.ant.inf;
			}// End if
			else{
				j = null;
			}// End else
		}// End while
			MyIO.println("");
	}// End mostrarDiagonalSecundaria()

	/*
 	* Método que mostra da matriz dinamica
 	* @param void
 	* @return void
 	*/
	public void mostrar(){
		Celula indice = this.inicio;
		while(indice != null){
			for(Celula i = indice; i != null; i = i.prox){
				MyIO.print(i.elemento + " ");
			}// End for
			MyIO.println("");
			indice = indice.inf;
		}// End while
	}// End mostrar()

	/*
 	* Método que soma os elementos
 	* da matriz dinamica
 	* @param Matriz
 	* @return Matriz
 	*/
	public Matriz somaMatriz(Matriz matriz) throws Exception{
		if(matriz.lengthCol() != lengthCol() || matriz.lengthLn() != lengthLn()){
			throw new Exception("erro");
		}// End if
		Matriz nova = new Matriz(lengthLn()-1,lengthCol()-1);
		Celula i = this.inicio;
		Celula j = matriz.inicio;
		Celula l = null;
		Celula lne = null;
		for(int col = 1; col <=  lengthCol()-1; col++){
			l = i;
			lne = j;
			for(int ln = 1; ln <= lengthLn()-1; ln++){
				nova.inserir((l.elemento+lne.elemento),col,ln);
				l = l.prox;
				lne = lne.prox;
			}// End for
			i = i.inf;
			j = j.inf;
		}// End for
		return nova;
	}// End Matriz

	/*
 	* Método que multiplica os elementos
 	* da matriz dinamica
 	* @param Matriz
 	* @return Matriz
 	*/
	public Matriz multiplicacao(Matriz matriz1, Matriz matriz2) throws Exception{
		int soma = 0;
		Matriz matriz3 = null;
		if(matriz1.lengthCol() == matriz2.lengthLn()){
			matriz3 = new Matriz(matriz1.lengthLn()-1,matriz2.lengthCol()-1);
			Celula ln = matriz1.inicio;
			Celula col = matriz2.inicio;
			Celula lne = null;
			Celula colu = null;
			for(int linha = 1; linha <= lengthLn()-1; linha++){
				for(int coluna = 1; coluna <= lengthCol()-1; coluna++){
					lne = ln;
					colu = col;
					while(lne != null && colu != null){
						soma += (lne.elemento*colu.elemento);
						lne = lne.prox;
						colu = colu.inf;
					}// End while
					matriz3.inserir(soma,coluna,linha);
					ln = ln.inf;
					soma = 0;
				}// End for
				soma = 0;
				ln = this.inicio;
				col = col.prox;
			}// End for
		}// End if
		else throw new Exception("erro");
			return matriz3;
	}// End multiplicacao() 
}// End Matriz

public class Main{
	public static void main(String[] args) throws Exception{
		MyIO.setCharset("UTF-8");
		int i = 0;
		Matriz m1 = null;
		Matriz m2 = null;
		Matriz m3 = null;
		int ocorrencia = MyIO.readInt();
		while(i < ocorrencia){
			int ln =  MyIO.readInt();
			int col = MyIO.readInt();
			m1 = new Matriz(ln,col);
			for(int coluna = 1; coluna <= col; coluna++){
				for(int linha = 1; linha <= ln; linha++){
					int x = MyIO.readInt();
					m1.inserir(x,coluna,linha);
				}// End for
			}// End for
			int lne = MyIO.readInt();
			int colu = MyIO.readInt();
			m2 = new Matriz(lne,colu);
			for(int coluna = 1; coluna <= colu; coluna++){
				for(int linha = 1; linha <= lne; linha++){
					int x = MyIO.readInt();
					m2.inserir(x,coluna,linha);
				}// End for
			}// End for
			m1.mostrarDiagonalPrincipal();
			m1.mostrarDiagonalSecundaria();
			m3 = m1.somaMatriz(m2);
			m3.mostrar();
			Matriz m4 = m1.multiplicacao(m1,m2);
			m4.mostrar();
			i++;
		}// End while 
	}// End main()
}// End class 