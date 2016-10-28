/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs132mazerecursion;

/**
 *
 * @author Ian Hecker
 */
public class MazeRecursionDriver {       
    
    public static void main(String[] args) {
        
        char[][] maze = new char[][]{
        {'#','#','#','#','#','#','#','#','#','#','#','#'},
        {'#','.','.','.','#','.','.','.','.','.','.','#'},
        {'.','.','#','.','#','.','#','#','#','#','.','#'},
        {'#','#','#','.','#','.','.','.','.','#','.','#'},
        {'#','.','.','.','.','#','#','#','.','#','.','#'},
        {'#','#','#','#','.','#','F','#','.','#','.','#'},
        {'#','.','.','#','.','#','.','#','.','#','.','#'},
        {'#','#','.','#','.','#','.','#','.','#','.','#'},
        {'#','.','.','.','.','.','.','.','.','#','.','#'},
        {'#','#','#','#','#','#','.','#','#','#','.','#'},
        {'#','.','.','.','.','.','.','#','.','.','.','#'},
        {'#','#','#','#','#','#','#','#','#','#','#','#'}  
        };          
               
        Position position = new Position(0, 2);
        Hand hand = new Hand();
        Head head = new Head();
        RecursionMethod maze1 = new RecursionMethod(maze, position, hand, head);        
        
        maze1.mazeRunner();
        //findEntrance(maze);
    }
    /*
    public static void findEntrance(char[][] maze){
        int xCoor = 0;
        int yCoor = 0;
        
        for(int leftCol = 0; leftCol < maze[0].length; leftCol++){
            if(maze[leftCol][0] == '.'){
                xCoor = 0;
                yCoor = leftCol;
                break;
            }            
        }
        for(int botRow = 0; botRow < maze[maze[0].length-1][0]; botRow++){
            if(maze[maze[0].length-1][botRow] == '.'){
                xCoor = botRow;
                yCoor = (maze[0].length-1);
                break;
            }
        }
        for(int rightCol = (maze.length-1); rightCol < maze[maze.length-1].length-1; rightCol++){
            if(maze[rightCol][maze.length-1] == '.'){
                xCoor = (maze.length-1);
                yCoor = rightCol;
                break;
            }
        }    
        for(int topRow = 0; topRow < (maze.length); topRow++){
            if(maze[0][topRow] == '.'){
                xCoor = topRow;
                yCoor = 0;
            }
        }        
    }*/
    
}
