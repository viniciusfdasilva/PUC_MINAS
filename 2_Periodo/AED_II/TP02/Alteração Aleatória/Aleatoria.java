/**
 * Aleatoria
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
import java.util.Random;
import java.lang.StringBuilder;
public class Aleatoria{
	public static void main(String[] args){
		String str;
		Random random = new Random();
		random.setSeed(4);	
		for(str = MyIO.readLine(); !igual(str); str = MyIO.readLine()){
			MyIO.println(random(str,random));
		}// End for
	}// End main()
	
	/*
     * Metodo publico para retornar a String retornarda
     * na função recursiva
     * @param String com a palavra que será alterada por
     * caracteres randomicos e o ponteiro random.
     * @return String com os caracteres trocados,
     */
	public static String random(String str,Random random){
		return random(str,random,0,' ',' ');
	}// End random()

	/*
     * Metodo publico recursivo para sortear dois caracteres
     * e trocar o primeiro sorteado pelo segundo dentro da
     * String recebida por parametro.
     * @param String com a palavra que será alterada por
     * caracteres randomicos.
     * @return String com os caracteres trocados,
     */
	public static String random(String str,Random random,int i,char a, char b){
		StringBuilder stringbuilder = new StringBuilder(str);
		if(i == 0){
			a = (char)('a' + (Math.abs(random.nextInt()) % 26));
			b = (char)('a' + (Math.abs(random.nextInt()) % 26));
		}// End if
		if(i <= str.length()-1){
			if((a >= 'a' && a <= 'z') && (b >= 'a' && b <= 'z')){
				if(str.charAt(i) == a){
					stringbuilder.setCharAt(i,b);
					str = stringbuilder.toString();
				}// End if
			}// End if
				str = random(str,random,i+1,a,b);
		}// End if
		return str;
	}// End random

	/*
     * Metodo publico para comparar a String
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
}// End class Aleatoria