public class DectoBaseX{
	public static String dectoBaseX(int decimal,int base){
		StringBuilder str = new StringBuilder();
		str.setLength(100);
		int i, j;
		i = j = 0;
		StringBuffer stringbuffer = null;
		if(base == 4){
			while(value > 1){
				str.setCharAt(i,(char)(value % base));
				value /= base;
				i++;
			}// End while
			if(value > 0) str.setCharAt(i,(char)value));
			stringbuffer = new StringBuffer(str.toString());
			stringbuffer = stringbuffer.reverse();
		}// End if
		else if(base == 8){
			while(value > 1){
				str.setCharAt(i,(char)(value % base));
				value /= base;
				i++;
			}// End while
			if(value > 0) str.setCharAt(i,(char)value));
			stringbuffer = new StringBuffer(str.toString());
			stringbuffer = stringbuffer.reverse();
		}// End else if
		else if(base == 16){
			while(value > 1){
				if(value % base < 10) str.setCharAt(i,(char)(value % base));
				else if(value % base == 10) str.setCharAt(i,'A');
				else if(value % base == 11) str.setCharAt(i,'B');
				else if(value % base == 12) str.setCharAt(i,'C');
				else if(value % base == 13) str.setCharAt(i,'D');
				else if(value % base == 14) str.setCharAt(i,'E');
				else if(value % base == 15) str.setCharAt(i,'F');
				value /= base;
				i++;
			}// End while
			if(value > 0) str.setCharAt(i,(char)value));
			stringbuffer = new StringBuffer(str.toString());
			stringbuffer = stringbuffer.reverse();
		}// End else if
		return stringbuffer.toString();
	}// End DectoBaseX()

	public static void main(String[] args){
		IO.println ( "Guia_01 - Java Tests" );
		IO.println ( "Nome: Vinicius Francisco da Silva Matricula 576920" );
		
		IO.println ("QUESTÃO 03");
		IO.equals( dectoBaseX ( 72, 4 ), "10101" );
		IO.equals( dectoBaseX ( 45, 8 ), "10101" );
		IO.equals( dectoBaseX ( 61, 16 ), "10101" );
		IO.equals( dectoBaseX ( 174, 16 ), "10101" );
		IO.equals( dectoBaseX ( 125, 16 ), "10101" );
		IO.println( "3. errorTotalReportMsg = "+IO.errorTotalReportMsg( ) );
	}// End main()
}// End class DectoBseX
