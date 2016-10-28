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
public class Head {
    
    private int xCoor;
    private int yCoor;
    private int direction;
    
    public static final int NORTH = 1;
    public static final int EAST = 2;
    public static final int SOUTH = 3;
    public static final int WEST = 4;
    
    public Head(){
        xCoor = 1;
        yCoor = 2;                
        direction = EAST;
    }        
    
    public void turnRight(int handDirection){
        
        if(handDirection == NORTH){
            direction = WEST;
            yCoor--;
            xCoor -= 2;
        }
        else if(handDirection == EAST){
            direction = NORTH;
            xCoor++;
            yCoor -= 2;
        }
        else if(handDirection == SOUTH){
            direction = EAST;
            yCoor++;
            xCoor += 2;
        }
        else if(handDirection == WEST){
            direction = SOUTH;
            xCoor--;
            yCoor += 2;
        }
    }        
    
    public void forward(int xMovement, int yMovement){
        xCoor += xMovement;
        yCoor += yMovement;
    }
    
    public int getDirection(){
        return direction;
    }
    
    public int getX(){
        return xCoor;
    }
    
    public int getY(){
        return yCoor;
    }
    
    public void turnLeft(){
    
        if(direction == NORTH){
            direction = WEST;
            xCoor--;
            yCoor++;
        }
        else if(direction == WEST){
            direction = SOUTH;            
            xCoor++;
            yCoor++;
        }
        else if(direction == SOUTH){
            direction = EAST;            
            xCoor++;
            yCoor--;
        }
        else if(direction == EAST){
            direction = NORTH;            
            xCoor--;
            yCoor--;
        }
    }
}
