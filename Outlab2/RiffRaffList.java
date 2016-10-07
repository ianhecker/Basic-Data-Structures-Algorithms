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
    
    public void addNumberN(int numberN){
        
        int iter = 1;
        Node addition;
        
        while(iter != (numberN+1)){                        
            addition = new Node(new RiffRaff(iter));//Create node with name = iter
            iter++;
            
            if(head == null){//Starts list, only one item in list at this time                
                head = addition;                                
                tail = head;
            }
            else{
                tail.setNext(addition);//adds addition after tail
                addition.setPrevious(tail);//adds reference from addition back to tail
                
                tail = tail.getNext();//addition becomes tail
                
                tail.setNext(head);//Loops list ahead to head
                head.setPrevious(tail);//Loops list back to tail
            }
        }
    }//end add method
    public void ringAroundTheRosy(int k, int m){
        Node kStart = head;
        Node mStart = tail;        
        ringAroundTheRosy(k, m, kStart, mStart);
    }//End of minor ringAroundTheRosy method
    
    public void ringAroundTheRosy(int k, int m, Node kStart, Node mStart){        
        Node kPos, mPos;
        kPos = kStart;//Starts at 1
        mPos = mStart;//Starts at N
        //System.out.println(kPos.getName());//DEBUGGING ONLY
        //System.out.println(mPos.getName());//DEBUGGING ONLY
        boolean stop = false;//DEBUGGING ONLY
        
        while(/*head != null*/stop != true){
            int mCount = m;
            int kCount = k;
            
            while(kCount != 0){
                kPos = kPos.getNext();
                kCount--;
            }
            System.out.println(kPos.getName());//DEBUGGING ONLY
            while(mCount != 0){
                mPos = mPos.getPrevious();
                mCount--;
            }
            System.out.println(mPos.getName());//DEBUGGING ONLY
            
            stop = true;
        }                
    }//End of major ringAroundTheRosy method
    
    public int candidateMatch(Node kPos, Node mPos){
        Node kToDelete, mToDelete;
        int honoraryPolitician, tarAndFeatherK, tarAndFeatherM; 
        
        if(kPos == mPos){
            honoraryPolitician = kPos.getName();
            
            kToDelete = kPos;
            kPos = kPos.getNext();
            mPos = mPos.getNext();
            
            remove(kToDelete.getName());
            return honoraryPolitician;
        }
        else if(kPos == mPos.getNext() || kPos == mPos.getPrevious()){//CHECKS IF K IS BEFORE OF AFTER M
            tarAndFeatherK = kPos.getName();
            tarAndFeatherM = mPos.getName();
            
            kToDelete = kPos;
            kPos = kPos.getNext();
            remove(kToDelete.getName());
            
            mToDelete = mPos;
            mPos = mPos.getPrevious();
            remove(mToDelete.getName());
        }
        return 123456789;
    }
    
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
