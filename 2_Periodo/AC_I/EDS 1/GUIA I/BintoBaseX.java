public class BintoBaseX{
	public static int bintoBaseX(int binary,int base){
		String str = Integer.toString(binary);
		StringBuilder string = new StringBuilder();
		string.setLength();
		int i = 0;
		int j = (str.length()-1);
		if(base == 4){
			if(str.length() % 2 == 0){
				int pot_0, pot_1;
				pot_0 = pot_1;
				while(j > 0){
					pot_0 = (Integer.parseInt(str.charAt(j)) * Math.pow(2,0));
					pot_1 = (Integer.parseInt(str.charAt(j-1)) * Math.pow(2,1));
					string.setcharAt(i,(char)(pot_0 + pot_1));
					j = (j-2);
					i++;
				}// End while
			}// End if
			else{
				int pot_0, pot_1;
				pot_0 = pot_1;
				while(j > 0){
					pot_0 = (Integer.parseInt(str.charAt(j)) * Math.pow(2,0));
					pot_1 = (Integer.parseInt(str.charAt(j-1)) * Math.pow(2,1));
					string.setcharAt(i,(char)(pot_0 + pot_1));
					j = (j-2);
					i++;
				}// End while
				string.setcharAt(i,str.charAt(j));
			}// End else
		}// End if
		else if(base == 8){
			if(str.length() % 3 == 0){
				int pot_0, pot_1, pot_2;
				pot_0 = pot_1 = pot_2 = 0;
				while(j > 0){
					pot_0 = (Integer.parseInt(str.charAt(j)) * Math.pow(2,0));
					pot_1 = (Integer.parseInt(str.charAt(j-1)) * Math.pow(2,1));
					pot_2 = (Integer.parseInt(str.charAt(j-2)) * Math.pow(2,2));
					string.setcharAt(i,(char)(pot_0 + pot_1 + pot_2));
					j = (j-3);
					i++;
				}// End while				
			}// End if
			else if(str.length() % 2 == 0){
			}// End else if
			else{
			}// End if
		}// End else if
	}// End bintoBaseX()

	public static void main(String[] args){
		IO.println ( "Guia_01 - Java Tests" );
		IO.println ( "Nome: Vinicius Francisco da Silva Matricula 576920" );
		
		IO.println ("QUESTÃO 04");
		IO.equals( bintoBaseX ( "10101", 4 ), "10101" );
		IO.equals( bintoBaseX ( "11011", 8 ), "10101" );
		IO.equals( bintoBaseX ( "101111", 16 ), "10101" );
		IO.equals( bintoBaseX ( "101001", 8 ), "10101" );
		IO.equals( bintoBaseX ( "111011", 4 ), "10101" );
		IO.println( "4. errorTotalReportMsg = "+IO.errorTotalReportMsg( ));
	}// End main()
}// End BintoBaseX
