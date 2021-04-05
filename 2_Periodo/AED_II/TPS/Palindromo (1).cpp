#include <stdio.h>
#include <stdbool.h>
#include <string.h>
bool igual(char* str);
bool palindromo(char* str);
bool isPalindromo(char* str,int i,int j,bool resp);
/**
 * Palindromo
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
int main(){
	char str[10000];
	for(scanf("%[^\n]\n",str);!igual(str);scanf("%[^\n]\n",str)){
		bool resp = palindromo(str);
		if(resp == true){
			printf("SIM\n");
		}// End if
		else{
			printf("NAO\n");
		}// End else
		//setbuf(stdin, NULL);
	}// End for
	return 0;
}// End main()
/**
 * Função que retorna o valor retornado
 * na função recursiva
 * @return true ou false
 */
bool palindromo(char* str){
	return isPalindromo(str,0,strlen(str)-1,false);
}// End bool

/**
 * Função recursiva que verifica se é um 
 * palindromo ou não.
 * @return true caso seja um palindromo
 * false caso não seja
 */
bool isPalindromo(char* str,int i,int j,bool resp){
	if(i < j && j > i){
		if(str[i] == str[j]){
			resp = true;
			resp = isPalindromo(str,i+1,j-1,resp);
		}// End if
		else{
			return false;
		}// End else
	}// End if
	return resp;
}// End ehPalindromo()

/**
 * Verifica se é a string que está como
 * parametro é igual a string "FIM".
 * @return true caso seja igual
 * false caso contrário
 */
bool igual(char str[]){
	bool resp = false;
	if(strlen(str) == 3){
		if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
			resp = true;
		}// End if
		else{
			return false;
		}// End else
	}// End if
		else{
			return false;
		}// End else	
		return resp;
}// End igual()
