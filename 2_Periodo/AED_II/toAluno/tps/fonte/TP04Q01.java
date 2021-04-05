

public class TP04Q01 {

    public static void main(String args[]) throws CloneNotSupportedException {
        //MyIO.setCharset("ISO-8859-1");
        for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo = MyIO.readLine()){
            Serie serie = new Serie();
            serie = serie.readFile("/tmp/" + nomeArquivo);
            serie.Imprimir();
        }
    }
}
