class Pesquisa{

	public boolean sequencial(int x,int[] array){
		boolean resp = false;
		for(int i = 0; i < array.length; i++){
			if(array[i] == x){
				resp = true;
				i = array.length;
			}// End if
		}// End for
		return resp;
	}// End sequencial

	public boolean binaria(){

	}// End binaria()
}// End class Pesquisa