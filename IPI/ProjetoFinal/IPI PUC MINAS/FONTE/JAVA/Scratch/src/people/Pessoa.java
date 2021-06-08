/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class Pessoa{
    private String nome;
    private String email;
    
    /**
     * 
     */
    public Pessoa(){
        this.nome = this.email = "";
    }// End Pessoa()
    
    /**
     * 
     * @param nome
     * @param email 
     */
    public Pessoa(String nome,String email){
        this.nome = nome;
        this.email = email;
    }// End Pessoa()

    /**
     * 
     * @return 
     */
    public String getNome(){
        return nome;
    }// End getNome()

    /**
     * 
     * @param nome 
     */
    public void setNome(String nome){
        this.nome = nome;
    }// End setNome()

    /**
     * 
     * @return 
     */
    public String getEmail(){
        return email;
    }// End getEmail()

    /**
     * 
     * @param email 
     */
    public void setEmail(String email){
        this.email = email;
    }// End setEmail()
    
    /**
     * 
     * @return 
     */
    public String toString(){
        return "[ Nome: " + this.email + " Email: " + this.email + " ]";
    }// End toString()
    
    public boolean isObjectEmpty(){
        return this.nome.isEmpty() || this.email.isEmpty() ? true : false;
    }// End isObjectEmpty()
    
    /**
     * 
     * @return 
     */
    public Pessoa clone(){
        return new Pessoa(this.nome,this.email);
    }// End clone()
}// End Pessoa
