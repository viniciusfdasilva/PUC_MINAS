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
 * Lista dupla dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
//TIPO CELULA ==============
typedef struct CelulaDupla{
	Serie* elemento;        // Elemento inserido na celula.
	struct CelulaDupla* prox; // Aponta a celula prox.
   struct CelulaDupla* ant;  // Aponta a celula anterior.
}CelulaDupla;

CelulaDupla* novaCelulaDupla(Serie* elemento) {
   CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
   nova->elemento = elemento;
   nova->ant = nova->prox = NULL;
   return nova;
}// End novaCelulaDupla

//LISTA PROPRIAMENTE DITA
CelulaDupla* primeiro;
CelulaDupla* ultimo;

/**
 * Cria uma lista dupla sem elementos (somente no cabeca).
 */
void start(){
   primeiro = novaCelulaDupla(NULL);
   ultimo = primeiro;
}// End start()

/**
 * Insere um elemento na primeira posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirInicio(Serie* x){
   CelulaDupla* tmp = novaCelulaDupla(x);
   tmp->ant = primeiro;
   tmp->prox = primeiro->prox;
   primeiro->prox = tmp;
   if (primeiro == ultimo) {                    
      ultimo = tmp;
   }// End if 
   else{
      tmp->prox->ant = tmp;
   }// End else
   tmp = NULL;
}// End inserirInicio()

/**
 * Insere um elemento na ultima posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirFim(Serie* x){
   ultimo->prox = novaCelulaDupla(x);
   ultimo->prox->ant = ultimo;
   ultimo = ultimo->prox;
}// End inserirFim()

/**
 * Remove um elemento da primeira posicao da lista.
 * @return resp int elemento a ser removido.
 */
Serie* removerInicio(){
   if (primeiro == ultimo){
      errx(1, "Erro ao remover (vazia)!");
   }// End if
   CelulaDupla* tmp = primeiro;
   primeiro = primeiro->prox;
   Serie* resp = primeiro->elemento;
   tmp->prox = primeiro->ant = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}// End remover()

/**
 * Remove um elemento da ultima posicao da lista.
 * @return resp int elemento a ser removido.
 */
Serie* removerFim(){
   if(primeiro == ultimo){
      errx(1, "Erro ao remover (vazia)!");
   }// End if 
   Serie* resp = ultimo->elemento;
   ultimo = ultimo->ant;
   ultimo->prox->ant = NULL;
   free(ultimo->prox);
   ultimo->prox = NULL;
   return resp;
}// End removerFim()

/**
 *  Calcula e retorna o tamanho, em numero de elementos, da lista.
 *  @return resp int tamanho
 */
int tamanho(){
   int tamanho = 0;
   for(CelulaDupla* i = primeiro; i != ultimo; i = i->prox, tamanho++);
   return tamanho;
}// End tamanho()

/**
 * Insere um elemento em uma posicao especifica considerando que o 
 * primeiro elemento valido esta na posicao 0.
 * @param x int elemento a ser inserido.
 * @param pos int posicao da insercao.
 * @throws Exception Se <code>posicao</code> invalida.
 */
void inserir(Serie* x, int pos){
   int tam = tamanho();
   if(pos < 0 || pos > tam){
      errx(1,"Erro ao remover (posicao %d/%d invalida!", pos, tam);
   }// End if 
   else if(pos == 0){
      inserirInicio(x);
   }// End else if 
   else if(pos == tam){
      inserirFim(x);
   }// End else 
   else{
      // Caminhar ate a posicao anterior a insercao
      CelulaDupla* i = primeiro;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);
      CelulaDupla* tmp = novaCelulaDupla(x);
      tmp->ant = i;
      tmp->prox = i->prox;
      tmp->ant->prox = tmp->prox->ant = tmp;
      tmp = i = NULL;
   }// End else
}// End inserir()

/**
 * Remove um elemento de uma posicao especifica da lista
 * considerando que o primeiro elemento valido esta na posicao 0.
 * @param posicao Meio da remocao.
 * @return resp int elemento a ser removido.
 * @throws Exception Se <code>posicao</code> invalida.
 */
Serie* remover(int pos){
   Serie* resp;
   int tam = tamanho();
   if(primeiro == ultimo){
      errx(1, "Erro ao remover (vazia)!");
   }// End if 
   else if(pos < 0 || pos >= tam){
      errx(1, "Erro ao remover (posicao %d/%d invalida!", pos, tam);
   }// End else if 
   else if(pos == 0){
      resp = removerInicio();
   }// End else if 
   else if(pos == tam - 1){
      resp = removerFim();
   }// End else if 
   else{
      // Caminhar ate a posicao anterior a insercao
      CelulaDupla* i = primeiro->prox;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);
      i->ant->prox = i->prox;
      i->prox->ant = i->ant;
      resp = i->elemento;
      i->prox = i->ant = NULL;
      free(i);
      i = NULL;
   }// End else
   return resp;
}// End remover()

/**
 * Mostra os elementos da lista separados por espacos.
 */
void mostrar(){
   CelulaDupla* i;
   for (i = primeiro->prox; i != NULL; i = i->prox) {
      imprimir(i->elemento);
   }// End for
}// End mostrar()

/**
 * Mostra os elementos da lista de forma invertida 
 * e separados por espacos.
 */
void mostrarInverso(){
   CelulaDupla* i;
   for (i = ultimo; i != primeiro; i = i->ant){
      imprimir(i->elemento);
   }// End for
}// End mostrarInverso()

/**
 * Procura um elemento e retorna se ele existe.
 * @param x Elemento a pesquisar.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(Serie* x){
   bool resp = false;
   CelulaDupla* i;
   for(i = primeiro->prox; i != NULL; i = i->prox){
      if(i->elemento == x){
         resp = true;
         i = ultimo;
      }// End if
   }// End for
   return resp;
}// End pesquisar()

CelulaDupla* getMeio(int esq,int dir){
   int cont = 0;
   CelulaDupla* i = primeiro->prox;
   while(cont < (int)((esq+dir)/2)){
      i = i->prox;
      cont++;
   }// End while
   return i;
}// End getMeio() 

void quicksortRecNome(CelulaDupla* esq,CelulaDupla* dir,int begin,int end){
   // Criando as referencias de ponteiro para o inicio e final da estrutura
   CelulaDupla* i = esq; 
   CelulaDupla* j = dir;
   //Criando referencias inteiras de um ponteiro para o inicio e final da estrutura
   int inicio = begin;
   int fim = end;
   Serie* pivo = getMeio(begin,end)->elemento;
   while(inicio <= fim){
      while(strcmp(i->elemento->nome,pivo->nome) > 0){ 
         i = i->prox;
         inicio++;
      }// End while
      while(strcmp(j->elemento->nome,pivo->nome) < 0){ 
         j = j->ant;
         fim--;
      }// End while
      if(inicio <= fim){
      	 void swap(CelulaDupla* i, CelulaDupla* j);
         swap(i,j);
         i = i->prox;
         j = j->ant;
         inicio++;
         fim--;
      }// End if
   }// End while
   if (begin < fim) quicksortRecNome(esq,j,begin,fim);
   if (inicio < end) quicksortRecNome(i,dir,inicio,end);
}// End quicksortRecNome()

void quicksortPais(){
   void quicksortRecPais(CelulaDupla* esq,CelulaDupla* dir,int begin,int end);   
   quicksortRecPais(primeiro->prox,ultimo,0,tamanho()-1);
}// End quicksortPais

void quicksortRecPais(CelulaDupla* esq,CelulaDupla* dir,int begin,int end){
   // Criando as referencias de ponteiro para o inicio e final da estrutura
   CelulaDupla* i = esq; 
   CelulaDupla* j = dir;
   //Criando referencias inteiras de um ponteiro para o inicio e final da estrutura
   int inicio = begin;
   int fim = end;
   quicksortRecNome(esq,dir,begin,end);
   Serie* pivo = getMeio(begin,end)->elemento;
   while(inicio <= fim){
      while(strcmp(i->elemento->pais,pivo->pais) < 0){ 
         i = i->prox;
         inicio++;
      }// End while
      while(strcmp(j->elemento->pais,pivo->pais) > 0){ 
         j = j->ant;
         fim--;
      }// End while
      if(inicio <= fim){
      	 void swap(CelulaDupla* i, CelulaDupla* j);
         swap(i,j);
         i = i->prox;
         j = j->ant;
         inicio++;
         fim--;
      }// End if
   }// End while
   if (begin < fim) quicksortRecPais(esq,j,begin,fim);
   if (inicio < end) quicksortRecPais(i,dir,inicio,end);
}// End quicksort()

/**
   * Troca o conteudo de duas posicoes do array
   * @param i int primeira posicao
   * @param j int segunda posicao
   */
void swap(CelulaDupla* i, CelulaDupla* j){
	Serie* temp = i->elemento;
    i->elemento = j->elemento;
    j->elemento = temp;
}// End swap()

static bool equals(char* str);
int main(){
   int i = 0;
   const int tamanho = 1000;
   Serie* serie[1000]; 
   char str[tamanho]; 
   char line[tamanho];
   start();
   for(scanf("%[^\n]\n",str); !equals(str); scanf("%[^\n]\n",str)){     
      serie[i] = serieStart(); 
      ler(serie[i],str);
      inserirFim(serie[i]);
      i++;
   }// End for
   quicksortPais();
   mostrar();
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