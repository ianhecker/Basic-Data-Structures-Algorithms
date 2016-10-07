/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlabrecursion;

/**
 *
 * @author Ian
 */
public class InlabRecursion {

    public static void main(String[] args) {
        palindrome("cat");
        palindrome("r");
        palindrome("qwerwq");               
        greatestCommonDivisor(20, 25);
        greatestCommonDivisor(25, 20);
        greatestCommonDivisor(3, 7);
    }
    
    public static boolean palindrome(String string){
        
        if(string.length() <= 1){
            System.out.println("True! Is a palindrome");
            return true;
        }
        if(string.charAt(0) == string.charAt(string.length()-1)){//Need minus one because charAt starts at 0            
            
            return palindrome(string.substring(1, string.length()-1));//cuts off ends of string
        }        
        System.out.println("False, is not a palindrome");
        return false;
    } 
    
    public static void greatestCommonDivisor(int one, int two){
    int divisor;
    
        if(one > two){
            divisor = one;
        }
        else{
            divisor = two;
        }
        greatestCommonDivisor(one, two, divisor);
    }
    
    
    public static boolean greatestCommonDivisor(int one, int two, int divisor){        
        
        if(divisor == 0){            
            System.out.println("No greatest common divisor");
            return false;
        }
        if(one % divisor == 0 && two % divisor == 0){
            System.out.println("Greatest common divisor is "+divisor);
            return true;
        }
        else{
            return greatestCommonDivisor(one, two, divisor-1);
        }                
    }
}
