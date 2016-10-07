/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package politicalriffraff;

/**
 *
 * @author Ian
 */
public class Node {
    
    private RiffRaff objectData;
    private Node next;
    private Node previous;
    
    public Node(RiffRaff stu){
        objectData = stu;
        next = null;
        previous = null;
    }
    
    public void setNext(Node n){
        next = n;
    }
    
    public void setPrevious(Node p){
        previous = p;
    }
    
    public Node getNext(){
        return next;
    }
    
    public Node getPrevious(){
        return previous;
    }       
    
    public int getName(){
        return objectData.getName();
    }
    
    
}//end of class


