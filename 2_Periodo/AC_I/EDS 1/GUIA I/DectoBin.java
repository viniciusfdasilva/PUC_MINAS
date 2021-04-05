import java.lang.StringBuilder;
import java.lang.StringBuffer;
public class DectoBin{

	public static String convert(int value){
		StringBuilder str = new StringBuilder();
		str.setLength(100);
		int i, j;
		i = j = 0;
		while(value > 1){
			if(value % 2 == 0) str.setCharAt(i,'0');
			else if(value % 2 == 1) str.setCharAt(i,'1');
			value /= 2;
			i++;
		}// End while
		if(value == 0) str.setCharAt(i,'0');
		else if(value == 1) str.setCharAt(i,'1');
		StringBuffer stringbuffer = new StringBuffer(str.toString());
		stringbuffer = stringbuffer.reverse();
		return stringbuffer.toString();
	}// End convert()

	public static void main(String[] args){
		IO.println ( "Guia_01 - Java Tests" );
		IO.println ( "Nome: Vinicius Francisco da Silva Matricula 576920" );
		
		IO.println ("QUESTÃO 01");
		IO.equals( convert ( 57 ), "10101" );
		IO.equals( convert ( 737 ), "10101" );
		IO.equals( convert ( 136 ), "10101" );
		IO.equals( convert ( 360 ), "10101" );
		IO.println( "4. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );
	}// End main()
}// End class Convert

