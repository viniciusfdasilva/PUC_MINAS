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
class Arvore{
    private No raiz;
    
    /*
     * @param void
    */
    public Arvore(){
        this.raiz = null;
    }// End Arvore()
    
    /**
     * @param int elemento a ser inserido
     * @return vazio
     * @throws Caso o elemento a ser inserido
     * ja exista na estrutura
    */
    public void inserir(int elemento) throws Exception{
        this.raiz = inserir(this.raiz,elemento);
        setFator(this.raiz);
    }// End inserir()
    
    /**
     * @param No i
     * @param int elemento a ser inserido
     * @return vazio
     * @throws Caso o elemento a ser inserido
     * ja exista na estrutura
    */
    private No inserir(No i,int elemento) throws Exception{
        if(i == null){
            i = new No(elemento);
        }// End if
        else if(i.elemento > elemento){
            i.esq = inserir(i.esq,elemento);
        }// End else if
        else if(i.elemento < elemento){
            i.dir = inserir(i.dir,elemento);
        }// End else if
        else{
            throw new Exception("erro");
        }// End else
        return i;
    }// End inserir()
    
    /**
     * @param int elemento a ser pesquisado
     * na estrutura
     * @return boolean true caso o elemento
     * pesquisdo exista na estrutura caso contrário
     * false
    */
    public boolean pesquisar(int elemento){
        return pesquisar(this.raiz,elemento);
    }// End pesquisar()
    
    /**
     * @param No i 
     * @param int elemento a ser pesquisado
     * na estrutura
     * @return boolean true caso o elemento
     * pesquisdo exista na estrutura caso contrário
     * false
    */
    public boolean pesquisar(No i,int elemento){
        boolean resp = false;
        if(i != null){   
            if(i.elemento > elemento){
                resp = pesquisar(i.esq,elemento);
            }// End if
            else if(i.elemento < elemento){
                resp = pesquisar(i.dir,elemento);
            }// End else if
            else{
                resp = true;
            }// End else
        }// End if
        return resp;
    }// End pesquisar()
   
    /**
     * @param int elemento a ser removido
     * @return elemento removido
     * @throws Caso o elemento não exista 
     */
    public int remover(int elemento) throws Exception{
        return remover(this.raiz,elemento).elemento;
    }// End remover()
    
    /**
     * 
     * @param No i
     * @param int elemento a ser removido
     * @return elemento removido
     * @throws Caso o elemento não exista
     */
    private No remover(No i,int elemento) throws Exception{
        if(i == null){
            throw new Exception("erro");
        }// End if
        else if(i.elemento > elemento){ 
            i.esq = inserir(i.esq,elemento);
        }// End else if
        else if(i.elemento < elemento){
            i.dir = inserir(i.dir,elemento);
        }// End else if
        if(i.esq != null){
            i = i.esq;
        }// End if
        else if(i.esq != null){
            i = i.dir;
        }// End else if
        else{
            i.esq = getMaiorEsq(i,i.esq);
        }// End else
        return i;
    }// End remover()
    
    /**
     * 
     * @param i
     * @param esq
     * @return 
     */
    private No getMaiorEsq(No i,No esq){
        if(esq.dir != null){
            esq.dir = getMaiorEsq(i,esq.dir);
        }// End if
        else{
            i.elemento = esq.elemento;
            esq = esq.esq;
        }// End else
        return esq;
    }// End getMaiorEsq()
    
    /**
     * 
     */
    public void mostrarCentral(){
        mostrarCentral(this.raiz);
    }// End mostrarCentral()
    
    /**
     * 
     * @param i 
     */
    private void mostrarCentral(No i){
        if(i != null){
            mostrarCentral(i.esq);
            System.out.println(i.elemento + i.fator);
            mostrarCentral(i.dir);
        }// End if  
    }// End mostrarCentral()
    
    /**
     * 
     */
    public void mostrarPre(){
        mostrarPre(this.raiz);
    }// End  mostrarPre()
    
    /**
     * 
     * @param i 
     */
    private void mostrarPre(No i){
        if(i != null){
            System.out.println(i.elemento + i.fator);
            mostrarPre(i.esq);
            mostrarPre(i.dir);
        }// End if
    }// End mostrarPre()
    
    /**
     * 
     */
    public void mostrarPos(){
        mostrarPos(this.raiz);
    }// Endm mostrarPos()
    
    /**
     * 
     * @param i 
     */
    private void mostrarPos(No i){
        if(i != null){
            mostrarPos(i.esq);
            mostrarPos(i.dir);
            System.out.println(i.elemento + i.fator);
        }// End if
    }// End mostrarPos()
    
    /**
     * 
     * @return 
     */
    public int getTamanho(){
        return alturaDir(raiz.dir) > alturaEsq(raiz.esq) ? alturaDir(raiz.dir) : alturaEsq(raiz.esq);
    }// End if
  
    /**
     * 
     * @param i
     * @return 
     */
    protected int alturaDir(No i){
        int tamanho = 1;
        if(i.dir == null && i.esq != null) tamanho = (1 + alturaDir(i.esq));
        else if(i.esq == null && i.dir != null) tamanho = (1 + alturaDir(i.dir));
        else if(i.esq != null && i.dir != null) tamanho = (1 + Math.max(alturaDir(i.esq),alturaEsq(i.dir)));
        return tamanho;
    }// End alturaDir()
    
    /**
     * 
     * @param i
     * @return 
     */
    protected int alturaEsq(No i){
        int tamanho = 1;
        if(i.dir == null && i.esq != null) tamanho = (1 + alturaEsq(i.esq));
        else if(i.esq == null && i.dir != null) tamanho = (1 + alturaEsq(i.dir));
        else if(i.esq != null && i.dir != null) tamanho = (1 + Math.max(alturaEsq(i.esq),alturaEsq(i.dir)));
        return tamanho;
    }// End alturaEsq()
    
    /**
     * 
     */
    private void setFator(){
        setFator(this.raiz);
    }// End void setFator()
    
    /**
     * 
     * @param i 
     */
    public void setFator(No i){
        if(i != null){
          i.fator = (alturaDir(i.dir) - alturaEsq(i.esq));
          setFator(i.esq);
          setFator(i.dir);
        }// End if
    }// End setFator()
}// End Arvore
