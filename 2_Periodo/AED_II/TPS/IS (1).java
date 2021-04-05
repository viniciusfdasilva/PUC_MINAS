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
     * Metodo publico para retornar o valor retornado
     * no método recursivo
     * @param String que irá ser comparada para veri
     * ficar se é uma Vogal
     * @return boolean
     */
	public static boolean isVogal(String str){
		return isVogal(str,0,false);
	}// End isVogal()

	/*
     * Metodo publico recursivo que ira verificar
     * se a String é uma vogal
     * @param String que irá ser comparada para veri
     * ficar se é uma Vogal
     * @return boolean seja uma vogal
     */
	public static boolean isVogal(String str,int i,boolean resp){
		if(i <= str.length()-1){
			if(((int)str.charAt(i) == 65) || ((int)str.charAt(i) == 69) || ((int)str.charAt(i) == 73) || ((int)str.charAt(i) == 79) || ((int)str.charAt(i) == 85) || ((int)str.charAt(i) == 97) || ((int)str.charAt(i) == 101) || ((int)str.charAt(i) == 105) || ((int)str.charAt(i) == 111) || ((int)str.charAt(i) == 117)){ 
				resp = true;
				resp = isVogal(str,i+1,resp);
			}// End if
			else{
				return false;
			}// End else 
		}// End for
		return resp;
	}// End isVogal()

	/*
     * Metodo publico para retornar o valor retornado
     * no método recursivo
     * @param String que irá ser comparada para veri
     * ficar se é uma consoante
     * @return boolean 
     */
	public static boolean isConsoante(String str){
		return isConsoante(str,0,false);
	}// End isConsoante()

	/*
     * Metodo publico recursivo que ira verificar
     * se a String é uma consoante
     * @param String que irá ser comparada para veri
     * ficar se é uma consoante
     * @return boolean seja uma consoante
     */
	public static boolean isConsoante(String str,int i,boolean resp){
		if(i <= str.length()-1){
			if((((int)str.charAt(i) >= 65 && (int)str.charAt(i) <= 122) && (int)str.charAt(i) != 65) && ((int)str.charAt(i) != 69) && ((int)str.charAt(i) != 73) && ((int)str.charAt(i) != 79) && ((int)str.charAt(i) != 85) && ((int)str.charAt(i) != 97) && ((int)str.charAt(i) != 101) && ((int)str.charAt(i) != 105) && ((int)str.charAt(i) != 111) && ((int)str.charAt(i) != 117)){ 
				resp = true;
				resp = isConsoante(str,i+1,resp);
			}// End if
			else{
				return false;
			}// End else 
		}// End for
		return resp;
	}// End isConsoante()

	/*
     * Metodo publico para retornar o valor retornado
     * no método recursivo
     * @param String que irá ser comparada para veri
     * ficar se é um inteiro
     * @return boolean      
     */
	public static boolean isInteiro(String str){
		return isInteiro(str,0,false);
	}// End isInteiro()

	/*
     * Metodo publico recursivo que ira verificar
     * se a String é um inteiro
     * @param String que irá ser comparada para veri
     * ficar se é um inteiro
     * @return boolean seja um inteiro
     */
	public static boolean isInteiro(String str,int i,boolean resp){
		if(i <= str.length()-1){
			if(str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' || str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' || str.charAt(i) == '7' || str.charAt(i) == '8' || str.charAt(i) == '9'){ 
				resp = true;
				resp = isInteiro(str,i+1,resp);
			}// End if
			else{
				return false;
			}// End else 
		}// End for
		return resp;
	}// End isInteiro()

	/*
     * Metodo publico para retornar o valor retornado
     * no método recursivo
     * @param String que irá ser comparada para veri
     * ficar se é um decimal
     * @return boolean      
     */
	public static boolean isDecimal(String str){
		return isDecimal(str,0,0,false);
	}// End boolean isDecimal()

	/*
     * Metodo publico recursivo que ira verificar
     * se a String é um decimal
     * @param String que irá ser comparada para veri
     * ficar se é um decimal
     * @return boolean seja um decimal
     */
	public static boolean isDecimal(String str,int i,int cont,boolean resp){
		if(i <= str.length()-1){
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
			resp = isDecimal(str,i+1,cont,resp);
		}// End if
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