/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioclone;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 *
 * @author courtney
 */
public class Enemy extends Character {

    public Enemy(Image image, double layoutX, double layoutY, int width, int height) {
        super(image, layoutX, layoutY, width, height);
        this.setDurability(Durability.DESTRUCTIBLE);
    } 

    @Override
    public void moveListener(Scene scene, ArrayList<GameObject> map) {
        
    } 

    //take a life from the current player object 
    public boolean terminate(Player currentPlayer) {
        return false;
    } 
    
    
    @Override
    public String toString(){
        return null;
    }

}
