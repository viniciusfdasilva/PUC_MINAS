public class Symbol{
    private String token;
    private String lexema;
    private String tipo;
    private byte numero;
    private String classe;

    public Symbol(byte numero,String lexema){  
       setToken(lexema);  
       setLexema(lexema);
       setTipo("");
       setClasse("");
       setNumero(numero);
    }// End Symbol()

    public Symbol(String token,String lexema){  
        setToken(token);  
        setLexema(lexema);
        setTipo("");
        setClasse("");
        this.numero = 0xFFFFFFFF; 
     }// End Symbol()

    public Symbol(String lexema,String tipo,String classe, byte numero){      
        setToken(lexema);  
        setLexema(lexema);
        setTipo(classe);
        setClasse(tipo);
        setNumero(numero);
    }// End Symbol()

    public String getToken(){
        return this.token;
    }// End getToken()

    public void setToken(String token){
        this.token = token;
    }// End setToken()

    public String getLexema(){
        return this.lexema;
    }// End getLexema()

    public void setLexema(String lexema){
        this.lexema = lexema;
    }// End setLexema()

    public String getTipo(){
        return this.tipo;
    }// End getTipo()

    public void setTipo(String tipo){
        this.tipo = tipo;
    }// End setTipo()

    public String getClasse(){
        return this.classe;
    }// End getClasse()

    public void setClasse(String classe){
        this.classe = classe;
    }// End setClasse()

    public byte getNumero(){
        return this.numero;
    }// End getClasse()

    public void setNumero(byte numero){
        this.numero = numero;
    }// End setClasse()
}// End Symbol


