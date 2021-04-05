/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;

/**
 *
 * @author Vinicius Francisco da Silva
 */
class Arvore{
    private No raiz;
    
    /**
     * 
     */
    public Arvore(){
        this.raiz = new No(' ',false);
    }// End Arvore()
    
    /**
     * 
     * @param str
     * @throws Exception 
     */
    public void inserir(String str) throws Exception{
        No no = this.raiz;
        if(!pesquisar(str) && str.length() > 0 && !str.equals(" ")){
            for(int i = 0; i < str.length(); i++){
                if(no.characterer[no.pos(str.charAt(i))] == null){
                    if(i == str.length()-1){
                        no.characterer[no.pos(str.charAt(i))] = new No(str.charAt(i),true);
                    }// End if
                    else{
                        no.characterer[no.pos(str.charAt(i))] = new No(str.charAt(i),false);
                    }// End else
                }// End if
                else if(no.characterer[no.pos(str.charAt(i))].folha){
                    throw new Exception("Prefixo da string ( " + str + " ) ja inserido na estrutura");
                }// End else if
                else if(!no.characterer[no.pos(str.charAt(i))].folha && i == str.length()-1){
                    throw new Exception("Prefixo da string ( " + str + " ) ja inserido na estrutura");
                }// End else if
                no = no.characterer[no.pos(str.charAt(i))]; 
            }// End for
        }// End if
        else{
            throw new Exception("Erro: String ( " + str + " ) já existe na estrutura | ou estrutura vazia");
        }// End else
    }// End inserir()
    
    /**
     * 
     * @param str
     * @return
     * @throws Exception 
     */
    public boolean pesquisar(String str) throws Exception{
        No no = this.raiz;
        boolean resp = false;
         if(str.length() > 0 && !str.equals(" ")){
            for(int i = 0; i < str.length(); i++){
                if(no.characterer[no.pos(str.charAt(i))] != null && no.characterer[no.pos(str.charAt(i))].letra == str.charAt(i)){
                    resp = true;
                    no = no.characterer[no.pos(str.charAt(i))];
                }// End if
                else{
                    resp = false;
                    i = str.length();
                }// End else
            }// End for
         }// End if
         else{
             throw new Exception("Erro: String vazia");
         }// End else
        return no.folha ? resp : false;
    }// End pesquisar()
    
    /**
     * 
     */
    public void mostrar(){
        mostrar(this.raiz,"");
    }// End mostrar() 
    
    /**
     * 
     * @param no
     * @param str 
     */
    private void mostrar(No no,String str){
        if(no.folha){
            System.out.println(str+no.letra);
        }// End if
        else{
            for(int i = 0; i < no.characterer.length; i++){
                if(no.characterer[i] != null){
                    mostrar(no.characterer[i],str+no.letra);
                }// End if
            }// End for
        }// End else
    }// End mostrar()
}// End class Arvore
