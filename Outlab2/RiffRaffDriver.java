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

        System.out.println("Please input file name: ");
        String fileName = scanner.next();       
        
        int integer, N, k, m;
        Scanner fileScan;
        
        try{
            fileScan = new Scanner(new File(fileName));
            
            for(int iter=0; iter < 3; iter++){
                integer = fileScan.nextInt();
                
                switch (iter) {
                    case 0:
                        N = integer;
                        System.out.println(N);//DEBUGGING ONLY
                        break;
                    case 1:
                        k = integer;
                        System.out.println(k);//DEBUGGING ONLY
                        break;
                    case 2:
                        m = integer;
                        System.out.println(m);//DEBUGGING ONLY
                        break;
                    default:
                        break;
                }//End of switch            
            }//End of for-loop
            fileScan.close();
            
        }        
        catch(FileNotFoundException e){
            System.out.println("Unable to find file \""+fileName+"\"");
        }        
    }
}//End of Driver
