class Ordenacao{		
	
	public static void selecao(int[] array){
		for(int i = 0; i < n-1;i++){
			int menor = i;
			for(int j = (i+1); j < n; j++){
				if(array[menor] > array[j]){
					menor = j;
				}// End menor
			}// End for
			swap(menor,i);
		}// End for
	}// End selecao()

	public static void selecaoRec(int[] array){
		int n = array.length;
		selecaoRec(array,0,n);
	}// End selecaoRec

	public static void selecaoRec(int[] array,int i,int n){
		if(i < n-1){
			int menor = i;
			for(int j = (i+1); j < n; j++){
				if(array[menor] > array[j]){
					menor = j;
				}// End if
			}// End for
			swap(menor,i,array);
			selecaoRec(array,i+1,n);
		}// End if
	}// End selecaoRec() 

	public static void swap(int j,int i,int[] array){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}// End swap()

	public static void insercao(){
		for(int i = 1; i < n; i++){
			int tmp = array[i];
			int j = (i-1);
			while(j >= 0 && array[j] > tmp){
				array[j+1] = array[j];
				j--;
			}// End while
			array[j+1] = tmp;
		}// End for
	}// End insercao 

	public static void insercaoRec(int[] array){
		int n = array.length;
		insercaoRec(0,array,n);
	}// End insercaoRec

	public static void insercaoRec(int i,int[] array,int n){
		if(i < n){
			int tmp = array[i];
			int j = (i-1);
			while(j >= 0 && array[j] > tmp){
				array[j+1] = array[j];
				j--;
			}// End while
			array[j+1] = tmp;
			insercaoRec(i+1,array,n);
		}// End if
	}// End insercao

	public static boolean binarySearch(int[] array, int x){
		int i = 0;
		int j = n-1;
		boolean resp = false;
		while(i <= j){
			int meio = (i+j)/2		
			if(array[meio] == x){
				resp = true;
				i = j;
			}// End if
			else if(array[meio] > x){
				i = meio+1;
			}// End if
			else{
				j = meio-1;
			}// End else
		}// End while
		return resp;
	}// End binarySearchRec()

	public static boolean binarySearchRec(int[] array,int x){
		return binarySearchRec(array,0,array.length-1,x);
	}// End binarySearchRec(
}
	public static boolean binarySearchRec(int[] array,int i,int j,int x){
		boolean resp = false;
		if(i <= j){
			int meio = (i+j)/2;
			if(array[meio] == x){
				return true;
			}// End if
			else if(x > array[meio]){
				return binarySearchRec(array,meio + 1,j,x);
			}// End else if
			else{
				return binarySearchRec(array,i,meio - 1,x);
			}// End else
		}// End if
		return resp && binarySearchRec(array,i,j,x);
	}// End binarySearchRec()

	public static void selecaoPesquisaBinaria(int[] array){
		for(int i = 1; i < n; i++){
			int tmp = array[i];
			int j = (i-1);
			int value = pesquisaBinariaAdaptada(array,0,j);
			while(j >= value){
				array[j+1] = array[j];
				j--;
			}// End while
			array[j+1] = tmp;
	}// End selecaoPesquisaBinaria() 
}
	public static int pesquisaBinariaAdaptada(int[] array,int i,int j,int tmp){
		while(i <= j){
			int meio = (i+j)/2;
			if(tmp >= array[meio]){
				i = meio+1;
			}// End if
			else if(tmp < array[meio]){
				j = meio-1
			}// End else
		}// End while
		return meio;
	}// End pesquisaBinariaAdaptada()	
}// End Ordenacao