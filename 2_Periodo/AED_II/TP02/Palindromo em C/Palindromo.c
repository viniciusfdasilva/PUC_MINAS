#include <stdio.h>
#include <stdbool.h>
#include <string.h>
bool igual(char* str);
bool Palindromo(char* str);
bool isPalindromo(char* str,int i,int j,bool resp);
int main(){
	char str[10000];
	for(scanf("%[^\n]\n",str);!igual(str);scanf("%[^\n]\n",str)){
		bool resp = Palindromo(str);
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

bool Palindromo(char* str){
	return isPalindromo(str,0,strlen(str)-1,false);
}// End bool

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
