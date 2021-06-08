/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Vinicius Silva
 */
public class Main{
    public static Map<String,String> map;
    public static DataInputStream datainputstream;
    public static DataInputStream datainputstreamf;
    public static DataOutputStream dataoutputstream;
    public static MaskFormatter mf = null;
    
    public static String str;
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        try{
           dataoutputstream = new DataOutputStream(new FileOutputStream("74181.hex")); 
           datainputstream = new DataInputStream(new FileInputStream("74181.alu"));
           datainputstreamf = new DataInputStream(new FileInputStream("74181.hex"));
       }catch(FileNotFoundException e){e.printStackTrace();}// End try        
        initMap();
        if(dataoutputstream != null && datainputstream != null){
            getInstructions();
            String string = new String(getValues());
            String[] instructions = string.split(String.valueOf((char)0x20));
            int i = 0;
            while(i < instructions.length && scanner.nextLine().equals("")){
                System.out.println("Enviando a instrução: " + instructions[i]);
                sendInstructions(instructions[i].trim());
                i++;
            }// End while()
        }// End if
    }// End main()
    
    public static boolean getInstructions(){
        String[] hex = new String[]{"","",""};
        boolean getInstruction,isInicio;
        try{
            if(datainputstream.available() > 0){
                for(str = datainputstream.readLine().trim(); !str.equals("fim."); str = datainputstream.readLine().trim()){
                    str = str.replace(".","").replace(",","").replace(";","").trim();
                    getInstruction = false;
                    isInicio = false;
                    while(!getInstruction){
                        if(str.equals("inicio:")){
                            getInstruction = true;
                            isInicio = true;
                        }else if(str.equals("fim.")){    
                            getInstruction = true;
                            isInicio = true;
                        }else if(containsDigit(str) && str.contains("=")){
                            String stringArray[] = str.split("=");
                            if(stringArray[0].equals("A")){
                                if(stringArray[stringArray.length-1].trim().equals("10")){
                                    hex[0] = "A";
                                }else if(stringArray[stringArray.length-1].trim().equals("11")){
                                    hex[0] = "B";
                                }else if(stringArray[stringArray.length-1].trim().equals("12")){
                                    hex[0] = "C";
                                }else if(stringArray[stringArray.length-1].trim().equals("13")){
                                    hex[0] = "D";
                                }else if(stringArray[stringArray.length-1].trim().equals("14")){
                                    hex[0] = "E";
                                }else if(stringArray[stringArray.length-1].trim().equals("15")){
                                    hex[0] = "F";
                                }else{
                                    hex[0] = stringArray[stringArray.length-1].trim();
                                }// End else
                            }// End if
                            else if(stringArray[0].equals("B")){
                                if(stringArray[stringArray.length-1].trim().equals("10")){
                                    hex[1] = "A";
                                }else if(stringArray[stringArray.length-1].trim().equals("11")){
                                    hex[1] = "B";
                                }else if(stringArray[stringArray.length-1].trim().equals("12")){
                                    hex[1] = "C";
                                }else if(stringArray[stringArray.length-1].trim().equals("13")){
                                    hex[1] = "D";
                                }else if(stringArray[stringArray.length-1].trim().equals("14")){
                                    hex[1] = "E";
                                }else if(stringArray[stringArray.length-1].trim().equals("15")){
                                    hex[1] = "F";
                                }else{
                                    hex[1] = stringArray[stringArray.length-1].trim();
                                }// End else
                            }// End else if
                            str = datainputstream.readLine().replace(".","").replace(",","").replace(";","").trim();
                        }else if(!containsDigit(str) && str.contains("=")){
                            String stringArray[] = str.split("=");
                            if(stringArray[0].equals("A")){
                                if(stringArray[stringArray.length-1].trim().equals("10")){
                                    hex[0] = "A";
                                }else if(stringArray[stringArray.length-1].trim().equals("11")){
                                    hex[0] = "B";
                                }else if(stringArray[stringArray.length-1].trim().equals("12")){
                                    hex[0] = "C";
                                }else if(stringArray[stringArray.length-1].trim().equals("13")){
                                    hex[0] = "D";
                                }else if(stringArray[stringArray.length-1].trim().equals("14")){
                                    hex[0] = "E";
                                }else if(stringArray[stringArray.length-1].trim().equals("15")){
                                    hex[0] = "F";
                                }else{
                                    hex[0] = stringArray[stringArray.length-1].trim();
                                }// End else
                            }// End if
                            else if(stringArray[0].equals("B")){
                                if(stringArray[stringArray.length-1].trim().equals("10")){
                                    hex[1] = "A";
                                }else if(stringArray[stringArray.length-1].trim().equals("11")){
                                    hex[1] = "B";
                                }else if(stringArray[stringArray.length-1].trim().equals("12")){
                                    hex[1] = "C";
                                }else if(stringArray[stringArray.length-1].trim().equals("13")){
                                    hex[1] = "D";
                                }else if(stringArray[stringArray.length-1].trim().equals("14")){
                                    hex[1] = "E";
                                }else if(stringArray[stringArray.length-1].trim().equals("15")){
                                    hex[1] = "F";
                                }else{
                                    hex[1] = stringArray[stringArray.length-1].trim();
                                }// End else 
                            }// End else if
                            str = datainputstream.readLine().replace(".","").replace(",","").replace(";","").trim();
                        }else if(validMask()){
                            hex[2] = map.get(new MaskFormatter(str).getMask());
                            getInstruction = true;
                        }// End else if
                    }// End while
                    if(!isInicio && getInstruction){
                        String strValue = "";
                        for(Object string : hex){
                            strValue += string;
                        }// End for
                        dataoutputstream.writeBytes(strValue+(char)0x20);                        
                    }// End if        
                }// End for()
            }// End if     
        }catch(IOException e){ e.printStackTrace();} catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }// End cath
        return true;
    }// End getInstructions()
    
    public static boolean containsDigit(String line){
        char[] charArray = line.toCharArray();
        for(Character chr : charArray){
            if(Character.isDigit(chr)){
                return true;
            }// End if
        }// End for
        return false;
    }// End containsDigit()
    
    public static boolean initMap(){
        map = new HashMap<String,String>();
        try{
            map.put(new MaskFormatter("An").getMask(),"0");
            map.put(new MaskFormatter("nAoB").getMask(),"1");
            map.put(new MaskFormatter("AnB").getMask(),"2");
            map.put(new MaskFormatter("zeroL").getMask(),"3");
            map.put(new MaskFormatter("nAeB").getMask(),"4");
            map.put(new MaskFormatter("Bn").getMask(),"5");
            map.put(new MaskFormatter("AxB").getMask(),"6");
            map.put(new MaskFormatter("ABn").getMask(),"7");
            map.put(new MaskFormatter("AnoB").getMask(),"8");
            map.put(new MaskFormatter("nAxB").getMask(),"9");
            map.put(new MaskFormatter("B").getMask(),"A");
            map.put(new MaskFormatter("AB").getMask(),"B");
            map.put(new MaskFormatter("umL").getMask(),"C");
            map.put(new MaskFormatter("AoBn").getMask(),"D");
            map.put(new MaskFormatter("AoB").getMask(),"E");
            map.put(new MaskFormatter("A").getMask(),"F");
        }catch(ParseException e){ e.printStackTrace(); }
        return true;
    }// End initMap()
    
    public static boolean validMask(){
        return isKey() ? true : false;
    }// End validMask()
    
    public static boolean isKey(){
        for(Map.Entry<String,String> entry : map.entrySet()){
            if(str.equals(entry.getKey())) return true;   
        }// End for
        return false;
    }// End isKey()
    
    public static byte[] getValues(){
        String str = "";
        String string = "";
        try{
            if(datainputstreamf.available() > 0){    
                while((str = datainputstreamf.readLine()) != null){
                    string += str;
                }// End while
            }// End if    
        }catch (IOException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }// End cath
        return string.getBytes();
    }// End getValues()

    public static void sendInstructions(String value){
        ProcessBuilder pb;
	Process p;
        try{    
            pb = new ProcessBuilder("envia.exe","com7",value);
            p = pb.start();
        }catch(IOException ex){
            System.out.println("\n[Ups! Erro ao enviar]");
            System.exit(1);
        }// End cath
    }// End sendInstructions()
}// End Main()
