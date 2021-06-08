//
// Created by vinicius on 21/03/19.
//

#ifndef TP_GRAPH_H
#define TP_GRAPH_H
#include<stdlib.h>

class Graph{
private:
    int n;
    int** matriz;

public:
    Graph(int n,int** matriz);
    Graph(int n);
    int getN();
    void setN(int n);
    void imprime();
};

Graph::Graph(int n, int** matriz){
    this->n = n;
    this->matriz = matriz;
}// End TpGraph()

Graph::Graph(int n){
    this->n = n;
    this->matriz = (int**)malloc(n*sizeof(int*));
    for(int i = 0; i < n;i++){ this->matriz[i] = new int[n]; }// End for
}// End TpGraph()

int Graph::getN(){ return this->n; }// End getN()

void Graph::setN(int n){ this->n = n; }// End setN()

void Graph::imprime(){
    std::cout << n << std::endl;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            std::cout << this->matriz[i][j] << std::endl;
        }// End for
    }// End for
}// End imprime()

#endif //TP_GRAPH_H
