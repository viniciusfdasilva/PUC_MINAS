import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
/**
 * Serie
 * @author Vinicius Francisco da Silva
 * @version 1 09/2017
 */
class Serie{
	private String nome;
	private String formato;
	private String duracao;
	private	String pais_origem;
	private String idioma_original;
	private String emissora;
	private String transmissao;
	private int numero_temporadas;
	private int numero_episodios;

	/*
     * Construtor Serie que seta  os
     * atributos 
     * @param String e int
     * @return void
     */
	public Serie(String nome,String formato,String duracao,String pais_origem,String idioma_original,String emissora,String transmissao,int numero_temporadas,int numero_episodios){
		setNome(nome);
		setFormato(formato);
		setDuracao(duracao);
		setPaisOrigem(pais_origem);
		setIdiomaOriginal(idioma_original);
		setEmissora(emissora);
		setTransmissao(transmissao);
		setNumeroTemporadas(numero_temporadas);
		setNumeroEpisodios(numero_episodios);
	}// End Serie()

	/*
     * Construtor Serie que seta nos
     * atributos 
     * @param void
     * @return void
     */
	public Serie(){
		setNome("");
		setFormato("");
		setDuracao("");
		setPaisOrigem("");
		setIdiomaOriginal("");
		setEmissora("");
		setTransmissao("");
		setNumeroTemporadas(0);
		setNumeroEpisodios(0);		
	}// End Serie()

	/*
     * Metodo que recebe um valor como 
     * parametro e seta o mesmo no atri
     * buto
     * @param String
     * @return void
     */
	public void setNome(String nome){
		this.nome = nome;
	}// End setNome()

	/*
     * Metodo que retorna o atributo privado
     * @param void
     * @return String
     */
	public String getNome(){
		return this.nome;
	}// End getNome()

	/*
     * Metodo que recebe um valor como 
     * parametro e seta o mesmo no atri
     * buto
     * @param String
     * @return void
     */
	public void setFormato(String formato){
		this.formato = formato;
	}// End setFormato()

	/*
     * Metodo que retorna o atributo privado
     * @param void
     * @return String
     */
	public String getFormato(){
		return this.formato;
	}// End getFormato()

	/*
     * Metodo que recebe um valor como 
     * parametro e seta o mesmo no atri
     * buto
     * @param String
     * @return void
     */
	public void setDuracao(String duracao){
		this.duracao = duracao;
	}// End setDuracao()

	/*
     * Metodo que retorna o atributo privado
     * @param void
     * @return String
     */
	public String getDuracao(){
		return this.duracao;
	}// End getFormato()

	/*
     * Metodo que recebe um valor como 
     * parametro e seta o mesmo no atri
     * buto
     * @param String
     * @return void
     */
	public void setPaisOrigem(String pais_origem){
		this.pais_origem = pais_origem;
	}// End setPaisOrigem()

	/*
     * Metodo que retorna o atributo privado
     * @param void
     * @return String
     */
	public String getPaisOrigem(){
		return this.pais_origem;
	}// End getPaisOrigem()

	/*
     * Metodo que recebe um valor como 
     * parametro e seta o mesmo no atri
     * buto
     * @param String
     * @return void
     */
	public void setIdiomaOriginal(String idioma_original){
		this.idioma_original = idioma_original;
	}// End setIdiomaOriginal()

	/*
     * Metodo que retorna o atributo privado
     * @param void
     * @return String
     */
	public String getIdiomaOriginal(){
		return this.idioma_original;
	}// End getIdiomaOriginal()

	/*
     * Metodo que recebe um valor como 
     * parametro e seta o mesmo no atri
     * buto
     * @param String
     * @return void
     */
	public void setEmissora(String emissora){
		this.emissora = emissora;
	}// End setEmissora()

	/*
     * Metodo que retorna o atributo privado
     * @param void
     * @return String
     */
	public String getEmissora(){
		return this.emissora;
	}// End getemissora()

	/*
     * Metodo que recebe um valor como 
     * parametro e seta o mesmo no atri
     * buto
     * @param String
     * @return void
     */
	public void setTransmissao(String transmissao){
		this.transmissao = transmissao;
	}// End setTransmissao()

	/*
     * Metodo que retorna o atributo privado
     * @param void
     * @return String
     */
	public String getTransmissao(){
		return this.transmissao;
	}// End getTransmissao()

	/*
     * Metodo que recebe um valor como 
     * parametro e seta o mesmo no atri
     * buto
     * @param int
     * @return void
     */
	public void setNumeroTemporadas(int numero_temporadas){
		this.numero_temporadas = numero_temporadas;
	}// End setNumeroTemporadas() 

	/*
     * Metodo que retorna o atributo privado
     * @param void
     * @return int
     */
	public int getNumeroTemporadas(){
		return this.numero_temporadas;
	}// End getNumeroTemporadas() 

	/*
     * Metodo que recebe um valor como 
     * parametro e seta o mesmo no atri
     * buto
     * @param int
     * @return void
     */
	public void setNumeroEpisodios(int numero_episodios){
		this.numero_episodios = numero_episodios;
	}// End setNumeroEpisodios() 

	/*
     * Metodo que retorna o atributo privado
     * @param void
     * @return String
     */
	public int getNumeroEpisodios(){
		return this.numero_episodios;
	}// End getNumeroTemporadas() 

	/*
     * Metodo que imprimi os valores 
     * dos atributos 
     * @param void
     * @return void
     */
	public void imprimir(){
		MyIO.println(getNome() + " " + getFormato() + " " + getDuracao() + " " + getPaisOrigem() + " " + getIdiomaOriginal() + " " + getEmissora() + " " + getTransmissao() + " " + getNumeroTemporadas() + " " + getNumeroEpisodios());
	}// End imprimir()

	/*
     * Metodo que clona o objeto 
     * @param void
     * @return new Serie
     */
	protected Serie clone(){
		return new Serie(getNome(),getFormato(),getDuracao(),getPaisOrigem(),getIdiomaOriginal(),getEmissora(),getTransmissao(),getNumeroTemporadas(),getNumeroEpisodios());
	}// End clone()

	/*
     * Metodo que remover todos os padrões
     * de tag da linha passada como parametro
     * @param String
     * @return String
     */
	public String removeTag(String str){
		for(int i = str.indexOf("<"); str.contains("<") && str.contains(">"); i = str.indexOf("<")){
			int j = str.indexOf(">");
			str = str.replace(str.substring(i,j+1),"");
		}// End for
		return str; 
	}// End removeTag

	/*
     * Metodo que remove os espaço em
     * branco do inicio ou do fim da
     * String passada como parametro
     * @param String
     * @return String
     */
	public String trim(String str){
		if(str.charAt(0) == ' '){
			str = str.substring(1,str.length());
		}// End if
		if(str.charAt(str.length()-1) == ' '){
			str = str.substring(0,str.length());
		}// End if
		return str;
	}// End trim()

	/*
     * Metodo lê um arquivo faz mineração
     * dos dados e seta os mesmos nos atributos 
     * @param String
     * @return void
     */
	public void ler(String serie) throws Exception{
		String str = null;
		String diretorio = "/tmp/";
		String endereco = diretorio.concat(serie);
		BufferedReader bufferedreader = null;
		try{
			bufferedreader = new BufferedReader(new FileReader(endereco));	
		}// End try
		catch(Exception e){
			e.printStackTrace();
		}// End catch

		String nome = serie.replace(".html","");
		for(str = bufferedreader.readLine(); str != null; str = bufferedreader.readLine()){		
			if(str.contains("<title>") && str.contains("</title>")){
				str = removeTag(str);
				if(str.contains("&#160;")){
					str = str.replace("&#160;","");
				}// End if
				if(str.contains("&nbsp;")){
					str = str.replace("&nbsp;","");
				}// End if
				this.setNome(trim(str.substring(0,nome.length())));
				str = bufferedreader.readLine();
			}// End if
			if(str.contains(">Formato</td>")){
				str = bufferedreader.readLine();
				str = removeTag(str);
				if(str.contains("&#160;")){
					str = str.replace("&#160;","");
				}// End if
				if(str.contains("&nbsp;")){
					str = str.replace("&nbsp;","");
				}// End if
				this.setFormato(trim(str));
				str = bufferedreader.readLine();
			}// End if
			if(str.contains(">Duração</td>")){
				str = bufferedreader.readLine();
				str = removeTag(str);
				if(str.contains("&#160;")){
					str = str.replace("&#160;","");
				}// End if
				if(str.contains("&nbsp;")){
					str = str.replace("&nbsp;","");
				}// End if
				this.setDuracao(trim(str));
				str = bufferedreader.readLine();
			}// End if
			if(str.contains(">País de origem</td>")){
				str = bufferedreader.readLine();
				str = removeTag(str);
				if(str.contains("&#160;")){
					str = str.replace("&#160;","");
				}// End if
				if(str.contains("&nbsp;")){
					str = str.replace("&nbsp;","");
				}// End if
				this.setPaisOrigem(str.trim());
				str = bufferedreader.readLine();
			}// End if
			if(str.contains(">Idioma original</td>")){
				str = bufferedreader.readLine();
				str = removeTag(str);
				if(str.contains("&#160;")){
					str = str.replace("&#160;","");
				}// End if
				if(str.contains("&nbsp;")){
					str = str.replace("&nbsp;","");
				}// End if
				this.setIdiomaOriginal(str.trim());
				str = bufferedreader.readLine();
			}// End if
			if(str.contains(">Emissora de televisão original</td>")){
				str = bufferedreader.readLine();
				str = removeTag(str);
				if(str.contains("&#160;")){
					str = str.replace("&#160;","");
				}// End if
				if(str.contains("&nbsp;")){
					str = str.replace("&nbsp;","");
				}// End if
				this.setEmissora(trim(str));
				str = bufferedreader.readLine();
			}// End if
			if(str.contains(">Transmissão original</td>")){
				str = bufferedreader.readLine();
				str = removeTag(str);
				if(str.contains("&#160;")){
					str = str.replace("&#160;","");
				}// End if
				if(str.contains("&nbsp;")){
					str = str.replace("&nbsp;","");
				}// End if
				this.setTransmissao(trim(str));
				str = bufferedreader.readLine();
			}// End if			
			if(str.contains(">N.º de temporadas</td>")){
				str = bufferedreader.readLine();
				str = removeTag(str);
				if(str.contains("&#160;")){
					str = str.replace("&#160;","");
				}// End if
				if(str.contains("&nbsp;")){
					str = str.replace("&nbsp;","");
				}// End if
				String[] line = str.split(" ");
				try{
					this.setNumeroTemporadas(Integer.parseInt(line[0]));
				}// End try
				catch(Exception e){
					throw new Exception("ERRO: " + e);
				}// End catch
				str = bufferedreader.readLine();
			}// End if
			if(str.contains(">N.º de episódios</td>")){
				str = bufferedreader.readLine();
				str = removeTag(str);
				if(str.contains("&#160;")){
					str = str.replace("&#160;","");
				}// End if
				if(str.contains("&nbsp;")){
					str = str.replace("&nbsp;","");
				}// End if
				String[] line = str.split(" ");
				try{
					this.setNumeroEpisodios(Integer.parseInt(line[0]));
				}// End try
				catch(Exception e){
					throw new Exception("ERRO " + e);
				}// End catch
			}// End if
		}// End for
		bufferedreader.close();
	}// End ler()
}// End class Serie

/**
 * Celula Dupla (lista dupla dinamica)
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class CelulaDupla{
	public Serie elemento;
	public CelulaDupla ant;
	public CelulaDupla prox;

	/**
	 * Construtor da classe.
	 */
	public CelulaDupla() {
		this(null);
	}// End CelulaDupla()

	/**
	 * Construtor da classe.
	 * @param elemento int inserido na celula.
	 */
	public CelulaDupla(Serie elemento) {
		this.elemento = elemento;
		this.ant = this.prox = null;
	}// End CelulaDupla()

}// End CelulaDupla()

/**
 * Lista dupla dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class ListaDupla{
	private CelulaDupla primeiro;
	private CelulaDupla ultimo;
	private int cont;
	private int mov;
	/**
	 * Construtor da classe que cria uma lista dupla sem elementos (somente no cabeca).
	 */
	public ListaDupla() {
		primeiro = new CelulaDupla();
		ultimo = primeiro;
		mov = cont = 0;
	}// End ListaDupla()

	/**
	 * Insere um elemento na primeira posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirInicio(Serie x) {
	  CelulaDupla tmp = new CelulaDupla(x);
      tmp.ant = primeiro;
      tmp.prox = primeiro.prox;
      primeiro.prox = tmp;
      if(primeiro == ultimo){
         ultimo = tmp;
      }else{
         tmp.prox.ant = tmp;
      }// End else
      tmp = null;
	}// End inserirInicio()

	/**
	 * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirFim(Serie x) {
		ultimo.prox = new CelulaDupla(x);
      	ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
	}// End inserirFim()

	/**
	 * Remove um elemento da primeira posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public Serie removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}// End if
      	CelulaDupla tmp = primeiro;
		primeiro = primeiro.prox;
		Serie resp = primeiro.elemento;
      	tmp.prox = primeiro.ant = null;
      	tmp = null;
		return resp;
	}// End removerInicio()

	/**
	 * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public Serie removerFim() throws Exception {
	   if(primeiro == ultimo) {
		 throw new Exception("Erro ao remover (vazia)!");
	   }// End if 
      Serie resp = ultimo.elemento;
      ultimo = ultimo.ant;
      ultimo.prox.ant = null;
      ultimo.prox = null;
	  return resp;
	}// End removerFim()

	/**
    * Insere um elemento em uma posicao especifica considerando que o 
    * primeiro elemento valido esta na posicao 0.
    * @param x int elemento a ser inserido.
	 * @param pos int posicao da insercao.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
   public void inserir(Serie x, int pos) throws Exception{
      int tamanho = tamanho();
      if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      }else if (pos == 0){
         inserirInicio(x);
      }else if (pos == tamanho){
         inserirFim(x);
      }else {
		 // Caminhar ate a posicao anterior a insercao
         CelulaDupla i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
         CelulaDupla tmp = new CelulaDupla(x);
         tmp.ant = i;
         tmp.prox = i.prox;
         tmp.ant.prox = tmp.prox.ant = tmp;
         tmp = i = null;
      }// End else
   }// End inserir()

	/**
    * Remove um elemento de uma posicao especifica da lista
    * considerando que o primeiro elemento valido esta na posicao 0.
	 * @param posicao Meio da remocao.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public Serie remover(int pos) throws Exception {
      Serie resp;
      int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");
      } else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } else if (pos == 0){
         resp = removerInicio();
      } else if (pos == tamanho - 1){
         resp = removerFim();
      } else {
		   // Caminhar ate a posicao anterior a insercao
         CelulaDupla i = primeiro.prox;
         for(int j = 0; j < pos; j++, i = i.prox);
         i.ant.prox = i.prox;
         i.prox.ant = i.ant;
         resp = i.elemento;
         i.prox = i.ant = null;
         i = null;
      }// End else

		return resp;
	}// End remover()

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar(){
		for(CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
			i.elemento.imprimir();
		}// End for
	}// End mostrar()

	/**
	 * Mostra os elementos da lista de forma invertida 
    * e separados por espacos.
	 */
	public void mostrarInverso() {
	  for(CelulaDupla i = ultimo; i != primeiro; i = i.ant){
		i.elemento.imprimir();
      }// End for
	}// End mostrarInverso()

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(Serie x) {
		boolean resp = false;
		for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento == x){
            resp = true;
            i = ultimo;
         }// End if
		}// End for
		return resp;
	}// End pesquisar()

	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * @return resp int tamanho
	 */
   public int tamanho(){
      int tamanho = 0; 	
      for(CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }// End tamanho()

  /**
   * Encontra o meio da Estrutura
    * @param int esq 
    * @param int dir 
    * @return CelulaDupla 
  */
  public CelulaDupla encontraMeio(int esq,int dir){
  	int cont = 0;
  	CelulaDupla i = this.primeiro.prox;
  	while(cont < (int)((esq+dir)/2)){
  		i = i.prox;
  		cont++;
  	}// End while
  	return i;
  }// End econtraMeio()

  /**
   * Algoritmo de ordenacao Quicksort.
   */
  public void quicksortNome(){
      quicksortNome(this.primeiro.prox,this.ultimo,0,tamanho()-1);
   }// End quicksort

  /**
   * Algoritmo de ordenacao Quicksort.
    * @param int esq inicio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
   */
    private void quicksortNome(CelulaDupla esq, CelulaDupla dir,int begin,int end){
        // Ponteiros para acesso a estrutura
        CelulaDupla i = esq;
        CelulaDupla j = dir;
        // Variaveis para controle de execução do algoritimo
     
     	int inicio = begin;
     	int fim = end;
        // Atribuindo o objeto do meio da estrutura para o pivo
        Serie pivo = encontraMeio(begin,end).elemento;	
        while(inicio <= fim){ 
            while(i.elemento.getNome().compareTo(pivo.getNome()) > 0){
            	i = i.prox; 
            	inicio++;
            	contNumeroComparacoes();
            }// Edn while
            contNumeroComparacoes();
            while(j.elemento.getNome().compareTo(pivo.getNome()) < 0){
            	j = j.ant; 
            	fim--;
            	contNumeroComparacoes();
            }// End while
            contNumeroComparacoes();
            if(inicio <= fim){
              swap(i,j);
              contNumeroMovimentacoes();
              i = i.prox;
              j = j.ant;
              inicio++;
              fim--;
            }// End if
        }// End while
         if(begin < fim)quicksortNome(esq,j,begin,fim);
         if(inicio < end)quicksortNome(i,dir,inicio,end); 
    }// End quicksortNome()

   /**
   * Algoritmo de ordenacao Quicksort.
   */
  public void quicksortPais(){
      quicksortPais(this.primeiro.prox,this.ultimo,0,tamanho()-1);
   }// End quicksort

  /**
   * Algoritmo de ordenacao Quicksort.
    * @param int esq inicio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
   */
    private void quicksortPais(CelulaDupla esq, CelulaDupla dir,int begin,int end){
        // Ponteiros para acesso a estrutura
        CelulaDupla i = esq; 
        CelulaDupla j = dir;
        // Atribuindo o objeto do meio da estrutura para o pivo
        int inicio = begin; 
        int fim = end;
 		quicksortNome(esq,dir,begin,end);
 		Serie pivo = encontraMeio(begin,end).elemento;
        while(inicio <= fim){ 
          while(i.elemento.getPaisOrigem().compareTo(pivo.getPaisOrigem()) < 0){
          	i = i.prox; 
          	inicio++;
          	contNumeroComparacoes();
          }// End while
          contNumeroComparacoes();
          while(j.elemento.getPaisOrigem().compareTo(pivo.getPaisOrigem()) > 0){
          	j = j.ant; 
          	fim--;
          	contNumeroComparacoes();
          }// End while
         	contNumeroComparacoes();
            if(inicio <= fim){
              swap(i,j);
              contNumeroMovimentacoes();
              i = i.prox;
              j = j.ant;
              inicio++;
              fim--;
     	    }// End if
        }// End while
        if(begin < fim)quicksortPais(esq,j,begin,fim);
        if(inicio < end)quicksortPais(i,dir,inicio,end);
    }// End quicksortPais()

    /**
    * Troca o conteudo de duas posicoes do array
    * @param i int primeira posicao
    * @param j int segunda posicao
    */
   private void swap(CelulaDupla i, CelulaDupla j){
      Serie temp = i.elemento;
      i.elemento = j.elemento;
      j.elemento = temp;
   }// End swap()

  /**
    * Conta o numero de movimentações
    * @param void
    * @return int
    */
  public int contNumeroMovimentacoes(){
    return mov++;
  }// End contnumeroMovimentacoes()

  /**
    * Conta o numero de comparacoes
    * @param void
    * @return int
    */
  public int contNumeroComparacoes(){
    return cont++;
  }// End contnumeroComparacoes()
}// End class Lista

public class Main{
	public static void main(String[] args) throws Exception{
		double inicio = now();
		MyIO.setCharset("UTF-8");
		String str;
		Serie[] serie = new Serie[1000];
		ListaDupla lista = new ListaDupla();
		int i = 0;
		for(str = MyIO.readLine();!str.equals("FIM");str = MyIO.readLine()){
		  serie[i] = new Serie();
		  serie[i].ler(str);
		  lista.inserirFim(serie[i]);	
		  i++;
	   }// End for
    	lista.quicksortPais();
    	lista.mostrar();
    	double fim = now();
		int comparacoes = lista.contNumeroComparacoes();
		int movimentacoes = lista.contNumeroMovimentacoes();
		createFile(576920,comparacoes,movimentacoes,fim-inicio);
	}// End main()
  
  /**
    * cria um arquivo setando a matricula
    * o numero de comparações e numero de
    * movimentações e o tempo
    * @param int
    * @return void
    */
  public static void createFile(int matricula,int comparacoes,int movimentacoes,double tempo) throws Exception{
    FileWriter file = new FileWriter("matrícula_quicksort");
    file.write(matricula + "\t" + comparacoes + "\t" + movimentacoes + "\t" + tempo);
    file.close();
  }// End createFile()

  /**
    * Retorna o tempo corrente
    * @param void
    * @return long
    */
  public static long now(){
    return new Date().getTime();
  }// End now()
}// End class Main
