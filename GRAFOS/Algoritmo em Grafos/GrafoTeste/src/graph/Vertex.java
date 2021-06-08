/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import controleaereo.Main;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Vertex{
    private int grau;
    private String nome;
    private Circle vertex;
    
    private double x;
    private double y;
   
    private double lat;
    private double lon;

    public Vertex(String name,int grau,double lat,double lon){
        this.grau  = grau;
        this.nome = name;
        
        this.x = (lon + 180) * (Main.width / 360);
        double latRad = lat * Math.PI / 180;
        double mercN = Math.log(Math.tan((Math.PI/4) + (latRad/2)));
        this.y = (Main.heigth/2) - (Main.width*mercN/(2*Math.PI));

        this.lat = lat;
        this.lon = lon;
        
        this.vertex = new Circle(8);
        this.vertex.setTranslateX((int)this.x);
        this.vertex.setTranslateY((int)this.y);
        this.vertex.setFill(Color.RED);
    }// End Vertex()

    public Group setGroup(Group group){
        group.getChildren().add(this.vertex);
        return group;
    }// End setScene()

    public int getGrau(){
        return grau;
    }// End getGrau()

    public void setGrau(int grau){
        this.grau = grau;
    }// End setGrau()

    public Circle getVertex(){
        return vertex;
    }// End getVertex()

    public void setVertex(Circle vertex){
        this.vertex = vertex;
    }// End setVertex()

    public double getX(){
        return x;
    }// End getX()

    public void setX(double x){
        this.x = x;
    }// End setX()

    public double getY(){
        return y;
    }// End getY()

    public void setY(double y){
        this.y = y;
    }// End setY()

    public double getLat(){
        return lat;
    }// End getLat()

    public void setLat(double lat){
        this.lat = lat;
    }// End setLat()

    public double getLon(){
        return lon;
    }// End getLon()

    public void setLon(double lon){
        this.lon = lon;
    }// End setLon()    
}// End Vertex