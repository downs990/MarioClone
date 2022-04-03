/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioclone;

import java.util.ArrayList;

/**
 * A Structure is a wall of vertical and horizontal blocks that can be
 * as large as the user wants. They can also specify specifically which 
 * blocks in that particular structure are going to be rendered inactive (invisible).
 *
 * @author courtney
 */
public class Structure extends ArrayList<GameObject>{
    
    int verticalBlocks;
    int horizontalBlocks;
    StructureType  type;
    
    public Structure(){
        //No Arg
    }
    
    public Structure(int verticalBlocks, int horizontalBlocks, StructureType type){
        this.verticalBlocks = verticalBlocks;
        this.horizontalBlocks = horizontalBlocks;
        this.type = type;
    }

    public int getVerticalBlocks() {
        return verticalBlocks;
    }

    public int getHorizontalBlocks() {
        return horizontalBlocks;
    }

    public StructureType getType() {
        return type;
    }

    public void setVerticalBlocks(int verticalBlocks) {
        this.verticalBlocks = verticalBlocks;
    }

    public void setHorizontalBlocks(int horizontalBlocks) {
        this.horizontalBlocks = horizontalBlocks;
    }

    public void setType(StructureType type) {
        this.type = type;
    }
    
    
            
    
}
