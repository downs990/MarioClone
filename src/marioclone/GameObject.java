/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioclone;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author courtney
 */
public class GameObject extends ImageView {

    private Durability durability;
    private double leftBound;
    private double rightBound;
    private double topBound;
    private double bottomBound;
    
    
    
    
    public GameObject() {
        durability = Durability.INDESTRUCTIBLE;
    } 
    
    public GameObject(Image image) {
        super(image);
    } 

    public GameObject(Image image, double x, double y, int width, int height) {
        this.setImage(image);
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setFitWidth(width);
        this.setFitHeight(height);
        durability = Durability.INDESTRUCTIBLE;
    } 

    public double getLeftBound() {
        return leftBound;
    }

    public double getRightBound() {
        return rightBound;
    }

    public double getTopBound() {
        return topBound;
    }

    public double getBottomBound() {
        return bottomBound;
    }

    public void setLeftBound(double leftBound) {
        this.leftBound = leftBound;
    }

    public void setRightBound(double rightBound) {
        this.rightBound = rightBound;
    }

    public void setTopBound(double topBound) {
        this.topBound = topBound;
    }

    public void setBottomBound(double bottomBound) {
        this.bottomBound = bottomBound;
    }    
    
    public void setDurability(Durability durability) {
        this.durability = durability;
    } 

    public Durability getDurability() {
        return durability;
    } 

}
