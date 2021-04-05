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
public class Main{
   public static void main(String[] args) throws Exception{
        Arvore arvore = new Arvore();
        arvore.inserir("Vinicius");
        arvore.inserir("Alemanha");
        arvore.inserir("mamão");
        arvore.inserir("ADA");
        arvore.inserir("Tudo Bem como você está?");
        arvore.inserir("AD");
        //System.out.println(arvore.pesquisar("Vinicius") ? "SIM" : "NÃO");
        //arvore.mostrar();
    }// End main()  
}// End class Main
