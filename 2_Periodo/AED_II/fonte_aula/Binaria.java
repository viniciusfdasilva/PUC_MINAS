public class Binaria{
	public static void main(String[] args){
		double inicio = System.currentTimeMillis();
		int[] vet = new int[10000000];
		int x = 38;
		//set(vet);
		pesquisaBinaria(vet,x);
		double fim = System.currentTimeMillis();
		double tempo = (fim-inicio);
		System.out.println(tempo);
	}// End main()

	public static void set(int[] vet){
		for(int i = 0; i < vet.length; i++){
			vet[i] = i+1;
		}// End for
	}// End set()

	public static boolean pesquisaBinaria(int[] array,int x){
		int inicio = 0;
		int fim = array.length-1;
		int meio = 0;
		boolean resp = false;
		while(fim <= inicio){
			meio = (fim + inicio)/2;
			if(x == array[meio]){
				resp = true;
				inicio = array.length;
			}// End if
			else if(x > array[meio]){
				inicio = meio+1;
			}// End else if
			else{
				fim = meio-1;
			}// End else if
		}// End while
		return resp;
	}// End pesquisaBinaria() 
}// End class Binaria