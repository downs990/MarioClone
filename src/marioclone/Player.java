/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioclone;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Rotate;

/**
 *
 * @author courtney
 */
public class Player extends Character {

    private double sizeScale; //determines how large the character grows 
    private final int MAP_SPEED = 3;
    private int rightSpeed = MAP_SPEED;
    private int leftSpeed = MAP_SPEED;
   
    public Player( Image image, double layoutX, double layoutY, int width, 
            int height, double sizeScale) {
        super(image, layoutX, layoutY, width, height);
        setHealthState(true);
        this.setDurability(Durability.DESTRUCTIBLE);
        this.sizeScale = sizeScale;
    } 

    public void setSizeScale(double sizeScale) {
        this.sizeScale = sizeScale;
    } 

    public double getSizeScale() {
        return sizeScale;
    } 

    public int getRightSpeed() {
        return rightSpeed;
    }

    public int getLeftSpeed() {
        return leftSpeed;
    }

    public void setRightSpeed(int rightSpeed) {
        this.rightSpeed = rightSpeed;
    }

    public void setLeftSpeed(int leftSpeed) {
        this.leftSpeed = leftSpeed;
    }
    
    @Override
    public void moveListener(Scene scene, ArrayList<GameObject> map) {
 
        this.setRotationAxis(Rotate.Y_AXIS);
        scene.setOnKeyPressed((KeyEvent key) -> {

            if (key.getCode() == KeyCode.RIGHT) {
                this.leftSpeed = 3;

                for (int i = 0; i < map.size(); i++) {
                    map.get(i).setLayoutX(map.get(i).getLayoutX() - rightSpeed);
                }

                this.setRotate(360);

            } else if (key.getCode() == KeyCode.LEFT) {
                this.rightSpeed = 3;
                
                for (int i = 0; i < map.size(); i++) {
                    map.get(i).setLayoutX(map.get(i).getLayoutX() + leftSpeed);
                }

                this.setRotate(180);
            } 

        });
    } 

}
