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
abstract class Character extends GameObject {

    private boolean alive;
    abstract public void moveListener(Scene scene, ArrayList<GameObject> map);

    public Character(Image image, double x, double y, int width, int height) {
        super(image, x, y, width, height);
        this.setDurability(Durability.DESTRUCTIBLE);
        alive = true;
    }//end GameObject()

    public void setHealthState(boolean healthState) {
        alive = healthState;
    }//end setHealthState()

    public boolean getHealthState() {
        return alive;
    }//end getHealthState()

}
