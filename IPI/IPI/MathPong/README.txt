MathPong

INSTRU��ES

� extremamente necess�rio que a m�quina tenha instalado o Oracle DataBase XE, caso tenha come�e no 2� Passo, caso contr�rio
Come�e desde o 1� Passo.

1� Passo:

Instale um ambiente de desenvolvimento integrado (IDE), recomendamos o Oracle SQL Developer
LINK DOWNLOAD: http://www.oracle.com/technetwork/developer-tools/sql-developer/downloads/index.html

Acesse o link abaixo e instale o Oracle DataBase XE
LINK DOWNLOAD: http://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html


2� Passo:

Ap�s instalado inicie o Banco de Dados executando o startDatabase
Crie o banco passando o login e senha

3� Passo:

Crie as tabela executando os seguintes comandos abaixo

CREATE TABLE USUARIO(
	ID_ INT INCREMENT AUTO PRIMARY KEY,
	NOME_USUARIO VARCHAR(400),
	EMAIL_USUARIO VARCHAR(500)
);

CREATE TABLE RESPOSTA(
	ID_RESPOSTA INT INCREMENT AUTO PRIMARY KEY,
	ID_USUARIO INT,
	VALOR1_SOMA1 INT,
	VALOR2_SOMA1 INT,
	RESULTADO_SOMA1 INT,
        RESPOSTA_SOMA1 INT,
	VALOR1_SOMA2 INT,
	VALOR2_SOMA2 INT,
	RESULTADO_SOMA2 INT,
	RESPOSTA_SOMA2 INT,
	VALOR1_SOMA3 INT,
	VALOR2_SOMA3 INT,
        RESULTADO_SOMA3 INT,
	RESPOSTA_SOMA3 INT
); 

Para executar cada c�digo pressione as teclas Ctrl+Enter

4� Passo 
Execute o Scratch-1.0.exe
Ap�s instalado caso a tela inicial n�o tenha aberto, pesquise por Scratch e clique no programa

5� Passo
Abra o arquivo Math.exe antes da instru��o a seguir

Passe seu login e senha do banco de dados  e clique