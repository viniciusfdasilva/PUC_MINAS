
	public void ordena(){
		ordena(0,n);
	}// End ordena

/**
	* Método que recebe um array de inteiros e dois inteiros referentes ao início e ao fim
	* da ordenação desse array, o que nos garante o poder de escolher uma faixa do array
	* para ser ordenado.
	*
	* @param array
	* @param indiceInicio
	* @param indiceFim
	*/
	public void ordena(int indiceInicio, int indiceFim) {
		// Condicional que verifica a validade dos parâmetros passados.
		if(array != null && indiceInicio < indiceFim && indiceInicio >= 0 && indiceFim < n && n != 0){
			int meio = ((indiceFim+indiceInicio)/2);
			ordena(indiceInicio,meio);
			ordena(meio+1,indiceFim);
			merge(indiceInicio,meio,indiceFim);
		}// End if
	}// End ordena

	/**
	* O merge consiste na junção de duas listas já ordenadas.
	* Usa um array auxiliar.
	*
	* @param array
	* @param indiceInicio
	* @param meio
	* @param indiceFim
	*/
	public void merge(int indiceInicio, int meio, int indiceFim){
		Serie tmp = new Serie[n];
		//Copiando o trecho da lista que vai ser ordenada
		for(int i = indiceInicio; i <= indiceFim; i++) {
			auxiliar[i] = array[i];
		}// End for
		//Índices auxiliares
		int i = indiceInicio;
		int j = meio + 1;
		int k = indiceInicio;
		//Junção das listas ordenadas
		while(i <= meio && j <= indiceFim){
			if(auxiliar[i].getNumeroEpisodios() < auxiliar[j].getNumeroEpisodios()){
				array[k] = auxiliar[i];
				i++;
			}else{
				array[k] = auxiliar[j];
				j++;
			}// End else
			if(auxiliar[i].getNumeroEpisodios() == auxiliar[j].getNumeroEpisodios()){
				if(auxiliar[i].getNome().compareTo(auxiliar[j].getNome()) < 0){
					array[k] = auxiliar[i];
					i++;
				}else{
				array[k] = auxiliar[j];
					j++;
				}// End else
			}// End if
			k++;
		}// End while
		//Append de itens que não foram usados na Junção
		while (i <= meio){
			array[k] = auxiliar[i];
			i++;
			k++;
		}// End while
		//Append de itens que não foram usados na Junção
		while (j <= indiceFim) {
			array[k] = auxiliar[j];
			j++;
			k++;
		}// End while
	}// End merge