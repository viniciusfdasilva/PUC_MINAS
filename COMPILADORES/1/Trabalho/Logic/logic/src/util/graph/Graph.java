package util.graph; 

public class Graph{
    private int[][] adjacency;
    private int n;

    public Graph(int n){
        this.n = n;
        this.adjacency = new int[this.n][this.n];
        
    }// End Graph()
}// End Graph

