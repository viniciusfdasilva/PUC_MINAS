import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

import java.io.FileNotFoundException;

public class LexicalAnalyzer{
    // Estados inicial e final do automato
    private final int INITIAL_STATE = 0;
    private final int FINAL_STATE = 1;

    // Final do Source File
    private final int EOF = -1;

    private SymbolTable symbolTable;
    private FileReader source;
    private BufferedReader bufferedReader;

    private int line;

    public LexicalAnalyzer(){ }// End LexicalAnalyzer

    public LexicalAnalyzer(BufferedReader source) throws FileNotFoundException{
        this.bufferedReader = source;
        this.symbolTable = new SymbolTable();
        this.line = 1;
    }// End LexicalAnalyer()
    
    public LexicalAnalyzer(FileReader source) throws FileNotFoundException{
        this.source = source;
        this.bufferedReader = new BufferedReader(this.source);
        this.symbolTable = new SymbolTable();
        this.line = 1;
    }// End LexicalAnalyer()

    public int getLine(){
        return this.line;
    }// End getLine()

    public boolean isToken(String token){
        boolean resp = false;
        if(token.matches("const")
        || token.matches("else")
        || token.matches("\\(")
        || token.matches("<=")
        || token.matches(";")
        || token.matches("write")
        || token.matches("integer")
        || token.matches("and")
        || token.matches("\\)")
        || token.matches(",")
        || token.matches("begin")
        || token.matches("writeln")
        || token.matches("byte")
        || token.matches("or")
        || token.matches("<")
        || token.matches("\\+")
        || token.matches("end")
        || token.matches("true")
        || token.matches("string")
        || token.matches("not")
        || token.matches(">")
        || token.matches("-")
        || token.matches("then")
        || token.matches("false")
        || token.matches("while")
        || token.matches("=")
        || token.matches("!=")
        || token.matches("\\*")
        || token.matches("readln")
        || token.matches("boolean")
        || token.matches("if")
        || token.matches("==")
        || token.matches(">=")
        || token.matches("/")
        || token.matches("main")
        || token.matches("EOF")){
            resp = true;
        }// End if
        return resp;
    }// End isToken

    public boolean isLexeme(String lexeme,char chr){
        boolean resp = false;
        if(lexeme.matches("[a-z]") 
            || lexeme.matches("[A-Z]")
            || lexeme.matches("[0-9]")
            || lexeme.matches("_")
            || lexeme.matches(",")
            || lexeme.matches(";")
            || lexeme.matches("/")
            || lexeme.matches("!")
            || lexeme.matches("\\*")
            || lexeme.matches("\\(")
            || lexeme.matches("\\)")
            || lexeme.matches("\\+")
            || lexeme.matches("-")
            || lexeme.matches("'")
            || lexeme.matches(">")
            || lexeme.matches(":")
            || lexeme.matches("<")
            || lexeme.matches("=")
            || lexeme.matches("\\$")
            || lexeme.matches("\\s")
            || lexeme.matches("\\r") || chr == '\r'            
            || lexeme.matches("\\n") || chr == '\n'){
                resp = true;
        }// End if   
        return resp;
    }// End isLexema()

    
    public Symbol analiseLexica(){
        int s = INITIAL_STATE;
        int read;
        String c = "";  
        String lexeme = "";

        Symbol tok = null;
        char chr = ' ';
        	
        try{
            while(s != FINAL_STATE){
               if((read = this.bufferedReader.read()) != EOF){
                   chr = (char)read; 
                   c = (chr + "").toLowerCase();

                   if(!isLexeme(c,chr)){
                     throw new Failed(this.line+ ":caractere invalido. " + c);
                   }// End if
                }else if((read = this.bufferedReader.read()) == EOF){
                    if(s != 0){
                        throw new Failed(this.line+ ":fim de arquivo nao esperado.");     
                    }else{
                        return action("EOF");
                    }// End else
                }// End else
           
                switch(s){
                    case 0: 
                        if(c.matches("/")){
                            lexeme += c;
                            s = 13;
                        }else if(c.matches(">")){
                            lexeme += c;
                            s = 2;
                        }else if(c.matches("=")){
                            lexeme += c;
                            s = 6;
                        }else if(c.matches("!")){
                            lexeme += c;
                            s = 3;
                        }else if(c.matches("<")){
                            lexeme += c;
                            s = 4;
                        }else if(c.matches("[a-z]|[A-Z]")){
                            lexeme += c;
                            s = 16;
                        }else if(c.matches("_")){
                            lexeme += c;
                            s = 17;
                        }else if(c.matches("'")){
                            lexeme += c;
                            s = 19;
                        }else if(c.matches("[\\(|;|\\)|\\+|\\*|,]")){
                            lexeme += c;
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }else if(c.matches("F")){
                            lexeme += c;
                            s = 9;
                        }else if(c.matches("-")){
                            lexeme += c;
                            s = 24;
                        }else if(c.matches("[1-9]")){
                            lexeme += c;
                            s = 18;
                        }else if(c.matches("0")){
                            lexeme += c;
                            s = 5;
                        }else if(c.matches("\\n") || chr == '\n' || chr == 11){
                            this.line++;
                        }else if(!c.matches("[\\r\\t\\s]")){
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }else if(isToken(c)){
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else if
                        break;
                    case 2:
                        if(c.matches("=")){
                            lexeme += c;
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }else if(isToken(c)){
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }else{
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }// End else
                        break;
                    case 3:
                        if(c.matches("=")){
                            lexeme += c;
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 4:
                        if(c.matches("=")){
                            lexeme += c;
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }else if(isToken(c)){
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }else{
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }// End else
                        break;
                    case 5:
                        if(c.matches("h")){
                            lexeme += c;
                            s = 7;
                        }else if(c.matches("D")){
                            lexeme += c;
                            s = 11;
                        }else if(c.matches("A")){
                            lexeme += c;
                            s = 12;
                        }else if(c.matches("[0-9]")){
                            lexeme += c;
                            s = 18;
                        }else if(c.matches(";")){
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme + " constante");

                            lexeme = c;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 6:
                        if(c.matches("=")){
                            lexeme += c;
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }else if(isToken(c)){
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }else{
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }// End else
                        break; 
                    case 7:
                        if(c.matches("[A-F]|[0-9]")){
                            lexeme += c;
                            s = 8;
                        }else{
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }// End else
                        break; 
                    case 8:
                        if(c.matches("[A-F]|[0-9]")){
                            lexeme += c;
                            s = 1;
                            System.out.println(lexeme + " constant");
                            tok = action("constant");
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;  
                    case 9:
                        if(c.matches("F")){
                            lexeme += c;
                            s = 10;
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 10:
                        if(c.matches("h")){
                            lexeme += c;
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 11:
                        if(c.matches("h")){
                            lexeme += c;
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 12:
                        if(c.matches("h")){
                            lexeme += c;
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 13:
                        if(c.matches("\\*")){
                            lexeme = "";
                            s = 15;
                        }else{
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }// End else
                        break;
                    case 14:
                        if(c.matches("/")){
                            s = 0;
                        }else{
                            s = 15;
                        }// End else
                        break;
                    case 15:
                        if(c.matches("\\*")){
                            s = 14;
                        }else{
                            s = 15;
                        }// End else
                        break;
                    case 16:
                        if(c.matches("[A-Z]|[a-z]|[0-9]|_")){
                            lexeme += c;
                            s = 16;
                            }else if(isToken(c)){
                                System.out.println(lexeme); 
                                tok = action(lexeme);
                                
                                s = 1;

                                lexeme = c;
                                System.out.println(lexeme); 
                                tok = action(lexeme);
                            }else{
                            s = 1;
                            System.out.println(lexeme); 
                            tok = action(lexeme); 
                        }// End else
                        break;
                    case 17:
                        if(c.matches("[A-Z]|[a-z]|[0-9]")){
                            lexeme += c;
                            s = 16;
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 18:
                        if(c.matches("[0-9]")){
                            lexeme += c;
                            s = 18;
                        }else if(c.matches(";")){
                            s = 1;
                            System.out.println(lexeme + " constant");
                            tok = action("constant");

                            lexeme = c;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }else{
                            s = 1;
                            System.out.println(lexeme + " constant");
                            tok = action("constant");
                        }// End else
                        break;
                    case 19:
                        if(c.matches("'")){
                            lexeme += c;
                            s = 20;
                        }else if(!c.matches("\n")){
                            lexeme += c;
                            s = 19;
                        }else if(!c.matches("\\$")){
                            lexeme += c;
                            s = 19;
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 20:
                        if(c.matches("'")){
                            lexeme += c;
                            s = 21;
                        }else if(isToken(c)){
                            System.out.println(lexeme); 
                            tok = action(lexeme);
                            
                            s = 1;

                            lexeme = c;
                            System.out.println(lexeme); 
                            tok = action(lexeme);
                        }else{
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }// End else

                        break;
                    case 21:
                        if(c.matches("'")){
                            lexeme += c;
                            s = 22;
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 22:
                        if(c.matches("'")){
                            lexeme += c;
                            s = 23;
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 23:
                        if(c.matches("'")){
                            lexeme += c;
                            s = 19;
                        }else{
                            throw new Failed(this.line + ":lexema nao identificado [" + (lexeme + c) + "]");
                        }// End else
                        break;
                    case 24:
                        if(c.matches("[0-9]")){
                            lexeme += c;
                            s = 18;
                        }else{
                            s = 1;
                            System.out.println(lexeme);
                            tok = action(lexeme);
                        }// End else
                        break;   
                    default : return tok;    
                }// End switch
            }// End while
        }catch(IOException e){
            e.printStackTrace();
        }// End catch
        return tok;
    }// End analiseLexica()

    private Symbol action(String lexeme){
        Symbol token, symbol;
        if(lexeme.equals("constant")){
            symbol = new Symbol(null,"constant");
        }else{
            token = symbolTable.pesquisaLex(lexeme);
            if(token == null){
                symbol = symbolTable.pesquisaLex(lexeme);
            }else{
                symbol = token;
            }// End else
        }// End else
        return symbol;
    }// End action()
}// End LexicalAnalyzer