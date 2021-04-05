import java.util.Random;
public class Sequencial{
	public static void main(String[] args){
		double inicio = System.currentTimeMillis();
		int[] vet = new int[10000000];
		int x = 38;
		//set(vet);
		pesquisaSequencial(vet,x);
		double fim = System.currentTimeMillis();
		double tempo = (fim-inicio);
		System.out.println(tempo);
	}// End main()

	public static void set(int[] array){
		for(int i = 0; i < array.length; i++){
			array[i] = i+1;
		}// End for
	}// End random()

	public static void pesquisaSequencial(int[] array, int x){
		int n = array.length;
		for(int i = 0; i < n; i++){
			if(array[i] == x){
				i = n+1;
			}// End if
		}// End for
	}// End pesquisaSequencial() 
}// End class Sequencial