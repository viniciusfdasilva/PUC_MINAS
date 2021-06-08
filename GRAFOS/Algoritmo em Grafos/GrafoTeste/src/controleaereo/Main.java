/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleaereo;

import adjacency.Adjacency;
import graph.Graph;
import graph.Vertex;
import java.awt.Dimension;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import localizacao.Localizacao;

/**
 *
 * @author Vinicius Silva
 */
public class Main extends Application{    
    public static double width;
    public static double heigth;
    
    public static double lat;
    public static double lon;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Group group = new Group();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension scrnsize = toolkit.getScreenSize();
        
        width = (int)scrnsize.getWidth() + 10;
        heigth = (int)scrnsize.getHeight() - 38;
        
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Opções");
        
        
        MenuItem menuitem1 = new MenuItem("Menor Caminho");
        MenuItem menuitem2 = new MenuItem("Menor Tarifa");
        MenuItem menuitem3 = new MenuItem("Menor Tarifa com viagem ao redor do mundo");
        MenuItem menuitem4 = new MenuItem("Ponto que vai de qualquer origem para qualquer destino");
        MenuItem menuitem5 = new MenuItem("Economia de combustível");
        
        menu.getItems().addAll(menuitem1,menuitem2,menuitem3,menuitem4,menuitem5);
        menuBar.getMenus().add(menu);
        
        
        Image image = new Image(
                "https://www.guiageo-mapas.com/imagens/mapa-mundi.jpg",
                 width,
                 heigth,
                 false,
                 false);
        
        group.getChildren().add(new ImageView(image));
        
        List<Localizacao> listVertex = getLatLon();
        List<Adjacency> listAdjacency = getAdjacencia();
        
        Map<String,Vertex> vertex = new HashMap<>(0);
        Map<String,Integer> pos = new HashMap<>(0);
        
        Graph graph = new Graph(listVertex.size());
        
        for(int i = 0; i < listVertex.size(); i++){
            lat = listVertex.get(i).getLatitude();
            lon = listVertex.get(i).getLongitude();
            String sigla = listVertex.get(i).getSigla();
            
            Vertex v = new Vertex(sigla,-1,lat,lon);
            vertex.put(sigla,v);
            pos.put(sigla,i);
            group = v.setGroup(group);
        }// End for
        
        for(int i = 0; i < listAdjacency.size(); i++){
            String s1 = listAdjacency.get(i).getSigla1();
            String s2 = listAdjacency.get(i).getSigla2();
            
            Vertex v1 = vertex.get(s1);
            Vertex v2 = vertex.get(s2);
            Integer pos1 = pos.get(s1);
            Integer pos2 = pos.get(s2);
          
           graph.addAdjacencia(pos1,pos2,v1,v2,listAdjacency.get(i).getValor());
           group = graph.setGroup(pos1,pos2,group);
        }// End for
       
        Scene scene = new Scene(group,width,heigth-60);
        group.getChildren().add(menuBar);
        primaryStage.setTitle("Mapa Mundi");
       
        primaryStage.setScene(scene);
        primaryStage.show();
    }// End start()

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        launch(args);
    }// End main()
    
    
    public static List<Localizacao> getLatLon() throws Exception{
        List<Localizacao> list = new ArrayList<>(0);
         
        DataInputStream data = new DataInputStream(new FileInputStream("C:\\Users\\vinic\\Desktop\\vertex.txt"));
        int n = Integer.parseInt(data.readLine().trim());
        for(int i = 0; i < n; i++){
            String str = data.readLine();
            String string[] = str.split(" ");       
            String sigla = string[0];
            
            double lat = Double.parseDouble(string[1]);
            double lon = Double.parseDouble(string[2]);
            
            list.add(new Localizacao(sigla,lat,lon));
        }// End for
        return list;
    }// End getLatLon()
    
    public static List<Adjacency> getAdjacencia() throws Exception{
        List<Adjacency> list = new ArrayList<>(0);
        DataInputStream data = new DataInputStream(new FileInputStream("C:\\Users\\vinic\\Desktop\\adjacency.txt"));
        int n = Integer.parseInt(data.readLine().trim());
        
        for(int i = 0; i < n; i++){
            String str = data.readLine();
            String string[] = str.split(" ");
            
            String sigla1 = string[0].trim();
            String sigla2 = string[1].trim();
            double valor = Double.parseDouble(string[2]);
            
            list.add(new Adjacency(sigla1,sigla2,valor));
        }// End for
        return list;
    }// End getAdjacencia()
}// End class Main
