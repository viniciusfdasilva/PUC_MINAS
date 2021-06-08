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
import javafx.scene.shape.Line;

public class Edge{
    private Vertex initialVertex;
    private Vertex finalVertex;
    private double xinicial;
    private double yinicial;
    private double xfinal;
    private double yfinal;
    private Line edge;

    public Edge(Vertex initialVertex,Vertex finalVertex){
       this.initialVertex = initialVertex;
       this.finalVertex = finalVertex;
       this.xinicial = this.initialVertex.getX();
       this.yinicial = this.initialVertex.getY();
       this.xfinal = this.finalVertex.getX();
       this.yfinal = this.finalVertex.getY();
       this.edge = new Line(xinicial,yinicial,xfinal,yfinal);
       this.edge.setFill(Color.BLACK);
    }// End Edge()
    
    public Edge(int latinicial,int loninicial,int latfinal,int lonfinal){
        

        this.xinicial = (loninicial + 180) * (Main.width / 360);
        double latRad = latinicial * Math.PI / 180;
        double mercN = Math.log(Math.tan((Math.PI/4) + (latRad/2)));
        this.yinicial = (Main.heigth/2) - (Main.width*mercN/(2*Math.PI));


        this.xfinal = (lonfinal + 180) * (Main.width / 360);
        double latRadfinal = latfinal * Math.PI / 180;
        double mercNfinal = Math.log(Math.tan((Math.PI/4) + (latRadfinal/2)));
        this.yfinal = (Main.heigth/2) - (Main.width*mercNfinal/(2*Math.PI));

        this.edge = new Line(xinicial,yinicial,xfinal,yfinal);
        this.edge.setFill(Color.BLACK);
    }// End Edge()


    public Group setGroup(Group group){
        group.getChildren().add(this.edge);
        return group;
    }// End setScene()
}// End Edge