#include <stdio.h>
#include <stdlib.h>
/**
 * Arquivo em C
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
void arquivo(int n,FILE* file);
int main(){
	int n;
	FILE* file;
	scanf("%i",&n);
	arquivo(n,file);
	return 0;
}// End main()

/*
     * função escreve n valores em um arquivo
     * fecha o mesmo e realiza a leitura do final do
     * arquivo até o inicio
     * @param int n com a quantidade de valores a serem
     * lido, ponteiro do tipo FILE que está
     * apontando para o endereço onde está localizado o 
     * arquivo
     * @return void
     */
void arquivo(int n,FILE* file){
	file = fopen("outarq","wb+");
	double dbe;
	double dbl;
	for(int i = 0;i < n;i++){
		scanf("%lf",&dbe);
		fwrite(&dbe,sizeof(double),1,file); 
	}// End for 
	fclose(file);
	file = fopen("outarq","rb+");
	n--;	
	while(n >= 0){
		fseek(file,n*sizeof(double),SEEK_SET);
		fread(&dbl,sizeof(double),1,file);
		if(dbl - (int)dbl == 0){
			printf("%i\n",(int)dbl);		
		}// End if
		else{
			printf("%g\n",dbl);
		}// End else
		n--;
	}// End while
	fclose(file);
}// end arquivo()