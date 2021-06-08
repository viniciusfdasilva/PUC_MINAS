/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleaereo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import localizacao.Localizacao;

/**
 *
 * @author Vinicius Silva
 */
public class Main extends Application{    
    static int n;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
       
        Group group = new Group();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension scrnsize = toolkit.getScreenSize();
        
        int width = (int)scrnsize.getWidth();
        int heigth = (int)scrnsize.getHeight();
        
        Image image = new Image(
                "https://www.guiageo-mapas.com/imagens/mapa-mundi.jpg",
                 width,
                 heigth-150,
                 false,
                 false);
        
        
        double mapW = width;
        double mapH = heigth-150;
        System.out.println(mapW + " " + mapH);
        double y;
        double x = y = 0;
        group.getChildren().add(new ImageView(image));
        List<Localizacao> list = getLatLon();
        List<Circle> listc = new ArrayList<>(0);
        
        for(int i = 0; i < n; i++){
            System.out.println(list.get(i).getLatitude() + " " + list.get(i).getLongitude());
            
            x = (list.get(i).getLongitude() + 180) * (mapW / 360);
            double latRad = list.get(i).getLatitude() * Math.PI / 180;
            double mercN = Math.log(Math.tan((Math.PI/4) + (latRad/2)));
            y = (mapH/2) - (mapW*mercN/(2*Math.PI));
            
            listc.add(new Circle(3));
            listc.get(i).setTranslateX((int)x);
            listc.get(i).setTranslateY((int)y);
            listc.get(i).setFill(Color.RED);
            
            group.getChildren().add(listc.get(i));
        }// End for   
        
        Scene scene = new Scene(group,width,heigth-60);
        
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
    
    
    public static List<Localizacao> getLatLon()throws Exception{
        List<Localizacao> list = new ArrayList<>(0);
         
        DataInputStream data = new DataInputStream(new FileInputStream("C:\\Users\\vinic\\Desktop\\teste.txt"));
        data.readInt();
        n = 5;
        System.out.println("Teste "+n);
        for(int i = 0; i < n; i++){
            String str = data.readLine();
            String string[] = str.split(" ");
            
            double lat = Double.parseDouble(string[1]);
            double lon = Double.parseDouble(string[2]);
            
            System.out.println(lat + " " + lon);
            list.add(new Localizacao(lat,lon));
        }// End for
        return list;
    }// End getLatLon()
}// End class Main
