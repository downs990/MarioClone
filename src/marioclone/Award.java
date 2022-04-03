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
public class Award extends GameObject{
    
    private int pointValue;
    
    public Award(){
        
    } 
    
    public Award(int pointValue,Image image, int layoutX, int layoutY 
        ,int width, int height){
        super(image, layoutX, layoutY, width, height);
        this.pointValue = pointValue;
    } 
    
    public void setPointValue(int pointValue){
        this.pointValue = pointValue;
    } 
    
    public int getPointValue(){
        return pointValue;
    } 
}
