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
import java.util.Scanner;
public class LinkedListDriver {
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        String [] names = {"Ali", "Bob", "Cal", "Dee", "Eve"};
        int [] ids = {100, 101, 102, 103, 104};
    
        for(int i=0; i<names.length; i++){
            list.add(new Node(new Student(names[i],ids[i])));
        }                 
        /*System.out.println("What would you like to do?\n" +
                    "Press 1 to add an item\n" +
                        "Press 2 to print the list\n" +
                            "Press 3 to search the list\n" +
                                "Press 4 to delete an item\n" +
                                    "Press 5 to clear the whole list\n" +
                                        "Press 6 to print out instructions again\n" +
                                            "Press -1 to exit"); 
        boolean exit = false;
        
        while(exit != true){
                                                                    
            System.out.println("\nYour decision: ");
            Scanner scanner = new Scanner(System.in);
            int int_input = scanner.nextInt(); 
            String str_input;

            switch (int_input){           
                case 1:
                    System.out.println("Please enter a name");
                    str_input = scanner.next();
                    System.out.println("Please enter an id");
                    int_input = scanner.nextInt();
                    list.add(new Node(new Student(str_input, int_input)));
                    System.out.println(str_input+" has been added!\n");
                    break;
                case 2:
                    list.print();
                    break;
                case 3:
                    System.out.println("Not Implemented!\n");
                    break;
                case 4:
                    System.out.println("Please enter a name");
                    str_input = scanner.next();                    
                    if(list.remove(str_input)==false){
                        System.out.println(str_input+" does not exist, could not delete!\n");
                    }
                    else{
                        list.remove(str_input);
                        System.out.println(str_input+" has been deleted!\n");
                    }
                    break;
                case 5:
                    System.out.println("Not Implemented!\n");
                    break;
                case 6:
                    System.out.println("What would you like to do?\n" +
                    "Press 1 to add an item\n" +
                        "Press 2 to print the list\n" +
                            "Press 3 to search the list\n" +
                                "Press 4 to delete an item\n" +
                                    "Press 5 to clear the whole list\n" +
                                        "Press 6 to print out instructions again\n"+
                                            "Press -1 to exit"); 
                    break;
                case -1:
                    System.out.println("Bye!");
                    exit = true;
                    break;

            }//end of switch
        }//end of while loop*/
        list.print();
        list.printBackwards();
        list.remove("Cal");
        list.print();
        list.printBackwards();
        list.remove("Dee");
        list.print();
        list.printBackwards();
        list.add(new Node(new Student("Ken", 143)));
        list.print();
        list.printBackwards();        
        System.out.println(list.search("Ali"));
        System.out.println(list.search("Dude"));
        list.deleteList();
        list.print();
        list.printBackwards();
    }//End of main
}//End of LinkedListDriver Class
