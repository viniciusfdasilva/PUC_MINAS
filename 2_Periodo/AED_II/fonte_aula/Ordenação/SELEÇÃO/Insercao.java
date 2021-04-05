public class Insercao{
	public static void main(String[] args){
		int[] array = new int[4];
		array[0] = 2;
		array[1] = 3;
		array[2] = 2;
		array[3] = 1;
		int n = array.length;
		insercao(array,n);
		for(int i = 0; i < n; i++){
			System.out.println(array[i]);
		}// End for
	}// End main()

	public static void insercao(int[] array,int n){
		for(int i = 0; i < n;i++){
			int tmp = array[i];
			int j = (i-1);
			int value = pesquisabinaria(array,0,j,tmp);
			while(j >= value && array[j] > tmp){
				array[j+1] = array[j];
				j--;
			}// End while
			array[j+1] = tmp;
		}// End for
	}// End insercao()

	public static int pesquisabinaria(int[] array,int i,int j,int x){
		int meio = 0;
		while(i <= j){
			meio = (i+j)/2;
			if(x >= array[meio]){
				i = meio+1;
			}// End if
			else if(x < array[meio]){
				j = meio-1;
			}// End else if
		}// End while
		return meio;
	}// End pesquisabinaria()
}// End class Insercao
