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
 * 
 * @author Vinicius Fracisco da Silva
 */
class Hash{
   Serie tabela[];
   int m1;
   int posicao;
   int cont;
  
   /**
    * Construtor hash 
    * com parametros void.
    */
   public Hash(){
      this(13);
   }// End Hash()

   /**
    * Construtor da hash
    * com tamanho da hash
    * @param m1
    */
   public Hash(int m1){
      this.m1 = m1;
      this.tabela = new Serie[this.m1];
      for(int i = 0; i < m1; i++){
         tabela[i] = null;
      }// End for
      cont = posicao = 0;
   }// End Hash()

   /**
    * Insere o elemento na tabela
    * hash
    * @param serie
    * @return int
    */
   public boolean inserir(Serie serie)throws Exception{
      boolean resp = false;
      if(serie != null){
         int pos = valorAsciinome(serie.getNome().trim());
         int repos = revalorAsciinome(serie.getNome().trim());
         if(tabela[pos] == null){
            tabela[pos] = serie;
            resp = true;
         }// End if
         else if(tabela[repos] == null){
         	tabela[repos] = serie;
            resp = true;
         }// End else if
      }// End if
      return resp;
   }// End inserir()

   /**
    * Retorna a soma ASCII
    * dos caracteres da String
    * mod o tamanho da hash
    * que corresponde a posicao
    * do elemento na Hash
    * @param str
    * @return int
    */
   public int valorAsciinome(String str){
		int cont = 0;
		for(int i = 0; i < str.length(); i++){
			cont += (int)str.charAt(i);
		}// End for
		return cont % this.m1; 
	}// End valorAsciinome() 

        /**
    * Retorna a soma ASCII
    * dos caracteres da String
    * mod o tamanho da hash
    * que corresponde a posicao
    * do elemento na Hash mais um
    * @param str
    * @return int
    */
	public int revalorAsciinome(String str){
		int cont = 0;
		for(int i = 0; i < str.length(); i++){
			cont += (int)str.charAt(i);
		}// End for
		return (cont+1) % this.m1; 
	}// End valorAsciinome() 

   /**
    * retorna a posição corrente
    * de uma determinada String
    * na hash
    * @param void
    * @return int posicao
    */
   public int getposicao(){
   	return this.posicao;
   }// End getposicao()

   /**
    * Pesquisa uma determinada
    * String na hash
    * @param str
    * @return <code>true</code> caso
    * o elemento esteja na hash
    * <code>false</code> caso contrario
    */
   public boolean pesquisar(String str){
      boolean resp = false;
      int pos = valorAsciinome(str);
      int repos = revalorAsciinome(str);
      if(tabela[pos] != null && tabela[pos].getNome().trim().equals(str)){
         numeroComparacoes();
         this.posicao = pos;
         resp = true;
      }// End if
      else if(tabela[repos] != null && tabela[repos].getNome().trim().equals(str)){
      	 numeroComparacoes();
         this.posicao = repos;
         resp = true;
      }// End else if
      return resp;
   }// End pesquisar()
   
   /**
    * Conta o numero de comparacoes
    * @param void
    * @return int
    */
  public int numeroComparacoes(){
	return cont++;
  }// End numeroComparacoes()
}// End Hash

/**
 * 
 * @author Vinicius Francisco da Silva
 */
public class Main{
        /**
         * 
         * @param args
         * @throws Exception 
         */
	public static void main(String[] args) throws Exception{
		long inicio = now();
		Serie[] serie = new Serie[10000];
		int i = 0;
		Serie s = null;
		Hash hash = new Hash(21);
		String str = null;
		for(str = MyIO.readLine(); !str.equals("FIM"); str = MyIO.readLine()){
			serie[i] = new Serie();
			serie[i].ler(str);
			hash.inserir(serie[i]);
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
					hash.inserir(s);
					break;
				case "R":
					str = MyIO.readLine();
					break;
				default: throw new Exception("ERRO " + str);
			}// End switch
			i++;
		}// End while
		for(str = MyIO.readLine(); !str.equals("FIM"); str = MyIO.readLine()){
			MyIO.println(hash.pesquisar(str) ? hash.getposicao() + " SIM" : "NAO");
		}// End for
		long fim = now();
		int comparacoes = hash.numeroComparacoes();
		createFile(576920,comparacoes,((fim-inicio)/100));
	}// End main()
        
        /**
    * cria um arquivo setando a matricula
    * o numero de comparações e numero de
    * movimentações e o tempo
    * @param int
    * @return void
    */
    public static void createFile(int matricula,int comparacoes,double tempo) throws Exception{
		FileWriter file = new FileWriter("matrícula_hashRehash");
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