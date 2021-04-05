import java.util.*;
public class BintoDec{
	public static int bintoDec(int binary) throws Exception{
		String str = Integer.toString(binary);
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != '0' && str.charAt(i) != '1'){
				throw new Exception("erro: ");
			}// End if
		}// End for
		int decimal = 0;
		int j = 0;
		for(int i = (str.length()-1); i >= 0; i--){
			decimal += (Integer.parseInt(Character.toString(str.charAt(i))) * Math.pow(2,j));
			j++;
		}// End for
		return decimal;
	}// End bintoDec()

	public static void main(String[] args) throws Exception{
		IO.println ( "Guia_01 - Java Tests" );
		IO.println ( "Nome: Vinicius Francisco da Silva Matricula 576920" );		
		
		IO.println ("QUESTÃO 02");	
		IO.equals( bintoDec ( "10101" ), 0);
		IO.equals( bintoDec ( "10010" ), 0);
		IO.equals( bintoDec ( "100111" ), 0);
		IO.equals( bintoDec ( "101110" ), 0);
		IO.equals( bintoDec ( "110011" ), 0);
		IO.println( ". errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );
	}// End main()
}// End class BintoDec
