/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pesquisa;
/**
 *
 * @author Vinicius Francisco da Silva
 */
class Pesquisa extends Geracao{
    public boolean sequencial(int elemento){
        boolean resp = false;
        for(int i = 0; i < tamanho(); i++){
            if(array[i] == elemento){
                resp = true;
                i = tamanho();
            }// End if
        }// End for
        return resp;
    }// End sequencial()
    
    public boolean binaria(int elemento) throws Exception{
        int indice_inicial = 0;
        int indice_final = array.length;
        int meio;
        boolean resp = false;
        if(isOrdenado()){
            while(indice_inicial <= indice_final){
                    meio = ((indice_inicial+indice_final)/2);
                if(array[meio] == elemento){
                    resp = true;
                    indice_inicial = indice_final;
                }// End if
                else if(array[meio] > elemento){
                    indice_final = meio-1;
                }// End else if
                else{
                    indice_inicial = meio+1;
                }// End else
            }// End while
        }// End if
        else{
            throw new Exception("Vetor não está ordenado");
        }// End else
        return resp;
    }// End binaria()
    
    public boolean isOrdenado(){
        boolean resp = false;
        for(int i = 0; i < array.length-1; i++){
            if(array[i] <= array[i+1]){
                resp = true;
            }// End if
            else{
                resp = false;
                i = array.length;
            }// End else
        }// End for
        return resp;
    }// End isOrdenado()
}// End class Pesquisa
