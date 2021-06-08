/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Vinicius Silva
 */
public class Graph{
    private int[][] adjacencia;
    private int n;

    public Graph(int n){
        this.n = n;
        this.adjacencia = new int[n][n];
    }// End Graph()
}// End Graph()
