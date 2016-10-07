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
                
        int mCount = m;
        int kCount = k;

        kPos = kStart;//Starts at 1
        mPos = mStart;//Starts at N

        while(kCount != 1){
            kPos = kPos.getNext();
            System.out.println("kPos: "+kPos.getName());//DEBUGGING ONLY
            kCount--;
        }
        //System.out.println("kPos: "+kPos.getName());//DEBUGGING ONLY
        while(mCount != 1){
            mPos = mPos.getPrevious();
            System.out.println("mPos: "+mPos.getName());//DEBUGGING ONLY
            mCount--;
        }
        //System.out.println("mPos: "+mPos.getName());//DEBUGGING ONLY

        candidateMatch(kPos, mPos);
                                                
    }//End of major ringAroundTheRosy method
    
    public void candidateMatch(Node kPos, Node mPos){
        Node kToDelete, mToDelete;
        int honoraryPolitician, tarAndFeatherK, tarAndFeatherM; 
        
        if(kPos == mPos){
            honoraryPolitician = kPos.getName();
            
            kToDelete = kPos;
            kPos = kPos.getNext();
            mPos = mPos.getPrevious();
            
            //System.out.println("kPos: "+kPos.getName());//DEBUGGING ONLY
            //System.out.println("mPos: "+mPos.getName());//DEBUGGING ONLY
            
            remove(kToDelete);
            System.out.println(honoraryPolitician);
            
            ringAroundTheRosy(RiffRaffDriver.k, RiffRaffDriver.m, kPos, mPos);
        }
        else if(mPos == kPos.getNext()){//CHECKS IF K IS BEFORE OF AFTER M
            tarAndFeatherK = kPos.getName();
            tarAndFeatherM = mPos.getName();
            
            kToDelete = kPos;
            kPos = kPos.getNext();
            kPos = kPos.getNext();
            remove(kToDelete);
            
            mToDelete = mPos;
            mPos = mPos.getPrevious();
            remove(mToDelete);
            
            //System.out.println("kPos: "+kPos.getName());//DEBUGGING ONLY
            //System.out.println("mPos: "+mPos.getName());//DEBUGGING ONLY
            
            System.out.println(tarAndFeatherK+" "+tarAndFeatherM);
        }
        else{
            tarAndFeatherK = kPos.getName();
            tarAndFeatherM = mPos.getName();
            
            kToDelete = kPos;
            kPos = kPos.getNext();            
            remove(kToDelete);
            
            mToDelete = mPos;
            mPos = mPos.getPrevious();
            remove(mToDelete);
            
            //System.out.println("kPos: "+kPos.getName());//DEBUGGING ONLY
            //System.out.println("mPos: "+mPos.getName());//DEBUGGING ONLY
            
            System.out.println(tarAndFeatherK+" "+tarAndFeatherM);
        }
    }//End of candidateMatch Method
    
    public boolean remove(Node remove){
        Node iter, lag, run;
        iter = lag = run = head;
        
        while(iter != null){
            if(remove.getName() == iter.getName()){
                
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
    
    public void print(){//ONLY FOR DEBUGGING
       Node iter = head;
       while(iter != tail){
           System.out.print("\n"+iter.getName());
           iter = iter.getNext();
       }
       System.out.println();
   }
}
