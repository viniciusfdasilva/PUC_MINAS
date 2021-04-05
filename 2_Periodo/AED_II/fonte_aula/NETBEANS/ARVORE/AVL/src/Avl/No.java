/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Avl;

/**
 *
 * @author Vinicius Francisco da Silva
 */
class No{
    int elemento;
    int fator;
    No esq;
    No dir;
   
    public No(){
        this(0);
    }// End No()
    
    public No(int elemento){
        this.elemento = elemento;
        this.fator = 0;
        this.esq = this.dir = null;
    }// End No()
}// End class No
