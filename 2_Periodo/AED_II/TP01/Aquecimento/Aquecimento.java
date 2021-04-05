/**
 * Aquecimento
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
public class Aquecimento{
	public static void main(String[] args){
		String str;
		for(str = MyIO.readLine(); !igual(str); str = MyIO.readLine()){
			MyIO.println(contaMaiusculo(str));
		}// End for
	}// End main()
	/*
     * Metodo publico iterativo para contar a quantidade
     * de caracteres maiusculos presentes em uma String
     * @param String
     * @return int com a quantidade de maiusculos da String,
     */
	public static int contaMaiusculo(String str){
		int cont = 0;
		for(int i = 0; i <= str.length()-1; i++){
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				cont++;
			}// End if
		}// End for
		return cont;
	}// End contaMaiusculo()
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
}// End class Aquecimento