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
 * No da arvore binaria
 * 
 * @author Max do Val Machado
 */
class No{
	public Serie elemento; // Conteudo do no.
	public No esq; // No da esquerda.
	public No dir; // No da direita.
	public int nivel; // Numero de niveis abaixo do no

	/**
	 * Construtor da classe.
	 * 
	 * @param elemento
	 *            Conteudo do no.
	 */
	No(Serie elemento){
		this(elemento,null,null,1);
	}// End No

	/**
	 * Construtor da classe.
	 * 
	 * @param elemento
	 *            Conteudo do no.
	 * @param esq
	 *            No da esquerda.
	 * @param dir
	 *            No da direita.
	 */
	No(Serie elemento, No esq, No dir, int nivel) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.nivel = nivel;
	}// End No

	/**
         * Cálculo do número de níveis a partir de um vértice
         * @return No
         */
	public No setNivel(){
		this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
		return this;
	}// End setNivel()
        
	/**
         * Retorna o número de níveis a partir de um vértice
         * @param no
         * @return int 
         */
        public static int getNivel(No no){
            return (no == null) ? 0 : no.nivel;
	}// End getNivel
}// End class No

/**
 * AVL - Árvore Binária de Pesquisa com algoritmo de balanceamento AVL.
 * 
 * @author Max do Val Machado
 */
class AVL{
	private No raiz; // Raiz da arvore.
	int cont;
	/**
	 * Construtor da classe.
	 */
	public AVL(){
		raiz = null;
		cont = 0;
	}// End AVL()
        
        /**
         * pega a altura da estrutura
         * @return int 
         */
	public int getAltura(){
            return nivel(raiz) - 1;
	}// End getAltura()

        /**
         * pega o nivel da estrutura
         * @param no
         * @return 
         */
	private int nivel(No no){
            return (no == null) ? 0 : (1 + Math.max(nivel(no.esq), nivel(no.dir)));
	}// End nivel()

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * 
	 * @param elemento
	 *            Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir, <code>false</code> em
	 *         caso contrario.
	 */
	public boolean pesquisar(String elemento){
            MyIO.print("raiz ");
            return pesquisar(raiz,elemento);
	}// End pesquisar()

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 * 
	 * @param no
	 *            No em analise.
	 * @param x
	 *            Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir, <code>false</code> em
	 *         caso contrario.
	 */
	private boolean pesquisar(No no, String x){
            boolean resp;
            if (no == null){
		resp = false;
            } else if (x.equals(no.elemento.getNome())){
		numeroComparacoes();
		resp = true;
            } else if (x.compareTo(no.elemento.getNome()) < 0){
                numeroComparacoes();
                MyIO.print("esq ");
		resp = pesquisar(no.esq,x);
            }else{
		MyIO.print("dir ");
		resp = pesquisar(no.dir,x);
            }// End else
            return resp;
	}// End pesquisar()

	/**
	 * Metodo publico iterativo para inserir elemento.
	 * 
	 * @param x
	 *            Elemento a ser inserido.
	 * @throws Exception
	 *             Se o elemento existir.
	 */
	public void inserir(Serie x) throws Exception{
		raiz = inserir(raiz,x);
	}// End inserir

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * 
	 * @param no
	 *            No em analise.
	 * @param x
	 *            Elemento a ser inserido.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception
	 *             Se o elemento existir.
	 */
	private No inserir(No no,Serie x) throws Exception{
            if (no == null){
		no = new No(x);
            }else if (x.getNome().compareTo(no.elemento.getNome()) < 0){
		no.esq = inserir(no.esq,x);
            }else if (x.getNome().compareTo(no.elemento.getNome()) > 0){
		no.dir = inserir(no.dir,x);
            }else{
		throw new Exception("Erro ao inserir elemento (" + x + ")! ");
            }// End else
            no = balancear(no);
            return no;
	}// End inserir

        /**
         * balanceia a estrutura de árvore
         * @param no
         * @return No
         * @throws Exception 
         */
	private No balancear(No no) throws Exception{
            if(no != null){
		int fator = (no.getNivel(no.dir)- no.getNivel(no.esq));
		// Se balanceada
		if (Math.abs(fator) <= 1){
                    no = no.setNivel();
                    // Se desbalanceada para a direita
		}else if(fator == 2){
                    int fatorFilhoDir = (no.getNivel(no.dir.dir) - no.getNivel(no.dir.esq));
                    // Se o filho a direita tambem estiver desbalanceado
                if(fatorFilhoDir == -1){
                    no.dir = rotacionarDir(no.dir);
                }// End if
                    no = rotacionarEsq(no);
                    // Se desbalanceada para a esquerda
		}else if (fator == -2) {
                    int fatorFilhoEsq = (no.getNivel(no.esq.dir) - no.getNivel(no.esq.esq));
                    // Se o filho a esquerda tambem estiver desbalanceado
                if (fatorFilhoEsq == 1) {
                    no.esq = rotacionarEsq(no.esq);
		}// En if
                    no = rotacionarDir(no);
		}else{
                    throw new Exception("Erro fator de balanceamento (" + fator + ") invalido!");
		}// End else
            }// End if 
            return no;
	}// End balancear()
        
        /**
         * Rotaciona os elementos
         * da estrutura para a direita
         * @param no
         * @return 
         */
	private No rotacionarDir(No no){
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;
		noEsq.dir = no;
		no.esq = noEsqDir;
		no.setNivel();
		noEsq.setNivel();
		return noEsq;
	}// End rotacionarDir

        /**
         * Rotaciona os elementos
         * da estrutura para a esquerda
         * @param no
         * @return 
         */
	private No rotacionarEsq(No no){
		No noDir = no.dir;
		No noDirEsq = noDir.esq;
		noDir.esq = no;
		no.dir = noDirEsq;
		no.setNivel();
		noDir.setNivel();
		return noDir;
	}// ENd rotacionarEsq

	/**
	 * Metodo publico iterativo para remover elemento.
	 * 
	 * @param elemento
	 *            Elemento a ser removido.
	 * @throws Exception
	 *             Se nao encontrar elemento.
	 */
	public void remover(String x) throws Exception{
		raiz = remover(raiz, x);
	}// End remover()

	/**
	 * Metodo privado recursivo para remover elemento.
	 * 
	 * @param no
	 *            No em analise.
	 * @param x
	 *            Elemento a ser removido.
	 * @return No em analise, alterado ou nao.
	 */
	private No remover(No no, String x)  throws Exception{
            if (no == null){
		//throw new Exception("Erro ao remover!");
            }else if(x.compareTo(no.elemento.getNome()) < 0){
                no.esq = remover(no.esq, x);
            }else if (x.compareTo(no.elemento.getNome()) > 0){
                no.dir = remover(no.dir, x);
		// Sem no a direita.
            }else if(no.dir == null){
		no = no.esq;
		// Sem no a esquerda.
            }else if(no.esq == null){
		no = no.dir;
		// No a esquerda e no a direita.
            }else{
		no.esq = antecessor(no,no.esq);
            }// End else
                no = balancear(no);
            return no;
	}// End remover()

	/**
	 * Metodo para trocar no removido pelo antecessor.
	 * 
	 * @param n1
	 *            No que teve o elemento removido.
	 * @param n2
	 *            No da subarvore esquerda.
	 * @return No em analise, alterado ou nao.
	 */
	private No antecessor(No n1, No n2){
            // Existe no a direita.
            if (n2.dir != null) {
		// Caminha para direita.
		n2.dir = antecessor(n1, n2.dir);
		// Encontrou o maximo da subarvore esquerda.
            }else{
		n1.elemento = n2.elemento; // Substitui N1 por N2.
		n2 = n2.esq; // Substitui N2 por N2.ESQ.
            }// End else
            return n2;
	}// End antecessor

	/**
    * Conta o numero de comparacoes
    * @param void
    * @return int
    */
  public int numeroComparacoes(){
	return cont++;
  }// End numeroComparacoes()
}// End class AVL

/**
 * 
 * @author Vinicius Francisco da Silva
 */
public class Tp7Q2{
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
		AVL arvore = new AVL();
		String str = null;
		for(str = MyIO.readLine(); !str.equals("FIM"); str = MyIO.readLine()){
			serie[i] = new Serie();
			serie[i].ler(str);
			arvore.inserir(serie[i]);
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
					arvore.inserir(s);
					break;
				case "R":
					arvore.remover(MyIO.readLine());
					break;
				default: throw new Exception("ERRO " + str);
			}// End switch
			i++;
		}// End while
		for(str = MyIO.readLine(); !str.equals("FIM"); str = MyIO.readLine()){
			MyIO.println(arvore.pesquisar(str) ? "SIM" : "NAO");
		}// End for
		long fim = now();
		int comparacoes = arvore.numeroComparacoes();
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
		FileWriter file = new FileWriter("matrícula_avl");
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








