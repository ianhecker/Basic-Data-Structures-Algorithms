/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs132mazerecursion;

public class RecursionMethod{

    public static final int NORTH = 1;
    public static final int EAST = 2;
    public static final int SOUTH = 3;
    public static final int WEST = 4;              
    
    char[][] maze;
    Position position = new Position(0, 2);
    Hand hand = new Hand();
    Head head = new Head();
    
    public RecursionMethod(char[][] maze, Position position, Hand hand, Head head){
        //Find path start here
        this.maze = maze;
        this.position = position;
        this.hand = hand;
        this.head = head;
    }
    
    public void mazeRunner(){
        //System.out.println("Px: "+position.getX()+" Py: "+position.getY());
        //System.out.println("HANDx: "+hand.getX()+" HANDy: "+hand.getY()); 
        //System.out.println("HEADx: "+head.getX()+" HEADy: "+head.getY()); 
        print();
        
        if(maze[head.getY()][head.getX()] == 'F'){
            System.out.println("Game Over");
        }
        else if(maze[hand.getY()][hand.getX()] == '.' || maze[hand.getY()][hand.getX()] == 'X'){
            maze[position.getY()][position.getX()] = 'X';            
            goForwardAndRight();
            mazeRunner();
        }
        else if((maze[head.getY()][head.getX()] == '.' || maze[head.getY()][head.getX()] == 'X') && maze[hand.getY()][hand.getX()] == '#'){
            maze[position.getY()][position.getX()] = 'X';            
            goForward();
            mazeRunner();
        }
        else if(maze[head.getY()][head.getX()] == '#' && maze[hand.getY()][hand.getX()] == '#'){
            goLeft();
            mazeRunner();
        }
    }//End of MazeRunner Method
    
    public void goForward(){
        
        int xMovement = 0;
        int yMovement = 0;
        
        if(head.getDirection() == NORTH){
            xMovement = 0;
            yMovement = -1;
        }
        else if(head.getDirection() == EAST){
            xMovement = 1;
            yMovement = 0;
        }
        else if(head.getDirection() == SOUTH){
            xMovement = 0;
            yMovement = 1;
        }
        else if(head.getDirection() == WEST){
            xMovement = -1;
            yMovement = 0;
        }
        position.forward(xMovement, yMovement);
        hand.forward(xMovement, yMovement);
        head.forward(xMovement, yMovement);
    }//End of goForward method
    
    public void goForwardAndRight(){
        
        if(position.getX() < hand.getX()){//Hand is East
            position.changeX(1);            
        }
        else if(position.getX() > hand.getX()){//Hand is West                       
            position.changeX(-1);            
        }
        else if(position.getY() < hand.getY()){//Hand is North                       
            position.changeY(1);            
        }
        else if(position.getY() > hand.getY()){//Hand is South                       
            position.changeY(-1);            
        }
        hand.turnRight();            
        head.turnRight(hand.getDirection());
    }//End of goForwardAndRight method        
    
    public void goLeft(){        
        
        hand.turnLeft(head.getX(), head.getY());
        head.turnLeft();
    }//End of goLeft method
    
    public void print(){
        for(int i=0; i < maze.length; i++){
            for(int j=0; j < maze[i].length; j++){
                if(i == position.getY() && j == position.getX()){
                    System.out.print("O");
                }
                else{
                    System.out.print(maze[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}//End of Class
