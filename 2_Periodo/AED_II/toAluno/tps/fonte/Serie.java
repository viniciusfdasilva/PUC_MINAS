import java.io.*;

public class Serie implements Cloneable {

    private String nome;
    private String formato;
    private String duracao;
    private String paisDeOrigem;
    private String idiomaOriginal;
    private String emissoraDeTelevisao;
    private String transmissaoOriginal;
    private int numeroDeTemporadas;
    private int numeroDeEpisodios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(String paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public String getEmissoraDeTelevisão() {
        return emissoraDeTelevisao;
    }

    public void setEmissoraDeTelevisão(String emissoraDeTelevisão) {
        this.emissoraDeTelevisao = emissoraDeTelevisão;
    }

    public String getTransmissaoOriginal() {
        return transmissaoOriginal;
    }

    public void setTransmissaoOriginal(String transmissaoOriginal) {
        this.transmissaoOriginal = transmissaoOriginal;
    }

    public int getNumeroDetemporadas() {
        return numeroDeTemporadas;
    }

    public void setNumeroDetemporadas(int numeroDetemporadas) {
        this.numeroDeTemporadas = numeroDetemporadas;
    }

    public int getNumeroDeEpisodios() {
        return numeroDeEpisodios;
    }

    public void setNumeroDeEpisodios(int numeroDeEpisodios) {
        this.numeroDeEpisodios = numeroDeEpisodios;
    }

    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", formato='" + formato + '\'' +
                ", duracao='" + duracao + '\'' +
                ", paisDeOrigem='" + paisDeOrigem + '\'' +
                ", idiomaOriginal='" + idiomaOriginal + '\'' +
                ", emissoraDeTelevisão='" + emissoraDeTelevisao + '\'' +
                ", transmissaoOriginal='" + transmissaoOriginal + '\'' +
                ", numeroDetemporadas=" + numeroDeTemporadas +
                ", numeroDeEpisodios=" + numeroDeEpisodios +
                '}';
    }

    public void Imprimir() {
        System.out.println(nome + ' ' + formato + ' ' +  duracao + ' ' +
                paisDeOrigem + ' ' + idiomaOriginal + ' ' + emissoraDeTelevisao + ' ' +
                transmissaoOriginal + ' ' +  numeroDeTemporadas + ' ' + numeroDeEpisodios);
    }

    public String getSubstringEntre(String s, char antes, String depois){
        String resp = "";
        int posInicio , posFim;

        posFim = s.indexOf(depois);

        int i = 0;
        for (i = posFim; s.charAt(i) != antes; i--);
        posInicio = i;

        resp = s.substring(posInicio + 1, posFim);

        return resp;
    }

    public String removeTags(String s) {
        String resp = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '&'){
                i +=6;
            }
            if(s.charAt(i)!='<'){
                resp += s.charAt(i);
            }else {
                while (s.charAt(i)!='>') {
                    i++;
                }
            }
        }

        if(resp.charAt(0) == ' ')
            return resp.substring(1, resp.length());
        else
            return resp;
    }

    public String removeUnderline(String s) {
        String resp = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '_'){
                resp += ' ';
            }else {
                resp += s.charAt(i);
            }
        }
        return resp;
    }

    public int converteString2Int(String linha){
        String resp = "";

        int i = 0;
        while( i < linha.length() && (linha.charAt(i) == '0' || linha.charAt(i) == '1' ||
                linha.charAt(i) == '2' ||linha.charAt(i) == '3' ||
                linha.charAt(i) == '4' ||linha.charAt(i) == '5' ||
                linha.charAt(i) == '6' || linha.charAt(i) == '7' ||
                linha.charAt(i) == '8' || linha.charAt(i) == '9')){
                resp += linha.charAt(i);
                i++;
        }

        return Integer.parseInt(resp);
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Serie readFile(String filename) throws CloneNotSupportedException {
        String linha;

        //Abrir o arquivo para leitura
        Arq.openRead(filename, "UTF8");//ISO-8859-1");

        //Definir atributo Nome
        this.nome = removeUnderline(getSubstringEntre(filename, '/', ".html"));

        //Definir atributo Formato
        for(linha = Arq.readLine(); linha.contains("Formato") == false; linha = Arq.readLine());
        linha = Arq.readLine();
        this.formato = getSubstringEntre(linha, '>', "</a>");

        //Definir atributo Duração
        for(linha = Arq.readLine(); linha.contains("Duração") == false; linha = Arq.readLine());
        linha = Arq.readLine();
        this.duracao = removeTags(linha);

        //Definir atributo País de Origem
        for(linha = Arq.readLine(); linha.contains("País de origem") == false; linha = Arq.readLine());
        linha = Arq.readLine();
        this.paisDeOrigem = removeTags(linha);

        //Definir atributo Idioma Original
        for(linha = Arq.readLine(); linha.contains("Idioma original") == false; linha = Arq.readLine());
        linha = Arq.readLine();
        this.idiomaOriginal = removeTags(linha);

        //Definir atributo Emissora de Televisão
        for(linha = Arq.readLine(); linha.contains("Emissora de televisão original") == false; linha = Arq.readLine());
        linha = Arq.readLine();
        this.emissoraDeTelevisao = removeTags(linha);

        //Definir atributo Transmissão Original
        for(linha = Arq.readLine(); linha.contains("Transmissão original") == false; linha = Arq.readLine());
        linha = Arq.readLine();
        this.transmissaoOriginal = removeTags(linha);

        //Definir atributo Número de Temporadas
        for(linha = Arq.readLine(); linha.contains("N.º de temporadas") == false; linha = Arq.readLine());
        linha = Arq.readLine();
        linha = removeTags(linha);
        this.numeroDeTemporadas = converteString2Int(linha);

        //Definir atributo Número de Episódios
        for(linha = Arq.readLine(); linha.contains("N.º de episódios") == false; linha = Arq.readLine());
        linha = Arq.readLine();
        linha = removeTags(linha);
        this.numeroDeEpisodios = converteString2Int(linha);;


        //Fechar o arquivo para a leitura
        Arq.close();

        return (Serie) this.clone();
    }


}
