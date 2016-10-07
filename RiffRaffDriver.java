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

import java.io.*;
import java.util.Scanner;

public class RiffRaffDriver {        
    
    public int N, k, m;    
    
    public static void main(String [] args){
        
        RiffRaffList list = new RiffRaffList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Place text files in the NetBeans project folder!");
        System.out.println("Please input file name: ");
        
        //String fileName = scanner.next();       
        
        System.out.println("\nProgram 4\n---------\n");
        String fileName = "text.txt";//DEBUGGING ONLY
        
        int nextInteger;        
        Scanner fileScan;
        
        try{
            fileScan = new Scanner(new File(fileName));
            
            for(int iter=0; iter < 3; iter++){
                nextInteger = fileScan.nextInt();                
                
                switch (iter) {
                    case 0:
                        N = nextInteger;                        
                        System.out.print("N = "+N+", ");
                        break;
                    case 1:
                        k = nextInteger;                        
                        System.out.print("k = "+k+", ");
                        break;
                    case 2:
                        m = nextInteger;
                        System.out.print("m = "+m);
                        break;                                                        
                    default:
                        break;
                }
            }//End of for-loop
            fileScan.close();            
        }        
        catch(FileNotFoundException e){
            System.out.println("Unable to find file \""+fileName+"\"");
        }                                
        
        System.out.println("\n\nOutput\n------");
        
        list.addNumberN(N);        
        list.ringAroundTheRosy(k, m);
        //list.print();
    }//End of Main
}//End of Driver
