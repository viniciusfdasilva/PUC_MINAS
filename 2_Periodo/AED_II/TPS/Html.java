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
        	    new LoadPage().getPage(url, file);
        	} catch (MalformedURLException e) {
        	    e.printStackTrace();
        	} catch (Exception e) {
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
    	int cont_a = 0;
    	int cont_á = 0;
		  int cont_à = 0;    	
		  int cont_ã = 0;
		  int cont_â = 0;

    	int cont_e = 0;
    	int cont_é = 0;
    	int cont_è = 0;
    	int cont_ẽ = 0;
    	int cont_ê = 0;
    	
    	int cont_i = 0;
    	int cont_í = 0;
    	int cont_ì = 0;
    	int cont_ĩ = 0;
    	int cont_î = 0;
    	
    	int cont_o = 0;
    	int cont_ó = 0;
    	int cont_ò = 0;
    	int cont_õ = 0;
    	int cont_ô = 0;

    	int cont_u = 0;
    	int cont_ú = 0;
    	int cont_ù = 0;
    	int cont_ũ = 0;
    	int cont_û = 0;
    	
    	int cont_consoante = 0;
    	int cont_table = 0;
    	int cont_br = 0;

    	BufferedReader lerArq = new BufferedReader(new FileReader(file));
    	String str = null;
    	for(str = lerArq.readLine(); str != null; str = lerArq.readLine()){
        for(int i = 0; i < str.length(); i++){
          switch(str.charAt(i)){
    				case '<':
  						if(isBr(str,i)){
  							cont_br += 1;  
  							i += 4;
  						}// End if
  						else if(isTable(str,i)){
  							cont_table += 1;
  							i += 6;
  						}// End else if
  						break;
    				case 'a':
    					cont_a += 1;
    					break;
    				case 'á':
    					cont_á += 1;
    					break;
    				case 'à':
    					cont_à += 1;
    					break;
   		 			case 'ã':
    					cont_ã += 1;
    					break;	
 	  	 			case 'â':
    					cont_â += 1;
    					break;	   					
    				case 'e':
    					cont_e += 1;
    					break;
    				case 'é':
    					cont_é += 1;
    					break;
   		 			case 'è':
    					cont_è += 1;
    					break;
    				case 'ẽ':
    					cont_ẽ += 1;
    					break;
    				case 'ê':
    					cont_ê += 1;
    					break;    					
    				case 'i':
    					cont_i += 1;
						break;    				
    				case 'í':
    					cont_í += 1;
    					break;
    				case 'ì':
    					cont_ì += 1;
    					break;
   	 				case 'ĩ':
   	 					cont_ĩ += 1;
   	 					break;
   	 				case 'î':
   	 					cont_î += 1;
   	 					break;
   	 				case 'o':
   		 				cont_o += 1;
						break;    				
    				case 'ó':
    					cont_ó += 1;
    					break;
   	 				case 'ò':
    					cont_ò += 1;
    					break;
    				case 'õ':
    					cont_õ += 1;
 						break;
    				case 'ô':
    					cont_ô += 1;
    					break;
    				case 'u':
    					cont_u += 1;
    					break;
    				case 'ú':
    					cont_ú += 1;
    					break;
    				case 'ù':
  						cont_ù += 1;
  						break;
  					case 'ũ':
  						cont_ũ += 1;
  						break;
  					case 'û':
  						cont_û += 1;
  						break;
  					default :
  						if(str.charAt(i) == 'b' || str.charAt(i) == 'c' || str.charAt(i) == 'd' || str.charAt(i) == 'f' || str.charAt(i) == 'g' || str.charAt(i) == 'h' || str.charAt(i) == 'j' || str.charAt(i) == 'k' || str.charAt(i) == 'l' || str.charAt(i) == 'm' || str.charAt(i) == 'n' || str.charAt(i) == 'p' || str.charAt(i) == 'q' || str.charAt(i) == 'r' || str.charAt(i) == 's' || str.charAt(i) == 't' || str.charAt(i) == 'v' || str.charAt(i) == 'w' || str.charAt(i) == 'x' || str.charAt(i) == 'y' || str.charAt(i) == 'z'){
							   cont_consoante += 1;
						  }// End if
	    			  break;
	    		}// End switch()
	    	}// End for
    	}// End for
      lerArq.close();
		  printValues(cont_a,cont_á,cont_à,cont_ã,cont_â,cont_e,cont_é,cont_è,cont_ẽ,cont_ê,cont_i,cont_í,cont_ì,cont_ĩ,cont_î,cont_o,cont_ó,cont_ò,cont_õ,cont_ô,cont_u,cont_ú,cont_ù,cont_ũ,cont_û,cont_consoante,cont_table,cont_br,str_nome);
    }// End contador()

     /*
     * Metodo publico que compara a String para saber
     * se ela e padrão <table>
     * @param String,int
     * @return boolean
     */
    public static boolean isTable(String str,int i){
    	boolean resp = false;
    	if(str.charAt(i+1) == 't' && str.charAt(i+2) == 'a' && str.charAt(i+3) == 'b' && str.charAt(i+4) == 'l' && str.charAt(i+5) == 'e' && str.charAt(i+6) == '>'){
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
    public static void printValues(int cont_a,int cont_á,int cont_à,int cont_ã,int cont_â,int cont_e,int cont_é,int cont_è,int cont_ẽ,int cont_ê,int cont_i,int cont_í,int cont_ì,int cont_ĩ,int cont_î,int cont_o,int cont_ó,int cont_ò,int cont_õ,int cont_ô,int cont_u,int cont_ú,int cont_ù,int cont_ũ,int cont_û,int cont_consoante,int cont_table,int cont_br,String str_nome){
    	MyIO.println("a(" + cont_a +") e(" + cont_e + ") i(" + cont_i + ") o(" + cont_o + ") u(" + cont_u + ") á(" + cont_á + ") é(" + cont_é + ") í(" + cont_í + ") ó(" + cont_ó + ") ú(" + cont_ú + ") à(" + cont_à + ") è(" + cont_è + ") ì(" + cont_ì + ") ò(" + cont_ò + ") ù(" + cont_ù + ") ã(" + cont_ã + ") õ(" + cont_õ + ") â(" + cont_â + ") ê(" + cont_ê + ") î(" + cont_î + ") ô(" + cont_ô + ") û(" + cont_û + ") consoante(" + cont_consoante + ") <br>(" + cont_br + ") <table>(" + cont_table + ") " + str_nome);
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