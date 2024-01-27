/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioclone;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This code was originally created by Rayfuzu Inc. This code is open source for 
 * anyone who thinks that they can make it better.
 *
 * @author Courtney Jean Downs 
 */
public class MarioClone extends Application implements EventHandler<ActionEvent> {

    final int SCENE_WIDTH = 750, SCENE_HEIGHT = 450;
    Player mario;
    final int SUPER_SPEED = 50;
    final int NORMAL_SPEED = 4;
    final int MAP_SPEED = NORMAL_SPEED;//mario speed

    ArrayList<Structure> structures;
    ArrayList<Pipe> pipes;
    final double NORMAL_GROUND_Y_AXIS = 350;
    final double NORMAL_CEILING_Y_AXIS = 50;
    double floor = NORMAL_GROUND_Y_AXIS;
    double playersYAxis = 0;
    double ceiling = 0;
    int animationSpeed = 2;

    public static void main(String[] args) {
        launch(args);
    }

    
    // **************************************************************************************
    // TODO: Improvements 
    //      - variable cloud groupings and variable altitudes (not just one every 100ft)
    //      - pipes that are connected horizzontally to vertical pipes 
    //      - flag pole 
    //      - stairs of smaller bricks 
    //      - more accurage collision detection 
    // 
    // **************************************************************************************

    
    
    
    
    @Override
    public void start(Stage primaryStage) {

        ImageView bgImageView = setBackgroundImage("mario_bg.png");
        mario = createPlayer();
        structures = new ArrayList<>();
        pipes = new ArrayList<>();

        Pane root = new Pane();
        root.getChildren().add(bgImageView);
        root.getChildren().add(mario);
        //Make the player jump if click on screen
        root.setOnMouseClicked((MouseEvent event) -> {

            final int JUMP_HEIGHT = 90;
            //if mario is under the ceiling then let him jump
            if (playersYAxis > ceiling) {
                playersYAxis -= JUMP_HEIGHT;
                mario.setLayoutY(playersYAxis);
            }
        });

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setTitle("Mario Land");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        //Standard keyframe and timeline required for the animation to work!
        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), this);
        Timeline animation = new Timeline(keyFrame);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        //This is an array list of all of the objects that are on the map
        ArrayList<GameObject> map = buildInitialMap(root);
        //Allows the map to move on the scene
        mario.moveListener(scene, map);

    }//end start()

    private ArrayList<GameObject> buildInitialMap(Pane root) {

        //The list that all of the objects in the collections below are added to
        ArrayList<GameObject> map = new ArrayList<>();

        ArrayList<GameObject> clouds = createClouds(25);//quantity, width, height 
        Pipe p1 = createPipe("mario_pipe.png", 50.0, NORMAL_GROUND_Y_AXIS - 50.0, 50, 100);//x,y,width,height
        Pipe p2 = createPipe("mario_pipe.png", 800.0, NORMAL_GROUND_Y_AXIS - 50.0, 50, 100);//x,y,width,height
        Pipe p3 = createPipe("mario_pipe.png", 1850.0, NORMAL_GROUND_Y_AXIS - 50.0, 50, 100);//x,y,width,height
        pipes.add(p1);
        pipes.add(p2);
        pipes.add(p3);

        int vBlocks = 2, hBlocks = 5;
        StructureType type = StructureType.CUSTOM_NORMAL;
        double initX = 220, initY = 150.0;
        ArrayList<Integer> inactiveBlocks = new ArrayList<>();
        inactiveBlocks.add(5);
        inactiveBlocks.add(6);
        inactiveBlocks.add(7);
        inactiveBlocks.add(8);
        inactiveBlocks.add(9);
        Structure s1 = createStructure(vBlocks, hBlocks, StructureType.CUSTOM_NORMAL, initX, initY, inactiveBlocks);

        vBlocks = 1;
        hBlocks = 4;
        initX = 500;
        initY = 200.0;
        inactiveBlocks.clear();

        Structure s2 = createStructure(vBlocks, hBlocks, StructureType.REGULAR_INTERACTIVE, initX, initY, inactiveBlocks);
        initY = 200;
        initX += 500;
        vBlocks = 4;
        hBlocks = 4;
        inactiveBlocks.add(0);
        inactiveBlocks.add(1);
        inactiveBlocks.add(2); 
        inactiveBlocks.add(4); 
        inactiveBlocks.add(5); 
        inactiveBlocks.add(8); 
        
        Structure s3 = createStructure(vBlocks, hBlocks, type, initX, initY, inactiveBlocks);
        
        
        
        initY = 150;
        initX += 400;
        vBlocks = 1;
        hBlocks = 5;
        inactiveBlocks.clear();
        inactiveBlocks.add(5);
        inactiveBlocks.add(6);
        inactiveBlocks.add(7);
        inactiveBlocks.add(8);
        inactiveBlocks.add(9);
        Structure s4 = createStructure(vBlocks, hBlocks, StructureType.REGULAR_INTERACTIVE, initX, initY, inactiveBlocks);

        
        initY = 200;
        initX += 600;
        vBlocks = 1;
        hBlocks = 8;
        inactiveBlocks.clear(); 
        inactiveBlocks.add(1);
        inactiveBlocks.add(2);
        inactiveBlocks.add(3);
        inactiveBlocks.add(4);
        inactiveBlocks.add(5);
        inactiveBlocks.add(6);
        Structure s5 = createStructure(vBlocks, hBlocks, StructureType.REGULAR_INTERACTIVE, initX, initY, inactiveBlocks);
        initY = 200;
        initX += 900;
        vBlocks = 4;
        hBlocks = 4;
        inactiveBlocks.clear();
        inactiveBlocks.add(5);
        inactiveBlocks.add(6);
        inactiveBlocks.add(7);
        inactiveBlocks.add(8);
        inactiveBlocks.add(9);
        Structure s6 = createStructure(vBlocks, hBlocks, StructureType.REGULAR_INTERACTIVE, initX, initY, inactiveBlocks);

        
         
        
        
        structures.add(s1);
        structures.add(s2);
        structures.add(s3);
        structures.add(s4);
        structures.add(s5);
        structures.add(s6);

        //Creates the first enemy and starts it's animation 
        Enemy enemy1 = createEnemy(200, 375);
        objectAnimations(enemy1, 0, 0);

        //Adding everything to the map (ArrayList<ImageView>)
        addGameObjectsToMap(map, clouds);
        map.add(p1);
        map.add(p2);
        map.add(p3);
        addStrucutreToMap(map, s1);
        addStrucutreToMap(map, s2);
        addStrucutreToMap(map, s3);
        addStrucutreToMap(map, s4);
        addStrucutreToMap(map, s5);
        addStrucutreToMap(map, s6);

        map.add(enemy1);

        //Adding everying in the map to the root pane
        for (int i = 0; i < map.size(); i++) {
            root.getChildren().add(map.get(i));
        }

        return map;
    }//buildInitialMap()

    private ArrayList<GameObject> createClouds(int quantity ) {
        
        
        double width = 103;//(int) (90 + Math.random() * 100);//100;
        double height = 72;//(int) (60 + Math.random() * 70);//70;
        
        ArrayList<GameObject> allClouds = new ArrayList<>();
        double layoutX = 100;
        double previousCloudX = 0;
        for (int i = 0; i < quantity; i++) {
            Image newCloud = new Image("cloud.png");
            GameObject newView = new GameObject(newCloud);
            newView.setLayoutX(layoutX);
            //Calculates space between clouds
            layoutX = previousCloudX + (int) (10 + Math.random() * 410);
            previousCloudX = layoutX;
            
            newView.setLayoutY( (int) (12 + Math.random() * 30) ); // 20
            newView.setFitWidth(width);
            newView.setFitHeight(height);
            allClouds.add(newView);
        }
        return allClouds;
    }

    private Structure createStructure(int vBlocks, int hBlocks, StructureType type,
            double initX, double initY, ArrayList<Integer> inactiveBlocks) {

        //Vertical blocks and horizontal blocks 
        final int TOTAL_BLOCKS = vBlocks * hBlocks;
        Structure newStructure = new Structure();
        //initialize a CUSTOM_NORMAL, and REGULAR_NORMAL  structure 
        initStructure(TOTAL_BLOCKS, vBlocks, initX, initY, newStructure, inactiveBlocks, type);

        return newStructure;
    }

    private void initStructure(int totalBlocks, int vBlocks, double initLayoutX, double layoutY,
            ArrayList<GameObject> newGroup, ArrayList<Integer> inactiveBlocks, StructureType type) {

        final int BLOCK_WIDTH = 40;
        final int BLOCK_HEIGHT = BLOCK_WIDTH;
        for (int i = 0; i < totalBlocks; i++) {

            int hBlocks = totalBlocks / vBlocks;
            GameObject newBlock = setBlockImage(type);
            //if newItem is the first entry in the list then set its 
            //layout x to the initial layout x 
            if (i == 0 || i % hBlocks == 0) {
                newBlock.setLayoutX(initLayoutX);
            } //all other entries will be set to its previous entry's layout x + spaceBetween
            else {
                newBlock.setLayoutX(newGroup.get(i - 1).getLayoutX()
                        + BLOCK_WIDTH);
            }            
            newBlock.setFitWidth(BLOCK_WIDTH);
            newBlock.setFitHeight(BLOCK_HEIGHT);

            if (i % hBlocks == 0) {
                layoutY += BLOCK_HEIGHT;
            }
            if (inactiveBlocks.contains(i)) {
                //Do not add the block image here
                newBlock.setVisible(false);
            }
            newBlock.setLayoutY(layoutY);
            newGroup.add(newBlock);
        }

    }

    private void addStrucutreToMap(ArrayList<GameObject> map, Structure struct) {
        for (int index = 0; index < struct.size(); index++) {
            GameObject currentBlock = struct.get(index);
            map.add(currentBlock);
        }
    }

    private void addGameObjectsToMap(ArrayList<GameObject> map, ArrayList<GameObject> images) {
        for (int index = 0; index < images.size(); index++) {
            GameObject currentBlock = images.get(index);
            map.add(currentBlock);
        }
    }
 
    private GameObject setBlockImage(StructureType type) {
        if (type == StructureType.REGULAR_INTERACTIVE) {
            return generateRandomBlock();
        } else {
            return generateNormalBlock();
        }
    }

    private GameObject generateRandomBlock() {
        int randomIndex = (int) (0 + Math.random() * 3);
        Image img1 = new Image("brick_block.png");
        GameObject imgView1 = new GameObject(img1, 0, 0, 0, 0);
        Image img2 = new Image("unknown_block.png");
        GameObject imgView2 = new GameObject(img2, 0, 0, 0, 0);
        Image img3 = new Image("used_block.png");
        GameObject imgView3 = new GameObject(img3, 0, 0, 0, 0);

        ArrayList<GameObject> list = new ArrayList<>();
        list.add(imgView1);
        list.add(imgView2);
        list.add(imgView3);

        return list.get(randomIndex);
    }

    private GameObject generateNormalBlock() {
        Image img1 = new Image("used_block.png");
        return new GameObject(img1, 0, 0, 0, 0);

    }

    private Pipe createPipe(String fileName, double x, double y, int width,
            int height) {

        Image img = new Image(fileName);
        Pipe pipe = new Pipe(img, x, y, width, height);
        return pipe;
    }

    private Player createPlayer() { 
        Image player = new Image("mario_character.gif");
        Player marioPlayer = new Player(player, SCENE_WIDTH / 2.5, playersYAxis, 50, 50, 100);
        return marioPlayer;
    }

    private Enemy createEnemy(double x, double y) {
        Image enemy = new Image("enemy.gif");
        Enemy officialEnemy = new Enemy(enemy, x, y, 25, 25);
        officialEnemy.setHealthState(true);

        return officialEnemy;
    }

    private ImageView setBackgroundImage(String fileName) {
        //TODO - figure out how to get this to work for different levels (change scenes ?)
        Image background = new Image(fileName);
        ImageView bgImageView = new ImageView(background);
        bgImageView.setFitHeight(SCENE_HEIGHT + 20);
        bgImageView.setFitWidth(SCENE_WIDTH + 20);

        return bgImageView;
    }

  
    private int getCurrentPipeIndex() {
        int index = 0;
        for (int i = 0; i < pipes.size(); i++) {
            //if the current pipes's end layout x value is greater than 
            //mario's layout x 
            if (pipes.get(i).getEndLayoutX() + mario.getFitWidth() > mario.getLayoutX()) {
                index = i;
                break;
            }//end if 
        }
        return index;
    }

    
    //TODO - fix me. This code needs to be cleaner.
    private void pipeCollisionDetection(Pipe pipe) {
        double playersX = mario.getLayoutX();
        double playersY = mario.getLayoutY();

        //if mario is between the x bounds of the current pipe 
        if (playersX > pipe.getStartLayoutX() && playersX < pipe.getEndLayoutX()) {
            //set the groundYAxis value to be the top of the pipe
            floor = NORMAL_GROUND_Y_AXIS - pipe.getFitHeight();
        } //if mario is not between the x bounds of the current pipe
        else {
            floor = NORMAL_GROUND_Y_AXIS;
        }//end if else 

        //if mario is below the height of the current pipe object 
        if (playersY > (NORMAL_GROUND_Y_AXIS - pipe.getFitHeight())) {

            //if mario has hit the left side of the current pipe 
            if (playerHitSideOfPipe("LEFT", playersX, pipe)) {
                //stop movement 
                mario.setRightSpeed(0);
            } else {
                //allow movement 
                mario.setRightSpeed(MAP_SPEED);
            }//end if else 

            //if mario has hit the right side of the current pipe 
            if (playerHitSideOfPipe("RIGHT", playersX, pipe)) {
                //stop movement 
                mario.setLeftSpeed(0);
            } else {
                //allow movement 
                mario.setLeftSpeed(MAP_SPEED);
            }//end if else 
        } //if mario is above the height of the pipe then allow movement in both 
        //dirrections 
        else {
            mario.setLeftSpeed(MAP_SPEED);
            mario.setRightSpeed(MAP_SPEED);
        }
    }
 
    
    private boolean playerHitSideOfPipe(String sideToCheck, double playersX, Pipe pipe) {

        //TODO - this method looks useless see if you can remove it with something better
        if (sideToCheck.equalsIgnoreCase("LEFT")) {
            return playersX == pipe.getStartLayoutX()
                    || playersX == pipe.getStartLayoutX() - 1
                    || playersX == pipe.getStartLayoutX() - 2
                    || playersX == pipe.getStartLayoutX() - 3;//TODO - fix code so that you don't need these offsets or magic numbers anywhere
        } else {
            return playersX == pipe.getEndLayoutX()
                    || playersX == pipe.getEndLayoutX() + 1
                    || playersX == pipe.getEndLayoutX() + 2
                    || playersX == pipe.getEndLayoutX() + 3;
        }
    }

    private int getCurrentStructureIndex() {
        int index = 0;
        for (int i = 0; i < structures.size(); i++) {
            //if the current structure's end layout x value is greater than 
            //mario's layout x 
            int lastIndex = structures.get(i).size() - 1;
            double endLayoutX = structures.get(i).get(lastIndex).getLayoutX();
            if (endLayoutX + mario.getFitWidth() > mario.getLayoutX()) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void testCollisionMethod(Structure struct) {
        for (int i = 0; i < struct.size(); i++) {
            GameObject currentBlock = struct.get(i);
            //If this block is active set it's bounds 
            if (currentBlock.isVisible()) {
                //update block's bounds 

                //TODO - how to get mario to stop jumping up through structures 
                System.out.println("Ceiling: " + ceiling + "    Floor: " + floor);

                currentBlock.setLeftBound(currentBlock.getLayoutX());
                currentBlock.setRightBound(currentBlock.getLayoutX() + currentBlock.getFitWidth());
                currentBlock.setTopBound(currentBlock.getLayoutY());
                currentBlock.setBottomBound(currentBlock.getLayoutY() + currentBlock.getFitHeight());
                //update mario's bounds 
                mario.setLeftBound(mario.getLayoutX());
                mario.setRightBound(mario.getLayoutX() + mario.getFitWidth());
                mario.setTopBound(mario.getLayoutY());
                mario.setBottomBound(mario.getLayoutY() + mario.getFitHeight());

                //check if they are touching 
                if ((mario.getRightBound() == currentBlock.getLeftBound())
                        && (mario.getLayoutY() > currentBlock.getLayoutY())
                        && (mario.getLayoutY() < (currentBlock.getLayoutY() + currentBlock.getFitHeight()))) {
                    //stop moving right
                    mario.setRightSpeed(0);
                    mario.setLeftSpeed(3);
                    //System.out.println("Hit left wall." + "Block #: " + i);
                } else if ((mario.getTopBound() == currentBlock.getBottomBound())
                        && (mario.getLayoutX() > currentBlock.getLayoutX())
                        && (mario.getLayoutX() < (currentBlock.getLayoutX() + currentBlock.getFitWidth()))) {
                    //stop moving up
                    ceiling = currentBlock.getBottomBound();
                    floor = NORMAL_GROUND_Y_AXIS;
                    //System.out.println("Hit ceiling." + "Block #: " + i);
                } else if ((mario.getLeftBound() == currentBlock.getRightBound())
                        && (mario.getLayoutY() > currentBlock.getLayoutY())
                        && (mario.getLayoutY() < (currentBlock.getLayoutY() + currentBlock.getFitHeight()))) {
                    //stop moving left 
                    mario.setLeftSpeed(0);
                    mario.setRightSpeed(3);
                    //System.out.println("Hit right wall." + "Block #: " + i);
                } else if ((mario.getBottomBound() == currentBlock.getTopBound())
                        && (mario.getLayoutX() > currentBlock.getLayoutX())
                        && (mario.getLayoutX() < (currentBlock.getLayoutX() + currentBlock.getFitWidth()))) {
                    //stop moving down
                    floor = currentBlock.getTopBound() - 50;
                    ceiling = 0;
                    System.out.println("Floor Y value: " + currentBlock.getTopBound()
                            + " Mario y value: " + mario.getBottomBound());
                    //System.out.println("Hit floor." + "Block #: " + i);
                    break;
                } //Makes mario fall off either edge of the structure 
                else if ((mario.getLayoutX() > struct.get(struct.size() - 1).getRightBound())
                        || (mario.getLayoutX() < struct.get(0).getLeftBound())) {
                    floor = NORMAL_GROUND_Y_AXIS;

                }

            } //Makes mario fall to the ground if he is standing on an inactive block 
            else if (currentBlock.isVisible() == false) {
                if ((mario.getBottomBound() == currentBlock.getTopBound())
                        && (mario.getLayoutX() > currentBlock.getLayoutX())
                        && (mario.getLayoutX() < (currentBlock.getLayoutX() + currentBlock.getFitWidth()))) {
                    //   floor = NORMAL_GROUND_Y_AXIS;
                    System.out.println("Floatingggg....");
                }
            }
        }

    }

    //TODO - update this method to work for current type of stuctures and interactive structures 
    private void structureCollisionDetection(Structure struct) {
//        double playersX = mario.getLayoutX();
//        final double STRUCTURE_SIZE_OFFSET = 30;
//        //if mario is between the start and end x axis of the structure
//        if (((struct.get(0).getLayoutX() - STRUCTURE_SIZE_OFFSET) <= playersX)
//                && ((struct.get(struct.size() - 1).getLayoutX() + STRUCTURE_SIZE_OFFSET)
//                >= playersX)) {
//            //if mario is above this platfrm 
//            if (mario.getLayoutY() < (struct.get(0).getLayoutY() - 50)) {
//                //set the structure y axis to be the ground
//                groundYAxis = struct.get(0).getLayoutY() - 50;
//            }
//            //if mario is below the structure 
//            if (mario.getLayoutY() > struct.get(0).getLayoutY()) {
//                ceilingYAxis = struct.get(0).getLayoutY() + 10;
//            }
//        } else {
//            groundYAxis = NORMAL_GROUND_Y_AXIS;
//            ceilingYAxis = NORMAL_CEILING_Y_AXIS;
//        }

        testCollisionMethod(struct);
    }

    /**
     * This method finds the next object to check it's collision for.
     */
    private void setCurrentIntersectingTarget() {

        Structure currentStructure = structures.get(getCurrentStructureIndex());
        Pipe currentPipe = pipes.get(getCurrentPipeIndex());
        //System.out.println("Ground y: " + groundYAxis + " Ceiling y: " + ceilingYAxis);

//        System.out.println("Current Structure Index: " + getCurrentStructureIndex() + ", "
//                + "Structure startX, endX: " + " ("
//                + currentStructure.get(0).getLayoutX() + " , " + currentStructure.get(0).getLayoutX()
//                + " ) \n");
        //if mario is closer to a Structure then have the collision detection 
        //check for a Structure object 
        if (findClosestObject(currentStructure, currentPipe)
                == GameObjectGroupType.STRUCTURE) {
            structureCollisionDetection(currentStructure);
        } //else if mario is closer to a Pipe then have the collision detection 
        //check for a Pipe object
        else if (findClosestObject(currentStructure, currentPipe)
                == GameObjectGroupType.PIPE) {
            pipeCollisionDetection(currentPipe);
        }
    }

    /**
     * This method finds out the type of GameObject group that Mario is closest
     * to at the current moment so that the proper collision detection method
     * can be called.
     *
     */
    private GameObjectGroupType findClosestObject(Structure structure, Pipe pipe) {
        GameObjectGroupType result = null;
        double distanceFromStructure = Math.abs(mario.getLayoutX() - structure.get(0).getLayoutX());
        double distanceFromPipe = Math.abs(mario.getLayoutX() - pipe.getStartLayoutX());
        if (distanceFromStructure < distanceFromPipe) {
            //mario is closer to the structure
            result = GameObjectGroupType.STRUCTURE;
        } else if (distanceFromPipe < distanceFromStructure) {
            //mario is closer to the pipe
            result = GameObjectGroupType.PIPE;
        }//end if else if 

        return result;
    }//end findClosestObject()

    private void objectAnimations(GameObject p, double leftBounds, double rightBounds) {
        EventHandler<ActionEvent> handler = e -> {
            p.setLayoutX(p.getLayoutX() + animationSpeed);
            if (p.getLayoutX() == rightBounds) {
                animationSpeed = -5;
            }
            if (p.getLayoutX() == leftBounds) {
                animationSpeed = 5;
            }
        };
        //This is a new timeline object
        Timeline animated = new Timeline(new KeyFrame(Duration.millis(50), handler));
        animated.setCycleCount(Timeline.INDEFINITE);
        animated.play();
    }

    @Override
    public void handle(ActionEvent event) {

//        System.out.println("Player Location (x,y)" + "( " + mario.getLayoutX()
//                + " , " + mario.getLayoutY() + " )");
        //Make Mario fall.
        if (playersYAxis <= floor) {
            playersYAxis = playersYAxis + 1;
        }

        //TODO - should all of the code in this class be inside of some kind of GameState class?
        //      That way this class can just have a few basic lines that can be modified to create the map.
        //TODO - how to get mario to stop jumping up through structures 
        mario.setLayoutY(playersYAxis);
        setCurrentIntersectingTarget();

    }

}
