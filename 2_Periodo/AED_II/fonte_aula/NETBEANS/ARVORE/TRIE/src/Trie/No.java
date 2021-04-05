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
class No{
    char letra;
    boolean folha;
    public No[] characterer;
    final int tamanho = 255;
    
    /**
     * Construtor nó
     * @param letra
     * @param folha 
     */
    public No(char letra,boolean folha){
        this.letra = letra;
        this.folha = folha;
        this.characterer = new No[tamanho];
        for(int i = 0; i < tamanho; i++){
            this.characterer[i] = null;
        }// End for
    }// End No
    
    /**
     * Construtor nó
     * @param vazio
     */
    public No(){
        this.letra = ' ';
        this.folha = false;
        this.characterer = new No[tamanho];
        for(int i = 0; i < tamanho; i++){
            this.characterer[i] = null;
        }// End for
    }// End No()
    
    /**
     * 
     * @param chr
     * @return int ASCII 
     */
    public int pos(char chr){
        return (int)chr;
    }// End pos()
}// End class No
