import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
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
				this.setPaisOrigem(trim(str));
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
				this.setIdiomaOriginal(trim(str));
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
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista{
   private Serie[] array;
   private int n;
   int cont;
   
   /**
    * Construtor da classe.
    */
   public Lista(){
      this(6);
   }// End Lista

   /**
    * Construtor da classe.
    * @param tamanho Tamanho da lista.
    */
   public Lista(int tamanho){
      array = new Serie[tamanho];
      n = 0;
      cont = 0;
   }// End Lista()

   /**
    * Insere um elemento na primeira posicao da lista e move os demais
    * elementos para o fim da lista.
    * @param x Serie elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirInicio(Serie x) throws Exception {
      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }// End if

      //levar elementos para o fim do array
      for(int i = n; i > 0; i--){
         array[i] = array[i-1];
      }// End for

      array[0] = x;
      n++;
   }// End inserirInicio()

   /**
    * Insere um elemento na ultima posicao da lista.
    * @param x Serie elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirFim(Serie x) throws Exception {
      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }// End if

      array[n] = x;
      n++;
   }// End inserirFim()

   /**
    * Insere um elemento em uma posicao especifica e move os demais
    * elementos para o fim da lista.
    * @param x Serie elemento a ser inserido.
    * @param pos Posicao de insercao.
    * @throws Exception Se a lista estiver cheia ou a posicao invalida.
    */
   public void inserir(Serie x, int pos) throws Exception {
      //validar insercao
      if(n >= array.length || pos < 0 || pos > n){
         throw new Exception("Erro ao inserir!");
      }// End if

      //levar elementos para o fim do array
      for(int i = n; i > pos; i--){
         array[i] = array[i-1];
      }// End for

      array[pos] = x;
      n++;
   }// End inserir

   /**
    * Remove um elemento da primeira posicao da lista e movimenta 
    * os demais elementos para o inicio da mesma.
    * @return resp Serie elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Serie removerInicio() throws Exception {
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }// End if

      Serie resp = array[0];
      n--;

      for(int i = 0; i < n; i++){
         array[i] = array[i+1];
      }// End for
      return resp;
   }// End removerInicio()

   /**
    * Remove um elemento da ultima posicao da lista.
    * @return resp Serie elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Serie removerFim() throws Exception {
      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }// End if
      return array[--n];
   }// End removerFim()

   /**
    * Remove um elemento de uma posicao especifica da lista e 
    * movimenta os demais elementos para o inicio da mesma.
    * @param pos Posicao de remocao.
    * @return resp Serie elemento a ser removido.
    * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
    */
   public Serie remover(int pos) throws Exception {
      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }// End if
      Serie resp = array[pos];
      n--;

      for(int i = pos; i < n; i++){
         array[i] = array[i+1];
      }// End for
      return resp;
   }// End remover()

   /**
    * Mostra os elementos da lista.
    */
   public void mostrar(){
      for(int i = 0; i < n; i++){
        array[i].imprimir();
      }// End for
   }// End mostrar()

   /**
    * Procura um elemento e retorna se ele existe.
    * @param x Serie elemento a ser pesquisado.
    * @return <code>true</code> se o array existir,
    * <code>false</code> em caso contrario.
    */
   public boolean pesquisaSequencial(String str){
      boolean resp = false;
      for(int i = 0; i < n; i++){
		contNumeroComparacoes();	          
        if(this.array[i].getNome().equals(str)){
          resp = true;
        }// End if
      }// End for
      return resp;
   }// End pesquisaSequencial()

   /**
    * Conta o numero de comparações
    * @param void
    * @return int
    */
   public int contNumeroComparacoes(){
		return cont++;
	}// End contnumeroComparacoes()
}// End class Lista


	public int valorAsciinome(String str){
		int cont = 0;
		for(int i = 0; i < str.length(); i++){
			cont += (int)str.charAt(i);
		}// End for
	}// End valorAsciinome() 


public class Main{
	public static void main(String[] args) throws Exception{
		double inicio = now();
		MyIO.setCharset("UTF-8");
		String str;
		Serie[] serie = new Serie[1000];
		Lista lista = new Lista(1000);
		int i = 0;
		int pos = 0;
		Serie s = null;

		for(str = MyIO.readLine();!str.equals("FIM");str = MyIO.readLine()){
			serie[i] = new Serie();
			serie[i].ler(str);
			lista.inserirFim(serie[i]);	
			i++;
	  	}// End for

	  	for(str = MyIO.readLine(); !str.equals("FIM"); str = MyIO.readLine()){
	  		MyIO.println(lista.pesquisaSequencial(str) ? "SIM" : "NÃO");
	  	}// End for
	  	int comparacoes = lista.contNumeroComparacoes();
	  	double fim = now();
	  	double tempo = (fim-inicio);
		createFile(576920,comparacoes,(tempo/1000));
	}// End main()

	/**
    * Cria um arquivo e seta
    * matricula comparações e tempo
    * @param int double
    * @return void
    */
	public static void createFile(int matricula,int comparacoes,double tempo) throws Exception{
		FileWriter file = new FileWriter("matrícula_sequencial");
		file.write(matricula + "\t" + comparacoes + "\t" + tempo);
		file.close();
	}// End createFile
	/**
    * Retorna o tempo corrente
    * @param void
    * @return long
    */
	public static long now(){
		return new Date().getTime();
	}// End now()
}// End class Main