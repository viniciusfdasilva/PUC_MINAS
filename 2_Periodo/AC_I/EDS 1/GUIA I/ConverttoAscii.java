import java.lang.StringBuilder;
public class ConverttoAscii{
	public static String convert(String str){
		StringBuilder string = new StringBuilder();
		string.setLength((str.length()+str.length()));
		for(int i = 0; i < str.length(); i++){
			string.setCharAt(i,(int)str.charAt(i));
			string.setCharAt((i+1),'-');
		}// End for
	}// End convert()

	public static void main(String[] args){
		IO.println ( "Guia_01 - Java Tests" );
		IO.println ( "Nome: Vinicius Francisco da Silva Matricula 576920" );		
		
		IO.println ("QUESTÃO 05");
		IO.equals ( convert ( "PUC-Minas" ), "10101" );
		IO.equals ( convert ( "2018-1"), "10101" );
		IO.equals ( convert ( "Brasil"), "10101" );
		// OBS.: Usar todos os códigos do exercício (05)!
		IO.equals ( convert ( "78"), "10101" ); // OBS.: 78 e' apenas o primeiro decimal (5d)!
		IO.equals ( convert ( "42"), "10101" ); // OBS.: 42 e' apenas o primeiro hexadecimal (5e)!
		IO.println ( "5. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );
	}// End main()
}// End class ConverttoAscii
