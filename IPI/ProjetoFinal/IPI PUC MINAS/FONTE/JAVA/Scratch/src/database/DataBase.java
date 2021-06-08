    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import people.Pessoa;
import resultado.Resultado;

/**
 *
 * @author Vinicius Francisco da Silva
 */
public class DataBase{
    private short primary_key_resultado;
    private short primary_key_usuario;
    private Connection connect;
    private static final Scanner scanner = new Scanner(System.in);
    
    public DataBase() throws FileNotFoundException, IOException{
        primary_key_resultado = primary_key_usuario = 0;   
        this.connect = null;
    }// End DataBase()
     
    /**
     * 
     * @param key
     * @param user
     * @throws ClassNotFoundException 
     */
    public boolean connection(String key,String user){ 
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,key);
        }catch(SQLException | ClassNotFoundException e){
            return true;
        }// End catch     
        return false;
    }// End connection()
     
    /**
     * 
     * @param pessoa
     * @param resultado 
     */
    public void insert(Pessoa pessoa,Resultado resultado) throws IOException, SQLException{
        String sql_1 = "INSERT INTO USUARIO(ID_,NOME_USUARIO,EMAIL_USUARIO) VALUES(?,?,?)";
        
        String sql = "INSERT INTO RESULTADO(ID_RESPOSTA,ID_USUARIO,VALOR1_SOMA1,VALOR2_SOMA1,RESULTADO_SOMA1,"
                  + "RESPOSTA_SOMA1,VALOR1_SOMA2,VALOR2_SOMA2,RESULTADO_SOMA2,RESPOSTA_SOMA2,VALOR1_SOMA3,VALOR2_SOMA3,"
                  + "RESULTADO_SOMA3,RESPOSTA_SOMA3) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     
        this.primary_key_resultado = (short)getPrimaryKey("USUARIO") == -1 ? 0 : (short)(getPrimaryKey("USUARIO")+1);
        this.primary_key_usuario = (short)getPrimaryKey("RESULTADO") == -1 ? 0 : (short)(getPrimaryKey("RESULTADO")+1);
        
        try{      
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            PreparedStatement st = this.connect.prepareStatement(sql_1);
           
            st.setString(1,Integer.toString(this.primary_key_usuario));
            st.setString(2,pessoa.getNome());
            st.setString(3,pessoa.getEmail());         
            st.execute();
            st.close();  
                    
            stmt.setString(1,Integer.toString(this.primary_key_resultado));
            stmt.setString(2,Integer.toString(this.primary_key_usuario));
            stmt.setString(3,Integer.toString(resultado.getValor1_soma1()));
            stmt.setString(4,Integer.toString(resultado.getValor2_soma1()));
            stmt.setString(5,Integer.toString(resultado.getResultado_soma1()));
            stmt.setString(6,Integer.toString(resultado.getResposta_soma1()));
            
            stmt.setString(7,Integer.toString(resultado.getValor1_soma2()));
            stmt.setString(8,Integer.toString(resultado.getValor2_soma2()));
            stmt.setString(9,Integer.toString(resultado.getResultado_soma2()));
            stmt.setString(10,Integer.toString(resultado.getResposta_soma2()));
            
            stmt.setString(11,Integer.toString(resultado.getValor1_soma3()));
            stmt.setString(12,Integer.toString(resultado.getValor2_soma3()));
            stmt.setString(13,Integer.toString(resultado.getResultado_soma3()));
            stmt.setString(14,Integer.toString(resultado.getResposta_soma3()));
            stmt.execute();
            stmt.close();      
            
            this.primary_key_usuario++;
            this.primary_key_resultado++;
        }catch(SQLException u){      
            throw new RuntimeException(u);      
        }// End catch      
    }// End insert()
    
    public int getPrimaryKey(String table_name) throws SQLException{
        String sql = "SELECT * FROM "+table_name;
        PreparedStatement stmt = null;
        ResultSet result;
        int key = -1;
        
        try{
            stmt = this.connect.prepareStatement(sql);
            result = stmt.executeQuery();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }// End catch
        
        try{
            while(result.next()){
                key = result.getInt(1);
            }// End while
        }catch(SQLException e){
            return -1;
        }// End catch
 
        stmt.close();
        result.close();
        
        return key;
    }// End getPrimaryKey()
}// End DataBase
