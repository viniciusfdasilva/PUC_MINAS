/**
 * Palindromo
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
public class Palindromo{
	public static void main(String[] args){
		String str;
		for(str = MyIO.readLine(); !igual(str); str = MyIO.readLine()){
			if(ehPalindromo(str)){
				MyIO.println("SIM");
			}// End if
			else{
				MyIO.println("NAO");
			}// End else
		}// End for
	}// End main()

	/*
     * Metodo publico iterativo para comparar a String
     * e retornar se ela é um palindromo ou não
     * @param String com a palavra que seja comparada
     * para descobrir se é ou não um palindromo
     * @return boolean identificando se é um palindromo
     * ou não
     */
	public static boolean ehPalindromo(String str){
		int i = 0;
		int j = str.length()-1;
		boolean resp = false;
		while(i < j && j > i){
			if(str.charAt(i) == str.charAt(j)){
				resp = true;
			}// End if
			else{
				return false;
			}// End else
			i++;
			j--;
		}// End while
		return resp;
	}// End ehPalindromo()
	
	/*
     * Metodo publico iterativo para comparar a String
     * recebida como parametro com a String "FIM"
     * @param String com a palavra que seja comparada
     * @return boolean caso o parametro seja igual a
     * String "FIM"
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
}// End class Palindromo