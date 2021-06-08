import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class AnaliseSintatica{
    LexicalAnalyzer lexico;
    SymbolTable tabela;
	Symbol s;
	BufferedReader arquivo;
	String token;

	public AnaliseSintatica(LexicalAnalyzer lexico){
		this.lexico = lexico;
	}// End AnaliseSintatica()
    
    public AnaliseSintatica(BufferedReader arquivo){
        try{   
            this.arquivo = arquivo;
            lexico = new LexicalAnalyzer(arquivo);
            tabela = new SymbolTable();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }// End catch    
	}// End AnaliseSintatica()
	
	public void setToken(String token){
		this.token = token;
	}// End setToken()

	public String getToken(){
		return this.token;
	}// End getToken()

    public void casaToken(byte token){
		try{
			if(s != null){
				if(s.getNumero() == token){
					s = lexico.analiseLexica();
					this.token = s.getLexema();
				}else{
					if(token == SymbolTable.EOF){
						System.err.println(lexico.getLine() + ":Fim de Arquivo não esperado.");
						System.exit(0);
					}else{
						System.err.println(lexico.getLine() + ":Token não esperado: " + s.getLexema());
						System.exit(0);
					}// End else	
				}// End else
			}// End else if
		}catch(Exception e){
			System.err.println(e.toString());
		}// End catch
	}// End casaToken()

	public void procedureS(){
		if(this.token.equals("const") ||  this.token.equals("integer") || this.token.equals("byte") || this.token.equals("boolean") || this.token.equals("string")){
			procedureDeclarar();
		}// End if

		if(this.token.equals("main")){
			casaToken(SymbolTable.MAIN);

			while(this.token.equals("const") || this.token.equals("integer") || this.token.equals("byte") || this.token.equals("boolean") || this.token.equals("string")){
				procedureDeclarar();
			}// End while

			while(token.equals("id") || token.equals("while") || token.equals("if") || token.equals("readln") || token.equals("write") || token.equals("writeln") || this.token.equals("const") || this.token.equals("integer") || this.token.equals("byte") || this.token.equals("boolean") || this.token.equals("string")){
                procedureComando();
			}// End while

			casaToken(SymbolTable.END);
		}else if(this.token.equals("EOF")) casaToken(SymbolTable.EOF);
	}// End procedureS()

	public void procedureEscrever(){
		if(this.token.equals("write")){
			casaToken(SymbolTable.WRITE);
            casaToken(SymbolTable.OPEN_PARENTHESIS);
            procedureExpressao();
            casaToken(SymbolTable.CLOSE_PARENTHESIS);
            casaToken(SymbolTable.SEMICOLON);
		}else{
			casaToken(SymbolTable.WRITELN);
			casaToken(SymbolTable.OPEN_PARENTHESIS);
			procedureExpressao();
			casaToken(SymbolTable.CLOSE_PARENTHESIS);
            casaToken(SymbolTable.SEMICOLON);
		}// End else
	}// End procedureEscrever()

	public void procedureLer(){
		if(this.token.equals("readln")){
			casaToken(SymbolTable.READLN);
			casaToken(SymbolTable.OPEN_PARENTHESIS);
			casaToken(SymbolTable.ID);
			casaToken(SymbolTable.CLOSE_PARENTHESIS);
            casaToken(SymbolTable.SEMICOLON);
		}// End if
	}// End procedureLer()

	public void procedureAtribuir(){
		casaToken(SymbolTable.ID);
		casaToken(SymbolTable.EQUAL);
		procedureExpressao();
		casaToken(SymbolTable.SEMICOLON);
	}// End procedureAtribuir()

	public void procedureListaAtribuir(){
		if(this.token.equals("const")){
			casaToken(SymbolTable.CONST);
			casaToken(SymbolTable.ID);
			casaToken(SymbolTable.EQUAL);
			casaToken(SymbolTable.VALUE);
		}else if(this.token.equals("integer")){
			casaToken(SymbolTable.INTEGER);
			casaToken(SymbolTable.ID);
			casaToken(SymbolTable.EQUAL);
			casaToken(SymbolTable.VALUE);
		}else if(this.token.equals("byte")){
			casaToken(SymbolTable.BYTE);
			casaToken(SymbolTable.ID);
			casaToken(SymbolTable.EQUAL);
			casaToken(SymbolTable.VALUE);
		}else if(this.token.equals("boolean")){
			casaToken(SymbolTable.BOOLEAN);
			casaToken(SymbolTable.ID);
			casaToken(SymbolTable.EQUAL);
			casaToken(SymbolTable.VALUE);
		}else{
			casaToken(SymbolTable.STRING);
			casaToken(SymbolTable.ID);
			casaToken(SymbolTable.EQUAL);
			casaToken(SymbolTable.VALUE);
			if(this.token.equals(",")){
				casaToken(SymbolTable.COMMA);
				casaToken(SymbolTable.ID);
				casaToken(SymbolTable.EQUAL);
				casaToken(SymbolTable.VALUE);
			}// End while
		
			casaToken(SymbolTable.SEMICOLON);
		}// End else
	}// End procedureListaAtribuir()

	public void procedureDeclarar(){
		if(this.token.equals("const")){
			casaToken(SymbolTable.CONST);
			casaToken(SymbolTable.ID);
			casaToken(SymbolTable.EQUAL);
			procedureExpressao();
			casaToken(SymbolTable.SEMICOLON);
		}else{
			procedureListaAtribuir();
		}// End else
	}// End procedureDeclarar()

	public void procedureDesvio(){
		casaToken(SymbolTable.IF);
		casaToken(SymbolTable.OPEN_PARENTHESIS);
		procedureExpressao();
		casaToken(SymbolTable.THEN);
		if(this.token.equals("begin")){
			casaToken(SymbolTable.BEGIN);
			while(token.equals("id") || token.equals("while") || token.equals("if") || token.equals("readln") || token.equals("write") || token.equals("writeln") || this.token.equals("const") || this.token.equals("integer") || this.token.equals("byte") || this.token.equals("boolean") || this.token.equals("string")){
                procedureComando();
			}// End while
			casaToken(SymbolTable.END);
		}else{
			procedureComando();
		}// End else

		if(this.token.equals("else")){
			casaToken(SymbolTable.ELSE);
			if(this.token.equals("begin")){
				casaToken(SymbolTable.BEGIN);
				while(token.equals("id") || token.equals("while") || token.equals("if") || token.equals("readln") || token.equals("write") || token.equals("writeln") || this.token.equals("const") || this.token.equals("integer") || this.token.equals("byte") || this.token.equals("boolean") || this.token.equals("string")){
					procedureComando();
				}// End while
				casaToken(SymbolTable.END);
			}else{
				procedureComando();
			}// End else
		}// End if
	}// End procedureDesvio()

	public void procedureRepetir(){
		casaToken(SymbolTable.WHILE);
		casaToken(SymbolTable.OPEN_PARENTHESIS);
		procedureExpressao();
		casaToken(SymbolTable.CLOSE_PARENTHESIS);
		if(token.equals("id") || token.equals("while") || token.equals("if") || token.equals("readln") || token.equals("write") || token.equals("writeln") || this.token.equals("const") || this.token.equals("integer") || this.token.equals("byte") || this.token.equals("boolean") || this.token.equals("string")){
			procedureComando();
		}else{
			casaToken(SymbolTable.BEGIN);
			while(token.equals("id") || token.equals("while") || token.equals("if") || token.equals("readln") || token.equals("write") || token.equals("writeln") || this.token.equals("const") || this.token.equals("integer") || this.token.equals("byte") || this.token.equals("boolean") || this.token.equals("string")){
				procedureComando();
			}// End while
			casaToken(SymbolTable.BEGIN);
		}// End else
	}// End procedureRepetir()

	public void procedureComando(){
		if(token.equals("id")){
			procedureAtribuir();
		}else if(token.equals("while")){
			procedureRepetir();
		}else if(token.equals("if")){
			procedureDesvio();
		}else if(token.equals("readln")){
			procedureLer();
		}else if(token.equals("write") || token.equals("writeln")){
			procedureEscrever();
		}else if(this.token.equals("const") || this.token.equals("integer") || this.token.equals("byte") || this.token.equals("boolean") || this.token.equals("string")){
			procedureDeclarar();
		}// End else if
	}// End procedureComando()

	public void procedureExpressao(){
		boolean relac = (this.token.equals("==")  || this.token.equals("!=") || this.token.equals("<") || this.token.equals(">") || this.token.equals("<=") || this.token.equals(">="));
		boolean arit = (this.token.equals("+")  || this.token.equals("*") || this.token.equals("/") || this.token.equals("-"));
		boolean log = (this.token.equals("not")  || this.token.equals("or") || this.token.equals("and"));
		
		if(relac){
			procedureRelacional();
		}else if(arit){
			procedureAritmetico();
		}else if(log){
			procedureLogico();
		}else if(this.token.equals("(")){
			casaToken(SymbolTable.OPEN_PARENTHESIS);
			procedureExpressao();
			casaToken(SymbolTable.CLOSE_PARENTHESIS);
		}else{
			casaToken(SymbolTable.ID);
		}// End else
	}// End procedureExpressao()

	public void procedureRelacional(){
		procedureExpressao();
			if(this.token.equals("==")){
				casaToken(SymbolTable.DOUBLE_EQUAL);
			}else if(this.token.equals("!=")){
				casaToken(SymbolTable.DIFFERENT);
			}else if(this.token.equals("<")){
				casaToken(SymbolTable.SMALLER);
			}else if(this.token.equals(">")){
				casaToken(SymbolTable.BIGGER);
			}else if(this.token.equals("<=")){
				casaToken(SymbolTable.SMALLER_EQUAL);
			}else{
				casaToken(SymbolTable.GREATER_EQUAL);
			}// End else
			procedureExpressao();
	}// End procedureRelacional()

	public void procedureAritmetico(){
		if(this.token.equals("not")){
			casaToken(SymbolTable.NOT);
			procedureExpressao();
		}else{
			procedureExpressao();
			if(this.token.equals("+")){
				casaToken(SymbolTable.ADD);
			}else if(this.token.equals("*")){
				casaToken(SymbolTable.MULT);
			}else if(this.token.equals("/")){
				casaToken(SymbolTable.BAR);
			}else{
				casaToken(SymbolTable.SUB);
			}// End else
			procedureExpressao();
		}// End else
	}// End procedureAritmetico()

	public void procedureLogico(){
		if(this.token.equals("not")){
			casaToken(SymbolTable.NOT);
			procedureExpressao();
		}else{
			procedureExpressao();
			if(this.token.equals("or")){
				casaToken(SymbolTable.OR);
			}else{
				casaToken(SymbolTable.AND);
			}// End else
			procedureExpressao();
		}// End else
	}// End procedureLogico()
}// End AnaliseSintatica