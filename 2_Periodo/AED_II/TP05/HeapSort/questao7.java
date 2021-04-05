/**
*Programa para ler HTML e realizar uma lista
*@author Bruno Rodrigues Paschoalino
*@version questao2.java 1.0 - 15/09/2017
*/

import java.io.*;

public class questao7
{
	public static void main(String[] args) throws Exception
	{
		String entrada [] = new String [1000];

		boolean teste = false;

		int numEntrada = 0;

		int tamanho = 61;

		Lista resp = new Lista(tamanho);

		MyIO.setCharset("UTF-8");

		do
		{
			entrada[numEntrada] = MyIO.readLine();

			teste = IfFlag(entrada[numEntrada]);

			numEntrada++;

		} while (teste == false);

		numEntrada--;

		Series aux = new Series();

		for( int i = 0; i < numEntrada; i++ )
		{
			aux.ler(entrada[i]);

			resp.inserirFim(aux);
		}

		resp.heapSort();

		resp.mostrar();
	}

	public static void doLista ( Lista resp ) throws Exception
	{
		int operacoes = MyIO.readInt();

		String array [] = new String [0];

		String aux = "";

		Series auxiliar = new Series();

		for ( int i = 0; i < operacoes; i++)
		{
			aux = MyIO.readLine();

			array = aux.split(" ");

			if ( array[0].equals("II") )
			{
				try
				{
					auxiliar.ler( array[1] );
				}
				catch( Exception e )
				{
				}

				resp.inserirInicio( auxiliar );
			}
			else if ( array[0].equals("IF") )
			{
				try
				{
					auxiliar.ler( array[1] );
				}
				catch( Exception e )
				{

				}

				resp.inserirFim( auxiliar );
			}
			else if ( array[0].equals("I*") )
			{
				try
				{
					auxiliar.ler( array[2] );
				}
				catch( Exception e )
				{

				}

				resp.inserir( auxiliar, Integer.parseInt( array[1] ) );
			}

			else if ( array[0].equals( "RI" ) )
			{
				MyIO.println("(R) " + resp.removerInicio().getNome() );
			}

			else if ( array[0].equals("RF"))
			{
				MyIO.println("(R) " + resp.removerFim().getNome() );
			}

			else if ( array[0].equals("R*"))	
			{
				try
				{
					MyIO.println("(R) " + resp.remover( Integer.parseInt( array[1] ) ).getNome() );
				}
				catch( Exception e )
				{

				}
			}
		}
		resp.mostrar();
	}

	/**
	*Metodo de verificaçao de flag das entradas
	*@param palavra String
	*@return teste boolean
	*/
	public static boolean IfFlag ( String palavra )
	{
		String flag = "FIM";

		boolean teste = false;

		if ( palavra.length() == flag.length() )
		{
			for ( int i = 0; i < palavra.length(); i++)
			{
				if ( palavra.charAt(i) != flag.charAt(i) )
				{
					return false;
				}
				else teste = true;
			}
		}
		return teste;
	}
}

class Series extends Object implements Cloneable 
{
	private String nome;
	private String formato;
	private String duracao;
	private String pais;
	private String idioma;
	private String emissora;
	private String transmissao;
	private int temporadas;
	private int episodios;

	/**
	*Metodo para remover tags do HTML
	*@param linha String
	*@return linha String
	*/
	String removeTag( String linha )
	{
		for ( int i = linha.indexOf("<"); linha.contains("<") && linha.contains(">"); i = linha.indexOf("<") )
		{
			int j = linha.indexOf(">");

			linha = linha.replace(linha.substring(i, (j+1)), "" );
		}
		
		return linha;
	}

	/**
	*Metodo para ler o html e procurar as informaçoes
	*@param entrada String
	*/
	void ler( String entrada ) throws Exception
	{
		Arq.openRead("/tmp/" + entrada, "UTF-8");

		String linha = Arq.readLine();

		String aux = entrada.replace( '_' , ' ' );

		this.setNome(aux.replace( ".html", "") );

		while(linha.contains("</html>") == false )
		{
			linha = Arq.readLine();

			if(linha.contains(">Formato</td>") )
			{
				linha = Arq.readLine();

				linha = removeTag(linha);

				this.setFormato(linha.trim());

				linha = Arq.readLine();
			}

			if( linha.contains(">Duração</td>") )
			{
				linha = Arq.readLine();

				linha = removeTag(linha.trim());

				this.setDuracao(linha.trim());

				linha = Arq.readLine();
			}

			if ( linha.contains(">País de origem</td>") )
			{
				linha = Arq.readLine();

				linha = removeTag(linha.trim());

				linha = linha.replace("&#160;", "");

				linha = linha.replace("&nbsp;", "");

				this.setPais(linha.trim());

				linha = Arq.readLine();
			}

			if( linha.contains(">Idioma original</td>") )
			{
				linha = Arq.readLine();

				linha = removeTag(linha);

				this.setIdioma(linha.trim());

				linha = Arq.readLine();
			}

			if( linha.contains(">Emissora de televisão original</td>") )
			{
				linha = Arq.readLine();

				linha = removeTag(linha);

				this.setEmissora(linha.trim());

				linha = Arq.readLine();
			}

			if( linha.contains(">Transmissão original</td>") )
			{
				linha = Arq.readLine();

				linha = removeTag(linha);

				linha = linha.replace("&#160;", "");

				linha = linha.replace("&nbsp;", "");

				this.setTransmissao(linha.trim());

				linha = Arq.readLine();
			}

			if( linha.contains(">N.º de temporadas</td>") )
			{
				linha = Arq.readLine();

				linha = removeTag(linha);

				String aux1 [] = new String [50];

				aux1 = linha.split(" ");

				try
				{
					this.setTemporadas(Integer.parseInt(aux1[0]) );
				}
				catch(Exception e)
				{
					throw new Exception("erro" + e);
				}
			}

			if( linha.contains(">N.º de episódios</td>") )
			{
				linha = Arq.readLine();

				linha = removeTag(linha);

				String aux2 [] = new String [50];

				aux2 = linha.split(" ");

				try
				{
					this.setEpisodios(Integer.parseInt(aux2[0]) );
				}
				catch(Exception e)
				{
					throw new Exception("erro" + e);
				}
			}
		}
		Arq.close();
	}

	/**
	*Metodo clone
	*@return nome String
	*@return formato String
	*@return duracao String
	*@return pais String
	*@return idioma String
	*@return emissora String
	*@return transmissao String
	*@return temporadas int
	*@return episodios int
	*/
	Series retornarClone()
	{
		try
		{
			return (Series)this.clone();
		}
		catch(CloneNotSupportedException e)
		{
			return null;
		}
	}

	/**
	*Metodo para imprimir
	*/
	void imprimir()
	{
		System.out.println(this.getNome() + " " + this.getFormato() + " " + this.getDuracao() + " " + 
			this.getPais() + " " + this.getIdioma() + " " + this.getEmissora() + " " + this.getTransmissao() + " " + this.getTemporadas()
			 + " " + this.getEpisodios());
	}

	/**
	*Metodo construtor vazio
	*@param nome String
	*@param formato String
	*@param duracao String
	*@param pais String
	*@param idioma String
	*@param emissora String
	*@param transmissao String
	*@param temporadas int
	*@param episodios int
	*/
	Series()
	{
		nome = formato = duracao = pais = idioma = emissora = transmissao = "";
		temporadas = episodios = 0;
	}

	/**
	*Metodo construtor
	*@param nome String
	*@param formato String
	*@param duracao String
	*@param pais String
	*@param idioma String
	*@param emissora String
	*@param transmissao String
	*@param temporadas int
	*@param episodios int
	*/
	Series(String nome, String formato, String duracao, String pais, String idioma, String emissora,
	 String transmissao, int temporadas, int episodios)
	{
		this.setNome(nome);
		this.setFormato(formato);
		this.setDuracao(duracao);
		this.setPais(pais);
		this.setIdioma(idioma);
		this.setEmissora(emissora);
		this.setTransmissao(transmissao);
		this.setTemporadas(temporadas);
		this.setEpisodios(episodios);
	}

	/**
	*Metodos get e set
	*/

	public String getNome() 
	{
		return this.nome;
	}

	public void setNome( String nome )
	{
		this.nome = nome;
	}

	String getFormato()
	{
		return this.formato;
	}

	void setFormato( String formato )
	{
		this.formato = formato;
	}

	String getDuracao()
	{
		return this.duracao;
	}

	void setDuracao( String duracao )
	{
		this.duracao = duracao;
	}

	String getPais()
	{
		return this.pais;
	}

	void setPais( String pais )
	{
		this.pais = pais;
	}

	String getIdioma()
	{
		return this.idioma;
	}

	void setIdioma( String idioma )
	{
		this.idioma = idioma;
	}

	String getEmissora()
	{
		return this.emissora;
	}

	void setEmissora( String emissora )
	{
		this.emissora = emissora;
	}

	String getTransmissao()
	{
		return this.transmissao;
	}

	void setTransmissao( String transmissao )
	{
		this.transmissao = transmissao;
	}

	int getTemporadas()
	{
		return this.temporadas;
	}

	void setTemporadas( int temporadas )
	{
		this.temporadas = temporadas;
	}

	int getEpisodios()
	{
		return this.episodios;
	}

	void setEpisodios( int episodios )
	{
		this.episodios = episodios;
	}
}

class Lista
{
	private Series [] series;
	private int n;

	Series [] getseries()
	{
		return this.series;
	}

	Lista()
	{
		this(6);
	}

	Lista(int tamanho)
	{
		series = new Series[tamanho];

		n = 0;
	}

	void heapSort()
	{
		Series temp [] = new Series[n+1];

		for ( int i = 0; i < n; i++ )
		{
			temp[i+1] = series[i];
		}

		series = temp;

		for ( int tam = 2; tam <= n; tam++)
		{
			constroi(tam);
		}

		int tamHeap = n;

		while( tamHeap > 1 )
		{
			swap(1,tamHeap--);

			reconstroiHeap(tamHeap);
		}

		temp = series;

		series = new Series[n];

		for ( int i = 0; i < n; i++ )
		{
			series[i] = temp[i+1];
		}
	}

	void swap( int i, int j )
	{
		Series temp = series[i];

		series[i] = series[j];

		series[j] = temp;
	}

	void constroi( int tamanho )
	{
		for ( int i = tamanho; (i > 1) && ( (series[i].getFormato().trim().compareTo(series[i/2].getFormato().trim() ) > 0 ) || 
			( (series[i].getFormato().trim().compareTo(series[i/2].getFormato().trim() ) == 0 ) && 
			(series[i].getNome().compareTo(series[i/2].getNome() ) > 0 ) ) ); i /= 2 )
		{
			swap(i,i/2);
		}
	}

	void reconstroiHeap( int tamanho )
	{
		int i = 1, filho;

		while ( i <= (tamanho/2) )
		{
			if (((series[2*i].getFormato().trim().compareTo(series[2*i+1].getFormato().trim() ) > 0 ) ||
			( (series[2*i].getFormato().trim().compareTo(series[2*i+1].getFormato().trim() ) == 0 ) && 
			( series[2*i].getNome().compareTo(series[2*i+1].getNome() ) ) > 0 )  ) || (2*i == tamanho ))
			{
				filho = 2*i;
			}
			else
			{
				filho = 2*i+1;
			}

			if ( ( series[i].getFormato().trim().compareTo(series[filho].getFormato().trim() ) < 0 ) ||
			 ( (series[i].getFormato().trim().compareTo(series[filho].getFormato().trim() ) == 0 ) && 
			 ( series[i].getNome().compareTo(series[filho].getNome() ) < 0 ) ) )
			{
				swap(i, filho);
				i = filho;
			}
			else
			{
				i = tamanho;
			}
		}
	}

	/**
    * Insere um elemento na primeira posicao da lista e move os demais
    * elementos para o fim da lista.
    * @param objeto Series
    * @throws Exception Se a lista estiver cheia.
    */
	void inserirInicio( Series objeto ) throws Exception
	{
		if ( n < series.length )
		{
			for ( int i = n; i > 0; i--)
			{
				series[i] = series[i-1].retornarClone();
			}

			series[0] = objeto.retornarClone();

			n++;
		}
	}

	/**
    * Insere um elemento na ultima posicao da lista.
    * @param objeto Series
    * @throws Exception Se a lista estiver cheia.
    */
	void inserirFim( Series objeto ) throws Exception
	{
		if ( n < series.length )
		{
			series[n] = objeto.retornarClone();

			n++;
		}
	}

	/**
    * Insere um elemento em uma posicao especifica e move os demais
    * elementos para o fim da lista.
    * @param objeto Series elemento a ser inserido.
    * @param int pos Posicao de insercao.
    * @throws Exception Se a lista estiver cheia ou a posicao invalida.
    */
    void inserir( Series objeto, int pos ) throws Exception
    {
    	if ( n < series.length && pos > 0 && pos < n )
    	{
    		for ( int i = n; i > pos; i-- )
    		{
    			series[i] = series[i-1].retornarClone();
    		}
    	}

    	series[pos] = objeto.retornarClone();

    	n++;
    }

    /**
    * Remove um elemento da primeira posicao da lista e movimenta 
    * os demais elementos para o inicio da mesma.
    * @return resposta Series elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
    Series removerInicio() throws Exception
    {
    	Series resposta = series[0];

    	if ( n > 0 )
    	{
    		resposta = series[0].retornarClone();

    		for( int i = 0; i < n; i++ )
    		{
    			series[i] = series[i+1].retornarClone();
    		}

    		n--;
    	}


    	return resposta;
    }

    /**
    * Remove um elemento da ultima posicao da lista.
    * @return resposta Series elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
    Series removerFim() throws Exception
    {
    	Series resposta = series[n];

    	if ( n > 0 )
    	{
    		resposta = series[--n].retornarClone();
    	}

    	return resposta;
    }

    /**
    * Remove um elemento de uma posicao especifica da lista e 
    * movimenta os demais elementos para o inicio da mesma.
    * @param pos Posicao de remocao.
    * @return resposta Series elemento a ser removido.
    * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
    */
    Series remover( int pos ) throws Exception
    {
    	Series resposta = series[0];

    	if ( n > 0 && pos > 0 && pos < n )
    	{
    		resposta = series[pos].retornarClone();

    		n--;

    		for ( int i = pos; i < n; i++ )
    		{
    			series[i] = series[i+1].retornarClone();
    		}
    	}

    	return resposta;
    }

    //Metodo para mostrar
    void mostrar()
    {
    	for ( int i = 0; i < n; i++ )
    	{
    		series[i].imprimir();
    		
    	}
    }
}