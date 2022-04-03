/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioclone;

import javafx.scene.image.Image;

/**
 *
 * @author courtney
 */
public class Pipe extends GameObject{
    
    //TODO - add a feature to the pipe class that will 
    //      allow them to let the player teleport across the 
    //      map to other pipes. 
    
    //TODO - tutorial for changing scenes is on gmail
    
     public Pipe (Image image, double x, double y, int width, int height) {
        super(image, x, y, width, height);
        this.setDurability(Durability.INDESTRUCTIBLE);
    } 
     
    public double getEndLayoutX(){
        return this.getLayoutX() + this.getFitWidth();
    }  
    
    public double getStartLayoutX(){
        return this.getLayoutX() - (this.getFitWidth() );
    }
     
}
