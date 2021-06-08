/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratch;

import database.DataBase;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Component;
import java.net.Socket;
import java.io.*;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.ConnectException;
import people.Pessoa;
import scratch.frame.Screen;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.OK_OPTION;
import resultado.Resultado;
/**
 * 
 * @author Vinicius Francisco da Silva
 */
public class Scratch{
   private static DataBase db;
   public static boolean bool = false;
    /**
     * 
     * @throws InterruptedException 
     * @throws java.io.IOException 
     * @throws java.net.ConnectException 
     */
    public static void chegadaDados(String key, String user) throws InterruptedException, IOException, ClassNotFoundException{
    	String ip = "127.0.0.1";
        int port = 42001;
        
        boolean resp_socket = false,resp_database = false;
        
        Socket socket = null;
        FileOutputStream fileoutputstream = null;
        DataInputStream in = null;     
            
        try{  
            socket = new Socket(ip,port); 
            db = new DataBase();
            resp_database = db.connection(key,user);
            if(!resp_database){
                JOptionPane.showMessageDialog(null,"Conecção estabelecida com sucesso!");
                getSom();
            }// End if    
        }catch(ConnectException e2){ 
            resp_socket = true;
        }// End catch
        
        if(resp_socket || resp_database){
            JOptionPane.showMessageDialog(null,"Não foi possível estabelecer conecção!","Erro de conecção",OK_OPTION);
            System.exit(1);
        }// End if
        
        Scanner input = new Scanner(System.in); 
        
        Pessoa pessoa = new Pessoa();
        Resultado resultado = new Resultado();
        
        try{
            in = new DataInputStream(socket.getInputStream());
            while(true){
                if(in.available() > 0){
                    String string = ler(in);
                   if(getData(string,pessoa,resultado)){
                        db.insert(pessoa,resultado);
                        pessoa = new Pessoa();
                        resultado = new Resultado();
                    }// End if
                }// End if
            }// End while
        }catch(Exception e){
            e.printStackTrace();
        }// End catch
   }// End ler()

    /**
     * 
     * @param str
     * @return 
     */
    private static boolean getData(String str,Pessoa pessoa,Resultado resultado){
        boolean resp = false;
        if(str.contains("sensor-update "+String.valueOf((char)0x22)+"nome"+String.valueOf((char)0x22))){
            str = str.replace("sensor-update "+String.valueOf((char)0x22)+"nome"+String.valueOf((char)0x22),"");
            str = str.replace(String.valueOf((char)0x22),"");          
            pessoa.setNome(str.trim());
        }else if(str.contains("sensor-update "+String.valueOf((char)0x22)+"email"+String.valueOf((char)0x22))){
            str = str.replace("sensor-update "+String.valueOf((char)0x22)+"email"+String.valueOf((char)0x22),"");
            str = str.replace(String.valueOf((char)0x22),"").trim();
            String[] stringemail = str.split(" ");
            pessoa.setEmail(stringemail[0].trim());
        }else if(str.contains(String.valueOf((char)0x22)+"resposta"+String.valueOf((char)0x22)) && 
                !str.contains(String.valueOf((char)0x22)+"nome"+String.valueOf((char)0x22)) && 
                !str.contains(String.valueOf((char)0x22)+"email"+String.valueOf((char)0x22))){
           
            String[] stringvalue = str.split(" ");
            str = getInt(stringvalue).trim();
            int intvalue = isNumber(str) ? Integer.parseInt(str) : -2;
            
            if(resultado.getResposta_soma1() == -1){
                resultado.setResposta_soma1(Integer.parseInt(str));
            }else if(resultado.getResposta_soma2() == -1){
                resultado.setResposta_soma2(Integer.parseInt(str));
            }else{
                resultado.setResposta_soma3(Integer.parseInt(str));
            }// End else
        }else if(str.contains("sensor-update "+String.valueOf((char)0x22)+"primeiroNumero"+String.valueOf((char)0x22)) && 
            str.contains("resultado") && str.contains("segundoNumero")){
            str = str.replace("sensor-update "+String.valueOf((char)0x22)+"primeiroNumero"+String.valueOf((char)0x22),"");    
            str = str.replace(String.valueOf((char)0x22)+"resultado"+String.valueOf((char)0x22),"");
            str = str.replace(String.valueOf((char)0x22)+"segundoNumero"+String.valueOf((char)0x22),"");
            str = str.substring(1,str.length());
           
            String[] string = str.split("  ");
            
            string[0] = string[0].trim();
            string[1] = string[1].trim();
            string[2] = string[2].trim();
            
            int[] integer = new int[3];
            if(isNumber(string[0]) && isNumber(string[1]) && isNumber(string[2])){
                try{    
                    integer[0] = Integer.parseInt(string[0]);
                    integer[1] = Integer.parseInt(string[1]);
                    integer[2] = Integer.parseInt(string[2]);
                }catch(Exception e){
                    e.printStackTrace();
                }// End catch
            }else{
                string[0] = getNumber(string[0]) != null ? getNumber(string[0]).trim() : "-2";
                string[1] = getNumber(string[1]) != null ? getNumber(string[1]).trim() : "-2";
                string[2] = getNumber(string[2]) != null ? getNumber(string[2]).trim() : "-2";
                
                try{    
                    integer[0] = Integer.parseInt(string[0]);
                    integer[1] = Integer.parseInt(string[1]);
                    integer[2] = Integer.parseInt(string[2]);
                }catch(Exception e){
                    e.printStackTrace();
                }// End catch
            }// End else
            
            if(resultado.getValor1_soma1() == -1 && resultado.getValor2_soma1() == -1 && resultado.getResultado_soma1() == -1){
               resultado.setValor1_soma1(integer[0]);
               resultado.setValor2_soma1(integer[2]);
               resultado.setResultado_soma1(integer[1]);
            }else if(resultado.getValor1_soma2() == -1 && resultado.getValor2_soma2() == -1 && resultado.getResultado_soma2() == -1){
                resultado.setValor1_soma2(integer[0]);
                resultado.setValor2_soma2(integer[2]);
                resultado.setResultado_soma2(integer[1]);
            }else{
                resultado.setValor1_soma3(integer[0]);
                resultado.setValor2_soma3(integer[2]);
                resultado.setResultado_soma3(integer[1]);
            }// End else
        }// End else if
        
        if(!pessoa.isObjectEmpty() && !resultado.isObjectEmpty()){
            resp = true;
        }// End if
        return resp;
    }// End getData()
    
    public static boolean isNumber(String str){
        boolean resp = false;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                resp = true;
            }else{
                return false;
            }// End else 
        }// End if
        return resp;
    }// End isNumber()
    
    public static String getInt(String[] string){
        int i,j = 0;
        for(i = 0; i < string.length; i++){
            if(string[i].equals(String.valueOf((char)0x22)+"resposta"+String.valueOf((char)0x22))){
                j = (i+1);
                i = string.length;
            }// End if
        }// End for
        return string[j];
    }// End getInt()
    
    public static String getNumber(String str){
        String string = "";
        boolean flag_fitstposition = false;
        boolean flag_character = false;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                string += str.charAt(i);
            }else{
                i = str.length();
            }// End else
        }// End for    
        return isNumber(string.trim()) ? string.trim() : null;
    }// End getNumber()
    
    /**
     * 
     */
    private static void getSom(){
	AudioClip clip = null;
        try{
            clip = Applet.newAudioClip(new URL("http://www.soundjay.com/button/beep-02.wav"));
        }catch(MalformedURLException e){
            e.printStackTrace();
        }// End catch
        clip.play();
    }// End getSom()

    /**
     * 
     * @param in
     * @return
     * @throws IOException 
     */
   private static String ler(DataInputStream in) throws IOException{
        in.readShort();
        return in.readUTF();
   }// End readMessage()
}// End class Scratch
