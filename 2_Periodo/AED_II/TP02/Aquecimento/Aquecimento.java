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
     * Metodo publico para retornar o valor do metodo recursivo
     * @param String
     * @return int com a quantidade de maiusculos da String,
     */
	public static int contaMaiusculo(String str){
		return contaMaiusculo(str,0,0);
	}// End contaMaiusculo

	/*
     * Metodo publico recursivo para contar a quantidade
     * de caracteres maiusculos presentes em uma String
     * @param String
     * @return int com a quantidade de maiusculos da String,
     */
	public static int contaMaiusculo(String str,int i,int cont){
		if(i <= str.length()-1){
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				cont++;
				cont = contaMaiusculo(str,i+1,cont);
			}// End if
			else{
				cont = contaMaiusculo(str,i+1,cont);
			}// End if
		}// End if
		return cont;
	}// End contaMaiusculo()
	
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
}// End class Aquecimento