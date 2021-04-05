class Ordenacao{

	public void Selecao(int[] array){
		for(int i = 0; i < array.length-1; i++){
			int menor = i;
			for(int j = (i+1); j < array.length; j++){
				if(array[menor] > array[j]){
					menor = j;
				}// End if
			}// End for
		}// End for
		swap(menor,j);
	}// End Selecao()

	public void Selecao(long[] array){
		for(int i = 0; i < array.length-1; i++){
			int menor = i;
			for(int j = (i+1); j < array.length; j++){
				if(array[menor] > array[j]){
					menor = j;
				}// End if
			}// End for
		}// End for
		swap(menor,j);
	}// End Selecao()

	public void Selecao(short[] array){
		for(int i = 0; i < array.length-1; i++){
			int menor = i;
			for(int j = (i+1); j < array.length; j++){
				if(array[menor] > array[j]){
					menor = j;
				}// End if
			}// End for
		}// End for
		swap(menor,j);
	}// End Selecao()

	public void Selecao(double[] array){
		for(int i = 0; i < array.length-1; i++){
			int menor = i;
			for(int j = (i+1); j < array.length; j++){
				if(array[menor] > array[j]){
					menor = j;
				}// End if
			}// End for
		}// End for
		swap(menor,j);
	}// End Selecao()

	public void Selecao(float[] array){
		for(int i = 0; i < array.length-1; i++){
			int menor = i;
			for(int j = (i+1); j < array.length; j++){
				if(array[menor] > array[j]){
					menor = j;
				}// End if
			}// End for
		}// End for
		swap(menor,i);
	}// End Selecao()
}// End class Ordenação