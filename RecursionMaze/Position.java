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
public class Position {

    private int xCoor;
    private int yCoor;
    
    public Position(int xCoor, int yCoor){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
    }
    
    public int getX(){
        return xCoor;
    }
    
    public int getY(){
        return yCoor;
    }
    
    public void changeX(int xChange){
        xCoor = xCoor + xChange;
    }
    
    public void changeY(int yChange){
        yCoor = yCoor + yChange;
    }
    
    public void forward(int xMovement, int yMovement){
        xCoor += xMovement;
        yCoor += yMovement;
    }
}
