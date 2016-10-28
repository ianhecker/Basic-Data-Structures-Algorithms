/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs132mazerecursion;

/**
 *
 * @author Ian
 */
public class Hand {

    public static final int NORTH = 1;
    public static final int EAST = 2;
    public static final int SOUTH = 3;
    public static final int WEST = 4;
    
    private int xCoor;
    private int yCoor;
    int direction;
    
    public Hand(){
        xCoor = 0;
        yCoor = 3;
        direction = SOUTH;
    }
    
    public int getX(){
        return xCoor;
    }
    
    public int getY(){
        return yCoor;
    }
    
    public int getDirection(){
        return direction;
    }
    
    public void turnRight(){//Changes hand direction and moves coordinate accordingly
        
        if(direction == NORTH){
            direction = EAST;
            xCoor++;
        }
        else if(direction == EAST){
            direction = SOUTH;
            yCoor++;
        }
        else if(direction == SOUTH){
            direction = WEST;
            xCoor--;
        }
        else if(direction == WEST){
            direction = NORTH;
            yCoor--;
        }
    }
    
    public void forward(int xMovement, int yMovement){
        xCoor += xMovement;
        yCoor += yMovement;
    }
    
    public void turnLeft(int headXCor, int headYCor){
        
        xCoor = headXCor;
        yCoor = headYCor;
        
        if(direction == NORTH){
            direction = WEST;            
        }
        else if(direction == WEST){
            direction = SOUTH;            
        }
        else if(direction == SOUTH){
            direction = EAST;            
        }
        else if(direction == EAST){
            direction = NORTH;            
        }
    }
}
