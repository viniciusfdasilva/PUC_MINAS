import java.lang.Object;
import java.util.ArrayList;
import java.util.Arrays;
import IO.*;
/*
	Arquitetura de Computadores I - Guia_01.
*/
class Binary{
	/*
	Converter valor decimal para binario.
	@return binario equivalente
	@param value - valor decimal
	*/
	public static String  dec2bin(int value){
        ArrayList<Integer> binary = new ArrayList<Integer>();
        while(value > 1){ 
            if(value % 2 == 0){
                binary.add(0);
            }// End if
            else if(value % 2 == 1){
                binary.add(1);
            }// End else if
            value /= 2;
        }// End while
            if(value == 1){
                binary.add(1);
            }// End if
            else if(value == 0){
                binary.add(0);
           }// End else if
            String str = " ";
            int j = 0;
            StringBuilder stringBuilder = new StringBuilder(str);
            for(int i = 0; i < Arrays.toString((binary.toArray())).length()-1; i++){
                if(Arrays.toString((binary.toArray())).charAt(i) == '1' || Arrays.toString((binary.toArray())).charAt(i) == '0'){
                    str = stringBuilder.insert(0,Arrays.toString((binary.toArray())).charAt(i)).toString().trim();
                }// End if
                j++;
            }// End for
            return str;
    }// End dec2bin ()
	/*
	Converter valor binario para decimal.
	@return decimal equivalente
	@param value - valor binario
	*/
     public static int bin2dec(String str){
        int change = 0;
        int j = 0;
        for(int i = str.length()-1; i >= 0; i--){ 
            change += (Math.pow(2,j)) * Integer.parseInt(Character.toString(str.charAt(i)));
            j++; 
        }// End for
        return change;
    }// End bin2dec()
    /*
	Converter valor decimal para base indicada.
	@return base para a conversao
	@param value - valor decimal
	*/
    public static String dec2base(int value,int base){
    	String str = " ";
        if(base == 4){
        	 ArrayList<Integer> array = new ArrayList<Integer>();
        	while(value > 0){ 
        	    array.add(value % 4);
        	    value /= 4;
        	}// End while
        	    int j = 0;
            StringBuilder stringBuilder = new StringBuilder(str);
            for(int i = 0; i < Arrays.toString((array.toArray())).length()-1; i++){
            	 if(Arrays.toString((array.toArray())).charAt(i) == '1' || Arrays.toString((array.toArray())).charAt(i) == '0'){
            	    str = stringBuilder.insert(0,Arrays.toString((array.toArray())).charAt(i)).toString().trim();
            	    j++;
            	}// End if
            }// End for
        }// End if
        else if(base == 8){
        	 ArrayList<Integer> array = new ArrayList<Integer>();
        	while(value > 0){ 
        	    array.add(value % 8);
        	    value /= 8;
        	}// End while
        	    int j = 0;
            StringBuilder stringBuilder = new StringBuilder(str);
            for(int i = 0; i < Arrays.toString((array.toArray())).length()-1; i++){
                if(Arrays.toString((array.toArray())).charAt(i) == '1' || Arrays.toString((array.toArray())).charAt(i) == '0'){
                    str = stringBuilder.insert(0,Arrays.toString((array.toArray())).charAt(i)).toString().trim();
                }// End if
                j++;
            }// End for
        }// End else if
        else if(base == 16){
        	ArrayList<String> array = new ArrayList<String>();
        	while(value > 0){ 
        		if(value % 16 == 10){
        			array.add("A");	
        		}// End if
        		else if(value % 16 == 11){
        			array.add("B");
        		}// End else if
        		else if(value % 16 == 12){
        			array.add("C");
        		}// End else if
        		else if(value % 16 == 13){
        			array.add("D");
        		}// End else if
        		else if(value % 16 == 14){
        			array.add("E");
        		}// End else if
        		else if(value % 16 == 15){
        			array.add("F");
        		}// End else if
        		else{
        	   	 	array.add(Integer.toString(value % 16));
        	   	}// End else 
        	   	 value /= 16;
        	}// End while
        	    int j = 0;
            StringBuilder stringBuilder = new StringBuilder(str);
            for(int i = 0; i < Arrays.toString(array.toArray()).length()-1; i++){
                 if(Arrays.toString((array.toArray())).charAt(i) == '1' || Arrays.toString((array.toArray())).charAt(i) == '0'){
                	str = stringBuilder.insert(0,Arrays.toString((array.toArray())).charAt(i)).toString().trim();
                	j++;
                }// End if
            }// End for
        }// End else if
    	return str;
    }// End dec2base()
   	/*
	Converter valor binario para base indicada.
	@return valor equivalente na base indicada
	@param value - valor binario
	@param base - para a conversao
	*/
   	public static String bin2base(String str,int base){
   		String change = " ";
   		if(base == 8){
   			change = converteBinarioParaOctal(str);
   		}// End else if
   		else if(base == 16){
   			change = converteBinarioParaHexadecimal(str);
   		}// End else if
   		return change;
   	}// End converteBinario()

   	/*
	Converter valor binario para base indicada.
	@return valor equivalente na base indicada
	@param value - valor binario
	@param base - para a conversao
	*/
    public static String converteBinarioParaOctal(String binario) {
   		StringBuilder sb = new StringBuilder();
   		int posicaoInicial = 0;
   		int posicaoFinal = 0;
  	    posicaoInicial = binario.length();
        posicaoFinal = posicaoInicial; 
   
   		while (posicaoInicial > 0) {
    	  posicaoInicial = ((posicaoInicial - 3) >= 0) ? posicaoInicial - 3 : 0;
    	  sb.insert(0, bin2dec(binario.substring(posicaoInicial, posicaoFinal)));
    	  posicaoFinal = posicaoInicial;
   		}// End
   		return sb.toString();
	}// End converteBinarioParaHexadecimal()

	/*
	Converter valor binario para base indicada.
	@return valor equivalente na base indicada
	@param value - valor binario
	@param base - para a conversao
	*/
	public static String converteBinarioParaHexadecimal(String binario) {
	   char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	   StringBuilder sb = new StringBuilder();
	   int posicaoInicial = 0;
	   int posicaoFinal = 0;
	   char caractereEncontrado = '-'; 
	   posicaoInicial = binario.length();
	   posicaoFinal = posicaoInicial;

	   while (posicaoInicial > 0) {
	      posicaoInicial = ((posicaoInicial - 4) >= 0) ? posicaoInicial - 4 : 0;
	      caractereEncontrado = hexa[bin2dec(binario.substring(posicaoInicial, posicaoFinal))];
	      sb.insert(0, caractereEncontrado);
	      posicaoFinal = posicaoInicial;
	   }// End while
	   return sb.toString();
	}// End converteBinarioParaHexadecimal()

	/*
	Converter valor em ASCII para hexadecimal.
	@return hexadecimal equivalente
	@param value - caractere(s) em codigo ASCII
	*/
	public static String ASCII2hex(String value){
		ArrayList<String> array = new ArrayList<String>();
		int[] vetor = new int[value.length()];
		for(int i = 0; i <= value.length()-1; i++){
			vetor[i] = (int)value.charAt(i); 
        		while(vetor[i] > 0){
        			if(vetor[i] % 16 == 10){
        				array.add("A");	
        			}// End if
        			else if(vetor[i] % 16 == 11){
        				array.add("B");
        			}// End else if
        			else if(vetor[i] % 16 == 12){
        				array.add("C");
        			}// End else if
        			else if(vetor[i] % 16 == 13){
        				array.add("D");
        			}// End else if
        			else if(vetor[i] % 16 == 14){
        				array.add("E");
        			}// End else if
        			else if(vetor[i] % 16 == 15){
        				array.add("F");
        			}// End else if
        			else{
        		   	 	array.add(Integer.toString(vetor[i] % 16));
        		   	}// End else 
        		   	 vetor[i] /= 16;
        	}// End while
        	array.add(" ");
        }// End for
        	int j = 0;
        	String str = " ";
            StringBuilder stringBuilder = new StringBuilder(str);
            for(int i = 0; i < Arrays.toString(array.toArray()).length()-1; i++){
				 if(Arrays.toString((array.toArray())).charAt(i) == '1' || Arrays.toString((array.toArray())).charAt(i) == '0'){
               		str = stringBuilder.insert(0,Arrays.toString((array.toArray())).charAt(i)).toString().trim();
               		j++;
            	}// End if
            }// End for
        return str;
	} // end ASCII2hex()

	/*
	Converter valor em hexadecimal para ASCII.
	@return caractere(s) em codigo ASCII
	@param value - hexadecimal equivalente(s)
	*/
	public static String hex2ASCII(String value){
		ArrayList<Integer> array = new ArrayList<Integer>();
		String digits = "0123456789ABCDEF";
        value = value.toUpperCase();
        int val = 0;
        for (int i = 0; i < value.length(); i++){
            char c = value.charAt(i);
            int d = digits.indexOf(c);
        	val = 16*val + d;
        	array.add(val);
        }// End for
        int j = 0;
        String str = " ";
        StringBuilder stringBuilder = new StringBuilder(str);
            for(int i = Arrays.toString((array.toArray())).length()-1; i > 0 ; i++){
				 if(Arrays.toString((array.toArray())).charAt(i) == '1' || Arrays.toString((array.toArray())).charAt(i) == '0'){
               		str = stringBuilder.insert(0,Arrays.toString((array.toArray())).charAt(i)).toString().trim();
               		j++;
            	}// End if
            }// End for
        return str;
	} // end hex2ASCII()
}// End class Binary
public class Binario{
    public static void main(String[] args){
        IO.println( "Guia_01 - Java Tests" );
	    IO.println( "Nome: Vinicius Francisco da Silva Matricula: 576920 " );
 	    
 	    IO.println("EXERCICIO 01");
		IO.equals(dec2bin(26), "10101" );
		IO.equals(dec2bin(56),EXIT "10101" );
        IO.equals(dec2bin(767), "10101" );
		IO.equals(dec2bin(161), "10101" );
		IO.equals(dec2bin(366), "10101" );
		IO.println("1. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );

		IO.println("EXERCICIO 02");
		IO.equals(bin2dec("10001"), 0);
		IO.equals(bin2dec("10011"), 0);
		IO.equals(bin2dec("100101"), 0);
		IO.equals(bin2dec("110110"), 0);
		IO.equals(bin2dec("110111"), 0);
		IO.println("2. errorTotalReportMsg() =" +IO.errorTotalReportMsg( )); 

		IO.println("EXERCICIO 03");
		IO.equals(dec2base (74,4), "10101" );
		IO.equals(dec2base (47,8), "10101" );
		IO.equals(dec2base (64,16), "10101" );
		IO.equals(dec2base (184,16), "10101" );
		IO.equals(dec2base (124,16), "10101" );
		IO.println( "3. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );

		IO.println("EXERCICIO 04");
		IO.equals(bin2base("11001",8), "10101" );
		IO.equals(bin2base("101011",16), "10101" );
		IO.equals(bin2base("100101",8), "10101" );
		IO.equals(bin2base("111001",4), "10101" );
		IO.println("4. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );

		IO.println("EXERCICIO 05");
		IO.equals(ASCII2hex("PUC-Minas"), "10101" );
		IO.equals(ASCII2hex("2017-2"), "10101" );
		IO.equals(ASCII2hex("Brasil"), "10101" );
		IO.equals(hex2ASCII("78 111 105 116 101"), "10101" ); 
		IO.equals(hex2ASCII("42 2E 48 2E 2D 4D 47"), "10101" ); 
		IO.println( "5. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) ); 

		IO.pause ( "Apertar ENTER para terminar." );
    }// End main
}// End class Main
