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
        String textLine = null;

        try{
            FileReader fileReader = new FileReader(fileName);
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((textLine = bufferedReader.readLine()) != null){
                System.out.println(textLine);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Unable to find file \""+fileName+"\"");
        }
        catch(IOException e){
            System.out.println("There was an error reading the file \""+fileName+"\"");
        }

    }
}//End of Driver
