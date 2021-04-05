import IO.*;
/**
 * 
 * @author Vinicius Francisco da Silva
 */
public class BintoDec{
    /**
     * Função que converte um valor binário
     * com vírgula em um valor base (10)
     * @param String str contendo o valor binário
     * @return valor convertido
     */
	public static double convert(String str){		
		byte index = (byte)str.indexOf(".");
		String string_antvirgula = str.substring(0,index);
		String string_posvirgula = str.substring(index+1,str.length());
		byte j,cont,cont_int;
		j = cont_int = 0;
		double cont_double = 0;
		for(byte i = (byte)(string_antvirgula.length()-1); i >= 0; i--){
			cont_int += (Integer.parseInt(Character.toString(string_antvirgula.charAt(i))) * Math.pow(2,j));
			j++;
		}// End for
		for(byte i = 0; i < string_posvirgula.length(); i++){
			cont_double += (Integer.parseInt(Character.toString(string_posvirgula.charAt(i))) * Math.pow(2,-(i+1)));
		}// End for
		return (cont_int + cont_double);
	}// End convert()
	
    /*
     * Função principal
	*/
	public static void main (String[] args){
		IO.println("Guia_02 - Java Tests" );
		IO.println ("Nome: Vinicius Francisco da Silva - Matricula: 576920");
		IO.println("EXERCÍCIO 01");
		IO.equals(convert("0.10100"),0);
		IO.equals(convert("0.01100"),0);
		IO.equals(convert("0.00110"),0);
		IO.equals(convert("1.11011"),0);
		IO.equals(convert("11.11010"),0);
		IO.println("1. errorTotalReportMsg = "+IO.errorTotalReportMsg());
	}// End main()
}// End BintoDec
