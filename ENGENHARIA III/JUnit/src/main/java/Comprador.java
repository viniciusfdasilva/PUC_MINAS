import java.util.Calendar;
import java.util.Date;

public class Comprador implements StubComprador{
    private String nome;
    private String cpf;
    private int dia;
    private int mes;
    private int ano;
    private char sexo;
    private String numeroCartao;

    public Comprador(String nome,String cpf,int dia,int mes,int ano,char sexo,String numeroCartao){
        this.nome = nome;
        this.cpf = cpf;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.sexo = sexo;
        this.numeroCartao = numeroCartao;
    }// End Comprador()

    public String getNome(){
        return nome;
    }// End getNome()
    public void setNome(String nome){
        this.nome = nome;
    }// End setNome()
    public String getNumeroCartao(){ return numeroCartao; }// End getNumeroCartao()
    public void setNumeroCartao(String numeroCartao){
        this.numeroCartao = numeroCartao;
    }// End setNumeroCartao()
    public String getCpf(){ return cpf; }// End getCpf()
    public void setCpf(String cpf){ this.cpf = cpf; }// End setCpf
    public int getDia(){ return dia; }// End getDia()
    public void setDia(int dia){ this.dia = dia; }// End setDia()
    public int getMes(){ return mes; }// End getMes()
    public void setMes(int mes){ this.mes = mes; }// End setMes()
    public int getAno(){ return ano; }// End getAno()
    public void setAno(int ano){ this.ano = ano; }// End setAno()]
    public char getSexo(){
        return sexo;
    }// End getSexo()
    public void setSexo(char sexo){
        this.sexo = sexo;
    }// End setSexo()
    public int getIdade(){
        Calendar calendar = Calendar.getInstance();
        int anoatual  = calendar.get(Calendar.YEAR);
        return (this.ano-anoatual);
    }// End getIdade()
}// End Comprador
