/**
 * Serie
 * @author Vinicius Francisco da Silva
 * @version 1 10/2017
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX_TAM 10000
typedef struct Serie{
	char* nome;
	char* formato; 
	char* duracao; 
	char* pais; 
	char* idioma;
	char* emissora; 
	char* transmissao;
	int temporadas;
	int episodios;
}Serie; 

Serie* serieStart(){
	Serie* serie = (Serie*)malloc(sizeof(Serie));
	serie->nome = "";
	serie->formato = "";
	serie->duracao = "";
	serie->pais = "";
	serie->idioma = "";
	serie->emissora = "";
	serie->temporadas = 0;
	serie->episodios = 0;
	return serie;
}// End serieStart()*
	
Serie* startSerie(char* nomeserie,char* formatoserie,char* duracaoserie,char* paisserie,char* idiomaserie,char* emissoraserie,int temporadasserie,int episodiosserie){
	Serie* serie = (Serie*)malloc(sizeof(Serie));
	serie->nome = nomeserie;
	serie->formato = formatoserie;
	serie->duracao = duracaoserie;
	serie->pais = paisserie;
	serie->idioma = idiomaserie;
	serie->emissora = emissoraserie;
	serie->temporadas = temporadasserie;
	serie->episodios = episodiosserie;
	return serie;
}// End startSerie()

void imprimir(Serie* serie){
	printf("%s %s %s %s %s %s %s %d %d\n",serie->nome,serie->formato,serie->duracao,serie->pais,serie->idioma,serie->emissora,serie->transmissao,serie->temporadas,serie->episodios);
}// End imprimir()

char* replace(char* str,int i, int j){
	int c = 0;
	char* tmp = (char*)malloc(MAX_TAM*sizeof(char));
	for(int k = 0; k < (int)strlen(str); k++){
		bool resp = k >= i && k <= j ? true : false;
		if(!resp){
			tmp[c] = str[k];
			c++;
		}// End if
	}// End for
	return tmp;
}// End replace()

int indexOffOpenTag(char* str){
	int i = 0;
	while(str[i] != '<' && i < (int)strlen(str)) i++;
	if(str[i] == '<') return i;
	else return -1;
}// End indexOffAbreTag() 

int indexOffCloseTag(char* str){
	int i = 0;
	while(str[i] != '>' && i < (int)strlen(str)) i++;
	if(str[i] == '>') return i;
	else return -1;
}// End indexOffCloseTag() 

char* removeTag(char* str){
	int i = 0;
	int j = 0;
	for(i = indexOffOpenTag(str),j = indexOffCloseTag(str); i >= 0 && j >= 0; i = indexOffOpenTag(str),j = indexOffCloseTag(str)){
		str = replace(str,i,j);		
	}// End for
	return str;
}// End removeTag()

char* removeExtensao(char* str){
	char* change = (char*)malloc(MAX_TAM*sizeof(char));
	int j = 0;
	for(int i = 0; i < (int)strlen(str); i++){
		if(str[i] == '.'){
			while(j < i){
				change[j] = str[j];
				j++;
			}// End while
		}// End if
	}// End for
	return change;
}// End removeExtensao()

char* strconcat(char* line1,char* line2){
	char* line = (char*)malloc(MAX_TAM*sizeof(char));
	int i = 0;
	int j = 0;
	while(i < strlen(line1)){
		line[i] = line1[i];
		i++;
	}// End while
	while(j < strlen(line2)){
		line[i] = line2[j];
		i++;
		j++;
	}// End while
	return line;
}// End strconcat()

char* substring(char* line,int i,int j){
	int k = 0;
	char* str = (char*)malloc(MAX_TAM*sizeof(char));
	while(i <= j){
		str[k] = line[i];
		i++;
		k++;
	}// End while
	return str;
}// End substring()

char* search(char* str){
	for(int i = 0; i < (int)strlen(str); i++){
		if(str[i] == '&' && strcmp(substring(str,i,i+5),"&#160;") == 0 || strcmp(substring(str,i,i+5),"&nbsp;") == 0){
			if(i+5 < (int)strlen(str)){
				str = replace(str,i,i+5);
			}// End if
		}// End if
	}// End for
	return str;
}// End search() 
	
/*
* Metodo que remove os espaço em
* branco do inicio ou do fim da
* String passada como parametro
* @param String
* @return String
*/
char* trim(char* str){
	if(str[0] == ' '){
		str = substring(str,1,(int)strlen(str));
	}// End if
	if(str[(int)strlen(str)-1] == ' '){
		str = substring(str,0,(int)strlen(str));
	}// End if
	return str;
}// End trim()

char* removeUnderline(char* str){
    for(int i = 0; i < (int)strlen(str); i++){
        if(str[i] == '_'){
            str[i] = ' ';
        }// End if
    }// End for
    return str;
}// End removeUnderline()

char* getNumber(char* string){
    char* str = (char*)malloc(3*sizeof(char));
    str[0] = string[0];
    str[1] = string[1];
    str[2] = string[2];
   	return str;
}// End getNumber()

void ler(Serie* serie,char* str){
	char diretorio[100] = "/tmp/";
	char* caminho = strconcat(diretorio,str);		
	FILE* file = fopen(caminho,"r");
	if(file == NULL){
		printf("erro na leitura do arquivo\n");
		system("pause");
	}// End if
	char* line = (char*)malloc(MAX_TAM*sizeof(char));
	char* resp = (char*)malloc(MAX_TAM*sizeof(char));
	char* linha = (char*)malloc(MAX_TAM*sizeof(char));
	str = removeExtensao(str);
	serie->nome = removeUnderline(str);
	for(fscanf(file,"%[^\n]\n",line),resp = strstr(line,">Formato</td>");resp == NULL; fscanf(file,"%[^\n]\n",line),resp = strstr(line,">Formato</td>"));
		fscanf(file,"%[^\n]\n",line);
		linha = removeTag(line);
		if(strstr(linha,"&#160;") != NULL){
			linha = search(linha);	
		}// End if
		if(strstr(linha,"&nbsp;") != NULL){
			linha = search(linha);
		}// End if
		serie->formato = trim(linha);
		fscanf(file,"%[^\n]\n",line);
	for(fscanf(file,"%[^\n]\n",line),resp = strstr(line,">Duração</td>");resp == NULL; fscanf(file,"%[^\n]\n",line),resp = strstr(line,">Duração</td>"));
		fscanf(file,"%[^\n]\n",line);
		linha = removeTag(line);
		if(strstr(linha,"&#160;") != NULL){
			linha = search(linha);	
		}// End if
		if(strstr(linha,"&nbsp;") != NULL){
			linha = search(linha);
		}// End if
		serie->duracao = trim(linha);
		fscanf(file,"%[^\n]\n",line);
	for(fscanf(file,"%[^\n]\n",line),resp = strstr(line,">País de origem</td>");resp == NULL; fscanf(file,"%[^\n]\n",line),resp = strstr(line,">País de origem</td>"));
		fscanf(file,"%[^\n]\n",line);
		linha = removeTag(line);
		if(strstr(linha,"&#160;") != NULL){
			linha = search(linha);	
		}// End if
		if(strstr(linha,"&nbsp;") != NULL){
			linha = search(linha);
		}// End if
		serie->pais = trim(linha);
		fscanf(file,"%[^\n]\n",line);
	for(fscanf(file,"%[^\n]\n",line),resp = strstr(line,">Idioma original</td>");resp == NULL; fscanf(file,"%[^\n]\n",line),resp = strstr(line,">Idioma original</td>"));
		fscanf(file,"%[^\n]\n",line);
		linha = removeTag(line);
		if(strstr(linha,"&#160;") != NULL){
			linha = search(linha);	
		}// End if
		if(strstr(linha,"&nbsp;") != NULL){
			linha = search(linha);
		}// End if
		serie->idioma = trim(linha);
		fscanf(file,"%[^\n]\n",line);
	for(fscanf(file,"%[^\n]\n",line),resp = strstr(line,">Emissora de televisão original</td>");resp == NULL; fscanf(file,"%[^\n]\n",line),resp = strstr(line,">Emissora de televisão original</td>"));
		fscanf(file,"%[^\n]\n",line);
		linha = removeTag(line);
		if(strstr(linha,"&#160;") != NULL){
			linha = search(linha);	
		}// End if
		if(strstr(linha,"&nbsp;") != NULL){
			linha = search(linha);
		}// End if
		serie->emissora = trim(linha);
		fscanf(file,"%[^\n]\n",line);
	for(fscanf(file,"%[^\n]\n",line),resp = strstr(line,">Transmissão original</td>");resp == NULL; fscanf(file,"%[^\n]\n",line),resp = strstr(line,">Transmissão original</td>"));
		fscanf(file,"%[^\n]\n",line);
		linha = removeTag(line);
		if(strstr(linha,"&#160;") != NULL){
			linha = search(linha);	
		}// End if
		if(strstr(linha,"&nbsp;") != NULL){
			linha = search(linha);
		}// End if
		serie->transmissao = trim(linha);
		fscanf(file,"%[^\n]\n",line);
	for(fscanf(file,"%[^\n]\n",line),resp = strstr(line,">N.º de temporadas</td>");resp == NULL; fscanf(file,"%[^\n]\n",line),resp = strstr(line,">N.º de temporadas</td>"));
		fscanf(file,"%[^\n]\n",line);
		linha = removeTag(line);
		if(strstr(linha,"&#160;") != NULL){
			linha = search(linha);	
		}// End if
		if(strstr(linha,"&nbsp;") != NULL){
			linha = search(linha);
		}// End if
		char* temporadas = getNumber(linha);
		serie->temporadas = atoi(temporadas);
		fscanf(file,"%[^\n]\n",line);
	for(fscanf(file,"%[^\n]\n",line),resp = strstr(line,">N.º de episódios</td>");resp == NULL; fscanf(file,"%[^\n]\n",line),resp = strstr(line,">N.º de episódios</td>"));
		fscanf(file,"%[^\n]\n",line);
		linha = removeTag(line);
		if(strstr(linha,"&#160;") != NULL){
			linha = search(linha);	
		}// End if
		if(strstr(linha,"&nbsp;") != NULL){
			linha = search(linha);
		}// End if
		char* episodios = getNumber(linha);
		serie->episodios = atoi(episodios);
}// End ler()

static bool equals(char* str);
int main(){
   int i = 0;
   Serie* serie[MAX_TAM];
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