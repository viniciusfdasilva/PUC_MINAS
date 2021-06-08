import java.util.HashMap;
import java.util.Map;

public class SymbolTable{
    private HashMap<? super CharSequence,Symbol> table;
   
     // Numero do fim de arquivo
    public static final  byte EOF = 0x00000000;
    // Numero das palavras reservadas
    public static final byte CONST = 0x00000001;
    public static final byte ELSE = 0x00000002;
    public static final byte OPEN_PARENTHESIS = 0x00000003;
    public static final byte SMALLER_EQUAL = 0x00000004;
    public static final byte SEMICOLON = 0x00000005;
    public static final byte WRITE = 0x00000006;
    public static final byte INTEGER = 0x00000007;
    public static final byte AND = 0x00000008;
    public static final byte CLOSE_PARENTHESIS = 0x00000009;
    public static final byte COMMA = 0x0000000A;
    public static final byte BEGIN = 0x0000000B;
    public static final byte WRITELN = 0x0000000C;
    public static final byte BYTE = 0x0000000D;
    public static final byte OR = 0x0000000E;
    public static final byte SMALLER = 0x0000000F;
    public static final byte ADD = 0x00000010;
    public static final byte END = 0x00000011;
    public static final byte TRUE = 0x00000012;
    public static final byte STRING = 0x00000013;
    public static final byte NOT = 0x00000014;
    public static final byte BIGGER = 0x00000015;
    public static final byte SUB = 0x00000016;
    public static final byte THEN = 0x00000017;
    public static final byte FALSE = 0x00000018;
    public static final byte WHILE = 0x00000019;
    public static final byte EQUAL = 0x0000001A;
    public static final byte DIFFERENT = 0x0000001B;
    public static final byte MULT = 0x0000001C;
    public static final byte READLN = 0x0000001D;
    public static final byte BOOLEAN = 0x0000001E;
    public static final byte IF = 0x0000001F;
    public static final byte DOUBLE_EQUAL = 0x00000020;
    public static final byte GREATER_EQUAL = 0x00000021;
    public static final byte BAR = 0x00000022;
    public static final byte MAIN = 0x00000023;
    public static final byte VALUE = 0x00000024;

    // Numero dos identificadores
    public static final byte ID = 0x00000024;
    
    // Classes de Tokens e Lexemas
    public static final String IDENTIFICADOR = "identificador";
    public static final String PALAVRAS_RESERVADAS = "palavras_reservadas";

    // Tipos de Tokens e Lexemas
    public static final String NOME_VARIAVEL = "nome_variavel";
    public static final String TIPO_DADO = "tipo_dados";
    public static final String FUNCAO_PRINCIPAL = "funcao_principal";
    public static final String ITERACAO = "iteracao";
    public static final String SELECAO = "selecao";
    public static final String DELIMITADOR = "delimitadores";
    public static final String OPERACOES_SIMPLES = "operacoes_simples";
    public static final String OPERADORES_DUPLOS = "operadores_duplos";


    public static final String RELACAO = "relacao";
    public static final String NUMERO = "numero";
    
    public SymbolTable(){
        table = new HashMap<>(0);

        table.put("const",new Symbol(CONST,"const"));
        table.put("else",new Symbol(ELSE,"else"));
        table.put("(",new Symbol(OPEN_PARENTHESIS,"("));
        table.put("<=",new Symbol(SMALLER_EQUAL,"<="));
        table.put(";",new Symbol(SEMICOLON,";"));
        table.put("write",new Symbol(WRITE,"write"));
        table.put("integer",new Symbol(INTEGER,"integer"));
        table.put("and",new Symbol(AND,"and"));
        table.put(")",new Symbol(CLOSE_PARENTHESIS,")"));
        table.put(",",new Symbol(COMMA,","));
        table.put("begin",new Symbol(BEGIN,"begin"));
        table.put("writeln",new Symbol(WRITELN,"writeln"));
        table.put("byte",new Symbol(BYTE,"byte"));
        table.put("or",new Symbol(OR,"or"));
        table.put("<",new Symbol(SMALLER,"<"));
        table.put("+",new Symbol(ADD,"+"));
        table.put("end",new Symbol(END,"end"));
        table.put("true",new Symbol(TRUE,"true"));
        table.put("string",new Symbol(STRING,"string"));
        table.put("not",new Symbol(NOT,"not"));
        table.put(">",new Symbol(BIGGER,">"));
        table.put("-",new Symbol(SUB,"-"));
        table.put("then",new Symbol(THEN,"then"));
        table.put("false",new Symbol(FALSE,"false"));
        table.put("while",new Symbol(WHILE,"while"));
        table.put("=",new Symbol(EQUAL,"="));
        table.put("!=",new Symbol(DIFFERENT,"!="));
        table.put("*",new Symbol(MULT,"*"));
        table.put("readln",new Symbol(READLN,"readln"));
        table.put("boolean",new Symbol(BOOLEAN,"boolean"));
        table.put("if",new Symbol(IF,"if"));
        table.put("==",new Symbol(DOUBLE_EQUAL,"=="));
        table.put(">=",new Symbol(GREATER_EQUAL,">="));
        table.put("/",new Symbol(BAR,"/"));
        table.put("main",new Symbol(MAIN,"main"));
        table.put("EOF",new Symbol(EOF,"EOF"));
    }// End SymbleTable()

    public Symbol pesquisaLex(String lexema){
        Symbol s = table.get(lexema);
        return s == null ? null : s;
    }// End pesquisaLexema()

    public Symbol insereRegistro(String token,String lexema){
        if(table.get(lexema) == null) table.put(lexema,new Symbol(token,lexema));
        else return null;
        return table.get(lexema);
    }// End insereRegistro()

    public void mostrar(){     
        for(Map.Entry entry : table.entrySet()){
            Symbol s = (Symbol)entry.getValue();
            System.out.println("TOKEN: " + s.getToken() + " LEXEMA: " + s.getLexema());
        }// End for 
    }// End mostrar()
}// End SymbolTable