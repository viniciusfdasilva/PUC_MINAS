import java.lang.StringBuilder;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Arrays;
import IO.*;
class Binary{
	public static String dbin2base(String str,int base){
		String bin = " ";
		StringBuilder strbuilder = new StringBuilder(bin);
		if(base == 4){
			if(str.length() % 2 == 0){		
				for(int i = str.length(); str.charAt(i) != ','; i-=2){
					//strbuilder.setCharAt(i,Integer.toString(((Math.pow(2,i)) * Integer.parseInt(Character.toString(str.charAt(i))) + (Math.pow(2,i)) * Integer.parseInt(Character.toString(str.charAt(i-1))))));
				}// End for
			}// End if
			else{
				StringBuilder builder = new StringBuilder(str);
				builder.setCharAt(str.length()+1,'0');
			}// End else
		}// End if
		else if(base == 8){
			if(str.length() % 2 == 0){		
				for(int i = str.length(); str.charAt(i) != ','; i-=3){
					//strbuilder.setCharAt(i,Integer.toString(((Math.pow(2,i)) * Integer.parseInt(Character.toString(str.charAt(i))) + (Math.pow(2,i)) * Integer.parseInt(Character.toString(str.charAt(i-1))) + (Math.pow(2,j)) * Integer.parseInt(Character.toString(str.charAt(i-2))))));
				}// End for
			}// End if
			else{
				StringBuilder builder = new StringBuilder(str);
				builder.setCharAt(str.length()+1,'0');
			}// End else
		}// End else if
		else if(base == 16){
			if(str.length() % 2 == 0){		
				for(int i = str.length(); str.charAt(i) != ','; i-=4){
					//strbuilder.setCharAt(i,Integer.toString(((Math.pow(2,i)) * Integer.parseInt(Character.toString(str.charAt(i))) + (Math.pow(2,i)) * Integer.parseInt(Character.toString(str.charAt(i-1))) + (Math.pow(2,i)) * Integer.parseInt(Character.toString(str.charAt(i-2))) + (Math.pow(2,i)) * Integer.parseInt(Character.toString(str.charAt(i-3))))));
				}// End for
			}// End if
			else{
				StringBuilder builder = new StringBuilder(str);
				builder.setCharAt(str.length()+1,'0');
			}// End else
		}// End else if
		return strbuilder.toString();
	}// End dbin2base()

	public static String double2bin(double value){
		String str = Double.toString(value);
		StringBuilder builder = new StringBuilder(str);
		int j = 0;
		while(Double.parseDouble(str) != 0){
				if(str.charAt(0) == '1'){
					Double.parseDouble(str);
					//Double.toString(str);
					builder.setCharAt(j,str.charAt(0));
					builder.setCharAt(0,'0');
					j++;
				}// End if
				else if(str.charAt(j) == '0'){
					//StringBuilder builder = new StringBuilder(str);
					Double.parseDouble(str);
					//Double.toString(str);
					builder.setCharAt(j,str.charAt(0));
					j++;
				}// End else if
			}// End while
			return builder.toString();
	}// End double2bin()

	public static String dbase2base(String str,int base1,int base2){
		double value = 0;
		String bin = "0,";
		int j = 2;
		StringBuilder builder = new StringBuilder(bin);
		if(base1 == 4 && base2 == 2){
			while(Double.parseDouble(str) != 0){
				if(str.charAt(0) == '1'){
					Double.parseDouble(str);
					//Double.toString(str);
					builder.setCharAt(j,str.charAt(0));
					//StringBuilder builder = new StringBuilder(str);
					builder.setCharAt(0,'0');
					j++;
				}// End if
				else if(str.charAt(j) == '0'){
					Double.parseDouble(str);
					//Double.toString(str);
					builder.setCharAt(j,str.charAt(0));
					j++;
				}// End else if
			}// End while
			return builder.toString();
		}// End if
		else if(base1 == 4 && base2 == 16){
			String s = " ";
			for(int i = 1; i <= str.length()-1;i++){	
				s = Integer.toString(Integer.parseInt(Character.toString(str.charAt(i))) % 8);
					if(s.charAt(1) == '0'){
						builder.setCharAt(i-1,'A');
						Integer.parseInt(Character.toString(str.charAt(i))); 
					}// End if
					else if(s.charAt(1) == '1'){
						builder.setCharAt(i-1,'B');
						Integer.parseInt(Character.toString(str.charAt(i))); 
					}// End else if
					else if(s.charAt(1) == '2'){
						builder.setCharAt(i-1,'C');
						Integer.parseInt(Character.toString(str.charAt(i))); 
					}// End else if
					else if(s.charAt(1) == '3'){
						builder.setCharAt(i-1,'D');
						Integer.parseInt(Character.toString(str.charAt(i))); 
					}// End else if
					else if(s.charAt(1) == '4'){
						builder.setCharAt(i-1,'E');
						Integer.parseInt(Character.toString(str.charAt(i))); 
					}// End else if
					else if(s.charAt(1) == '5'){
						builder.setCharAt(i-1,'F');
						Integer.parseInt(Character.toString(str.charAt(i))); 
					}// End else if
					else if(s.charAt(1) != '1' && s.charAt(1) != '2' && s.charAt(1) != '3' && s.charAt(1) != '4' && s.charAt(1) != '5'){ 
						builder.setCharAt(i-1,s.charAt(0));
						Integer.parseInt(Character.toString(str.charAt(i))); 
					}// End else if
			}// End for
			return builder.toString();
		}// End else if
		else if(base1 == 8 && base2 == 2){
			while(Double.parseDouble(str) != 0){
				if(str.charAt(0) == '1'){
					Double.parseDouble(str);
					//Double.toString(str);
					builder.setCharAt(j,str.charAt(0));
					//StringBuilder builder = new StringBuilder(str);
					builder.setCharAt(0,'0');
					j++;
				}// End if
				else if(str.charAt(j) == '0'){
					Double.parseDouble(str);
					//Double.toString(str);
					builder.setCharAt(j,str.charAt(0));
					j++;
				}// End else if
			}// End while
			return builder.toString();
		}// End else if
		else if(base1 == 8 && base2 == 4){
			String binario = " ";
			binario = converteOctalParaBinario(str);
			bin = dbin2base(binario,base2);
			return bin;
		}// End else if
		else if(base1 == 16 && base2 == 4){
			String binario = " ";
			binario = converteBinarioParaHexadecimal(binario);
			bin = dbin2base(binario,base2);
		}// End else if
		return " ";
	}// End dbase2base()

	public static int bin2dec(String str){
        int change = 0;
        int j = 0;
        for(int i = str.length()-1; i >= 0; i--){ 
            change += (Math.pow(2,j)) * Integer.parseInt(Character.toString(str.charAt(i)));
            j++; 
        }// End for
        return change;
    }// End bin2dec()

	public static String converteBinarioParaHexadecimal(String binario){
	   char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	   StringBuilder sb = new StringBuilder();
	   int posicaoInicial = 0;
	   int posicaoFinal = 0;
	   char caractereEncontrado = '-'; 
	   posicaoInicial = binario.length();
	   posicaoFinal = posicaoInicial;

	   while(posicaoInicial > 0) {
	      posicaoInicial = ((posicaoInicial - 4) >= 0) ? posicaoInicial - 4 : 0;
	      caractereEncontrado = hexa[bin2dec(binario.substring(posicaoInicial, posicaoFinal))];
	      sb.insert(0, caractereEncontrado);
	      posicaoFinal = posicaoInicial;
	   }// End while
	   return sb.toString();
	}// End converteBinarioParaHexadecimal()

	public static String converteOctalParaBinario(String valorOctal){
 	  int posicao = 0;
 	  StringBuilder sb = new StringBuilder();
 	  String valorConvertidoParaBinario = null;
 
 	  while (posicao < valorOctal.length()) { 
    	  valorConvertidoParaBinario = converteDecimalParaBinario(Integer.parseInt(valorOctal.charAt(posicao)+""));                        
 	     if (valorConvertidoParaBinario.length() != 3  && posicao > 0) {
 	        for (int i=0; i < (3-valorConvertidoParaBinario.length()); i++) {
 	           sb.append("0");
 	  		 }// End for
 	     }// End if
 	     sb.append(valorConvertidoParaBinario);
 	     posicao++;
 	  }// End while
 	  return sb.toString();
	}// End converteOctalParaBinario()

	public static String converteDecimalParaBinario(int valor) {
	   int resto = -1;
	   StringBuilder sb = new StringBuilder();	 
	   if (valor == 0) {
	      return "0";
	   }// End if
   	   while (valor > 0) {
     	 resto = valor % 2;
     	 valor = valor / 2;
     	 sb.insert(0, resto);
   	   }// End while
   		return sb.toString();
	}// End converteDecimalParaBinario()

	public static int changeBinarytoDecimal(double value){
        String str = Double.toString(value);
        StringBuilder sb = new StringBuilder();
        int change = 0;
        int change1 = 0;
        int j = 0;
        int k = 0;
        String str1 = " ";
        for(int i = str.length()-1; str.charAt(i) != ','; i--){
            change += (Math.pow(2,j)) * Integer.parseInt(Character.toString(str.charAt(-i)));
            j++;
            k = i;
        }// End for
        for(int i = k-1; i >= 0;i++){
        	change1 += (Math.pow(2,j)) * Integer.parseInt(Character.toString(str.charAt(i))); 
        }// End for
        sb.setCharAt(0,(char)Integer.toString(change1).charAt(0));
        sb.setCharAt(1,',');
        sb.setCharAt(2,(char)Integer.toString(change).charAt(0));
    	return Integer.parseInt(sb.toString());	
    }// End changeBinarytoDecimal()

    public static int changeBinarytoDecimal(String str){
        int change = 0;
        int j = 0;
        for(int i = str.length()-1; i >= 0; i--){
            change += (Math.pow(2,j)) * Integer.parseInt(Character.toString(str.charAt(i)));
            j++;
        }// End for
        return change;
    }// End changeBinarytoDecimal()

    public static String changeDecimalToBinary(int value){
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
    }// End changeDecimalToBinary()

    public static String dbinEval(String str1,char chr,String str2){
    	String str = " ";
    	if(chr == '+'){
    		double value1 = changeBinarytoDecimal(str1);
    		double value2 = changeBinarytoDecimal(str2);
    		double soma = value1 + value2;
    		str = double2bin(soma);
    	}// End chr
    	else if(chr == '-'){
    		double value1 = changeBinarytoDecimal(str1);
    		double value2 = changeBinarytoDecimal(str2);
    		double soma = value1 - value2;
    		str = double2bin(soma);
    	}// End else if
    	else if(chr == '*'){
    		double value1 = changeBinarytoDecimal(str1);
    		double value2 = changeBinarytoDecimal(str2);
    		double soma = value1 * value2;
    		str = double2bin(soma);
    	}// End else if
    	else if(chr == '/'){
    		double value1 = changeBinarytoDecimal(str1);
    		double value2 = changeBinarytoDecimal(str2);
    		double soma = value1 / value2;
    		str = double2bin(soma);
    	}// End else if
    	else if(chr == '%'){
    		int value1 = changeBinarytoDecimal(str1);
    		int value2 = changeBinarytoDecimal(str2);
    		int soma = value1 % value2;
    		str =  changeDecimalToBinary(soma);
    	}// End else if
   		return str;
    }// End dbinEval 
}// End class Binary

public class Main{
	public static void main(String[] args){
		IO.println ( "Guia_02 - Java Tests" );
		IO.println ( "Nome: Vinicius Francisco da Silva Matricula 576920" );
		
		IO.println ("QUESTÃO 02");
		IO.equals ( double2bin ( 0.0625 ), "0" );
		IO.equals ( double2bin ( 0.12500 ), "0" );
		IO.equals ( double2bin ( 0.87500 ), "0" );
		IO.equals ( double2bin ( 2.62500 ), "0" );
		IO.equals ( double2bin ( 11.75000 ), "0" );
		IO.println ( "2. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );

		IO.println ("QUESTÃO 03");
		IO.equals ( dbin2base ( "0.111001", 4 ), "0" );
		IO.equals ( dbin2base ( "0.011000", 8 ), "0" );
		IO.equals ( dbin2base ( "0.101011", 16 ), "0" );
		IO.equals ( dbin2base ( "1.110100", 8 ), "0" );
		IO.equals ( dbin2base ( "1001.1110", 16 ), "0" );
		IO.println ( "3. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );
	
		IO.println ("QUESTÃO 04");
		IO.equals ( dbase2base ( "0.312", 4, 2 ), "0" );
		IO.equals ( dbase2base ( "0.021", 4, 16 ), "0" );
		IO.equals ( dbase2base ( "0.132", 8, 2 ), "0" );
		IO.equals ( dbase2base ( "5.470", 8, 4 ), "0" );
		IO.equals ( dbase2base ( "A.470", 16, 4 ), "0" );
		IO.println ( "4. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );
		
		IO.println ("QUESTÃO 05");
		IO.equals ( dbinEval ( "111.110", "+", "1.11" ), "0" );
		IO.equals ( dbinEval ( "1011.011", "-", "10.11" ), "0" );
		IO.equals ( dbinEval ( "110.010", "*", "101.11" ), "0" );
		IO.equals ( dbinEval ( "10111.110", "/", "10.01" ), "0" );
		IO.equals ( dbinEval ( "1011111", "%", "1011" ), "0" );
		IO.println ( "5. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );
		IO.println ( );
		IO.pause ( "Apertar ENTER para terminar." );
	}// End main()
}// End class Main
