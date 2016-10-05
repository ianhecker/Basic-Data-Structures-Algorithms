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
public class RiffRaffList {
    private Node head;
    private Node tail;
    
    public RiffRaffList(){
        head = tail = null;
    }
    
    public void add(Node addition){
        if(head == null){
            head = addition;
            tail = head;
        }
        else{
            tail.setNext(addition);
            addition.setPrevious(tail);
            tail = tail.getNext();
        }
    }//end add
    
    public boolean remove(int remove){
        Node iter, lag, run;
        iter = lag = run = head;
        
        while(iter != null){
            if(remove == iter.getName()){
                
                if(iter == head){
                    head = head.getNext();
                }
                else if(iter == tail){
                    tail = tail.getPrevious();
                }
                else{//Replacing Nodes between first and last
                    lag.setNext(iter.getNext());//sets Nodes' (before remove) next to one after remove
                    iter.setNext(null);
                    iter.setPrevious(null);//sets Node's (after remove) previous to one before remove                    
                    run.setPrevious(lag);//sets Node
                    return true;//Did Replace Node! Exit method
                }
            }//end of check for remove
            else{
                lag = iter;
                iter = iter.getNext();
                run = iter.getNext();
            }
        }//End of while loop
        return false;//Did not replace remove!        
    }//End of remove method
    
    
}
