/**
 * Ciframento
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
class Ciframento{
	public static void main(String[] args){
		String str;
		for(str = MyIO.readLine(); !igual(str);str = MyIO.readLine()){
			MyIO.println(ciframento(str));
		}// End for
	}// End main()
	
	/*
     * Metodo publico iterativo para codificar a String 
     * a partir de um valor constante de chave
     * @param String
     * @return String que foi codificada,
     */
	public static String ciframento(String str){
		int chave = 3;
		String cifra = "";
		for(int i = 0; i <= str.length()-1; i++){
			cifra = cifra + (char)(str.charAt(i)+chave);
		}// End for 
		return cifra;
	}// End ciframento()

	/*
     * Metodo publico iterativo para comparar a String
     * recebida como parametro com a String "FIM"
     * @param String com a palavra que seja comparada
     * @return boolean caso o parametro seja igual a
     * String "FIM",
     */
	public static boolean igual(String str){
		boolean resp = false;
		if(str.length() == 3){
			if(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){
				resp = true;
			}// End if
			else{
				return false;
			}// End else
		}// End if
		else{
			return false;
		}// End esle
		return resp;
	}// End igual
}// End class Ciframento
