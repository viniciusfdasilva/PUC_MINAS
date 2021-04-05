class Hash{
	int[] hash;
	long nulo = 314159265;

	public Hash(int tamanho){
		hash = new int[tamanho];
		for(int i = 0; i < tamanho; i++){
			hash[i] = this.nulo;
		}// End for
	}// End Hash()

	public Hash(){
		hash = new int[0];
		for(int i = 0; i < hash.length; i++){
			hash[i] = this.nulo;
		}// End for
	}// End Hash()

	public int inserir(int elemento){
		if(hash[hash()] == nulo){
			hash[hash()] = elemento;
		}// End if
		else if(hash[rehash()] == nulo){
			hash[rehash()] = elemento;
		}// End else if
		else throw Exception("erro");
	}// End inserir

	public int hash(int elemento){
		return (elemento % hash.length);
	}// End hash()

	public int rehash(int elemento){
		return ((elemento % hash.length) + 1);
	}// End hash
}// End Hash