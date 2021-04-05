#include "Serie"
static bool equals(char* str);
int main(){
   int i = 0;
   const int tamanho = 1000;
   Serie* serie[1000]; 
   char str[tamanho]; 
   char line[tamanho];
   for(scanf("%[^\n]\n",str); !equals(str); scanf("%[^\n]\n",str)){     
      serie[i] = serieStart(); 
      ler(serie[i],str);
      imprimir(serie[i]);
      i++;
   }// End for
	return 0;
}// End main()

static bool equals(char* str){
	bool resp = false;
	if((int)strlen(str) == 3){
		if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
			resp = true;
		}// End if
	}// End if
	return resp;
}// End equals()