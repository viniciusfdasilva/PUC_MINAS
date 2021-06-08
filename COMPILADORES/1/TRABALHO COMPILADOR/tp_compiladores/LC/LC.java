import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.ArrayIndexOutOfBoundsException;

public class LC{
    static SymbolTable symbolTable;
    public static void main(String[] args){
        try{  
            LexicalAnalyzer lexical = new LexicalAnalyzer(new FileReader(args[0]));
            AnaliseSintatica sintatica = new AnaliseSintatica(lexical);
            String token = "";
            do{  
                Symbol s = lexical.analiseLexica();
                if(s != null){ 
                    token = s.getLexema();
                    sintatica.setToken(token);
                    sintatica.procedureS();
                }// End if
            }while(!token.equals("EOF"));
        }catch(FileNotFoundException | ArrayIndexOutOfBoundsException e){
            System.out.println("Arquivo não encontrado ou arquivo fonte não informado!");
        }// End catch
    }// End main()
}// End LC