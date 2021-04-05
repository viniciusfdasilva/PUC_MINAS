import java.net.URL;
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
/**
 * Html
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
public class Html{
	  public static void main(String[] args) throws Exception{
	   	MyIO.setCharset("UTF-8");
	   	URL url = null;
		  String str_nome;
		  String str_endereço;
		
		  for(str_nome = MyIO.readLine(); !igual(str_nome); str_nome = MyIO.readLine()){
        		File file = new File("page.txt");
		  	str_endereço = MyIO.readLine();	
    	   try {
            url = new URL(str_endereço);
        	  new LoadPage().getPage(url,file);
          }catch (MalformedURLException e) {
          	e.printStackTrace();
          }catch (Exception e) {
         	   e.printStackTrace();
          }// End catch
    	   contador(file,str_nome);
      }// End for
  }// End main()

     /*
     * Metodo publico que conta o numero de
     * vogais,consoantes, padrões <br> e <table>
     * @param File,String
     * @return void
     */
    public static void contador(File file,String str_nome) throws IOException{
      	int[] vet = new int[28];
    	BufferedReader lerArq = new BufferedReader(new FileReader(file));
    	String str = null;
    	for(str = lerArq.readLine(); str != null; str = lerArq.readLine()){
        	for(int i = 0; i < str.length(); i++){
        		switch(str.charAt(i)){
    				case '<':
  					if(isBr(str,i)){
  						vet[0]++;  
  				  		i += 4;
  					}// End if
  					else if(isTable(str,i)){
  						vet[1]++;
                		i += 6;
              		}// End else if
           		break;
           		case 'a':
            	  vet[2]++;
            	  break;
            	case 'á':
            	  vet[3]++;
            	  break;
            case 'à':
              vet[4]++;
              break;
            case 'ã':
              vet[5]++;
              break;  
            case 'â':
              vet[6]++;
              break;              
            case 'e':
              vet[7]++;
              break;
            case 'é':
              vet[8]++;
              break;
            case 'è':
              vet[9]++;
              break;
            case 'ẽ':
              vet[10]++;
              break;
            case 'ê':
              vet[11]++;
              break;              
            case 'i':
              vet[12]++;
            break;            
            case 'í':
              vet[13]++;
              break;
            case 'ì':
              vet[14]++;
              break;
            case 'ĩ':
              vet[15]++;
              break;
            case 'î':
              vet[16]++;
              break;
            case 'o':
              vet[17]++;
            break;            
            case 'ó':
              vet[18]++;
              break;
            case 'ò':
              vet[19]++;
              break;
            case 'õ':
              vet[20]++;
            break;
            case 'ô':
              vet[21]++;
              break;
            case 'u':
              vet[22]++;
              break;
            case 'ú':
              vet[23]++;
              break;
            case 'ù':
              vet[24]++;
              break;
            case 'ũ':
              vet[25]++;
              break;
            case 'û':
              vet[26]++;
              break;
            default :
              if(str.charAt(i) == 'b' || str.charAt(i) == 'c' || str.charAt(i) == 'd' 
                || str.charAt(i) == 'f' || str.charAt(i) == 'g' || str.charAt(i) == 'h' 
                || str.charAt(i) == 'j' || str.charAt(i) == 'k' || str.charAt(i) == 'l' 
                || str.charAt(i) == 'm' || str.charAt(i) == 'n' || str.charAt(i) == 'p' 
                || str.charAt(i) == 'q' || str.charAt(i) == 'r' || str.charAt(i) == 's' 
                || str.charAt(i) == 't' || str.charAt(i) == 'v' || str.charAt(i) == 'w' 
                || str.charAt(i) == 'x' || str.charAt(i) == 'y' || str.charAt(i) == 'z'){
                 vet[27]++;
              }// End if
              break;
          }// End switch()
        }// End for
      }// End for
      lerArq.close();
      printValues(vet,str_nome);
    }// End contador()

     /*
     * Metodo publico que compara a String para saber
     * se ela e padrão <table>
     * @param String,int
     * @return boolean
     */
    public static boolean isTable(String str,int i){
      boolean resp = false;
      if(str.charAt(i+1) == 't' && str.charAt(i+2) == 'a' 
        && str.charAt(i+3) == 'b' && str.charAt(i+4) == 'l' 
        && str.charAt(i+5) == 'e' && str.charAt(i+6) == '>'){
        resp = true;
      }// End if
      return resp;
    }//End isTable()

    /*
     * Metodo publico que compara a String para saber
     * se ela e padrão <br>
     * @param String,int
     * @return boolean
     */
    public static boolean isBr(String str, int i){
    boolean resp = false;
    if(str.charAt(i+1) == 'b' && str.charAt(i+2) == 'r' && str.charAt(i+3) == '>'){
        resp = true;
      }// End if
      return resp;
    }// End isBr()

    /*
     * Metodo publico que escreve os contadores
     * @param int,String
     * @return void
     */
    public static void printValues(int[] vet, String str_nome){
      MyIO.println("a(" + vet[2] +") e(" + vet[7] + ") i(" + vet[12] 
                        + ") o(" + vet[17] + ") u(" + vet[22] 
                        + ") á(" + vet[3] + ") é(" + vet[8] 
                        + ") í(" + vet[13] + ") ó(" + vet[18] 
                        + ") ú(" + vet[23] + ") à(" + vet[4] 
                        + ") è(" + vet[9] + ") ì(" + vet[14] 
                        + ") ò(" + vet[19] + ") ù(" + vet[24] 
                        + ") ã(" + vet[5] + ") õ(" + vet[20] 
                        + ") â(" + vet[6] + ") ê(" + vet[11] 
                        + ") î(" + vet[16] + ") ô(" + vet[21] 
                        + ") û(" + vet[26] + ") consoante(" + vet[27] 
                        + ") <br>(" + vet[0] + ") <table>(" + vet[1] 
                        + ") " + str_nome);
    }//End printValues()

    /*
     * Metodo publico iterativo para comparar a String
     * recebida como parametro com a String "FIM"
     * @param String com a palavra que seja comparada
     * @return boolean caso o parametro seja igual a
     * String "FIM",
     */
	  public static boolean igual(String str){
		  boolean resp = false;
		  if(str.length() != 3){
	 	   return resp;
		  }// End if
		  if(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){
		    resp = true;
		  }// End if
		  return resp;	
	 }// End igual()
}// End class Http
  
/*
 * LoadPage
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
	class LoadPage{
      /*
     * Metodo publico que pega a página html e salva
     * em um arquivo do tipo file
     * @param Url e File 
     * @return void
     */
    	public void getPage(URL url, File file) throws IOException {
    	    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    	    BufferedWriter out = new BufferedWriter(new FileWriter(file));
    	    String inputLine;
    	    while((inputLine = in.readLine()) != null) {
    	        out.write(inputLine);
    	        out.newLine();
    	    }// End while
    	    in.close();
    	    out.flush();
    	    out.close();
    	}// End getPage()
	}// End class LoadPage 
