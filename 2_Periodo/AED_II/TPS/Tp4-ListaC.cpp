/**
 * Serie
 * @author Vinicius Francisco da Silva
 * @version 1 10/2017
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
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
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#define MAXTAM   10000

Serie* array[MAXTAM];   // Elementos da pilha 
int n;              // Quantidade de array.

/**
 * Inicializacoes
 */
void start(){
   n = 0;
}// End start()

/**
 * Insere um elemento na primeira posicao da lista e move os demais
 * elementos para o fim da 
 * @param x int elemento a ser inserido.
 */
void inserirInicio(Serie* x){
   int i;
   //validar insercao
   if(n >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   }// End if
   //levar elementos para o fim do array
   for(i = n; i > 0; i--){
      array[i] = array[i-1];
   }// End for
   array[0] = x;
   n++;
}// End inserirInicio()

/**
 * Insere um elemento na ultima posicao da 
 * @param x int elemento a ser inserido.
 */
void inserirFim(Serie* x){
   //validar insercao
   if(n >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   }// End if
   array[n] = x;
   n++;
}// End inserirFim()

/**
 * Insere um elemento em uma posicao especifica e move os demais
 * elementos para o fim da 
 * @param x int elemento a ser inserido.
 * @param pos Posicao de insercao.
 */
void inserir(Serie* x, int pos){
   int i;
   //validar insercao
   if(n >= MAXTAM || pos < 0 || pos > n){
      printf("Erro ao inserir!");
      exit(1);
   }// End if
   //levar elementos para o fim do array
   for(i = n; i > pos; i--){
      array[i] = array[i-1];
   }// End for
   array[pos] = x;
   n++;
}// End inserir()

/**
 * Remove um elemento da primeira posicao da lista e movimenta 
 * os demais elementos para o inicio da mesma.
 * @return resp int elemento a ser removido.
 */
Serie* removerInicio(){
   int i; 
   Serie* resp;
   //validar remocao
   if (n == 0) {
      printf("Erro ao remover!");
      exit(1);
   }// End if
   resp = array[0];
   n--;
   for(i = 0; i < n; i++){
      array[i] = array[i+1];
   }// End for
   return resp;
}// End removerInicio()

/**
 * Remove um elemento da ultima posicao da 
 * @return resp int elemento a ser removido.
 */
Serie* removerFim(){
   //validar remocao
   if (n == 0) {
      printf("Erro ao remover!");
      exit(1);
   }// End if
   return array[--n];
}// End removerFim()

/**
 * Remove um elemento de uma posicao especifica da lista e 
 * movimenta os demais elementos para o inicio da mesma.
 * @param pos Posicao de remocao.
 * @return resp int elemento a ser removido.
 */
Serie* remover(int pos){
   int i;
   Serie* resp;
   //validar remocao
   if (n == 0 || pos < 0 || pos >= n) {
      printf("Erro ao remover!");
      exit(1);
   }// End remover()
   resp = array[pos];
   n--;
   for(i = pos; i < n; i++){
      array[i] = array[i+1];
   }// End for
   return resp;
}// End remover()

/**
 * Mostra os array separados por espacos.
 */
void mostrar(){
   for(int i = 0; i < n; i++){
      imprimir(array[i]);
   }// End for
}// End mostrar()

/**
 * Procura um array e retorna se ele existe.
 * @param x int elemento a ser pesquisado.
 * @return <code>true</code> se o array existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(Serie* x){
   bool retorno = false;
   int i;
   for(i = 0; i < n && retorno == false; i++){
      retorno = (array[i] == x);
   }// End for
   return retorno;
}// End pesquisar()

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
      inserirFim(serie[i]);
      i++;
   }// End for
   	scanf("%[^\n]\n",str); 
	quantidade = atoi(str);
	i = 0;
	while(i < quantidade){
		scanf("%s",line);
		if(strcmp(line,"II") == 0){
			scanf("%s",line);
			s = serieStart();
			ler(s,line);
			inserirInicio(s);
		}// End if
		else if(strcmp(line,"IF") == 0){
			scanf("%s",line);
			s = serieStart();
			ler(s,line);
			inserirFim(s);
		}// End if
		else if(strcmp(line,"I*") == 0){
			scanf("%s",line);
			pos = atoi(line);
			scanf("%s",line);
			s = serieStart();
			ler(s,line);
			inserir(s,pos);
		}// End else if
		else if(strcmp(line,"RI") == 0){
			s = serieStart();
			s = removerInicio();
			printf("(R) " "%s\n",s->nome);
		}// End else if
		else if(strcmp(line,"RF") == 0){
			s = serieStart();
			s = removerFim();
			printf("(R) " "%s\n",s->nome);
		}// End else if
		else if(strcmp(line,"R*") == 0){
				scanf("%s\n",line);
				pos = atoi(line);
				s = serieStart();
				s = remover(pos);
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
