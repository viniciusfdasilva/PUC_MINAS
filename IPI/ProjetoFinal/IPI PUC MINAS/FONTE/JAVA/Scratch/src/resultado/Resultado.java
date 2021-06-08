/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultado;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Resultado{
    private int valor1_soma1;
    private int valor2_soma1;
    private int resposta_soma1;
    private int resultado_soma1;
    
    private int valor1_soma2;
    private int valor2_soma2;
    private int resposta_soma2;
    private int resultado_soma2;
    
    private int valor1_soma3;
    private int valor2_soma3;
    private int resposta_soma3;
    private int resultado_soma3;

    public Resultado(int valor1_soma1, int valor2_soma1,  int resposta_soma1, int resultado_soma1,
                     int valor1_soma2, int valor2_soma2, int resposta_soma2, int resultado_soma2, 
                     int valor1_soma3, int valor2_soma3, int resposta_soma3, int resultado_soma3){       
        
        this.valor1_soma1 = valor1_soma1;   
        this.valor2_soma1 = valor2_soma1;
        this.resposta_soma1 = resposta_soma1;
        this.resultado_soma1 = resultado_soma1;
                        
        this.valor1_soma2 = valor1_soma2;
        this.valor2_soma2 = valor2_soma2;
        this.resposta_soma2 = resposta_soma2;
        this.resultado_soma2 = resultado_soma2;
    
        this.valor1_soma3 = valor1_soma3;
        this.valor2_soma3 = valor2_soma3;
        this.resposta_soma3 = resposta_soma3;
        this.resultado_soma3 = resultado_soma3;
    }// End Resultado()
    
    public Resultado(){       
        this.valor1_soma1 = -1;   
        this.valor2_soma1 = -1;
        this.resposta_soma1 = -1;
        this.resultado_soma1 = -1;
    
        this.valor1_soma2 = -1;
        this.valor2_soma2 = -1;
        this.resposta_soma2 = -1;
        this.resultado_soma2 = -1;
    
        this.valor1_soma3 = -1;
        this.valor2_soma3 = -1;
        this.resposta_soma3 = -1;
        this.resultado_soma3 = -1;
    }// End Resultado
    
    public int getValor1_soma1(){
        return valor1_soma1;
    }// End getValor1_soma1() 

    public void setValor1_soma1(int valor1_soma1){
        this.valor1_soma1 = valor1_soma1;
    }// End setValor1_soma1()

    public int getValor2_soma1(){
        return valor2_soma1;
    }// End getValor2_soma1() 

    public void setValor2_soma1(int valor2_soma1){
        this.valor2_soma1 = valor2_soma1;
    }// End setValor2_soma1()

    public int getResposta_soma1(){
        return resposta_soma1;
    }// End getResposta_soma1() 

    public void setResposta_soma1(int resposta_soma1){
        this.resposta_soma1 = resposta_soma1;
    }// End setResposta_soma1()

    public int getResultado_soma1(){
        return resultado_soma1;
    }// End getResultado_soma1()

    public void setResultado_soma1(int resultado_soma1) {
        this.resultado_soma1 = resultado_soma1;
    }// End setResultado_soma1()

    public int getValor1_soma2(){
        return valor1_soma2;
    }// End getValor1_soma2() 

    public void setValor1_soma2(int valor1_soma2){
        this.valor1_soma2 = valor1_soma2;
    }// End setValor1_soma2()

    public int getValor2_soma2(){
        return valor2_soma2;
    }// End getValor2_soma2() 

    public void setValor2_soma2(int valor2_soma2){
        this.valor2_soma2 = valor2_soma2;
    }// End setValor2_soma2()

    public int getResposta_soma2(){
        return resposta_soma2;
    }// End getResposta_soma2()

    public void setResposta_soma2(int resposta_soma2){
        this.resposta_soma2 = resposta_soma2;
    }// End setResposta_soma2()

    public int getResultado_soma2(){
        return resultado_soma2;
    }// End getResultado_soma2() 

    public void setResultado_soma2(int resultado_soma2){
        this.resultado_soma2 = resultado_soma2;
    }// End setResultado_soma2()

    public int getValor1_soma3(){
        return valor1_soma3;
    }// End getValor1_soma3()

    public void setValor1_soma3(int valor1_soma3){
        this.valor1_soma3 = valor1_soma3;
    }// End setValor1_soma3()

    public int getValor2_soma3(){
        return valor2_soma3;
    }// End getValor2_soma3() 

    public void setValor2_soma3(int valor2_soma3){
        this.valor2_soma3 = valor2_soma3;
    }// End setValor2_soma3()

    public int getResposta_soma3(){
        return resposta_soma3;
    }// End getResposta_soma3()

    public void setResposta_soma3(int resposta_soma3){
        this.resposta_soma3 = resposta_soma3;
    }// End setResposta_soma3()

    public int getResultado_soma3(){
        return resultado_soma3;
    }// End getResultado_soma3()

    public void setResultado_soma3(int resultado_soma3){
        this.resultado_soma3 = resultado_soma3;
    }// End setResultado_soma3()
  
    public boolean isObjectEmpty(){
        return this.valor1_soma1 == -1 || this.valor2_soma1 == -1 || this.resposta_soma1 == -1 || 
               this.resultado_soma1 == -1 || this.valor1_soma2 == -1 || this.valor2_soma2 == -1 || 
               this.resposta_soma2 == -1 || this.resultado_soma2 == -1 || this.valor1_soma3 == -1 || 
               this.valor2_soma3 == -1 || this.resposta_soma3 == -1 || this.resultado_soma3 == -1 ? true : false; 
    }// End isObjectEmpty()
}// End Resultado
