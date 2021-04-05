public class Mdc{
	public static void main(String[] args){
		return mdc();
	}// End main()

	public static int euclides(int value1,int value2){
		int valor1 = Math.abs(value1);
		int valor2 = Math.abs(value2);
		if(getMaior(value2,value1) == value1){
			if(value2 % value1 == 0){

			}// End if
			int value3 = (value2/value1);
			int resto = (value2 % value1 == 0);
			value1 = value3;
			value2 = resto; 
		}// End if
		else if(getMaior(value2,value1) == value2){
			if(value1 % value2 == 0){

			}// End if
			int value3 = (value1/value2);
			int resto = (value1 % value2 == 0);
			value1 = value3;
			value2 = resto; 
		}// End else if
	}// End euclides()

	public static int getMaior(int value1,int value2){
		if(value1 >= value2){
			return value1;
		}// End if
		else if(value2 <= value1){
			return value2;
		}// End else if
	}// End getMaior()
}