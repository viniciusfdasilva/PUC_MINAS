/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Group;

/**
 *
 * @author Vinicius Silva
 */
public class Graph{
    private int[][] adjacencia;
    private Map<String,Edge> map;
    private int n;

    public Graph(){
        
    }// End Graph()
    
    public Graph(int n){
        this.n = n;
        this.adjacencia = new int[n][n];
        this.map = new HashMap<>();
     //   this.map = new HashMap<>();
    }// End Graph()
    
    public Graph(int[][] adjacencia){
      this.n = adjacencia.length;
      this.adjacencia = adjacencia;
    //  this.map = new HashMap<>();
    }// End Graph()
    
  //  public Graph(int[][] adjacencia,Map<String,Circle> map){
    
   //}// End Graph()
    
    public void addAdjacencia(int i,int j,Vertex v1,Vertex v2,double valor){
        this.adjacencia[i][j] = (int)valor;
        this.map.put(i+""+j,new Edge(v1,v2));
    }// End Vertex
    
    public Group setGroup(int i,int j,Group group){
        return this.map.get(i+""+j).setGroup(group);
    }// End setGroup
}// End Graph()
