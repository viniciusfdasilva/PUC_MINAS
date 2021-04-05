/**
 * Algebra
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
public class Algebra{
    final static String[] opcoes =
    {" ",
    "not(0)",
    "not(1)",
    "and(0,0)",
    "and(1,1)",
    "and(0,1)",
    "and(1,0)",
    "and(0,0,",
    "and(1,1,",
    "and(0,1,",
    "and(1,0,",
    "or(0,0)",
    "or(1,1)",
    "or(0,1)",
    "or(1,0)",
    "or(0,0,",
    "or(1,1,",
    "or(0,1,",
    "or(1,0,"
    };

    final static String[] opcoes2 =
    {"",
    "1",
    "0",
    "0",
    "1",
    "0",
    "0",
    "and(and(0,0),",
    "and(and(1,1),",
    "and(and(0,1),",
    "and(and(1,0),",
    "0",
    "1",
    "1",
    "1",
    "or(or(0,0),",
    "or(or(1,1),",
    "or(or(0,1),",
    "or(or(1,0),"
    };

  public static void main(String[] args) {
    leAte0();
  }//Fim main

  /**
  * Metodo que controla a condicao de parada do programa(Flag = 0) e tambem chama os demais metodos.
  */
  public static void leAte0(){
    int i = MyIO.readInt();
    if(i == 0){
      return;
    }//Fim if
    else{
      int[] arrayEnt = new int[i];
      int[] qntValores = criaArranjo(i,arrayEnt);
      String expressao = MyIO.readLine();
      String expressao2 = alterLetra(expressao, qntValores);
      MyIO.println(resolve(expressao2));
      leAte0();
    }//Fim else
  }//Fim leAte0

  /*
  * Metodo que cria e retorna um arranjo com o as entradas da expressao booleana.
  * @param int i - numero de entradas(A,B,C etc) que a expressao booleana possui.
  * @return int[] arrayEnt  - O arranjo com as entradas.
  */
  public static int[] criaArranjo(int i, int arrayEnt[]){
    return criaArranjo(i,arrayEnt,0);
  }//Fim criaArranjo

  /*
  * Metodo que cria e retorna um arranjo com o as entradas da expressao booleana.
  * @param int i - numero de entradas(A,B,C etc) que a expressao booleana possui.
  * @param int j - contador.
  * @param int[] arrayEnt - arranjo com que recebera as entradas.
  * @return int[] arrayEnt  - O arranjo com as entradas.
  */
  public static int[] criaArranjo(int i,int arrayEnt[], int j){
    if(j < i){
      arrayEnt[j] = MyIO.readInt();
      criaArranjo(i,arrayEnt,j + 1);
    }//Fim if
    return arrayEnt;
  }//Fim criaArranjo

  public static String alterLetra(String expressao,int qntValores[]){
    return alterLetra(expressao,qntValores,0);
  }//Fim alterLetra

  /**
  * Metodo que substitui as letras(A,B,C...) por 0 ou 1 dependendo da expressao booleana.
  * @param String expressao - expressao booleana.
  * @param int i - contador.
  * @param int[] qntValores - arranjo com o valor booleano das entradas(0 ou 1).
  * @return String r  - expressao booleana com as entradas(A,B,C..) substituidas por seus valores booleanos(0 ou 1).
  */
  public static String alterLetra(String expressao,int qntValores[], int i){
    String r = "";
    if(i >= expressao.length()){
      return r;
    }//Fim if
    else{
      r += auxAlterLetra(expressao,qntValores,i);
      r += alterLetra(expressao,qntValores, i + 1);
    }//Fim for
    return r;
  }//Fim alterLetra

  /**
  * Metodo auxiliar do metodo auxAlterLetra.
  * @param String expressao - expressao booleana.
  * @param int i - variavel auxiliar.
  * @param int[] qntValores - arranjo com o valor booleano das entradas(0 ou 1).
  * @return char letra - Valor da variavel letra.
  */
  public static char auxAlterLetra(String expressao,int qntValores[],int i){
    return auxAlterLetra(expressao,qntValores,i,0);
  }//Fim auxAlterLetra

  /**
  * Metodo auxiliar do metodo auxAlterLetra.
  * @param String expressao - expressao booleana.
  * @param int i - contador.
  * @param int i - variavel auxiliar.
  * @param int[] qntValores - arranjo com o valor booleano das entradas(0 ou 1).
  * @return char letra - Valor da variavel letra.
  */
  public static char auxAlterLetra(String expressao,int qntValores[],int i,int c){
    char letra;
    if(c >= qntValores.length){
      letra = expressao.charAt(i);
    }//Fim if
    else if((char)('A' + c) == expressao.charAt(i)){
      letra = (char)(qntValores[c] + '0');
    }//Fim if
    else{
      letra = auxAlterLetra(expressao,qntValores,i,c + 1);
    }//Fim else
    return letra;
  }//Fim auxAlterLetra

  /**
  * Metodo que resolve e retorna o valor final da expressao booleana(com a ajuda de metodos auxiliares).
  * @param String expressao2 - expressao boolena sem as n primeiras posicoes(que seria a qnt de entradas e seus respectivos valores).
  * @return char expressao2  - Resultado(0 ou 1) da expressao booleana.
  */
  public static char resolve(String expressao2){
    if(expressao2.charAt(0) == '0' || expressao2.charAt(0) == '1'){
      return expressao2.charAt(0);
    }//Fim if
    else{
      expressao2 = auxResolve(expressao2);
    }//Fim else
    return resolve(expressao2);
  }//Fim resolve

  /**
  * Metodo auxiliar do metodo resolve.
  * @param String expressao2 - expressao boolena sem as n primeiras posicoes(que seria a qnt de entradas e seus respectivos valores).
  * @return char expressao2  - Resultado(0 ou 1) da expressao booleana.
  */
  public static String auxResolve(String expressao2){
    return auxResolve(expressao2,0);
  }//Fim auxResolve

  /**
  * Metodo auxiliar do metodo resolve.
  * @param String expressao2 - expressao boolena sem as n primeiras posicoes(que seria a qnt de entradas e seus respectivos valores).
  * @param int i - contador.
  * @return char expressao2  - Resultado(0 ou 1) da expressao booleana.
  */
  public static String auxResolve(String expressao2, int i){
    if(i >= opcoes.length){
      return expressao2;
    }//Fim if
    else{
      expressao2 = replace(expressao2, opcoes[i], opcoes2[i]);
    }//Fim else
    return auxResolve(expressao2,i + 1);
  }//Fim auxResolve

  /**
  * Metodo que substitui a expressao booleana por seu resultado(0 ou 1).
  * @param String frase - expressao boolena a ser analisada e substituida por seu resultado booleano.
  * @param String estouProcu - posicao do arranjo que sera comparada com a String frase,
  * caso haja correpondencia, sera trocada pelo resultado booleano encontrado na String lugar.
  * @param String lugar - possiveis resultados booleanos da String frase que serao colocados na String nova.
  * @return String nova  - String com os valores da variavel String substituidos pelos seus correspondentes na variavel String lugar.
  */
  public static String replace(String frase, String estouProcu, String lugar){
    return replace(frase,estouProcu,lugar,0);
  }//Fim replace

  /**
  * Metodo que substitui a expressao booleana por seu resultado(0 ou 1).
  * @param String frase - expressao boolena a ser analisada e substituida por seu resultado booleano.
  * @param String estouProcu - posicao do arranjo que sera comparada com a String frase,
  * caso haja correpondencia, sera trocada pelo resultado booleano encontrado na String lugar.
  * @param String lugar - possiveis resultados booleanos da String frase que serao colocados na String nova.
  * @param int i - contador.
  * @return String nova  - String com os valores da variavel String substituidos pelos seus correspondentes na variavel String lugar.
  */

  public static String replace(String frase, String estouProcu, String lugar, int i) {
        String nova = "";
        if (i >= frase.length()) {
            nova = "";
        }//Fim if
        else if (saoIguais(frase, estouProcu, i)) {
            nova += lugar;
            i += estouProcu.length() - 1;
            nova += replace(frase, estouProcu, lugar, i + 1);
        }//Fim if
        else {
            nova += frase.charAt(i);
            nova += replace(frase, estouProcu, lugar, i + 1);
        }//Fim else
        return nova;
    }//Fim replace

  /**
  * Metodo que verifica se a String frase possui em sua composicao a String estouProcu.
  * @param int i - indice a ser utilizado no metodo abaixo(varia a cada chamada deste metodo de acordo com o for do metodo replace()).
  * @param String frase - expressao boolena a ser analisada e substituida por seu resultado booleano.
  * @param String estouProcu - posicao do arranjo que sera comparada com a String frase,
  * caso haja correpondencia, sera trocada pelo resultado booleano encontrado na String lugar.
  * @return boolean is  - verdadeiro caso a String frase contenha a String estouProcu e falso caso contrario.
  */

  public static boolean saoIguais(String frase, String estouProcu, int i){
    boolean is = false;
    int j = i;
    if(frase.length() - i >= estouProcu.length() && frase.charAt(i) == estouProcu.charAt(0)){
      j += auxSaoIguais(frase,estouProcu,i,j);
      is = (j - i) >= estouProcu.length();
    }//Fim if
    return is;
  }//Fim saoIguais

  /**
  * Metodo auxiliar do metodo saoIguais();
  * @param int i - indice a ser utilizado no metodo abaixo(varia a cada chamada deste metodo de acordo com o for do metodo replace()).
  * @param int j = variavel que recebe o valor de i.
  * @param String frase - expressao boolena a ser analisada e substituida por seu resultado booleano.
  * @param String estouProcu - posicao do arranjo que sera comparada com a String frase,
  * caso haja correpondencia, sera trocada pelo resultado booleano encontrado na String lugar.
  * @return char c  - valor da variavel c.
  */
  public static int auxSaoIguais(String frase, String estouProcu, int i,int j){
    int c;
    if(!(j < frase.length() && j - i < estouProcu.length() && frase.charAt(j) == estouProcu.charAt(j - i))){
      c = 0;
    }//Fim if
    else {
      c = 1 + auxSaoIguais(frase,estouProcu,i,j + 1);
    }//Fim else
    return c;
  }//Fim auxsaoIguais

}//Fim class
