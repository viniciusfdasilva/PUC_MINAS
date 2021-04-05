/**
 * Serie
 * @author Vinicius Francisco da Silva
 * @version 1 10/2017
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <err.h>
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

/**
 * Simula um construtor criando um ponteiro
 * e setando valores vazios as variáveis
 * da struct
 * @param void
 * @return Serie*
 */
Serie* serieStart(){
	Serie* serie = (Serie*)malloc(sizeof(Serie));
	serie->nome = NULL;
	serie->formato = NULL;
	serie->duracao = NULL;
	serie->pais = NULL;
	serie->idioma = NULL;
	serie->emissora = NULL;
	serie->temporadas = 0;
	serie->episodios = 0;
	return serie;
}// End serieStart()*

/**
 * Simula um construtor criando um ponteiro
 * e setando valores as variáveis
 * da struct
 * @param char* e int
 * @return Serie*
 */	
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

/**
 * imprime os valores da serie
 * da struct em que o ponteiro
 * possui o endereço
 * @param Serie*
 * @return void
 */	
void imprimir(Serie* serie){
	printf("%s %s %s %s %s %s %s %d %d\n",serie->nome,serie->formato,serie->duracao,serie->pais,serie->idioma,serie->emissora,serie->transmissao,serie->temporadas,serie->episodios);
}// End imprimir()

/**
 * função que ignora os valores
 * que estão entre os índices i e j
 * @param char* int
 * @return char* com os caracteres fora
 * do índice
 */	
char* replace(char* str,int i, int j){
	int c = 0;
	char* tmp = (char*)malloc(10000*sizeof(char));
	for(int k = 0; k < (int)strlen(str); k++){
		bool resp = k >= i && k <= j ? true : false;
		if(!resp){
			tmp[c] = str[k];
			c++;
		}// End if
	}// End for
	return tmp;
}// End replace()

/**
 * função que retorna o índice da primeira
 * ocorrencia do open tag na cadeia de catacter
 * @param char*
 * @return int
 */	
int indexOffOpenTag(char* str){
	int i = 0;
	while(str[i] != '<' && i < (int)strlen(str)) i++;
	if(str[i] == '<') return i;
	else return -1;
}// End indexOffAbreTag() 

/**
 * função que retorna o índice da primeira
 * ocorrencia do close tag na cadeia de catacter
 * @param char*
 * @return int
 */	
int indexOffCloseTag(char* str){
	int i = 0;
	while(str[i] != '>' && i < (int)strlen(str)) i++;
	if(str[i] == '>') return i;
	else return -1;
}// End indexOffCloseTag() 

/**
 * remove tudo que estiver entre as tags
 * @param char*
 * @return char*
 */	
char* removeTag(char* str){
	int i = 0;
	int j = 0;
	for(i = indexOffOpenTag(str),j = indexOffCloseTag(str); i >= 0 && j >= 0; i = indexOffOpenTag(str),j = indexOffCloseTag(str)){
		str = replace(str,i,j);		
	}// End for
	return str;
}// End removeTag()

/**
 * remove a extensão .html da cadeia de caracter
 * @param char*
 * @return char*
 */	
char* removeExtensao(char* str){
	char* change = (char*)malloc(100*sizeof(char));
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

/**
 * função que concatena a String line1 com a 
 * String line2
 * @param char*
 * @return char*
 */
char* strconcat(char* line1,char* line2){
	char* line = (char*)malloc(100*sizeof(char));
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

/**
 * função que concatena a String line1 com a 
 * String line2
 * @param char*
 * @return char*
 */
char* substring(char* line,int i,int j){
	int k = 0;
	char* str = (char*)malloc(100*sizeof(char));
	while(i <= j){
		str[k] = line[i];
		i++;
		k++;
	}// End while
	return str;
}// End substring()

/*
* função que pesquisa se existe a String 
* &#160; ou &nbsp; na String str e remove
* estes elementos da mesma e retorna a String str
* @param char*
* @return char*
*/
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
* função que remove os espaços em branco
* do início e do fim da String
* @param char*
* @return char*
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

/*
* função que remove o underline da String str
* @param char*
* @return char*
*/
char* removeUnderline(char* str){
    for(int i = 0; i < (int)strlen(str); i++){
        if(str[i] == '_'){
            str[i] = ' ';
        }// End if
    }// End for
    return str;
}// End removeUnderline()

/*
* função que pega o que existe na String str
* entre as posições 0 1 2 e 3
* @param char*
* @return char*
*/
char* getNumber(char* string){
    char* str = (char*)malloc(3*sizeof(char));
    str[0] = string[0];
    str[1] = string[1];
    str[2] = string[2];
   	return str;
}// End getNumber()

/*
* função que abre os arquivos html 
* abre e faz a leitura dos mesmos
* mineirando os dados e setando as
* informações nas variáveis da struct
* @param char* Serie*
* @return void
*/
void ler(Serie* serie,char* str){
	char diretorio[100] = "/tmp/";
	char* caminho = strconcat(diretorio,str);		
	FILE* file = fopen(caminho,"r");
	if(file == NULL){
		printf("erro na leitura do arquivo\n");
		system("pause");
	}// End if
	char* line = (char*)malloc(100000*sizeof(char));
	char* resp = (char*)malloc(10000*sizeof(char));
	char* linha = (char*)malloc(10000*sizeof(char));
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

/**
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
//====TIPO CELULA =====
typedef struct Celula {
	Serie* elemento;        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

Celula* novaCelula(Serie* elemento){
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}// End novaCelula()

//PILHA PROPRIAMENTE DITA
Celula* topo; // Sem celula cabeca.

/**
 * Cria uma fila sem elementos.
 */
void start(){
   topo = NULL;
}// End start()

/**
 * Insere elemento na pilha (politica FILO).
 * @param x int elemento a inserir.
 */
void inserir(Serie* x){
   Celula* tmp = novaCelula(x);
   tmp->prox = topo;
   topo = tmp;
   tmp = NULL;
}// End inserir()

/**
 * Remove elemento da pilha (politica FILO).
 * @return Elemento removido.
 */
Serie* remover(){
   if (topo == NULL){
      errx(1, "Erro ao remover!");
   }// End remover()
   Serie* resp = topo->elemento;
   Celula* tmp = topo;
   topo = topo->prox;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}// End remover()

/**
 * Mostra os elementos separados por espacos, comecando do topo.
 */
void mostrar(){
   Celula* i;
   for(i = topo; i != NULL; i = i->prox) {
      imprimir(i->elemento);
   }// End for
}// End mostrar()

static bool equals(char* str);
int main(){
   int i = 0;
   const int tamanho = 1000;
   Serie* serie[1000]; 
   char str[tamanho]; 
   char line[tamanho];
   int quantidade = 0;
   int pos = 0;
   Serie* s = NULL;
   start();
   for(scanf("%[^\n]\n",str); !equals(str); scanf("%[^\n]\n",str)){     
      serie[i] = serieStart(); 
      ler(serie[i],str);
      inserir(serie[i]);
      i++;
   }// End for
   	scanf("%[^\n]\n",str); 
	quantidade = atoi(str);
	i = 0;
	while(i < quantidade){
		scanf("%s",line);
		if(strcmp(line,"I") == 0){
			scanf("%s",line);
			s = serieStart();
			ler(s,line);
			inserir(s);
		}// End else if
		else if(strcmp(line,"R") == 0){
			s = serieStart();
			s = remover();
			printf("(R) " "%s\n",s->nome);
		}// End else if
		else exit(1);
		i++;
	}// End while
	mostrar();
	return 0;
}// End main()

/**
 * Recebe uma String e compara se a mesma é
 * igual a String FIM
 * @param char*
 * @return bool
 */
static bool equals(char* str){
	bool resp = false;
	if((int)strlen(str) == 3){
		if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
			resp = true;
		}// End if
	}// End if
	return resp;
}// End equals()

