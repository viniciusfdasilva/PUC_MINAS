/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pesquisa;
import java.util.Scanner;
/**
 *
 * @author Vinicius Francisco da Silva
 */
class Geracao{
    int array[];
    
    /**
     * 
     */
    public Geracao(int tamanho){
       this.array = new int[tamanho];
    }// End Geracao()
    
    /**
     * 
     */
    public Geracao(){
        this(0);
    }// End Geracao()
    
    /**
     * 
     * @return 
     */
    public int tamanho(){
        return array.length;
    }// End tamanho()
    
    /**
     * 
     * @throws Exception 
     */
    public void mostrar() throws Exception{
        if((tamanho()) > 0){
            for(int i = 0; i < tamanho(); i++){
                System.out.print(this.array[i]);
            }// End for
        }// End if
        else{
            throw new Exception("nenhum valor inserido");
        }// End else
    }// End mostrar
    
    /**
     * 
     * @throws Exception 
     */
    public void mostrarContrario() throws Exception{
        if(tamanho() > 0){
            for(int i = tamanho(); i > 0; i--){
                System.out.println(this.array[i]);
            }// End for    
        }// End if
        else{
            throw new Exception("nenhum valor inserido");
        }// End else
    }// End mostrarContrario()
    
    /**
     * 
     * @throws Exception 
     */
    public void inserir() throws Exception{
        Scanner scanner = new Scanner(System.in);      
        for(int i = 0; i < this.array.length; i++){
            try{
                this.array[i] = scanner.nextInt();
            }// End try
            catch(Exception e){
               throw new Exception("erro: " + e);
            }// End catch
        }// End for
    }// End inserir()
}// End class Geracao
