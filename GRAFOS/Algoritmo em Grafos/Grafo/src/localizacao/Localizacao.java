/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localizacao;

/**
 *
 * @author Vinicius Silva
 */
public class Localizacao{
    private double latitude;
    private double longitude;
    
    public Localizacao(double latitude,double longitude){
        setLatitude(latitude);
        setLongitude(longitude);
    }// End Localizacao()

    public double getLatitude(){
        return latitude;
    }// End getLatitude()

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }// End setLatitude()

    public double getLongitude(){
        return longitude;
    }// End getLongitude()

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }// End setLongitude()
}// End Localizacao
