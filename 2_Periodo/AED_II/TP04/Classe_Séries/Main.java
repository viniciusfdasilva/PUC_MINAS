class Serie{
	private String nome;
	private String formato;
	private	String pais_origem;
	private String idioma_original;
	private String emissora;
	private String transmissao;
	private int numero_temporadas;
	private int numero_episodios;

	public Serie(String nome,String formato,String pais_origem,String idioma_original,String emissora,String transmissao,int numero_temporadas,int numero_episodios){
		setNome(nome);
		setFormato(formato);
		setPaisOrigem(pais_origem);
		setIdiomaOriginal(idioma_original);
		setEmissora(emissora);
		setTransmissao(transmissao);
		setNumeroTemporadas(numero_temporadas);
		setNumeroEpisodios(numero_episodios);
	}// End Serie()

	public Serie(){
		setNome(" ");
		setFormato(" ");
		setPaisOrigem(" ");
		setIdiomaOriginal(" ");
		setEmissora(emissora);
		setTransmissao(" ");
		setNumeroTemporadas(0);
		setNumeroEpisodios(0);		
	}// End Serie()

	public void setNome(String nome){
		this.nome = nome;
	}// End setNome()

	public String getNome(){
		return this.nome;
	}// End getNome()

	public void setFormato(String formato){
		this.formato = formato;
	}// End setFormato()

	public String getFormato(){
		return this.formato;
	}// End getFormato()

	public void setPaisOrigem(String pais_origem){
		this.pais_origem = pais_origem;
	}// End setPaisOrigem()

	public String getPaisOrigem(){
		return this.pais_origem;
	}// End getPaisOrigem()

	public void setIdiomaOriginal(String idioma_original){
		this.idioma_original = idioma_original;
	}// End setIdiomaOriginal()

	public String getIdiomaOriginal(){
		return this.idioma_original;
	}// End getIdiomaOriginal()

	public void setEmissora(String emissora){
		this.emissora = emissora;
	}// End setEmissora()

	public String getEmissora(){
		return this.emissora;
	}// End getemissora()

	public void setTransmissao(String transmissao){
		this.transmissao = transmissao;
	}// End setTransmissao()

	public String getTransmissao(){
		return this.transmissao;
	}// End getTransmissao()

	public void setNumeroTemporadas(int numero_temporadas){
		this.numero_temporadas = numero_temporadas;
	}// End setNumeroTemporadas() 

	public int getNumeroTemporadas(){
		return this.numero_temporadas;
	}// End getNumeroTemporadas() 

	public void setNumeroEpisodios(int numero_temporadas){
		this.numero_episodios = numero_episodios;
	}// End setNumeroEpisodios() 

	public int getNumeroEpisodios(){
		return this.numero_episodios;
	}// End getNumeroTemporadas() 

	public void imprimir(){
		MyIO.println(getNome() + " " + getFormato() + " " + getPaisOrigem() + " " + getIdiomaOriginal() + " " + getEmissora() + " " + getTransmissao() + " " + getNumeroTemporadas() + " " + getNumeroEpisodios());
	}// End imprimir()

	public Serie clone(){
		return new Serie(getNome(),getFormato(),getPaisOrigem(),getIdiomaOriginal(),getEmissora(),getTransmissao(),getNumeroTemporadas(),getNumeroEpisodios());
	}// End clone()

	public void ler(String serie){
		String str;
		int j = 0;
		String diretorio = "/tmp/";
		String endereco = diretorio.concat(serie);
		MyIO.println(endereco);
	/*
		Arq.openWrite(endereco);
		while(arq.hasNext() && str == null){
			str = Arq.readLine();
			if(str.contains("Nome")){
				str = Arq.readLine();
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '>' && srt.charAt(i+1) >= "A" && srt.charAt(i+1) <= 'Z' || srt.charAt(i+1) >= "a" && srt.charAt(i+1) <= 'z'){
						j = j;
						while(str.charAt(i) != '>'){
							j++;
						}// End while
						setNome(str.subString(i+1,j));
					}// End if
				}// End for
			}// End if
			if(str.contains("Formato")){
				str = Arq.readLine();
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '>' && srt.charAt(i+1) >= "A" && srt.charAt(i+1) <= 'Z' || srt.charAt(i+1) >= "a" && srt.charAt(i+1) <= 'z'){
						j = j;
						while(str.charAt(i) != '>'){
							j++;
						}// End while
						setFormato(str.subString(i+1,j));
					}// End if
				}// End for
			}// End if
			if(str.contains("País de origem")){
				str = Arq.readLine();
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '>' && srt.charAt(i+1) >= "A" && srt.charAt(i+1) <= 'Z' || srt.charAt(i+1) >= "a" && srt.charAt(i+1) <= 'z'){
						j = j;
						while(str.charAt(i) != '>'){
							j++;
						}// End while
						setFormato(str.subString(i+1,j));
					}// End if
				}// End for
			}// End if
			if(str.contains("Idioma original")){
				str = Arq.readLine();
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '>' && srt.charAt(i+1) >= "A" && srt.charAt(i+1) <= 'Z' || srt.charAt(i+1) >= "a" && srt.charAt(i+1) <= 'z'){
						j = j;
						while(str.charAt(i) != '>'){
							j++;
						}// End while
						setFormato(str.subString(i+1,j));
					}// End if
				}// End for
			}// End if
			if(str.contains("Emissora de televisão original")){
				str = Arq.readLine();
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '>' && srt.charAt(i+1) >= "A" && srt.charAt(i+1) <= 'Z' || srt.charAt(i+1) >= "a" && srt.charAt(i+1) <= 'z'){
						j = j;
						while(str.charAt(i) != '>'){
							j++;
						}// End while
						setFormato(str.subString(i+1,j));
					}// End if
				}// End for
			}// End if
			if(str.contains("Transmissão original")){
				str = Arq.readLine();
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '>' && srt.charAt(i+1) >= "A" && srt.charAt(i+1) <= 'Z' || srt.charAt(i+1) >= "a" && srt.charAt(i+1) <= 'z'){
						j = j;
						while(str.charAt(i) != '>'){
							j++;
						}// End while
						setFormato(str.subString(i+1,j));
					}// End if
				}// End for
			}// End if
			if(str.contains("N.º de temporadas")){
				str = Arq.readLine();
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '>' && srt.charAt(i+1) >= "A" && srt.charAt(i+1) <= 'Z' || srt.charAt(i+1) >= "a" && srt.charAt(i+1) <= 'z'){
						j = j;
						while(str.charAt(i) != '>'){
							j++;
						}// End while
						setFormato(Integer.parseInt(str.subString(i+1,j)));
					}// End if
				}// End for
			}// End if
			if(str.contains("N.º de episódios")){
				str = Arq.readLine();
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '>' && srt.charAt(i+1) >= "A" && srt.charAt(i+1) <= 'Z' || srt.charAt(i+1) >= "a" && srt.charAt(i+1) <= 'z'){
						j = j;
						while(str.charAt(i) != '>'){
							j++;
						}// End while
						setFormato(Integer.parseInt(str.subString(i+1,j)));
					}// End if
				}// End for
			}// End if
		}// End while
	*/
	}// End ler()
}// End class Serie

public class Tp4{
	public static void main(String[] args){
		MyIO.setCharset("UTF-8");
		//Serie[] serie = new Serie[100];
		int i = 0;
		//for(str = MyIO.readLine();str.equals("FIM");str = MyIO.readLine()){
			str = MyIO.readLine();
			Serie serie = new Serie();
			serie.ler(str);
			//serie[i].imprimir();
			//i++;
		}// End for
	}// End main()
}// End class Main()





























