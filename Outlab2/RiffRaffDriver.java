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
    
    public static void main(String [] args){
        
        RiffRaffList list = new RiffRaffList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Place text files in the NetBeans project folder!");
        System.out.println("Please input file name: ");
        //String fileName = scanner.next();       
        
        String fileName = "text.txt";
        int nextInteger, N, k, m;
        nextInteger = k = N = m = 0;
        Scanner fileScan;
        
        try{
            fileScan = new Scanner(new File(fileName));
            
            for(int iter=0; iter < 3; iter++){
                nextInteger = fileScan.nextInt();                
                
                switch (iter) {
                    case 0:
                        N = nextInteger;
                        System.out.println(N);//DEBUGGING ONLY
                        break;
                    case 1:
                        k = nextInteger;
                        System.out.println(k);//DEBUGGING ONLY
                        break;
                    case 2:
                        m = nextInteger;
                        System.out.println(m);//DEBUGGING ONLY
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
        list.addNumberN(N);        
        list.ringAroundTheRosy(k, m);
    }//End of Main
}//End of Driver
