/**
 * IS
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
public class IS{
	public static void main(String[] args){
		String str;
		for(str = MyIO.readLine(); !igual(str); str = MyIO.readLine()){
				if(isVogal(str)){
					MyIO.print("SIM ");
				}// End if
				else{
					MyIO.print("NAO ");
				}// End else
				if(isConsoante(str)){
					MyIO.print("SIM ");
				}// End if
				else{
					MyIO.print("NAO ");
				}// End else
				if(isInteiro(str)){
					MyIO.print("SIM ");
				}// End if
				else{
					MyIO.print("NAO ");
				}// End else
				if(isDecimal(str)){
					MyIO.println("SIM");
				}// End if
				else{
					MyIO.println("NAO");
				}// End else
		}// End for			
	}// End main()
	
	/*
     * Metodo publico iterativo que ira verificar
     * se a String é uma vogal
     * @param String que irá ser comparada para veri
     * ficar se é uma Vogal
     * @return boolean seja uma vogal
     */
	public static boolean isVogal(String str){
		boolean resp = false;
		for(int i = 0; i <= str.length()-1; i++){
			if(((int)str.charAt(i) == 65) || ((int)str.charAt(i) == 69) || ((int)str.charAt(i) == 73) || ((int)str.charAt(i) == 79) || ((int)str.charAt(i) == 85) || ((int)str.charAt(i) == 97) || ((int)str.charAt(i) == 101) || ((int)str.charAt(i) == 105) || ((int)str.charAt(i) == 111) || ((int)str.charAt(i) == 117)){ 
				resp = true;
			}// End if
			else{
				return false;
			}// End else 
		}// End for
		return resp;
	}// End isVogal()

	/*
     * Metodo publico iterativo que ira verificar
     * se a String é uma consoante
     * @param String que irá ser comparada para veri
     * ficar se é uma consoante
     * @return boolean seja uma consoante
     */
	public static boolean isConsoante(String str){
		boolean resp = false;
		for(int i = 0; i <= str.length()-1; i++){
			if((((int)str.charAt(i) >= 65 && (int)str.charAt(i) <= 122) && (int)str.charAt(i) != 65) && ((int)str.charAt(i) != 69) && ((int)str.charAt(i) != 73) && ((int)str.charAt(i) != 79) && ((int)str.charAt(i) != 85) && ((int)str.charAt(i) != 97) && ((int)str.charAt(i) != 101) && ((int)str.charAt(i) != 105) && ((int)str.charAt(i) != 111) && ((int)str.charAt(i) != 117)){ 
				resp = true;
			}// End if
			else{
				return false;
			}// End else 
		}// End for
		return resp;
	}// End isConsoante()

	/*
     * Metodo publico iterativo que ira verificar
     * se a String é um inteiro
     * @param String que irá ser comparada para veri
     * ficar se é um inteiro
     * @return boolean seja um inteiro
     */
	public static boolean isInteiro(String str){
		boolean resp = false;
		for(int i = 0; i <= str.length()-1; i++){
			if(str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' || str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' || str.charAt(i) == '7' || str.charAt(i) == '8' || str.charAt(i) == '9'){ 
				resp = true;
			}// End if
			else{
				return false;
			}// End else 
		}// End for
		return resp;
	}// End isInteiro()

	/*
     * Metodo publico iterativo que ira verificar
     * se a String é um decimal
     * @param String que irá ser comparada para veri
     * ficar se é um decimal
     * @return boolean seja um decimal
     */
	public static boolean isDecimal(String str){
		boolean resp = false;
		int cont = 0;
		for(int i = 0; i <= str.length()-1; i++){
			if(str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' || str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' || str.charAt(i) == '7' || str.charAt(i) == '8' || str.charAt(i) == '9' || str.charAt(i) == ',' || str.charAt(i) == '.'){ 
				resp = true;
			}// End if
			else{
				return false;
			}// End else
			if(str.charAt(i) == ',' || str.charAt(i) == '.'){
				cont++;
			}// End if
			if(cont >= 2){
				return false;
			}// End if
		}// End for
		return resp;
	}// End isDecimal()

	/*
     * Metodo publico iterativo para comparar a String
     * recebida como parametro com a String "FIM"
     * @param String com a palavra que seja comparada
     * @return boolean caso o parametro seja igual a
     * String "FIM"
     */
	public static boolean igual(String str){
		boolean resp = false;
		if(str.length() == 3){
			if(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){
				resp = true;
			}// End if
			else{
				resp = false;
			}// End else
		}// End if
		else{
			return false;
		}// End else
		return resp;
	}// End igual
}// End class IS