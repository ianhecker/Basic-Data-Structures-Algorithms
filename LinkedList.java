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
public class LinkedList {
    private Node head;
    private Node tail;
    
    public LinkedList(){
        head = tail = null;
    }
    
    public void add(Node addition){
        if(head == null){//If list is empty
            head = addition;
            tail = head;
        }
        else{
            tail.setNext(addition);//add to end            
            addition.setPrevious(tail);//sets previous node
            tail = tail.getNext();//moves tail down
            
        }
    }
    
    public void print(){
        Node iter = head;
        while(iter != null){
            System.out.print("\n"+iter.getName()+" "+iter.getId());
            iter = iter.getNext();
        }
        System.out.println();
    }
    
    public void printBackwards(){
        Node iter = tail;        
        while(iter != null){
            System.out.print("\n"+iter.getName()+" "+iter.getId());
            iter = iter.getPrevious();                            
        }
        System.out.println();
    }
    
    public boolean remove(String subtraction){
        Node iter = head;//current Node
        Node lag = head;//previous Node
        Node run = head;//next Node
        
        while(iter != null){
            
            if(subtraction.equals(iter.getName())){
                
                if(iter == head){//Special case for removing first Node
                    head = head.getNext();
                }
                else if(iter == tail){//Special case for removing last Node
                    tail = tail.getPrevious();                 
                }
                else{//Replacing Nodes between first and last
                    lag.setNext(iter.getNext());//sets Node's (before subtraction) next to one after subtraction
                    iter.setNext(null);
                    iter.setPrevious(null);
                    run.setPrevious(lag);//sets Node's (after subtraction) previous to one before subtraction  
                    return true;//Did replace Node
                }                
            }//end of check for subtraction == node
            else{
                lag = iter;
                iter = iter.getNext();
                run = iter.getNext();
            }            
        }//End of while loop
        return false;//did not replace Node
    }//End of remove method
    
    public boolean search(String toFind){
        Node iter = head;        
        
        while(iter != null){
            if(toFind.equals(iter.getName())){                                
                return true;                                
            }
            else{
                iter = iter.getNext();
            }
        }//End of while loop        
        return false;
    }//End of search method
    
    public void deleteList(){
        Node iter = head;
        Node lag = head;
        
        while(iter != null){
            iter.setPrevious(null);
            iter = iter.getNext();
            lag.setNext(null);
            lag = iter;
        }
        head = null;
        tail = null;
    }
}//End of LinkedList Class

