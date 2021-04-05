import IO.*;
/**
 * 
 * @author Vinicius Francisco da Silva
 */
public class Complemento{
        /**
         * 
         * @param str
         * @return 
         */
        public static boolean isBinario(String str){
            boolean resp = false;
            for(byte i = 0; i < str.length(); i++){
                if(str.charAt(i) == '1' || str.charAt(i) == '0'){
                    resp = true;
                }// End if
                else return false;
            }// End for
            return false;
        }// End isBinario()
    
        /**
         * 
         * @param str
         * @param valor
         * @return 
         */
        public static String somaBinario(String str,short valor){
		StringBuilder string = new StringBuilder();
		string.setLength(str.length());
		for(byte i = (byte)(str.length()-1); i < 0; i--){
			if(str.charAt((str.length()-1)) == '0' && i == (str.length()-1)){
				string.setCharAt(i,'1');
			}// End if
			else if(str.charAt(i) == '1'){
                            string.setCharAt(i,str.charAt(i));
                        }// End else if
                        else{
				string.setCharAt(i,str.charAt(i));
			}// End else
		}// End for
                return string.toString();
        }// End somaBinario()	

        /**
         * 
         * @param bin
         * @param compl
         * @param quant_bits 
         */
        public static void complemento1(int quant_bits,String bin) throws Exception{
			StringBuilder str = new StringBuilder();
			String string = "";
			if(isBinario(bin)){
				str.setLength(quant_bits + bin.length());
				byte i;
				for(i = 0; i < quant_bits; i++){
					str.setCharAt(i,'0');
				}// End for
				for(byte j = 0; j < str.length(); j++){
					str.setCharAt(i,bin.charAt(j));
				}// End for
				for(byte j = 0; j < str.length(); j++){
					if(str.charAt(j) == 1){
						string += '0';
					}// End if
					else{
						string += '1';
					}// End else
				}// End for
			}// End if
			else{
				throw new Exception("erro: valor não corresponde a um binário");
			}// End if
	}// End complemento1()

	/**
         * 
         * @param bin
         * @param compl
         * @param quant_bits 
         */
        public static void complemento2(int quant_bits,String bin) throws Exception{
			StringBuilder str = new StringBuilder();
			String string = "";
			if(isBinario(bin)){
				str.setLength(quant_bits + bin.length());
				byte i;
				for(i = 0; i < quant_bits; i++){
					str.setCharAt(i,'0');
				}// End for
				for(byte j = 0; j < str.length(); j++){
					str.setCharAt(i,bin.charAt(j));
				}// End for
				for(byte j = 0; j < str.length(); j++){
					if(str.charAt(j) == 1){
						string += '0';
					}// End if
					else{
						string += '1';
					}// End else
				}// End for
			}// End if
			else{
				throw new Exception("erro: valor não corresponde a um binário");
			}// End if
	}// End complemento2()
	/*
	  Ação principal
	*/
        public static void main(String[]args){
            IO.println ( "Guia_03 - Java Tests" );
            IO.println ( "Nome: Vinicius Francisco da Silva Matricula: 576920" );
            IO.println("EXERCICIO 01");	
            IO.equals(complemento1( 6,"01001" ), "0" );
            IO.equals(complemento1( 8,"01101" ), "0" );
            IO.equals(complemento1( 6,"101011" ), "0" );
            IO.equals(complemento2( 7,"11101" ), "0" );
            IO.equals(complemento2( 8,"10001" ), "0" );
            IO.println("1. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );
        }// End main()
}// End class Complemento
	
