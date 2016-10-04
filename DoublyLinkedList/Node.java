/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlisttesting;

/**
 *
 * @author Ian
 */
public class Node {
    
    private Student objectData;
    private Node next;
    private Node previous;
    
    public Node(Student stu){
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
        
    @Override
    public String toString(){
        System.out.println(objectData.getName());        
        System.out.print(" "+objectData.getId());
        return "";
    }
    
    public int getId(){
        return objectData.getId();
    }
    
    public String getName(){
        return objectData.getName();
    }
    
    
}//end of class

