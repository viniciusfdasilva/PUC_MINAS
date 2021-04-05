import java.util.Random;
import java.lang.StringBuilder;
/**
 * Aleatoria
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
public class Aleatoria{
	public static void main(String[] args){
		Random random = new Random();
		random.setSeed(4);	
		String str;
		for(str = MyIO.readLine(); !igual(str); str = MyIO.readLine()){
			MyIO.println(random(str,random));
		}// End for
	}// End main()
	
	/*
     * Metodo publico iterativo para sortear dois caracteres
     * e trocar o primeiro sorteado pelo segundo dentro da
     * String recebida por parametro.
     * @param String com a palavra que será alterada por
     * caracteres randomicos.
     * @return String com os caracteres trocados,
     */
	public static String random(String str, Random random){
		StringBuilder stringbuilder = new StringBuilder(str);
		char a = (char)('a' + (Math.abs(random.nextInt()) % 26));
		char b = (char)('a' + (Math.abs(random.nextInt()) % 26));
		//random.setSeed(4);
		for(int i = 0; i <= str.length()-1;i++){
			//MyIO.println(a + " " + b);
			if((a >= 'a' && a <= 'z') && (b >= 'a' && b <= 'z')){
				if(str.charAt(i) == a){
					stringbuilder.setCharAt(i,b);
				}// End if
			}// End if
		}// End for
		return stringbuilder.toString();
	}// End random

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
}// End class Aleatoria
