import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
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
     * Metodo que remover todos os padr??es
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
     * Metodo que remove os espa??o em
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
     * Metodo l?? um arquivo faz minera????o
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
			if(str.contains(">Dura????o</td>")){
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
			if(str.contains(">Pa??s de origem</td>")){
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
			if(str.contains(">Emissora de televis??o original</td>")){
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
			if(str.contains(">Transmiss??o original</td>")){
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
			if(str.contains(">N.?? de temporadas</td>")){
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
			if(str.contains(">N.?? de epis??dios</td>")){
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

class No{
    public char elemento; // Conteudo do no.
    public No esq; // No da esquerda.
    public No dir; // No da direita.
    public No2 outro;
	
   /**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	No(char elemento){
		this.elemento = elemento;
		this.esq = this.dir = null;
    	this.outro = null;
	}// End No()

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No da esquerda.
	 * @param dir No da direita.
	 */
	No(char elemento, No esq, No dir){
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
    	this.outro = null;
	}// End No()
}// End class No

class No2{
	public Serie elemento; // Conteudo do no.
	public No2 esq; // No da esquerda.
	public No2 dir; // No da direita.
	
   /**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	No2(Serie elemento){
		this.elemento = elemento;
		this.esq = this.dir = null;
	}// End No2()

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No2 da esquerda.
	 * @param dir No2 da direita.
	 */
	No2(Serie elemento, No2 esq, No2 dir){
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}// End No2
}// End class No2()

/**
 * Arvore de arvore
 * @author Max do Val Machado
 */
public final class ArvoreArvore{
    private No raiz; // Raiz da arvore.
	/**
         * 
         * @throws Exception 
         */
	public ArvoreArvore()throws Exception{
	this.raiz = null;
      	inserir('D');
      	inserir('R');
      	inserir('Z');
      	inserir('X');
        inserir('V');
      	inserir('B');
      	inserir('F');
      	inserir('P');
      	inserir('U');
      	inserir('I');
      	inserir('G');
      	inserir('E');
      	inserir('J');
      	inserir('J');
      	inserir('H');
      	inserir('T');
      	inserir('A');
      	inserir('W');
      	inserir('S');
      	inserir('O');
      	inserir('M');
      	inserir('N');
      	inserir('K');
      	inserir('C');
      	inserir('Y');
      	inserir('Q');
      	inserir('A');
	}// End ArvoreArvore()

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param elemento Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(String elemento){
		return pesquisar(raiz, elemento);
	}// End pesquisar
    /**
    * 
    * @param no
    * @param x
    * @return 
    */
	private boolean pesquisar(No no, String x){
      boolean resp;
		if(no == null){ 
         resp = false;
      }else if(x.charAt(0) == no.elemento){ 
         resp = pesquisarSegundaArvore(no.outro, x); 
      }else if(x.charAt(0) < no.elemento){ 
         resp = pesquisar(no.esq, x); 
      }else{ 
         resp = pesquisar(no.dir, x); 
      }// End else
      return resp;
	}// End pesquisar()
        /**
         * 
         * @param no
         * @param x
         * @return 
         */
	private boolean pesquisarSegundaArvore(No2 no, String x){
      boolean resp;
		if(no == null){ 
         resp = false;
      }else if(x.equals(no.elemento.getNome())){ 
         resp = true; 
      }else if(x.compareTo(no.elemento.getNome()) < 0){ 
         resp = pesquisarSegundaArvore(no.esq, x); 
      }else{ 
         resp = pesquisarSegundaArvore(no.dir, x); 
      }// End else
      return resp;
	}// End pesquisarSegundaArvore()
   /**
    * 
    * @param letra
    * @throws Exception 
    */
   public void inserir(char letra) throws Exception{
      this.raiz = inserir(this.raiz,letra);
   }// End inserir()
   /**
    * 
    * @param i
    * @param letra
    * @return
    * @throws Exception 
    */
   private No inserir(No i,char letra) throws Exception{
      if(i == null){
         i = new No(letra);
      }// End if
      else if(letra > i.elemento){
         i.dir = inserir(i.dir,letra);
      }// End else
      else if(letra < i.elemento){
         i.esq = inserir(i.esq,letra);
      }// End else if
      else{
         throw new Exception("erro");
      }// End else 
      return i;
   }// End inserir()
   /**
    * 
    * @param serie
    * @throws Exception 
    */
   public void pesquisarInserir(Serie serie) throws Exception{
      pesquisarInserir(this.raiz,serie);
   }// End inserirSegundaArvore()
   /**
    * 
    * @param i
    * @param str
    * @throws Exception 
    */
   private void pesquisarInserir(No i,Serie serie) throws Exception{
      if(i == null){
         throw new Exception("erro");
      }// End pesquisarInserir
      else if(i.elemento > serie.getNome().charAt(0)){
         pesquisarInserir(i.esq,serie);
      }// End else if
      else if(i.elemento < serie.getNome().charAt(0)){
         pesquisarInserir(i.dir,serie);
      }// End else if
      else{
         i.outro = inserirSegundaArvore(i.outro,serie);
      }// End else
   }// End pesquisarInserir()
   /**
    * 
    * @param i
    * @param str
    * @return
    * @throws Exception 
    */
   private No2 inserirSegundaArvore(No2 i,Serie serie) throws Exception{
      if(i == null){
         i = new No2(serie);
      }// End if
      else if(i.elemento.getNome().compareTo(serie.getNome()) < 0){
         i.dir = inserirSegundaArvore(i.dir,serie);
      }// End else if
      else if(i.elemento.getNome().compareTo(serie.getNome()) > 0){
         i.esq = inserirSegundaArvore(i.esq,serie);
      }// End else if
      else{
         throw new Exception("erro");
      }// End else
      return i;
   }// End inserirSegundaArvore()
   /**
    * 
    * @param serie
    * @return
    * @throws Exception 
    */
   public No2 remover(Serie serie) throws Exception{
      return remover(this.raiz,serie);
   }// End remover()
   /**
    * 
    * @param i
    * @param str
    * @return
    * @throws Exception 
    */
   private No2 remover(No i,Serie serie) throws Exception{
      if(i == null){
         throw new Exception("erro");
      }// End if
      else if(serie.getNome().charAt(0) > i.elemento){
         i.dir.outro = remover(i.dir,serie);
      }// End else if
      else if(serie.getNome().charAt(0) < i.elemento){
         i.esq.outro = remover(i.esq,serie);
      }// End else if
      else{
         i.outro = removerSegundaArvore(i.outro,serie);
      }// End else
      return i.outro; 
   }// End remover()
   /**
    * 
    * @param i
    * @param str
    * @return
    * @throws Exception 
    */
   private No2 removerSegundaArvore(No2 i, Serie serie) throws Exception{
      if(i == null){
         throw new Exception("erro");
      }// End if
      else if(i.elemento.getNome().compareTo(serie.getNome()) > 0){
         i.esq = removerSegundaArvore(i.esq,serie);
      }// End else if
      else if(i.elemento.getNome().compareTo(serie.getNome()) < 0){
         i.dir = removerSegundaArvore(i.dir,serie);
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
   }// End removerSegundaArvore()
   /**
    * 
    * @param i
    * @param j
    * @return 
    */
   private No2 anterior(No2 i,No2 j){
      if(j.dir != null){
         j.dir = anterior(i,j.dir);
      }// End if
      else{
         i.elemento = j.elemento;
         j = j.esq;
      }// End esle 
      return j;
   }// End anterior()
}// End class ArvoreArvore
