import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str;
		for(int i = 0; i < 3; i++){
			str = scanner.nextLine();
			System.out.println(contLetra(str));
			if(isLetra(str)){
				System.out.println("SIM");
			}// End if
			else if(!isLetra(str)){
				System.out.println("NÃO");
			}// End if
		}// End for
	}// End main()

	public static int contLetra(String str){
		return contLetra(str,0);
	}// End isVogal()

	public static int contLetra(String str,int i){
		int cont = 0; 
		if(i < str.length()){
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				cont = 1 + contLetra(str,i+1);
			}// End if
			else{
				cont = contLetra(str,i+1);
			}// End else
		}// End if
		return cont;
	}// End contLetraVogal()

	public static boolean isLetra(String str){
		return isLetra(str,0);
	}// End isLetra()

	public static boolean isLetra(String str,int i){
		boolean resp = false;
		if(i < str.length()){
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				resp = true && isLetra(str,i+1);		
			}// End if
			else{
				resp = false && isLetra(str,i+1);
			}// End else
		}// End if
		else{
			return true;
		}// End else
		return resp;
	}// End isLetra()
}// End class Main()